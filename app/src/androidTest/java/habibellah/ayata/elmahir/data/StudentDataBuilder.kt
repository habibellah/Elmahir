package habibellah.ayata.elmahir.data

import habibellah.ayata.elmahir.data.roomDb.entity.Student

class StudentDataBuilder {
   companion object{
      fun aStudent() = StudentDataBuilder()
   }

   var id : Int = 0
   var studentName : String = "some name"
   var educationYear = "some year"
   var healthStatus = "some health Status"
   var studentNote : String = "some note"
   var currentSora = "some sora"
   var age = 0
   var teacherName = "some name"
   var groupName = "some group"

   fun withId(id : Int) : StudentDataBuilder{
      this.id = id
      return this
   }

   fun withStudentName(studentName : String) : StudentDataBuilder{
      this.studentName = studentName
      return this
   }

   fun withEducationYear(educationYear : String) : StudentDataBuilder{
      this.educationYear = educationYear
      return this
   }

   fun withHealthStatus(healthStatus : String) : StudentDataBuilder{
      this.healthStatus = healthStatus
      return this
   }

   fun withStudentNote(studentNote : String) : StudentDataBuilder{
      this.studentNote = studentNote
      return this
   }

   fun withCurrentSora(currentSora : String) : StudentDataBuilder{
      this.currentSora = currentSora
      return this
   }

   fun withAge(age : Int) : StudentDataBuilder{
      this.age = age
      return this
   }

   fun withTeacherName(teacherName : String) : StudentDataBuilder{
      this.teacherName = teacherName
      return this
   }

   fun withGroupName(groupName : String) : StudentDataBuilder{
      this.groupName = groupName
      return this
   }
   fun build(): Student {
      return Student(
         id = id ,
         studentName = studentName ,
         educationYear = educationYear ,
         healthStatus = healthStatus ,
         age = age,
         teacherName = teacherName,
         studentNote = studentNote ,
         currentSora = currentSora,
         groupName = groupName
      )
   }
}