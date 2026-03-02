package a4;

import c1.c1;
import c1.v4;
import c1.w4;
import com.uptodown.activities.AppDetailActivity;
import h0.k;
import h1.m;
import java.io.IOException;
import z8.a0;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f199a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f200b;

    public a(y3.d dVar) {
        this.f199a = 25;
        this.f200b = dVar.g;
    }

    private final void a() {
        synchronized (((m) this.f200b).f8431c) {
            ((h1.c) ((m) this.f200b).f8432d).n();
        }
    }

    private final void b() {
        while (true) {
            long jA = ((p8.m) this.f200b).a(System.nanoTime());
            if (jA == -1) {
                return;
            }
            if (jA > 0) {
                long j10 = jA / 1000000;
                long j11 = jA - (1000000 * j10);
                synchronized (((p8.m) this.f200b)) {
                    try {
                        ((p8.m) this.f200b).wait(j10, (int) j11);
                    } catch (InterruptedException unused) {
                    }
                }
            }
        }
    }

    private final void c() {
        synchronized (((r8.f) this.f200b)) {
            r8.f fVar = (r8.f) this.f200b;
            if ((!fVar.f12485n) || fVar.f12486o) {
                return;
            }
            try {
                fVar.o();
            } catch (IOException unused) {
                ((r8.f) this.f200b).f12487p = true;
            }
            try {
                if (((r8.f) this.f200b).h()) {
                    ((r8.f) this.f200b).m();
                    ((r8.f) this.f200b).f12483l = 0;
                }
            } catch (IOException unused2) {
                r8.f fVar2 = (r8.f) this.f200b;
                fVar2.f12488q = true;
                fVar2.f12481j = new a0(new z8.e());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0387  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1134
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a4.a.run():void");
    }

    public /* synthetic */ a(Object obj, int i10) {
        this.f199a = i10;
        this.f200b = obj;
    }

    public a(k kVar, h0.a0 a0Var) {
        this.f199a = 13;
        this.f200b = a0Var;
    }

    public a(c1 c1Var, boolean z9) {
        this.f199a = 1;
        this.f200b = c1Var;
    }

    public a(v4 v4Var, w4 w4Var) {
        this.f199a = 5;
        this.f200b = v4Var;
    }

    public a(AppDetailActivity appDetailActivity, String str, int i10) {
        this.f199a = 17;
        this.f200b = appDetailActivity;
    }
}
