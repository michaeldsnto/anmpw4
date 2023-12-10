package com.example.advweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.databinding.StudentListItemBinding
import com.example.advweek4.model.Student
import com.squareup.picasso.Picasso
import java.util.*

class StudentListAdapter(val studentList: ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener{
    class StudentViewHolder(var view: StudentListItemBinding):RecyclerView.ViewHolder(view.root) {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)

    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student =studentList[position]
        holder.view.listener = this
//        with(holder){
//            txtID.text = studentList[position].id
//            txtNama.text = studentList[position].nama
//
//            val studentId = studentList[position].id
//
//            val picasso = Picasso.Builder(itemView.context)
//            picasso.listener{picasso, uri, exception ->
//            exception.printStackTrace()}
//            picasso.build().load(studentList[position].photoUrl).into(studentPhoto)
//            btnDetail.setOnClickListener {
//                val action = StudentListFragmentDirections.actionStudentDetail(studentId.toString())
//                Navigation.findNavController(it).navigate(action)
//            }
//        }

    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun updateStudentList(newStudentList: ArrayList<Student>){
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }

}