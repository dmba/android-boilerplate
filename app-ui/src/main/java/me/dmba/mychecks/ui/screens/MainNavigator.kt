package me.dmba.mychecks.ui.screens


import android.support.v4.app.FragmentManager
import android.support.v4.view.ViewCompat
import android.transition.Fade
import android.transition.TransitionInflater
import me.dmba.mychecks.R
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.ui.screens.details.newDetailsFragment
import me.dmba.mychecks.ui.screens.main.MainFragment
import me.dmba.mychecks.ui.screens.main.newMainFragment
import javax.inject.Inject

/**
 * Created by dmba on 6/3/18.
 */
class MainNavigator @Inject constructor(
    private val transitionInflater: TransitionInflater,
    private val fragmentManager: FragmentManager
) : MainContract.Navigator {

    lateinit var mainFragment: MainFragment

    override fun goToMainScreen() {
        mainFragment = newMainFragment()

        fragmentManager.beginTransaction()
            .add(R.id.activity_main_container, mainFragment)
            .commitAllowingStateLoss()
    }

    override fun goToDetails(check: Check, itemPosition: Int) {
        val prevFragment = mainFragment
        val transitionName = ViewCompat.getTransitionName(prevFragment.sharedItemView)
        val nextFragment = newDetailsFragment(check.id, transitionName)

        // 1. Transitions for Previous Fragment
        prevFragment.apply {
            exitTransition = Fade()
            enterTransition = Fade()
        }

        // 2. Shared Elements Transition
        nextFragment.apply {
            sharedElementEnterTransition = transitionInflater.inflateTransition(android.R.transition.move)
            sharedElementReturnTransition = transitionInflater.inflateTransition(android.R.transition.move)
        }

        // 3. Transitions for New Fragment
        nextFragment.apply {
            enterTransition = Fade()
            exitTransition = Fade()
        }

        fragmentManager.beginTransaction()
            .addSharedElement(prevFragment.sharedItemView, transitionName)
            .addToBackStack(null)
            .replace(R.id.activity_main_container, nextFragment)
            .commitAllowingStateLoss()
    }

}
