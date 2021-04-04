package id.itborneo.moca.detail

import androidx.lifecycle.ViewModel
import id.itborneo.moca.core.model.SeriesModel
import id.itborneo.moca.core.repository.MocaRepository

class DetailSeriesViewModel(private val id: Int) : ViewModel() {

    private val repo = MocaRepository()

    private var detail = repo.getDetailSeries(id)
    private var credits = repo.getCredits(id)

    fun getDetail() = detail

    fun getCredits() = credits
}

