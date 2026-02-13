package h5;

import android.database.Cursor;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j0 {

    /* renamed from: c, reason: collision with root package name */
    public String f8626c;

    /* renamed from: a, reason: collision with root package name */
    public int f8624a = -1;

    /* renamed from: b, reason: collision with root package name */
    public long f8625b = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f8627d = -1;

    public final void a(Cursor cursor) {
        this.f8624a = cursor.getInt(0);
        this.f8625b = cursor.getLong(1);
        this.f8626c = cursor.getString(2);
        this.f8627d = cursor.getInt(3);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{id=");
        sb.append(this.f8624a);
        sb.append(", appId=");
        sb.append(this.f8625b);
        sb.append(", deviceName=");
        sb.append(this.f8626c);
        sb.append(", downloadId=");
        return a3.a.k(sb, this.f8627d, '}');
    }
}
