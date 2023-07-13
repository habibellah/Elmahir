package habibellah.ayata.elmahir.data.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import habibellah.ayata.elmahir.data.roomDb.entity.Student

@Dao
interface StudentDao {

   @Insert
  suspend fun addStudent(student : Student)

   @Query("SELECT * FROM student WHERE groupName = :groupName")
   fun getStudentsBy(groupName : String) : LiveData<List<Student>>

   @Query("SELECT * FROM student WHERE id = :id")
  suspend fun getStudentBy(id : Int) : Student

  @Query("DELETE FROM student WHERE id = :studentId ")
 suspend fun deleteStudentBy(studentId : Int)

 @Update
 suspend  fun updateStudent(student : Student)
}