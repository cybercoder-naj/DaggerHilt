package com.nishant.daggerhilt.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nishant.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println(someClass.doAThing())
    }
}

@ActivityScoped
class SomeClass @Inject constructor(
    private val someInterfaceImpl: SomeInterface
) {
    fun doAThing(): String {
        return "Look, I got: ${someInterfaceImpl.getAThing()}"
    }
}

class SomeInterfaceImpl : SomeInterface {
    override fun getAThing(): String {
        return "A Thing!"
    }
}

interface SomeInterface {
    fun getAThing(): String
}