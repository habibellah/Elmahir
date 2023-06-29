package habibellah.ayata.elmahir.presentation.feature_teacher.adapter

import androidx.recyclerview.widget.DiffUtil
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher

class TeacherDiffUtilI(private val oldList: List<Teacher> , private val newList: List<Teacher>) : DiffUtil.Callback() {
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