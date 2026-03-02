package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class GuidedAction extends Action {
    public static final long ACTION_ID_CANCEL = -5;
    public static final long ACTION_ID_CONTINUE = -7;
    public static final long ACTION_ID_CURRENT = -3;
    public static final long ACTION_ID_FINISH = -6;
    public static final long ACTION_ID_NEXT = -2;
    public static final long ACTION_ID_NO = -9;
    public static final long ACTION_ID_OK = -4;
    public static final long ACTION_ID_YES = -8;
    public static final int CHECKBOX_CHECK_SET_ID = -1;
    public static final int DEFAULT_CHECK_SET_ID = 1;
    static final int EDITING_ACTIVATOR_VIEW = 3;
    static final int EDITING_DESCRIPTION = 2;
    static final int EDITING_NONE = 0;
    static final int EDITING_TITLE = 1;
    public static final int NO_CHECK_SET = 0;
    static final int PF_AUTORESTORE = 64;
    static final int PF_CHECKED = 1;
    static final int PF_ENABLED = 16;
    static final int PF_FOCUSABLE = 32;
    static final int PF_HAS_NEXT = 4;
    static final int PF_INFO_ONLY = 8;
    static final int PF_MULTI_LINE_DESCRIPTION = 2;
    private static final String TAG = "GuidedAction";
    int mActionFlags;
    String[] mAutofillHints;
    int mCheckSetId;
    int mDescriptionEditInputType;
    int mDescriptionInputType;
    private CharSequence mEditDescription;
    int mEditInputType;
    private CharSequence mEditTitle;
    int mEditable;
    int mInputType;
    Intent mIntent;
    List<GuidedAction> mSubActions;

    public GuidedAction() {
        super(0L);
    }

    public static boolean isPasswordVariant(int i10) {
        int i11 = i10 & 4080;
        return i11 == 128 || i11 == 144 || i11 == 224;
    }

    private void setFlags(int i10, int i11) {
        this.mActionFlags = (i10 & i11) | (this.mActionFlags & (~i11));
    }

    public String[] getAutofillHints() {
        return this.mAutofillHints;
    }

    public int getCheckSetId() {
        return this.mCheckSetId;
    }

    public CharSequence getDescription() {
        return getLabel2();
    }

    public int getDescriptionEditInputType() {
        return this.mDescriptionEditInputType;
    }

    public int getDescriptionInputType() {
        return this.mDescriptionInputType;
    }

    public CharSequence getEditDescription() {
        return this.mEditDescription;
    }

    public int getEditInputType() {
        return this.mEditInputType;
    }

    public CharSequence getEditTitle() {
        return this.mEditTitle;
    }

    public int getInputType() {
        return this.mInputType;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @SuppressLint({"NullableCollection"})
    public List<GuidedAction> getSubActions() {
        return this.mSubActions;
    }

    public CharSequence getTitle() {
        return getLabel1();
    }

    public boolean hasEditableActivatorView() {
        return this.mEditable == 3;
    }

    public boolean hasMultilineDescription() {
        return (this.mActionFlags & 2) == 2;
    }

    public boolean hasNext() {
        return (this.mActionFlags & 4) == 4;
    }

    public boolean hasSubActions() {
        return this.mSubActions != null;
    }

    public boolean hasTextEditable() {
        int i10 = this.mEditable;
        return i10 == 1 || i10 == 2;
    }

    public boolean infoOnly() {
        return (this.mActionFlags & 8) == 8;
    }

    public final boolean isAutoSaveRestoreEnabled() {
        return (this.mActionFlags & 64) == 64;
    }

    public boolean isChecked() {
        return (this.mActionFlags & 1) == 1;
    }

    public boolean isDescriptionEditable() {
        return this.mEditable == 2;
    }

    public boolean isEditTitleUsed() {
        return this.mEditTitle != null;
    }

    public boolean isEditable() {
        return this.mEditable == 1;
    }

    public boolean isEnabled() {
        return (this.mActionFlags & 16) == 16;
    }

    public boolean isFocusable() {
        return (this.mActionFlags & 32) == 32;
    }

    public final boolean needAutoSaveDescription() {
        return isDescriptionEditable() && !isPasswordVariant(getDescriptionEditInputType());
    }

    public final boolean needAutoSaveTitle() {
        return isEditable() && !isPasswordVariant(getEditInputType());
    }

    public void onRestoreInstanceState(Bundle bundle, String str) {
        if (needAutoSaveTitle()) {
            String string = bundle.getString(str);
            if (string != null) {
                setTitle(string);
                return;
            }
            return;
        }
        if (!needAutoSaveDescription()) {
            if (getCheckSetId() != 0) {
                setChecked(bundle.getBoolean(str, isChecked()));
            }
        } else {
            String string2 = bundle.getString(str);
            if (string2 != null) {
                setDescription(string2);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle, String str) {
        if (needAutoSaveTitle() && getTitle() != null) {
            bundle.putString(str, getTitle().toString());
            return;
        }
        if (needAutoSaveDescription() && getDescription() != null) {
            bundle.putString(str, getDescription().toString());
        } else if (getCheckSetId() != 0) {
            bundle.putBoolean(str, isChecked());
        }
    }

    public void setChecked(boolean z9) {
        setFlags(z9 ? 1 : 0, 1);
    }

    public void setDescription(CharSequence charSequence) {
        setLabel2(charSequence);
    }

    public void setEditDescription(CharSequence charSequence) {
        this.mEditDescription = charSequence;
    }

    public void setEditTitle(CharSequence charSequence) {
        this.mEditTitle = charSequence;
    }

    public void setEnabled(boolean z9) {
        setFlags(z9 ? 16 : 0, 16);
    }

    public void setFocusable(boolean z9) {
        setFlags(z9 ? 32 : 0, 32);
    }

    public void setIntent(Intent intent) {
        this.mIntent = intent;
    }

    public void setSubActions(List<GuidedAction> list) {
        this.mSubActions = list;
    }

    public void setTitle(CharSequence charSequence) {
        setLabel1(charSequence);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder extends BuilderBase<Builder> {
        @Deprecated
        public Builder() {
            super(null);
        }

        public GuidedAction build() {
            GuidedAction guidedAction = new GuidedAction();
            applyValues(guidedAction);
            return guidedAction;
        }

        public Builder(Context context) {
            super(context);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static abstract class BuilderBase<B extends BuilderBase> {
        private String[] mAutofillHints;
        private Context mContext;
        private CharSequence mDescription;
        private CharSequence mEditDescription;
        private CharSequence mEditTitle;
        private Drawable mIcon;
        private long mId;
        private Intent mIntent;
        private List<GuidedAction> mSubActions;
        private CharSequence mTitle;
        private int mEditable = 0;
        private int mInputType = 524289;
        private int mDescriptionInputType = 524289;
        private int mEditInputType = 1;
        private int mDescriptionEditInputType = 1;
        private int mCheckSetId = 0;
        private int mActionFlags = 112;

        public BuilderBase(Context context) {
            this.mContext = context;
        }

        private boolean isChecked() {
            return (this.mActionFlags & 1) == 1;
        }

        private void setFlags(int i10, int i11) {
            this.mActionFlags = (i10 & i11) | (this.mActionFlags & (~i11));
        }

        public final void applyValues(GuidedAction guidedAction) {
            guidedAction.setId(this.mId);
            guidedAction.setLabel1(this.mTitle);
            guidedAction.setEditTitle(this.mEditTitle);
            guidedAction.setLabel2(this.mDescription);
            guidedAction.setEditDescription(this.mEditDescription);
            guidedAction.setIcon(this.mIcon);
            guidedAction.mIntent = this.mIntent;
            guidedAction.mEditable = this.mEditable;
            guidedAction.mInputType = this.mInputType;
            guidedAction.mDescriptionInputType = this.mDescriptionInputType;
            guidedAction.mAutofillHints = this.mAutofillHints;
            guidedAction.mEditInputType = this.mEditInputType;
            guidedAction.mDescriptionEditInputType = this.mDescriptionEditInputType;
            guidedAction.mActionFlags = this.mActionFlags;
            guidedAction.mCheckSetId = this.mCheckSetId;
            guidedAction.mSubActions = this.mSubActions;
        }

        public B autoSaveRestoreEnabled(boolean z9) {
            setFlags(z9 ? 64 : 0, 64);
            return this;
        }

        public B autofillHints(String... strArr) {
            this.mAutofillHints = strArr;
            return this;
        }

        public B checkSetId(int i10) {
            this.mCheckSetId = i10;
            if (this.mEditable == 0) {
                return this;
            }
            com.google.gson.internal.a.n("Editable actions cannot also be in check sets");
            return null;
        }

        public B checked(boolean z9) {
            setFlags(z9 ? 1 : 0, 1);
            if (this.mEditable == 0) {
                return this;
            }
            com.google.gson.internal.a.n("Editable actions cannot also be checked");
            return null;
        }

        public B clickAction(long j10) {
            if (j10 == -4) {
                this.mId = -4L;
                this.mTitle = this.mContext.getString(android.R.string.ok);
                return this;
            }
            if (j10 == -5) {
                this.mId = -5L;
                this.mTitle = this.mContext.getString(android.R.string.cancel);
                return this;
            }
            if (j10 == -6) {
                this.mId = -6L;
                this.mTitle = this.mContext.getString(androidx.leanback.R.string.lb_guidedaction_finish_title);
                return this;
            }
            if (j10 == -7) {
                this.mId = -7L;
                this.mTitle = this.mContext.getString(androidx.leanback.R.string.lb_guidedaction_continue_title);
                return this;
            }
            if (j10 == -8) {
                this.mId = -8L;
                this.mTitle = this.mContext.getString(android.R.string.ok);
                return this;
            }
            if (j10 == -9) {
                this.mId = -9L;
                this.mTitle = this.mContext.getString(android.R.string.cancel);
            }
            return this;
        }

        public B description(@StringRes int i10) {
            this.mDescription = getContext().getString(i10);
            return this;
        }

        public B descriptionEditInputType(int i10) {
            this.mDescriptionEditInputType = i10;
            return this;
        }

        public B descriptionEditable(boolean z9) {
            if (z9) {
                this.mEditable = 2;
                if (isChecked() || this.mCheckSetId != 0) {
                    com.google.gson.internal.a.n("Editable actions cannot also be checked");
                    return null;
                }
            } else if (this.mEditable == 2) {
                this.mEditable = 0;
                return this;
            }
            return this;
        }

        public B descriptionInputType(int i10) {
            this.mDescriptionInputType = i10;
            return this;
        }

        public B editDescription(@StringRes int i10) {
            this.mEditDescription = getContext().getString(i10);
            return this;
        }

        public B editInputType(int i10) {
            this.mEditInputType = i10;
            return this;
        }

        public B editTitle(@StringRes int i10) {
            this.mEditTitle = getContext().getString(i10);
            return this;
        }

        public B editable(boolean z9) {
            if (z9) {
                this.mEditable = 1;
                if (isChecked() || this.mCheckSetId != 0) {
                    com.google.gson.internal.a.n("Editable actions cannot also be checked");
                    return null;
                }
            } else if (this.mEditable == 1) {
                this.mEditable = 0;
                return this;
            }
            return this;
        }

        public B enabled(boolean z9) {
            setFlags(z9 ? 16 : 0, 16);
            return this;
        }

        public B focusable(boolean z9) {
            setFlags(z9 ? 32 : 0, 32);
            return this;
        }

        public Context getContext() {
            return this.mContext;
        }

        public B hasEditableActivatorView(boolean z9) {
            if (z9) {
                this.mEditable = 3;
                if (isChecked() || this.mCheckSetId != 0) {
                    com.google.gson.internal.a.n("Editable actions cannot also be checked");
                    return null;
                }
            } else if (this.mEditable == 3) {
                this.mEditable = 0;
                return this;
            }
            return this;
        }

        public B hasNext(boolean z9) {
            setFlags(z9 ? 4 : 0, 4);
            return this;
        }

        public B icon(@DrawableRes int i10) {
            return (B) icon(ContextCompat.getDrawable(getContext(), i10));
        }

        @Deprecated
        public B iconResourceId(@DrawableRes int i10, Context context) {
            return (B) icon(ContextCompat.getDrawable(context, i10));
        }

        public B id(long j10) {
            this.mId = j10;
            return this;
        }

        public B infoOnly(boolean z9) {
            setFlags(z9 ? 8 : 0, 8);
            return this;
        }

        public B inputType(int i10) {
            this.mInputType = i10;
            return this;
        }

        public B intent(Intent intent) {
            this.mIntent = intent;
            return this;
        }

        public B multilineDescription(boolean z9) {
            setFlags(z9 ? 2 : 0, 2);
            return this;
        }

        public B subActions(List<GuidedAction> list) {
            this.mSubActions = list;
            return this;
        }

        public B title(@StringRes int i10) {
            this.mTitle = getContext().getString(i10);
            return this;
        }

        public B description(CharSequence charSequence) {
            this.mDescription = charSequence;
            return this;
        }

        public B editDescription(CharSequence charSequence) {
            this.mEditDescription = charSequence;
            return this;
        }

        public B editTitle(CharSequence charSequence) {
            this.mEditTitle = charSequence;
            return this;
        }

        public B title(CharSequence charSequence) {
            this.mTitle = charSequence;
            return this;
        }

        public B icon(Drawable drawable) {
            this.mIcon = drawable;
            return this;
        }
    }
}
