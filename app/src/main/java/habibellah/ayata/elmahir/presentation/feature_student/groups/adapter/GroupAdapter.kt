package habibellah.ayata.elmahir.presentation.feature_student.groups.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Group
import habibellah.ayata.elmahir.databinding.GroupItemBinding

class GroupAdapter (private val groupListener : GroupListener): RecyclerView.Adapter<GroupAdapter.GroupHolder>() {
   private var groups : List<Group> = emptyList()

   fun setData(newGroups : List<Group>) {
      val diffResult = DiffUtil.calculateDiff(GroupDiffUtilI(groups,newGroups))
      groups = newGroups
      diffResult.dispatchUpdatesTo(this)
   }

   override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : GroupHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.group_item , parent , false)
      return GroupHolder(view)
   }

   override fun onBindViewHolder(holder : GroupHolder , position : Int) {
      val currentGroup = groups[position]
      holder.binding.groupName.text = currentGroup.groupName
      holder.binding.root.setOnClickListener {
         groupListener.onGroupClick(currentGroup.groupName)
      }
   }

   override fun getItemCount() = groups.size

   class GroupHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
      val binding = GroupItemBinding.bind(itemView)
   }
}