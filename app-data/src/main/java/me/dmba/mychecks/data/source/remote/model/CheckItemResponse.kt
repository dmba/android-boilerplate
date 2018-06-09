package me.dmba.mychecks.data.source.remote.model

import com.google.gson.annotations.SerializedName

/**
 * Created by dmba on 6/9/18.
 */
internal data class CheckItemResponse(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("amount")
    val amount: String

)
