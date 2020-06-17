package com.leandroid.formula1.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.leandroid.formula1.R


class CardCommomView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val nameView by lazy<TextView> { findViewById(R.id.tv_name) }
    private val yearView by lazy<TextView> { findViewById(R.id.tv_year) }
    private val pictureView by lazy<ImageView> { findViewById(R.id.iv_picture) }

    init {
        inflate(context, R.layout.widget_card_commom_view, this)
    }

    fun setName(name: String) {
        nameView.text = name
    }

    fun setYear(year: String) {
        yearView.text = year
    }

    fun setImage(picutre: String) {
        Glide.with(context)
            .load(picutre)
            .centerCrop()
            .placeholder(R.color.placeholderPicture)
            .into(pictureView)
    }
}