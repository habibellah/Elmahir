package habibellah.ayata.elmahir.presentation.feature_student.groups.adapter

import androidx.recyclerview.widget.DiffUtil
import habibellah.ayata.elmahir.data.roomDb.entity.Group

class GroupDiffUtilI(private val oldList: List<Group> , private val newList: List<Group>) : DiffUtil.Callback() {
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