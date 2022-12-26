### SQL
***SQL - Structure Query Language***
- SQL is a relational Database where the data is organized in Rows and Coloumns (Table)
- Operations
  - Storing
  - Retrieving
  - Modifying

[Click Here](https://sqliteonline.com/) to practice the commands below.

###### Table Sample used 
***Table name: students_data***
student_id|student_name|student_age
----------|-----------|-----------
1|Pavan Kumar|28
2|Md Naveed|22
3|Chester|21
4|Darshana|20
  
SQLite - Is a Database which is light weight database
- It is embedded in Android by default.

###### Main Classes that we have on android to make use of SLQLite are
- SQLiteDatabase
    - It is used to perform all SQLite operations (database Operations)
- SQLiteOpenHelper
    - It is used for database creation and version Management

###### CRUD - Create, Read, Update, Delete
###### Create a table
```SQL
CREATE table students_data(student_id INTEGER PRIMARY KEY AUTOINCREMENT, student_name TEXT, student_age INTEGER);
```

###### Insert Data into the Table
```SQL
INSERT INTO students_data(student_name, student_age) VALUES("Pavan Kumar", "30");
```

###### Read the table with Select Command
- To read all the values of the table
```SQL
SELECT * FROM students_data;
```
- To read only the specific rows in the table
```SQL
SELECT student_id, student_name from students_data;
```
- To Read database values on a ```where``` condition
```SQL
select student_id,student_name from students_data where student_age>=26;
```

```SQL
SELECT * from students_data ORDER BY student_name ASC;
```

###### Update Command
```SQL
UPDATE students_data set student_name = "TPK Reddy" where student_id = 1;
```

###### Delete Command
```SQL
UPDATE students_data set student_name = "TPK Reddy" where student_id = 1;
```


