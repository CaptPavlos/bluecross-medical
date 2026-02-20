package z6;

import java.io.Serializable;
import t6.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends e implements a, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Enum[] f14448a;

    public b(Enum[] enumArr) {
        enumArr.getClass();
        this.f14448a = enumArr;
    }

    @Override // t6.a, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        Enum r42 = (Enum) obj;
        int iOrdinal = r42.ordinal();
        Enum[] enumArr = this.f14448a;
        enumArr.getClass();
        return ((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r42;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        t6.b bVar = e.Companion;
        Enum[] enumArr = this.f14448a;
        int length = enumArr.length;
        bVar.getClass();
        t6.b.b(i10, length);
        return enumArr[i10];
    }

    @Override // t6.a
    public final int getSize() {
        return this.f14448a.length;
    }

    @Override // t6.e, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r52 = (Enum) obj;
        int iOrdinal = r52.ordinal();
        Enum[] enumArr = this.f14448a;
        enumArr.getClass();
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r52) {
            return iOrdinal;
        }
        return -1;
    }

    @Override // t6.e, java.util.List
    public final int lastIndexOf(Object obj) {
        if (!(obj instanceof Enum)) {
            return -1;
        }
        Enum r52 = (Enum) obj;
        int iOrdinal = r52.ordinal();
        Enum[] enumArr = this.f14448a;
        enumArr.getClass();
        if (((iOrdinal < 0 || iOrdinal >= enumArr.length) ? null : enumArr[iOrdinal]) == r52) {
            return iOrdinal;
        }
        return -1;
    }
}
