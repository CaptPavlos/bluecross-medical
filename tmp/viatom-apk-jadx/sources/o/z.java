package o;

import android.util.SparseArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public static final z f11660a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ z[] f11661b;

    /* JADX INFO: Fake field, exist only in values array */
    z EF0;

    static {
        z zVar = new z("NOT_SET", 0);
        z zVar2 = new z("EVENT_OVERRIDE", 1);
        f11660a = zVar2;
        f11661b = new z[]{zVar, zVar2};
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, zVar);
        sparseArray.put(5, zVar2);
    }

    public static z valueOf(String str) {
        return (z) Enum.valueOf(z.class, str);
    }

    public static z[] values() {
        return (z[]) f11661b.clone();
    }
}
