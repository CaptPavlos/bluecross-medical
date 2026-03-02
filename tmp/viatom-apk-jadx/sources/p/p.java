package p;

import android.content.Context;
import c5.b0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.DesugarCollections;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import w2.r;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class p {
    public static volatile j e;

    /* renamed from: a, reason: collision with root package name */
    public final t3.h f11869a;

    /* renamed from: b, reason: collision with root package name */
    public final t3.h f11870b;

    /* renamed from: c, reason: collision with root package name */
    public final u.a f11871c;

    /* renamed from: d, reason: collision with root package name */
    public final v.h f11872d;

    public p(t3.h hVar, t3.h hVar2, u.a aVar, v.h hVar3, r rVar) {
        this.f11869a = hVar;
        this.f11870b = hVar2;
        this.f11871c = aVar;
        this.f11872d = hVar3;
        ((Executor) rVar.f13462b).execute(new androidx.constraintlayout.helper.widget.a(rVar, 12));
    }

    public static p a() {
        j jVar = e;
        if (jVar != null) {
            return (p) jVar.f.get();
        }
        androidx.window.layout.c.g("Not initialized!");
        return null;
    }

    public static void b(Context context) {
        if (e == null) {
            synchronized (p.class) {
                try {
                    if (e == null) {
                        b0 b0Var = new b0();
                        context.getClass();
                        b0Var.f1657a = context;
                        e = b0Var.a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final o c(n.a aVar) {
        byte[] bytes;
        Set setUnmodifiableSet = aVar instanceof n.a ? DesugarCollections.unmodifiableSet(n.a.f11256d) : Collections.singleton(new m.c("proto"));
        aVar.getClass();
        String str = aVar.f11257a;
        String str2 = aVar.f11258b;
        if (str2 == null && str == null) {
            bytes = null;
        } else {
            if (str2 == null) {
                str2 = "";
            }
            bytes = ("1$" + str + "\\" + str2).getBytes(Charset.forName(C.UTF8_NAME));
        }
        return new o(setUnmodifiableSet, new i("cct", bytes, m.d.f11154a), this);
    }
}
