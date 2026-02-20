package b9;

import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends i {
    public long h;

    /* renamed from: i, reason: collision with root package name */
    public final String f857i;

    public a(long j10, String str) {
        this.h = j10;
        this.f857i = str;
    }

    @Override // b9.i
    public final long a() {
        return this.h;
    }

    @Override // b9.i
    public final void b(long j10) {
        this.h = j10;
    }

    @Override // b9.i
    public final String d() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, this.f857i);
        jSONObject.putOpt("clientTimestamp", Long.valueOf(this.h));
        String string = jSONObject.toString();
        string.getClass();
        return string;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.h == aVar.h && this.f857i.equals(aVar.f857i);
    }

    public final int hashCode() {
        long j10 = this.h;
        return this.f857i.hashCode() + (((int) (j10 ^ (j10 >>> 32))) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserEvent(clientTimestamp=");
        sb.append(this.h);
        sb.append(", event=");
        return a3.a.m(sb, this.f857i, ')');
    }
}
