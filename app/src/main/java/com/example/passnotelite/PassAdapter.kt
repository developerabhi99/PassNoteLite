package com.example.passnotelite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_pass.view.*
import kotlin.random.Random

class PassAdapter(val userlist: List<UserPass>):RecyclerView.Adapter<PassAdapter.PassViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PassViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.item_pass,parent,false)
        return PassViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PassViewHolder, position: Int) {
        val currentitem=userlist[position]
           holder.fireappname.text=currentitem.appname
           holder.fireepass.text=currentitem.pass

            holder.enter.setOnClickListener {

            holder.pass3.requestFocus()
            val fix=holder.decrpt.text.toString()
            if(fix.isEmpty()){
                holder.decrpt.error="Enter the Code in Number Only"
                holder.decrpt.requestFocus()

            }else{
                val s= decrypto(currentitem.pass.toString(),fix)
                holder.pass3.text=s.toString()
            }

        }


        with(holder.itemView){
            val colors = resources.getIntArray(R.array.random_color)
            val randomColor = colors[Random.nextInt(colors.size)]
            viewColorTag1.setBackgroundColor(randomColor)
        }

    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    override fun getItemId(position: Int):Long{
        return userlist[position].id
    }

    class PassViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val enter:Button=itemView.findViewById(R.id.enter)
        val pass3: TextView =itemView.findViewById(R.id.firepass)
        val fireappname: TextView =itemView.findViewById(R.id.fireappname)
        val  fireepass: TextView =itemView.findViewById(R.id.fireepass)
        val decrpt: EditText =itemView.findViewById(R.id.decrpt)




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
