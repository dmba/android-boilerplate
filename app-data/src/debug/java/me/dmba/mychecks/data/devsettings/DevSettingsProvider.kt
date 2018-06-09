package me.dmba.mychecks.data.devsettings

import io.reactivex.Single

/**
 * Created by dmba on 6/9/18.
 */
interface DevSettingsProvider {

    val model: Single<DevSettings>

    var stethoEnabled: Boolean

}
