package com.github.satoshun.example.p1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.observe
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.DialogActBinding

class DialogP1Activity : AppCompatActivity() {
  private lateinit var binding: DialogActBinding

  private val dialogViewModel: P1DialogFragmentViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.dialog_act)

    binding.start.setOnClickListener {
      P1DialogFragment()
        .show(supportFragmentManager, "p1")
    }

    dialogViewModel.data.observe(this) {
      when {
        it.tag == "p1" -> {
          Toast.makeText(this@DialogP1Activity, "p1", Toast.LENGTH_LONG).show()
        }
      }
    }
  }
}
