package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.LocalDateTime;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class s extends a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final s f9188c = new s();
    private static final long serialVersionUID = -1440403870442975015L;

    @Override // j$.time.chrono.l
    public final m l(int i10) {
        if (i10 == 0) {
            return t.BCE;
        }
        if (i10 == 1) {
            return t.CE;
        }
        j$.time.g.d("Invalid era: ", i10);
        return null;
    }

    @Override // j$.time.chrono.l
    public final String d() {
        return ExifInterface.TAG_RW2_ISO;
    }

    @Override // j$.time.chrono.l
    public final String i() {
        return "iso8601";
    }

    @Override // j$.time.chrono.l
    public final b o(j$.time.temporal.n nVar) {
        return j$.time.h.x(nVar);
    }

    private s() {
    }

    @Override // j$.time.chrono.a, j$.time.chrono.l
    public final e p(LocalDateTime localDateTime) {
        return LocalDateTime.w(localDateTime);
    }

    public static boolean f(long j10) {
        if ((3 & j10) == 0) {
            return j10 % 100 != 0 || j10 % 400 == 0;
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public Object writeReplace() {
        return new e0((byte) 1, this);
    }
}
