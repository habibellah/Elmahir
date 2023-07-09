package habibellah.ayata.elmahir.presentation.feature_student.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.elmahir.data.repository.StudentRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentDetailsViewModel @Inject constructor(
   private val studentRepository : StudentRepository
): ViewModel() {

   private val _student : MutableLiveData<Student> = MutableLiveData()
   val student : LiveData<Student> = _student

   fun addAbsent(absent : Absent) {
      viewModelScope.launch {
         studentRepository.addAbsent(absent)
      }
   }

   fun getAbsentsBy(studentId : Int) = studentRepository.getAbsentsBy(studentId)

   fun getStudentBy(id : Int) {
      viewModelScope.launch {
         _student.postValue(studentRepository.getStudentBy(id))
      }
   }

   fun updateStudent(student : Student) {
      viewModelScope.launch {
         studentRepository.updateStudent(student)
      }
   }
}