package in.nareshtechnologies.sqlitedatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "NareshTech";
    public static final String TABLE_NAME = "students";
    public static final String COL_0 = "students_id";
    public static final String COL_1 = "students_name";
    public static final String COL_2 = "students_age";
    public static final int DATABASE_VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Used to create tables
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME+"("+COL_0+" integer primary key autoincrement, "+COL_1+" text, "+COL_2+" integer);";
        sqLiteDatabase.execSQL(query);
    }

    // used to upgrade (delete and re-create) tables when there is a version change.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String dropQuery = "DROP TABLE "+TABLE_NAME;
        sqLiteDatabase.execSQL(dropQuery);
        onCreate(sqLiteDatabase);
    }

    // For inserting data
    public void insertData(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
    }

    // Reading data from database - Whenever you read the data out of the data base, you get the data in the form of a Cursor
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM "+TABLE_NAME,null,null);
    }


}
