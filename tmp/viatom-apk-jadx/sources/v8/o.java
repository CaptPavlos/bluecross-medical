package v8;

import java.io.IOException;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends q8.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f13243b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13244c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f13245d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(q qVar, s sVar) {
        super("OkHttp %s", qVar.f13251d);
        this.f13244c = qVar;
        this.f13245d = sVar;
    }

    @Override // q8.a
    public final void a() throws IOException {
        int i10 = this.f13243b;
        Object obj = this.f13245d;
        Object obj2 = this.f13244c;
        switch (i10) {
            case 0:
                w wVar = (w) obj;
                q qVar = (q) ((o) obj2).f13244c;
                try {
                    qVar.f13249b.b(wVar);
                    return;
                } catch (IOException e) {
                    x8.h.f13740a.k(4, "Http2Connection.Listener failure for " + qVar.f13251d, e);
                    try {
                        wVar.c(2);
                        return;
                    } catch (IOException unused) {
                        return;
                    }
                }
            case 1:
                q qVar2 = (q) ((o) obj2).f13244c;
                try {
                    qVar2.f13261r.a((h0.a0) obj);
                    return;
                } catch (IOException unused2) {
                    ThreadPoolExecutor threadPoolExecutor = q.f13247u;
                    qVar2.b();
                    return;
                }
            default:
                q qVar3 = (q) obj2;
                s sVar = (s) obj;
                try {
                    try {
                        sVar.d(this);
                        do {
                        } while (sVar.b(false, this));
                        qVar3.a(1, 6);
                    } catch (IOException unused3) {
                    }
                } catch (IOException unused4) {
                    qVar3.a(2, 2);
                } catch (Throwable th) {
                    try {
                        qVar3.a(3, 3);
                    } catch (IOException unused5) {
                    }
                    q8.c.c(sVar);
                    throw th;
                }
                q8.c.c(sVar);
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(o oVar, Object[] objArr, w wVar) {
        super("OkHttp %s stream %d", objArr);
        this.f13244c = oVar;
        this.f13245d = wVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(o oVar, Object[] objArr, h0.a0 a0Var) {
        super("OkHttp %s ACK Settings", objArr);
        this.f13244c = oVar;
        this.f13245d = a0Var;
    }
}
