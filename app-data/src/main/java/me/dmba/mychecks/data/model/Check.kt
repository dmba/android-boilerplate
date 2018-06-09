package me.dmba.mychecks.data.model

/**
 * Created by dmba on 6/2/18.
 */
data class Check(
    val id: String,
    val name: String,
    val amount: String,
    val date: String,
    val imgUrl: String,
    val isReceived: Boolean,
    val items: List<CheckItem>
)
