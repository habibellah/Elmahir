package habibellah.ayata.elmahir.data

import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

class FakeTeacherRepository : TeacherRepository{
  private val teachers : MutableList<Teacher> = mutableListOf()
   override suspend fun addTeacher(teacher : Teacher) {
     teachers.add(teacher)
   }

   override suspend fun getTeacherList() : List<Teacher> {
     return teachers
   }
}