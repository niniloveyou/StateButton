package deadline.statebutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.IntRange;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * Created by deadline on 2017/1/11.
 * 根据用户点击状态设置不同的图片
 */

public class StateImageView extends AppCompatImageView {

    private Drawable mNormalDrawable;

    private Drawable mPressedDrawable;

    private Drawable mUnableDrawable;

    private int mDuration = 0;

    private int[][] states;

    private StateListDrawable mStateBackground;

    public StateImageView(Context context) {
        this(context, null);
    }

    public StateImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StateImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        states = new int[4][];
        states[0] = new int[] { android.R.attr.state_pressed, android.R.attr.state_enabled };
        states[1] = new int[] { android.R.attr.state_enabled, android.R.attr.state_focused };
        states[3] = new int[] { -android.R.attr.state_enabled };
        states[2] = new int[] { android.R.attr.state_enabled };

        Drawable drawable = getBackground();
        if(drawable != null && drawable instanceof StateListDrawable){
            mStateBackground = (StateListDrawable) drawable;
        }else{
            mStateBackground = new StateListDrawable();
        }

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.StateImageView);

        mNormalDrawable = a.getDrawable(R.styleable.StateImageView_normalBackground);
        mPressedDrawable = a.getDrawable(R.styleable.StateImageView_pressedBackground);
        mUnableDrawable = a.getDrawable(R.styleable.StateImageView_unableBackground);
        setStateBackground(mNormalDrawable, mPressedDrawable, mUnableDrawable);

        mDuration = a.getInteger(R.styleable.StateImageView_AnimationDuration, mDuration);
        setAnimationDuration(mDuration);
        a.recycle();
    }

    /**
     * 设置不同状态下的背景
     * @param normal
     * @param pressed
     * @param unable
     */
    public void setStateBackground(Drawable normal, Drawable pressed, Drawable unable){
        this.mNormalDrawable = normal;
        this.mPressedDrawable = pressed;
        this.mUnableDrawable = unable;

        //set background
        if(mPressedDrawable != null) {
            mStateBackground.addState(states[0], mPressedDrawable);
            mStateBackground.addState(states[1], mPressedDrawable);
        }

        if(mUnableDrawable != null) {
            mStateBackground.addState(states[3], mUnableDrawable);
        }

        if(mNormalDrawable != null) {
            mStateBackground.addState(states[2], mNormalDrawable);
        }
        setBackgroundDrawable(mStateBackground);
    }

    /**
     * 设置动画时长
     * @param duration
     */
    public void setAnimationDuration(@IntRange(from = 0)int duration){
        this.mDuration = duration;
        mStateBackground.setEnterFadeDuration(mDuration);
        mStateBackground.setExitFadeDuration(mDuration);
    }

}
