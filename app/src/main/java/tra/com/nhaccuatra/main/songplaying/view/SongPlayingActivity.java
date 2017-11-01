package tra.com.nhaccuatra.main.songplaying.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import tra.com.nhaccuatra.R;
import tra.com.nhaccuatra.main.songplaying.presenter.SongPlayingPresenterImp;

/**
 * Created by Admin on 10/13/2017.
 */

public class SongPlayingActivity extends Activity implements View.OnClickListener, SongPlayingView,
                 SeekBar.OnSeekBarChangeListener{

    private ImageButton playingButton;
    private ImageButton pauseButton;
    private ImageButton repeatButton;
    private SeekBar timeSeekBar;
    private TextView currentTimeOfSong;
    private TextView wholeSongTime;

    private int currentTime;
    private boolean isRepeat = false;

    private SongPlayingPresenterImp songPlayingPresenterImp;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_playing);

        playingButton = (ImageButton) findViewById(R.id.playing_button);
        pauseButton = (ImageButton) findViewById(R.id.pause_button);
        repeatButton = (ImageButton) findViewById(R.id.playing_song_repeat_button);
        timeSeekBar = (SeekBar) findViewById(R.id.playing_song_seekBar);
        currentTimeOfSong = (TextView) findViewById(R.id.current_time_of_song);
        wholeSongTime = (TextView) findViewById(R.id.whole_song_time);
        playingButton.setOnClickListener(this);
        pauseButton.setOnClickListener(this);
        repeatButton.setOnClickListener(this);

        initalView();
        intent = getIntent();
        String uri = intent.getStringExtra("uri");
        songPlayingPresenterImp = new SongPlayingPresenterImp(getApplicationContext(), uri, this);
        currentTime = 0;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        songPlayingPresenterImp.destroyService();
        songPlayingPresenterImp = null;
    }

    public void initalView() {
        playingButton.setVisibility(View.GONE);
        pauseButton.setVisibility(View.VISIBLE);
        timeSeekBar.setOnSeekBarChangeListener(this);
        isRepeat = false;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.playing_button :
                songPlayingPresenterImp.playingButtonClick();
                break;
            case R.id.pause_button :
                songPlayingPresenterImp.pauseButtonClick();
                break;
            case R.id.playing_song_repeat_button :
                isRepeat = !isRepeat;
                songPlayingPresenterImp.repeatButtonClicked(isRepeat);
                break;
        }
    }

    @Override
    public void updateViewState(String action) {
        if (action.equals("playing")) {
            playingButton.setVisibility(View.GONE);
            pauseButton.setVisibility(View.VISIBLE);
        } else if (action.equals("pause")) {
            playingButton.setVisibility(View.VISIBLE);
            pauseButton.setVisibility(View.GONE);
        } else if (action.equals("repeat")) {
            if (isRepeat) {
                repeatButton.setBackgroundColor(Color.RED);
            } else {
                repeatButton.setBackgroundColor(Color.parseColor("#00ffffff"));
            }
        }
    }

    @Override
    public void setFinalTime(String time) {
        wholeSongTime.setText(time);
    }

    @Override
    public void setCurrentTime(String time) {
        currentTimeOfSong.setText(time);
    }

    @Override
    public void setCurrentPositionOfSeekBar(int positionOfSeekBar) {
        timeSeekBar.setProgress(positionOfSeekBar);
    }

    @Override
    public void setMaxValue(int value) {
        timeSeekBar.setMax(value);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        currentTime = i;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        songPlayingPresenterImp.startStopTrackingTouch(currentTime);
        Toast.makeText(this, currentTime + "", Toast.LENGTH_SHORT).show();
    }
}
