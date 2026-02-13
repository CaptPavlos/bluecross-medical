package o7;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11763a;

    /* renamed from: b, reason: collision with root package name */
    public int f11764b;

    /* renamed from: c, reason: collision with root package name */
    public int f11765c;

    /* renamed from: d, reason: collision with root package name */
    public int f11766d;
    public int e;

    public g(String str) {
        this.f11763a = str;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10;
        int i11;
        int i12 = this.f11764b;
        if (i12 != 0) {
            return i12 == 1;
        }
        if (this.e < 0) {
            this.f11764b = 2;
            return false;
        }
        String str = this.f11763a;
        int length = str.length();
        int length2 = str.length();
        for (int i13 = this.f11765c; i13 < length2; i13++) {
            char cCharAt = str.charAt(i13);
            if (cCharAt == '\n' || cCharAt == '\r') {
                i10 = (cCharAt == '\r' && (i11 = i13 + 1) < str.length() && str.charAt(i11) == '\n') ? 2 : 1;
                length = i13;
                this.f11764b = 1;
                this.e = i10;
                this.f11766d = length;
                return true;
            }
        }
        i10 = -1;
        this.f11764b = 1;
        this.e = i10;
        this.f11766d = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.b();
            return null;
        }
        this.f11764b = 0;
        int i10 = this.f11766d;
        int i11 = this.f11765c;
        this.f11765c = this.e + i10;
        return this.f11763a.subSequence(i11, i10).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
