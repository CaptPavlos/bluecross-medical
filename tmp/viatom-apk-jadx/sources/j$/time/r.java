package j$.time;

import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class r implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final r f9272d = new r(0, 0, 0);
    private static final long serialVersionUID = -3587258372562876L;

    /* renamed from: a, reason: collision with root package name */
    public final int f9273a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9274b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9275c;

    static {
        Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)Y)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)W)?(?:([-+]?[0-9]+)D)?", 2);
        Object[] objArr = {j$.time.temporal.b.YEARS, j$.time.temporal.b.MONTHS, j$.time.temporal.b.DAYS};
        ArrayList arrayList = new ArrayList(3);
        for (int i10 = 0; i10 < 3; i10++) {
            arrayList.add(Objects.requireNonNull(objArr[i10]));
        }
        Collections.unmodifiableList(arrayList);
    }

    public r(int i10, int i11, int i12) {
        this.f9273a = i10;
        this.f9274b = i11;
        this.f9275c = i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.f9273a == rVar.f9273a && this.f9274b == rVar.f9274b && this.f9275c == rVar.f9275c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Integer.rotateLeft(this.f9275c, 16) + Integer.rotateLeft(this.f9274b, 8) + this.f9273a;
    }

    public final String toString() {
        if (this == f9272d) {
            return "P0D";
        }
        StringBuilder sb = new StringBuilder("P");
        int i10 = this.f9273a;
        if (i10 != 0) {
            sb.append(i10);
            sb.append('Y');
        }
        int i11 = this.f9274b;
        if (i11 != 0) {
            sb.append(i11);
            sb.append('M');
        }
        int i12 = this.f9275c;
        if (i12 != 0) {
            sb.append(i12);
            sb.append('D');
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 14, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
