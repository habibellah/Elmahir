package habibellah.ayata.elmahirofquran.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import habibellah.ayata.elmahirofquran.Student
import habibellah.ayata.elmahirofquran.Teacher

class DbAccess(context: Context) : IDataBase {
    private lateinit var access: SQLiteDatabase
    private var db: SQLiteOpenHelper

    init {
        this.db = DB(context)
    }

    private fun open() {
        this.access = this.db.writableDatabase
    }

    private fun close() {
        if (this.access != null) {
            this.access.close()
        }
    }

    @SuppressLint("Range")
    private fun getTeachers(): ArrayList<Teacher> {
        val list: ArrayList<Teacher> = ArrayList()
        val cursor = access.rawQuery("SELECT * FROM " + Constants.TEACHER_TABLE_NAME, null)
        if (cursor.moveToNext()) do {
            val name = cursor.getString(cursor.getColumnIndex(Constants.TEACHER_NAME_RAW))
            val teacher = Teacher(name)
            list.add(teacher)
        } while (cursor.moveToNext())
        cursor.close()
        return list
    }

    private fun insertNewTeacher(name: String) {
        val values = ContentValues()
        values.put(Constants.TEACHER_NAME_RAW, name)
        access.insert(Constants.TEACHER_TABLE_NAME, null, values)
    }

    override fun getTeachersList(): ArrayList<Teacher> {
        return getTeachers()
    }

    override fun insertANewTeacher(name: String) {
        insertNewTeacher(name)
    }

    override fun openDB() {
        open()
    }

    override fun closeDB() {
        close()
    }

    override fun getStudentsList(): ArrayList<Student> {
        TODO("Not yet implemented")
    }

    override fun insertANewStudent(
        name: String,
        age: String,
        teacher: String,
        currentSora: String,
        medicalInfo: String,
        dateOfStart: String,
        yearOfEducation: String,
    ) {
        insertNewStudent(name,age,teacher,currentSora,medicalInfo,dateOfStart,yearOfEducation)
    }

    private fun insertNewStudent(
        name: String,
        age: String,
        teacher: String,
        currentSora: String,
        medicalInfo: String,
        dateOfStart: String,
        yearOfEducation: String,
    ) {

      val values = ContentValues()
        values.put(Constants.STUDENT_NAME_RAW,name)
        values.put(Constants.STUDENT_AGE_RAW,age)
        values.put(Constants.STUDENT_TEACHER_NAME_RAW,teacher)
        values.put(Constants.STUDENT_SORA_RAW,currentSora)
        values.put(Constants.STUDENT_MEDICAL_INFO_RAW,medicalInfo)
        values.put(Constants.STUDENT_DATE_OF_START_RAW,dateOfStart)
        values.put(Constants.STUDENT_STUDYING_YEAR_RAW,yearOfEducation)
        access.insert(Constants.STUDENT_TABLE_NAME,null,values)
    }
}