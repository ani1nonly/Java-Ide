package com.pranav.android.code.formatter

import com.google.googlejavaformat.java.Formatter
import com.google.googlejavaformat.java.FormatterException
import com.google.googlejavaformat.java.JavaFormatterOptions

class GoogleJavaFormatter(input: String) {

    private val source: String

    init {
        source = input
    }

    fun format(): String {
        val options =
                JavaFormatterOptions.builder()
                        .style(JavaFormatterOptions.Style.AOSP) // Use AOSP formatting style
                        .formatJavadoc(true) // Format Javadoc with code
                        .build()
        val formatter = Formatter(options)
        try {
            return formatter.formatSourceAndFixImports(source)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return source
    }
}
