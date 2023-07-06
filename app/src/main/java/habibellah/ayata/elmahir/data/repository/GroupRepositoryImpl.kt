package habibellah.ayata.elmahir.data.repository

import habibellah.ayata.elmahir.data.roomDb.GroupsDao
import habibellah.ayata.elmahir.data.roomDb.entity.Group

class GroupRepositoryImpl (private val groupsDao : GroupsDao) : GroupRepository {
   override suspend fun addGroup(group : Group) = groupsDao.addGroup(group)

   override fun getGroupList() = groupsDao.getGroups()
}