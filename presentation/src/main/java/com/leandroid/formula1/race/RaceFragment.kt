package com.leandroid.formula1.race

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.domain.model.Race
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.RaceFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.ext.android.viewModel

class RaceFragment : Fragment() {

    private lateinit var binding: RaceFragmentBinding
    private val viewModel: RaceViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.race_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getRace()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSuccess { races ->
                mountList(races)
            }.doOnError { error ->

            }.subscribe()

    }

    fun mountList(races: List<Race>) {
        binding.recRace.setHasFixedSize(true)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.recRace.layoutManager = llm

        val adapter = RaceAdapter(races)
        binding.recRace.adapter = adapter
    }
}