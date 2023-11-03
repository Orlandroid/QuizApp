package com.example.presentation.ui.raking

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entities.local.Score
import com.example.presentation.R
import com.example.presentation.databinding.ItemAnswerBinding
import com.example.presentation.extensions.changeBackgroundColor
import com.example.presentation.extensions.changeTextColor


class RakingAdapter : RecyclerView.Adapter<RakingAdapter.ViewHolder>() {

    private var listOfAnswers: List<Score> = arrayListOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(list: List<Score>) {
        listOfAnswers = list
        notifyDataSetChanged()
    }

    fun getItems() = listOfAnswers

    class ViewHolder(private val binding: ItemAnswerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(score: Score) = with(binding) {
            binding.question.changeBackgroundColor(R.color.background)
            binding.question.changeTextColor(R.color.black)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAnswerBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listOfAnswers[position])
    }

    override fun getItemCount() = listOfAnswers.size


}
