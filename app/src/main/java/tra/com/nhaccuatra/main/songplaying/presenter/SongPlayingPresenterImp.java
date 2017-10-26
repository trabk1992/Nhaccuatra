package tra.com.nhaccuatra.main.songplaying.presenter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;

import tra.com.nhaccuatra.main.songplaying.view.SongPlayingView;
import tra.com.nhaccuatra.service.SongService;
import tra.com.nhaccuatra.service.SongService.PlayingSongBinder;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingPresenterImp {


    private SongPlayingView songPlayingView;
    private SongService songService ;
    private boolean mBound = false;
    private Context context;

    public SongPlayingPresenterImp(Context context,String uri, SongPlayingView songPlayingView) {
        this.songPlayingView = songPlayingView;
        this.context = context;

        Intent intent = new Intent(context, SongService.class);
        intent.putExtra("uri", uri);
        context.bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    public void destroyService() {
        if (mBound) {
            context.unbindService(connection);
            mBound = false;
        }
    }

    public void playingButtonClick() {
        songService.start();
        songPlayingView.updateViewState("playing");
    }


    public void pauseButtonClick() {
        songService.pause();
        songPlayingView.updateViewState("pause");
    }

    private ServiceConnection connection =  new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            PlayingSongBinder binder = (PlayingSongBinder) iBinder;
            songService = binder.getService();
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
        }
    };
}
