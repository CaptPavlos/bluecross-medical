package j$.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: classes2.dex */
public final class a extends j$.com.android.tools.r8.a implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9147b;
    private static final long serialVersionUID = 6740630888130243051L;

    /* renamed from: a, reason: collision with root package name */
    public final ZoneId f9148a;

    public a(ZoneId zoneId) {
        this.f9148a = zoneId;
    }

    static {
        System.currentTimeMillis();
        f9147b = new a(ZoneOffset.UTC);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f9148a.equals(((a) obj).f9148a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9148a.hashCode() + 1;
    }

    public final String toString() {
        return "SystemClock[" + this.f9148a + "]";
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
    }
}
