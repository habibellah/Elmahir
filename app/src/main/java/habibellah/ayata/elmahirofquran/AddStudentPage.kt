package habibellah.ayata.elmahirofquran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import habibellah.ayata.elmahirofquran.databinding.FragmentAddStudentPageBinding
import habibellah.ayata.elmahirofquran.db.DbAccess
import habibellah.ayata.elmahirofquran.db.IDataBase

/*
@definition this page of add a new student where the user fill all information about
the new student after that click on add button to add it in the data base
 */
class AddStudentPage : Fragment() {

    private lateinit var binding: FragmentAddStudentPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAddStudentPageBinding.inflate(inflater, container, false)
        addStudentButtonCallBack()
        return binding.root
    }

    private fun addStudentButtonCallBack() {
       binding.addStudentButton.setOnClickListener { addStudentOnDB() }
    }

    private fun addStudentOnDB() {
        val dbAccess: IDataBase = DbAccess(requireContext())
        dbAccess.openDB()
        dbAccess.insertANewStudent(getNameStudent(),
            getAgeStudent(),
            getTeacherStudent(),
            getCurrentSoraStudent(),
            getMedicalInfoStudent(),
            getDateOfStartStudent(),
            getYearOfEducationStudent())
        dbAccess.closeDB()
        Toast.makeText(context,"success insert",Toast.LENGTH_SHORT).show()
    }

    private fun getYearOfEducationStudent(): String {
        return binding.yearOfEducation.text.toString()
    }

    private fun getDateOfStartStudent(): String {
        return binding.dateOfStart.text.toString()
    }

    private fun getMedicalInfoStudent(): String {
        return binding.medicalInfoOfStudent.text.toString()
    }

    private fun getCurrentSoraStudent(): String {
        return binding.spinnerOfCurrentSore.toString()
    }

    private fun getTeacherStudent(): String {
        return binding.spineerOfTeacherStudent.toString()
    }

    private fun getAgeStudent(): String {
        return binding.ageOfStudent.text.toString()
    }

    private fun getNameStudent(): String {
        return binding.nameOfStudent.text.toString()
    }


}