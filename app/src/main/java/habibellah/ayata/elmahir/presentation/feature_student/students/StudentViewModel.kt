package habibellah.ayata.elmahir.presentation.feature_student.students

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

   fun getStudents(groupName : String) = studentRepository.getStudentBy(groupName)

   fun addStudent(student : Student) {
      viewModelScope.launch {
         studentRepository.addStudent(student)
      }
   }

   fun deleteStudentBy(studentId : Int) {
      viewModelScope.launch {
         studentRepository.deleteStudentBy(studentId)
      }
   }

   fun deleteAbsentsBy(studentId : Int){
      viewModelScope.launch {
         studentRepository.deleteAbsentsBy(studentId)
      }
   }
}