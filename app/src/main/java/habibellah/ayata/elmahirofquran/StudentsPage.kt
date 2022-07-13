package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import habibellah.ayata.elmahirofquran.adapters.StudentAdapter
import habibellah.ayata.elmahirofquran.databinding.FragmentStudentsPageBinding


class StudentsPage : Fragment() {
private lateinit var binding: FragmentStudentsPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentStudentsPageBinding.inflate(inflater,container,false)
val arrayList = mutableListOf<Student>()
        arrayList.add(Student("حبيب الله","القيامة","4 غيابات"))
        arrayList.add(Student("حبيب الله1","القيامة3","14 غيابات"))
        arrayList.add(Student("حبيب 2","القيامة2","42 غيابات"))
        arrayList.add(Student("حبيب الله3","القيامة5","43 غيابات"))
        arrayList.add(Student("4حبيب الله","القيام66ة","44 غيابات"))
        arrayList.add(Student("حبيب الله5","القيا7مة","45 غيابات"))
        val adapter = StudentAdapter(arrayList,object :StudentListener{
            override fun onStudentClick(position: Int) {
                addProfileCallBackPage()
            }

        })
        binding.studentRecycler.adapter = adapter
        addStudentsCallBack()

        return binding.root
    }

    private fun addProfileCallBackPage() {
        navToProfilePage()
    }

    private fun navToProfilePage() {
        view?.let { Navigation.findNavController(it).navigate(R.id.action_navToStudentOrTeacherPage_to_profileStudentPage) }
    }

    private fun addStudentsCallBack() {
        binding.floatingActionButton.setOnClickListener { navToAddStudentPage(it) }

    }

    private fun navToAddStudentPage(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_navToStudentOrTeacherPage_to_addStudentPage)
    }

}