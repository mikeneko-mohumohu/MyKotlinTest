package com.example.kmyou.kotlin

/**
 * Created by kmyou on 2017/05/19.
 */
class Person(val firstName : String , val lastName : String, var age : Int = 0) :Foo {
    override fun baz(qux: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val bar: Int
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    val getFullName: String
        get() {
            return this.firstName + this.lastName
        }
    fun elapse(years: Int = 1): Int {
        age += years
        return age
    }

}