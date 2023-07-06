package habibellah.ayata.elmahir.data.roomDb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import habibellah.ayata.elmahir.data.roomDb.entity.Group

@Dao
interface GroupsDao {

   @Insert
   fun addGroup(group : Group)

   @Query("SELECT * FROM `group`")
   fun getGroups() : LiveData<List<Group>>
}