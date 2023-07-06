package habibellah.ayata.elmahir.data.repository

import androidx.lifecycle.LiveData
import habibellah.ayata.elmahir.data.roomDb.entity.Group

interface GroupRepository {
   suspend fun addGroup(group : Group)

   fun getGroupList(): LiveData<List<Group>>
}