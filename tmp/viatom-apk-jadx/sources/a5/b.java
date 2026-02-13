package a5;

import com.google.android.gms.internal.measurement.a4;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f223a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f224b;

    public /* synthetic */ b(d dVar, int i10) {
        this.f223a = i10;
        this.f224b = dVar;
    }

    private final void a() {
        d dVar;
        d dVar2;
        while (true) {
            try {
                try {
                    synchronized (this.f224b.f232i) {
                        while (true) {
                            try {
                                d dVar3 = this.f224b;
                                if (dVar3.f233j || dVar3.f238o < dVar3.f232i.size()) {
                                    break;
                                }
                                d dVar4 = this.f224b;
                                dVar4.f234k = false;
                                dVar4.f232i.wait();
                            } finally {
                            }
                        }
                    }
                    d dVar5 = this.f224b;
                    if (dVar5.f238o >= dVar5.f236m) {
                        while (true) {
                            dVar2 = this.f224b;
                            if (dVar2.f237n == dVar2.f238o) {
                                break;
                            } else {
                                a4.x("Waiting for read and write to catch up before cleanup.");
                            }
                        }
                        d.a(dVar2);
                    }
                    d dVar6 = this.f224b;
                    int i10 = dVar6.f238o;
                    int size = dVar6.f232i.size();
                    dVar = this.f224b;
                    if (i10 < size) {
                        dVar.f234k = true;
                        y4.a aVar = (y4.a) dVar.f232i.get(dVar.f238o);
                        aVar.e();
                        a4.x("Executing: " + aVar.b() + " with context: " + a3.a.D(this.f224b.f230c));
                        this.f224b.h.write(aVar.b());
                        this.f224b.h.flush();
                        this.f224b.h.write("\necho F*D^W@#FGF " + this.f224b.f239p + " $?\n");
                        this.f224b.h.flush();
                        d dVar7 = this.f224b;
                        dVar7.f238o = dVar7.f238o + 1;
                        dVar7.f239p = dVar7.f239p + 1;
                    } else if (dVar.f233j) {
                        break;
                    }
                } finally {
                    d dVar8 = this.f224b;
                    dVar8.f238o = 0;
                    d.b(dVar8.h);
                }
            } catch (IOException e) {
                e = e;
                a4.x(e.getMessage());
                d dVar9 = this.f224b;
                dVar9.f238o = 0;
                d.b(dVar9.h);
            } catch (InterruptedException e3) {
                e = e3;
                a4.x(e.getMessage());
                d dVar92 = this.f224b;
                dVar92.f238o = 0;
                d.b(dVar92.h);
            }
        }
        dVar.f234k = false;
        dVar.h.write("\nexit 0\n");
        this.f224b.h.flush();
        a4.x("Closing shell");
        d dVar922 = this.f224b;
        dVar922.f238o = 0;
        d.b(dVar922.h);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        r9.f224b.e.waitFor();
        r9.f224b.e.destroy();
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x003a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003b  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 448
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.b.run():void");
    }
}
