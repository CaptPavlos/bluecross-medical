package j$.time.temporal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a, reason: collision with root package name */
    public final long f9304a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9305b;

    /* renamed from: c, reason: collision with root package name */
    public final long f9306c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9307d;

    public static u e(long j10, long j11) {
        if (j10 > j11) {
            j$.time.g.c("Minimum value must be less than maximum value");
            return null;
        }
        return new u(j10, j10, j11, j11);
    }

    public static u f(long j10, long j11) {
        if (j10 > j11) {
            j$.time.g.c("Smallest maximum value must be less than largest maximum value");
            return null;
        }
        if (1 > j11) {
            j$.time.g.c("Minimum value must be less than maximum value");
            return null;
        }
        return new u(1L, 1L, j10, j11);
    }

    public u(long j10, long j11, long j12, long j13) {
        this.f9304a = j10;
        this.f9305b = j11;
        this.f9306c = j12;
        this.f9307d = j13;
    }

    public final int a(long j10, q qVar) {
        if (this.f9304a < -2147483648L || this.f9307d > 2147483647L || !d(j10)) {
            throw new j$.time.b(c(j10, qVar));
        }
        return (int) j10;
    }

    public final boolean d(long j10) {
        return j10 >= this.f9304a && j10 <= this.f9307d;
    }

    public final void b(long j10, q qVar) {
        if (!d(j10)) {
            throw new j$.time.b(c(j10, qVar));
        }
    }

    public final String c(long j10, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j10;
        }
        return "Invalid value (valid values " + this + "): " + j10;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        long j10 = this.f9304a;
        long j11 = this.f9305b;
        if (j10 > j11) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j12 = this.f9306c;
        long j13 = this.f9307d;
        if (j12 > j13) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j11 > j13) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f9304a == uVar.f9304a && this.f9305b == uVar.f9305b && this.f9306c == uVar.f9306c && this.f9307d == uVar.f9307d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f9304a;
        long j11 = this.f9305b;
        long j12 = j10 + (j11 << 16) + (j11 >> 48);
        long j13 = this.f9306c;
        long j14 = j12 + (j13 << 32) + (j13 >> 32);
        long j15 = this.f9307d;
        long j16 = j14 + (j15 << 48) + (j15 >> 16);
        return (int) (j16 ^ (j16 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f9304a);
        if (this.f9304a != this.f9305b) {
            sb.append('/');
            sb.append(this.f9305b);
        }
        sb.append(" - ");
        sb.append(this.f9306c);
        if (this.f9306c != this.f9307d) {
            sb.append('/');
            sb.append(this.f9307d);
        }
        return sb.toString();
    }
}
