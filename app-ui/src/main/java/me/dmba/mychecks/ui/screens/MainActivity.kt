package me.dmba.mychecks.ui.screens

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import me.dmba.mychecks.R
import me.dmba.mychecks.ui.utils.ViewModifier
import javax.inject.Inject

/**
 * Created by dmba on 5/31/18.
 */
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModifier: ViewModifier

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewModifier.modifyView(R.layout.activity_main))
    }

}
