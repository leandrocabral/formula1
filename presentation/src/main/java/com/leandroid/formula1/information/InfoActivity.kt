package com.leandroid.formula1.information

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.leandroid.domain.model.Information
import com.leandroid.formula1.R
import com.leandroid.formula1.databinding.InfoActivityBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.viewmodel.ext.android.viewModel


class InfoActivity : AppCompatActivity() {

    private lateinit var binding: InfoActivityBinding
    private val viewModel: InfoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.info_activity)

        val information: Information = intent.getSerializableExtra("information") as Information

        when (information) {
            Information.ABOUT -> {
                viewModel.getAbout()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess { about ->
                        init(about.title, about.content)
                    }.doOnError {

                    }.subscribe()
            }
            Information.TERMOFUSE -> {
                viewModel.getTermOfUse()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess { termOfUse ->
                        init(termOfUse.title, termOfUse.content)
                    }.doOnError {

                    }.subscribe()
            }
            Information.PRIVACYPOLICY -> {
                viewModel.getPrivacyPolicy()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSuccess { privacyPolicy ->
                        init(privacyPolicy.title, privacyPolicy.content)
                    }.doOnError {

                    }.subscribe()
            }
        }
    }

    fun init(title: String?, content: String?) {
        binding.tvInfoTitle.text = title
        binding.tvInfoContent.text = content
    }
}