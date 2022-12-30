package in.nareshtechnologies.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    // To give more control to the user about the notification that he/she sees, we have notification channels
    // introduced from Android 8.0 and above that corresponds to API 26.
    // First we need NotificationManger as we want to send notifications and cancel the notifications
    NotificationManager manager;
    //Channel Id - is a String constant that uniquely identifies the notificationChannel
    public static String CHANNEL_ID = "myNotificationChannelID";
    //Channel Name - is a string that gives a name for the notification channel
    public static String CHANNEL_NAME = "MY Notification Channel";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Creating a notification channel
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // This condition checks the operating system version if it is above or equal to Version O (API 26)
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_HIGH);
            // to create the channel, we need to use NotificationManager
            manager.createNotificationChannel(channel);
        }

    }

    // This method is responsible of sending the notification to the user
    public void sendNotification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        // To display an icon on the notification
        builder.setSmallIcon(R.drawable.ic_baseline_airport_shuttle_24);
        // to display a Title
        builder.setContentTitle("Hi First Notification");
        // To display a message on the notification
        builder.setContentText("This is a sample message. This can also be a bit lengthy!");
        //set Autocancel to true
        builder.setAutoCancel(true);
        // to let something happen when the notification is tapped, we need to create a PendingIntent
        // PendingIntent is a description of something that has to happen.
        // PendingIntent can be created using three methods
        // PendingIntent.getBroadcast() -> used to invoke broadcasts
        // PendingIntent.getService() -> used to invoke services
        // PendingIntent.getActivity() -> used to invoke Activities
        PendingIntent pi = PendingIntent.getActivity(this,23,
                new Intent(MainActivity.this,MainActivity.class),
                PendingIntent.FLAG_IMMUTABLE);
        builder.setContentIntent(pi);
        builder.addAction(R.drawable.ic_baseline_airport_shuttle_24,"REPLY",pi);
        builder.addAction(R.drawable.ic_baseline_airport_shuttle_24,"mark as read",pi);

        // set BigPicture Style
        // First convert the image format from jpeg,png,webpng or anyother format to BITMAP
        Bitmap b = BitmapFactory.decodeResource(getResources(),R.drawable.android);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(b));

        //TODO: Assignment -> try to use bigTextStyle to display gmail kind of notifications

        // push a notification to the user
        manager.notify(56,builder.build());
    }

    // This method is responsible of Canceling the notificaitons
    public void cancelNotificaiton(View view) {
        manager.cancel(56);
    }
}