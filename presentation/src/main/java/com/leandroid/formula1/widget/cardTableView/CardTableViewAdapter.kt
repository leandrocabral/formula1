package com.leandroid.formula1.widget.cardTableView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.leandroid.domain.model.Pilot
import com.leandroid.formula1.R

class CardTableViewAdapter(var pilots: List<Pilot>) :
    RecyclerView.Adapter<CardTableViewAdapter.CardTableViewHolder>() {

    override fun getItemCount(): Int {
        return pilots.size
    }

    override fun onBindViewHolder(cardTableViewHolder: CardTableViewHolder, i: Int) {
        val position = cardTableViewHolder.vPosition
        val name = cardTableViewHolder.vDescricao
        val point = cardTableViewHolder.vPoint
        val team = cardTableViewHolder.vTeam

        position.text =  "${pilots[i].id} º"
        name.text = pilots[i].name
        point.text = pilots[i].point.toString()
        team.text = pilots[i].team

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): CardTableViewHolder {
        val itemView: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.widget_card_table_item, viewGroup, false)
        return CardTableViewHolder(itemView)
    }

    class CardTableViewHolder(v: View) : ViewHolder(v) {
        var vPosition: TextView
        var vDescricao: TextView
        var vPoint: TextView
        var vTeam: TextView

        init {
            vPosition = v.findViewById(R.id.tv_position)
            vDescricao = v.findViewById(R.id.tv_name)
            vTeam = v.findViewById(R.id.tv_team)
            vPoint = v.findViewById(R.id.tv_point)
        }
    }
}