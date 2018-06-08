package me.dmba.mychecks.ui.utils

import android.support.annotation.LayoutRes
import android.view.View

/**
 * Created by dmba on 6/9/18.
 */
interface ViewModifier {

    fun modifyView(@LayoutRes layoutId: Int): View

}
