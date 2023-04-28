package com.romanmikhailenko.weaterapp.utils

import retrofit2.Response

sealed class Resource<T>(
    val data: T? = null,
    val message: String? = null,
    val status: Status
) {
    class Success<T>(data: T?): Resource<T>(data = data, status = Status.SUCCESS)
    class Error<T>(message: String?) : Resource<T>(message = message, status = Status.ERROR)
    class Loading<T>: Resource<T>(status = Status.LOADING)
}