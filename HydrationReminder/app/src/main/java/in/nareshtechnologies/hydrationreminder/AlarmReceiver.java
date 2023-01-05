package in.nareshtechnologies.hydrationreminder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    // This method is invoked as soon as an alarm is raised.
    // We need to inform the user to have some water in the form of a notification
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("notify","Hydration Reminder", NotificationManager.IMPORTANCE_HIGH);
            manager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"notify");
        builder.setSmallIcon(R.drawable.ic_baseline_local_drink_24);
        builder.setContentTitle("Drink a glass of water");
        builder.setContentText("It is good to be hydrated. So we recommend you to have a drink!");
        builder.setAutoCancel(true);
        builder.setPriority(NotificationCompat.PRIORITY_HIGH);

        manager.notify(23, builder.build());
    }
}