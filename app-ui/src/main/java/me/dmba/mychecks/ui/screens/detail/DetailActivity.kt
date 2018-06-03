package me.dmba.mychecks.ui.screens.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_layout.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.extra
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.ui.screens.main.MainActivity.Companion.EXTRA_CHECK_ITEM
import me.dmba.mychecks.ui.screens.main.MainActivity.Companion.EXTRA_CHECK_ITEM_TRANSITION_NAME

/**
 * Created by dmba on 5/31/18.
 */
class DetailActivity : AppCompatActivity() {

    private val checkItem: Check by extra(EXTRA_CHECK_ITEM)
    private val imageTransitionName: String by extra(EXTRA_CHECK_ITEM_TRANSITION_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        runEnterTransitions()

        sharedView.transitionName = imageTransitionName

        setupCheckItem(checkItem)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        runExitTransitions()
    }

    private fun setupCheckItem(check: Check) {
        name.text = check.name
        date.text = check.date
        amount.text = check.amount
        logo.setImageResource(check.imgRes)
    }

    private fun runEnterTransitions() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.slide_down)
        tobBackground.animation = anim
        anim.start()
    }

    private fun runExitTransitions() {
        val anim = AnimationUtils.loadAnimation(this, R.anim.slide_up)
        tobBackground.animation = anim
        anim.start()
    }

}
