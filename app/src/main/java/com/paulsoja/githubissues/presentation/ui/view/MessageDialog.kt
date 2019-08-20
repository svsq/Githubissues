package com.paulsoja.githubissues.presentation.ui.view

import android.content.Context
import android.text.TextUtils
import android.widget.Button
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.paulsoja.githubissues.R

object MessageDialog {

    fun show(
        context: Context,
        message: String,
        title: String? = null,
        okListener: (() -> Unit)? = null,
        okText: String? = null,
        negativeListener: (() -> Unit)? = null,
        negativeText: String? = null

    ) {
        val messageDialog: AlertDialog
        AlertDialog.Builder(context, R.style.CustomDialogTheme)
            .apply {
                val positiveText =
                    if (TextUtils.isEmpty(okText)) {
                        context.getString(R.string.ok)
                    } else okText
                setTitle(title)
                setMessage(message)
                setCancelable(true)
                setPositiveButton(positiveText) { dialog, _ ->
                    dialog.dismiss()
                    okListener?.invoke()
                }
                if (!TextUtils.isEmpty(negativeText)) {
                    setNegativeButton(negativeText) { dialog, _ ->
                        dialog.dismiss()
                        negativeListener?.invoke()
                    }
                }
                messageDialog = this.create()
                messageDialog.show()
            }

        val color = ContextCompat.getColor(context, R.color.blue)
        (messageDialog.getButton(AlertDialog.BUTTON_POSITIVE) as Button).setTextColor(color)
        (messageDialog.getButton(AlertDialog.BUTTON_NEGATIVE) as Button).setTextColor(color)

    }

    fun show(context: Context, @StringRes message: Int, @StringRes title: Int? = null, okListener: (() -> Unit)? = null) {
        val messageString = context.getString(message)
        var titleString: String? = null
        title?.let {
            titleString = context.getString(it)
        }
        show(context, messageString, titleString, okListener)
    }

}