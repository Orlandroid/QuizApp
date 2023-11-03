package com.example.presentation.ui.raking

import androidx.fragment.app.viewModels
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentRankingBinding
import com.example.presentation.extensions.observeApiResult
import com.example.presentation.ui.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RankingFragment : BaseFragment<FragmentRankingBinding>(R.layout.fragment_ranking) {

    override fun configureToolbar() = MainActivity.ToolbarConfiguration(
        showToolbar = true, toolbarTitle = getString(R.string.puntuaci_nes)
    )

    private val viewModel: RankingViewModel by viewModels()

    private val adapter = RakingAdapter()
    override fun setUpUi() {
        binding.recycler.adapter = adapter
    }

    override fun observerViewModel() {
        super.observerViewModel()
        observeApiResult(viewModel.scoreList) {
            adapter.setData(it)
        }
    }
}