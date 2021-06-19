package com.example.passnotelite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_notes.view.*
import kotlin.random.Random

class NoteAdapter(val list:List<UserNote>):RecyclerView.Adapter<NoteAdapter.Noteview>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Noteview {
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_notes,parent,false)
        return Noteview(itemView)
    }

    override fun onBindViewHolder(holder: Noteview, position: Int) {
       val current = list[position]
        holder.notessubject.text=current.notesubject
        holder.encrpytnote.text=current.note
        holder.enternote.setOnClickListener {
            //holder.originalnote.
            holder.originalnote.requestFocus()
            val fix=holder.decrpytnote.text.toString()
            if(fix.isEmpty() ){
                holder.decrpytnote.error="Enter the Code in Number Only"
                holder.decrpytnote.requestFocus()

            }else{
                val s= decrypto(current.note.toString(),fix)
                holder.originalnote.text=s.toString()
            }


        }


        with(holder.itemView){
            val colors = resources.getIntArray(R.array.random_color)
            val randomColor = colors[Random.nextInt(colors.size)]

            notw2.setBackgroundColor(randomColor)
        }


    }

    override fun getItemCount(): Int {
        return list.size

    }
    override fun getItemId(position: Int):Long{
        return list[position].uid
    }
    class Noteview(itemView:View):RecyclerView.ViewHolder(itemView){

        val notessubject:TextView=itemView.findViewById(R.id.notessubject)
        val encrpytnote:TextView=itemView.findViewById(R.id.encrptnote)
        val decrpytnote: EditText =itemView.findViewById(R.id.decrptnote)
        val enternote: Button =itemView.findViewById(R.id.enternote)
        val originalnote:TextView=itemView.findViewById(R.id.originalnote)

    }
}
private fun decrypto(s1: String, js: String): String? {
    // TODO Auto-generated method stub
    val j = js.toIntOrNull()
    var s5: String? = ""
    for (i in 0 until s1.length) {
        val a = s1[i]
        val v = a.toInt()
        val k = v - j!!
        val d = k.toChar()
        s5 += d
    }
    return s5
}