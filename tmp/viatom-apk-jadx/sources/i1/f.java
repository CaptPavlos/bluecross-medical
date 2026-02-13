package i1;

import com.google.android.gms.internal.measurement.c6;
import j$.util.Objects;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public volatile c6 f8965a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f8966b;

    /* renamed from: c, reason: collision with root package name */
    public Object f8967c;

    @Override // i1.d
    public final Object get() {
        if (!this.f8966b) {
            synchronized (this) {
                try {
                    if (!this.f8966b) {
                        c6 c6Var = this.f8965a;
                        Objects.requireNonNull(c6Var);
                        Object obj = c6Var.get();
                        this.f8967c = obj;
                        this.f8966b = true;
                        this.f8965a = null;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f8967c;
    }

    public final String toString() {
        Object string = this.f8965a;
        if (string == null) {
            String strValueOf = String.valueOf(this.f8967c);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
