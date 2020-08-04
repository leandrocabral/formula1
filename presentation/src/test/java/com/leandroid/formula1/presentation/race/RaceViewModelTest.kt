package com.leandroid.formula1.presentation.race

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer

import com.leandroid.data.network.service.RaceService
import com.leandroid.domain.model.Race
import com.leandroid.formula1.CoroutineTestRule
import com.leandroid.formula1.race.RaceViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class RaceViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @get:Rule
    var coroutinesTestRule = CoroutineTestRule()

    @Mock
    private lateinit var raceLiveDataObserver: Observer<List<Race>>

    private lateinit var viewModel: RaceViewModel
    private lateinit var scope: TestCoroutineScope

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        scope = TestCoroutineScope()

    }

    @Test
    fun `when viewModel getRace get success then set raceLiveData`() = coroutinesTestRule.testDispatcherProvider.default().run {
        //Arrange
        val races = listOf(
            Race(1, "Brasil", "flag")
        )
        val resultSuccess = MockService(races)
        viewModel = RaceViewModel(resultSuccess)
        viewModel.raceLiveData.observeForever(raceLiveDataObserver)

        //Act
        viewModel.getRace()

        //Assert
        verify(raceLiveDataObserver).onChanged(races)
    }
}


class MockService(private val races: List<Race>?) : RaceService {
    override suspend fun getRace(): List<Race>? {
        return races
    }
}