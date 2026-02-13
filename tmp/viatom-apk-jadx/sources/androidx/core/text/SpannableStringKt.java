package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import l7.d;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, d dVar, Object obj) {
        spannable.setSpan(obj, dVar.f11084a, dVar.f11085b, 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(Spannable spannable, int i10, int i11, Object obj) {
        spannable.setSpan(obj, i10, i11, 17);
    }
}
