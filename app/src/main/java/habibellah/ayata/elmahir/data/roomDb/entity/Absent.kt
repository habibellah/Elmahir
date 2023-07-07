package habibellah.ayata.elmahir.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "absent")
data class Absent(
  @PrimaryKey(autoGenerate = true) val id : Int,
  val studentId : Int,
  val absentDate : String
)