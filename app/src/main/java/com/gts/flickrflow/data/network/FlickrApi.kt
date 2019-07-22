package com.gts.flickrflow.data.network

import kotlinx.coroutines.Deferred

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

import com.gts.flickrflow.data.model.PhotosResponse

internal const val URLS = "url_sq, url_t, url_s, url_q, url_m, url_n, url_z, url_c, url_l, url_o"

interface FlickrApi {

    @GET("$ENDPOINT$METHOD_PHOTOS_SEARCH$EXTRA_PARAMS")
    fun search(
        @Query("api_key") apiKey: String,
        @Query("lat") lat: String? = null,
        @Query("lon") lon: String? = null,
        @Query("extras") extras: String = URLS
    ): Deferred<Response<PhotosResponse>>

    companion object {
        const val API_KEY = "58cace78ed8d64e8490e5e3341a96930"
        private const val ENDPOINT = "https://www.flickr.com/services/rest/"
        private const val METHOD_PHOTOS_SEARCH = "?method=flickr.photos.search"
        private const val EXTRA_PARAMS = "&nojsoncallback=1&format=json"
        private const val EXTRA_SMALL_URL = "url_s"
    }
}