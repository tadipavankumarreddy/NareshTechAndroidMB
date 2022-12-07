package in.nareshtechnologies.favoritemovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    ImageView iv; TextView mn,an;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        iv = findViewById(R.id.details_poster);
        mn = findViewById(R.id.details_mn);
        an = findViewById(R.id.details_an);

        // you need to populate data based on the user selection
        Intent i = getIntent();
        int id = i.getIntExtra("IMAGE",0);
        String n = i.getStringExtra("MOVIE");
        String a = i.getStringExtra("ACTOR");

        iv.setImageResource(id);
        mn.setText(n);
        an.setText(a);
    }
}