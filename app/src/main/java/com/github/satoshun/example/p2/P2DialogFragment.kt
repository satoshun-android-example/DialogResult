package com.github.satoshun.example.p2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.satoshun.example.databinding.P1DialogFragmentBinding

class P2DialogFragment : DialogFragment() {
  private lateinit var binding: P1DialogFragmentBinding

  private val dialogViewModel: P2DialogFragmentViewModel by activityViewModels()

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
      dialogViewModel.sendData(P2DialogFragmentData.Click(tag))
      dismiss()
    }
  }
}

sealed class P2DialogFragmentData(val tag: String?) {
  class Click(tag: String?) : P2DialogFragmentData(tag)
}

class P2DialogFragmentViewModel : ViewModel() {
  val data = MutableLiveData<Event<P2DialogFragmentData>>()

  fun sendData(data: P2DialogFragmentData) {
    this.data.value = Event(data)
  }
}
