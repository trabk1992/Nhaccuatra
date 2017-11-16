package tra.com.nhaccuatra.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import tra.com.nhaccuatra.R;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Admin on 11/15/2017.
 */

public class SongNotification {

    private RemoteViews views;
    private NotificationManager notificationManager;
    private Notification notification;
    private NotificationCompat.Builder builder;

    public SongNotification(Context context) {
        views = new RemoteViews(context.getPackageName(),
                R.layout.layout_notification);

        Intent playingIntent = new Intent();
        playingIntent.setAction("play");
        PendingIntent playingPendingIntent = PendingIntent.getBroadcast(context, 0, playingIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent pauseIntent = new Intent();
        pauseIntent.setAction("pause");
        PendingIntent pausePendingIntent = PendingIntent.getBroadcast(context, 0, pauseIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.notification_play_btn, playingPendingIntent);
        views.setOnClickPendingIntent(R.id.notification_pause_btn, pausePendingIntent);

        views.setViewVisibility(R.id.notification_play_btn, View.GONE);
        views.setViewVisibility(R.id.notification_pause_btn, View.VISIBLE);
        views.setTextViewText(R.id.notification_song_name, "nhac cua tung");
        views.setTextViewText(R.id.notification_singer_name, "SonTung MTP");
        views.setImageViewResource(R.id.notification_song_icon, R.drawable.play);

        builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.pikachu)
                .setCustomBigContentView(views);
        builder.setAutoCancel(true);
        notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

    }

    public void setVisiblePlayButton(boolean visible) {
        Log.d("tra.nta","setVisiblePlayButton "+visible);
        if(visible) {
            views.setViewVisibility(R.id.notification_play_btn, View.VISIBLE);
            views.setViewVisibility(R.id.notification_pause_btn, View.GONE);
            builder.setOngoing(false);
        } else {
            views.setViewVisibility(R.id.notification_play_btn, View.GONE);
            views.setViewVisibility(R.id.notification_pause_btn, View.VISIBLE);
            builder.setOngoing(true);
        }
        notification = builder.build();
        notificationManager.notify(0,notification);
    }
}
