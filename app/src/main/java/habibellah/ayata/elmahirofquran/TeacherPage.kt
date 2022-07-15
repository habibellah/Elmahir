package habibellah.ayata.elmahirofquran

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import habibellah.ayata.elmahirofquran.adapters.TeacherAdapter
import habibellah.ayata.elmahirofquran.databinding.FragmentTeacherPageBinding
import habibellah.ayata.elmahirofquran.db.DbAccess
import habibellah.ayata.elmahirofquran.db.IDataBase

/*
@this page you will find the Teachers List (recycler view) where you can know the teachers in this school
and you can add a new one
 */
class TeacherPage : Fragment() {

    private lateinit var arrayList: ArrayList<Teacher>
    private lateinit var binding: FragmentTeacherPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTeacherPageBinding.inflate(inflater, container, false)

        setUpAdapter()

        addTeacherCallBack()
        return binding.root
    }

    //this method prepare the adapter of Teachers
    private fun setUpAdapter() {
        val adapter = TeacherAdapter(arrayList)
        binding.teacherRecycler.adapter = adapter
    }

    //this method when the user click on FAB to add a new teacher
    private fun addTeacherCallBack() {
        binding.floatingActionButton.setOnClickListener {
            navToAddTeacherDialogue()
        }
    }

    //navigate to AddStudent page
    private fun navToAddTeacherDialogue() {
        Navigation.findNavController(requireActivity(), R.id.fragmentContainerView)
            .navigate(R.id.action_navToStudentOrTeacherPage_to_addTeacher)
    }

    //get data not completed yet just dummy data
    override fun onAttach(context: Context) {
        super.onAttach(context)
        val dbAccess:IDataBase = DbAccess(requireContext())
        dbAccess.openDB()
        arrayList = dbAccess.getTeachersList()
        dbAccess.closeDB()
    }

}