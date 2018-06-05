package me.dmba.mychecks.ui.screens.detail

import android.os.Bundle
import android.view.animation.AnimationUtils.loadAnimation
import com.squareup.picasso.Picasso
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_layout.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.extra
import me.dmba.mychecks.data.ChecksDataSource
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.ui.screens.main.MainNavigator.Companion.EXTRA_CHECK_ITEM_POSITION
import me.dmba.mychecks.ui.screens.main.MainNavigator.Companion.EXTRA_CHECK_ITEM_TRANSITION_NAME
import javax.inject.Inject

/**
 * Created by dmba on 5/31/18.
 */
class DetailActivity : DaggerAppCompatActivity() {

    private val checkItemPosition: Int by extra(EXTRA_CHECK_ITEM_POSITION)
    private val imgTransitionName: String by extra(EXTRA_CHECK_ITEM_TRANSITION_NAME)

    @Inject
    lateinit var picasso: Picasso

    @Inject
    lateinit var dataSource: ChecksDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        postponeEnterTransition()

        runEnterTransitions()

        sharedView.transitionName = imgTransitionName

        dataSource.getCheckAt(checkItemPosition).subscribe {
            setupCheckItem(it)
            startPostponedEnterTransition()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        runExitTransitions()
    }

    private fun setupCheckItem(check: Check) {
        name.text = check.name
        date.text = check.date
        amount.text = check.amount
        picasso.load(check.imgUrl).into(logo)
    }

    private fun runEnterTransitions() {
        val anim = loadAnimation(this, R.anim.slide_down)
        tobBackground.animation = anim
        anim.start()
    }

    private fun runExitTransitions() {
        val anim = loadAnimation(this, R.anim.slide_up)
        tobBackground.animation = anim
        anim.start()
    }

}
