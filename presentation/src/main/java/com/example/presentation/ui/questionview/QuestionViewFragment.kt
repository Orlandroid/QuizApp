package com.example.presentation.ui.questionview

import android.annotation.SuppressLint
import android.os.CountDownTimer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.domain.entities.local.Answer
import com.example.presentation.R
import com.example.presentation.base.BaseFragment
import com.example.presentation.databinding.FragmentQuestionViewBinding
import com.example.presentation.extensions.click
import com.example.presentation.extensions.countDown
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

    companion object {
        const val FINAL_QUESTION = 9
    }

    override fun setUpUi() {
        binding.recyclerView.adapter = answersAdapter
        binding.btnBack.click {
            timer?.cancel()
            findNavController().popBackStack()
        }
        setDataCurrentQuestion(currentQuestion)
        doCountDown()
    }

    private fun onFinishTimeForCurrentQuestion() {
        if (currentQuestion == FINAL_QUESTION) {
            //go to scoreView
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

    private fun checkAnswer(answer: Answer) {
        if (answer.id == questions[currentQuestion].correctAnswerId) {
            setCorrectAnswer(answer.id)
        } else {
            showCorrectAndWrongQuestion(
                idCorrectAnswer = questions[currentQuestion].correctAnswerId,
                idWrongAnswer = answer.id
            )
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