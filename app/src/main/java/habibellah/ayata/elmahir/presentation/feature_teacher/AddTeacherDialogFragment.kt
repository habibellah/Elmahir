package habibellah.ayata.elmahir.presentation.feature_teacher

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.databinding.FragmentAddTeacherDialogBinding

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
         checkInputs()
      }
   }

   private fun checkInputs() {
      if(binding.addTeacher.editText?.text?.isEmpty() == true){
         binding.addTeacher.error = "قم بإدخال إسم الشيخ"
      }
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