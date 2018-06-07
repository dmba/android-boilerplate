package me.dmba.mychecks.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by dmba on 6/6/18.
 */
internal data class CheckResponse(

    @SerializedName("id")
    val id: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("amount")
    val amount: String,

    @SerializedName("date")
    val date: String,

    @SerializedName("img_url")
    val imgUrl: String,

    @SerializedName("is_received")
    val isReceived: Boolean

)

internal data class CheckListResponse(

    @SerializedName("checks")
    val checks: List<CheckResponse>

)
