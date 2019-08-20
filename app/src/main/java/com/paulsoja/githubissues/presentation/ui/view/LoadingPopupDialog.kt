package com.paulsoja.githubissues.presentation.ui.view

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView
import com.paulsoja.githubissues.R

class LoadingPopupDialog(inflater: LayoutInflater) : PopupWindow() {

    private val loadingHint: TextView

    init {
        contentView = inflater.inflate(R.layout.dialog_loading, null)
        loadingHint = contentView.findViewById(R.id.loadingHint)
        width = LinearLayout.LayoutParams.MATCH_PARENT
        height = LinearLayout.LayoutParams.MATCH_PARENT
        isFocusable = false
        inputMethodMode = INPUT_METHOD_NOT_NEEDED
    }

    fun show() {
        showAtLocation(contentView, Gravity.CENTER, 0, 0)
    }

    fun show(view: View) {
        showAtLocation(view, Gravity.CENTER, 0, 0)
    }

    fun hide() {
        dismiss()
    }

    fun setText(textResource: Int) {
        loadingHint.setText(textResource)
    }

    fun setText(text: String) {
        loadingHint.text = text
    }

}