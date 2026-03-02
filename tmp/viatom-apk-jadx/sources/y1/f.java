package y1;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements k {

    /* renamed from: c, reason: collision with root package name */
    public static final t3.h f13756c = new t3.h(18);

    /* renamed from: a, reason: collision with root package name */
    public final Object f13757a;

    /* renamed from: b, reason: collision with root package name */
    public Object f13758b;

    public f(c2.d dVar) {
        this.f13757a = dVar;
        this.f13758b = f13756c;
    }

    @Override // y1.k
    public void a(j jVar, int i10) throws IOException {
        int[] iArr = (int[]) this.f13758b;
        try {
            jVar.read((byte[]) this.f13757a, iArr[0], i10);
            iArr[0] = iArr[0] + i10;
        } finally {
            jVar.close();
        }
    }

    public f(byte[] bArr, int[] iArr) {
        this.f13757a = bArr;
        this.f13758b = iArr;
    }
}
