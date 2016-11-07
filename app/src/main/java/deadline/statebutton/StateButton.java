package deadline.statebutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.widget.Button;

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
    private int mRadius = 0;

    /**
     * 设置stroke的宽度
     */
    private int mStrokeWidth = 0;

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

    private StateListDrawable mBackgroundStateList;


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
/*
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public StateButton(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }*/

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

        ShapeDrawable shapeDrawable = new ShapeDrawable();

        a.recycle();
    }

    /****************** stroke color *********************/

    public int getNormalStrokeColor() {
        return mNormalStrokeColor;
    }

    public void setNormalStrokeColor(int normalStrokeColor) {
        this.mNormalStrokeColor = normalStrokeColor;
    }

    public int getPressedStrokeColor() {
        return mPressedStrokeColor;
    }

    public void setPressedStrokeColor(int pressedStrokeColor) {
        this.mPressedStrokeColor = pressedStrokeColor;
    }

    public int getUnableStrokeColor() {
        return mUnableStrokeColor;
    }

    public void setUnableStrokeColor(int unableStrokeColor) {
        this.mUnableStrokeColor = unableStrokeColor;
    }



    /********************  background color  **********************/

    public int getNormalBackgroundColor() {
        return mNormalBackgroundColor;
    }

    public void setNormalBackgroundColor(int normalBackgroundColor) {
        this.mNormalBackgroundColor = normalBackgroundColor;
    }

    public int getPressedBackgroundColor() {
        return mPressedBackgroundColor;
    }

    public void setPressedBackgroundColor(int pressedBackgroundColor) {
        this.mPressedBackgroundColor = pressedBackgroundColor;
    }

    public int getUnableBackgroundColor() {
        return mUnableBackgroundColor;
    }

    public void setUnableBackgroundColor(int unableBackgroundColor) {
        this.mUnableBackgroundColor = unableBackgroundColor;
    }


    public int getStrokeWidth() {
        return mStrokeWidth;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.mStrokeWidth = strokeWidth;
    }

    public int getRadius() {
        return mRadius;
    }

    public void setRadius(int radius) {
        this.mRadius = radius;
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

    public int getNormalTextColor() {
        return mNormalTextColor;
    }

    public void setNormalTextColor(int normalTextColor) {
        if(normalTextColor != mNormalTextColor) {
            this.mNormalTextColor = normalTextColor;
            setTextColor();
        }
    }
    public int getPressedTextColor() {
        return mPressedTextColor;
    }

    public void setPressedTextColor(int pressedTextColor) {
        if(pressedTextColor != mPressedTextColor) {
            this.mPressedTextColor = pressedTextColor;
            setTextColor();
        }
    }

    public int getUnableTextColor() {
        return mUnableTextColor;
    }

    public void setUnableTextColor(int unableTextColor) {
        if(unableTextColor != mUnableTextColor) {
            this.mUnableTextColor = unableTextColor;
            setTextColor();
        }
    }
}
