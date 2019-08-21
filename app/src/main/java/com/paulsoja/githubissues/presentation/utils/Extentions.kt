package com.paulsoja.githubissues.presentation.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.text.Editable
import android.text.TextWatcher
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.snackbar.Snackbar
import com.jakewharton.rxbinding.view.clicks
import com.paulsoja.githubissues.R
import com.paulsoja.githubissues.domain.model.TypeEnum
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.android.support.SupportAppScreen
import ru.terrakok.cicerone.commands.BackTo
import ru.terrakok.cicerone.commands.Replace
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

inline fun <reified T : Enum<T>> getEnumTypeValue(type: String): T? {
  val values = enumValues<T>()
  return values.firstOrNull {
    it is TypeEnum && (it as TypeEnum).type.equals(type, true)
  }
}

/**
 * those clicks ignore fast series of clicks to prevent multiple action calls like openDialog
 */
fun View.onClick(call: () -> Unit) {
  clicks().throttleFirst(500, TimeUnit.MILLISECONDS).subscribe { empty ->
    call.invoke()
  }
}

/**
 * normal click listener alias
 */
fun View.onFastClick(call: () -> Unit) {
  setOnClickListener {
    call.invoke()
  }
}

fun Navigator.setLaunchScreen(screen: SupportAppScreen) {
  applyCommands(
    arrayOf(
      BackTo(null),
      Replace(screen)
    )
  )
}

fun FragmentActivity.hideKeyboard() {
  val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  //Find the currently focused view, so we can grab the correct window token from it.
  var view = currentFocus
  //If no view currently has focus, create a new one, just so we can grab a window token from it
  if (view == null) {
    view = View(this)
  }
  imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Fragment.hideKeyboard() {
  val v = view?.findFocus()
  val imm = requireContext().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  imm.hideSoftInputFromWindow(v?.windowToken, 0)

}

fun Dialog.hideKeyboard() {
  val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
  //Find the currently focused view, so we can grab the correct window token from it.
  var view = currentFocus
  //If no view currently has focus, create a new one, just so we can grab a window token from it
  if (view == null) {
    view = View(context)
  }
  imm.hideSoftInputFromWindow(view.windowToken, 0)
}

fun ImageView.tint(colorRes: Int) = this.setColorFilter(this.context.color(colorRes))

fun Context.color(colorRes: Int) = ContextCompat.getColor(this, colorRes)

fun Context.drawable(drawableRes: Int) = ContextCompat.getDrawable(this, drawableRes)

fun Fragment.showSnackMessage(message: String) {
  view?.let {
    val snackbar = Snackbar.make(it, message, Snackbar.LENGTH_LONG)
    val messageTextView = snackbar.view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    messageTextView.setTextColor(Color.WHITE)
    snackbar.show()
  }
}

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
  LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

fun View.hideIfVisible() {
  if (!isVisible) return
  isVisible = false
}

fun View.showIfNotVisible() {
  if (isVisible) return
  isVisible = true
}

fun RecyclerView.doOnNextPage(call: () -> Unit, scrollOffset: Int = 4) {
  addOnScrollListener(object : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
      with(recyclerView.layoutManager as LinearLayoutManager) {
        val lastVisibleItemPosition = findLastVisibleItemPosition()
        if ((itemCount - lastVisibleItemPosition) <= scrollOffset) call.invoke()
      }
    }
  })
}

fun BottomSheetBehavior<View>.showBottomSheet(show: Boolean = true) {
  state = if (show) BottomSheetBehavior.STATE_EXPANDED else BottomSheetBehavior.STATE_COLLAPSED
}

fun BottomSheetBehavior<View>.hideIfVisible() {
  if (state == BottomSheetBehavior.STATE_EXPANDED) showBottomSheet(false)
}

fun EditText.setEnterButtonAction(action: () -> Unit) {
  setOnEditorActionListener { _, actionId, _ ->
    if (actionId == EditorInfo.IME_ACTION_SEND
      || actionId == EditorInfo.IME_ACTION_DONE
      || actionId == EditorInfo.IME_ACTION_GO
      || actionId == EditorInfo.IME_ACTION_NONE
      || actionId == EditorInfo.IME_ACTION_SEARCH
    ) {
      action()
    }
    return@setOnEditorActionListener false
  }
}

fun View.dimView(show: Boolean, duration: Long = 300, endListener: (() -> Unit)? = null) {
  isEnabled = show
  if (show) alpha = 0f
  ViewCompat.animate(this)
    .alpha(if (show) 1f else 0f)
    .setDuration(duration)
    .setListener(object : ViewPropertyAnimatorListener {
      override fun onAnimationEnd(view: View) {
        view.visibility = if (show) View.VISIBLE else View.GONE
        alpha = 1f
        endListener?.invoke()
      }

      override fun onAnimationCancel(view: View) {
        view.visibility = View.GONE
      }

      override fun onAnimationStart(view: View) {
        view.visibility = View.VISIBLE
      }
    })
    .withLayer()
    .start()
}

fun View.slideUpView(show: Boolean, duration: Long = 200, updateListener: ((y: Float) -> Unit)? = null) {
  isEnabled = show
  if (show) translationY = 400f // stub
  ViewCompat.animate(this)
    .translationY(if (show) 0f else height.toFloat())
    .setDuration(duration)
    .setInterpolator(null)
    .setListener(object : ViewPropertyAnimatorListener {
      override fun onAnimationEnd(view: View) {
        view.visibility = if (show) View.VISIBLE else View.GONE
      }

      override fun onAnimationCancel(view: View) {
        view.visibility = View.GONE
      }

      override fun onAnimationStart(view: View) {
        view.visibility = View.VISIBLE
      }
    })
    .setUpdateListener {
      val visiblePart = it.height - it.translationY
      updateListener?.invoke(if (visiblePart > 0) visiblePart else 0f)
    }
    .withLayer()
    .start()
}

fun View.postDraw(block: () -> Unit) {
  this.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
    override fun onLayoutChange(
      v: View?, left: Int, top: Int, right: Int, bottom: Int,
      oldLeft: Int, oldTop: Int, oldRight: Int, oldBottom: Int
    ) {
      removeOnLayoutChangeListener(this)
      block.invoke()
    }
  })
}

fun Fragment.shareText(text: String?) {
  text?.let {
    startActivity(
      Intent.createChooser(
        Intent(Intent.ACTION_SEND).apply {
          type = "text/plain"
          putExtra(Intent.EXTRA_TEXT, text)
        },
        "Share to"
      )
    )
  }
}

fun Fragment.sendEmail(email: String?) {
  if (email != null) {
    startActivity(
      Intent.createChooser(
        Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null)),
        null
      )
    )
  }
}

fun Fragment.toast(text: String, length: Int = Toast.LENGTH_SHORT) {
  Toast.makeText(context, text, length).show()
}

fun Fragment.toast(@StringRes textRes: Int) {
  val text = context?.getString(textRes) ?: return
  toast(text)
}

fun View.setBackgroundTintByColor(@ColorInt color: Int) {
  val wrappedDrawable = DrawableCompat.wrap(background)
  DrawableCompat.setTint(wrappedDrawable.mutate(), color)
}

fun Context.dpToPx(valueInDp: Float): Float {
  return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, valueInDp, resources.displayMetrics)
}

fun EditText.onChange(cb: (String) -> Unit) {
  this.addTextChangedListener(object : TextWatcher {
    override fun afterTextChanged(s: Editable?) {
      cb(s.toString())
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
  })
}

fun AppCompatActivity.setStatusBarColor(color: Int) {
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
    var flags = window.decorView.systemUiVisibility
    if (color != R.color.green) {
      flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
      flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
      flags = flags xor View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }
    window.decorView.systemUiVisibility = flags
    window.statusBarColor = ContextCompat.getColor(this, color)
  }
}

fun Calendar.getUkrainianFullDate(): String {
  val stringBuilder = StringBuilder()
  val day = get(Calendar.DAY_OF_MONTH)
  stringBuilder.append("$day ")
  stringBuilder.append(
    when (get(Calendar.MONTH)) {
      Calendar.JANUARY -> "Січня"
      Calendar.FEBRUARY -> "Лютого"
      Calendar.MARCH -> "Березня"
      Calendar.APRIL -> "Квітня"
      Calendar.MAY -> "Травня"
      Calendar.JUNE -> "Червня"
      Calendar.JULY -> "Липня"
      Calendar.AUGUST -> "Серпня"
      Calendar.SEPTEMBER -> "Вересня"
      Calendar.OCTOBER -> "Жовтня"
      Calendar.NOVEMBER -> "Листопада"
      Calendar.DECEMBER -> "Грудня"
      else -> ""
    }
  )
  return stringBuilder.toString()
}

fun Long.getTimerFormatTime(): String {
  val calendar = Calendar.getInstance()
  calendar.timeInMillis = this
  val dateFormat = SimpleDateFormat("H:mm:ss", Locale.US)
  dateFormat.timeZone = TimeZone.getTimeZone("GMT")
  return dateFormat.format(calendar.time)
}

@SuppressLint("ClickableViewAccessibility")
fun TextView.onRightDrawableClicked(onClicked: (view: TextView) -> Unit) {
  this.setOnTouchListener { v, event ->
    var hasConsumed = false
    if (v is TextView) {
      if (event.x >= v.width - v.totalPaddingRight) {
        if (event.action == MotionEvent.ACTION_UP) {
          onClicked(this)
        }
        hasConsumed = true
      }
    }
    hasConsumed
  }
}


fun Resources.getStatusBarSize(): Int {
  var result = 0
  val resourceId = getIdentifier("status_bar_height", "dimen", "android")
  if (resourceId > 0) {
    result = getDimensionPixelSize(resourceId)
  }
  return result
}

fun <T> Collection<T>.joinToString(
  separator: String = ", ",
  prefix: String = "",
  postfix: String = ""
): String {
  val result = StringBuilder(prefix)

  for ((index, element) in this.withIndex()) {
    if (index == 0) {
      result.append(element.toString().capitalize())
    }
    if (index > 0) {
      result.append(separator)
      result.append(element)
    }
  }

  result.append(postfix)
  return result.toString()
}

fun numberWithSpaces(number: Float): String {
  val formatSymbols = DecimalFormatSymbols(Locale.US)
  formatSymbols.decimalSeparator = '.'
  formatSymbols.groupingSeparator = ' '
  val decimalFormat = DecimalFormat("###,###,##0.00", formatSymbols)
  return decimalFormat.format(number)
}