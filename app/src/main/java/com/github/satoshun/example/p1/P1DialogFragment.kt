package com.github.satoshun.example.p1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.satoshun.example.databinding.DialogActBinding
import com.github.satoshun.example.databinding.P1DialogFragmentBinding

class P1DialogFragment : DialogFragment() {
  private lateinit var binding: P1DialogFragmentBinding

  private val dialogViewModel: P1DialogFragmentViewModel by activityViewModels()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    binding = P1DialogFragmentBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    binding.finish.setOnClickListener {
      dialogViewModel.sendData(P1DialogFragmentData.Click)
      dismiss()
    }
  }
}

sealed class P1DialogFragmentData {
  object Click : P1DialogFragmentData()
}

class P1DialogFragmentViewModel : ViewModel() {
  val data = MutableLiveData<P1DialogFragmentData>()

  fun sendData(data: P1DialogFragmentData) {
    this.data.value = data
  }
}
