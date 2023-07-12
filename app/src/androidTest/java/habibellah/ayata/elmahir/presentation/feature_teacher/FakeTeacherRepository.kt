package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

class FakeTeacherRepository : TeacherRepository{
  private val teachers : MutableList<Teacher> = mutableListOf()
   override suspend fun addTeacher(teacher : Teacher) {
     teachers.add(teacher)
   }

   override fun getTeacherList() : LiveData<List<Teacher>> {
      return MutableLiveData(teachers)
   }
}