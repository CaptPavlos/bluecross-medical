package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import androidx.documentfile.provider.DocumentFile;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.uptodown.R;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j4 {

    /* renamed from: d, reason: collision with root package name */
    public static j4 f2006d;
    public static r7.m e;
    public static r7.m f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f2007a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2008b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2009c;

    public j4(int i10) {
        switch (i10) {
            case 2:
                this.f2008b = new Object();
                break;
            default:
                this.f2007a = false;
                this.f2008b = null;
                this.f2009c = null;
                break;
        }
    }

    public static final void a(j4 j4Var, PackageInstaller packageInstaller) {
        Iterator<PackageInstaller.SessionInfo> it = packageInstaller.getMySessions().iterator();
        while (it.hasNext()) {
            try {
                packageInstaller.abandonSession(it.next().getSessionId());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public static final Object b(j4 j4Var, File file, File file2, x4.g gVar) {
        y7.e eVar = r7.i0.f12407a;
        return r7.y.z(new a6.q(file2, file, j4Var, (w6.c) null), y7.d.f14116a, gVar);
    }

    public static final String c(j4 j4Var, int i10, PackageInstaller.Session session, int i11) {
        Context context = (Context) j4Var.f2008b;
        return i10 == 0 ? context.getString(R.string.error_code_installation_status_failure, MBridgeCommon.DYNAMIC_VIEW_TEMPLATE_VALUE) : session == null ? context.getString(R.string.error_code_installation_status_failure, "103") : i11 == 0 ? context.getString(R.string.installation_status_failure_storage) : i11 == 1 ? context.getString(R.string.error_code_installation_status_failure, "105") : i11 == 2 ? context.getString(R.string.error_code_installation_status_failure, "106") : i11 == 3 ? context.getString(R.string.error_code_installation_status_failure, "107") : i11 == 4 ? context.getString(R.string.error_code_installation_status_failure, "108") : context.getString(R.string.error_code_installation_status_failure, "101");
    }

    public static final InputStream d(j4 j4Var, Object obj) throws Exception {
        if (obj instanceof File) {
            return new FileInputStream((File) obj);
        }
        if (!(obj instanceof DocumentFile)) {
            throw new Exception("getInputStream: Illegal parameter type");
        }
        ContentResolver contentResolver = ((Context) j4Var.f2008b).getContentResolver();
        if (contentResolver != null) {
            return contentResolver.openInputStream(((DocumentFile) obj).getUri());
        }
        return null;
    }

    public static final OutputStream e(j4 j4Var, PackageInstaller.Session session, Object obj) throws Exception {
        String name;
        long length;
        if (obj instanceof File) {
            File file = (File) obj;
            name = file.getName();
            length = file.length();
        } else {
            if (!(obj instanceof DocumentFile)) {
                throw new Exception("getOutputStream: Illegal parameter type");
            }
            DocumentFile documentFile = (DocumentFile) obj;
            if (documentFile.getName() == null) {
                throw new Exception("getOutputStream: DocumentFile name is null");
            }
            name = documentFile.getName();
            name.getClass();
            length = documentFile.length();
        }
        OutputStream outputStreamOpenWrite = session.openWrite(name, 0L, length);
        outputStreamOpenWrite.getClass();
        return outputStreamOpenWrite;
    }

    public static final int f(j4 j4Var, String str, Long l10, ArrayList arrayList) {
        PackageInfo packageInfoF;
        if (str == null) {
            return 1;
        }
        try {
            PackageManager packageManager = ((Context) j4Var.f2008b).getPackageManager();
            packageManager.getClass();
            packageInfoF = l5.a.f(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfoF = null;
        }
        if (packageInfoF != null) {
            return (l10 != null && x4.d.d(packageInfoF) == l10.longValue() && arrayList.size() > 1) ? 2 : 1;
        }
        return 1;
    }

    public static final void g(j4 j4Var, Context context, String str, h5.p0 p0Var) {
        j4Var.f2007a = true;
        h5.c1.c(context);
        j4Var.f2008b = null;
        if (str != null) {
            j4Var.f2009c = str;
        }
        Bundle bundleC = r1.i.c(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "fail", "loginSource", "google");
        if (p0Var != null) {
            bundleC.putString("responseCode", String.valueOf(p0Var.f8697b));
            String str2 = p0Var.f8698c;
            if (str2 != null) {
                bundleC.putString("exception", str2);
            }
        }
        new t1.c(context, 4).e(bundleC, "login");
    }

    public static boolean m(int i10) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 31) {
            return false;
        }
        if (i11 == 31 && i10 >= 29) {
            return true;
        }
        if (i11 == 32 && i10 >= 29) {
            return true;
        }
        if (i11 != 33 || i10 < 30) {
            return i11 >= 34 && i10 >= 31;
        }
        return true;
    }

    public static j4 n(Context context) {
        j4 j4Var;
        j4 j4Var2;
        synchronized (j4.class) {
            try {
                if (f2006d == null) {
                    if (PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                        j4Var2 = new j4();
                        j4Var2.f2007a = false;
                        j4Var2.f2008b = context;
                        j4Var2.f2009c = new i4(null);
                    } else {
                        j4Var2 = new j4(0);
                    }
                    f2006d = j4Var2;
                }
                j4 j4Var3 = f2006d;
                if (j4Var3 != null && ((i4) j4Var3.f2009c) != null && !j4Var3.f2007a) {
                    try {
                        context.getContentResolver().registerContentObserver(z3.f2277a, true, (i4) f2006d.f2009c);
                        j4 j4Var4 = f2006d;
                        j4Var4.getClass();
                        j4Var4.f2007a = true;
                    } catch (SecurityException e3) {
                        Log.e("GservicesLoader", "Unable to register Gservices content observer", e3);
                    }
                }
                j4Var = f2006d;
                j4Var.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return j4Var;
    }

    public static synchronized void r() {
        Context context;
        try {
            j4 j4Var = f2006d;
            if (j4Var != null && (context = (Context) j4Var.f2008b) != null && ((i4) j4Var.f2009c) != null && j4Var.f2007a) {
                context.getContentResolver().unregisterContentObserver((i4) f2006d.f2009c);
            }
            f2006d = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void i(g0.b bVar, h1.i iVar) {
        d0.i iVar2 = (d0.i) ((y2.c) this.f2009c).f13781b;
        iVar2.getClass();
        k0.a aVar = (k0.a) ((k0.c) bVar).t();
        i0.n nVar = (i0.n) iVar2.f6781b;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar.f2253k);
        int i10 = v0.a.f13116a;
        if (nVar == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            nVar.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar.f2252b.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            iVar.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public Context j() {
        return (Context) this.f2008b;
    }

    public void k(ArrayList arrayList, boolean z9) {
        this.f2007a = z9;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        y7.e eVar = r7.i0.f12407a;
        r7.y.q(r7.y.a(y7.d.f14116a), null, null, new p4.i0(this, arrayList2, (w6.c) null, 16), 3);
    }

    public Object l(String str, Context context, y6.i iVar) throws Throwable {
        this.f2008b = new h5.e1();
        kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
        y7.e eVar = r7.i0.f12407a;
        Object objZ = r7.y.z(new c5.c(context, xVar, str, this, (w6.c) null), y7.d.f14116a, iVar);
        return objZ == x6.a.f13718a ? objZ : s6.w.f12711a;
    }

    public void o(h1.n nVar) {
        synchronized (this.f2008b) {
            try {
                if (((ArrayDeque) this.f2009c) == null) {
                    this.f2009c = new ArrayDeque();
                }
                ((ArrayDeque) this.f2009c).add(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String p(String str) {
        Object objA;
        Context context = (Context) this.f2008b;
        if (context != null && (!d4.a() || d4.b(context))) {
            try {
                try {
                    t tVar = new t(this, str);
                    try {
                        objA = tVar.a();
                    } catch (SecurityException unused) {
                        long jClearCallingIdentity = Binder.clearCallingIdentity();
                        try {
                            objA = tVar.a();
                        } finally {
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    }
                    return (String) objA;
                } catch (SecurityException e3) {
                    e = e3;
                    Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                    return null;
                }
            } catch (IllegalStateException e7) {
                e = e7;
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                return null;
            } catch (NullPointerException e10) {
                e = e10;
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(str), e);
                return null;
            }
        }
        return null;
    }

    public void q(h1.p pVar) {
        h1.n nVar;
        synchronized (this.f2008b) {
            if (((ArrayDeque) this.f2009c) != null && !this.f2007a) {
                this.f2007a = true;
                while (true) {
                    synchronized (this.f2008b) {
                        try {
                            nVar = (h1.n) ((ArrayDeque) this.f2009c).poll();
                            if (nVar == null) {
                                this.f2007a = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    nVar.a(pVar);
                }
            }
        }
    }

    public j4(Context context, t4.b bVar) {
        context.getClass();
        this.f2008b = context;
        this.f2009c = bVar;
    }
}
