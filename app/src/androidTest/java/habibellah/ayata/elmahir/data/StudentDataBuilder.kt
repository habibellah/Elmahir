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
   var absents : Int = 0
   var currentSora = "some sora"
   var age = 0
   var teacherName = "some name"

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

   fun withAbsents(absents : Int) : StudentDataBuilder{
      this.absents = absents
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

   fun build(): Student {
      return Student(
         id = id ,
         studentName = studentName ,
         educationYear = educationYear ,
         healthStatus = healthStatus ,
         age = age,
         teacherName = teacherName,
         absents = absents ,
         currentSora = currentSora
      )
   }
}