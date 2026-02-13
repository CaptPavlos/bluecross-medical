package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m5 implements g6 {

    /* renamed from: b, reason: collision with root package name */
    public static final m5 f2084b = new m5(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2085a;

    public /* synthetic */ m5(int i10) {
        this.f2085a = i10;
    }

    public static final e6 c(Object obj, Object obj2) {
        e6 e6VarA = (e6) obj;
        e6 e6Var = (e6) obj2;
        if (!e6Var.isEmpty()) {
            if (!e6VarA.f1936a) {
                e6VarA = e6VarA.a();
            }
            e6VarA.d();
            if (!e6Var.isEmpty()) {
                e6VarA.putAll(e6Var);
            }
        }
        return e6VarA;
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public boolean a(Class cls) {
        switch (this.f2085a) {
            case 0:
                return o5.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }

    @Override // com.google.android.gms.internal.measurement.g6
    public o6 b(Class cls) {
        switch (this.f2085a) {
            case 0:
                if (o5.class.isAssignableFrom(cls)) {
                    try {
                        return (o6) o5.l(cls.asSubclass(o5.class)).o(3);
                    } catch (Exception e) {
                        androidx.privacysandbox.ads.adservices.adid.a.l("Unable to get message info for ".concat(cls.getName()), e);
                    }
                } else {
                    com.google.gson.internal.a.n("Unsupported message type: ".concat(cls.getName()));
                }
                return null;
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }
}
