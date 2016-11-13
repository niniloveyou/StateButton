package deadline.statebutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * @author deadline
 * @time 2016-11-07
 */

public class StateButton extends AppCompatButton{

    //text color
    private int mNormalTextColor = 0;
    private int mPressedTextColor = 0;
    private int mUnableTextColor = 0;
    ColorStateList mTextColorStateList;

    //animation duration
    private int mDuration = 0;

    //radius
    private float mRadius = 0;
    private boolean mRound;

    //stroke
    private float mStrokeDashWidth = 0;
    private float mStrokeDashGap = 0;
    private int mNormalStrokeWidth = 0;
    private int mPressedStrokeWidth = 0;
    private int mUnableStrokeWidth = 0;
    private int mNormalStrokeColor = 0;
    private int mPressedStrokeColor = 0;
    private int mUnableStrokeColor = 0;

    //background color
    private int mNormalBackgroundColor = 0;
    private int mPressedBackgroundColor = 0;
    private int mUnableBackgroundColor = 0;

    private GradientDrawable mNormalBackground;
    private GradientDrawable mPressedBackground;
    private GradientDrawable mUnableBackground;

    private int[][] states;

    StateListDrawable mStateBackground;


    public StateButton(Context context) {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attrs) {
        this(context, attrs, android.support.v7.appcompat.R.attr.buttonStyle);
    }

    public StateButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(attrs);
    }

    private void setup(AttributeSet attrs) {

        states = new int[4][];

        Drawable drawable = getBackground();
        if(drawable != null && drawable instanceof StateListDrawable){
            mStateBackground = (StateListDrawable) drawable;
        }else{
            mStateBackground = new StateListDrawable();
        }

        mNormalBackground = new GradientDrawable();
        mPressedBackground = new GradientDrawable();
        mUnableBackground = new GradientDrawable();

        //pressed, focused, normal, unable
        states[0] = new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled };
        states[1] = new int[] { android.R.attr.state_enabled, android.R.attr.state_focused };
        states[2] = new int[] { android.R.attr.state_enabled };
        states[3] = new int[] { android.R.attr.state_window_focused };

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StateButton);

        //get original text color as default
        //set text color
        mTextColorStateList = getTextColors();
        int mDefaultNormalTextColor = mTextColorStateList.getColorForState(states[2], getCurrentTextColor());
        int mDefaultPressedTextColor = mTextColorStateList.getColorForState(states[0], getCurrentTextColor());
        int mDefaultUnableTextColor = mTextColorStateList.getColorForState(states[3], getCurrentTextColor());
        mNormalTextColor = a.getColor(R.styleable.StateButton_normalTextColor, mDefaultNormalTextColor);
        mPressedTextColor = a.getColor(R.styleable.StateButton_pressedTextColor, mDefaultPressedTextColor);
        mUnableTextColor = a.getColor(R.styleable.StateButton_unableTextColor, mDefaultUnableTextColor);
        setTextColor();

        //set animation duration
        mDuration = a.getInteger(R.styleable.StateButton_animationDuration, mDuration);
        mStateBackground.setEnterFadeDuration(mDuration);

        //set background color
        mNormalBackgroundColor = a.getColor(R.styleable.StateButton_normalBackgroundColor, 0);
        mPressedBackgroundColor = a.getColor(R.styleable.StateButton_pressedBackgroundColor, 0);
        mUnableBackgroundColor = a.getColor(R.styleable.StateButton_unableBackgroundColor, 0);
        mNormalBackground.setColor(mNormalBackgroundColor);
        mPressedBackground.setColor(mPressedBackgroundColor);
        mUnableBackground.setColor(mUnableBackgroundColor);

        //set radius
        mRadius = a.getDimensionPixelSize(R.styleable.StateButton_radius, 0);
        mRound = a.getBoolean(R.styleable.StateButton_round, false);
        mNormalBackground.setCornerRadius(mRadius);
        mPressedBackground.setCornerRadius(mRadius);
        mUnableBackground.setCornerRadius(mRadius);

        //set stroke
        mStrokeDashWidth = a.getDimensionPixelSize(R.styleable.StateButton_strokeDashWidth, 0);
        mStrokeDashGap = a.getDimensionPixelSize(R.styleable.StateButton_strokeDashWidth, 0);
        mNormalStrokeWidth = a.getDimensionPixelSize(R.styleable.StateButton_normalStrokeWidth, 0);
        mPressedStrokeWidth = a.getDimensionPixelSize(R.styleable.StateButton_pressedStrokeWidth, 0);
        mUnableStrokeWidth = a.getDimensionPixelSize(R.styleable.StateButton_unableStrokeWidth, 0);
        mNormalStrokeColor = a.getColor(R.styleable.StateButton_normalStrokeColor, 0);
        mPressedStrokeColor = a.getColor(R.styleable.StateButton_pressedStrokeColor, 0);
        mUnableStrokeColor = a.getColor(R.styleable.StateButton_unableStrokeColor, 0);
        setStroke();

        //set background
        mStateBackground.addState(states[0], mPressedBackground);
        mStateBackground.addState(states[1], mPressedBackground);
        mStateBackground.addState(states[2], mNormalBackground);
        mStateBackground.addState(states[3], mUnableBackground);
        setBackgroundDrawable(mStateBackground);
        a.recycle();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = getMeasuredHeight();
        if(mRound){
            setRadius(height / 2f);
        }
    }

    /****************** stroke color *********************/

    public void setNormalStrokeColor(@ColorInt int normalStrokeColor) {
        this.mNormalStrokeColor = normalStrokeColor;
        setStroke(mNormalBackground, mNormalStrokeColor, mNormalStrokeWidth);
    }

    public void setPressedStrokeColor(@ColorInt int pressedStrokeColor) {
        this.mPressedStrokeColor = pressedStrokeColor;
        setStroke(mPressedBackground, mPressedStrokeColor, mPressedStrokeWidth);
    }

    public void setUnableStrokeColor(@ColorInt int unableStrokeColor) {
        this.mUnableStrokeColor = unableStrokeColor;
        setStroke(mUnableBackground, mUnableStrokeColor, mUnableStrokeWidth);
    }

    public void setStateStrokeColor(@ColorInt int normal, @ColorInt int pressed, @ColorInt int unable){
        mNormalStrokeColor = normal;
        mPressedStrokeColor = pressed;
        mUnableStrokeColor = unable;
        setStroke();
    }

    /****************** stroke width *********************/

    public void setNormalStrokeWidth(int normalStrokeWidth) {
        this.mNormalStrokeWidth = normalStrokeWidth;
        setStroke(mNormalBackground, mNormalStrokeColor, mNormalStrokeWidth);
    }

    public void setPressedStrokeWidth(int pressedStrokeWidth) {
        this.mPressedStrokeWidth = pressedStrokeWidth;
        setStroke(mPressedBackground, mPressedStrokeColor, mPressedStrokeWidth);
    }

    public void setUnableStrokeWidth(int unableStrokeWidth) {
        this.mUnableStrokeWidth = unableStrokeWidth;
        setStroke(mUnableBackground, mUnableStrokeColor, mUnableStrokeWidth);
    }

    public void setStateStrokeWidth(int normal, int pressed, int unable){
        mNormalStrokeWidth = normal;
        mPressedStrokeWidth = pressed;
        mUnableStrokeWidth= unable;
        setStroke();
    }

    public void setStrokeDash(float strokeDashWidth, float strokeDashGap) {
        this.mStrokeDashWidth = strokeDashWidth;
        this.mStrokeDashGap = strokeDashWidth;
        setStroke();
    }

    private void setStroke(){
        setStroke(mNormalBackground, mNormalStrokeColor, mNormalStrokeWidth);
        setStroke(mPressedBackground, mPressedStrokeColor, mPressedStrokeWidth);
        setStroke(mUnableBackground, mUnableStrokeColor, mUnableStrokeWidth);
    }

    private void setStroke(GradientDrawable mBackground, int mStrokeColor, int mStrokeWidth) {
        mBackground.setStroke(mStrokeWidth, mStrokeColor, mStrokeDashWidth, mStrokeDashGap);
    }

    /********************   radius  *******************************/

    public void setRadius(@FloatRange(from = 0) float radius) {
        this.mRadius = radius;
        mNormalBackground.setCornerRadius(mRadius);
        mPressedBackground.setCornerRadius(mRadius);
        mUnableBackground.setCornerRadius(mRadius);
    }

    public void setRound(boolean round){
        this.mRound = round;
        int height = getMeasuredHeight();
        if(mRound){
            setRadius(height / 2f);
        }
    }

    public void setRadius(float[] radii){
        mNormalBackground.setCornerRadii(radii);
        mPressedBackground.setCornerRadii(radii);
        mUnableBackground.setCornerRadii(radii);
    }

    /********************  background color  **********************/

    public void setStateBackgroundColor(@ColorInt int normal, @ColorInt int pressed, @ColorInt int unable){
        mPressedBackgroundColor = normal;
        mNormalBackgroundColor = pressed;
        mUnableBackgroundColor = unable;
        mNormalBackground.setColor(mNormalBackgroundColor);
        mPressedBackground.setColor(mPressedBackgroundColor);
        mUnableBackground.setColor(mUnableBackgroundColor);
    }

    public void setNormalBackgroundColor(@ColorInt int normalBackgroundColor) {
        this.mNormalBackgroundColor = normalBackgroundColor;
        mNormalBackground.setColor(mNormalBackgroundColor);
    }

    public void setPressedBackgroundColor(@ColorInt int pressedBackgroundColor) {
        this.mPressedBackgroundColor = pressedBackgroundColor;
        mPressedBackground.setColor(mPressedBackgroundColor);
    }

    public void setUnableBackgroundColor(@ColorInt int unableBackgroundColor) {
        this.mUnableBackgroundColor = unableBackgroundColor;
        mUnableBackground.setColor(mUnableBackgroundColor);
    }

    /*******************alpha animation duration********************/
    public void setAnimationDuration(@IntRange(from = 0)int duration){
        this.mDuration = duration;
        mStateBackground.setEnterFadeDuration(mDuration);
    }

    /***************  text color   ***********************/

    private void setTextColor() {
        int[] colors = new int[] {mPressedTextColor, mPressedTextColor, mNormalTextColor, mUnableTextColor};
        mTextColorStateList = new ColorStateList(states, colors);
        setTextColor(mTextColorStateList);
    }

    public void setStateTextColor(@ColorInt int normal, @ColorInt int pressed, @ColorInt int unable){
        this.mNormalTextColor = normal;
        this.mPressedTextColor = pressed;
        this.mUnableTextColor = unable;
        setTextColor();
    }

    public void setNormalTextColor(@ColorInt int normalTextColor) {
        this.mNormalTextColor = normalTextColor;
        setTextColor();

    }

    public void setPressedTextColor(@ColorInt int pressedTextColor) {
        this.mPressedTextColor = pressedTextColor;
        setTextColor();
    }

    public void setUnableTextColor(@ColorInt int unableTextColor) {
        this.mUnableTextColor = unableTextColor;
        setTextColor();
    }
}
