package com.leandroid.formula1.widget.cardTableView

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.domain.model.Pilot
import com.leandroid.formula1.R

class CardTableView
@JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val recList by lazy<RecyclerView> { findViewById(R.id.rv_card_table) }

    init {
        inflate(context, R.layout.widget_card_table, this)
    }

    fun mountList(pilots: List<Pilot>) {
        recList.setHasFixedSize(true)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recList.layoutManager = llm

        val adapter = CardTableViewAdapter(pilots)
        recList.adapter = adapter
    }
}
