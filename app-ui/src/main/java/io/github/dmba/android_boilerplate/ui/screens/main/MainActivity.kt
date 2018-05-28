package io.github.dmba.android_boilerplate.ui.screens.main

import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.VERTICAL
import android.view.View
import io.github.dmba.android_boilerplate.R
import io.github.dmba.android_boilerplate.data.model.Check
import io.github.dmba.android_boilerplate.ui.screens.detail.DetailActivity
import io.github.dmba.android_boilerplate.ui.utils.ListPaddingDecoration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.intentFor

/**
 * Created by dmba on 5/31/18.
 */
class MainActivity : AppCompatActivity(), OnChecksItemClickListener {

    companion object {
        const val EXTRA_CHECK_ITEM = "EXTRA_CHECK_ITEM"
        const val EXTRA_CHECK_ITEM_TRANSITION_NAME = "EXTRA_CHECK_ITEM_TRANSITION_NAME"
    }

    private val data: List<Check> = arrayListOf(
        Check(
            "Hermes",
            "$1,500.67",
            "March 13, 2018",
            R.drawable.logo_apple,
            false
        ),
        Check(
            "Philipp Plein",
            "$1,245.17",
            "March 13, 2018",
            R.drawable.logo_chrome,
            true
        ),
        Check(
            "L`Ocitane",
            "$545.28",
            "March 13, 2018",
            R.drawable.logo_cloud,
            true
        ),
        Check(
            "Kenzo",
            "$375.37",
            "March 13, 2018",
            R.drawable.logo_grtia,
            false
        ),
        Check(
            "Ray Ban",
            "$151.33",
            "March 13, 2018",
            R.drawable.logo_rayban,
            true
        ),
        Check(
            "Stadium",
            "$230.47",
            "March 13, 2018",
            R.drawable.logo_stadium,
            false
        ),
        Check(
            "Apple",
            "$3486.23",
            "March 13, 2018",
            R.drawable.logo_apple,
            true
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        setUpRecyclerView(this)
    }

    override fun onCheckItemClick(position: Int, check: Check, sharedView: View) {
        val transitionName = ViewCompat.getTransitionName(sharedView)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            sharedView,
            transitionName)

        startActivity(intentFor<DetailActivity>(
            EXTRA_CHECK_ITEM to check,
            EXTRA_CHECK_ITEM_TRANSITION_NAME to transitionName
        ), options.toBundle())
    }

    private fun setUpRecyclerView(itemClickListener: OnChecksItemClickListener) {
        recyclerView.apply {
            adapter = ChecksRecyclerViewAdapter(itemClickListener, data)
            layoutManager = LinearLayoutManager(context, VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            addItemDecoration(ListPaddingDecoration.from(context))
        }

        swipeRefreshLayout.apply {
            setOnRefreshListener {
                Handler().postDelayed({
                    swipeRefreshLayout.isRefreshing = false
                }, 3000)
            }
            setColorSchemeResources(R.color.orange, R.color.green, R.color.blue)
        }
    }

}
