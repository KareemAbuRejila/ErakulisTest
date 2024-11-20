package com.dotech.erakulistest.data.utils


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dotech.erakulistest.data.models.ImageDTO

class PixabayPagingSource(
) : PagingSource<Int, ImageDTO>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageDTO> {
//        return try {
//            val page = params.key ?: 1
//            val response = service.getImages(
//                page = page,
//                perPage = params.loadSize
//            )
//            LoadResult.Page(
//                data = response.hits,
//                prevKey = if (page == 1) null else page - 1,
//                nextKey = if (response.hits.isEmpty()) null else page + 1
//            )
//        } catch (e: Exception) {
//            LoadResult.Error(e)
//        }
        return LoadResult.Error(Exception("Fuck"))
    }

    override fun getRefreshKey(state: PagingState<Int, ImageDTO>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}