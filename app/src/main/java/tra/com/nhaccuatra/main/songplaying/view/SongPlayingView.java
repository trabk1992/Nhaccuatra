package tra.com.nhaccuatra.main.songplaying.view;

/**
 * Created by Admin on 10/26/2017.
 */

public interface SongPlayingView {

    void updateViewState(String action);
    void setFinalTime(String time);
    void setCurrentTime(String time);
    void setCurrentPositionOfSeekBar(int positionOfSeekBar);
    void setMaxValue(int value);
}
