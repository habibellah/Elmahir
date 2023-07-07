package habibellah.ayata.elmahir.data.roomDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import habibellah.ayata.elmahir.data.roomDb.entity.Student

@Dao
interface StudentDao {

   @Insert
   fun addStudent(student : Student)

   @Query("SELECT * FROM student")
   fun getStudents() : List<Student>

   @Query("SELECT * FROM student WHERE id = :id")
   fun getStudentBy(id : Int) : Student
}