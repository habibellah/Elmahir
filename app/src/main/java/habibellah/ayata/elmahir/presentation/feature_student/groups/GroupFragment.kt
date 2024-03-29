package habibellah.ayata.elmahir.presentation.feature_student.groups

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.databinding.FragmentGroupBinding
import habibellah.ayata.elmahir.presentation.NavigationBottomFragmentDirections
import habibellah.ayata.elmahir.presentation.feature_student.groups.adapter.GroupAdapter
import habibellah.ayata.elmahir.presentation.feature_student.groups.adapter.GroupListener

@AndroidEntryPoint
class GroupFragment : Fragment() {

   private val groupViewModel : GroupViewModel by viewModels()
    lateinit var groupAdapter : GroupAdapter
   private lateinit var binding : FragmentGroupBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =
         DataBindingUtil.inflate(inflater, R.layout.fragment_group, container, false)
      return binding.root
   }

   override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
      super.onViewCreated(view , savedInstanceState)
      addGroupButtonCallBack()
      setupGroupAdapter()
   }

   private fun setupGroupAdapter() {
      groupAdapter = GroupAdapter(object : GroupListener{
         override fun onGroupClick(groupName : String) {
            navigateToStudentFragment(groupName)
         }
      })
      groupViewModel.getGroups().observe(viewLifecycleOwner){groups->
         if(groups.isNotEmpty()){
            groupAdapter.setData(groups)
         }
      }
      binding.recyclerGroup.adapter = groupAdapter
   }

   private fun navigateToStudentFragment(groupName : String) {
      val action = NavigationBottomFragmentDirections.actionNavigationBottomFragmentToStudentsFragment(groupName)
     Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
        .navigate(action)
   }

   private fun addGroupButtonCallBack() {
      binding.addGroup.setOnClickListener {
         val modalBottomSheet = AddGroupBottomSheet()
         modalBottomSheet.show(childFragmentManager, AddGroupBottomSheet.TAG)
      }
   }

}