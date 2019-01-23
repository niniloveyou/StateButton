package com.deadline.statebutton;

import android.support.annotation.ColorInt;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;

public final class StateConfig {

    //animation duration
    private int mDuration;

    //radius
    private float mRadius;

    //text color
    private int mNormalTextColor;
    private int mPressedTextColor;
    private int mUnableTextColor;

    //stroke
    private float mStrokeDashWidth;
    private float mStrokeDashGap;
    private int mNormalStrokeWidth;
    private int mPressedStrokeWidth;
    private int mUnableStrokeWidth;
    private int mNormalStrokeColor;
    private int mPressedStrokeColor;
    private int mUnableStrokeColor;

    //background color
    private int mNormalBackgroundColor;
    private int mPressedBackgroundColor;
    private int mUnableBackgroundColor;

    private StateConfig(Builder builder) {
        this.mNormalTextColor = builder.mNormalTextColor;
        this.mPressedTextColor = builder.mPressedTextColor;
        this.mUnableTextColor = builder.mUnableTextColor;
        this.mDuration = builder.mDuration;
        this.mRadius = builder.mRadius;
        this.mStrokeDashWidth = builder.mStrokeDashWidth;
        this.mStrokeDashGap = builder.mStrokeDashGap;
        this.mNormalStrokeWidth = builder.mNormalStrokeWidth;
        this.mPressedStrokeWidth = builder.mPressedStrokeWidth;
        this.mUnableStrokeWidth = builder.mUnableStrokeWidth;
        this.mNormalStrokeColor = builder.mNormalStrokeColor;
        this.mPressedStrokeColor = builder.mPressedStrokeColor;
        this.mUnableStrokeColor = builder.mUnableStrokeColor;
        this.mNormalBackgroundColor = builder.mNormalBackgroundColor;
        this.mPressedBackgroundColor = builder.mPressedBackgroundColor;
        this.mUnableBackgroundColor = builder.mUnableBackgroundColor;
    }

    public int getNormalTextColor() {
        return mNormalTextColor;
    }

    public int getPressedTextColor() {
        return mPressedTextColor;
    }

    public int getUnableTextColor() {
        return mUnableTextColor;
    }

    public int getDuration() {
        return mDuration;
    }

    public float getRadius() {
        return mRadius;
    }

    public float getStrokeDashWidth() {
        return mStrokeDashWidth;
    }

    public float getStrokeDashGap() {
        return mStrokeDashGap;
    }

    public int getNormalStrokeWidth() {
        return mNormalStrokeWidth;
    }

    public int getPressedStrokeWidth() {
        return mPressedStrokeWidth;
    }

    public int getUnableStrokeWidth() {
        return mUnableStrokeWidth;
    }

    public int getNormalStrokeColor() {
        return mNormalStrokeColor;
    }

    public int getPressedStrokeColor() {
        return mPressedStrokeColor;
    }

    public int getUnableStrokeColor() {
        return mUnableStrokeColor;
    }

    public int getNormalBackgroundColor() {
        return mNormalBackgroundColor;
    }

    public int getPressedBackgroundColor() {
        return mPressedBackgroundColor;
    }

    public int getUnableBackgroundColor() {
        return mUnableBackgroundColor;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {

        //animation duration
        private int mDuration;

        //radius
        private float mRadius;

        //text color
        private int mNormalTextColor;
        private int mPressedTextColor;
        private int mUnableTextColor;

        //stroke
        private float mStrokeDashWidth;
        private float mStrokeDashGap;
        private int mNormalStrokeWidth;
        private int mPressedStrokeWidth;
        private int mUnableStrokeWidth;
        private int mNormalStrokeColor;
        private int mPressedStrokeColor;
        private int mUnableStrokeColor;

        //background color
        private int mNormalBackgroundColor;
        private int mPressedBackgroundColor;
        private int mUnableBackgroundColor;


        public Builder setDuration(@IntRange(from = 0) int duration) {
            this.mDuration = duration;
            return this;
        }

        public Builder setRadius(@FloatRange(from = 0) float radius) {
            this.mRadius = radius;
            return this;
        }

        public Builder setNormalTextColor(@ColorInt int normalTextColor) {
            this.mNormalTextColor = normalTextColor;
            return this;
        }

        public Builder setPressedTextColor(@ColorInt int pressedTextColor) {
            this.mPressedTextColor = pressedTextColor;
            return this;
        }

        public Builder setUnableTextColor(@ColorInt int unableTextColor) {
            this.mUnableTextColor = unableTextColor;
            return this;
        }

        public Builder setStrokeDashWidth(@FloatRange(from = 0) float strokeDashWidth) {
            this.mStrokeDashWidth = strokeDashWidth;
            return this;
        }

        public Builder setStrokeDashGap(@FloatRange(from = 0) float strokeDashGap) {
            this.mStrokeDashGap = strokeDashGap;
            return this;
        }

        public Builder setNormalStrokeWidth(@IntRange(from = 0) int normalStrokeWidth) {
            this.mNormalStrokeWidth = normalStrokeWidth;
            return this;
        }

        public Builder setPressedStrokeWidth(@IntRange(from = 0) int pressedStrokeWidth) {
            this.mPressedStrokeWidth = pressedStrokeWidth;
            return this;
        }

        public Builder setUnableStrokeWidth(@IntRange(from = 0) int unableStrokeWidth) {
            this.mUnableStrokeWidth = unableStrokeWidth;
            return this;
        }

        public Builder setNormalStrokeColor(@ColorInt int normalStrokeColor) {
            this.mNormalStrokeColor = normalStrokeColor;
            return this;
        }

        public Builder setPressedStrokeColor(@ColorInt int pressedStrokeColor) {
            this.mPressedStrokeColor = pressedStrokeColor;
            return this;
        }

        public Builder setUnableStrokeColor(@ColorInt int unableStrokeColor) {
            this.mUnableStrokeColor = mUnableStrokeColor;
            return this;
        }

        public Builder setNormalBackgroundColor(@ColorInt int normalBackgroundColor) {
            this.mNormalBackgroundColor = normalBackgroundColor;
            return this;
        }

        public Builder setPressedBackgroundColor(@ColorInt int pressedBackgroundColor) {
            this.mPressedBackgroundColor = pressedBackgroundColor;
            return this;
        }

        public Builder setUnableBackgroundColor(@ColorInt int unableBackgroundColor) {
            this.mUnableBackgroundColor = unableBackgroundColor;
            return this;
        }

        public Builder setStateTextColor(@ColorInt int normal, @ColorInt int pressed, @ColorInt int unable){
            this.mNormalTextColor = normal;
            this.mPressedTextColor = pressed;
            this.mUnableTextColor = unable;
            return this;
        }

        public Builder setStateBackgroundColor(@ColorInt int normal, @ColorInt int pressed, @ColorInt int unable){
            mNormalBackgroundColor = normal;
            mPressedBackgroundColor = pressed;
            mUnableBackgroundColor = unable;
            return this;
        }

        public Builder setStateStrokeColor(@ColorInt int normal, @ColorInt int pressed, @ColorInt int unable){
            mNormalStrokeColor = normal;
            mPressedStrokeColor = pressed;
            mUnableStrokeColor = unable;
            return this;
        }

        public Builder() {
        }

        public StateConfig build() {
            return new StateConfig(this);
        }
    }
}
