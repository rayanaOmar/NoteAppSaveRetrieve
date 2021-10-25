package com.example.notesappsaveretriving

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappsaveretriving.Database.NoteDetails
import kotlinx.android.synthetic.main.note_row.view.*

class RVadapter (private val activity: MainActivity,private val items: ArrayList<NoteDetails>): RecyclerView.Adapter<RVadapter.ItemViewHolder>() {

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVadapter.ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RVadapter.ItemViewHolder, position: Int) {
        val item = items[position]

        holder.itemView.apply {
            tvNote.text = item.noteText
        }
    }

    override fun getItemCount() = items.size
}