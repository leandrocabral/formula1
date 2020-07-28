package com.leandroid.formula1.info

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.InfoActivityBinding
import org.koin.android.viewmodel.ext.android.viewModel


class InfoActivity : AppCompatActivity() {

    private val viewModel: InfoViewModel by viewModel()
    private lateinit var binding: InfoActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.info_activity)

        val type = intent.getStringExtra("INFO_TYPE")

        viewModel.getInfo(type)

        viewModel.infoLiveData.observe(this, Observer { info ->
            binding.titleInfo.text = info.title
            binding.contentInfo.text = info.content
        })
    }
}