package androidx.leanback.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
class ActionPresenterSelector extends PresenterSelector {
    private final Presenter mOneLineActionPresenter;
    private final Presenter[] mPresenters;
    private final Presenter mTwoLineActionPresenter;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class ActionPresenter extends Presenter {
        @Override // androidx.leanback.widget.Presenter
        public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) throws Resources.NotFoundException {
            Action action = (Action) obj;
            ActionViewHolder actionViewHolder = (ActionViewHolder) viewHolder;
            actionViewHolder.mAction = action;
            Drawable icon = action.getIcon();
            View view = actionViewHolder.view;
            if (icon != null) {
                actionViewHolder.view.setPaddingRelative(view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_action_with_icon_padding_start), 0, actionViewHolder.view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_action_with_icon_padding_end), 0);
            } else {
                int dimensionPixelSize = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_action_padding_horizontal);
                actionViewHolder.view.setPaddingRelative(dimensionPixelSize, 0, dimensionPixelSize, 0);
            }
            int i10 = actionViewHolder.mLayoutDirection;
            Button button = actionViewHolder.mButton;
            if (i10 == 1) {
                button.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, icon, (Drawable) null);
            } else {
                button.setCompoundDrawablesWithIntrinsicBounds(icon, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }

        @Override // androidx.leanback.widget.Presenter
        public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
            ActionViewHolder actionViewHolder = (ActionViewHolder) viewHolder;
            actionViewHolder.mButton.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            actionViewHolder.view.setPadding(0, 0, 0, 0);
            actionViewHolder.mAction = null;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class ActionViewHolder extends Presenter.ViewHolder {
        Action mAction;
        Button mButton;
        int mLayoutDirection;

        public ActionViewHolder(View view, int i10) {
            super(view);
            this.mButton = (Button) view.findViewById(androidx.leanback.R.id.lb_action_button);
            this.mLayoutDirection = i10;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class OneLineActionPresenter extends ActionPresenter {
        @Override // androidx.leanback.widget.ActionPresenterSelector.ActionPresenter, androidx.leanback.widget.Presenter
        public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) throws Resources.NotFoundException {
            super.onBindViewHolder(viewHolder, obj);
            ((ActionViewHolder) viewHolder).mButton.setText(((Action) obj).getLabel1());
        }

        @Override // androidx.leanback.widget.Presenter
        public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            return new ActionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_action_1_line, viewGroup, false), viewGroup.getLayoutDirection());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class TwoLineActionPresenter extends ActionPresenter {
        @Override // androidx.leanback.widget.ActionPresenterSelector.ActionPresenter, androidx.leanback.widget.Presenter
        public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) throws Resources.NotFoundException {
            super.onBindViewHolder(viewHolder, obj);
            Action action = (Action) obj;
            ActionViewHolder actionViewHolder = (ActionViewHolder) viewHolder;
            CharSequence label1 = action.getLabel1();
            CharSequence label2 = action.getLabel2();
            if (TextUtils.isEmpty(label1)) {
                actionViewHolder.mButton.setText(label2);
                return;
            }
            if (TextUtils.isEmpty(label2)) {
                actionViewHolder.mButton.setText(label1);
                return;
            }
            actionViewHolder.mButton.setText(((Object) label1) + "\n" + ((Object) label2));
        }

        @Override // androidx.leanback.widget.Presenter
        public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
            return new ActionViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_action_2_lines, viewGroup, false), viewGroup.getLayoutDirection());
        }
    }

    public ActionPresenterSelector() {
        OneLineActionPresenter oneLineActionPresenter = new OneLineActionPresenter();
        this.mOneLineActionPresenter = oneLineActionPresenter;
        TwoLineActionPresenter twoLineActionPresenter = new TwoLineActionPresenter();
        this.mTwoLineActionPresenter = twoLineActionPresenter;
        this.mPresenters = new Presenter[]{oneLineActionPresenter, twoLineActionPresenter};
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter getPresenter(Object obj) {
        return TextUtils.isEmpty(((Action) obj).getLabel2()) ? this.mOneLineActionPresenter : this.mTwoLineActionPresenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        return this.mPresenters;
    }
}
