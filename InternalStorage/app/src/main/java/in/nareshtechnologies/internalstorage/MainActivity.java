package in.nareshtechnologies.internalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    EditText n,a; TextView r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = findViewById(R.id.person_name); a = findViewById(R.id.person_age); r = findViewById(R.id.textView);

    }

    public void loadData(View view) {

        FileInputStream fis;
        try {
            fis = openFileInput("pavan.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = "";
            StringBuilder sb = new StringBuilder();
            while((line = br.readLine())!=null){
                sb.append(line+"\n");
            }

            r.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void saveData(View view) {
        String name = n.getText().toString() + "\n"; int age = Integer.parseInt(a.getText().toString());

        // FileInputStream (This is to read data from the file)
        // FileOutputStream (This is to write data to the file)

        FileOutputStream fos;

        try {

            fos = openFileOutput("pavan.txt",MODE_PRIVATE);
            fos.write(name.getBytes());
            fos.write((""+age).getBytes());
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Data is saved!", Toast.LENGTH_SHORT).show();
    }
}