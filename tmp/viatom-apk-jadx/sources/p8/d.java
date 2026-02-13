package p8;

import java.io.IOException;
import z8.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends z8.r {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r8.e f12077b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(h0 h0Var, r8.e eVar) {
        super(h0Var);
        this.f12077b = eVar;
    }

    @Override // z8.r, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12077b.close();
        super.close();
    }
}
