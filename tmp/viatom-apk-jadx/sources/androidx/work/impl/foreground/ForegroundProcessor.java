package androidx.work.impl.foreground;

import androidx.annotation.RestrictTo;
import androidx.work.ForegroundInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public interface ForegroundProcessor {
    void startForeground(String str, ForegroundInfo foregroundInfo);
}
