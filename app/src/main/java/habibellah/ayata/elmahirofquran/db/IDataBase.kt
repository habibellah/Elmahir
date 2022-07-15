package habibellah.ayata.elmahirofquran.db

import habibellah.ayata.elmahirofquran.Student
import habibellah.ayata.elmahirofquran.Teacher

interface IDataBase {
    fun getTeachersList():ArrayList<Teacher>
    fun insertANewTeacher(name:String)
    fun openDB()
    fun closeDB()
    fun getStudentsList():ArrayList<Student>
    fun insertANewStudent(name:String,age:String,teacher:String,currentSora:String,medicalInfo:String,
    dateOfStart:String,yearOfEducation:String)

}