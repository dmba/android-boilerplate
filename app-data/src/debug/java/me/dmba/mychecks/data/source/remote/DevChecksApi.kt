package me.dmba.mychecks.data.source.remote

import android.content.res.AssetManager
import com.google.gson.Gson
import io.reactivex.Flowable
import me.dmba.mychecks.common.extensions.random
import me.dmba.mychecks.data.source.remote.model.CheckListResponse
import java.io.InputStreamReader
import java.io.Reader
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by dmba on 6/6/18.
 */

private const val FAKE_CHECKS_RESPONSE = "fake_checks_response.json"

internal class DevChecksApi @Inject constructor(
    private val gson: Gson,
    private val assets: AssetManager
) : ChecksApi {

    private val dsReader: Reader
        get() = InputStreamReader(assets.open(FAKE_CHECKS_RESPONSE))

    private val response: CheckListResponse
        get() = gson.fromJson(dsReader, CheckListResponse::class.java)

    private val thresholdMs: Long
        get() = (30..3000).random()

    override fun getAll(): Flowable<CheckListResponse> {
        return Flowable.fromCallable<CheckListResponse> { response }
            .delay(thresholdMs, TimeUnit.MILLISECONDS)
    }

}
