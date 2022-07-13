package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import habibellah.ayata.elmahirofquran.adapters.TeacherAdapter
import habibellah.ayata.elmahirofquran.databinding.FragmentTeacherPageBinding


class TeacherPage : Fragment() {

private lateinit var binding: FragmentTeacherPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTeacherPageBinding.inflate(inflater,container,false)
val arrayList = mutableListOf<Teacher>()
        arrayList.add(Teacher("حبيب الله"))
        arrayList.add(Teacher("حبيب الله1"))
        arrayList.add(Teacher("حبيب الل2ه"))
        arrayList.add(Teacher("حبيب الل3ه"))
        arrayList.add(Teacher("4حبيب الله"))
        val adapter = TeacherAdapter(arrayList)
        binding.teacherRecycler.adapter = adapter
addTeacherCallBack()
        return binding.root
    }

    private fun addTeacherCallBack() {
        binding.floatingActionButton.setOnClickListener {
            navToAddStudentDialogue(it)
        }
    }

    private fun navToAddStudentDialogue(view: View) {
        Navigation.findNavController(view).navigate(R.id.action_navToStudentOrTeacherPage_to_addTeacher)
    }

}