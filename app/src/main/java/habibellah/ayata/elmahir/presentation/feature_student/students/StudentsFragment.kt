package habibellah.ayata.elmahir.presentation.feature_student.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.databinding.FragmentStudentsBinding
import habibellah.ayata.elmahir.presentation.feature_student.students.adapter.student.StudentAdapter
import habibellah.ayata.elmahir.presentation.feature_student.students.adapter.student.StudentListener

@AndroidEntryPoint
class StudentsFragment : Fragment() {

   private val args by navArgs<StudentsFragmentArgs>()
   private val studentViewModel : StudentViewModel by viewModels()
   private lateinit var studentAdapter : StudentAdapter
   private lateinit var binding : FragmentStudentsBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =
         DataBindingUtil.inflate(inflater , R.layout.fragment_students , container , false)
      return binding.root
   }

   override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
      super.onViewCreated(view , savedInstanceState)
      setupAdapter()
      addStudentButtonCallBack()
   }

   private fun addStudentButtonCallBack() {
      binding.addStudent.setOnClickListener {
         Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            .navigate(R.id.action_studentsFragment_to_addStudentFragment)
      }
   }

   private fun setupAdapter() {
      studentViewModel.getStudents(args.groupName)
      studentAdapter = StudentAdapter(object : StudentListener {
         override fun onStudentItemClick(studentId : Int) {
           navigateToStudentDetailsFragment(studentId)
         }
      })
     studentViewModel.students.observe(viewLifecycleOwner){ students ->
        if(students.isNotEmpty()){
           studentAdapter.setData(students)
        }
     }
      binding.studentRecycler.adapter = studentAdapter
   }

   private fun navigateToStudentDetailsFragment(studentId : Int) {
      val action = StudentsFragmentDirections.actionStudentsFragmentToStudentDetailsFragment(studentId)
      Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
         .navigate(action)
   }

}