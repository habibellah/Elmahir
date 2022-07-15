package habibellah.ayata.elmahirofquran

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import habibellah.ayata.elmahirofquran.databinding.FragmentAddTeacherBinding
import habibellah.ayata.elmahirofquran.db.DbAccess
import habibellah.ayata.elmahirofquran.db.IDataBase

/*
@definition this is a dialogue where you can add a new teacher by his name
 */
class AddTeacher : DialogFragment() {

    private lateinit var binding: FragmentAddTeacherBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddTeacherBinding.inflate(inflater, container, false)

        addTeacherCallBack()

        return binding.root
    }

    //when the user click on add button
    private fun addTeacherCallBack() {
        binding.add.setOnClickListener { addTeacherOnDB() }
    }

    //this method will add the teacher on the data base
    private fun addTeacherOnDB() {
        val name = getNameOfTeacher()
        val dbAccess: IDataBase = DbAccess(requireContext())
        dbAccess.openDB()
        dbAccess.insertANewTeacher(name)
        dbAccess.closeDB()
    }

    //this method will get the name of the teacher from the edit text
    private fun getNameOfTeacher(): String {
        return binding.addTeacher.text.toString()
    }


}