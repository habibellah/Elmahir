package habibellah.ayata.elmahir.presentation.feature_teacher

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import habibellah.ayata.elmahir.databinding.FragmentAddTeacherDialogBinding

@AndroidEntryPoint
class AddTeacherDialogFragment : DialogFragment() {

   private val teacherViewModel : TeacherViewModel by viewModels()
   private lateinit var binding : FragmentAddTeacherDialogBinding
   override fun onCreateView(
      inflater : LayoutInflater , container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =   DataBindingUtil.inflate(inflater, R.layout.fragment_add_teacher_dialog, container, false)
      return binding.root
   }

   override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
      super.onViewCreated(view , savedInstanceState)
      addTeacherButtonCallBack()
   }

   private fun addTeacherButtonCallBack() {
      binding.add.setOnClickListener {
        if(isValidInputs())
        {
           teacherViewModel.addTeacher(Teacher(0,binding.addTeacher.editText!!.text.toString()))
           dialog!!.cancel()
        }
      }
   }

   private fun isValidInputs() : Boolean{
      if(binding.addTeacher.editText?.text?.isEmpty() == true){
         binding.addTeacher.error = "قم بإدخال إسم الشيخ"
         return false
      }
      return true
   }

   override fun onResume() {
      super.onResume()
      if (activity != null) requireActivity().requestedOrientation =
         ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
      dialog!!.window!!.setLayout(
         ViewGroup.LayoutParams.MATCH_PARENT,
         ViewGroup.LayoutParams.WRAP_CONTENT
      )
   }
}