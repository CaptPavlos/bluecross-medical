package r8;

import c1.g1;
import java.io.EOFException;
import java.io.IOException;
import z8.i;
import z8.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends q {

    /* renamed from: b, reason: collision with root package name */
    public boolean f12464b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12465c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f12466d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, z8.b bVar, int i10) {
        super(bVar);
        this.f12465c = i10;
        this.f12466d = obj;
    }

    public final void a() {
        switch (this.f12465c) {
            case 0:
                ((f) this.f12466d).f12484m = true;
                return;
            default:
                synchronized (((f) ((g1) this.f12466d).f1232d)) {
                    ((g1) this.f12466d).e();
                }
                return;
        }
    }

    @Override // z8.q, z8.f0
    public final void c(i iVar, long j10) throws EOFException {
        if (this.f12464b) {
            iVar.skip(j10);
            return;
        }
        try {
            this.f14502a.c(iVar, j10);
        } catch (IOException unused) {
            this.f12464b = true;
            a();
        }
    }

    @Override // z8.q, z8.f0, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f12464b) {
            return;
        }
        try {
            super.close();
        } catch (IOException unused) {
            this.f12464b = true;
            a();
        }
    }

    @Override // z8.q, z8.f0, java.io.Flushable
    public final void flush() {
        if (this.f12464b) {
            return;
        }
        try {
            super.flush();
        } catch (IOException unused) {
            this.f12464b = true;
            a();
        }
    }
}
