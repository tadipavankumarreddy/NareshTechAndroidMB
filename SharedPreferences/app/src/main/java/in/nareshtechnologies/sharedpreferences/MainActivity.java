package in.nareshtechnologies.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;

    EditText n,a; TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        n = findViewById(R.id.person_name); a = findViewById(R.id.person_age); r = findViewById(R.id.textView);
        
        preferences = getSharedPreferences("person_details",MODE_PRIVATE);
    }

    public void saveData(View view) {
        String name = n.getText().toString(); int age = Integer.parseInt(a.getText().toString());
        
        // Editing the values of a shared preferences file
        SharedPreferences.Editor e = preferences.edit();
        e.putString("NAME", name); 
        e.putInt("AGE",age);
        e.apply(); // WHithout calling apply() or commit() the changes will not take place.

        Toast.makeText(this, "Data is saved!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {
        if(preferences.contains("NAME") && preferences.contains("AGE")){
            String name = preferences.getString("NAME","Default");
            int age = preferences.getInt("AGE",5);

            r.setText(name+"\n"+age);
        }
    }
}