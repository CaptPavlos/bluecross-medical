package androidx.leanback.app;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ErrorSupportFragment extends BrandedSupportFragment {
    private Drawable mBackgroundDrawable;
    private Button mButton;
    private View.OnClickListener mButtonClickListener;
    private String mButtonText;
    private Drawable mDrawable;
    private ViewGroup mErrorFrame;
    private ImageView mImageView;
    private boolean mIsBackgroundTranslucent = true;
    private CharSequence mMessage;
    private TextView mTextView;

    private static Paint.FontMetricsInt getFontMetricsInt(TextView textView) {
        Paint paint = new Paint(1);
        paint.setTextSize(textView.getTextSize());
        paint.setTypeface(textView.getTypeface());
        return paint.getFontMetricsInt();
    }

    private static void setTopMargin(TextView textView, int i10) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = i10;
        textView.setLayoutParams(marginLayoutParams);
    }

    private void updateBackground() {
        ViewGroup viewGroup = this.mErrorFrame;
        if (viewGroup != null) {
            Drawable drawable = this.mBackgroundDrawable;
            if (drawable != null) {
                viewGroup.setBackground(drawable);
            } else {
                viewGroup.setBackgroundColor(viewGroup.getResources().getColor(this.mIsBackgroundTranslucent ? R.color.lb_error_background_color_translucent : R.color.lb_error_background_color_opaque));
            }
        }
    }

    private void updateButton() {
        Button button = this.mButton;
        if (button != null) {
            button.setText(this.mButtonText);
            this.mButton.setOnClickListener(this.mButtonClickListener);
            this.mButton.setVisibility(TextUtils.isEmpty(this.mButtonText) ? 8 : 0);
            this.mButton.requestFocus();
        }
    }

    private void updateImageDrawable() {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.mDrawable);
            this.mImageView.setVisibility(this.mDrawable == null ? 8 : 0);
        }
    }

    private void updateMessage() {
        TextView textView = this.mTextView;
        if (textView != null) {
            textView.setText(this.mMessage);
            this.mTextView.setVisibility(TextUtils.isEmpty(this.mMessage) ? 8 : 0);
        }
    }

    public Drawable getBackgroundDrawable() {
        return this.mBackgroundDrawable;
    }

    public View.OnClickListener getButtonClickListener() {
        return this.mButtonClickListener;
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public Drawable getImageDrawable() {
        return this.mDrawable;
    }

    public CharSequence getMessage() {
        return this.mMessage;
    }

    public boolean isBackgroundTranslucent() {
        return this.mIsBackgroundTranslucent;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.lb_error_fragment, viewGroup, false);
        this.mErrorFrame = (ViewGroup) viewInflate.findViewById(R.id.error_frame);
        updateBackground();
        installTitleView(layoutInflater, this.mErrorFrame, bundle);
        this.mImageView = (ImageView) viewInflate.findViewById(R.id.image);
        updateImageDrawable();
        this.mTextView = (TextView) viewInflate.findViewById(R.id.message);
        updateMessage();
        this.mButton = (Button) viewInflate.findViewById(R.id.button);
        updateButton();
        Paint.FontMetricsInt fontMetricsInt = getFontMetricsInt(this.mTextView);
        setTopMargin(this.mTextView, (viewGroup != null ? viewGroup.getResources().getDimensionPixelSize(R.dimen.lb_error_under_image_baseline_margin) : 0) + fontMetricsInt.ascent);
        setTopMargin(this.mButton, (viewGroup != null ? viewGroup.getResources().getDimensionPixelSize(R.dimen.lb_error_under_message_baseline_margin) : 0) - fontMetricsInt.descent);
        return viewInflate;
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        this.mErrorFrame.requestFocus();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.mBackgroundDrawable = drawable;
        if (drawable != null) {
            int opacity = drawable.getOpacity();
            this.mIsBackgroundTranslucent = opacity == -3 || opacity == -2;
        }
        updateBackground();
        updateMessage();
    }

    public void setButtonClickListener(View.OnClickListener onClickListener) {
        this.mButtonClickListener = onClickListener;
        updateButton();
    }

    public void setButtonText(String str) {
        this.mButtonText = str;
        updateButton();
    }

    public void setDefaultBackground(boolean z9) {
        this.mBackgroundDrawable = null;
        this.mIsBackgroundTranslucent = z9;
        updateBackground();
        updateMessage();
    }

    public void setImageDrawable(Drawable drawable) {
        this.mDrawable = drawable;
        updateImageDrawable();
    }

    public void setMessage(CharSequence charSequence) {
        this.mMessage = charSequence;
        updateMessage();
    }
}
