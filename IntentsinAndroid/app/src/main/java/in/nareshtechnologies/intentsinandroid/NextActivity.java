package in.nareshtechnologies.intentsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        textView = findViewById(R.id.textview);

        // TODO 5: Catch the intent object that is responisble of raising this activity
        Intent i = getIntent();
        // TODO 6: extract the data
        String s = i.getStringExtra("KEY1");
        // TODO 7: show the data on TextView
        textView.append(s);

    }
}