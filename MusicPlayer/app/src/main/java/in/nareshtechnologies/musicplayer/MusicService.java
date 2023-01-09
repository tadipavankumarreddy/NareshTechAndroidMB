package in.nareshtechnologies.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {

    MediaPlayer player;

    // Empty Constructor is needed.
    public MusicService() {

    }

    // this is used for bound services but mandatory to implement.
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // to initialize the task and start the service\
    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this,R.raw.audio);
        player.setLooping(false);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
