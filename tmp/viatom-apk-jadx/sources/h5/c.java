package h5;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8480a;

    /* renamed from: b, reason: collision with root package name */
    public String f8481b;

    /* renamed from: c, reason: collision with root package name */
    public String f8482c;

    /* renamed from: d, reason: collision with root package name */
    public String f8483d;
    public String e;
    public int f;
    public String g;
    public Serializable h;

    /* renamed from: i, reason: collision with root package name */
    public Serializable f8484i;

    public c(int i10) {
        this.f8480a = i10;
        switch (i10) {
            case 1:
                this.f8482c = "";
                this.f8483d = "";
                this.f = -1;
                ArrayList arrayList = new ArrayList();
                this.h = arrayList;
                arrayList.add("");
                break;
            default:
                this.f = -1;
                break;
        }
    }

    public static void c(f fVar, y0 y0Var, v5.g gVar) {
        c cVar = new c(0);
        cVar.f8481b = fVar.f8526c;
        cVar.f = 1;
        cVar.e = String.valueOf(fVar.f8527d);
        cVar.g = String.valueOf(y0Var.f8796c);
        cVar.f8482c = fVar.e;
        cVar.f8483d = y0Var.f8797d;
        q qVar = y0Var.f8798i;
        cVar.h = String.valueOf(qVar != null ? qVar.k() : 0L);
        cVar.f8484i = String.valueOf(System.currentTimeMillis() / 1000);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, Integer.valueOf(cVar.f));
        contentValues.put("packagename", cVar.f8481b);
        contentValues.put("versioncode_old", cVar.e);
        contentValues.put("versioncode_new", cVar.g);
        contentValues.put("versionname_old", cVar.f8482c);
        contentValues.put("versionname_new", cVar.f8483d);
        contentValues.put("size", (String) cVar.h);
        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, (String) cVar.f8484i);
        SQLiteDatabase sQLiteDatabase = gVar.f13150a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.insert("activity_log", null, contentValues);
    }

    public p8.s a() {
        if (this.f8481b == null) {
            androidx.window.layout.c.g("scheme == null");
            return null;
        }
        if (this.e != null) {
            return new p8.s(this);
        }
        androidx.window.layout.c.g("host == null");
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(p8.s r26, java.lang.String r27) throws java.lang.NumberFormatException, java.io.EOFException {
        /*
            Method dump skipped, instructions count: 817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.c.b(p8.s, java.lang.String):int");
    }

    public final String toString() {
        switch (this.f8480a) {
            case 0:
                StringBuilder sb = new StringBuilder("{id=-1, type=");
                sb.append(this.f);
                sb.append(", typeReadable=");
                int i10 = this.f;
                sb.append(i10 != 1 ? i10 != 3 ? i10 != 4 ? "Unknown" : "INSTALLED_UPDATE" : "DOWNLOADED_UPDATE" : "NEW_UPDATE");
                sb.append(", packageName=");
                sb.append(this.f8481b);
                sb.append(", versionNameOld=");
                sb.append(this.f8482c);
                sb.append(", versionNameNew=");
                sb.append(this.f8483d);
                sb.append(", versionCodeOld=");
                sb.append(this.e);
                sb.append(", versionCodeNew=");
                sb.append(this.g);
                sb.append(", size=");
                sb.append((String) this.h);
                sb.append(", timestamp=");
                return a3.a.m(sb, (String) this.f8484i, '}');
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.f8481b);
                sb2.append("://");
                if (!this.f8482c.isEmpty() || !this.f8483d.isEmpty()) {
                    sb2.append(this.f8482c);
                    if (!this.f8483d.isEmpty()) {
                        sb2.append(':');
                        sb2.append(this.f8483d);
                    }
                    sb2.append('@');
                }
                if (this.e.indexOf(58) != -1) {
                    sb2.append('[');
                    sb2.append(this.e);
                    sb2.append(']');
                } else {
                    sb2.append(this.e);
                }
                int iB = this.f;
                if (iB == -1) {
                    iB = p8.s.b(this.f8481b);
                }
                if (iB != p8.s.b(this.f8481b)) {
                    sb2.append(':');
                    sb2.append(iB);
                }
                ArrayList arrayList = (ArrayList) this.h;
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    sb2.append('/');
                    sb2.append((String) arrayList.get(i11));
                }
                if (((ArrayList) this.f8484i) != null) {
                    sb2.append('?');
                    p8.s.g(sb2, (ArrayList) this.f8484i);
                }
                if (this.g != null) {
                    sb2.append('#');
                    sb2.append(this.g);
                }
                return sb2.toString();
        }
    }
}
