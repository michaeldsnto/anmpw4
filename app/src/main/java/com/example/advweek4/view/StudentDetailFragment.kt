package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.advweek4.R
import com.example.advweek4.databinding.FragmentStudentDetailBinding
import com.example.advweek4.viewmodel.DetailViewModel
import com.example.advweek4.viewmodel.ListViewModel
import com.squareup.picasso.Picasso
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable.timer
import io.reactivex.rxjava3.core.Maybe.timer
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observable.timer
import io.reactivex.rxjava3.core.Single.timer
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class StudentDetailFragment : Fragment() {
    private lateinit var detailView: DetailViewModel
    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val studentId = arguments?.getString("studentId")

        detailView = ViewModelProvider(this).get(DetailViewModel::class.java)

        detailView.fetch(studentId.toString())
        observeViewModel()
    }

    fun observeViewModel() {
//        val id = view?.findViewById<TextView>(R.id.txtID)
//        val nama = view?.findViewById<TextView>(R.id.txtNama)
//        val bod = view?.findViewById<TextView>(R.id.txtBirth)
//        val phone = view?.findViewById<TextView>(R.id.txtPhone)
//        val imgStudent = view?.findViewById<ImageView>(R.id.imgStudent)

        detailView.studentLD.observe(viewLifecycleOwner, Observer { student ->
            dataBinding.student = student
//            id?.setText(student.id)
//            nama?.setText(student.nama)
//            bod?.setText(student.bod)
//            phone?.setText(student.phone)
//            Picasso.get().load(student.photoUrl).into(imgStudent)
//
//            val btnUpdate = view?.findViewById<Button>(R.id.btnUpdate)
//            btnUpdate?.setOnClickListener{
//                Observable.timer(5, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe {
//                        MainActivity.showNotification("New Notification", "Student data is Updated", R.drawable.ic_baseline_update_24)
//                    }
//            }
        })
    }
}