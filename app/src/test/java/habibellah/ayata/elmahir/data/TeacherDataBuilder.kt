package habibellah.ayata.elmahir.data

import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

class TeacherDataBuilder {

   companion object{
      fun aTeacher() = TeacherDataBuilder()
   }

   var id : Int = 0
   var name : String = "some name"

   fun withId(id : Int) : TeacherDataBuilder{
      this.id = id
      return this
   }

   fun withName(name : String) : TeacherDataBuilder{
      this.name = name
      return this
   }

   fun build():Teacher{
      return Teacher(
         id, name
      )
   }
}