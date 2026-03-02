package androidx.leanback.widget;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ControlButtonPresenterSelector extends PresenterSelector {
    private final Presenter[] mPresenters;
    private final Presenter mPrimaryPresenter;
    private final Presenter mSecondaryPresenter;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ActionViewHolder extends Presenter.ViewHolder {
        View mFocusableView;
        ImageView mIcon;
        TextView mLabel;

        public ActionViewHolder(View view) {
            super(view);
            this.mIcon = (ImageView) view.findViewById(androidx.leanback.R.id.icon);
            this.mLabel = (TextView) view.findViewById(androidx.leanback.R.id.label);
            this.mFocusableView = view.findViewById(androidx.leanback.R.id.button);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ControlButtonPresenter extends Presenter {
        private int mLayoutResourceId;

        public ControlButtonPresenter(int i10) {
            this.mLayoutResourceId = i10;
        }

        @Override // androidx.leanback.widget.Presenter
        public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
            Action action = (Action) obj;
            ActionViewHolder actionViewHolder = (ActionViewHolder) viewHolder;
            actionViewHolder.mIcon.setImageDrawable(action.getIcon());
            if (actionViewHolder.mLabel != null) {
                Drawable icon = action.getIcon();
                TextView textView = actionViewHolder.mLabel;
                if (icon == null) {
                    textView.setText(action.getLabel1());
                } else {
                    textView.setText((CharSequence) null);
                }
            }
            CharSequence label1 = TextUtils.isEmpty(action.getLabel2()) ? action.getLabel1() : action.getLabel2();
            if (TextUtils.equals(actionViewHolder.mFocusableView.getContentDescription(), label1)) {
                return;
            }
            actionViewHolder.mFocusableView.setContentDescription(label1);
            actionViewHolder.mFocusableView.sendAccessibilityEvent(32768);
        }

        @Override // androidx.leanback.widget.Presenter
        public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            return new ActionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.mLayoutResourceId, viewGroup, false));
        }

        @Override // androidx.leanback.widget.Presenter
        public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
            ActionViewHolder actionViewHolder = (ActionViewHolder) viewHolder;
            actionViewHolder.mIcon.setImageDrawable(null);
            TextView textView = actionViewHolder.mLabel;
            if (textView != null) {
                textView.setText((CharSequence) null);
            }
            actionViewHolder.mFocusableView.setContentDescription(null);
        }

        @Override // androidx.leanback.widget.Presenter
        public void setOnClickListener(Presenter.ViewHolder viewHolder, View.OnClickListener onClickListener) {
            ((ActionViewHolder) viewHolder).mFocusableView.setOnClickListener(onClickListener);
        }
    }

    public ControlButtonPresenterSelector() {
        ControlButtonPresenter controlButtonPresenter = new ControlButtonPresenter(androidx.leanback.R.layout.lb_control_button_primary);
        this.mPrimaryPresenter = controlButtonPresenter;
        this.mSecondaryPresenter = new ControlButtonPresenter(androidx.leanback.R.layout.lb_control_button_secondary);
        this.mPresenters = new Presenter[]{controlButtonPresenter};
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter getPresenter(Object obj) {
        return this.mPrimaryPresenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        return this.mPresenters;
    }

    public Presenter getPrimaryPresenter() {
        return this.mPrimaryPresenter;
    }

    public Presenter getSecondaryPresenter() {
        return this.mSecondaryPresenter;
    }
}
