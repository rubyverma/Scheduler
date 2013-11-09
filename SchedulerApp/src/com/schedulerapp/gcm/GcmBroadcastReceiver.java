package com.schedulerapp.gcm;

import com.schedulerapp.activities.MainActivity;
import com.schedulerapp.activities.R;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.widget.Toast;

public class GcmBroadcastReceiver extends WakefulBroadcastReceiver {

	Context context;

	@Override
	public void onReceive(Context context, Intent intent) {

		this.context = context;

		Bundle extras = intent.getExtras();
		String msgTitle = extras.getString("title");
		String message = extras.getString("message");
		Toast.makeText(context, "Scheduler: " + message,
				Toast.LENGTH_LONG).show();

		Vibrator v = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		// Vibrate for 500 milliseconds
		v.vibrate(500);

		showNotification(context, msgTitle, message);
		showAlertDialog(context, message);
	}

	private void showNotification(Context context, String title, String message) {

		PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
				new Intent(context, MainActivity.class), 0);

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(
				context).setSmallIcon(R.drawable.notification_icon)
				.setContentTitle(title)
				.setContentText(message);
		mBuilder.setContentIntent(contentIntent);
		mBuilder.setDefaults(Notification.DEFAULT_SOUND);
		mBuilder.setAutoCancel(true);
		NotificationManager mNotificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		mNotificationManager.notify(1, mBuilder.build());

	}

	private void showAlertDialog(Context context, String message) {
		
		Intent intent = new Intent(context, MainActivity.class);
		startWakefulService(context, intent);

	}
}
