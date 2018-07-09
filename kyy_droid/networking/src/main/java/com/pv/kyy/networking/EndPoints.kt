package com.pv.kyy.networking

import android.os.NetworkOnMainThreadException
import android.util.Log
import arrow.core.*
import arrow.effects.IO
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.pv.kyy.networking.NextFiveData.NextFiveDataClass
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import kotlin.properties.Delegates

//typealias LaunchResponse = Either<LaunchResult.NetworkError, LaunchResult.LaunchData>
typealias NewLaunchData = Either<LaunchErrors, LaunchResult>

var EndpointListener by Delegates.observable<Either<LaunchErrors, LaunchResult>>(LaunchResult.InitialState.right()) {
    _, _, new ->
    Log.d("pv", "Updated data : $new")
}

sealed class LaunchResult {
    object InitialState : LaunchResult()
    class LaunchData(private val data: String) : LaunchResult()
    class LaunchTen(private val data: NextFiveDataClass) : LaunchResult()
}

sealed class LaunchErrors {
    object NetworkError : LaunchErrors()
    object NoData : LaunchErrors()
}

object EndPoints {
    const val url = "https://launchlibrary.net/1.3"
}

fun String.toEndpoint() = "${EndPoints.url}$this"

fun EndPoints.getNextTen(path: String = "/launch/next/10"): IO<NewLaunchData> = IO.async {
    val (req, resp, res) = path.toEndpoint().httpGet().responseString()
    Log.d("pv"," here")
    if (resp.responseMessage.isNotEmpty()) LaunchResult.LaunchData("").right()
    else LaunchErrors.NoData.left()
}

// Using fuel lambda
fun EndPoints.getNextTenByFuel(path: String = "/launch/next/10", dataObservable: BehaviorSubject<NewLaunchData>) {
    path.toEndpoint().httpGet().responseString { _, response, result ->
        val launchTen = Gson().fromJson(result.component1(), NextFiveDataClass::class.java)
        Log.d("pv", "got response : ${response.statusCode}")

        when (response.statusCode) {
            200 -> dataObservable.onNext(LaunchResult.LaunchTen(launchTen).right())
            else -> dataObservable.onNext(LaunchErrors.NetworkError.left())
        }
    }
}
