package h5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class g0 {

    /* renamed from: a, reason: collision with root package name */
    public long f8558a;

    /* renamed from: b, reason: collision with root package name */
    public String f8559b;

    /* renamed from: c, reason: collision with root package name */
    public String f8560c;

    /* renamed from: d, reason: collision with root package name */
    public String f8561d;
    public int e;

    public final void a(Cursor cursor) {
        this.f8558a = cursor.getLong(0);
        this.e = cursor.getInt(1);
    }

    public final void b(Context context) {
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        String[] strArr = {String.valueOf(this.f8558a)};
        SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("preregistrations", "appId=?", strArr);
        gVarL.b();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PreRegister(appID=");
        sb.append(this.f8558a);
        sb.append(", name=");
        sb.append(this.f8559b);
        sb.append(", icon=");
        sb.append(this.f8560c);
        sb.append(", authorName=");
        sb.append(this.f8561d);
        sb.append(", automaticDownload=");
        return a3.a.k(sb, this.e, ')');
    }
}
