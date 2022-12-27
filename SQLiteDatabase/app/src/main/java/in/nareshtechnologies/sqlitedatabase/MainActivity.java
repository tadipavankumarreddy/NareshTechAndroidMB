package in.nareshtechnologies.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText n,a; TextView r;
    DBHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n = findViewById(R.id.person_name); a = findViewById(R.id.person_age); r = findViewById(R.id.textView);
        helper = new DBHelper(this);
    }


    public void saveData(View view) {
        String name = n.getText().toString(); int age = Integer.parseInt(a.getText().toString());
        ContentValues values = new ContentValues();
        // Content values are used to map the coloumn names with the values
        values.put(DBHelper.COL_1, name);
        values.put(DBHelper.COL_2,age);

        helper.insertData(values);

        Toast.makeText(this, "Data is inserted successfully!", Toast.LENGTH_SHORT).show();
    }

    public void loadData(View view) {

        r.setText("");
        Cursor c = helper.getData();
        c.moveToFirst();
        do{
            r.append(c.getInt(0)+"\n");
            r.append(c.getString(1)+"\n");
            r.append(c.getInt(2)+"\n\n");
        }while(c.moveToNext());

    }
}