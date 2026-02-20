package androidx.window.core;

import androidx.window.core.SpecificationComputer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BuildConfig {
    public static final BuildConfig INSTANCE = new BuildConfig();
    private static final SpecificationComputer.VerificationMode verificationMode = SpecificationComputer.VerificationMode.QUIET;

    private BuildConfig() {
    }

    public final SpecificationComputer.VerificationMode getVerificationMode() {
        return verificationMode;
    }
}
