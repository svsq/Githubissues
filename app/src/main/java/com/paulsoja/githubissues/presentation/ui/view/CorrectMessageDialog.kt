package com.paulsoja.githubissues.presentation.ui.view

import android.content.Context
import android.text.TextUtils
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.paulsoja.githubissues.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CorrectMessageDialog @Inject constructor() {

    private var dialog: AlertDialog? = null

    fun show(
        context: Context,
        message: String,
        title: String? = null,
        okListener: (() -> Unit)? = null,
        okText: String? = null,
        negativeListener: (() -> Unit)? = null,
        negativeText: String? = null

    ) {
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
                dialog = this.create()
                dialog?.show()
            }

        val color = ContextCompat.getColor(context, R.color.blue)
        dialog?.getButton(AlertDialog.BUTTON_POSITIVE)?.setTextColor(color)
        dialog?.getButton(AlertDialog.BUTTON_NEGATIVE)?.setTextColor(color)
    }

    fun show(context: Context, @StringRes message: Int, @StringRes title: Int? = null, okListener: (() -> Unit)? = null) {
        val messageString = context.getString(message)
        var titleString: String? = null
        title?.let {
            titleString = context.getString(it)
        }
        show(context, messageString, titleString, okListener)
    }

    fun hide() {
        dialog?.dismiss()
        dialog = null
    }

    fun isVisible(): Boolean {
        return dialog != null && dialog!!.isShowing
    }

}