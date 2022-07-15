package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import habibellah.ayata.elmahirofquran.adapters.StudentAdapter
import habibellah.ayata.elmahirofquran.databinding.FragmentStudentsPageBinding
/*
@definition this page you can find a list of Students and know some information about it like the absents
and the name and if he is sick
 */

class StudentsPage : Fragment() {
    private lateinit var binding: FragmentStudentsPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStudentsPageBinding.inflate(inflater, container, false)
        val arrayList = mutableListOf<Student>()
        arrayList.add(Student("حبيب الله", "القيامة", "4 غيابات"))
        arrayList.add(Student("حبيب الله1", "القيامة3", "14 غيابات"))
        arrayList.add(Student("حبيب 2", "القيامة2", "42 غيابات"))
        arrayList.add(Student("حبيب الله3", "القيامة5", "43 غيابات"))
        arrayList.add(Student("4حبيب الله", "القيام66ة", "44 غيابات"))
        arrayList.add(Student("حبيب الله5", "القيا7مة", "45 غيابات"))
        val adapter = StudentAdapter(arrayList, object : StudentListener {
            override fun onStudentClick(position: Int) {
                addProfileCallBackPage()
            }

        })
        binding.studentRecycler.adapter = adapter
        addStudentsCallBack()

        return binding.root
    }

    //click on item of a student
    private fun addProfileCallBackPage() {
        navToProfilePage()
    }

    //if the user click on the item of each student will navigate a profile page when you will get more
    //information about the student
    private fun navToProfilePage() {
        Navigation.findNavController(requireActivity(),R.id.fragmentContainerView)
            .navigate(R.id.action_navToStudentOrTeacherPage_to_profileStudentPage)
    }

    //this method when the user click on FAB to add a new student
    private fun addStudentsCallBack() {
        binding.floatingActionButton.setOnClickListener { navToAddStudentPage() }

    }

    //this method navigate to Add a new Student
    private fun navToAddStudentPage() {
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
            .navigate(R.id.action_navToStudentOrTeacherPage_to_addStudentPage)
    }

}