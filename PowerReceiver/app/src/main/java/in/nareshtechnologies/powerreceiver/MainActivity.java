package in.nareshtechnologies.powerreceiver;

import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_CUSTOM = "in.nareshtechnologies.powerreceiver.CUSTOM_BROADCAST";
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        // Register the Broadcast
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_POWER_CONNECTED);
        intentFilter.addAction(ACTION_POWER_DISCONNECTED);
        intentFilter.addAction(ACTION_CUSTOM);
        registerReceiver(new PowerReceiverBroadcast(imageView),intentFilter);
    }

    // How do we unregister

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(new PowerReceiverBroadcast(imageView));
    }


    public void sendBroadcast(View view) {
        Intent intent = new Intent(ACTION_CUSTOM);
        sendBroadcast(intent);
    }
}