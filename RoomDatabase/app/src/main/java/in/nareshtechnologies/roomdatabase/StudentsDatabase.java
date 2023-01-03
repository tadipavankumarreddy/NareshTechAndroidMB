package in.nareshtechnologies.roomdatabase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Students.class},version = 1)
public abstract class StudentsDatabase extends RoomDatabase {
    public abstract StudentsDAO studentsDAO();
}

