package habibellah.ayata.elmahir.presentation.feature_student.students.adapter.absent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Absent
import habibellah.ayata.elmahir.databinding.AbsentItemBinding

class AbsentAdapter: RecyclerView.Adapter<AbsentAdapter.AbsentHolder>() {
   private var absents : List<Absent> = emptyList()

   fun setData(newAbsents : List<Absent>) {
      val diffResult = DiffUtil.calculateDiff(AbsentDiffUtilI(absents,newAbsents))
      absents = newAbsents
      diffResult.dispatchUpdatesTo(this)
   }

   override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : AbsentHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.absent_item , parent , false)
      return AbsentHolder(view)
   }

   override fun onBindViewHolder(holder : AbsentHolder , position : Int) {
      val currentAbsent = absents[position]
      holder.binding.absetnDate.text = currentAbsent.absentDate
   }

   override fun getItemCount() = absents.size

   class AbsentHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
      val binding = AbsentItemBinding.bind(itemView)
   }
}