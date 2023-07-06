package habibellah.ayata.elmahir.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import habibellah.ayata.elmahir.data.repository.GroupRepository
import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

class FakeGroupRepository : GroupRepository{
  private val groups : MutableList<Group> = mutableListOf()
   override suspend fun addGroup(group : Group) {
      groups.add(group)
   }

   override fun getGroupList() : LiveData<List<Group>> {
      return MutableLiveData(groups)
   }
}