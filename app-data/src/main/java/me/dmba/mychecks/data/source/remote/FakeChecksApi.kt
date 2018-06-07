package me.dmba.mychecks.data.source.remote

import io.reactivex.Flowable
import me.dmba.mychecks.common.extensions.random
import me.dmba.mychecks.data.model.CheckResponse
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by dmba on 6/6/18.
 */
internal class FakeChecksApi @Inject constructor() : ChecksApi {

    private val data = arrayListOf(
        CheckResponse(
            "#01",
            "Hermes",
            "$1,500.67",
            "March 13, 2018",
            "file:///android_asset/logos/logo_apple.png",
            false
        ),
        CheckResponse(
            "#02",
            "Philipp Plein",
            "$1,245.17",
            "March 13, 2018",
            "file:///android_asset/logos/logo_chrome.png",
            true
        ),
        CheckResponse(
            "#03",
            "L`Ocitane",
            "$545.28",
            "March 13, 2018",
            "file:///android_asset/logos/logo_cloud.jpeg",
            true
        ),
        CheckResponse(
            "#04",
            "Kenzo",
            "$375.37",
            "March 13, 2018",
            "file:///android_asset/logos/logo_grtia.jpeg",
            false
        ),
        CheckResponse(
            "#05",
            "Ray Ban",
            "$151.33",
            "March 13, 2018",
            "file:///android_asset/logos/logo_rayban.png",
            true
        ),
        CheckResponse(
            "#06",
            "Stadium",
            "$230.47",
            "March 13, 2018",
            "file:///android_asset/logos/logo_stadium.png",
            false
        ),
        CheckResponse(
            "#07",
            "Apple",
            "$3486.23",
            "March 13, 2018",
            "file:///android_asset/logos/logo_apple.png",
            true
        )
    )

    private val thresholdMs: Long get() = (30..3000).random()

    override fun getAll(): Flowable<List<CheckResponse>> {
        return Flowable.fromCallable<List<CheckResponse>> { data }
            .delay(thresholdMs, TimeUnit.MILLISECONDS)
    }

}
