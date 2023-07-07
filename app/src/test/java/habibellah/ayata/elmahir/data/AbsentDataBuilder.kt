package habibellah.ayata.elmahir.data

import habibellah.ayata.elmahir.data.roomDb.entity.Absent

class AbsentDataBuilder {

   companion object{
      fun anAbsent() = AbsentDataBuilder()
   }

   var id : Int = 0
   var studentId : Int = 0
   var absentDate = "some date"

   fun withId(id : Int) : AbsentDataBuilder{
      this.id = id
      return this
   }

   fun withStudentId(studentId : Int) : AbsentDataBuilder{
      this.studentId = studentId
      return this
   }

   fun withAbsentDate(absentDate : String) : AbsentDataBuilder{
      this.absentDate = absentDate
      return this
   }

   fun build():Absent{
      return Absent(
         id = id , studentId = studentId, absentDate = absentDate
      )
   }
}