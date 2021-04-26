package id.itborneo.mocafavorite.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002\u0012\u0013B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\n\u001a\u00020\u00062\n\u0010\u000b\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lid/itborneo/mocafavorite/adapters/FavoriteMoviePagedAdapter;", "Landroidx/paging/PagedListAdapter;", "Lid/itborneo/core/domain/model/MovieModel;", "Lid/itborneo/mocafavorite/adapters/FavoriteMoviePagedAdapter$ViewHolder;", "listener", "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;)V", "getListener", "()Lkotlin/jvm/functions/Function1;", "onBindViewHolder", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "mocafavorite_debug"})
public final class FavoriteMoviePagedAdapter extends androidx.paging.PagedListAdapter<id.itborneo.core.domain.model.MovieModel, id.itborneo.mocafavorite.adapters.FavoriteMoviePagedAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<id.itborneo.core.domain.model.MovieModel, kotlin.Unit> listener = null;
    private static final androidx.recyclerview.widget.DiffUtil.ItemCallback<id.itborneo.core.domain.model.MovieModel> DIFF_CALLBACK = null;
    @org.jetbrains.annotations.NotNull()
    public static final id.itborneo.mocafavorite.adapters.FavoriteMoviePagedAdapter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public id.itborneo.mocafavorite.adapters.FavoriteMoviePagedAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    id.itborneo.mocafavorite.adapters.FavoriteMoviePagedAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<id.itborneo.core.domain.model.MovieModel, kotlin.Unit> getListener() {
        return null;
    }
    
    public FavoriteMoviePagedAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super id.itborneo.core.domain.model.MovieModel, kotlin.Unit> listener) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lid/itborneo/mocafavorite/adapters/FavoriteMoviePagedAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemBinding", "Lid/itborneo/moca/databinding/ItemPosterBinding;", "(Lid/itborneo/mocafavorite/adapters/FavoriteMoviePagedAdapter;Lid/itborneo/moca/databinding/ItemPosterBinding;)V", "bind", "", "movie", "Lid/itborneo/core/domain/model/MovieModel;", "mocafavorite_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final id.itborneo.moca.databinding.ItemPosterBinding itemBinding = null;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        id.itborneo.core.domain.model.MovieModel movie) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        id.itborneo.moca.databinding.ItemPosterBinding itemBinding) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lid/itborneo/mocafavorite/adapters/FavoriteMoviePagedAdapter$Companion;", "", "()V", "DIFF_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lid/itborneo/core/domain/model/MovieModel;", "mocafavorite_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}