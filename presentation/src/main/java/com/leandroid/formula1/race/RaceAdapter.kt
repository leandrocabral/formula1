package com.leandroid.formula1.race

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.domain.model.Race
import com.leandroid.formula1.R
import com.leandroid.formula1.widget.CardCommomView

class RaceAdapter (var races: List<Race>)
    : RecyclerView.Adapter<RaceAdapter.RaceViewHolder>() {

    override fun getItemCount(): Int {
        return races.size
    }

    override fun onBindViewHolder(raceViewHolder: RaceViewHolder, i: Int) {
        val card = raceViewHolder.vCardCommomView
        races[i].name?.let { card.setName(it) }
        races[i].flag?.let { card.setImage(it) }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RaceViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.race_item, viewGroup, false)
        return RaceViewHolder(itemView)
    }

    class RaceViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vCardCommomView: CardCommomView
        init {
            vCardCommomView = v.findViewById(R.id.ccv_race)

        }
    }
}