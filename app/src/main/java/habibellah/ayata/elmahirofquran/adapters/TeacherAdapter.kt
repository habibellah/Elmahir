package habibellah.ayata.elmahirofquran.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import habibellah.ayata.elmahirofquran.R
import habibellah.ayata.elmahirofquran.Teacher
import habibellah.ayata.elmahirofquran.databinding.TeacherItemBinding

class TeacherAdapter(private val listOfTeachers:List<Teacher>): RecyclerView.Adapter<TeacherAdapter.TeacherHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.teacher_item,parent,false)
        return TeacherHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherHolder, position: Int) {
        val teacher = listOfTeachers[position]
        holder.binding.teacherName.text = teacher.teacherName
    }

    override fun getItemCount(): Int {
        return listOfTeachers.size
    }

    class TeacherHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
val binding = TeacherItemBinding.bind(itemView)
    }

}