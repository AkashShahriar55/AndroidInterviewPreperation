package com.akash.androidinterviewpreperation.ViewModel

import androidx.lifecycle.ViewModel
import com.akash.androidinterviewpreperation.Model.Repositories.FlowPageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class  FlowViewModel @Inject constructor(private val flowPageRepository: FlowPageRepository): ViewModel() {



    fun collectFlowWithFlowBlock(): Flow<Int> {
        return flowPageRepository.numbersFlow()
    }
}