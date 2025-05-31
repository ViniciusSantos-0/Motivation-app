package com.example.motivation.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.motivation.databinding.ActivitySplash2Binding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences


@SuppressLint("CustomSplashScreen")
class SplashActivity2 : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivitySplash2Binding
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplash2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)

        binding.buttonSave.setOnClickListener(this)

        verifyName()
    }

    override fun onClick(v: View) {
        if (v.id == binding.buttonSave.id) {
            handleSave()
        }
    }

    private fun verifyName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        Log.d("SplashCheck", "Name saved: '$name'")
        if (name.isNotEmpty()) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }


    private fun handleSave() {
        val name = binding.editName.text.toString()
        if (name.isNotBlank()) {
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME, name)
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, "Please, type your name", Toast.LENGTH_LONG).show()
        }
    }
}
