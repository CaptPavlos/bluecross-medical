package r2;

import i0.k;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12346a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f12347b;

    public /* synthetic */ b(c cVar, int i10) {
        this.f12346a = i10;
        this.f12347b = cVar;
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        s2.b bVarC;
        s2.b bVarI;
        switch (this.f12346a) {
            case 0:
                this.f12347b.b();
                return;
            case 1:
                this.f12347b.b();
                return;
            default:
                c cVar = this.f12347b;
                synchronized (c.f12348m) {
                    try {
                        l1.g gVar = cVar.f12349a;
                        gVar.a();
                        k kVarB = k.b(gVar.f10177a);
                        try {
                            bVarC = cVar.f12351c.C();
                            if (kVarB != null) {
                                kVarB.E();
                            }
                        } catch (Throwable th) {
                            if (kVarB != null) {
                                kVarB.E();
                            }
                            throw th;
                        }
                    } finally {
                    }
                }
                try {
                    int i10 = bVarC.f12523b;
                    if (i10 == 5) {
                        bVarI = cVar.i(bVarC);
                    } else {
                        if (i10 == 3) {
                            bVarI = cVar.i(bVarC);
                        } else if (!cVar.f12352d.a(bVarC)) {
                            return;
                        } else {
                            bVarI = cVar.c(bVarC);
                        }
                    }
                    cVar.f(bVarI);
                    cVar.m(bVarC, bVarI);
                    if (bVarI.f12523b == 4) {
                        cVar.l(bVarI.f12522a);
                    }
                    int i11 = bVarI.f12523b;
                    if (i11 == 5) {
                        cVar.j(new e());
                        return;
                    } else if (i11 == 2 || i11 == 1) {
                        cVar.j(new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."));
                        return;
                    } else {
                        cVar.k(bVarI);
                        return;
                    }
                } catch (e e) {
                    cVar.j(e);
                    return;
                }
        }
    }
}
