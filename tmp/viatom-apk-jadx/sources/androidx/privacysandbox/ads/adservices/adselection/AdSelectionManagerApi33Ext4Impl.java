package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresExtension(extension = 1000000, version = 4)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class AdSelectionManagerApi33Ext4Impl extends AdSelectionManagerImplCommon {
    /* JADX WARN: Illegal instructions before constructor call */
    public AdSelectionManagerApi33Ext4Impl(Context context) {
        context.getClass();
        Object systemService = context.getSystemService((Class<Object>) android.adservices.adselection.AdSelectionManager.class);
        systemService.getClass();
        super(androidx.privacysandbox.ads.adservices.adid.a.a(systemService));
    }
}
