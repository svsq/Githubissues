package com.paulsoja.githubissues.presentation.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener

class LoadingView @JvmOverloads constructor(
  context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

  init {
    startAnimation()
  }

  private fun startAnimation() {
    rotation = 0f
    ViewCompat.animate(this)
      .rotation(360f)
      .setDuration(1000L)
      .setInterpolator(null)
      .setListener(object : ViewPropertyAnimatorListener {
        override fun onAnimationEnd(view: View?) {}

        override fun onAnimationCancel(view: View?) {}

        override fun onAnimationStart(view: View?) {}
      })
      .withEndAction {
        startAnimation()
      }
      .start()
  }

}