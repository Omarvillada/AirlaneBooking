package presentation

import domine.presentation.Formatter

interface PresentationFactory<T> {
    fun getPresentationFormat(format: PresentationFormat): Formatter<T>


}