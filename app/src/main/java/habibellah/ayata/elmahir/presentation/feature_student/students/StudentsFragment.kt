package habibellah.ayata.elmahir.presentation.feature_student.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.databinding.FragmentStudentsBinding
import habibellah.ayata.elmahir.presentation.feature_student.students.adapter.StudentAdapter
import habibellah.ayata.elmahir.presentation.feature_student.students.adapter.StudentListener

class StudentsFragment : Fragment() {
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
    Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
       .navigate(R.id.action_studentsFragment_to_addStudentFragment)
   }

   private fun setupAdapter() {
      studentAdapter = StudentAdapter(object : StudentListener {
         override fun onStudentItemClick(studentId : Int) {

         }
      })
      studentAdapter.setData(
         listOf(
            Student(
               id = 4542 , studentName = "Ethan Russo" , educationYear = "veri" , healthStatus = "interdum" , absents = 6891 , age = 5258 , teacherName = "Tim Lyons" , currentSora = "eirmod" , groupName = "Bertha Petersen"
            ),
            Student(
               id = 4542 , studentName = "Ethan Russo" , educationYear = "veri" , healthStatus = "interdum" , absents = 6891 , age = 5258 , teacherName = "Tim Lyons" , currentSora = "eirmod" , groupName = "Bertha Petersen"
            ),
            Student(
               id = 4542 , studentName = "Ethan Russo" , educationYear = "veri" , healthStatus = "interdum" , absents = 6891 , age = 5258 , teacherName = "Tim Lyons" , currentSora = "eirmod" , groupName = "Bertha Petersen"
            ),
            Student(
               id = 4542 , studentName = "Ethan Russo" , educationYear = "veri" , healthStatus = "interdum" , absents = 6891 , age = 5258 , teacherName = "Tim Lyons" , currentSora = "eirmod" , groupName = "Bertha Petersen"
            ),
            Student(
               id = 4542 , studentName = "Ethan Russo" , educationYear = "veri" , healthStatus = "interdum" , absents = 6891 , age = 5258 , teacherName = "Tim Lyons" , currentSora = "eirmod" , groupName = "Bertha Petersen"
            ),
            Student(
               id = 4542 , studentName = "Ethan Russo" , educationYear = "veri" , healthStatus = "interdum" , absents = 6891 , age = 5258 , teacherName = "Tim Lyons" , currentSora = "eirmod" , groupName = "Bertha Petersen"
            ),
         )
      )
      binding.studentRecycler.adapter = studentAdapter
   }

}