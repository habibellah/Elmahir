package habibellah.ayata.elmahir.data.repository

import habibellah.ayata.elmahir.data.roomDb.AbsentDao
import habibellah.ayata.elmahir.data.roomDb.StudentDao
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Student

class StudentRepositoryImpl (
   private val studentDao : StudentDao,
   private val absentDao : AbsentDao
        ): StudentRepository {
   override suspend fun addStudent(student : Student) = studentDao.addStudent(student)

   override suspend fun getStudentBy(groupName : String) = studentDao.getStudentsBy(groupName)

   override suspend fun addAbsent(absent : Absent) = absentDao.addAbsent(absent)

   override fun getAbsentsBy(studentId : Int) = absentDao.getAbsentsBy(studentId)

   override suspend fun getStudentBy(id : Int) = studentDao.getStudentBy(id)
}