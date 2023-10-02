package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.viewmodel.DetailViewModel
import com.example.advweek4.viewmodel.ListViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var detailView: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailView = ViewModelProvider(this).get(DetailViewModel::class.java)

        detailView.fetch()
        observeViewModel()
    }

    fun observeViewModel() {
        val id = view?.findViewById<TextView>(R.id.txtID)
        val nama = view?.findViewById<TextView>(R.id.txtNama)
        val bod = view?.findViewById<TextView>(R.id.txtBirth)
        val phone = view?.findViewById<TextView>(R.id.txtPhone)
        detailView.studentLD.observe(viewLifecycleOwner, Observer { student ->
            id?.setText(student.id)
            nama?.setText(student.nama)
            bod?.setText(student.bod)
            phone?.setText(student.phone)
        })
    }
}