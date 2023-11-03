package com.example.presentation.ui.score

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.domain.entities.local.Score
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentScoreViewBinding
import com.example.presentation.extensions.click
import com.example.presentation.ui.MainActivity
import com.example.presentation.ui.questionview.QuestionsViewModel
import com.example.presentation.ui.raking.RankingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScoreViewFragment : BaseFragment<FragmentScoreViewBinding>(R.layout.fragment_score_view) {

    private val viewModel: QuestionsViewModel by navGraphViewModels(R.id.main_navigation) {
        defaultViewModelProviderFactory
    }

    private val rankingViewModel: RankingViewModel by viewModels()

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true, toolbarTitle = getString(R.string.puntaje)
    )

    override fun setUpUi() {
        rankingViewModel.saveScore(
            Score(
                name = viewModel.user.name,
                puntuacion = viewModel.user.score
            )
        )
        binding.user = viewModel.user
        binding.buttonRaking.click {
            findNavController().navigate(ScoreViewFragmentDirections.actionScoreViewFragmentToRankingFragment())
        }
    }

}