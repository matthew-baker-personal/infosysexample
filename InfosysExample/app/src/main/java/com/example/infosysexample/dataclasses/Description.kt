package com.example.infosysexample.dataclasses



data class Description(val value: String?, val attributes: Attributes) {
    companion object {
        val default=Description("default",Attributes.default)
    }
}
