package habibellah.ayata.elmahir.presentation.feature_student.students.adapter.student

import androidx.recyclerview.widget.DiffUtil
import habibellah.ayata.elmahir.data.roomDb.entity.Student

class StudentDiffUtilI(private val oldList: List<Student> , private val newList: List<Student>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
      return  oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return  oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}