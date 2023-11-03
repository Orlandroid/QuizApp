package com.example.presentation.ui.home

import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.domain.entities.local.User
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.extensions.click
import com.example.presentation.ui.questionview.QuestionsViewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {


    private val viewModel: QuestionsViewModel by navGraphViewModels(R.id.main_navigation) {
        defaultViewModelProviderFactory
    }

    override fun setUpUi() {
        viewModel.user = User()
        binding.btnStartQuiz.click {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToQuestionViewFragment())
        }
        binding.tvName.doOnTextChanged { text, _, _, _ ->
            viewModel.user.name = text.toString().trim()
        }
        binding.imageButton.click {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToRankingFragment())
        }
    }


}