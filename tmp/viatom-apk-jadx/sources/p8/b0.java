package p8;

import java.io.Closeable;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final z f12063a;

    /* renamed from: b, reason: collision with root package name */
    public final x f12064b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12065c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12066d;
    public final q e;
    public final r f;
    public final d0 g;
    public final b0 h;

    /* renamed from: i, reason: collision with root package name */
    public final b0 f12067i;

    /* renamed from: j, reason: collision with root package name */
    public final b0 f12068j;

    /* renamed from: k, reason: collision with root package name */
    public final long f12069k;

    /* renamed from: l, reason: collision with root package name */
    public final long f12070l;

    /* renamed from: m, reason: collision with root package name */
    public volatile i f12071m;

    public b0(a0 a0Var) {
        this.f12063a = a0Var.f12051a;
        this.f12064b = a0Var.f12052b;
        this.f12065c = a0Var.f12053c;
        this.f12066d = a0Var.f12054d;
        this.e = a0Var.e;
        n5 n5Var = a0Var.f;
        n5Var.getClass();
        this.f = new r(n5Var);
        this.g = a0Var.g;
        this.h = a0Var.h;
        this.f12067i = a0Var.f12055i;
        this.f12068j = a0Var.f12056j;
        this.f12069k = a0Var.f12057k;
        this.f12070l = a0Var.f12058l;
    }

    public final i a() {
        i iVar = this.f12071m;
        if (iVar != null) {
            return iVar;
        }
        i iVarA = i.a(this.f);
        this.f12071m = iVarA;
        return iVarA;
    }

    public final String b(String str) {
        String strA = this.f.a(str);
        if (strA != null) {
            return strA;
        }
        return null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        d0 d0Var = this.g;
        if (d0Var != null) {
            d0Var.close();
        } else {
            androidx.window.layout.c.g("response is not eligible for a body and must not be closed");
        }
    }

    public final a0 d() {
        a0 a0Var = new a0();
        a0Var.f12051a = this.f12063a;
        a0Var.f12052b = this.f12064b;
        a0Var.f12053c = this.f12065c;
        a0Var.f12054d = this.f12066d;
        a0Var.e = this.e;
        a0Var.f = this.f.c();
        a0Var.g = this.g;
        a0Var.h = this.h;
        a0Var.f12055i = this.f12067i;
        a0Var.f12056j = this.f12068j;
        a0Var.f12057k = this.f12069k;
        a0Var.f12058l = this.f12070l;
        return a0Var;
    }

    public final String toString() {
        return "Response{protocol=" + this.f12064b + ", code=" + this.f12065c + ", message=" + this.f12066d + ", url=" + this.f12063a.f12205a + '}';
    }
}
