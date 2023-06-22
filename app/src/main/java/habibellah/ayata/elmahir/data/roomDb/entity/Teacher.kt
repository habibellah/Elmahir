package habibellah.ayata.elmahir.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teachers")
data class Teacher(
   @PrimaryKey(autoGenerate = true) val id : Int,
   val name : String
)