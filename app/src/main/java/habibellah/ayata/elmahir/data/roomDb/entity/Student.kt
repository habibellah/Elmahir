package habibellah.ayata.elmahir.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
 @PrimaryKey(autoGenerate = true)  val id:Int
)