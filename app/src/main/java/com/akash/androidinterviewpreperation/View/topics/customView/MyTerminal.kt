package com.akash.androidinterviewpreperation.View.topics.customView


import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.setPadding
import com.akash.androidinterviewpreperation.R
import com.akash.androidinterviewpreperation.Utils.dp
import com.akash.androidinterviewpreperation.Utils.sp


class MyTerminal(context: Context) : AppCompatTextView(context) {


    init {

        val typeface = ResourcesCompat.getFont(context, R.font.terminal_font)
        setTypeface(typeface)
        setPadding(20.dp)
        textSize = 20.sp
        setBackgroundColor(Color.parseColor("#000000"))
        setTextColor(Color.GREEN)
    }

    val inputList = mutableListOf<String>()


    constructor(context: Context,attr: AttributeSet?) : this(context)
    constructor(context: Context,attr: AttributeSet?,defStyleAttr:Int) : this(context,attr)






    fun println(line:String = ""){
        inputList.add(line+"\n")
        val builder = StringBuilder()
        inputList.forEach {
            builder.append(it)
        }
        text = builder
        invalidate()
    }






}