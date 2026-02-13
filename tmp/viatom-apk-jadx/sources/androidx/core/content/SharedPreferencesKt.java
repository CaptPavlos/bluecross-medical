package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SharedPreferencesKt {
    @SuppressLint({"ApplySharedPref"})
    public static final void edit(SharedPreferences sharedPreferences, boolean z9, l lVar) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        lVar.invoke(editorEdit);
        if (z9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }

    public static /* synthetic */ void edit$default(SharedPreferences sharedPreferences, boolean z9, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z9 = false;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        lVar.invoke(editorEdit);
        if (z9) {
            editorEdit.commit();
        } else {
            editorEdit.apply();
        }
    }
}
