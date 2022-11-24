package in.nareshtechnologies.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Create two objects for Button class
    Button plusBtn, minusBtn;

    //Create another object for TextView class
    TextView result;

    int count = 0;
    // We trigger the activity execution from onCreate(...)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusBtn = findViewById(R.id.plus_btn);
        minusBtn = findViewById(R.id.minus_btn);
        result = findViewById(R.id.result);

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // from here I can handle the clicks on the button
                count++;
                result.setText(String.valueOf(count));
            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // from here I can handle the clicks on the button
                count--;
                result.setText(String.valueOf(count));
            }
        });
    }
}