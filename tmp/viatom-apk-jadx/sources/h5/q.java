package h5;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import com.uptodown.activities.MyDownloads;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q implements Parcelable {
    public static Parcelable.Creator<q> CREATOR = new g0.l(4);

    /* renamed from: b, reason: collision with root package name */
    public String f8701b;

    /* renamed from: c, reason: collision with root package name */
    public int f8702c;
    public String f;
    public int g;

    /* renamed from: i, reason: collision with root package name */
    public int f8704i;

    /* renamed from: j, reason: collision with root package name */
    public String f8705j;

    /* renamed from: k, reason: collision with root package name */
    public String f8706k;

    /* renamed from: l, reason: collision with root package name */
    public int f8707l;

    /* renamed from: m, reason: collision with root package name */
    public String f8708m;

    /* renamed from: n, reason: collision with root package name */
    public String f8709n;

    /* renamed from: o, reason: collision with root package name */
    public long f8710o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f8711p;

    /* renamed from: r, reason: collision with root package name */
    public int f8713r;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f8715u;

    /* renamed from: a, reason: collision with root package name */
    public int f8700a = -1;

    /* renamed from: d, reason: collision with root package name */
    public int f8703d = 1;
    public long e = -1;
    public long h = -1;

    /* renamed from: q, reason: collision with root package name */
    public long f8712q = -1;

    /* renamed from: s, reason: collision with root package name */
    public long f8714s = -1;
    public long t = -1;

    /* renamed from: v, reason: collision with root package name */
    public ArrayList f8716v = new ArrayList();

    public final void a(h hVar) {
        hVar.getClass();
        this.f8701b = hVar.f8595w;
        this.h = hVar.f8566a;
        this.f8709n = hVar.f8567b;
        if (this.f8705j == null) {
            this.f8705j = hVar.D;
        }
        if (hVar.D0.isEmpty()) {
            r rVar = new r();
            if (rVar.g == null) {
                rVar.g = hVar.G;
            }
            rVar.f8722c = hVar.A;
            String str = hVar.g;
            if (str != null && str.length() != 0) {
                try {
                    String str2 = hVar.g;
                    str2.getClass();
                    rVar.e = Long.parseLong(str2);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f8716v = arrayList;
            arrayList.add(rVar);
        } else {
            this.f8716v = hVar.D0;
        }
        this.f8708m = hVar.h();
        this.f8711p = hVar.J;
        if (!a.a.f3d) {
            this.f8704i = 1;
        }
        if (this.e <= 0) {
            long j10 = hVar.B;
            if (j10 > 0) {
                this.e = j10;
            } else {
                long j11 = hVar.f8569d;
                if (j11 > 0) {
                    this.e = j11;
                }
            }
        }
        this.f = hVar.f8568c;
        this.f8706k = null;
        ArrayList arrayList2 = hVar.K;
        if (arrayList2 != null && arrayList2.size() > 0) {
            ArrayList arrayList3 = hVar.K;
            arrayList3.getClass();
            int size = arrayList3.size();
            for (int i10 = 0; i10 < size; i10++) {
                String str3 = this.f8706k;
                ArrayList arrayList4 = hVar.K;
                if (str3 == null) {
                    arrayList4.getClass();
                    this.f8706k = (String) arrayList4.get(i10);
                } else {
                    arrayList4.getClass();
                    this.f8706k = String.format("%s,%s", Arrays.copyOf(new Object[]{str3, arrayList4.get(i10)}, 2));
                }
            }
        }
        String str4 = hVar.f8600z;
        if (str4 != null) {
            try {
                this.f8707l = Integer.parseInt(str4);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void b(h hVar, c0 c0Var) {
        hVar.getClass();
        c0Var.getClass();
        this.f8701b = hVar.f8595w;
        this.h = hVar.f8566a;
        this.f8709n = hVar.f8567b;
        this.f8708m = hVar.f8575l;
        this.f8705j = hVar.D;
        this.e = c0Var.f8488d;
        this.f = c0Var.f8485a;
        if (!o7.u.Z(c0Var.f, "apk", true)) {
            this.f8716v = c0Var.f8489i;
            return;
        }
        this.f8716v = new ArrayList();
        r rVar = new r();
        String str = c0Var.g;
        str.getClass();
        rVar.f8722c = Long.parseLong(str);
        rVar.e = c0Var.f8486b;
        this.f8716v.add(rVar);
    }

    public final boolean c() {
        return this.f8703d == 0;
    }

    public final void d() {
        if (this.f8716v.isEmpty()) {
            return;
        }
        Iterator it = this.f8716v.iterator();
        it.getClass();
        r rVar = null;
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            rVar = (r) next;
            String str = rVar.h;
            if (str != null) {
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if ((rVar != null ? rVar.h : null) != null) {
            String str2 = rVar.h;
            str2.getClass();
            File parentFile = new File(str2).getParentFile();
            if (parentFile != null && parentFile.exists() && parentFile.isDirectory()) {
                String[] list = parentFile.list();
                if (list == null || list.length == 0) {
                    parentFile.delete();
                }
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f8704i;
    }

    public final File f(MyDownloads myDownloads) {
        String str = !this.f8716v.isEmpty() ? ((r) this.f8716v.get(0)).h : null;
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public final File g() {
        if (this.f8716v.size() == 1 && ((r) this.f8716v.get(0)).h != null) {
            String str = ((r) this.f8716v.get(0)).h;
            str.getClass();
            return new File(str);
        }
        if (this.f8716v.size() <= 1 || ((r) this.f8716v.get(0)).h == null) {
            return null;
        }
        String str2 = ((r) this.f8716v.get(0)).h;
        str2.getClass();
        return new File(str2).getParentFile();
    }

    public final void h(MyDownloads myDownloads, File file) {
        if (this.f8701b != null) {
            long j10 = this.e;
            if (j10 > 0) {
                this.f8714s = j10;
                p(myDownloads);
                return;
            }
            String name = file.getName();
            name.getClass();
            if (o7.u.X(name, ".apk", false)) {
                try {
                    PackageManager packageManager = myDownloads.getPackageManager();
                    packageManager.getClass();
                    String absolutePath = file.getAbsolutePath();
                    absolutePath.getClass();
                    PackageInfo packageInfoD = l5.a.d(packageManager, absolutePath, 128);
                    if (packageInfoD != null) {
                        this.f8714s = x4.d.d(packageInfoD);
                    }
                    if (packageInfoD == null || !o7.u.Z(this.f8701b, packageInfoD.packageName, false)) {
                        return;
                    }
                    p(myDownloads);
                } catch (Exception unused) {
                }
            }
        }
    }

    public final int i() {
        long j10;
        long j11;
        if (this.f8716v.isEmpty()) {
            j10 = 0;
            j11 = 0;
        } else {
            Iterator it = this.f8716v.iterator();
            it.getClass();
            j10 = 0;
            j11 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                r rVar = (r) next;
                j10 += rVar.e;
                j11 += rVar.f;
            }
        }
        if (j11 <= 0 || j10 <= 0) {
            return 0;
        }
        return (int) ((j11 * 100.0d) / j10);
    }

    public final long j() {
        long j10 = 0;
        if (!this.f8716v.isEmpty()) {
            Iterator it = this.f8716v.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                j10 += ((r) next).f;
            }
        }
        return j10;
    }

    public final long k() {
        long j10 = 0;
        if (!this.f8716v.isEmpty()) {
            Iterator it = this.f8716v.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                j10 += ((r) next).e;
            }
        }
        return j10;
    }

    public final void l(Context context) {
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        this.g++;
        this.f8710o = System.currentTimeMillis() + 1800000;
        gVarL.j(this);
        if (this.g >= 4) {
            s(context);
        } else {
            gVarL.P(this);
        }
        gVarL.b();
    }

    public final boolean m() {
        return this.f8701b != null && o() && !c() && this.f8705j != null && this.e > 0 && this.g < 4 && System.currentTimeMillis() > this.f8710o;
    }

    public final boolean n() {
        String str;
        Activity activity = o4.b.g;
        u4.a aVarA = r0.f.A();
        return this.e > 0 && (str = this.f8701b) != null && aVarA != null && o7.u.Z(aVarA.f12891a, str, true) && aVarA.f12892b == this.e;
    }

    public final boolean o() {
        return this.f8712q == -1;
    }

    public final void p(MyDownloads myDownloads) {
        PackageInfo packageInfoF;
        try {
            PackageManager packageManager = myDownloads.getPackageManager();
            if (packageManager != null) {
                String str = this.f8701b;
                str.getClass();
                packageInfoF = l5.a.f(packageManager, str, 0);
            } else {
                packageInfoF = null;
            }
            if (packageInfoF != null) {
                this.t = x4.d.d(packageInfoF);
            }
        } catch (Exception unused) {
        }
    }

    public final int q(Context context) {
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        String str = this.f8701b;
        str.getClass();
        q qVarB = gVarL.B(this.e, str);
        if (qVarB == null) {
            gVarL.P(this);
            qVarB = this;
        }
        gVarL.b();
        return qVarB.f8700a;
    }

    public final void r(Context context) {
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        gVarL.j(this);
        gVarL.b();
    }

    public final void s(Context context) {
        r rVar;
        context.getClass();
        v5.g gVarL = v5.g.f13148u.l(context);
        gVarL.a();
        this.f8703d = 1;
        gVarL.d0(this);
        if (this.f8716v.isEmpty()) {
            rVar = null;
        } else {
            Iterator it = this.f8716v.iterator();
            it.getClass();
            rVar = null;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                rVar = (r) next;
                String str = rVar.h;
                if (str != null) {
                    try {
                        File file = new File(str);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.f8712q > 0) {
                    rVar.h = null;
                    rVar.f = 0L;
                    rVar.f8724i = 0;
                    rVar.f8725j = 0L;
                    gVarL.e0(rVar);
                }
            }
        }
        gVarL.b();
        if ((rVar != null ? rVar.h : null) != null) {
            String str2 = rVar.h;
            str2.getClass();
            File parentFile = new File(str2).getParentFile();
            if (parentFile != null && parentFile.exists() && parentFile.isDirectory()) {
                String[] list = parentFile.list();
                if (list == null || list.length == 0) {
                    parentFile.delete();
                }
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{id='");
        sb.append(this.f8700a);
        sb.append("', packagename='");
        sb.append(this.f8701b);
        sb.append("', checkedByUser=");
        sb.append(this.f8702c);
        sb.append(", incomplete=");
        sb.append(this.f8703d);
        sb.append(", versioncode='");
        sb.append(this.e);
        sb.append("', versionname='");
        sb.append(this.f);
        sb.append("', attempts=");
        sb.append(this.g);
        sb.append(", appId=");
        sb.append(this.h);
        sb.append(", downloadAnyway=");
        sb.append(this.f8704i);
        sb.append(", md5signature='");
        sb.append(this.f8705j);
        sb.append("', supportedAbis='");
        sb.append(this.f8706k);
        sb.append("', minsdk=");
        sb.append(this.f8707l);
        sb.append(", urlIcon='");
        sb.append(this.f8708m);
        sb.append("', appName='");
        sb.append(this.f8709n);
        sb.append("', versioncodeFile=");
        sb.append(this.f8714s);
        sb.append(", versioncodeInstalled=");
        sb.append(this.t);
        sb.append(", nextAttemptTimeStamp=");
        sb.append(this.f8710o);
        sb.append(", updateId=");
        sb.append(this.f8712q);
        sb.append(", isDeepLink=");
        sb.append(this.f8713r);
        sb.append(", files=");
        return a3.a.p(sb, this.f8716v, '}');
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.getClass();
        parcel.writeInt(this.f8700a);
        parcel.writeString(this.f8701b);
        parcel.writeInt(this.f8702c);
        parcel.writeInt(this.f8703d);
        parcel.writeLong(this.e);
        parcel.writeString(this.f);
        parcel.writeInt(this.g);
        parcel.writeLong(this.h);
        parcel.writeInt(this.f8704i);
        parcel.writeString(this.f8705j);
        parcel.writeString(this.f8706k);
        parcel.writeInt(this.f8707l);
        parcel.writeString(this.f8708m);
        parcel.writeString(this.f8709n);
        parcel.writeLong(this.f8710o);
        parcel.writeStringList(this.f8711p);
        parcel.writeTypedList(this.f8716v);
        parcel.writeLong(this.f8712q);
        parcel.writeInt(this.f8713r);
    }
}
