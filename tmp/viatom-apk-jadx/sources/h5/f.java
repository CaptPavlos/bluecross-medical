package h5;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.os.Parcelable;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class f implements Parcelable {
    public static Parcelable.Creator<f> CREATOR = new g0.l(1);
    public ArrayList A;
    public boolean B;

    /* renamed from: b, reason: collision with root package name */
    public String f8525b;

    /* renamed from: c, reason: collision with root package name */
    public String f8526c;
    public String e;
    public String f;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8528i;

    /* renamed from: j, reason: collision with root package name */
    public int f8529j;

    /* renamed from: k, reason: collision with root package name */
    public int f8530k;

    /* renamed from: l, reason: collision with root package name */
    public String f8531l;

    /* renamed from: m, reason: collision with root package name */
    public int f8532m;

    /* renamed from: n, reason: collision with root package name */
    public long f8533n;

    /* renamed from: o, reason: collision with root package name */
    public long f8534o;

    /* renamed from: p, reason: collision with root package name */
    public int f8535p;

    /* renamed from: q, reason: collision with root package name */
    public String f8536q;

    /* renamed from: r, reason: collision with root package name */
    public long f8537r;

    /* renamed from: s, reason: collision with root package name */
    public String f8538s;
    public int t;

    /* renamed from: u, reason: collision with root package name */
    public f0 f8539u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f8540v;

    /* renamed from: w, reason: collision with root package name */
    public long f8541w;

    /* renamed from: x, reason: collision with root package name */
    public int f8542x;

    /* renamed from: z, reason: collision with root package name */
    public ArrayList f8543z;

    /* renamed from: a, reason: collision with root package name */
    public long f8524a = -1;

    /* renamed from: d, reason: collision with root package name */
    public long f8527d = -1;
    public e g = e.f8507b;
    public int y = -1;

    public static void a(String str, ArrayList arrayList, v5.g gVar, f fVar, ArrayList arrayList2) {
        arrayList2.getClass();
        w wVar = new w();
        wVar.f8782b = new File(str).length();
        wVar.f8783c = str;
        Iterator it = arrayList.iterator();
        int i10 = -1;
        int i11 = 0;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            w wVar2 = (w) it.next();
            if (o7.u.Z(wVar2.f8783c, wVar.f8783c, false) && wVar2.f8782b == wVar.f8782b) {
                String str2 = wVar2.f8781a;
                if (str2 != null) {
                    wVar.f8781a = str2;
                }
                i10 = i11;
            }
            i11 = i12;
        }
        if (i10 != -1) {
            arrayList.remove(i10);
            arrayList2.add(wVar);
            return;
        }
        long j10 = fVar.f8524a;
        ContentValues contentValues = new ContentValues();
        contentValues.put(MBridgeConstans.APP_ID, String.valueOf(j10));
        contentValues.put("sha256", wVar.f8781a);
        contentValues.put("size", String.valueOf(wVar.f8782b));
        contentValues.put(MBridgeConstans.DYNAMIC_VIEW_WX_PATH, wVar.f8783c);
        SQLiteDatabase sQLiteDatabase = gVar.f13150a;
        sQLiteDatabase.getClass();
        if (sQLiteDatabase.insert("app_files", null, contentValues) >= 0) {
            arrayList2.add(wVar);
        }
    }

    public final boolean b(Context context) {
        context.getClass();
        if (this.f8526c == null) {
            return false;
        }
        if (d()) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("show_system_services")) {
                    return sharedPreferences.getBoolean("show_system_services", false);
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        if (!c()) {
            return true;
        }
        try {
            SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences2.contains("show_system_apps")) {
                return sharedPreferences2.getBoolean("show_system_apps", false);
            }
            return false;
        } catch (Exception unused2) {
            return false;
        }
    }

    public final boolean c() {
        return this.h == 1;
    }

    public final boolean d() {
        return this.f8528i == 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final void e(v5.g gVar) {
        this.A = new ArrayList();
        String str = this.f8526c;
        str.getClass();
        ArrayList arrayListY = t1.y(str);
        if (arrayListY.isEmpty()) {
            return;
        }
        String str2 = this.f8526c;
        str2.getClass();
        f fVarR = gVar.r(str2);
        if (fVarR != null) {
            ArrayList arrayListS = gVar.s(fVarR.f8524a);
            Iterator it = arrayListY.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                File file = (File) next;
                if (file.isFile()) {
                    String name = file.getName();
                    name.getClass();
                    if (o7.u.X(name, ".obb", false)) {
                        String absolutePath = file.getAbsolutePath();
                        absolutePath.getClass();
                        ArrayList arrayList = this.A;
                        arrayList.getClass();
                        a(absolutePath, arrayListS, gVar, fVarR, arrayList);
                    }
                }
            }
        }
    }

    public final void f(ApplicationInfo applicationInfo, v5.g gVar) {
        applicationInfo.getClass();
        this.f8543z = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            String str = this.f8526c;
            str.getClass();
            f fVarR = gVar.r(str);
            if (fVarR != null) {
                ArrayList arrayListS = gVar.s(fVarR.f8524a);
                int i10 = 0;
                while (i10 < strArr.length) {
                    int i11 = i10 + 1;
                    try {
                        String str2 = strArr[i10];
                        str2.getClass();
                        if (o7.u.X(str2, ".apk", false)) {
                            ArrayList arrayList = this.f8543z;
                            arrayList.getClass();
                            a(str2, arrayListS, gVar, fVarR, arrayList);
                        }
                        i10 = i11;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        com.google.gson.internal.a.o(e.getMessage());
                        return;
                    }
                }
                if (arrayListS.isEmpty()) {
                    return;
                }
                Iterator it = arrayListS.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    gVar.h((w) next);
                }
            }
        }
    }

    public final void g(boolean z9, boolean z10) {
        if (c()) {
            if (z9) {
                this.f8535p = 0;
            } else {
                this.f8535p = 1;
            }
        }
        if (d()) {
            if (z10) {
                this.f8535p = 0;
            } else {
                this.f8535p = 1;
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{id='");
        sb.append(this.f8524a);
        sb.append("', name='");
        sb.append(this.f8525b);
        sb.append("', packagename='");
        sb.append(this.f8526c);
        sb.append("', versionCode=");
        sb.append(this.f8527d);
        sb.append(", versionName='");
        sb.append(this.e);
        sb.append("', urlFicha='");
        sb.append(this.f);
        sb.append("', status=");
        sb.append(this.g);
        sb.append(", isSystemApp=");
        sb.append(this.h);
        sb.append(", isSystemService=");
        sb.append(this.f8528i);
        sb.append(", minSdkVersion=");
        sb.append(this.f8529j);
        sb.append(", targetSdkVersion=");
        sb.append(this.f8530k);
        sb.append(", md5signature='");
        sb.append(this.f8531l);
        sb.append("', exclude=");
        sb.append(this.f8532m);
        sb.append(", size=");
        sb.append(this.f8533n);
        sb.append(", lastUpdateTime=");
        sb.append(this.f8534o);
        sb.append(", excludeFromTracking=");
        sb.append(this.f8535p);
        sb.append(", defaultName='");
        sb.append(this.f8536q);
        sb.append("', firstInstallTime=");
        sb.append(this.f8537r);
        sb.append(", sha256='");
        sb.append(this.f8538s);
        sb.append("', appID=");
        sb.append(this.f8541w);
        sb.append(", hasOldVersions=");
        sb.append(this.f8542x);
        sb.append(", trackInfoRegistered=");
        return a3.a.k(sb, this.y, '}');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeLong(this.f8524a);
        parcel.writeString(this.f8525b);
        parcel.writeString(this.f8526c);
        parcel.writeLong(this.f8527d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        int iOrdinal = this.g.ordinal();
        if (iOrdinal == 0) {
            parcel.writeInt(0);
        } else if (iOrdinal != 1) {
            parcel.writeInt(2);
        } else {
            parcel.writeInt(1);
        }
        parcel.writeInt(this.h);
        parcel.writeInt(this.f8528i);
        parcel.writeInt(this.f8529j);
        parcel.writeInt(this.f8530k);
        parcel.writeString(this.f8531l);
        parcel.writeInt(this.f8532m);
        parcel.writeLong(this.f8533n);
        parcel.writeLong(this.f8534o);
        parcel.writeInt(this.f8535p);
        parcel.writeString(this.f8536q);
        parcel.writeLong(this.f8537r);
        parcel.writeString(this.f8538s);
        parcel.writeInt(this.t);
        parcel.writeLong(this.f8541w);
        parcel.writeInt(this.f8542x);
        parcel.writeInt(this.B ? 1 : 0);
    }
}
