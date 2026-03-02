package androidx.privacysandbox.ads.adservices.internal;

import android.content.Context;
import android.util.Log;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BackCompatManager {
    public static final BackCompatManager INSTANCE = new BackCompatManager();

    private BackCompatManager() {
    }

    public final <T> T getManager(Context context, String str, l lVar) {
        context.getClass();
        str.getClass();
        lVar.getClass();
        try {
            return (T) lVar.invoke(context);
        } catch (NoClassDefFoundError unused) {
            Log.d(str, "Unable to find adservices code, check manifest for uses-library tag, versionS=" + AdServicesInfo.INSTANCE.extServicesVersionS());
            return null;
        }
    }
}
