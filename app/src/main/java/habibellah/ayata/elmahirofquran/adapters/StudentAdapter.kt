package habibellah.ayata.elmahirofquran.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import habibellah.ayata.elmahirofquran.R
import habibellah.ayata.elmahirofquran.Student
import habibellah.ayata.elmahirofquran.StudentListener
import habibellah.ayata.elmahirofquran.databinding.StudentItemBinding

class StudentAdapter(private val listOfStudent:List<Student>, val listener: StudentListener): RecyclerView.Adapter<StudentAdapter.StudentHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item,parent,false)
        return StudentHolder(view)
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
       val currentStudent = listOfStudent[position]
        holder.binding.apply {
            name.text = currentStudent.name
            sora.text = currentStudent.sora
            absents.text = currentStudent.absents
        }
        holder.binding.root.setOnClickListener {
            listener.onStudentClick(position)
        }
    }

    override fun getItemCount() = listOfStudent.size
    class StudentHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = StudentItemBinding.bind(itemView)
    }

}