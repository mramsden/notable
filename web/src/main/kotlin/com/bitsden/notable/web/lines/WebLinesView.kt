package com.bitsden.notable.web.lines

import kotlinx.html.div
import kotlinx.html.dom.append
import kotlinx.html.p
import org.w3c.dom.Element
import org.w3c.dom.HTMLButtonElement
import org.w3c.dom.HTMLDivElement
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import org.w3c.dom.events.KeyboardEvent
import kotlin.dom.clear

class WebLinesView(val linesHolder: HTMLDivElement, formRoot: Element) : LinesView {
    lateinit override var presenter: LinesPresenter

    private val input = formRoot.querySelector("input") as HTMLInputElement

    private val addButton = formRoot.querySelector("button") as HTMLButtonElement

    private val buttonHandler: (Event) -> Unit = {
         presenter.addButtonClicked()
    }

    private val inputHandler: (Event) -> Unit = { e ->
        if (e is KeyboardEvent && e.keyCode == 13) {
             presenter.inputEnterPressed()
        }
    }

    init {
        register()
    }

    override var inputText: String
        get() = input.value
        set(newValue) { input.value = newValue }

    override fun focusInput() {
        input.focus()
    }

    override fun addLine(lineText: String) {
        linesHolder.append.div {
            p {
                +" + $lineText x"
            }
        }
    }

    override fun clearLines() {
        linesHolder.clear()
    }

    override fun dispose() {
        unregister()
    }

    private fun register() {
        addButton.addEventListener("click", buttonHandler)
        input.addEventListener("keypress", inputHandler)
    }

    private fun unregister() {
        addButton.removeEventListener("click", buttonHandler)
        input.removeEventListener("keypress", inputHandler)
    }
}