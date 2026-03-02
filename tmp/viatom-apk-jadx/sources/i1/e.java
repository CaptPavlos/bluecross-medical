package i1;

import com.google.android.gms.internal.measurement.c6;
import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final c6 f8962a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient boolean f8963b;

    /* renamed from: c, reason: collision with root package name */
    public transient Object f8964c;

    public e(c6 c6Var) {
        this.f8962a = c6Var;
    }

    @Override // i1.d
    public final Object get() {
        if (!this.f8963b) {
            synchronized (this) {
                try {
                    if (!this.f8963b) {
                        Object obj = this.f8962a.get();
                        this.f8964c = obj;
                        this.f8963b = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f8964c;
    }

    public final String toString() {
        Object string;
        if (this.f8963b) {
            String strValueOf = String.valueOf(this.f8964c);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        } else {
            string = this.f8962a;
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
