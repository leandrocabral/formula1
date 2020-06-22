package com.leandroid.formula1.more

import android.bluetooth.BluetoothClass.Service.INFORMATION
import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.leandroid.domain.model.Information
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.MoreFragmentBinding
import com.leandroid.formula1.databinding.RaceFragmentBinding
import com.leandroid.formula1.information.InfoActivity
import com.leandroid.formula1.race.RaceViewModel
import com.leandroid.formula1.widget.NavigationBottomView

class MoreFragment : Fragment() {

    private lateinit var binding: MoreFragmentBinding
    private val viewModel: MoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.more_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAbout.setOnClickListener {
              val intent = Intent(activity, InfoActivity::class.java)
              intent.putExtra("information", Information.ABOUT)
              startActivity(intent)
        }

        binding.buttonPrivacyPolicy.setOnClickListener {
              val intent = Intent(activity, InfoActivity::class.java)
              intent.putExtra("information", Information.PRIVACYPOLICY)
              startActivity(intent)
        }

        binding.buttonTermOfUse.setOnClickListener {
            val intent = Intent(activity, InfoActivity::class.java)
            intent.putExtra("information", Information.TERMOFUSE)
            startActivity(intent)
        }
    }
}