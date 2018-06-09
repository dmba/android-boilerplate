package me.dmba.mychecks.ui.screens

import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewCompat
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.findFragmentById
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.ui.screens.details.newDetailsFragment
import me.dmba.mychecks.ui.screens.main.MainFragment
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
class MainNavigator @Inject constructor(
    private val activity: MainActivity,
    private val fragmentManager: FragmentManager
) : MainContract.Navigator {

    private val mainFragment: MainFragment get() = activity.findFragmentById(R.id.activity_fragment_main)

    override fun goToDetails(check: Check, itemPosition: Int) {
        val sharedItemView = mainFragment.sharedItemView
        val transitionName = ViewCompat.getTransitionName(sharedItemView)

        fragmentManager.beginTransaction()
            .addSharedElement(sharedItemView, transitionName)
            .add(R.id.activity_main, newDetailsFragment(check.id, transitionName))
            .addToBackStack(null)
            .commit()
    }

}
