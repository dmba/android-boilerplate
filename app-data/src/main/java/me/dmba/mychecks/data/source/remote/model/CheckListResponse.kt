package me.dmba.mychecks.data.source.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by dmba on 6/9/18.
 */
internal data class CheckListResponse(

    @SerializedName("checks")
    val checks: List<CheckResponse>

)
