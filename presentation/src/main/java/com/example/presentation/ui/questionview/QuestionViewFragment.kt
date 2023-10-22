package com.example.presentation.ui.questionview

import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentQuestionViewBinding
import com.example.presentation.extensions.countDown
import com.example.presentation.providers.QuestionsProvider


class QuestionViewFragment :
    BaseFragment<FragmentQuestionViewBinding>(R.layout.fragment_question_view) {

    private val questionsProvider = QuestionsProvider()
    private val currentQuestions = 1
    override fun setUpUi() {
        countDown(onFinish = {}) {
            binding.tvTimer.text = it.toString()
        }
    }

}