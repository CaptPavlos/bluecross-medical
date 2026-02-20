package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class b implements Comparable, Serializable {
    public static final /* synthetic */ int e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a, reason: collision with root package name */
    public final long f9321a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalDateTime f9322b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneOffset f9323c;

    /* renamed from: d, reason: collision with root package name */
    public final ZoneOffset f9324d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f9321a, ((b) obj).f9321a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        localDateTime.getClass();
        this.f9321a = j$.com.android.tools.r8.a.t(localDateTime, zoneOffset);
        this.f9322b = localDateTime;
        this.f9323c = zoneOffset;
        this.f9324d = zoneOffset2;
    }

    public b(long j10, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f9321a = j10;
        this.f9322b = LocalDateTime.z(j10, 0, zoneOffset);
        this.f9323c = zoneOffset;
        this.f9324d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean e() {
        return this.f9324d.f9142b > this.f9323c.f9142b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f9321a == bVar.f9321a && this.f9323c.equals(bVar.f9323c) && this.f9324d.equals(bVar.f9324d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f9322b.hashCode() ^ this.f9323c.f9142b) ^ Integer.rotateLeft(this.f9324d.f9142b, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(e() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f9322b);
        sb.append(this.f9323c);
        sb.append(" to ");
        sb.append(this.f9324d);
        sb.append(']');
        return sb.toString();
    }
}
