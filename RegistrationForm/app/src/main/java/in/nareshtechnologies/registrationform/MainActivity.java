package in.nareshtechnologies.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    RadioGroup group;
    String gender = "Prefer Not to Say";
    CheckBox tel,hin,eng;
    Spinner sp;
    String country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO 1: Connect the Objects to the correct Views
        name = findViewById(R.id.person_name);
        group = findViewById(R.id.rg);
        tel = findViewById(R.id.telugu); hin = findViewById(R.id.hindi); eng = findViewById(R.id.english);
        sp = findViewById(R.id.countries);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int id = radioGroup.getCheckedRadioButtonId();
                if(id == R.id.rb1)
                    gender = "Male";
                else if(id == R.id.rb2)
                    gender = "Female";
                else
                    gender = "Prefer Not to Say";
            }
        });

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                country = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void captureDetails(View view) {
        // TODO 2: Get the name of the person
        String n = name.getText().toString();

        // TODO 4: get the languages known
        String lk = "";
        if(tel.isChecked())
            lk += "telugu"+"\n";
        if(hin.isChecked())
            lk += "hindi"+"\n";
        if(eng.isChecked())
            lk += "english"+"\n";

        // TODO 3: Display a Toast Message
        Toast.makeText(this, country, Toast.LENGTH_SHORT).show();
    }
}