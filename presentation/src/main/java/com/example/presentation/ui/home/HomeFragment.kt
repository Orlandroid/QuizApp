package com.example.presentation.ui.home

import androidx.navigation.fragment.findNavController
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.extensions.click


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {


    override fun setUpUi() {
        binding.btnStartQuiz.click {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQuestionViewFragment())
        }
    }


}