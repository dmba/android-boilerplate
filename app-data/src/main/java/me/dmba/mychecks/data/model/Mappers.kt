package me.dmba.mychecks.data.model

/**
 * Created by dmba on 6/6/18.
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

internal fun mapObjectToCheck(obj: CheckObject): Check {
    return Check(
        obj.id,
        obj.name,
        obj.amount,
        obj.date,
        obj.imgUrl,
        obj.isReceived
    )
}

internal fun mapResponseToCheck(response: CheckResponse): Check {
    return Check(
        response.id,
        response.name,
        response.amount,
        response.date,
        response.imgUrl,
        response.isReceived
    )
}
