package in.nareshtechnologies.roomdatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentsDAO {

    // Insert the value
    @Insert
    void insertData(Students students);


    // Read all the values
    @Query("Select * from students")
    List<Students> getAllData();
    
}
