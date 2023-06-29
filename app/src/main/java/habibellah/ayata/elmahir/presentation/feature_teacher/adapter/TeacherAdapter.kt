package habibellah.ayata.elmahir.presentation.feature_teacher.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Teacher
import habibellah.ayata.elmahir.databinding.TeacherItemBinding

class TeacherAdapter : RecyclerView.Adapter<TeacherAdapter.TeacherHolder>() {
   private var teachers : List<Teacher> = emptyList()

   fun setData(newTeachers : List<Teacher>) {
      val diffResult = DiffUtil.calculateDiff(TeacherDiffUtilI(teachers,newTeachers))
      teachers = newTeachers
      diffResult.dispatchUpdatesTo(this)
   }

   override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : TeacherHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item , parent , false)
      return TeacherHolder(view)
   }

   override fun onBindViewHolder(holder : TeacherHolder , position : Int) {
      val currentTeacher = teachers[position]
      holder.binding.teacherName.text = currentTeacher.name
   }

   override fun getItemCount() = teachers.size

   class TeacherHolder(itemView : View) : ViewHolder(itemView) {
      val binding = TeacherItemBinding.bind(itemView)
   }
}