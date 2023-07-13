package habibellah.ayata.elmahir.presentation.feature_student.groups

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import habibellah.ayata.elmahir.data.repository.GroupRepository
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GroupViewModel @Inject constructor(private val groupRepository : GroupRepository) :
   ViewModel() {

   init {
      getGroups()
   }

   fun addGroup(group : Group) {
      viewModelScope.launch {
         groupRepository.addGroup(group)
      }
   }

   fun getGroups() = groupRepository.getGroupList()

}