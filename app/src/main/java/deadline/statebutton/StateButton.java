package deadline.statebutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * @author deadline
 * @time 2016-11-07
 */

public class StateButton extends AppCompatButton{

    /**
     * 正常显示的文字颜色
     */
    private int mNormalTextColor = 0;

    /**
     * 按下时的文字颜色
     */
    private int mPressedTextColor = 0;

    /**
     * 不可用时的文字颜色
     */
    private int mUnableTextColor = 0;

    /**
     * 给背景设置圆角
     */
    private float mRadius = 0;

    /**
     * 设置stroke的宽度
     */
    private int mStrokeWidth = 0;

    /**
     * dash width
     */
    private float mStrokeDashWidth = 0;

    /**
     * dash gap width
     */
    private float mStrokeDashGap = 0;

    /**
     * 设置stroke正常颜色
     */
    private int mNormalStrokeColor = 0;

    /**
     * 设置stroke按下时颜色
     */
    private int mPressedStrokeColor = 0;

    /**
     * 设置stroke不可用时的颜色
     */
    private int mUnableStrokeColor = 0;

    /**
     * 设置正常的背景颜色
     */
    private int mNormalBackgroundColor = 0;

    /**
     *
     * 设置按下时的背景颜色
     */
    private int mPressedBackgroundColor = 0;

    /**
     * 设置不可用时的背景颜色
     */
    private int mUnableBackgroundColor = 0;


    int[][] states;

    private ColorStateList mTextColorStateList;

    private ColorStateList mBackgroundStateList;

    private ColorStateList mStrokeStateList;

    private GradientDrawable mBackground;


    public StateButton(Context context) {
        this(context, null);
    }

    public StateButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(attrs);
    }

    //属性获取各种颜色值
    private void setup(AttributeSet attrs) {

        states = new int[4][];

        //pressed, focused, normal, unable
        states[0] = new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled };
        states[1] = new int[] { android.R.attr.state_enabled, android.R.attr.state_focused };
        states[2] = new int[] { android.R.attr.state_enabled };
        states[3] = new int[] { android.R.attr.state_window_focused};

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StateButton);

        //获取TextView中的文字颜色
        mTextColorStateList = getTextColors();
        int mDefaultNormalTextColor = mTextColorStateList.getColorForState(states[2], getCurrentTextColor());
        int mDefaultPressedTextColor = mTextColorStateList.getColorForState(states[0], getCurrentTextColor());
        int mDefaultUnableTextColor = mTextColorStateList.getColorForState(states[3], getCurrentTextColor());
        mNormalTextColor = a.getColor(R.styleable.StateButton_normalTextColor, mDefaultNormalTextColor);
        mPressedTextColor = a.getColor(R.styleable.StateButton_pressedTextColor, mDefaultPressedTextColor);
        mUnableTextColor = a.getColor(R.styleable.StateButton_unableTextColor, mDefaultUnableTextColor);
        setTextColor();

        if(mBackground == null){
            mBackground = new GradientDrawable();
        }

        //获取背景颜色
        mNormalBackgroundColor = a.getColor(R.styleable.StateButton_normalBackgroundColor, 0);
        mPressedBackgroundColor = a.getColor(R.styleable.StateButton_pressedBackgroundColor, 0);
        mUnableBackgroundColor = a.getColor(R.styleable.StateButton_unableBackgroundColor, 0);

        mStrokeWidth = a.getDimensionPixelSize(R.styleable.StateButton_strokeWidth, 0);
        mRadius = a.getDimensionPixelSize(R.styleable.StateButton_radius, 0);
        mStrokeDashWidth = a.getDimensionPixelSize(R.styleable.StateButton_strokeDashWidth, 0);
        mStrokeDashGap = a.getDimensionPixelSize(R.styleable.StateButton_strokeDashWidth, 0);

        mNormalStrokeColor = a.getColor(R.styleable.StateButton_normalStrokeColor, 0);
        mPressedStrokeColor = a.getColor(R.styleable.StateButton_pressedStrokeColor, 0);
        mUnableStrokeColor = a.getColor(R.styleable.StateButton_unableStrokeColor, 0);

        int[] colors = new int[] {mPressedStrokeColor, mPressedStrokeColor,
                                                mNormalStrokeColor, mUnableStrokeColor};
        mStrokeStateList = new ColorStateList(states, colors);

        int[] bgColors = new int[] {mPressedBackgroundColor, mPressedBackgroundColor,
                                                mNormalBackgroundColor, mUnableBackgroundColor};
        mBackgroundStateList = new ColorStateList(states, bgColors);
        mBackground.setColor(mBackgroundStateList);

        mBackground.setCornerRadius(mRadius);
        setStroke();
        a.recycle();

        StateListDrawable drawable = new StateListDrawable();
        drawable.setEnterFadeDuration();
        drawable.setExitFadeDuration();
    }

    /****************** stroke color *********************/

    public void setNormalStrokeColor(int normalStrokeColor) {
        this.mNormalStrokeColor = normalStrokeColor;
        setStrokeColor();
        setStroke();
    }

    public void setPressedStrokeColor(int pressedStrokeColor) {
        this.mPressedStrokeColor = pressedStrokeColor;
        setStrokeColor();
        setStroke();
    }

    public void setUnableStrokeColor(int unableStrokeColor) {
        this.mUnableStrokeColor = unableStrokeColor;
        setStrokeColor();
        setStroke();
    }

    public void setStateStrokeColor(int normal, int pressed, int unable){
        mNormalStrokeColor = normal;
        mPressedStrokeColor = pressed;
        mUnableStrokeColor = unable;
        setStrokeColor();
        setStroke();
    }

    private void setStrokeColor(){
        int[] colors = new int[] {mPressedStrokeColor, mPressedStrokeColor, mNormalStrokeColor, mUnableStrokeColor};
        mStrokeStateList = new ColorStateList(states, colors);
    }

    public void setStrokeWidth(int strokeWidth) {
        this.mStrokeWidth = strokeWidth;
        setStroke();
    }

    public void setStrokeDashWidth(float strokeDashWidth) {
        this.mStrokeDashWidth = strokeDashWidth;
        setStroke();
    }

    public void setStrokeDashGap(float strokeDashGap) {
        this.mStrokeDashGap = strokeDashGap;
        setStroke();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setStroke() {
        mBackground.setStroke(mStrokeWidth, mStrokeStateList, mStrokeDashWidth, mStrokeDashGap);
        setBackgroundDrawable(mBackground);
    }

    /********************   radius  *******************************/

    public void setRadius(float radius) {
        this.mRadius = radius;
        mBackground.setCornerRadius(mRadius);
        setBackgroundDrawable(mBackground);
    }

    public void setRadius(float[] radii){
        mBackground.setCornerRadii(radii);
        setBackgroundDrawable(mBackground);
    }

    /********************  background color  **********************/

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setBackgroundColor(){
        int[] colors = new int[] {mPressedBackgroundColor, mPressedBackgroundColor, mNormalBackgroundColor, mUnableBackgroundColor};
        mBackgroundStateList = new ColorStateList(states, colors);
        mBackground.setColor(mBackgroundStateList);
        setBackgroundDrawable(mBackground);
    }

    public void setStateBackgroundColor(int normal, int pressed, int unable){
        mPressedBackgroundColor = normal;
        mNormalBackgroundColor = pressed;
        mUnableBackgroundColor = unable;
        setBackgroundColor();
    }

    public void setNormalBackgroundColor(int normalBackgroundColor) {
        this.mNormalBackgroundColor = normalBackgroundColor;
        setBackgroundColor();
    }

    public void setPressedBackgroundColor(int pressedBackgroundColor) {
        this.mPressedBackgroundColor = pressedBackgroundColor;
        setBackgroundColor();
    }

    public void setUnableBackgroundColor(int unableBackgroundColor) {
        this.mUnableBackgroundColor = unableBackgroundColor;
        setBackgroundColor();
    }



    /***************  text color   ***********************/
    /**
     * reset text colors
     */
    private void setTextColor() {
        int[] colors = new int[] {mPressedTextColor, mPressedTextColor, mNormalTextColor, mUnableTextColor};
        mTextColorStateList = new ColorStateList(states, colors);
        setTextColor(mTextColorStateList);
    }

    public void setStateTextColor(int normal, int pressed, int unable){
        this.mNormalTextColor = normal;
        this.mPressedTextColor = pressed;
        this.mUnableTextColor = unable;
        setTextColor();
    }

    public void setNormalTextColor(int normalTextColor) {
        this.mNormalTextColor = normalTextColor;
        setTextColor();

    }

    public void setPressedTextColor(int pressedTextColor) {
        this.mPressedTextColor = pressedTextColor;
        setTextColor();
    }

    public void setUnableTextColor(int unableTextColor) {
        this.mUnableTextColor = unableTextColor;
        setTextColor();
    }
}
