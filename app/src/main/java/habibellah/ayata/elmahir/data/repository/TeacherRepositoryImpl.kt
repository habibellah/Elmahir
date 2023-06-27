package habibellah.ayata.elmahir.data.repository

import habibellah.ayata.elmahir.data.roomDb.TeacherDao
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

class TeacherRepositoryImpl(private val teacherDao : TeacherDao) : TeacherRepository {

   override suspend fun addTeacher(teacher : Teacher) = teacherDao.addTeacher(teacher)

   override suspend fun getTeacherList() = teacherDao.getTeacherList()
}