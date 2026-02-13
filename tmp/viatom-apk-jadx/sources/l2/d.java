package l2;

import j2.g;
import java.util.Date;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d implements k2.a {
    public static final b f;
    public static final b g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10194a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f10195b;

    /* renamed from: c, reason: collision with root package name */
    public final a f10196c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10197d;
    public static final a e = new a(0);
    public static final c h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [l2.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [l2.b] */
    static {
        final int i10 = 0;
        f = new j2.f() { // from class: l2.b
            @Override // j2.a
            public final void a(Object obj, Object obj2) {
                switch (i10) {
                    case 0:
                        ((g) obj2).b((String) obj);
                        break;
                    default:
                        ((g) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i11 = 1;
        g = new j2.f() { // from class: l2.b
            @Override // j2.a
            public final void a(Object obj, Object obj2) {
                switch (i11) {
                    case 0:
                        ((g) obj2).b((String) obj);
                        break;
                    default:
                        ((g) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap map = new HashMap();
        this.f10194a = map;
        HashMap map2 = new HashMap();
        this.f10195b = map2;
        this.f10196c = e;
        this.f10197d = false;
        map2.put(String.class, f);
        map.remove(String.class);
        map2.put(Boolean.class, g);
        map.remove(Boolean.class);
        map2.put(Date.class, h);
        map.remove(Date.class);
    }

    public final k2.a a(Class cls, j2.d dVar) {
        this.f10194a.put(cls, dVar);
        this.f10195b.remove(cls);
        return this;
    }
}
