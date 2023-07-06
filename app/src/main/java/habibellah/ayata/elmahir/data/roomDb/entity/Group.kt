package habibellah.ayata.elmahir.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group")
data class Group(
   @PrimaryKey(autoGenerate = true) val id : Int,
   val groupName : String
)