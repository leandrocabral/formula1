package com.leandroid.formula1.presentation.race

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.leandroid.data.network.service.ChampionService
import com.leandroid.domain.model.Champion
import com.leandroid.formula1.CoroutineTestRule
import com.leandroid.formula1.champion.ChampionViewModel
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ChampionViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @Mock
    private lateinit var championLiveDataObserver: Observer<List<Champion>>

    private lateinit var viewModel: ChampionViewModel
    private lateinit var scope: TestCoroutineScope

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        scope = TestCoroutineScope()

    }

    @Test
    fun `when viewModel getChampion get success then set championLiveData`() = coroutinesTestRule.testDispatcherProvider.default().run {
        //Arrange
        val champions = listOf(
            Champion(1, "Ayrton", "flag","1991")
        )
        val resultSuccess = ChampionMockService(champions)
        viewModel = ChampionViewModel(resultSuccess)
        viewModel.championsLiveData.observeForever(championLiveDataObserver)

        //Act
        viewModel.getChampion()

        //Assert
        Mockito.verify(championLiveDataObserver).onChanged(champions)
    }
}

class ChampionMockService(private val champions: List<Champion>?) : ChampionService {
    override suspend fun getChampion(): List<Champion>? {
        return champions
    }
}