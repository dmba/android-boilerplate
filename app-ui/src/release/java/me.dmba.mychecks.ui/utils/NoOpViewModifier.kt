package me.dmba.mychecks.ui.utils

import android.view.LayoutInflater
import android.view.View
import javax.inject.Inject

/**
 * Created by dmba on 6/9/18.
 */
internal class NoOpViewModifier @Inject constructor(
    private val inflater: LayoutInflater
) : ViewModifier {

    override fun modifyView(layoutId: Int): View = inflater.inflate(layoutId, null)

}
