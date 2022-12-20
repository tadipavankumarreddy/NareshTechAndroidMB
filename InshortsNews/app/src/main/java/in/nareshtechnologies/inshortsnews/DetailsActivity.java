package in.nareshtechnologies.inshortsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    ImageView newsDetailsImage;
    TextView newsDetailsTitle;
    TextView newsDetailsContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        newsDetailsImage = findViewById(R.id.details_image);
        newsDetailsTitle = findViewById(R.id.details_title);
        newsDetailsContent = findViewById(R.id.details_content);

        Intent i = getIntent();
        Datum d = (Datum) i.getSerializableExtra("DATA");
        Glide.with(this).load(d.getImageUrl()).into(newsDetailsImage);
        newsDetailsTitle.setText(d.getTitle());
        newsDetailsContent.setText(d.getContent());
    }
}