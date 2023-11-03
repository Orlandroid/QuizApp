package com.example.presentation.ui.raking

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.Repository
import com.example.data.di.CoroutineDispatchers
import com.example.domain.entities.local.Score
import com.example.presentation.base.BaseViewModel
import com.example.presentation.helpers.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import com.example.domain.state.Result


@HiltViewModel
class RankingViewModel @Inject constructor(
    private val repository: Repository,
    coroutineDispatchers: CoroutineDispatchers,
    networkHelper: NetworkHelper
) : BaseViewModel(coroutineDispatchers, networkHelper) {

    private val _scoreList = MutableLiveData<Result<List<Score>>>()
    val scoreList = _scoreList

    private val _saveScore = MutableLiveData<Result<Long>>()
    val saveScore = _saveScore

    init {
        getAllScores()
    }

    private fun getAllScores() {
        viewModelScope.launch {
            safeApiCall(_scoreList, coroutineDispatchers) {
                val response = repository.getAllScore()
                withContext(Dispatchers.Main) {
                    _scoreList.value = Result.Success(response)
                }
            }
        }
    }

    fun saveScore(score: Score) {
        viewModelScope.launch {
            safeApiCall(_saveScore, coroutineDispatchers) {
                val response = repository.saveScore(score)
                withContext(Dispatchers.Main) {
                    _saveScore.value = Result.Success(response)
                }
            }
        }
    }


}