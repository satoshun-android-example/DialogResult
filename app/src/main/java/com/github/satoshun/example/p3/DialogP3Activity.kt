package com.github.satoshun.example.p3

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.github.satoshun.example.R
import com.github.satoshun.example.databinding.Dialog3ActBinding

// not working case when re-create Activity
class DialogP3Activity : AppCompatActivity() {
  private lateinit var binding: Dialog3ActBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.dialog3_act)
  }
}

fun DialogFragment.show(activity: AppCompatActivity, tag: String, body: () -> Unit) {
  val dialogViewModel: P3DialogFragmentViewModel by activity.viewModels()
  dialogViewModel.data.observeUnhandledEvent(this) {
    if (it.tag == tag) body()
  }

  show(activity.supportFragmentManager, tag)
}
