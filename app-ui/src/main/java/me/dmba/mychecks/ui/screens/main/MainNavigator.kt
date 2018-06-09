package me.dmba.mychecks.ui.screens.main

import android.support.v4.view.ViewCompat
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.ui.screens.detail.newDetailsFragment
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
class MainNavigator @Inject constructor(
    private val activity: MainActivity
) : MainContract.Navigator {

    override fun goToDetails(check: Check, itemPosition: Int) {
        val transitionName = ViewCompat.getTransitionName(activity.sharedItemView)

        activity.supportFragmentManager.beginTransaction()
            .addSharedElement(activity.sharedItemView, transitionName)
            .add(android.R.id.content, newDetailsFragment(check.id, transitionName))
            .addToBackStack(null)
            .commit()
    }

}
