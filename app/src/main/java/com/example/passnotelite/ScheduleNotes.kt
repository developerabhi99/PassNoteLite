package com.example.passnotelite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_schedule_notes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class ScheduleNotes : AppCompatActivity() {
    val db by lazy {
        AppDatabase.getDatabase(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_notes)

        savesnotes.setOnClickListener {
            savenote()
        }
    }

    private fun savenote() {
       val subject:String =namesubject.text.toString()
        val notee:String=notepass.text.toString()
        val notecodee:String=notecode.text.toString()
        val encrpytnote= encrypto(notee,notecodee)
       if(!subject.isEmpty() && !notee.isEmpty() && !notecodee.isEmpty()){
           GlobalScope.launch (Dispatchers.Main){
               val uid= withContext(Dispatchers.IO){
                   db.notedao().insertnote(
                       UserNote(
                           subject,
                           encrpytnote!!
                       )
                   )
               }
               finish()
           }
       }else{
          namesubject.error="Enter the Subject name"
           namesubject.requestFocus()
           notepass.error="Enter the password"
           notepass.requestFocus()
           notecode.error="Enter the code"
           notecode.requestFocus()
       }



    }
}
private fun encrypto(s: String, js: String): String? {
    val j = js.toIntOrNull()
    var s1: String? = ""
    for (i in 0 until s.length) {
        val a = s[i]
        val v = a.toInt()
        val k = v + j!!
        val d = k.toChar()
        s1 += d
    }
    //System.out.println(s1);
    return s1
}