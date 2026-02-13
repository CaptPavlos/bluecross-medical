package l7;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b implements Iterable, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f11084a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11085b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11086c;

    public b(int i10, int i11, int i12) {
        if (i12 == 0) {
            com.google.gson.internal.a.n("Step must be non-zero.");
            throw null;
        }
        if (i12 == Integer.MIN_VALUE) {
            com.google.gson.internal.a.n("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.f11084a = i10;
        if (i12 > 0) {
            if (i10 < i11) {
                int i13 = i11 % i12;
                int i14 = i10 % i12;
                int i15 = ((i13 < 0 ? i13 + i12 : i13) - (i14 < 0 ? i14 + i12 : i14)) % i12;
                i11 -= i15 < 0 ? i15 + i12 : i15;
            }
        } else {
            if (i12 >= 0) {
                com.google.gson.internal.a.n("Step is zero.");
                throw null;
            }
            if (i10 > i11) {
                int i16 = -i12;
                int i17 = i10 % i16;
                int i18 = i11 % i16;
                int i19 = ((i17 < 0 ? i17 + i16 : i17) - (i18 < 0 ? i18 + i16 : i18)) % i16;
                i11 += i19 < 0 ? i19 + i16 : i19;
            }
        }
        this.f11085b = i11;
        this.f11086c = i12;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (isEmpty() && ((b) obj).isEmpty()) {
            return true;
        }
        b bVar = (b) obj;
        return this.f11084a == bVar.f11084a && this.f11085b == bVar.f11085b && this.f11086c == bVar.f11086c;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f11084a * 31) + this.f11085b) * 31) + this.f11086c;
    }

    public boolean isEmpty() {
        int i10 = this.f11085b;
        int i11 = this.f11086c;
        int i12 = this.f11084a;
        return i11 > 0 ? i12 > i10 : i12 < i10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this.f11084a, this.f11085b, this.f11086c);
    }

    public String toString() {
        StringBuilder sb;
        int i10 = this.f11085b;
        int i11 = this.f11086c;
        int i12 = this.f11084a;
        if (i11 > 0) {
            sb = new StringBuilder();
            sb.append(i12);
            sb.append("..");
            sb.append(i10);
            sb.append(" step ");
            sb.append(i11);
        } else {
            sb = new StringBuilder();
            sb.append(i12);
            sb.append(" downTo ");
            sb.append(i10);
            sb.append(" step ");
            sb.append(-i11);
        }
        return sb.toString();
    }
}
