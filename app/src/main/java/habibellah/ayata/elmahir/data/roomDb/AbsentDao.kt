package habibellah.ayata.elmahir.data.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import habibellah.ayata.elmahir.data.roomDb.entity.Absent

@Dao
interface AbsentDao {
   @Insert
  suspend fun addAbsent(absent : Absent)

   @Query("SELECT * FROM absent WHERE studentId = :studentId")
   fun getAbsentsBy(studentId : Int) : LiveData<List<Absent>>

   @Query("DELETE FROM absent WHERE studentId = :studentId ")
  suspend fun deleteAbsentBy(studentId : Int)

}