package id.itborneo.moca.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.itborneo.moca.core.model.credits.CreditsModel
import id.itborneo.moca.core.model.detail.SeriesDetailModel
import id.itborneo.moca.core.repository.MocaRepository
import id.itborneo.moca.core.utils.Resource
import kotlinx.coroutines.launch

class DetailSeriesViewModel(private val repo: MocaRepository, private val id: Int) : ViewModel() {

    private lateinit var detail: LiveData<Resource<SeriesDetailModel>>
    private lateinit var credits: LiveData<Resource<CreditsModel>>

    init {
        initDetailSeries()
    }

    fun initDetailSeries() = viewModelScope.launch {
        detail = repo.getDetailSeries(id)
        credits = repo.getCredits(id)
    }

    fun getDetail() = detail
    fun getCredits() = credits
}

