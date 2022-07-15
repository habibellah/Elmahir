package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import habibellah.ayata.elmahirofquran.databinding.FragmentNavToStudentOrTeacherPageBinding
/*
@definition this page has the bottom navigation where you can find the Teachers page
and the students page
 */
class NavToStudentOrTeacherPage : Fragment() {

    private lateinit var binding:FragmentNavToStudentOrTeacherPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNavToStudentOrTeacherPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val navigate = requireActivity().findNavController(R.id.fragment_container)
        binding.bottomNavigationView.setupWithNavController(navigate)
    }

}
