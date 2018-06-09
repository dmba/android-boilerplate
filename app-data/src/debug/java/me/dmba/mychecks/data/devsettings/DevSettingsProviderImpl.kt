package me.dmba.mychecks.data.devsettings

import io.reactivex.Single
import me.dmba.mychecks.data.KeyValue
import me.dmba.mychecks.data.di.KEY_VALUE_PREFS
import me.dmba.mychecks.data.utils.DevSettingsBoolDelegate
import javax.inject.Inject
import javax.inject.Named
import kotlin.reflect.KProperty

/**
 * Created by dmba on 6/9/18.
 */
internal class DevSettingsProviderImpl @Inject constructor(
    modelDelegate: ModelDelegate,
    stethoDelegate: StethoDelegate
) : DevSettingsProvider {

    override val model: Single<DevSettings> by modelDelegate

    override var stethoEnabled: Boolean by stethoDelegate

}

internal class ModelDelegate @Inject constructor(
) {
    operator fun getValue(provider: DevSettingsProvider, property: KProperty<*>): Single<DevSettings> {
        //TODO
        return Single.fromCallable {
            DevSettings(
                "8d8aaf",
                "today :)",
                "1",
                "0.0.1"
            )
        }
    }
}

internal class StethoDelegate @Inject constructor(
    @Named(KEY_VALUE_PREFS) private val storage: KeyValue
) : DevSettingsBoolDelegate("STETHO_ENABLED", storage)
