package j$.time;

import j$.util.Objects;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: classes2.dex */
public final class x extends ZoneId {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f9315d = 0;
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: b, reason: collision with root package name */
    public final String f9316b;

    /* renamed from: c, reason: collision with root package name */
    public final transient j$.time.zone.f f9317c;

    public static x A(String str, boolean z9) {
        j$.time.zone.f fVarA;
        Objects.requireNonNull(str, "zoneId");
        int length = str.length();
        if (length >= 2) {
            for (int i10 = 0; i10 < length; i10++) {
                char cCharAt = str.charAt(i10);
                if ((cCharAt < 'a' || cCharAt > 'z') && ((cCharAt < 'A' || cCharAt > 'Z') && ((cCharAt != '/' || i10 == 0) && ((cCharAt < '0' || cCharAt > '9' || i10 == 0) && ((cCharAt != '~' || i10 == 0) && ((cCharAt != '.' || i10 == 0) && ((cCharAt != '_' || i10 == 0) && ((cCharAt != '+' || i10 == 0) && (cCharAt != '-' || i10 == 0))))))))) {
                    throw new b("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
                }
            }
            try {
                fVarA = j$.time.zone.i.a(str);
            } catch (j$.time.zone.g e) {
                if (z9) {
                    throw e;
                }
                fVarA = null;
            }
            return new x(str, fVarA);
        }
        throw new b("Invalid ID for region-based ZoneId, invalid format: ".concat(str));
    }

    public x(String str, j$.time.zone.f fVar) {
        this.f9316b = str;
        this.f9317c = fVar;
    }

    @Override // j$.time.ZoneId
    public final String d() {
        return this.f9316b;
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f v() {
        j$.time.zone.f fVar = this.f9317c;
        return fVar != null ? fVar : j$.time.zone.i.a(this.f9316b);
    }

    private Object writeReplace() {
        return new s((byte) 7, this);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void z(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        dataOutput.writeUTF(this.f9316b);
    }
}
