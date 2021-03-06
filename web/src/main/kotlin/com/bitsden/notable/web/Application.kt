package com.bitsden.notable.web

abstract class ApplicationBase {
    abstract val stateKeys: List<String>

    abstract fun start(state: Map<String, Any>)
    abstract fun dispose(): Map<String, Any>
}