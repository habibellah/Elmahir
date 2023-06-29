package habibellah.ayata.elmahir.presentation.feature_teacher

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.databinding.FragmentTeacherBinding
import habibellah.ayata.elmahir.presentation.feature_teacher.adapter.TeacherAdapter

@AndroidEntryPoint
class TeacherFragment : Fragment() {

   private lateinit var teacherAdapter : TeacherAdapter
   private val teacherViewModel : TeacherViewModel by viewModels()
   private lateinit var binding : FragmentTeacherBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =
         DataBindingUtil.inflate(inflater, R.layout.fragment_teacher, container, false)
      return binding.root
   }

   override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
      super.onViewCreated(view , savedInstanceState)
     setupAdapter()
   }

   private fun setupAdapter() {
      teacherAdapter = TeacherAdapter()
      teacherViewModel.teachers.observe(viewLifecycleOwner){
         if(it.isNotEmpty()){
            teacherAdapter.setData(it)
         }
      }
      binding.teachersRecycler.adapter = teacherAdapter
   }
}