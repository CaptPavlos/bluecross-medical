package r8;

import c1.g1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p8.u;
import z1.t1;
import z8.h0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f12467a;

    /* renamed from: b, reason: collision with root package name */
    public final long[] f12468b;

    /* renamed from: c, reason: collision with root package name */
    public final File[] f12469c;

    /* renamed from: d, reason: collision with root package name */
    public final File[] f12470d;
    public boolean e;
    public g1 f;
    public long g;
    public final /* synthetic */ f h;

    public d(f fVar, String str) {
        this.h = fVar;
        this.f12467a = str;
        int i10 = fVar.h;
        File file = fVar.f12477b;
        this.f12468b = new long[i10];
        this.f12469c = new File[i10];
        this.f12470d = new File[i10];
        StringBuilder sb = new StringBuilder(str);
        sb.append('.');
        int length = sb.length();
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append(i11);
            this.f12469c[i11] = new File(file, sb.toString());
            sb.append(".tmp");
            this.f12470d[i11] = new File(file, sb.toString());
            sb.setLength(length);
        }
    }

    public final e a() throws IOException {
        f fVar = this.h;
        int i10 = fVar.h;
        if (!Thread.holdsLock(fVar)) {
            u.m();
            return null;
        }
        h0[] h0VarArr = new h0[i10];
        for (int i11 = 0; i11 < fVar.h; i11++) {
            try {
                w8.a aVar = fVar.f12476a;
                File file = this.f12469c[i11];
                aVar.getClass();
                h0VarArr[i11] = t1.S(file);
            } catch (FileNotFoundException unused) {
                for (int i12 = 0; i12 < i10; i12++) {
                    h0 h0Var = h0VarArr[i12];
                    if (h0Var != null) {
                        q8.c.c(h0Var);
                    }
                }
                try {
                    fVar.n(this);
                    return null;
                } catch (IOException unused2) {
                    return null;
                }
            }
        }
        return new e(fVar, this.f12467a, this.g, h0VarArr);
    }
}
