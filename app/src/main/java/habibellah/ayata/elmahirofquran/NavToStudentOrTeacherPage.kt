package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import habibellah.ayata.elmahirofquran.databinding.FragmentNavToStudentOrTeacherPageBinding


class NavToStudentOrTeacherPage : Fragment() {
     private val studentsPage = StudentsPage()
    private val teacherPage = TeacherPage()
    private lateinit var binding:FragmentNavToStudentOrTeacherPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNavToStudentOrTeacherPageBinding.inflate(inflater,container,false)
        showTeachersPage(teacherPage)
       addNavigationListener()
        return binding.root
    }

    private fun addNavigationListener() {
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.teacher -> {
                    replaceFragment(teacherPage)
                }
                R.id.student -> {
                    replaceFragment(studentsPage)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

    private fun showTeachersPage(fragment: Fragment) {
   addFragment(fragment)
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,fragment)
        transaction.commit()
    }
}
