package in.nareshtechnologies.fruityvice;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar pb;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = findViewById(R.id.progressBar);
        tv = findViewById(R.id.textView);
        // Stop the visibility of the progress bar
        pb.setVisibility(View.INVISIBLE);
    }

    public void fetchFruits(View view) {
        pb.setVisibility(View.VISIBLE);
        if(isNetworkConnected())
            new FetchFruits(this,tv,pb).execute("https://www.fruityvice.com/api/fruit/all");
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
}