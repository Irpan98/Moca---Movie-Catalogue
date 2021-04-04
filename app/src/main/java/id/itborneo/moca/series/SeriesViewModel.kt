package id.itborneo.moca.series

import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.repository.MocaRepository

class SeriesViewModel : ViewModel() {

    private val repo = MocaRepository()
    private val series = repo.getSeries()

    fun getSeries() = series
}