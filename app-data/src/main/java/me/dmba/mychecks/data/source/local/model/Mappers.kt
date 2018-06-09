package me.dmba.mychecks.data.source.local.model

import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.CheckItem

/**
 * Created by dmba on 6/9/18.
 */

internal fun mapCheckToObject(check: Check): CheckObject {
    return CheckObject(
        check.id,
        check.name,
        check.amount,
        check.date,
        check.imgUrl,
        check.isReceived
    )
}

internal fun mapCheckItemToObjectItem(check: Check, item: CheckItem): CheckItemObject {
    return CheckItemObject(
        item.id,
        check.id,
        item.name,
        item.amount
    )
}

internal fun mapObjectWithItemsToCheck(obj: CheckWithItems): Check {
    return Check(
        obj.check.id,
        obj.check.name,
        obj.check.amount,
        obj.check.date,
        obj.check.imgUrl,
        obj.check.isReceived,
        obj.items.map(::mapItemObjectToCheckItem)
    )
}

internal fun mapItemObjectToCheckItem(obj: CheckItemObject): CheckItem {
    return CheckItem(
        obj.id,
        obj.name,
        obj.amount
    )
}
