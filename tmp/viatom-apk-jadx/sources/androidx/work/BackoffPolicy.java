package androidx.work;

import com.google.android.gms.internal.measurement.a4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class BackoffPolicy {
    private static final /* synthetic */ z6.a $ENTRIES;
    private static final /* synthetic */ BackoffPolicy[] $VALUES;
    public static final BackoffPolicy EXPONENTIAL = new BackoffPolicy("EXPONENTIAL", 0);
    public static final BackoffPolicy LINEAR = new BackoffPolicy("LINEAR", 1);

    private static final /* synthetic */ BackoffPolicy[] $values() {
        return new BackoffPolicy[]{EXPONENTIAL, LINEAR};
    }

    static {
        BackoffPolicy[] backoffPolicyArr$values = $values();
        $VALUES = backoffPolicyArr$values;
        $ENTRIES = a4.m(backoffPolicyArr$values);
    }

    private BackoffPolicy(String str, int i10) {
    }

    public static z6.a getEntries() {
        return $ENTRIES;
    }

    public static BackoffPolicy valueOf(String str) {
        return (BackoffPolicy) Enum.valueOf(BackoffPolicy.class, str);
    }

    public static BackoffPolicy[] values() {
        return (BackoffPolicy[]) $VALUES.clone();
    }
}
