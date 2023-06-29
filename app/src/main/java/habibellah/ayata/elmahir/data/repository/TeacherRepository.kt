package habibellah.ayata.elmahir.data.repository

import androidx.lifecycle.LiveData
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

interface TeacherRepository {

   suspend fun addTeacher(teacher : Teacher)

    fun getTeacherList(): LiveData<List<Teacher>>
}