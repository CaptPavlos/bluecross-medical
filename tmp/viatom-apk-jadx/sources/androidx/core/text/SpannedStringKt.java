package androidx.core.text;

import android.text.Spanned;
import android.text.SpannedString;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SpannedStringKt {
    public static final <T> T[] getSpans(Spanned spanned, int i10, int i11) {
        l.h();
        throw null;
    }

    public static Object[] getSpans$default(Spanned spanned, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            spanned.length();
        }
        l.h();
        throw null;
    }

    public static final Spanned toSpanned(CharSequence charSequence) {
        return SpannedString.valueOf(charSequence);
    }
}
