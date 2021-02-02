package com.riccardotesta.mvishowcase.main


class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}
