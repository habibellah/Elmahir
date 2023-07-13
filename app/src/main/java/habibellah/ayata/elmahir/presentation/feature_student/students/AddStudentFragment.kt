package habibellah.ayata.elmahir.presentation.feature_student.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.databinding.FragmentAddStudentBinding
import habibellah.ayata.elmahir.presentation.feature_student.groups.GroupViewModel
import habibellah.ayata.elmahir.presentation.feature_teacher.TeacherViewModel

@AndroidEntryPoint
class AddStudentFragment : Fragment() {

   private val studentViewModel : StudentViewModel by viewModels()
   private val teacherViewModel : TeacherViewModel by viewModels()
   private val groupViewModel : GroupViewModel by viewModels()
   private lateinit var binding : FragmentAddStudentBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =
         DataBindingUtil.inflate(inflater , R.layout.fragment_add_student , container , false)
      initSowarSpinner()
      initTeachersSpinner()
      initGroupSpinner()
      addStudentButtonCallBack()
      return binding.root
   }


   private fun initTeachersSpinner() {
      teacherViewModel.getTeachers().observe(viewLifecycleOwner) { teachers ->
         if (teachers.isNotEmpty()) {
            val teacherList = teachers.map { it.name }
            ArrayAdapter(
               requireActivity() ,
               android.R.layout.simple_spinner_item ,
               teacherList
            ).also { adapter ->
               adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
               binding.spineerOfTeacher.adapter = adapter
            }
         }
      }
   }

   private fun initSowarSpinner() {
      ArrayAdapter.createFromResource(
         requireContext() ,
         R.array.sowar ,
         android.R.layout.simple_spinner_item
      ).also { adapter ->
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         binding.spinnerOfCurrentSore.adapter = adapter
      }
   }

   private fun initGroupSpinner() {
      groupViewModel.getGroups().observe(viewLifecycleOwner) { groups ->
         if (groups.isNotEmpty()) {
            val groupList = groups.map { it.groupName }
            ArrayAdapter(
               requireActivity() ,
               android.R.layout.simple_spinner_item ,
               groupList
            ).also { adapter ->
               adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
               binding.spineerOfGroup.adapter = adapter
            }
         }
      }
   }

   private fun addStudentButtonCallBack() {
      binding.addStudentButton.setOnClickListener {
         if(isValidInputs()){
            studentViewModel.addStudent(
               Student(
                  id = 0 ,
                  studentName = binding.nameOfStudent.editText!!.text.toString() ,
                  educationYear =  binding.yearOfEducation.editText!!.text.toString(),
                  healthStatus = binding.medicalInfoOfStudent.editText!!.text.toString(),
                  age = binding.ageOfStudent.editText!!.text.toString().toInt() ,
                  teacherName = binding.spineerOfTeacher.selectedItem.toString() ,
                  currentSora = binding.spinnerOfCurrentSore.selectedItem.toString() ,
                  groupName =binding.spineerOfGroup.selectedItem.toString(),
                  studentNote = ""
               )
            )
            Navigation.findNavController(requireActivity(),R.id.fragmentContainerView).popBackStack()
         }
      }
   }

   private fun isValidInputs() : Boolean {
      if(binding.nameOfStudent.editText?.text?.isEmpty() == true){
         binding.nameOfStudent.error = "قم بإدخال إسم الطالب"
         return false
      }
      if(binding.ageOfStudent.editText?.text?.isEmpty() == true){
         binding.ageOfStudent.error = "قم بإدخال عمر الطالب"
         return false
      }
      if(binding.medicalInfoOfStudent.editText?.text?.isEmpty() == true){
         binding.medicalInfoOfStudent.error = "قم بإدخال الحالة الصحية للطالب"
         return false
      }
      if(binding.yearOfEducation.editText?.text?.isEmpty() == true){
         binding.yearOfEducation.error = "قم بإدخال السنة الدراسية للطالب"
         return false
      }
      return true
   }
}