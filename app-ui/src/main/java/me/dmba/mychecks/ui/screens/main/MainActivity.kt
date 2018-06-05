package me.dmba.mychecks.ui.screens.main

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import me.dmba.mychecks.R
import me.dmba.mychecks.data.model.Check
import me.dmba.mychecks.domain.main.MainContract
import me.dmba.mychecks.ui.utils.ListPaddingDecoration
import javax.inject.Inject

/**
 * Created by dmba on 5/31/18.
 */
class MainActivity : DaggerAppCompatActivity(), MainContract.View, OnChecksItemClickListener {

    @Inject
    lateinit var presenter: MainContract.Presenter

    lateinit var sharedItemView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        setUpRecyclerView()
        setUpSwipeRefreshLayout()
        presenter.loadData()
    }

    override fun updateList(items: List<Check>) {
        (recyclerView.adapter as ChecksAdapter).updateData(items)
    }

    override fun onCheckItemClick(check: Check, itemPosition: Int, sharedView: View) {
        sharedItemView = sharedView
        presenter.onItemSelect(check, itemPosition)
    }

    private fun setUpRecyclerView() = recyclerView.apply {
        adapter = ChecksAdapter(this@MainActivity)
        layoutManager = LinearLayoutManager(context, VERTICAL, false)
        itemAnimator = DefaultItemAnimator()
        setHasFixedSize(true)
        addItemDecoration(ListPaddingDecoration.from(context))
    }

    private fun setUpSwipeRefreshLayout() = swipeRefreshLayout.apply {
        setOnRefreshListener {
            Handler().postDelayed({
                swipeRefreshLayout.isRefreshing = false
            }, 3000)
        }
        setColorSchemeResources(R.color.orange, R.color.green, R.color.blue)
    }

}
