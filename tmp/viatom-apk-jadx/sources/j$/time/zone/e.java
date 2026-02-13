package j$.time.zone;

import androidx.work.WorkInfo;
import j$.time.ZoneOffset;
import j$.time.k;
import j$.time.m;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class e implements Serializable {
    private static final long serialVersionUID = 6889046316657758795L;

    /* renamed from: a, reason: collision with root package name */
    public final m f9327a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f9328b;

    /* renamed from: c, reason: collision with root package name */
    public final j$.time.d f9329c;

    /* renamed from: d, reason: collision with root package name */
    public final k f9330d;
    public final boolean e;
    public final d f;
    public final ZoneOffset g;
    public final ZoneOffset h;

    /* renamed from: i, reason: collision with root package name */
    public final ZoneOffset f9331i;

    public e(m mVar, int i10, j$.time.d dVar, k kVar, boolean z9, d dVar2, ZoneOffset zoneOffset, ZoneOffset zoneOffset2, ZoneOffset zoneOffset3) {
        this.f9327a = mVar;
        this.f9328b = (byte) i10;
        this.f9329c = dVar;
        this.f9330d = kVar;
        this.e = z9;
        this.f = dVar2;
        this.g = zoneOffset;
        this.h = zoneOffset2;
        this.f9331i = zoneOffset3;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 3, this);
    }

    public final void b(DataOutput dataOutput) {
        int iH = this.e ? 86400 : this.f9330d.H();
        int i10 = this.g.f9142b;
        int i11 = this.h.f9142b - i10;
        int i12 = this.f9331i.f9142b - i10;
        byte b10 = iH % 3600 == 0 ? this.e ? (byte) 24 : this.f9330d.f9257a : (byte) 31;
        int i13 = i10 % 900 == 0 ? (i10 / 900) + 128 : 255;
        int i14 = (i11 == 0 || i11 == 1800 || i11 == 3600) ? i11 / 1800 : 3;
        int i15 = (i12 == 0 || i12 == 1800 || i12 == 3600) ? i12 / 1800 : 3;
        j$.time.d dVar = this.f9329c;
        dataOutput.writeInt((this.f9327a.getValue() << 28) + ((this.f9328b + 32) << 22) + ((dVar == null ? 0 : dVar.getValue()) << 19) + (b10 << 14) + (this.f.ordinal() << 12) + (i13 << 4) + (i14 << 2) + i15);
        if (b10 == 31) {
            dataOutput.writeInt(iH);
        }
        if (i13 == 255) {
            dataOutput.writeInt(i10);
        }
        if (i14 == 3) {
            dataOutput.writeInt(this.h.f9142b);
        }
        if (i15 == 3) {
            dataOutput.writeInt(this.f9331i.f9142b);
        }
    }

    public static e a(DataInput dataInput) {
        m mVar;
        e eVar;
        k kVarW;
        int i10;
        int i11 = dataInput.readInt();
        m mVarY = m.y(i11 >>> 28);
        int i12 = ((264241152 & i11) >>> 22) - 32;
        int i13 = (3670016 & i11) >>> 19;
        j$.time.d dVarV = i13 == 0 ? null : j$.time.d.v(i13);
        int i14 = (507904 & i11) >>> 14;
        d dVar = d.values()[(i11 & 12288) >>> 12];
        int i15 = (i11 & 4080) >>> 4;
        int i16 = (i11 & 12) >>> 2;
        int i17 = i11 & 3;
        if (i14 == 31) {
            long j10 = dataInput.readInt();
            k kVar = k.e;
            j$.time.temporal.a.SECOND_OF_DAY.k(j10);
            int i18 = (int) (j10 / 3600);
            mVar = mVarY;
            eVar = null;
            long j11 = j10 - (i18 * 3600);
            kVarW = k.w(i18, (int) (j11 / 60), (int) (j11 - (r2 * 60)), 0);
        } else {
            mVar = mVarY;
            eVar = null;
            int i19 = i14 % 24;
            k kVar2 = k.e;
            j$.time.temporal.a.HOUR_OF_DAY.k(i19);
            kVarW = k.h[i19];
        }
        ZoneOffset zoneOffsetC = i15 == 255 ? ZoneOffset.C(dataInput.readInt()) : ZoneOffset.C((i15 + WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) * 900);
        ZoneOffset zoneOffsetC2 = i16 == 3 ? ZoneOffset.C(dataInput.readInt()) : ZoneOffset.C((i16 * 1800) + zoneOffsetC.f9142b);
        if (i17 == 3) {
            i10 = dataInput.readInt();
        } else {
            i10 = (i17 * 1800) + zoneOffsetC.f9142b;
        }
        ZoneOffset zoneOffsetC3 = ZoneOffset.C(i10);
        boolean z9 = i14 == 24;
        m mVar2 = mVar;
        Objects.requireNonNull(mVar2, "month");
        Objects.requireNonNull(kVarW, "time");
        Objects.requireNonNull(dVar, "timeDefnition");
        Objects.requireNonNull(zoneOffsetC, "standardOffset");
        Objects.requireNonNull(zoneOffsetC2, "offsetBefore");
        Objects.requireNonNull(zoneOffsetC3, "offsetAfter");
        if (i12 < -28 || i12 > 31 || i12 == 0) {
            j$.time.g.c("Day of month indicator must be between -28 and 31 inclusive excluding zero");
            return eVar;
        }
        if (z9 && !kVarW.equals(k.g)) {
            j$.time.g.c("Time must be midnight when end of day flag is true");
            return eVar;
        }
        if (kVarW.f9260d != 0) {
            j$.time.g.c("Time's nano-of-second must be zero");
            return eVar;
        }
        return new e(mVar2, i12, dVarV, kVarW, z9, dVar, zoneOffsetC, zoneOffsetC2, zoneOffsetC3);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f9327a == eVar.f9327a && this.f9328b == eVar.f9328b && this.f9329c == eVar.f9329c && this.f == eVar.f && this.f9330d.equals(eVar.f9330d) && this.e == eVar.e && this.g.equals(eVar.g) && this.h.equals(eVar.h) && this.f9331i.equals(eVar.f9331i);
    }

    public final int hashCode() {
        int iH = ((this.f9330d.H() + (this.e ? 1 : 0)) << 15) + (this.f9327a.ordinal() << 11) + ((this.f9328b + 32) << 5);
        j$.time.d dVar = this.f9329c;
        return ((this.g.f9142b ^ (this.f.ordinal() + (iH + ((dVar == null ? 7 : dVar.ordinal()) << 2)))) ^ this.h.f9142b) ^ this.f9331i.f9142b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TransitionRule[");
        sb.append(this.f9331i.f9142b - this.h.f9142b > 0 ? "Gap " : "Overlap ");
        sb.append(this.h);
        sb.append(" to ");
        sb.append(this.f9331i);
        sb.append(", ");
        j$.time.d dVar = this.f9329c;
        if (dVar != null) {
            byte b10 = this.f9328b;
            if (b10 == -1) {
                sb.append(dVar.name());
                sb.append(" on or before last day of ");
                sb.append(this.f9327a.name());
            } else if (b10 < 0) {
                sb.append(dVar.name());
                sb.append(" on or before last day minus ");
                sb.append((-this.f9328b) - 1);
                sb.append(" of ");
                sb.append(this.f9327a.name());
            } else {
                sb.append(dVar.name());
                sb.append(" on or after ");
                sb.append(this.f9327a.name());
                sb.append(' ');
                sb.append((int) this.f9328b);
            }
        } else {
            sb.append(this.f9327a.name());
            sb.append(' ');
            sb.append((int) this.f9328b);
        }
        sb.append(" at ");
        sb.append(this.e ? "24:00" : this.f9330d.toString());
        sb.append(" ");
        sb.append(this.f);
        sb.append(", standard offset ");
        sb.append(this.g);
        sb.append(']');
        return sb.toString();
    }
}
