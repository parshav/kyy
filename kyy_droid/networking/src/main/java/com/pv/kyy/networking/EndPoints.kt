package com.pv.kyy.networking

import android.util.Log
import arrow.core.*
import arrow.effects.IO
import com.github.kittinunf.fuel.httpGet
import kotlin.properties.Delegates

//typealias LaunchResponse = Either<LaunchResult.NetworkError, LaunchResult.LaunchData>
typealias NewLaunchData = Either<LaunchErrors, LaunchResult>
sealed class LaunchResult {
    object InitialState : LaunchResult()
    class LaunchData(private val data: String) : LaunchResult()
}

sealed class LaunchErrors {
    object NetworkError : LaunchErrors()
    object NoData : LaunchErrors()
}

object EndPoints {
    const val url = "https://launchlibrary.net/1.3"
    val dataHolder by Delegates.observable<NewLaunchData>(LaunchResult.InitialState.right()) {
        _, _, new ->
        new.map {

        }
    }
}

fun String.toEndpoint() = "${EndPoints.url}$this"

//fun EndPoints.getNextTen(path: String = "/launch/next/10"): IO<LaunchResponse> = IO {
//    val (_, resp, _) = path.toEndpoint().httpGet().responseString()
//    if (resp.responseMessage.isNotEmpty()) LaunchResponse.right(LaunchResult.LaunchData(""))
//    else LaunchResponse.left(LaunchResult.NetworkError)
//}

// Using fuel lambda
fun EndPoints.getNextTenByFuel(path: String = "/launch/next/10") {
    path.toEndpoint().httpGet().responseString { _, response, _ ->
        Log.d("pv", "got response : ${response.responseMessage}")
    }
}
