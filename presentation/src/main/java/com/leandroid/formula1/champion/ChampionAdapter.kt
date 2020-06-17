package com.leandroid.formula1.champion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.domain.model.Champion
import com.leandroid.formula1.R
import com.leandroid.formula1.widget.CardCommomView

class ChampionAdapter (var champions: List<Champion>)
    : RecyclerView.Adapter<ChampionAdapter.ChampionViewHolder>() {

    override fun getItemCount(): Int {
        return champions.size
    }

    override fun onBindViewHolder(championViewHolder: ChampionViewHolder, i: Int) {
        val card = championViewHolder.vCardCommomView
        champions[i].name?.let { card.setName(it) }
        champions[i].photo?.let { card.setImage(it) }
        champions[i].year?.let { card.setYear(it) }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ChampionViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.champion_item, viewGroup, false)
        return ChampionViewHolder(itemView)
    }

    class ChampionViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var vCardCommomView: CardCommomView
        init {
            vCardCommomView = v.findViewById(R.id.ccv_champion)
        }
    }
}