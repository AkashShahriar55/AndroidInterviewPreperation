package com.akash.androidinterviewpreperation.Model.Repositories

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

class FlowPageRepository {

    //create a flow from a fixed set of values.
    val colors = flowOf("Red","Green","Blue","White")

    //types to convert them into flows.
    val list = listOf(1,2,3,4,5,6).asFlow()

    //to construct arbitrary flows from sequential calls to emit function.
    val names = flow<String> {
        emit("Joe")
        emit("Smith")
        emit("Neymar")
    }



    //to construct arbitrary flows from potentially concurrent calls to the send function.
    val days = channelFlow<String> {
        send("Sunday")
        send("Monday")
        send("Tuesday")
    }


    val isTrue = MutableStateFlow(true)

    val isReallyTrue = MutableSharedFlow<Boolean>(0,100, BufferOverflow.DROP_LATEST)


    fun numbersFlow(): Flow<Int> = flow {
        // code inside flow can suspend!
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    } // the function numbersFlow() itself does not suspend
}