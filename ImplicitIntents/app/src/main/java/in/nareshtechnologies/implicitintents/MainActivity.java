package in.nareshtechnologies.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openMaps(View view) {
        EditText e = findViewById(R.id.address_et);
        String address = e.getText().toString();

        Intent in = new Intent(Intent.ACTION_VIEW);
        // Data
        Uri data = Uri.parse("geo:0,0?q="+address);
        in.setData(data);

        startActivity(in);

    }

    public void openBrowser(View view) {
        EditText e = findViewById(R.id.url_et);
        String link = e.getText().toString();

        Intent i = new Intent(Intent.ACTION_VIEW);
        //Data
        Uri u = Uri.parse("https://"+link);
        i.setData(u);

        startActivity(i);
    }
}