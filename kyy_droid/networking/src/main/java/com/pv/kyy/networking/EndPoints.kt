package com.pv.kyy.networking

import arrow.core.Either
import arrow.effects.IO
import com.github.kittinunf.fuel.httpGet

typealias LaunchResponse = Either<LaunchResult.NetworkError, LaunchResult.LaunchData>

sealed class LaunchResult {
    object NetworkError : LaunchResult()
    class LaunchData(data: String) : LaunchResult()
}

object EndPoints {
    const val url = "https://launchlibrary.net/1.3"
}

fun String.toEndpoint() = "${EndPoints.url}$this"

fun EndPoints.getNextTen(path: String = "/next/10"): IO<LaunchResponse> = IO {
    val (_, response, _) = path.toEndpoint().httpGet().responseString()
    if (response.responseMessage.isNotEmpty()) LaunchResponse.right(LaunchResult.LaunchData(""))
    else LaunchResponse.left(LaunchResult.NetworkError)
}

/*
// Using fuel lambda
fun EndPoints.getNextTen(path: String = "/next/10"): LaunchResult {
    path.toEndpoint().httpGet().responseString { _, response, result ->

    }
}*/
