package id.itborneo.core.utils

import androidx.paging.PagedList

object PagedListUtils {
    fun config(): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
    }
}