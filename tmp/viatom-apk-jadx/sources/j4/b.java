package j4;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public final y f9917a;

    /* renamed from: b, reason: collision with root package name */
    public final c0 f9918b;

    /* renamed from: c, reason: collision with root package name */
    public final a f9919c;

    /* renamed from: d, reason: collision with root package name */
    public final String f9920d;
    public final b e;
    public boolean f;
    public boolean g;

    public b(y yVar, Object obj, c0 c0Var, String str) {
        this.f9917a = yVar;
        this.f9918b = c0Var;
        this.f9919c = obj == null ? null : new a(this, obj, yVar.h);
        this.f9920d = str;
        this.e = this;
    }

    public void a() {
        this.g = true;
    }

    public abstract void b(Bitmap bitmap, int i10);

    public abstract void c(Exception exc);

    public Object d() {
        a aVar = this.f9919c;
        if (aVar == null) {
            return null;
        }
        return aVar.get();
    }
}
