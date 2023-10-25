package com.example.presentation.ui.questionview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.local.Answer
import com.example.presentation.R
import com.example.presentation.databinding.ItemAnswerBinding
import com.example.presentation.extensions.changeBackgroundColor
import com.example.presentation.extensions.changeTextColor
import com.example.presentation.extensions.click


class AnswersAdapter(private val clickOnUser: (Answer) -> Unit) :
    RecyclerView.Adapter<AnswersAdapter.ViewHolder>() {

    private var listOfAnswers: List<Answer> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(lista: List<Answer>) {
        listOfAnswers = lista
        notifyDataSetChanged()
    }

    fun getItems() = listOfAnswers


    class ViewHolder(private val binding: ItemAnswerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Answer, clickOnAnswer: (Answer) -> Unit) = with(binding) {
            binding.question.changeBackgroundColor(R.color.background)
            binding.question.changeTextColor(R.color.black)
            question.isCorrectAnswer?.let {
                val colorAnswer = if (it) {
                    R.color.green_color
                } else {
                    R.color.red_color
                }
                binding.question.changeTextColor()
                binding.question.changeBackgroundColor(colorAnswer)
            }
            root.click {
                clickOnAnswer(question)
            }
            binding.question.text = question.answer
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnswerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfAnswers[position], clickOnUser)
    }

    override fun getItemCount(): Int {
        return listOfAnswers.size
    }


}
