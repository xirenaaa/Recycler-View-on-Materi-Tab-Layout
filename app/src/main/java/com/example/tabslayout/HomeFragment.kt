package com.example.tabslayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {

    private lateinit var rvMateri: RecyclerView
    private lateinit var materiAdapter: MateriAdapter
    private val materiList = mutableListOf<Materi>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvMateri = view.findViewById(R.id.rv_materi)
        setupRecyclerView()
        loadMateriData()
    }

    private fun setupRecyclerView() {
        rvMateri.layoutManager = LinearLayoutManager(requireContext())
        materiAdapter = MateriAdapter(materiList) { materi ->
            onMateriClick(materi)
        }
        rvMateri.adapter = materiAdapter
    }

    private fun loadMateriData() {
        materiList.clear()
        materiList.addAll(
            listOf(
                Materi(1, "Pengenalan OOP", "Konsep dasar pemrograman berorientasi objek", "OOP"),
                Materi(2, "Class dan Object", "Memahami class dan object dalam OOP", "OOP"),
                Materi(3, "Inheritance", "Pewarisan sifat dari class parent ke child", "OOP"),
                Materi(4, "Polymorphism", "Kemampuan objek untuk memiliki banyak bentuk", "OOP"),
                Materi(5, "Encapsulation", "Pembungkusan data dan method dalam satu unit", "OOP"),
                Materi(6, "Activity Lifecycle", "Siklus hidup activity di Android", "Android"),
                Materi(7, "Intent", "Komunikasi antar komponen Android", "Android"),
                Materi(8, "RecyclerView", "Menampilkan daftar data dengan efisien", "Android"),
                Materi(9, "Fragment", "Komponen UI modular di Android", "Android"),
                Materi(10, "Material Design", "Desain visual untuk aplikasi Android", "Android")
            )
        )
        materiAdapter.notifyDataSetChanged()
    }

    private fun onMateriClick(materi: Materi) {
        Toast.makeText(
            requireContext(),
            "Anda memilih: ${materi.judul}",
            Toast.LENGTH_SHORT
        ).show()
    }
}
