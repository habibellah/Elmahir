package habibellah.ayata.elmahir.presentation.feature_student.students.adapter.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import habibellah.ayata.elmahir.R
import habibellah.ayata.elmahir.data.roomDb.entity.Student
import habibellah.ayata.elmahir.databinding.StudentItemBinding

class StudentAdapter (private val studentListener : StudentListener): RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
   private var students : List<Student> = emptyList()

   fun setData(newStudents : List<Student>) {
      val diffResult = DiffUtil.calculateDiff(StudentDiffUtilI(students,newStudents))
      students = newStudents
      diffResult.dispatchUpdatesTo(this)
   }

   override fun onCreateViewHolder(parent : ViewGroup , viewType : Int) : StudentHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.student_item , parent , false)
      return StudentHolder(view)
   }

   override fun onBindViewHolder(holder : StudentHolder , position : Int) {
      val currentStudent = students[position]
      holder.binding.studentName.text = currentStudent.studentName
      holder.binding.root.setOnClickListener {
         studentListener.onStudentItemClick(currentStudent.id)
      }
   }

   override fun getItemCount() = students.size

   class StudentHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
      val binding = StudentItemBinding.bind(itemView)
   }
}