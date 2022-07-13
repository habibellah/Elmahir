package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import habibellah.ayata.elmahirofquran.databinding.FragmentAddStudentPageBinding
import habibellah.ayata.elmahirofquran.databinding.FragmentAddTeacherBinding


class AddStudentPage : Fragment() {

lateinit var binding:FragmentAddStudentPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentAddStudentPageBinding.inflate(inflater,container,false)

        return binding.root
    }

}