package habibellah.ayata.elmahir.data

import habibellah.ayata.elmahir.data.roomDb.entity.Group

class GroupDataBuilder {

   companion object{
      fun aGroup() = GroupDataBuilder()
   }

   var id : Int = 0
   var groupName : String = "some name"

   fun withId(id : Int) : GroupDataBuilder{
      this.id = id
      return this
   }

   fun withGroupName(name : String) : GroupDataBuilder{
      this.groupName = name
      return this
   }

   fun build():Group{
      return Group(
         id, groupName
      )
   }
}