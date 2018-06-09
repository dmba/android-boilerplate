package me.dmba.mychecks.ui.screens.detail

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.view.animation.AnimationUtils.loadAnimation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_layout.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.extra
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.CheckItem
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.ui.screens.main.MainNavigator.Companion.EXTRA_CHECK_ITEM_ID
import me.dmba.mychecks.ui.screens.main.MainNavigator.Companion.EXTRA_CHECK_ITEM_TRANSITION_NAME
import me.dmba.mychecks.ui.utils.ListPaddingDecoration
import me.dmba.mychecks.ui.utils.RxPresenterActivity
import javax.inject.Inject

/**
 * Created by dmba on 5/31/18.
 */
class DetailActivity : RxPresenterActivity<DetailsContract.Presenter>(), DetailsContract.View {

    private val itemId: String by extra(EXTRA_CHECK_ITEM_ID)
    private val imgTransitionName: String by extra(EXTRA_CHECK_ITEM_TRANSITION_NAME)

    @Inject
    override lateinit var presenter: DetailsContract.Presenter

    @Inject
    lateinit var picasso: Picasso

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        postponeEnterTransition()

        runEnterTransitions()

        sharedView.transitionName = imgTransitionName

        presenter.loadCheckItem(itemId)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        runExitTransitions()
    }

    override fun showCheckItem(check: Check) {
        startPostponedEnterTransition()
        name.text = check.name
        date.text = check.date
        amount.text = check.amount
        picasso.load(check.imgUrl).into(logo)
        setupRecyclerView(check.items)
    }

    private fun setupRecyclerView(items: List<CheckItem>) = recyclerView.apply {
        adapter = CheckItemsAdapter(items)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        addItemDecoration(ListPaddingDecoration.from(context))
    }

    private fun runEnterTransitions() {
        val anim = loadAnimation(this, R.anim.slide_down)
        tobBackground.animation = anim
        anim.start()
    }

    private fun runExitTransitions() {
        recyclerView.visibility = View.GONE
        val anim = loadAnimation(this, R.anim.slide_up)
        tobBackground.animation = anim
        anim.start()
    }

}
