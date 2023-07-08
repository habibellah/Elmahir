package habibellah.ayata.elmahir.presentation.feature_student.students

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.elmahir.data.repository.StudentRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StudentViewModel @Inject constructor(
   private val studentRepository : StudentRepository
): ViewModel() {

   private val _students:MutableLiveData<List<Student>> = MutableLiveData()
   val students : LiveData<List<Student>> = _students

   private val _student:MutableLiveData<Student> = MutableLiveData()
   val student : LiveData<Student> = _student

   fun getStudents(groupName : String) {
    viewModelScope.launch {
       _students.postValue(studentRepository.getStudentBy(groupName))
    }
   }

   fun addStudent(student : Student) {
      viewModelScope.launch {
         studentRepository.addStudent(student)
      }
   }
}