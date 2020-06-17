package com.leandroid.formula1.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import androidx.annotation.IdRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.leandroid.formula1.R
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

class NavigationBottomView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    val selectedButton: BehaviorSubject<Section> = BehaviorSubject.create()

    private val homeButton by lazy<RelativeLayout> { findViewById(R.id.navigation_bottom_home) }
    private val raceButton by lazy<RelativeLayout> { findViewById(R.id.navigation_bottom_race) }
    private val championButton by lazy<RelativeLayout> { findViewById(R.id.navigation_bottom_champion) }
    private val moreButton by lazy<RelativeLayout> { findViewById(R.id.navigation_bottom_more) }

    enum class Section(@IdRes val viewId: Int) {
        HOME(R.id.navigation_bottom_home),
        RACE(R.id.navigation_bottom_race),
        CHAMPION(R.id.navigation_bottom_champion),
        MORE(R.id.navigation_bottom_more)
    }

    init {
        inflate(context, R.layout.widget_navigation_bottom, this)
        select(Section.HOME)
        selectButton()
    }

    private fun select(section: Section) {
        selectedButton.onNext(section)
    }

    private fun selectButton() {
        homeButton.setOnClickListener {select(Section.HOME)}
        raceButton.setOnClickListener {select(Section.RACE)}
        championButton.setOnClickListener {select(Section.CHAMPION)}
        moreButton.setOnClickListener {select(Section.MORE)}
    }
}