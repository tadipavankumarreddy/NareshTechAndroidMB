package in.nareshtechnologies.externalstorage;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText n,a; TextView r;

    // We need to check if the external storage is available or not
    boolean isAvailable = false, isWritable = false, isReadable = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = findViewById(R.id.person_name); a = findViewById(R.id.person_age); r = findViewById(R.id.textView);

        // to check if the external storage is readable, writable and is available
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
            isAvailable = isReadable = isWritable = true;
        }else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            isAvailable = isReadable = true;
        }

        // Grant the dynamic permissions request
        if(checkSelfPermission(WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this, "Permission Granted!", Toast.LENGTH_SHORT).show();
        }else{
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE,READ_EXTERNAL_STORAGE},123);
        }



    }

    public void saveData(View view) {
        String name = n.getText().toString();
        int age = Integer.parseInt(a.getText().toString());

        // First create the file in the external storage in your preferred folder
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,"MyDataExternal.txt");

        FileOutputStream fos;
        try {
            fos = new FileOutputStream(file);
            fos.write((name+"\n").getBytes());
            fos.write((age+"\n").getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {

        // First create the file in the external storage in your preferred folder
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder,"MyDataExternal.txt");

        FileInputStream fis;

        try {
            fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = ""; StringBuilder sb = new StringBuilder();
            while ((line = br.readLine())!=null){
                sb.append(line+"\n");
            }
            r.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}