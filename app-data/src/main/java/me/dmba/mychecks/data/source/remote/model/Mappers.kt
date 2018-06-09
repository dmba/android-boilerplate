package me.dmba.mychecks.data.source.remote.model

import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.CheckItem

/**
 * Created by dmba on 6/9/18.
 */

internal fun mapResponseToCheck(response: CheckResponse): Check {
    return Check(
        response.id,
        response.name,
        response.amount,
        response.date,
        response.imgUrl,
        response.isReceived,
        response.items.map(::mapItemResponseToCheckItem)
    )
}

internal fun mapItemResponseToCheckItem(response: CheckItemResponse): CheckItem {
    return CheckItem(
        response.id,
        response.name,
        response.amount
    )
}
