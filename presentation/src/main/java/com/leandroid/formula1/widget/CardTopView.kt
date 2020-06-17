package com.leandroid.formula1.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.leandroid.formula1.R

class CardTopView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val titleView by lazy<TextView> { findViewById(R.id.tv_title) }
    private val nameView by lazy<TextView> { findViewById(R.id.tv_name) }
    private val pointView by lazy<TextView> { findViewById(R.id.tv_point) }
    private val pictureView by lazy<ImageView> { findViewById(R.id.iv_picture) }

    init {
        inflate(context, R.layout.widget_card_top, this)
    }

    fun setTitle(title: String?) {
        titleView.text = title
    }

    fun setName(name: String?) {
        nameView.text = name
    }

    fun setPoint(point: String?) {
        pointView.text = point
    }

    fun setImage(picture: String?) {
        Glide
            .with(context)
            .load(picture)
            .centerCrop()
            .placeholder(R.color.placeholderPicture)
            .into(pictureView)
    }

}