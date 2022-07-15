package habibellah.ayata.elmahirofquran

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import habibellah.ayata.elmahirofquran.databinding.FragmentLogoPageBinding

/*
@definition this page has the splash screen where show the logo and get data from data bases
 */
class LogoPage : Fragment() {

    private lateinit var binding: FragmentLogoPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLogoPageBinding.inflate(inflater, container, false)
        timerOfSeconds()
        return binding.root
    }

    //this function is make a timer for three seconds
    private fun timerOfSeconds() {
        Handler(Looper.getMainLooper()).postDelayed({
            navToStudentTeacherPage()
        }, 3000)
    }

//this method navigate to Student_and_TeacherPage
    private fun navToStudentTeacherPage() {
        view?.let {
            Navigation.findNavController(it)
                .navigate(R.id.action_logoPage_to_navToStudentOrTeacherPage)
        }
    }

}