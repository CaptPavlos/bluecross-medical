package n;

import android.content.Context;
import android.net.ConnectivityManager;
import java.net.MalformedURLException;
import java.net.URL;
import l2.d;
import o.a0;
import o.b0;
import o.c0;
import o.d0;
import o.e0;
import o.f;
import o.f0;
import o.g;
import o.i;
import o.i0;
import o.j;
import o.k;
import o.l;
import o.m;
import o.n;
import o.o;
import o.p;
import o.q;
import o.r;
import o.s;
import o.t;
import o.v;
import o.w;
import o.y;
import q.e;
import t3.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class c implements e {

    /* renamed from: a, reason: collision with root package name */
    public final y2.c f11262a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f11263b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f11264c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f11265d;
    public final h e;
    public final h f;
    public final int g;

    public c(Context context, h hVar, h hVar2) {
        d dVar = new d();
        o.c cVar = o.c.f11597a;
        dVar.a(w.class, cVar);
        dVar.a(m.class, cVar);
        j jVar = j.f11622a;
        dVar.a(f0.class, jVar);
        dVar.a(t.class, jVar);
        o.d dVar2 = o.d.f11599a;
        dVar.a(y.class, dVar2);
        dVar.a(n.class, dVar2);
        o.b bVar = o.b.f11588a;
        dVar.a(o.a.class, bVar);
        dVar.a(l.class, bVar);
        i iVar = i.f11616a;
        dVar.a(e0.class, iVar);
        dVar.a(s.class, iVar);
        o.e eVar = o.e.f11602a;
        dVar.a(a0.class, eVar);
        dVar.a(o.class, eVar);
        o.h hVar3 = o.h.f11612a;
        dVar.a(d0.class, hVar3);
        dVar.a(r.class, hVar3);
        g gVar = g.f11608a;
        dVar.a(c0.class, gVar);
        dVar.a(q.class, gVar);
        k kVar = k.f11628a;
        dVar.a(i0.class, kVar);
        dVar.a(v.class, kVar);
        f fVar = f.f11605a;
        dVar.a(b0.class, fVar);
        dVar.a(p.class, fVar);
        dVar.f10197d = true;
        this.f11262a = new y2.c(dVar, 21);
        this.f11264c = context;
        this.f11263b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f11265d = b(a.f11255c);
        this.e = hVar2;
        this.f = hVar;
        this.g = 130000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(a3.a.i("Invalid url: ", str), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final p.h a(p.h r8) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n.c.a(p.h):p.h");
    }
}
