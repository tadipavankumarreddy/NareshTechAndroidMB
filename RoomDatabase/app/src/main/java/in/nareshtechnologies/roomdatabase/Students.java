package in.nareshtechnologies.roomdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// @Entity will consider the class name as the table name
@Entity(tableName = "students")
public class Students {
    @PrimaryKey(autoGenerate = true)
    int students_id;

    @ColumnInfo(name = "students_names")
    String students_name;

    int students_age;

    public Students(String students_name, int students_age) {
        this.students_name = students_name;
        this.students_age = students_age;
    }

    public int getStudents_id() {
        return students_id;
    }

    public String getStudents_name() {
        return students_name;
    }

    public int getStudents_age() {
        return students_age;
    }
}
