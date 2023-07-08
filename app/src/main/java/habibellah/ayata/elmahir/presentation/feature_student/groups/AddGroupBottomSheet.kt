package habibellah.ayata.elmahir.presentation.feature_student.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import habibellah.ayata.elmahir.databinding.AddGroupBottomSheetBinding

@AndroidEntryPoint
class AddGroupBottomSheet : BottomSheetDialogFragment() {
   private val groupViewModel : GroupViewModel by viewModels()
   private lateinit var binding : AddGroupBottomSheetBinding
   override fun onCreateView(
      inflater : LayoutInflater ,
      container : ViewGroup? ,
      savedInstanceState : Bundle?
   ) : View {
      binding =
         DataBindingUtil.inflate(inflater, R.layout.add_group_bottom_sheet, container, false)
      return binding.root
   }

   override fun onViewCreated(view : View , savedInstanceState : Bundle?) {
      super.onViewCreated(view , savedInstanceState)
      addGroupButtonCallBack()
   }

   private fun addGroupButtonCallBack() {
      binding.add.setOnClickListener {
            if(isValidInputs())
            {
               groupViewModel.addGroup(Group(0,binding.addGroup.editText!!.text.toString()))
               dialog!!.cancel()
            }
      }
   }

   private fun isValidInputs() : Boolean{
      if(binding.addGroup.editText?.text?.isEmpty() == true){
         binding.addGroup.error = "قم بإدخال إسم المجموعة"
         return false
      }
      return true
   }
   companion object {
      const val TAG = "ModalBottomSheet"
   }
}


