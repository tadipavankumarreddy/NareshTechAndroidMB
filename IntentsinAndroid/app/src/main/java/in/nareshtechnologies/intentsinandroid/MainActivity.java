package in.nareshtechnologies.intentsinandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText p_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize the p_name
        p_name = findViewById(R.id.person_name);
    }

    // This method will execute as soon as the button on activity_main.xml
    // is clicked.
    // Intents can take the data along with them in extras.
    public void nextScreen(View view) {
        // TODO 3: Extract the data out of EditText box.
        String name = p_name.getText().toString();
        // TODO 1: Create an Intent & Specify the destination to NextActivity.class
        Intent i = new Intent(this,NextActivity.class);
        // TODO 4: Attach the data to the intent object as an extra.
        i.putExtra("KEY1",name);
        // TODO 2: start the Activity
        startActivity(i);
    }
}