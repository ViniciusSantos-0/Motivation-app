package com.example.motivation.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.repository.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mSecurityPreferences: SecurityPreferences
    private val mock = Mock()
    private var mPhraseFilter: Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSecurityPreferences = SecurityPreferences(this)
        showUserName()
        setListeners()
        handleNewPhrase()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == binding.buttonPhrase.id) {
            handleNewPhrase()
        } else {
            handleFilter(id)
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showUserName() {
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        binding.textNameMain.text = "Hi, $name"
    }

    private fun setListeners() {
        binding.buttonPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSun.setOnClickListener(this)
    }

    private fun handleFilter(id: Int) {
        val white = ContextCompat.getColor(this, R.color.white)
        val pink = ContextCompat.getColor(this, R.color.pink)

        binding.imageAll.setColorFilter(white)
        binding.imageSun.setColorFilter(white)
        binding.imageHappy.setColorFilter(white)

        when (id) {
            binding.imageAll.id -> {
                binding.imageAll.setColorFilter(pink)
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL
            }

            binding.imageHappy.id -> {
                binding.imageHappy.setColorFilter(pink)
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }

            binding.imageSun.id -> {
                binding.imageSun.setColorFilter(pink)
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }
        }
    }

    private fun handleNewPhrase() {
        binding.textPhrase.text = mock.getPhrase(mPhraseFilter)
    }
}
