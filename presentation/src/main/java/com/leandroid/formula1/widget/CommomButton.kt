package com.leandroid.formula1.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.getDrawableOrThrow
import androidx.core.content.res.getStringOrThrow
import androidx.core.content.withStyledAttributes
import com.leandroid.formula1.R

class CommomButton
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val titleView by lazy<TextView> { findViewById(R.id.tv_title) }

    init {
        inflate(context, R.layout.widget_commom_button, this)
        applyAttributes(attrs, defStyleAttr)
    }

    private fun applyAttributes(attrs: AttributeSet?, defStyleAttr: Int) {
        context.withStyledAttributes(attrs, R.styleable.CommomButton, defStyleAttr) {
            titleView.text = getStringOrThrow(R.styleable.CommomButton_commom_button_description)
        }
    }

}