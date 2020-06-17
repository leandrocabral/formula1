package com.leandroid.formula1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.leandroid.formula1.champion.ChampionFragment
import com.leandroid.formula1.databinding.MainActivityBinding
import com.leandroid.formula1.home.HomeFragment
import com.leandroid.formula1.more.MoreFragment
import com.leandroid.formula1.race.RaceFragment
import com.leandroid.formula1.widget.NavigationBottomView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity)

        binding.navigationBottom.selectedButton.doOnNext {section->
            navigateToSection(section)
        }.doOnError {
            Toast.makeText(this, "Erro ao trocar de Fragment", Toast.LENGTH_LONG).show()
        }.subscribe()
    }

    private fun navigateToSection(section: NavigationBottomView.Section) {
        val selectedSectionFragment: Fragment = when (section) {
            NavigationBottomView.Section.HOME -> HomeFragment()
            NavigationBottomView.Section.RACE -> RaceFragment()
            NavigationBottomView.Section.CHAMPION -> ChampionFragment()
            NavigationBottomView.Section.MORE -> MoreFragment()
        }

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_main, selectedSectionFragment)
            .addToBackStack(selectedSectionFragment::class.java.simpleName)
            .commit()
    }
}