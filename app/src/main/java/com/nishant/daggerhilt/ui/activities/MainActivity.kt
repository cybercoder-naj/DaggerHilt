package com.nishant.daggerhilt.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nishant.daggerhilt.R
import com.nishant.daggerhilt.di.Impl1
import com.nishant.daggerhilt.di.Impl2
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

        println(someClass.doAThing1())
        println(someClass.doAThing2())
    }
}

class SomeClass @Inject constructor(
    @Impl1 private val someInterfaceImpl1: SomeInterface,
    @Impl2 private val someInterfaceImpl2: SomeInterface
) {
    fun doAThing1() = "Look I got: ${someInterfaceImpl1.getAThing()}"
    fun doAThing2() = "Look I got: ${someInterfaceImpl2.getAThing()}"
}

class SomeInterfaceImpl1 : SomeInterface {
    override fun getAThing(): String {
        return "A Thing - 1!"
    }
}

class SomeInterfaceImpl2 : SomeInterface {
    override fun getAThing(): String {
        return "A Thing - 2!"
    }
}

interface SomeInterface {
    fun getAThing(): String
}