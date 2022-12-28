package in.nareshtechnologies.powerreceiver;

import static android.content.Intent.ACTION_POWER_CONNECTED;
import static android.content.Intent.ACTION_POWER_DISCONNECTED;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

public class PowerReceiverBroadcast extends BroadcastReceiver {

    ImageView imageView;

    public PowerReceiverBroadcast(ImageView imageView) {
        this.imageView = imageView;
    }

    // This onReceive method will be triggered when there is a broadcast of our interest occurs in the system
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        if(intent.getAction().equals(ACTION_POWER_CONNECTED)){
            imageView.setImageResource(R.drawable.ic_baseline_battery_charging_full_24);
        }else if(intent.getAction().equals(ACTION_POWER_DISCONNECTED)){
            imageView.setImageResource(R.drawable.ic_baseline_battery_alert_24);
        }else if(intent.getAction().equals(MainActivity.ACTION_CUSTOM)){
            Toast.makeText(context, "Received custom broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}