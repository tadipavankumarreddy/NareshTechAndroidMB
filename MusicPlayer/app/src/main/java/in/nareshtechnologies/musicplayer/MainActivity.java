package in.nareshtechnologies.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startMusic(View view) {
        Intent intent = new Intent(this,MusicService.class);
        startService(intent);
    }

    public void stopMusic(View view) {
        stopService(new Intent(this,MusicService.class));
    }
}