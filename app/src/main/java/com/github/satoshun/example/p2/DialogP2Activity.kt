package com.github.satoshun.example.p2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.observe
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.DialogActBinding

class DialogP2Activity : AppCompatActivity() {
  private lateinit var binding: DialogActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.dialog_act)

    binding.start.setOnClickListener {
      P2DialogFragment().show(this, "p1") {
        Toast.makeText(this@DialogP2Activity, "p1", Toast.LENGTH_LONG).show()
      }
    }
  }
}

fun DialogFragment.show(activity: AppCompatActivity, tag: String, body: () -> Unit) {
  val dialogViewModel: P2DialogFragmentViewModel by activity.viewModels()
  dialogViewModel.data.observe(this) {
    if (it.tag == tag) body()
  }

  show(activity.supportFragmentManager, tag)
}
