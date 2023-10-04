package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.model.Student
import java.util.*

class StudentListAdapter(val studentList: ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(){
    class StudentViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val txtID:TextView
        val txtNama:TextView
        val btnDetail:Button
        init {
            txtID = view.findViewById(R.id.txtBrand)
            txtNama = view.findViewById(R.id.txtModel)
            btnDetail = view.findViewById(R.id.btnDetail)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.txtID.text = studentList[position].id
        holder.txtNama.text = studentList[position].nama

        val studentId = studentList[position].id

        holder.btnDetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail(studentId.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

}