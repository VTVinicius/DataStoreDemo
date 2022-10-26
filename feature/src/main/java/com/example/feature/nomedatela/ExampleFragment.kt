package com.example.feature.nomedatela

import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner
import base_feature.core.BaseFragment
import com.example.feature.databinding.FragmentExampleBinding
import kotlinx.coroutines.Job
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExampleFragment : BaseFragment<FragmentExampleBinding>() {

    private val viewModel: ExampleViewModel by viewModel()
//    private val navigation: ExampleNavigation by navDirections()

    var job: Job? = null

    override fun onCreateViewBinding(inflater: LayoutInflater): FragmentExampleBinding =
        FragmentExampleBinding.inflate(inflater)

    override fun setupView() {
        super.setupView()

        binding.button.setOnClickListener {
            saveValues()
        }

    }

    override fun addObservers(owner: LifecycleOwner) {
        super.addObservers(owner)
        exampleObserver(owner)
    }

    private fun exampleObserver(owner: LifecycleOwner) {
        viewModel.getNameViewState.onPostValue(owner,
            onSuccess = {
                binding.textView.text = it
            },
            onError = {
                showErrorDialog()
            }
        )
        viewModel.getAgeViewState.onPostValue(owner,
            onSuccess = {
                binding.textView2.text = it.toString()
            },
            onError = {
                showErrorDialog()
            }
        )
    }


    fun saveValues() {
        viewModel.saveName(
            if (binding.editText.text.toString()
                    .isNullOrEmpty()
            ) " " else binding.editText.text.toString()
        )
        viewModel.saveAge(
            if (binding.editText2.text.toString()
                    .isNullOrEmpty()
            ) 0 else binding.editText2.text.toString().toInt()
        )
    }
}
