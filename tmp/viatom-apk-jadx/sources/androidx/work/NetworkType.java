package androidx.work;

import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.measurement.a4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class NetworkType {
    private static final /* synthetic */ z6.a $ENTRIES;
    private static final /* synthetic */ NetworkType[] $VALUES;
    public static final NetworkType NOT_REQUIRED = new NetworkType("NOT_REQUIRED", 0);
    public static final NetworkType CONNECTED = new NetworkType("CONNECTED", 1);
    public static final NetworkType UNMETERED = new NetworkType("UNMETERED", 2);
    public static final NetworkType NOT_ROAMING = new NetworkType("NOT_ROAMING", 3);
    public static final NetworkType METERED = new NetworkType("METERED", 4);

    @RequiresApi(30)
    public static final NetworkType TEMPORARILY_UNMETERED = new NetworkType("TEMPORARILY_UNMETERED", 5);

    private static final /* synthetic */ NetworkType[] $values() {
        return new NetworkType[]{NOT_REQUIRED, CONNECTED, UNMETERED, NOT_ROAMING, METERED, TEMPORARILY_UNMETERED};
    }

    static {
        NetworkType[] networkTypeArr$values = $values();
        $VALUES = networkTypeArr$values;
        $ENTRIES = a4.m(networkTypeArr$values);
    }

    private NetworkType(String str, int i10) {
    }

    public static z6.a getEntries() {
        return $ENTRIES;
    }

    public static NetworkType valueOf(String str) {
        return (NetworkType) Enum.valueOf(NetworkType.class, str);
    }

    public static NetworkType[] values() {
        return (NetworkType[]) $VALUES.clone();
    }
}
