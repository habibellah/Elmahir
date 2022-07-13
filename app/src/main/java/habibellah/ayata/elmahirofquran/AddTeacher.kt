package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import habibellah.ayata.elmahirofquran.databinding.FragmentAddTeacherBinding


class AddTeacher : DialogFragment() {

lateinit var binding: FragmentAddTeacherBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddTeacherBinding.inflate(inflater,container,false)



        return binding.root
    }


}