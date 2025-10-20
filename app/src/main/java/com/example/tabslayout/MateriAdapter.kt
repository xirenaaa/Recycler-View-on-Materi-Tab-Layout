package com.example.tabslayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MateriAdapter(
    private val materiList: List<Materi>,
    private val onItemClick: (Materi) -> Unit
) : RecyclerView.Adapter<MateriAdapter.MateriViewHolder>() {

    inner class MateriViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvJudul: TextView = itemView.findViewById(R.id.tv_judul)
        val tvDeskripsi: TextView = itemView.findViewById(R.id.tv_deskripsi)
        val tvKategori: TextView = itemView.findViewById(R.id.tv_kategori)

        fun bind(materi: Materi) {
            tvJudul.text = materi.judul
            tvDeskripsi.text = materi.deskripsi
            tvKategori.text = materi.kategori

            itemView.setOnClickListener {
                onItemClick(materi)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateriViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_materi, parent, false)
        return MateriViewHolder(view)
    }

    override fun onBindViewHolder(holder: MateriViewHolder, position: Int) {
        holder.bind(materiList[position])
    }

    override fun getItemCount(): Int = materiList.size
}

