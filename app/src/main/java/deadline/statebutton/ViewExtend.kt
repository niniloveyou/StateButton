package deadline.statebutton

import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable
import android.support.annotation.NonNull
import android.support.v4.view.ViewCompat
import android.view.View
import android.widget.TextView

/**
 * @author deadline
 * @time 2018/7/19
 */
fun View.setState(@NonNull config: StateConfig) {

    //pressed, focused, normal, unable
    val states = arrayOf(intArrayOf(android.R.attr.state_enabled, android.R.attr.state_pressed),
                        intArrayOf(android.R.attr.state_enabled, android.R.attr.state_focused),
                        intArrayOf(-android.R.attr.state_enabled),
                        intArrayOf(android.R.attr.state_enabled))


    val mNormalBackground = GradientDrawable()
    val mPressedBackground = GradientDrawable()
    val mUnableBackground = GradientDrawable()

    var mStateBackground: StateListDrawable? = null
    val drawable = background
    mStateBackground = if (drawable != null && drawable is StateListDrawable) drawable else StateListDrawable()

    applyState(mNormalBackground, config.normalBackgroundColor, config.radius,
            config.normalStrokeWidth, config.normalStrokeColor,
            config.strokeDashWidth, config.strokeDashGap)

    applyState(mPressedBackground, config.pressedBackgroundColor, config.radius,
            config.pressedStrokeWidth, config.pressedStrokeColor,
            config.strokeDashWidth, config.strokeDashGap)

    applyState(mUnableBackground, config.unableBackgroundColor, config.radius,
            config.unableStrokeWidth, config.unableStrokeColor,
            config.strokeDashWidth, config.strokeDashGap)


    if (this@setState is TextView) {

        val colors = intArrayOf(config.pressedTextColor, config.pressedTextColor, config.unableTextColor, config.normalTextColor)
        setTextColor(ColorStateList(states, colors))
    }

    mStateBackground.addState(states[0], mPressedBackground)
    mStateBackground.addState(states[1], mPressedBackground)
    mStateBackground.addState(states[2], mUnableBackground)
    mStateBackground.addState(states[3], mNormalBackground)

    mStateBackground.apply {
        setEnterFadeDuration(config.duration)
    }

    ViewCompat.setBackground(this@setState, mStateBackground)
}

private fun applyState(drawable: GradientDrawable,
                       backgroundColor: Int, radius: Float,
                       strokeWidth: Int, strokeColor: Int,
                       strokeDashWidth: Float, strokeDashGap: Float) {

    drawable.apply {
        setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap)
        setColor(backgroundColor)
        cornerRadius = radius
    }
}

