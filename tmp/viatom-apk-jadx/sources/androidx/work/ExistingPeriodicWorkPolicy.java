package androidx.work;

import com.google.android.gms.internal.measurement.a4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ExistingPeriodicWorkPolicy {
    private static final /* synthetic */ z6.a $ENTRIES;
    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $VALUES;
    public static final ExistingPeriodicWorkPolicy REPLACE = new ExistingPeriodicWorkPolicy("REPLACE", 0);
    public static final ExistingPeriodicWorkPolicy KEEP = new ExistingPeriodicWorkPolicy("KEEP", 1);
    public static final ExistingPeriodicWorkPolicy UPDATE = new ExistingPeriodicWorkPolicy("UPDATE", 2);
    public static final ExistingPeriodicWorkPolicy CANCEL_AND_REENQUEUE = new ExistingPeriodicWorkPolicy("CANCEL_AND_REENQUEUE", 3);

    private static final /* synthetic */ ExistingPeriodicWorkPolicy[] $values() {
        return new ExistingPeriodicWorkPolicy[]{REPLACE, KEEP, UPDATE, CANCEL_AND_REENQUEUE};
    }

    static {
        ExistingPeriodicWorkPolicy[] existingPeriodicWorkPolicyArr$values = $values();
        $VALUES = existingPeriodicWorkPolicyArr$values;
        $ENTRIES = a4.m(existingPeriodicWorkPolicyArr$values);
    }

    private ExistingPeriodicWorkPolicy(String str, int i10) {
    }

    public static z6.a getEntries() {
        return $ENTRIES;
    }

    public static ExistingPeriodicWorkPolicy valueOf(String str) {
        return (ExistingPeriodicWorkPolicy) Enum.valueOf(ExistingPeriodicWorkPolicy.class, str);
    }

    public static ExistingPeriodicWorkPolicy[] values() {
        return (ExistingPeriodicWorkPolicy[]) $VALUES.clone();
    }
}
