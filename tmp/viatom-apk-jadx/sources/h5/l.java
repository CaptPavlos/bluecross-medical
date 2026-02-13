package h5;

import com.mbridge.msdk.MBridgeConstans;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public String f8644a;

    /* renamed from: b, reason: collision with root package name */
    public String f8645b;

    /* renamed from: c, reason: collision with root package name */
    public int f8646c = -1;

    public final String a() {
        return b().substring(o7.m.m0("/", b(), 6) + 1);
    }

    public final String b() {
        String str = this.f8644a;
        if (str != null) {
            return str;
        }
        kotlin.jvm.internal.l.i(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        throw null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{path='");
        sb.append(b());
        sb.append("', date='");
        String str = this.f8645b;
        if (str != null) {
            return a3.a.o(sb, str, "'}");
        }
        kotlin.jvm.internal.l.i("date");
        throw null;
    }
}
