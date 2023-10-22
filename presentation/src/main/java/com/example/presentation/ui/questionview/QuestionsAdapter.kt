package com.example.presentation.ui.questionview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.local.Answer
import com.example.presentation.databinding.ItemAnswerBinding
import com.example.presentation.extensions.click


class QuestionsAdapter(private val clickOnUser: (Answer) -> Unit) :
    RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {

    private var listOfAnswers: List<Answer> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(lista: List<Answer>) {
        listOfAnswers = lista
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemAnswerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Answer, clickOnAnswer: (Answer) -> Unit) = with(binding) {
            root.click {
                clickOnAnswer(question)
            }
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
