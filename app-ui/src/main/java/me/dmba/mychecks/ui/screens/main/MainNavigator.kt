package me.dmba.mychecks.ui.screens.main

import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.main.MainContract
import me.dmba.mychecks.ui.screens.detail.DetailActivity
import org.jetbrains.anko.intentFor
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
class MainNavigator @Inject constructor(
    private val activity: MainActivity
) : MainContract.Navigator {

    companion object {
        const val EXTRA_CHECK_ITEM_POSITION = "EXTRA_CHECK_ITEM_POSITION"
        const val EXTRA_CHECK_ITEM_TRANSITION_NAME = "EXTRA_CHECK_ITEM_TRANSITION_NAME"
    }

    override fun goToDetails(check: Check, itemPosition: Int) {
        val transitionName = ViewCompat.getTransitionName(activity.sharedItemView)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            activity,
            activity.sharedItemView,
            transitionName)

        activity.startActivity(activity.intentFor<DetailActivity>(
            MainNavigator.EXTRA_CHECK_ITEM_POSITION to itemPosition,
            MainNavigator.EXTRA_CHECK_ITEM_TRANSITION_NAME to transitionName
        ), options.toBundle())
        activity.overridePendingTransition(0, 0);
    }

}
