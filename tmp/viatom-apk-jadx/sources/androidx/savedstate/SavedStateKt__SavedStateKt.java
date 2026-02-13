package androidx.savedstate;

import android.os.Bundle;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final /* synthetic */ class SavedStateKt__SavedStateKt {
    public static final <T> T read(Bundle bundle, l lVar) {
        bundle.getClass();
        lVar.getClass();
        return (T) lVar.invoke(SavedStateReader.m96boximpl(SavedStateReader.m97constructorimpl(bundle)));
    }

    public static final <T> T write(Bundle bundle, l lVar) {
        bundle.getClass();
        lVar.getClass();
        return (T) lVar.invoke(SavedStateWriter.m181boximpl(SavedStateWriter.m183constructorimpl(bundle)));
    }
}
