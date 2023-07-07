package habibellah.ayata.elmahir.data.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

@Database(entities = [Student::class, Teacher::class,Group::class, Absent::class], version = 1)
abstract class ElmahirDataBase : RoomDatabase() {
   abstract fun studentDao() : StudentDao
   abstract fun teacherDao() : TeacherDao
   abstract fun groupsDao() : GroupsDao

   abstract fun absentDao() : AbsentDao
}