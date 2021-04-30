package id.itborneo.mocafavorite.views;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0002J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\u001a\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006%"}, d2 = {"Lid/itborneo/mocafavorite/views/FavoriteMovieFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lid/itborneo/mocafavorite/adapters/FavoriteMoviePagedAdapter;", "binding", "Lid/itborneo/moca/databinding/FragmentFavoriteMovieBinding;", "isEmpty", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "viewModel", "Lid/itborneo/mocafavorite/viewmodels/FavoriteMovieViewModel;", "getViewModel", "()Lid/itborneo/mocafavorite/viewmodels/FavoriteMovieViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "actionToDetail", "", "movie", "Lid/itborneo/core/domain/model/MovieModel;", "initRecycler", "observerData", "observerIsEmpty", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "showEmptyFavorite", "showIt", "mocafavorite_debug"})
public final class FavoriteMovieFragment extends androidx.fragment.app.Fragment {
    private id.itborneo.moca.databinding.FragmentFavoriteMovieBinding binding;
    private id.itborneo.mocafavorite.adapters.FavoriteMoviePagedAdapter adapter;
    private final kotlin.Lazy viewModel$delegate = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEmpty = null;
    
    private final id.itborneo.mocafavorite.viewmodels.FavoriteMovieViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observerIsEmpty() {
    }
    
    private final void showEmptyFavorite(boolean showIt) {
    }
    
    private final void observerData() {
    }
    
    private final void initRecycler() {
    }
    
    private final void actionToDetail(id.itborneo.core.domain.model.MovieModel movie) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    public FavoriteMovieFragment() {
        super();
    }
}