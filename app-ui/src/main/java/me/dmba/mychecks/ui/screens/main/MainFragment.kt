package me.dmba.mychecks.ui.screens.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import me.dmba.mychecks.R
import me.dmba.mychecks.common.extensions.action
import me.dmba.mychecks.common.extensions.snack
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.MainContract
import me.dmba.mychecks.ui.utils.ListPaddingDecoration
import me.dmba.mychecks.ui.utils.PresenterFragment
import javax.inject.Inject

/**
 * Created by dmba on 6/9/18.
 */

fun newMainFragment() = MainFragment()

class MainFragment : PresenterFragment<MainContract.Presenter>(), MainContract.View {

    @Inject
    override lateinit var presenter: MainContract.Presenter

    lateinit var sharedItemView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        setUpRecyclerView()
        setUpSwipeRefreshLayout()
        presenter.loadData()
    }

    override fun updateList(items: List<Check>) {
        (recyclerView.adapter as ChecksAdapter).updateData(items)
    }

    override fun showLoading() {
        swipeRefreshLayout.isRefreshing = true
    }

    override fun hideLoading() {
        swipeRefreshLayout.isRefreshing = false
    }

    override fun showDataFetchError() {
        activity.snack(R.string.app_data_fetch_error, Snackbar.LENGTH_INDEFINITE) {
            action(R.string.app_retry) { presenter.loadData(refresh = true) }
        }
    }

    private fun onCheckItemClick(check: Check, itemPosition: Int, sharedView: View) {
        sharedItemView = sharedView
        presenter.onItemSelect(check, itemPosition)
    }

    private fun setUpRecyclerView() = recyclerView.apply {
        adapter = ChecksAdapter(::onCheckItemClick)
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        addItemDecoration(ListPaddingDecoration.from(context))
    }

    private fun setUpSwipeRefreshLayout() = swipeRefreshLayout.apply {
        setOnRefreshListener { presenter.loadData(refresh = true) }
        setColorSchemeResources(R.color.orange, R.color.green, R.color.blue)
    }

}
