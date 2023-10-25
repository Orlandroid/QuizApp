package com.example.presentation.ui.score

import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentScoreViewBinding
import com.example.presentation.extensions.click
import com.example.presentation.ui.questionview.QuestionsViewModel


class ScoreViewFragment : BaseFragment<FragmentScoreViewBinding>(R.layout.fragment_score_view) {

    private val viewModel: QuestionsViewModel by navGraphViewModels(R.id.main_navigation) {
        defaultViewModelProviderFactory
    }

    override fun setUpUi() {
        binding.user = viewModel.user
        binding.button.click {
            findNavController().popBackStack(R.id.homeFragment, false)
        }
    }

}