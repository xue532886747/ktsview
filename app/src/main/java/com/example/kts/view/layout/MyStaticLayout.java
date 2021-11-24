package com.example.kts.view.layout;


import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;

/**
 * @author 53288
 * @description
 * @date 2021/11/22
 */
public class MyStaticLayout extends Layout {
    static final String TAG = "StaticLayout";


    public final static class Builder {
        public CharSequence mText;
        public int mStart;
        public int mEnd;
        public TextPaint mPaint;
        public int mWidth;
        public Alignment mAlignment;
        public TextDirectionHeuristic mTextDir;
        public float mSpacingMult;
        public float mSpacingAdd;
        public boolean mIncludePad;
        public boolean mFallbackLineSpacing;
        public int mEllipsizedWidth;
        public TextUtils.TruncateAt mEllipsize;
        public int mMaxLines;
        public int mBreakStrategy;
        public int mHyphenationFrequency;
        public int mJustificationMode;
        public int[] mLeftIndents;
        public int[] mRightIndents;
        boolean mAddLastLineLineSpacing;
        private final Paint.FontMetricsInt mFontMetricsInt = new Paint.FontMetricsInt();
        private static final Pools.SynchronizedPool<Builder> sPool = new Pools.SynchronizedPool<>(3);

        private Builder() {
        }

        public static Builder obtain(@NonNull CharSequence source, @IntRange(from = 0) int start,
                                     @IntRange(from = 0) int end, @NonNull TextPaint paint,
                                     @IntRange(from = 0) int width) {
            Builder b = sPool.acquire();
            if (b == null) {
                b = new Builder();
            }
            b.mText = source;
            b.mStart = start;
            b.mEnd = end;
            b.mPaint = paint;
            b.mWidth = width;
            b.mAlignment = Alignment.ALIGN_NORMAL;
            b.mTextDir = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            b.mSpacingMult = DEFAULT_LINESPACING_MULTIPLIER;
            b.mSpacingAdd = DEFAULT_LINESPACING_ADDITION;
            b.mIncludePad = true;
            b.mFallbackLineSpacing = false;
            b.mEllipsizedWidth = width;
            b.mEllipsize = null;
            b.mMaxLines = Integer.MAX_VALUE;
            b.mBreakStrategy = Layout.BREAK_STRATEGY_SIMPLE;
            b.mHyphenationFrequency = Layout.HYPHENATION_FREQUENCY_NONE;
            b.mJustificationMode = Layout.JUSTIFICATION_MODE_NONE;
            return b;
        }

        private static void recycle(@NonNull Builder b) {
            b.mPaint = null;
            b.mText = null;
            b.mLeftIndents = null;
            b.mRightIndents = null;
            sPool.release(b);
        }

        void finish() {
            mText = null;
            mPaint = null;
            mLeftIndents = null;
            mRightIndents = null;
        }

        public Builder setText(CharSequence source) {
            return setText(source, 0, source.length());
        }

        /**
         * 设置文本
         */
        private Builder setText(@NonNull CharSequence source, int start, int end) {
            mText = source;
            mStart = start;
            mEnd = end;
            return this;
        }

        public Builder setPaint(@NonNull TextPaint paint) {
            mPaint = paint;
            return this;
        }

        @NonNull
        public Builder setWidth(@IntRange(from = 0) int width) {
            mWidth = width;
            if (mEllipsize == null) {
                mEllipsizedWidth = width;
            }
            return this;
        }

        @NonNull
        public Builder setAlignment(@NonNull Alignment alignment) {
            mAlignment = alignment;
            return this;
        }

        @NonNull
        public Builder setTextDirection(@NonNull TextDirectionHeuristic textDir) {
            mTextDir = textDir;
            return this;
        }

        @NonNull
        public Builder setLineSpacing(float spacingAdd, @FloatRange(from = 0.0) float spacingMult) {
            mSpacingAdd = spacingAdd;
            mSpacingMult = spacingMult;
            return this;
        }

        @NonNull
        public Builder setIncludePad(boolean includePad) {
            mIncludePad = includePad;
            return this;
        }

        //如果宽度不同于正常布局宽度，则将其设置为用于椭圆化
        @NonNull
        public Builder setUseLineSpacingFromFallbacks(boolean useLineSpacingFromFallbacks) {
            mFallbackLineSpacing = useLineSpacingFromFallbacks;
            return this;
        }

        @NonNull
        public Builder setEllipsizedWidth(@IntRange(from = 0) int ellipsizedWidth) {
            mEllipsizedWidth = ellipsizedWidth;
            return this;
        }

        @NonNull
        public Builder setEllipsize(TextUtils.TruncateAt ellipsize) {
            mEllipsize = ellipsize;
            return this;
        }

        @NonNull
        public Builder setMaxLines(@IntRange(from = 0) int maxLines) {
            mMaxLines = maxLines;
            return this;
        }

        //折行策略
        @NonNull
        public Builder setBreakStrategy(int breakStrategy) {
            mBreakStrategy = breakStrategy;
            return this;
        }

        //自动连字的频率。从主题设置的TextView和EditText默认为normal。
        @NonNull
        public Builder setHyphenationFrequency(int hyphenationFrequency) {
            mHyphenationFrequency = hyphenationFrequency;
            return this;
        }

        //设置缩进。参数是包含缩进量的数组，每行一个，以像素为单位。对于超过数组中最后一个元素的行，最后一个元素将重复。
        @NonNull
        public Builder setIndents(@Nullable int[] leftIndents, @Nullable int[] rightIndents) {
            mLeftIndents = leftIndents;
            mRightIndents = rightIndents;
            return this;
        }

        @NonNull
        public Builder setJustificationMode(int justificationMode) {
            mJustificationMode = justificationMode;
            return this;
        }

        //设置是否应为最后一行应用行距。默认值为false。
        @NonNull
        Builder setAddLastLineLineSpacing(boolean value) {
            mAddLastLineLineSpacing = value;
            return this;
        }

    }



    MyStaticLayout(CharSequence text) {
        super(text, null, 0, null, 0, 0);
        mColumns = COLUMNS_ELLIPSIZE;
        mLineDirections = new Directions[2];
        mLines = new int[mColumns * 2];
    }

    private MyStaticLayout(MyStaticLayout.Builder b) {
        super((b.mEllipsize == null) ? b.mText : null, b.mPaint, 0, null, 0, 0);

    }

    @Override
    public int getLineCount() {
        return 0;
    }

    @Override
    public int getLineTop(int line) {
        return 0;
    }

    @Override
    public int getLineDescent(int line) {
        return 0;
    }

    @Override
    public int getLineStart(int line) {
        return 0;
    }

    @Override
    public int getParagraphDirection(int line) {
        return 0;
    }

    @Override
    public boolean getLineContainsTab(int line) {
        return false;
    }

    @Override
    public Directions getLineDirections(int line) {
        return null;
    }

    @Override
    public int getTopPadding() {
        return 0;
    }

    @Override
    public int getBottomPadding() {
        return 0;
    }

    @Override
    public int getEllipsisStart(int line) {
        return 0;
    }

    @Override
    public int getEllipsisCount(int line) {
        return 0;
    }

    private int mColumns;
    private Directions[] mLineDirections;
    private int[] mLines;

    private static final int COLUMNS_NORMAL = 5;
    private static final int COLUMNS_ELLIPSIZE = 7;
}
