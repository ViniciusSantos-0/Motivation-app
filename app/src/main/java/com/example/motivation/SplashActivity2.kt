package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_splash2.*

class SplashActivity2 : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        buttonSave.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if(id == R.id.buttonSave){
            handSave()
        }
    }
    private fun handSave(){
        val name = editName.text.toString()
        if(name != ""){
            startActivity(Intent(this,MainActivity::class.java))
        }else{
            Toast.makeText(this,"Por gentileza, digite seu nome",Toast.LENGTH_LONG).show()
        }
    }
}