package habibellah.ayata.elmahir.presentation.feature_student.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.databinding.FragmentStudentDetailsBinding
import habibellah.ayata.elmahir.presentation.feature_student.students.adapter.absent.AbsentAdapter
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@AndroidEntryPoint
class StudentDetailsFragment : Fragment() {

   val args by navArgs<StudentDetailsFragmentArgs>()
   private lateinit var absentAdapter : AbsentAdapter
   private val studentDetailsViewModel : StudentDetailsViewModel by viewModels()
   private lateinit var binding : FragmentStudentDetailsBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =
         DataBindingUtil.inflate(inflater , R.layout.fragment_student_details , container , false)
      return binding.root
   }

   override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
      super.onViewCreated(view , savedInstanceState)
      fillStudentDetails()
      setupAbsentAdapter()
      addAbsentButtonCallBack()
      initCurrentSoraSpinner()
      saveChangesButtonCallBack()
   }

   private fun saveChangesButtonCallBack() {
      binding.saveChanges.setOnClickListener {
      studentDetailsViewModel.updateStudent(
         Student(
            args.studentId ,
            studentName = binding.nameOfStudent.text.toString() ,
            educationYear = binding.educationYear.text.toString() ,
            healthStatus = binding.HealthStatus.text.toString() ,
            age = binding.ageOfStudent.text.toString().toInt() ,
            studentNote = binding.studentNote.editText!!.text.toString() ,
            teacherName = binding.teacherName.text.toString() ,
            currentSora = binding.currentSora.text.toString() ,
            groupName = binding.groupName.text.toString() ,

         )
      )
      }
   }

   private fun initCurrentSoraSpinner() {
      ArrayAdapter.createFromResource(
         requireContext() ,
         R.array.sowar ,
         android.R.layout.simple_spinner_item
      ).also { adapter ->
         adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         binding.spinnerOfCurrentSore.adapter = adapter
      }
      binding.spinnerOfCurrentSore.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
         override fun onItemSelected(
            parent : AdapterView<*>? ,
            view : View? ,
            position : Int ,
            id : Long
         ) {
            binding.currentSora.text = binding.spinnerOfCurrentSore.selectedItem.toString()
         }

         override fun onNothingSelected(parent : AdapterView<*>?) {
         }
      }
   }

   private fun addAbsentButtonCallBack() {
      binding.addAbsent.setOnClickListener {
         studentDetailsViewModel.addAbsent(
            Absent(
               0 ,
               args.studentId ,
               getCurrentDate()
            )
         )
      }
   }

   private fun getCurrentDate() : String {
      val calender : Date = Calendar.getInstance().time
      val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy" , Locale.getDefault())
      return simpleDateFormat.format(calender)
   }

   private fun setupAbsentAdapter() {
      binding.absentRecycler.layoutManager = GridLayoutManager(context,2)
      absentAdapter = AbsentAdapter()
      studentDetailsViewModel.getAbsentsBy(args.studentId).observe(viewLifecycleOwner) { absents ->
         if (absents.isNotEmpty()) {
            Toast.makeText(context,absents.toString(),Toast.LENGTH_SHORT).show()
            absentAdapter.setData(absents)
         }
      }
      binding.absentRecycler.adapter = absentAdapter
   }

   private fun fillStudentDetails() {
      studentDetailsViewModel.getStudentBy(args.studentId)
      studentDetailsViewModel.student.observe(viewLifecycleOwner) { student ->
         binding.nameOfStudent.text = student.studentName
         binding.ageOfStudent.setText(student.age.toString())
         binding.HealthStatus.setText(student.healthStatus)
         binding.teacherName.text = student.teacherName
         binding.currentSora.text = student.currentSora
         binding.studentNote.editText!!.setText(student.studentNote)
         binding.educationYear.setText(student.educationYear)
         binding.groupName.text = student.groupName
      }
   }

}