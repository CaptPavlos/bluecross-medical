package h5;

import android.database.Cursor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    public int f8472a = -1;

    /* renamed from: b, reason: collision with root package name */
    public String f8473b;

    /* renamed from: c, reason: collision with root package name */
    public String f8474c;

    /* renamed from: d, reason: collision with root package name */
    public String f8475d;
    public String e;
    public String f;

    public final void a(Cursor cursor) {
        this.f8472a = cursor.getInt(0);
        this.f8473b = cursor.getString(1);
        this.f8474c = cursor.getString(2);
        this.f8475d = cursor.getString(3);
        this.e = cursor.getString(4);
        this.f = cursor.getString(5);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{id=");
        sb.append(this.f8472a);
        sb.append(", timestamp=");
        sb.append(this.f8473b);
        sb.append(", title='");
        sb.append(this.f8474c);
        sb.append("', msg='");
        sb.append(this.f8475d);
        sb.append("', actions='");
        sb.append(this.e);
        sb.append("', extraInfo='");
        return a3.a.o(sb, this.f, "'}");
    }
}
