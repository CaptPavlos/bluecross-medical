package q;

import android.content.Context;
import t3.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12211a;

    /* renamed from: b, reason: collision with root package name */
    public final h f12212b;

    /* renamed from: c, reason: collision with root package name */
    public final h f12213c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12214d;

    public b(Context context, h hVar, h hVar2, String str) {
        if (context == null) {
            androidx.window.layout.c.k("Null applicationContext");
            throw null;
        }
        this.f12211a = context;
        if (hVar == null) {
            androidx.window.layout.c.k("Null wallClock");
            throw null;
        }
        this.f12212b = hVar;
        if (hVar2 == null) {
            androidx.window.layout.c.k("Null monotonicClock");
            throw null;
        }
        this.f12213c = hVar2;
        if (str != null) {
            this.f12214d = str;
        } else {
            androidx.window.layout.c.k("Null backendName");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            b bVar = (b) ((c) obj);
            if (this.f12211a.equals(bVar.f12211a) && this.f12212b.equals(bVar.f12212b) && this.f12213c.equals(bVar.f12213c) && this.f12214d.equals(bVar.f12214d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f12211a.hashCode() ^ 1000003) * 1000003) ^ this.f12212b.hashCode()) * 1000003) ^ this.f12213c.hashCode()) * 1000003) ^ this.f12214d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f12211a);
        sb.append(", wallClock=");
        sb.append(this.f12212b);
        sb.append(", monotonicClock=");
        sb.append(this.f12213c);
        sb.append(", backendName=");
        return a3.a.o(sb, this.f12214d, "}");
    }
}
