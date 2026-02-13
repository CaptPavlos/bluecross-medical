package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import j$.util.Objects;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* loaded from: classes2.dex */
public final class s implements Externalizable {
    private static final long serialVersionUID = -7683839454370182990L;

    /* renamed from: a, reason: collision with root package name */
    public byte f9276a;

    /* renamed from: b, reason: collision with root package name */
    public Object f9277b;

    public s() {
    }

    public s(byte b10, Object obj) {
        this.f9276a = b10;
        this.f9277b = obj;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput objectOutput) throws IOException {
        byte b10 = this.f9276a;
        Object obj = this.f9277b;
        objectOutput.writeByte(b10);
        switch (b10) {
            case 1:
                Duration duration = (Duration) obj;
                objectOutput.writeLong(duration.f9128a);
                objectOutput.writeInt(duration.f9129b);
                return;
            case 2:
                Instant instant = (Instant) obj;
                objectOutput.writeLong(instant.f9131a);
                objectOutput.writeInt(instant.f9132b);
                return;
            case 3:
                h hVar = (h) obj;
                objectOutput.writeInt(hVar.f9251a);
                objectOutput.writeByte(hVar.f9252b);
                objectOutput.writeByte(hVar.f9253c);
                return;
            case 4:
                ((k) obj).K(objectOutput);
                return;
            case 5:
                LocalDateTime localDateTime = (LocalDateTime) obj;
                h hVar2 = localDateTime.f9135a;
                objectOutput.writeInt(hVar2.f9251a);
                objectOutput.writeByte(hVar2.f9252b);
                objectOutput.writeByte(hVar2.f9253c);
                localDateTime.f9136b.K(objectOutput);
                return;
            case 6:
                ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
                LocalDateTime localDateTime2 = zonedDateTime.f9144a;
                h hVar3 = localDateTime2.f9135a;
                objectOutput.writeInt(hVar3.f9251a);
                objectOutput.writeByte(hVar3.f9252b);
                objectOutput.writeByte(hVar3.f9253c);
                localDateTime2.f9136b.K(objectOutput);
                zonedDateTime.f9145b.F(objectOutput);
                zonedDateTime.f9146c.z(objectOutput);
                return;
            case 7:
                objectOutput.writeUTF(((x) obj).f9316b);
                return;
            case 8:
                ((ZoneOffset) obj).F(objectOutput);
                return;
            case 9:
                q qVar = (q) obj;
                qVar.f9270a.K(objectOutput);
                qVar.f9271b.F(objectOutput);
                return;
            case 10:
                OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
                LocalDateTime localDateTime3 = offsetDateTime.f9138a;
                h hVar4 = localDateTime3.f9135a;
                objectOutput.writeInt(hVar4.f9251a);
                objectOutput.writeByte(hVar4.f9252b);
                objectOutput.writeByte(hVar4.f9253c);
                localDateTime3.f9136b.K(objectOutput);
                offsetDateTime.f9139b.F(objectOutput);
                return;
            case 11:
                objectOutput.writeInt(((u) obj).f9309a);
                return;
            case 12:
                w wVar = (w) obj;
                objectOutput.writeInt(wVar.f9313a);
                objectOutput.writeByte(wVar.f9314b);
                return;
            case 13:
                o oVar = (o) obj;
                objectOutput.writeByte(oVar.f9266a);
                objectOutput.writeByte(oVar.f9267b);
                return;
            case 14:
                r rVar = (r) obj;
                objectOutput.writeInt(rVar.f9273a);
                objectOutput.writeInt(rVar.f9274b);
                objectOutput.writeInt(rVar.f9275c);
                return;
            default:
                throw new InvalidClassException("Unknown serialized type");
        }
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput objectInput) {
        byte b10 = objectInput.readByte();
        this.f9276a = b10;
        this.f9277b = a(b10, objectInput);
    }

    public static Object a(byte b10, ObjectInput objectInput) throws IOException {
        switch (b10) {
            case 1:
                Duration duration = Duration.f9127c;
                long j10 = objectInput.readLong();
                long j11 = objectInput.readInt();
                return Duration.e(j$.com.android.tools.r8.a.x(j10, j$.com.android.tools.r8.a.B(j11, C.NANOS_PER_SECOND)), (int) j$.com.android.tools.r8.a.A(j11, C.NANOS_PER_SECOND));
            case 2:
                Instant instant = Instant.f9130c;
                return Instant.w(objectInput.readLong(), objectInput.readInt());
            case 3:
                h hVar = h.f9250d;
                return h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte());
            case 4:
                return k.F(objectInput);
            case 5:
                LocalDateTime localDateTime = LocalDateTime.f9133c;
                h hVar2 = h.f9250d;
                return LocalDateTime.y(h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.F(objectInput));
            case 6:
                LocalDateTime localDateTime2 = LocalDateTime.f9133c;
                h hVar3 = h.f9250d;
                LocalDateTime localDateTimeY = LocalDateTime.y(h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.F(objectInput));
                ZoneOffset zoneOffsetE = ZoneOffset.E(objectInput);
                ZoneId zoneId = (ZoneId) a(objectInput.readByte(), objectInput);
                Objects.requireNonNull(localDateTimeY, "localDateTime");
                Objects.requireNonNull(zoneOffsetE, TypedValues.CycleType.S_WAVE_OFFSET);
                Objects.requireNonNull(zoneId, "zone");
                if (!(zoneId instanceof ZoneOffset) || zoneOffsetE.equals(zoneId)) {
                    return new ZonedDateTime(localDateTimeY, zoneId, zoneOffsetE);
                }
                g.c("ZoneId must match ZoneOffset");
                return null;
            case 7:
                int i10 = x.f9315d;
                return ZoneId.w(objectInput.readUTF(), false);
            case 8:
                return ZoneOffset.E(objectInput);
            case 9:
                int i11 = q.f9269c;
                return new q(k.F(objectInput), ZoneOffset.E(objectInput));
            case 10:
                int i12 = OffsetDateTime.f9137c;
                h hVar4 = h.f9250d;
                return new OffsetDateTime(LocalDateTime.y(h.D(objectInput.readInt(), objectInput.readByte(), objectInput.readByte()), k.F(objectInput)), ZoneOffset.E(objectInput));
            case 11:
                int i13 = u.f9308b;
                return u.v(objectInput.readInt());
            case 12:
                int i14 = w.f9312c;
                int i15 = objectInput.readInt();
                byte b11 = objectInput.readByte();
                j$.time.temporal.a.YEAR.k(i15);
                j$.time.temporal.a.MONTH_OF_YEAR.k(b11);
                return new w(i15, b11);
            case 13:
                int i16 = o.f9265c;
                byte b12 = objectInput.readByte();
                byte b13 = objectInput.readByte();
                m mVarY = m.y(b12);
                Objects.requireNonNull(mVarY, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k(b13);
                if (b13 <= mVarY.x()) {
                    return new o(mVarY.getValue(), b13);
                }
                throw new b("Illegal value for DayOfMonth field, value " + ((int) b13) + " is not valid for month " + mVarY.name());
            case 14:
                r rVar = r.f9272d;
                int i17 = objectInput.readInt();
                int i18 = objectInput.readInt();
                int i19 = objectInput.readInt();
                return ((i17 | i18) | i19) == 0 ? r.f9272d : new r(i17, i18, i19);
            default:
                throw new StreamCorruptedException("Unknown serialized type");
        }
    }

    private Object readResolve() {
        return this.f9277b;
    }
}
