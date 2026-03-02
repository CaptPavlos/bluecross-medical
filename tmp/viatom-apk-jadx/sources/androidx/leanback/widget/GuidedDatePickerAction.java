package androidx.leanback.widget;

import android.content.Context;
import android.os.Bundle;
import androidx.leanback.widget.GuidedAction;
import java.util.Calendar;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class GuidedDatePickerAction extends GuidedAction {
    long mDate;
    String mDatePickerFormat;
    long mMinDate = Long.MIN_VALUE;
    long mMaxDate = Long.MAX_VALUE;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder extends BuilderBase<Builder> {
        public Builder(Context context) {
            super(context);
        }

        public GuidedDatePickerAction build() {
            GuidedDatePickerAction guidedDatePickerAction = new GuidedDatePickerAction();
            applyDatePickerValues(guidedDatePickerAction);
            return guidedDatePickerAction;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class BuilderBase<B extends BuilderBase> extends GuidedAction.BuilderBase<B> {
        private long mDate;
        private String mDatePickerFormat;
        private long mMaxDate;
        private long mMinDate;

        public BuilderBase(Context context) {
            super(context);
            this.mMinDate = Long.MIN_VALUE;
            this.mMaxDate = Long.MAX_VALUE;
            this.mDate = Calendar.getInstance().getTimeInMillis();
            hasEditableActivatorView(true);
        }

        public final void applyDatePickerValues(GuidedDatePickerAction guidedDatePickerAction) {
            applyValues(guidedDatePickerAction);
            guidedDatePickerAction.mDatePickerFormat = this.mDatePickerFormat;
            guidedDatePickerAction.mDate = this.mDate;
            long j10 = this.mMinDate;
            long j11 = this.mMaxDate;
            if (j10 > j11) {
                com.google.gson.internal.a.n("MinDate cannot be larger than MaxDate");
            } else {
                guidedDatePickerAction.mMinDate = j10;
                guidedDatePickerAction.mMaxDate = j11;
            }
        }

        public B date(long j10) {
            this.mDate = j10;
            return this;
        }

        public B datePickerFormat(String str) {
            this.mDatePickerFormat = str;
            return this;
        }

        public B maxDate(long j10) {
            this.mMaxDate = j10;
            return this;
        }

        public B minDate(long j10) {
            this.mMinDate = j10;
            return this;
        }
    }

    public long getDate() {
        return this.mDate;
    }

    public String getDatePickerFormat() {
        return this.mDatePickerFormat;
    }

    public long getMaxDate() {
        return this.mMaxDate;
    }

    public long getMinDate() {
        return this.mMinDate;
    }

    @Override // androidx.leanback.widget.GuidedAction
    public void onRestoreInstanceState(Bundle bundle, String str) {
        setDate(bundle.getLong(str, getDate()));
    }

    @Override // androidx.leanback.widget.GuidedAction
    public void onSaveInstanceState(Bundle bundle, String str) {
        bundle.putLong(str, getDate());
    }

    public void setDate(long j10) {
        this.mDate = j10;
    }
}
