package tra.com.nhaccuatra.main.songplaying.presenter;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;

import java.util.concurrent.TimeUnit;

import tra.com.nhaccuatra.main.songplaying.view.SongPlayingView;
import tra.com.nhaccuatra.service.SongService;
import tra.com.nhaccuatra.service.SongService.PlayingSongBinder;
import tra.com.nhaccuatra.service.TimeChange;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingPresenterImp implements TimeChange{


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
            songService.unRegisterTimeChange(this);
            songService.release();
            context.unbindService(connection);
            mBound = false;

        }
    }

    public void startStopTrackingTouch(int time) {
        songService.seekTo(time);
    }

    public void playingButtonClick() {
        songService.start();
        songPlayingView.updateViewState("playing");
    }


    public void pauseButtonClick() {
        songService.pause();
        songPlayingView.updateViewState("pause");
    }

    public void repeatButtonClicked(boolean isRepeat) {
        songPlayingView.updateViewState("repeat");
        songService.repeat(isRepeat);
    }

    public String convertTimeToString(int mTime) {
       return String.format("%d min, %d sec",
                TimeUnit.MILLISECONDS.toMinutes((long) mTime),
                TimeUnit.MILLISECONDS.toSeconds((long) mTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                mTime)));
    }

    private ServiceConnection connection =  new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            PlayingSongBinder binder = (PlayingSongBinder) iBinder;
            songService = binder.getService();
            mBound = true;
            songService.registerTimeChange(SongPlayingPresenterImp.this);
            int finalTime = songService.getFinalTime();
            songPlayingView.setMaxValue(finalTime);
            songPlayingView.setFinalTime(convertTimeToString(finalTime));
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mBound = false;
        }
    };

    @Override
    public void dataChange(int time) {
        songPlayingView.setCurrentTime(convertTimeToString(time));
        songPlayingView.setCurrentPositionOfSeekBar(time);
    }

    @Override
    public void OnCompletion() {
        songPlayingView.updateViewState("pause");
    }
}
