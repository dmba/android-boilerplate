package me.dmba.mychecks.ui.screens.details

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

private const val ARG_CHECK_ID = "checkId"
private const val ARG_TRANSITION_NAME = "transitionName"

fun newDetailsFragment(checkId: String, transitionName: String): DetailsFragment {
    return DetailsFragment().apply {
        arguments = Bundle().apply {
            putString(ARG_CHECK_ID, checkId)
            putString(ARG_TRANSITION_NAME, transitionName)
        }
    }
}

class DetailsFragment : PresenterFragment<DetailsContract.Presenter>(), DetailsContract.View {

    @Inject
    override lateinit var presenter: DetailsContract.Presenter

    @Inject
    lateinit var picasso: Picasso

    private val checkId: String by arg(ARG_CHECK_ID)
    private val transitionName: String by arg(ARG_TRANSITION_NAME)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedView.transitionName = transitionName
        presenter.loadCheckItem(checkId)
    }

    override fun showCheckItem(check: Check) {
        name.text = check.name
        date.text = check.date
        amount.text = check.amount
        picasso.load(check.imgUrl).into(logo)
        setupRecyclerView(check.items)
        startPostponedEnterTransition()
    }

    private fun setupRecyclerView(items: List<CheckItem>) = recyclerView.apply {
        adapter = CheckItemsAdapter(items)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        addItemDecoration(ListPaddingDecoration.from(context))
    }

}
