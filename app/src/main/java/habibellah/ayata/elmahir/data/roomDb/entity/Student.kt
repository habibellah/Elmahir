package habibellah.ayata.elmahir.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student")
data class Student(
   @PrimaryKey(autoGenerate = true)
   val id : Int ,
   val studentName : String ,
   val educationYear : String ,
   val healthStatus : String ,
   val age : Int,
   val studentNote : String,
   val teacherName : String,
   val currentSora : String,
   val groupName : String
)