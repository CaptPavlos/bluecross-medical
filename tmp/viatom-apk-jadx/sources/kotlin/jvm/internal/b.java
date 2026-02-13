package kotlin.jvm.internal;

import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class b implements Iterator, h7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10127a;

    /* renamed from: b, reason: collision with root package name */
    public int f10128b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10129c;

    public b(Object[] objArr) {
        this.f10127a = 0;
        objArr.getClass();
        this.f10129c = objArr;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f10127a) {
            case 0:
                return this.f10128b < ((Object[]) this.f10129c).length;
            case 1:
                return this.f10128b < ((byte[]) this.f10129c).length;
            case 2:
                return this.f10128b < ((int[]) this.f10129c).length;
            case 3:
                return this.f10128b < ((long[]) this.f10129c).length;
            case 4:
                return this.f10128b < ((short[]) this.f10129c).length;
            case 5:
                return this.f10128b < ((t6.e) this.f10129c).size();
            default:
                return ((Iterator) this.f10129c).hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f10127a) {
            case 0:
                try {
                    Object[] objArr = (Object[]) this.f10129c;
                    int i10 = this.f10128b;
                    this.f10128b = i10 + 1;
                    return objArr[i10];
                } catch (ArrayIndexOutOfBoundsException e) {
                    this.f10128b--;
                    com.google.gson.internal.a.o(e.getMessage());
                    return null;
                }
            case 1:
                int i11 = this.f10128b;
                byte[] bArr = (byte[]) this.f10129c;
                if (i11 < bArr.length) {
                    this.f10128b = i11 + 1;
                    return new s6.n(bArr[i11]);
                }
                com.google.gson.internal.a.o(String.valueOf(i11));
                return null;
            case 2:
                int i12 = this.f10128b;
                int[] iArr = (int[]) this.f10129c;
                if (i12 < iArr.length) {
                    this.f10128b = i12 + 1;
                    return new s6.p(iArr[i12]);
                }
                com.google.gson.internal.a.o(String.valueOf(i12));
                return null;
            case 3:
                int i13 = this.f10128b;
                long[] jArr = (long[]) this.f10129c;
                if (i13 < jArr.length) {
                    this.f10128b = i13 + 1;
                    return new s6.r(jArr[i13]);
                }
                com.google.gson.internal.a.o(String.valueOf(i13));
                return null;
            case 4:
                int i14 = this.f10128b;
                short[] sArr = (short[]) this.f10129c;
                if (i14 < sArr.length) {
                    this.f10128b = i14 + 1;
                    return new s6.u(sArr[i14]);
                }
                com.google.gson.internal.a.o(String.valueOf(i14));
                return null;
            case 5:
                if (!hasNext()) {
                    com.google.gson.internal.a.b();
                    return null;
                }
                t6.e eVar = (t6.e) this.f10129c;
                int i15 = this.f10128b;
                this.f10128b = i15 + 1;
                return eVar.get(i15);
            default:
                int i16 = this.f10128b;
                this.f10128b = i16 + 1;
                if (i16 >= 0) {
                    return new t6.w(i16, ((Iterator) this.f10129c).next());
                }
                t6.m.U();
                throw null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f10127a) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 2:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 4:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 5:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public /* synthetic */ b(Object obj, int i10) {
        this.f10127a = i10;
        this.f10129c = obj;
    }

    public b(Iterator it) {
        this.f10127a = 6;
        it.getClass();
        this.f10129c = it;
    }
}
