package j$.time.chrono;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class h implements Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = 57387258289L;

    /* renamed from: a, reason: collision with root package name */
    public final l f9163a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9164b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9165c;

    /* renamed from: d, reason: collision with root package name */
    public final int f9166d;

    static {
        Object[] objArr = {j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i10 = 0; i10 < 3; i10++) {
            arrayList.add(Objects.requireNonNull(objArr[i10]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public h(l lVar, int i10, int i11, int i12) {
        Objects.requireNonNull(lVar, "chrono");
        this.f9163a = lVar;
        this.f9164b = i10;
        this.f9165c = i11;
        this.f9166d = i12;
    }

    public final String toString() {
        if (this.f9164b == 0 && this.f9165c == 0 && this.f9166d == 0) {
            return this.f9163a.toString() + " P0D";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9163a.toString());
        sb.append(" P");
        int i10 = this.f9164b;
        if (i10 != 0) {
            sb.append(i10);
            sb.append('Y');
        }
        int i11 = this.f9165c;
        if (i11 != 0) {
            sb.append(i11);
            sb.append('M');
        }
        int i12 = this.f9166d;
        if (i12 != 0) {
            sb.append(i12);
            sb.append('D');
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.f9164b == hVar.f9164b && this.f9165c == hVar.f9165c && this.f9166d == hVar.f9166d && this.f9163a.equals(hVar.f9163a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Integer.rotateLeft(this.f9166d, 16) + (Integer.rotateLeft(this.f9165c, 8) + this.f9164b)) ^ this.f9163a.hashCode();
    }

    public Object writeReplace() {
        return new e0((byte) 9, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
