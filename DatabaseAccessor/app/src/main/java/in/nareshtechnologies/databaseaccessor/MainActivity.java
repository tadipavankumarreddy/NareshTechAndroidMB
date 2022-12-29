package in.nareshtechnologies.databaseaccessor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String AUTHORITIES = "in.nareshtechnologies.sqlitedatabase.CONTENT_PROVIDER";
    public static final String COL_1 = "students_name";
    public static final String COL_2 = "students_age";
    TextView r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r = findViewById(R.id.text_view);
        // Create a URI and add "content://" as the prefix
        Uri CONTENT_URI = Uri.parse("content://"+AUTHORITIES);

        ContentValues values = new ContentValues();
        values.put(COL_1,"Krupakar");
        values.put(COL_2,34);

        getContentResolver().insert(CONTENT_URI,values);

        r.setText("");
        Cursor c = getContentResolver().query(CONTENT_URI,null,null,null,null);
        c.moveToFirst();
        do{
            r.append(c.getInt(0)+"\n");
            r.append(c.getString(1)+"\n");
            r.append(c.getInt(2)+"\n\n");
        }while(c.moveToNext());



    }
}