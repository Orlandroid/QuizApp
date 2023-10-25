package com.example.presentation.ui.questionview

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.domain.entities.local.Answer
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentQuestionViewBinding
import com.example.presentation.extensions.click
import com.example.presentation.extensions.countDown
import com.example.presentation.extensions.onBackGesture
import com.example.presentation.providers.QuestionsProvider
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds


class QuestionViewFragment :
    BaseFragment<FragmentQuestionViewBinding>(R.layout.fragment_question_view) {

    private val questionsProvider = QuestionsProvider()
    private var currentQuestion = 0
    private val answersAdapter = AnswersAdapter { clickOnAnswer(it) }
    private val questions by lazy {
        questionsProvider.getTeenRandomsQuestions()
    }
    private var timer: CountDownTimer? = null
    private var score = 0
    private val viewModel: QuestionsViewModel by navGraphViewModels(R.id.main_navigation) {
        defaultViewModelProviderFactory
    }

    companion object {
        const val FINAL_QUESTION = 9
    }

    override fun setUpUi() {
        binding.recyclerView.adapter = answersAdapter
        binding.btnBack.click {
            timer?.cancel()
            findNavController().popBackStack()
        }
        onBackGesture {
            timer?.cancel()
        }
        setDataCurrentQuestion(currentQuestion)
        doCountDown()
    }

    private fun onFinishTimeForCurrentQuestion() {
        if (currentQuestion == FINAL_QUESTION) {
            viewModel.user.score = score
            findNavController().navigate(
                QuestionViewFragmentDirections.actionQuestionViewFragmentToScoreViewFragment()
            )
            return
        }
        currentQuestion++
        setDataCurrentQuestion(currentQuestion)
        doCountDown()

    }

    private fun onEachSecond(second: Int) {
        binding.tvTimer.text = second.toString()
    }

    private fun setDataCurrentQuestion(currentQuestion: Int) {
        with(binding) {
            questions[currentQuestion].let { currentQuestion ->
                answersAdapter.setData(currentQuestion.answers)
                imageQuestions.setImageResource(currentQuestion.backgroundQuestions)
                tvQuestion.text = currentQuestion.question
            }
        }
    }

    private fun doCountDown() {
        timer = countDown(onFinish = {
            onFinishTimeForCurrentQuestion()
        }, onMyTick = {
            onEachSecond(it)
        })
    }

    private fun clickOnAnswer(answer: Answer) {
        lifecycleScope.launch {
            checkAnswer(answer)
            timer?.cancel()
            delay(1.seconds)
            onFinishTimeForCurrentQuestion()
        }
    }

    private fun checkAnswer(answerUser: Answer) {
        questions[currentQuestion].correctAnswerId.let { correctIdAnswer ->
            if (answerUser.id == correctIdAnswer) {
                score++
                setCorrectAnswer(answerUser.id)
            } else {
                showCorrectAndWrongQuestion(
                    idCorrectAnswer = correctIdAnswer, idWrongAnswer = answerUser.id
                )
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setCorrectAnswer(idCorrectAnswer: Int) {
        answersAdapter.getItems().forEach {
            if (it.id == idCorrectAnswer) {
                it.isCorrectAnswer = true
            }
            answersAdapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun showCorrectAndWrongQuestion(idCorrectAnswer: Int, idWrongAnswer: Int) {
        answersAdapter.getItems().forEach {
            if (it.id == idCorrectAnswer) {
                it.isCorrectAnswer = true
            }
            if (it.id == idWrongAnswer) {
                it.isCorrectAnswer = false
            }
        }
        answersAdapter.notifyDataSetChanged()
    }


}