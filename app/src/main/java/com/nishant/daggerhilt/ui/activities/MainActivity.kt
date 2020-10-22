package com.nishant.daggerhilt.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nishant.daggerhilt.R
import dagger.hilt.android.AndroidEntryPoint
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
        println(someClass.doSomething())
    }
}

class SomeClass @Inject constructor(
        private val someOtherClass: SomeOtherClass
) {
    fun doAThing(): String {
        return "Look, I did a thing!"
    }

    fun doSomething() = someOtherClass.doSomeOtherThing()
}

class SomeOtherClass @Inject constructor() {
    fun doSomeOtherThing() = "Another thing!"
}