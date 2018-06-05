package me.dmba.mychecks.data

import me.dmba.mychecks.data.model.Check
import javax.inject.Inject

/**
 * Created by dmba on 5/26/18.
 */
interface ChecksDataSource {

    fun getChecks(): List<Check>

    fun getCheckAt(position: Int): Check

}

class LocalChecksDataSource @Inject constructor() : ChecksDataSource {

    val data = arrayListOf(
        Check(
            "#01",
            "Hermes",
            "$1,500.67",
            "March 13, 2018",
            "file:///android_asset/logos/logo_apple.png",
            false
        ),
        Check(
            "#02",
            "Philipp Plein",
            "$1,245.17",
            "March 13, 2018",
            "file:///android_asset/logos/logo_chrome.png",
            true
        ),
        Check(
            "#03",
            "L`Ocitane",
            "$545.28",
            "March 13, 2018",
            "file:///android_asset/logos/logo_cloud.jpeg",
            true
        ),
        Check(
            "#04",
            "Kenzo",
            "$375.37",
            "March 13, 2018",
            "file:///android_asset/logos/logo_grtia.jpeg",
            false
        ),
        Check(
            "#05",
            "Ray Ban",
            "$151.33",
            "March 13, 2018",
            "file:///android_asset/logos/logo_rayban.png",
            true
        ),
        Check(
            "#06",
            "Stadium",
            "$230.47",
            "March 13, 2018",
            "file:///android_asset/logos/logo_stadium.png",
            false
        ),
        Check(
            "#07",
            "Apple",
            "$3486.23",
            "March 13, 2018",
            "file:///android_asset/logos/logo_apple.png",
            true
        )
    )

    override fun getChecks(): List<Check> = data

    override fun getCheckAt(position: Int): Check = data[position]

}
