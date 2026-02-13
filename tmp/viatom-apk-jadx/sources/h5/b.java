package h5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f8468a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8469b;

    /* renamed from: c, reason: collision with root package name */
    public int f8470c;

    /* renamed from: d, reason: collision with root package name */
    public int f8471d;
    public a e;

    public b(String str, long j10) {
        str.getClass();
        this.f8468a = str;
        this.f8469b = j10;
        this.f8470c = -1;
        this.f8471d = -1;
        this.e = a.f8457a;
    }

    public final b a(Context context) {
        b bVarP;
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        int i10 = this.f8471d;
        if (i10 != -1) {
            bVarP = gVarL.o(i10);
        } else {
            int i11 = this.f8470c;
            if (i11 != -1) {
                bVarP = gVarL.q(i11);
            } else {
                bVarP = gVarL.p(this.f8469b, this.f8468a);
            }
        }
        gVarL.b();
        return bVarP;
    }

    public final void b(Context context) {
        b bVarQ;
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        int i10 = this.f8471d;
        long j10 = this.f8469b;
        String str = this.f8468a;
        if (i10 != -1) {
            bVarQ = gVarL.o(i10);
        } else {
            int i11 = this.f8470c;
            bVarQ = i11 != -1 ? gVarL.q(i11) : gVarL.p(j10, str);
        }
        if (bVarQ != null) {
            String[] strArr = {String.valueOf(this.f8470c)};
            ContentValues contentValues = new ContentValues();
            contentValues.put("notificationId", Integer.valueOf(this.f8471d));
            contentValues.put("packagename", str);
            contentValues.put("versioncode", Long.valueOf(j10));
            contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.e.ordinal()));
            SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
            sQLiteDatabase.getClass();
            sQLiteDatabase.update("active_notifications", contentValues, "id=?", strArr);
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("notificationId", Integer.valueOf(this.f8471d));
            contentValues2.put("packagename", str);
            contentValues2.put("versioncode", Long.valueOf(j10));
            contentValues2.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(this.e.ordinal()));
            SQLiteDatabase sQLiteDatabase2 = gVarL.f13150a;
            sQLiteDatabase2.getClass();
            sQLiteDatabase2.insert("active_notifications", null, contentValues2);
        }
        gVarL.b();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f8468a, bVar.f8468a) && this.f8469b == bVar.f8469b;
    }

    public final int hashCode() {
        int iHashCode = this.f8468a.hashCode() * 31;
        long j10 = this.f8469b;
        return iHashCode + ((int) (j10 ^ (j10 >>> 32)));
    }

    public final String toString() {
        return "ActiveNotification(packageName=" + this.f8468a + ", versionCode=" + this.f8469b + ')';
    }
}
