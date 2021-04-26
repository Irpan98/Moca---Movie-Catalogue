package id.itborneo.mocafavorite.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\b\u0010\n\u001a\u00020\u000bH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lid/itborneo/mocafavorite/viewmodels/FavoriteSeriesViewModel;", "Landroidx/lifecycle/ViewModel;", "useCase", "Lid/itborneo/core/domain/usecase/MocaUseCase;", "(Lid/itborneo/core/domain/usecase/MocaUseCase;)V", "listSeries", "Landroidx/lifecycle/LiveData;", "Landroidx/paging/PagedList;", "Lid/itborneo/core/domain/model/SeriesModel;", "getSeries", "initSeries", "Lkotlinx/coroutines/Job;", "mocafavorite_debug"})
public final class FavoriteSeriesViewModel extends androidx.lifecycle.ViewModel {
    private androidx.lifecycle.LiveData<androidx.paging.PagedList<id.itborneo.core.domain.model.SeriesModel>> listSeries;
    private final id.itborneo.core.domain.usecase.MocaUseCase useCase = null;
    
    private final kotlinx.coroutines.Job initSeries() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<androidx.paging.PagedList<id.itborneo.core.domain.model.SeriesModel>> getSeries() {
        return null;
    }
    
    public FavoriteSeriesViewModel(@org.jetbrains.annotations.NotNull()
    id.itborneo.core.domain.usecase.MocaUseCase useCase) {
        super();
    }
}