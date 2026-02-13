package a3;

import android.content.Context;
import android.os.Process;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f106a;

    /* renamed from: b, reason: collision with root package name */
    public final s6.m f107b;

    /* renamed from: c, reason: collision with root package name */
    public final int f108c;

    /* renamed from: d, reason: collision with root package name */
    public final s6.m f109d;
    public final s6.m e;
    public boolean f;

    public j0(Context context, p1 p1Var) {
        context.getClass();
        p1Var.getClass();
        this.f106a = context;
        final int i10 = 0;
        this.f107b = new s6.m(new g7.a(this) { // from class: a3.h0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j0 f81b;

            {
                this.f81b = this;
            }

            @Override // g7.a
            public final Object invoke() {
                switch (i10) {
                    case 0:
                        return ((k0) this.f81b.e.getValue()).f118a;
                    default:
                        return l0.b(this.f81b.f106a);
                }
            }
        });
        this.f108c = Process.myPid();
        this.f109d = new s6.m(new i0(p1Var, 0));
        final int i11 = 1;
        this.e = new s6.m(new g7.a(this) { // from class: a3.h0

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ j0 f81b;

            {
                this.f81b = this;
            }

            @Override // g7.a
            public final Object invoke() {
                switch (i11) {
                    case 0:
                        return ((k0) this.f81b.e.getValue()).f118a;
                    default:
                        return l0.b(this.f81b.f106a);
                }
            }
        });
    }

    public final String a() {
        return (String) this.f107b.getValue();
    }

    public final Map b(Map map) {
        s6.m mVar = this.f109d;
        if (map != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            linkedHashMap.put(a(), new g0(Process.myPid(), (String) mVar.getValue()));
            return t6.a0.l0(linkedHashMap);
        }
        Map mapSingletonMap = Collections.singletonMap(a(), new g0(Process.myPid(), (String) mVar.getValue()));
        mapSingletonMap.getClass();
        return mapSingletonMap;
    }
}
