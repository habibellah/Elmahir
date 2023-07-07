package habibellah.ayata.elmahir.data.roomDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import habibellah.ayata.elmahir.data.roomDb.entity.Student

@Dao
interface StudentDao {

   @Insert
  suspend fun addStudent(student : Student)

   @Query("SELECT * FROM student WHERE groupName = :groupName")
  suspend fun getStudentsBy(groupName : String) : List<Student>

   @Query("SELECT * FROM student WHERE id = :id")
  suspend fun getStudentBy(id : Int) : Student
}