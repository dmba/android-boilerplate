package me.dmba.mychecks.data.utils

import me.dmba.mychecks.data.KeyValue
import me.dmba.mychecks.data.devsettings.DevSettingsProvider
import kotlin.reflect.KProperty

/**
 * Created by dmba on 6/9/18.
 */
internal abstract class DevSettingsBoolDelegate constructor(
    private val propertyKey: String,
    private val storage: KeyValue
) {

    operator fun setValue(provider: DevSettingsProvider, property: KProperty<*>, value: Boolean) {
        storage.put(propertyKey, value)
    }

    operator fun getValue(providerImpl: DevSettingsProvider, property: KProperty<*>): Boolean {
        return storage.getBool(propertyKey, true)
    }

}
