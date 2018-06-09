package me.dmba.mychecks.ui.screens.details

import android.os.Bundle
import android.support.transition.ChangeBounds
import android.support.transition.ChangeTransform
import android.support.transition.TransitionSet
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.transition.Fade
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.item_layout.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.arg
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.data.model.CheckItem
import me.dmba.mychecks.domain.DetailsContract
import me.dmba.mychecks.ui.utils.ListPaddingDecoration
import me.dmba.mychecks.ui.utils.PresenterFragment
import javax.inject.Inject

/**
 * Created by dmba on 6/9/18.
 */
class DetailsTransition : TransitionSet() {
    init {
        ordering = ORDERING_TOGETHER
        addTransition(ChangeBounds())
        addTransition(ChangeTransform())
    }
}

fun newDetailsFragment(checkId: String, transitionName: String): DetailsFragment {
    val enter = Fade()
    val exit = Fade()

    enter.excludeTarget(transitionName, true)
    exit.excludeTarget(transitionName, true)

    return DetailsFragment().apply {
        arguments = Bundle().apply {
            putString("checkId", checkId)
            putString("transitionName", transitionName)
        }
        sharedElementEnterTransition = DetailsTransition()
        enterTransition = enter
        exitTransition = exit
        sharedElementReturnTransition = DetailsTransition()

        postponeEnterTransition()
    }
}

class DetailsFragment : PresenterFragment<DetailsContract.Presenter>(), DetailsContract.View {

    @Inject
    override lateinit var presenter: DetailsContract.Presenter

    @Inject
    lateinit var picasso: Picasso

    private val checkId: String by arg("checkId")
    private val transitionName: String by arg("transitionName")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        runEnterTransitions()
        sharedView.transitionName = transitionName
        presenter.loadCheckItem(checkId)
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
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_down)
        tobBackground.animation = anim
        anim.start()
    }

    private fun runExitTransitions() {
        val anim = AnimationUtils.loadAnimation(context, R.anim.slide_up)
        tobBackground.animation = anim
        anim.start()
    }

}
