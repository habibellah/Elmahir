package habibellah.ayata.elmahir.data.roomDb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

@Dao
interface TeacherDao {


   @Insert
   suspend fun addTeacher(teacher : Teacher)

   @Query("SELECT * from teachers")
   suspend fun getTeacherList() : List<Teacher>
}