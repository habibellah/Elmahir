package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.elmahir.data.repository.TeacherRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeacherViewModel @Inject constructor(private val teacherRepository : TeacherRepository) :
   ViewModel() {

   init {
      getTeachers()
   }

   fun addTeacher(teacher : Teacher) {
      viewModelScope.launch {
         teacherRepository.addTeacher(teacher)
      }
   }

   fun getTeachers() : LiveData<List<Teacher>> = teacherRepository.getTeacherList()
}