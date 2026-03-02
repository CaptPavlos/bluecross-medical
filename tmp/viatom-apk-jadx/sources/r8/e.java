package r8;

import java.io.Closeable;
import java.io.IOException;
import z8.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final String f12471a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12472b;

    /* renamed from: c, reason: collision with root package name */
    public final h0[] f12473c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f f12474d;

    public e(f fVar, String str, long j10, h0[] h0VarArr) {
        this.f12474d = fVar;
        this.f12471a = str;
        this.f12472b = j10;
        this.f12473c = h0VarArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        for (h0 h0Var : this.f12473c) {
            q8.c.c(h0Var);
        }
    }
}
