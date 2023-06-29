package habibellah.ayata.elmahir.data.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

@Dao
interface TeacherDao {


   @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun addTeacher(teacher : Teacher)

   @Query("SELECT * from teachers")
    fun getTeacherList() : LiveData<List<Teacher>>
}