package com.example.passnotelite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_schedule_password.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SchedulePassword : AppCompatActivity() {
    val db by lazy {
        AppDatabase.getDatabase(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_password)


        savespass.setOnClickListener {


            savetask()


        }
    }

    private fun savetask() {
        val nameappp:String=nameapp.text.toString()
        val apppasss:String=apppass.text.toString()
        val passcodee:String=passcode.text.toString()
        val encrpyt:String?=encrypto(apppasss,passcodee)
        if(!nameappp.isEmpty() && !apppasss.isEmpty() && !passcodee.isEmpty()){
            GlobalScope.launch (Dispatchers.Main){
                val id = withContext(Dispatchers.IO){
                    return@withContext db.appdao().insertpass(
                        UserPass(
                            nameappp,
                            encrpyt!!
                        )
                    )
                }
                finish()
            }
        }else{
            nameapp.error="Enter the App name"
            nameapp.requestFocus()
            apppass.error="Enter the password"
            apppass.requestFocus()
            passcode.error="Enter the code"
            passcode.requestFocus()
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
}