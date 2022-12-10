package com.ddr.racingstory.util

/**
 * Created by Dede Dari Rahmadi on 10/12/22
 */
sealed class Resource<out T> {
    data class Success<T>(val model: T? = null) : Resource<T>()
    data class Error(val error: String) : Resource<Nothing>()
    data class Idle<T>(val model: T? = null) : Resource<T>()
    object Loading : Resource<Nothing>()
    object None : Resource<Nothing>()
}
