package com.bitsden.notable.web.lines

interface LinesView {
    var presenter: LinesPresenter
    var inputText: String
    fun focusInput()
    fun addLine(lineText: String)
    fun clearLines()
    fun dispose()
}