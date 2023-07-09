package habibellah.ayata.elmahir.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import habibellah.ayata.elmahir.data.repository.StudentRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Student

class FakeStudentRepository : StudentRepository {
   private val students : MutableList<Student> = mutableListOf()
   private val absents : MutableList<Absent> = mutableListOf()

   override suspend fun addStudent(student : Student) {
      students.add(student)
   }

   override suspend fun getStudentBy(groupName : String) : List<Student> {
      return students.filter { it.groupName == groupName }
   }

   override suspend fun addAbsent(absent : Absent) {
      absents.add(absent)
   }

   override fun getAbsentsBy(studentId : Int) : LiveData<List<Absent>> {
      return MutableLiveData(absents.filter { it.studentId == studentId })
   }

   override suspend fun getStudentBy(id : Int) : Student {
      return students.first { it.id == id }
   }

   override suspend fun deleteStudentBy(studentId : Int) {
      students.filter { it.id != studentId }
   }

   override suspend fun updateStudent(student : Student) {
      students.removeIf { it.id == student.id }
      students.add(student)
   }
}