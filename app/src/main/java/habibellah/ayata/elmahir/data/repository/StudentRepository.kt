package habibellah.ayata.elmahir.data.repository

import androidx.lifecycle.LiveData
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Student

interface StudentRepository {

   suspend fun addStudent(student : Student)

    fun getStudentBy(groupName : String) : LiveData<List<Student>>

   suspend fun addAbsent(absent : Absent)

   fun getAbsentsBy(studentId : Int) : LiveData<List<Absent>>

   suspend fun getStudentBy(id : Int) : Student

   suspend fun deleteStudentBy(studentId : Int)

   suspend fun updateStudent(student : Student)

   suspend fun deleteAbsentsBy(studentId : Int)
}