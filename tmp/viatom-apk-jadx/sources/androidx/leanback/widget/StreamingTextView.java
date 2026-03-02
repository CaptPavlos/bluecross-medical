package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.style.ForegroundColorSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import androidx.core.widget.TextViewCompat;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
class StreamingTextView extends EditText {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.leanback.widget.StreamingTextView";
    static final boolean ANIMATE_DOTS_FOR_PENDING = true;
    private static final boolean DEBUG = false;
    private static final boolean DOTS_FOR_PENDING = true;
    private static final boolean DOTS_FOR_STABLE = false;
    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\S+");
    private static final Property<StreamingTextView, Integer> STREAM_POSITION_PROPERTY = new Property<StreamingTextView, Integer>(Integer.class, "streamPosition") { // from class: androidx.leanback.widget.StreamingTextView.1
        @Override // android.util.Property
        public Integer get(StreamingTextView streamingTextView) {
            return Integer.valueOf(streamingTextView.getStreamPosition());
        }

        @Override // android.util.Property
        public void set(StreamingTextView streamingTextView, Integer num) {
            streamingTextView.setStreamPosition(num.intValue());
        }
    };
    private static final long STREAM_UPDATE_DELAY_MILLIS = 50;
    private static final String TAG = "StreamingTextView";
    private static final float TEXT_DOT_SCALE = 1.3f;
    Bitmap mOneDot;
    final Random mRandom;
    int mStreamPosition;
    private ObjectAnimator mStreamingAnimation;
    Bitmap mTwoDot;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public class DottySpan extends ReplacementSpan {
        private final int mPosition;
        private final int mSeed;

        public DottySpan(int i10, int i11) {
            this.mSeed = i10;
            this.mPosition = i11;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i10, int i11, float f, int i12, int i13, int i14, Paint paint) {
            int iMeasureText = (int) paint.measureText(charSequence, i10, i11);
            int width = StreamingTextView.this.mOneDot.getWidth();
            int i15 = width * 2;
            int i16 = iMeasureText / i15;
            int i17 = (iMeasureText % i15) / 2;
            boolean zIsLayoutRtl = StreamingTextView.isLayoutRtl(StreamingTextView.this);
            StreamingTextView.this.mRandom.setSeed(this.mSeed);
            int alpha = paint.getAlpha();
            for (int i18 = 0; i18 < i16; i18++) {
                int i19 = this.mPosition + i18;
                StreamingTextView streamingTextView = StreamingTextView.this;
                if (i19 >= streamingTextView.mStreamPosition) {
                    break;
                }
                float f10 = (width / 2) + (i18 * i15) + i17;
                float f11 = zIsLayoutRtl ? ((iMeasureText + f) - f10) - width : f + f10;
                paint.setAlpha((streamingTextView.mRandom.nextInt(4) + 1) * 63);
                boolean zNextBoolean = StreamingTextView.this.mRandom.nextBoolean();
                StreamingTextView streamingTextView2 = StreamingTextView.this;
                if (zNextBoolean) {
                    canvas.drawBitmap(streamingTextView2.mTwoDot, f11, i13 - r3.getHeight(), paint);
                } else {
                    canvas.drawBitmap(streamingTextView2.mOneDot, f11, i13 - r3.getHeight(), paint);
                }
            }
            paint.setAlpha(alpha);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i10, int i11, Paint.FontMetricsInt fontMetricsInt) {
            return (int) paint.measureText(charSequence, i10, i11);
        }
    }

    public StreamingTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRandom = new Random();
    }

    private void addColorSpan(SpannableStringBuilder spannableStringBuilder, int i10, String str, int i11) {
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i10), i11, str.length() + i11, 33);
    }

    private void addDottySpans(SpannableStringBuilder spannableStringBuilder, String str, int i10) {
        Matcher matcher = SPLIT_PATTERN.matcher(str);
        while (matcher.find()) {
            int iStart = matcher.start() + i10;
            spannableStringBuilder.setSpan(new DottySpan(str.charAt(matcher.start()), iStart), iStart, matcher.end() + i10, 33);
        }
    }

    private void cancelStreamAnimation() {
        ObjectAnimator objectAnimator = this.mStreamingAnimation;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private Bitmap getScaledBitmap(int i10, float f) {
        return Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), i10), (int) (r3.getWidth() * f), (int) (r3.getHeight() * f), false);
    }

    public static boolean isLayoutRtl(View view) {
        return 1 == view.getLayoutDirection();
    }

    private void startStreamAnimation() {
        cancelStreamAnimation();
        int streamPosition = getStreamPosition();
        int length = length();
        int i10 = length - streamPosition;
        if (i10 > 0) {
            if (this.mStreamingAnimation == null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                this.mStreamingAnimation = objectAnimator;
                objectAnimator.setTarget(this);
                this.mStreamingAnimation.setProperty(STREAM_POSITION_PROPERTY);
            }
            this.mStreamingAnimation.setIntValues(streamPosition, length);
            this.mStreamingAnimation.setDuration(i10 * STREAM_UPDATE_DELAY_MILLIS);
            this.mStreamingAnimation.start();
        }
    }

    private void updateText(CharSequence charSequence) {
        setText(charSequence);
        bringPointIntoView(length());
    }

    public int getStreamPosition() {
        return this.mStreamPosition;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.mOneDot = getScaledBitmap(androidx.leanback.R.drawable.lb_text_dot_one, TEXT_DOT_SCALE);
        this.mTwoDot = getScaledBitmap(androidx.leanback.R.drawable.lb_text_dot_two, TEXT_DOT_SCALE);
        reset();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    public void reset() {
        this.mStreamPosition = -1;
        cancelStreamAnimation();
        setText("");
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setFinalRecognizedText(CharSequence charSequence) {
        updateText(charSequence);
    }

    public void setStreamPosition(int i10) {
        this.mStreamPosition = i10;
        invalidate();
    }

    public void updateRecognizedText(String str, String str2) {
        if (str == null) {
            str = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (str2 != null) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            addDottySpans(spannableStringBuilder, str2, length);
        }
        this.mStreamPosition = Math.max(str.length(), this.mStreamPosition);
        updateText(new SpannedString(spannableStringBuilder));
        startStreamAnimation();
    }

    public StreamingTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mRandom = new Random();
    }

    public void updateRecognizedText(String str, List<Float> list) {
    }
}
