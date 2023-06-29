package habibellah.ayata.elmahir.presentation.feature_teacher

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
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
   private val _teachers : MutableLiveData<List<Teacher>> = MutableLiveData<List<Teacher>>()
   val teachers : LiveData<List<Teacher>> = _teachers

   init {
      getTeachers()
   }

   fun addTeacher(teacher : Teacher) {
      viewModelScope.launch {
         teacherRepository.addTeacher(teacher)
      }
   }

   fun getTeachers() {
      viewModelScope.launch {
         _teachers.postValue(teacherRepository.getTeacherList())
      }
   }
}