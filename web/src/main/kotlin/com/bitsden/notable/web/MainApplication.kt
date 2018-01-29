package com.bitsden.notable.web

import com.bitsden.notable.web.lines.LinesPresenter
import com.bitsden.notable.web.lines.LinesView
import com.bitsden.notable.web.lines.WebLinesView
import org.w3c.dom.HTMLDivElement
import kotlin.browser.document

class MainApplication : ApplicationBase() {
    private lateinit var view: LinesView
    private lateinit var presenter: LinesPresenter

    override val stateKeys = listOf("lines")

    override fun start(state: Map<String, Any>) {
        view = WebLinesView(document.getElementById("lines") as HTMLDivElement, document.getElementById("addForm")!!)
        presenter = LinesPresenter(view)

        state["lines"]?.let { linesState ->
            @Suppress("UNCHECKED_CAST")
            presenter.restore(linesState as Array<String>)
        }
    }

    override fun dispose(): Map<String, Any> = mapOf(
        "lines" to presenter.dispose()
    )
}