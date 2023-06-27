package habibellah.ayata.elmahir.data.repository

import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

interface TeacherRepository {

   suspend fun addTeacher(teacher : Teacher)

   suspend fun getTeacherList():List<Teacher>
}