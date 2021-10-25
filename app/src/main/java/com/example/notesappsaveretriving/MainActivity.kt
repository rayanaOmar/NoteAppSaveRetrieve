package com.example.notesappsaveretriving

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappsaveretriving.Database.DatabaseHandler
import com.example.notesappsaveretriving.Database.NoteDetails

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var submitBtn: Button
    lateinit var recyclerView: RecyclerView

    lateinit var database: DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        submitBtn = findViewById(R.id.button)
        recyclerView = findViewById(R.id.recyclerView)

        database = DatabaseHandler(this)

        submitBtn.setOnClickListener {
            val userEnter = editText.text.toString()
            val status = database.addMoreNote(NoteDetails(0,userEnter))
            editText.text.clear()
            Toast.makeText(this, "Note Added $status", Toast.LENGTH_SHORT).show()

            recyclerView.adapter = RVadapter(this, getNote())
            recyclerView.layoutManager = LinearLayoutManager(this)
        }


        recyclerView.adapter = RVadapter(this, getNote())
        recyclerView.layoutManager = LinearLayoutManager(this)


    }
    fun getNote(): ArrayList<NoteDetails>{
        return database.retrieveNote()
    }
}