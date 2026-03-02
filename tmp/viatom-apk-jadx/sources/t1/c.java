package t1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.IPackageInstallObserver;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.internal.measurement.l1;
import com.google.android.gms.internal.measurement.y0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.views.FullHeightImageView;
import h1.h;
import h1.i;
import h5.p0;
import h5.u0;
import i5.f;
import j4.g;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.x;
import l4.n5;
import l4.x4;
import n4.k0;
import p4.a0;
import p4.y;
import w.j;
import w1.p;
import w1.s;
import w2.r;
import x4.l;
import y5.c1;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class c implements r.b, h, g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12750a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f12751b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12752c;

    public c(Context context, int i10) {
        this.f12750a = i10;
        switch (i10) {
            case 4:
                this.f12751b = context;
                if (context != null) {
                    s1.c cVar = (s1.c) l1.g.c().b(s1.c.class);
                    if (cVar == null) {
                        androidx.window.layout.c.k("FirebaseCrashlytics component is not present.");
                        throw null;
                    }
                    boolean zR = t1.r(context, "gdpr_crashlytics_allowed", false);
                    p pVar = cVar.f12517a;
                    Boolean boolValueOf = Boolean.valueOf(zR);
                    s sVar = pVar.f13373b;
                    synchronized (sVar) {
                        sVar.f = false;
                        sVar.g = boolValueOf;
                        SharedPreferences.Editor editorEdit = sVar.f13391a.edit();
                        editorEdit.putBoolean("firebase_crashlytics_collection_enabled", zR);
                        editorEdit.apply();
                        synchronized (sVar.f13393c) {
                            try {
                                boolean zA = sVar.a();
                                boolean z9 = sVar.e;
                                if (zA) {
                                    if (!z9) {
                                        sVar.f13394d.c(null);
                                        sVar.e = true;
                                    }
                                } else if (z9) {
                                    sVar.f13394d = new i();
                                    sVar.e = false;
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                    }
                    FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(context);
                    this.f12752c = firebaseAnalytics;
                    if (t1.r(context, "gdpr_analytics_allowed", false)) {
                        if (firebaseAnalytics != null) {
                            l1 l1Var = firebaseAnalytics.f2419a;
                            Boolean bool = Boolean.TRUE;
                            l1Var.getClass();
                            l1Var.a(new y0(l1Var, bool));
                            return;
                        }
                        return;
                    }
                    if (firebaseAnalytics != null) {
                        l1 l1Var2 = firebaseAnalytics.f2419a;
                        Boolean bool2 = Boolean.FALSE;
                        l1Var2.getClass();
                        l1Var2.a(new y0(l1Var2, bool2));
                        return;
                    }
                    return;
                }
                return;
            default:
                this.f12751b = context;
                this.f12752c = null;
                return;
        }
    }

    public static final void a(c cVar, File file) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        long length;
        Activity activity = (Activity) cVar.f12751b;
        a0 a0Var = (a0) cVar.f12752c;
        try {
            try {
                PackageManager packageManager = activity.getPackageManager();
                packageManager.getClass();
                String absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
                PackageInfo packageInfoD = l5.a.d(packageManager, absolutePath, 128);
                if ((packageInfoD != null ? packageInfoD.applicationInfo : null) == null) {
                    if (a0Var != null) {
                        String name = file.getName();
                        name.getClass();
                        a0Var.f11920a.O(name.concat(" could not be parsed."));
                    }
                    if (o4.b.f11716o != null) {
                        Bundle bundle = new Bundle();
                        bundle.putString("fileName", file.getName());
                        f fVar = o4.b.f11716o;
                        if (fVar != null) {
                            fVar.send(353, bundle);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ApplicationInfo applicationInfo = packageInfoD.applicationInfo;
                applicationInfo.getClass();
                String str = applicationInfo.packageName;
                long jD = x4.d.d(packageInfoD);
                int i10 = 0;
                try {
                    PackageManager packageManager2 = activity.getPackageManager();
                    packageManager2.getClass();
                    str.getClass();
                    if (x4.d.d(l5.a.f(packageManager2, str, 0)) > jD) {
                        if (a0Var != null) {
                            file.getName().getClass();
                            a0Var.f11920a.O("invalid version code");
                        }
                        if (o4.b.f11716o != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("packageName", str);
                            bundle2.putLong("versionCode", jD);
                            f fVar2 = o4.b.f11716o;
                            if (fVar2 != null) {
                                fVar2.send(353, bundle2);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (a0Var != null) {
                    file.getName().getClass();
                    InstallerActivity installerActivity = a0Var.f11920a;
                    installerActivity.runOnUiThread(new y(installerActivity, i10));
                }
                if (o4.b.f11716o != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putString("packageName", str);
                    bundle3.putLong("versionCode", jD);
                    f fVar3 = o4.b.f11716o;
                    if (fVar3 != null) {
                        fVar3.send(351, bundle3);
                    }
                }
                ApplicationInfo applicationInfo2 = packageInfoD.applicationInfo;
                applicationInfo2.getClass();
                String absolutePath2 = file.getAbsolutePath();
                absolutePath2.getClass();
                applicationInfo2.sourceDir = absolutePath2;
                applicationInfo2.publicSourceDir = absolutePath2;
                String string = packageManager.getApplicationLabel(applicationInfo2).toString();
                long jD2 = x4.d.d(packageInfoD);
                String absolutePath3 = file.getAbsolutePath();
                absolutePath3.getClass();
                try {
                    length = new File(absolutePath3).length();
                } catch (Exception unused2) {
                    length = -1;
                }
                long j10 = length;
                String str2 = packageInfoD.packageName;
                str2.getClass();
                r0.f.J(jD2, j10, str2, string);
                packageManager.getClass().getMethod("installPackage", (Class[]) Arrays.copyOf(new Class[]{Uri.class, IPackageInstallObserver.class, Integer.TYPE, String.class}, 4)).invoke(packageManager, Uri.fromFile(file), new l(cVar), 2, null);
            } catch (Error e) {
                o4.b.f11717p = null;
                if (a0Var != null) {
                    file.getName().getClass();
                    String message = e.getMessage();
                    InstallerActivity installerActivity2 = a0Var.f11920a;
                    if (message != null) {
                        installerActivity2.O(message);
                    } else {
                        String string2 = installerActivity2.getString(R.string.error_unknown);
                        string2.getClass();
                        installerActivity2.O(string2);
                    }
                }
                if (o4.b.f11716o != null) {
                    Bundle bundle4 = new Bundle();
                    bundle4.putString("fileName", file.getName());
                    f fVar4 = o4.b.f11716o;
                    if (fVar4 != null) {
                        fVar4.send(353, bundle4);
                    }
                }
            }
        } catch (Exception e3) {
            o4.b.f11717p = null;
            if (a0Var != null) {
                file.getName().getClass();
                String message2 = e3.getMessage();
                InstallerActivity installerActivity3 = a0Var.f11920a;
                if (message2 != null) {
                    installerActivity3.O(message2);
                } else {
                    String string3 = installerActivity3.getString(R.string.error_unknown);
                    string3.getClass();
                    installerActivity3.O(string3);
                }
            }
            if (o4.b.f11716o != null) {
                Bundle bundle5 = new Bundle();
                bundle5.putString("fileName", file.getName());
                f fVar5 = o4.b.f11716o;
                if (fVar5 != null) {
                    fVar5.send(353, bundle5);
                }
            }
        }
    }

    public static final boolean b(c cVar, String str) throws IOException {
        v4.a aVar = (v4.a) cVar.f12752c;
        n5 n5Var = (n5) cVar.f12751b;
        try {
            Socket socket = aVar.f13128d;
            if (socket == null) {
                ((o4.b) n5Var.f10654b).b();
                return false;
            }
            if (socket.isClosed()) {
                ((o4.b) n5Var.f10654b).b();
                return false;
            }
            Socket socket2 = aVar.f13128d;
            socket2.getClass();
            DataOutputStream dataOutputStream = new DataOutputStream(socket2.getOutputStream());
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
            return true;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            ((o4.b) n5Var.f10654b).b();
            return false;
        } catch (IOException e3) {
            e3.printStackTrace();
            ((o4.b) n5Var.f10654b).b();
            return false;
        } catch (Exception e7) {
            e7.printStackTrace();
            ((o4.b) n5Var.f10654b).b();
            return false;
        }
    }

    public static c d(t3.d dVar, t3.g gVar) {
        if (dVar != t3.d.DEFINED_BY_JAVASCRIPT) {
            return new c(2, dVar, gVar);
        }
        com.google.gson.internal.a.n("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        return null;
    }

    public void c() throws IOException {
        String str = (String) this.f12751b;
        try {
            c2.d dVar = (c2.d) this.f12752c;
            dVar.getClass();
            new File((File) dVar.f1643d, str).createNewFile();
        } catch (IOException e) {
            Log.e("FirebaseCrashlytics", "Error creating marker: ".concat(str), e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x025f  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:194:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.os.Bundle r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t1.c.e(android.os.Bundle, java.lang.String):void");
    }

    public void f(String str, Exception exc) {
        Context context = (Context) this.f12751b;
        if (context != null) {
            boolean z9 = false;
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
                if (sharedPreferences.contains("gdpr_crashlytics_allowed")) {
                    z9 = sharedPreferences.getBoolean("gdpr_crashlytics_allowed", false);
                }
            } catch (Exception unused) {
            }
            if (z9) {
                s1.c cVar = (s1.c) l1.g.c().b(s1.c.class);
                if (cVar == null) {
                    androidx.window.layout.c.k("FirebaseCrashlytics component is not present.");
                    return;
                }
                p pVar = cVar.f12517a;
                x1.e eVar = pVar.f13382o;
                eVar.f13576a.a(new androidx.browser.trusted.c(25, pVar, str));
                Map map = Collections.EMPTY_MAP;
                eVar.f13576a.a(new androidx.browser.trusted.c(pVar, exc));
            }
        }
    }

    public void g(String str, Bundle bundle, p0 p0Var, String str2) {
        Bundle bundle2 = new Bundle();
        if (bundle == null) {
            bundle = bundle2;
        }
        if (p0Var != null) {
            int i10 = p0Var.f8697b;
            if (i10 > 0) {
                bundle.putString("responseCode", String.valueOf(i10));
            }
            String str3 = p0Var.f8698c;
            if (str3 != null) {
                bundle.putString("exception", str3);
            }
        }
        if (str2 != null) {
            bundle.putString("workRequest", str2);
        }
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        e(bundle, "tracking");
    }

    @Override // p6.a
    public Object get() {
        t3.h hVar = new t3.h(17);
        t3.h hVar2 = new t3.h(16);
        Object obj = ((p6.a) this.f12751b).get();
        p6.a aVar = (p6.a) this.f12752c;
        return new w.h(hVar, hVar2, w.a.f, (j) obj, aVar);
    }

    @Override // j4.g
    public void onSuccess() {
        switch (this.f12750a) {
            case 13:
                c1 c1Var = (c1) this.f12751b;
                c1Var.itemView.setVisibility(0);
                if (c1Var.f13832b == 0) {
                    View view = c1Var.itemView;
                    view.getClass();
                    if (((FullHeightImageView) view).getWidth() > 0) {
                        View view2 = c1Var.itemView;
                        view2.getClass();
                        c1Var.f13832b = ((FullHeightImageView) view2).getWidth();
                        break;
                    }
                }
                break;
            default:
                ((c1) this.f12751b).itemView.setVisibility(0);
                break;
        }
    }

    @Override // j4.g
    public void p(Exception exc) {
        int i10 = this.f12750a;
        exc.getClass();
        switch (i10) {
            case 13:
                exc.printStackTrace();
                r rVar = ((c1) this.f12751b).f13831a;
                u0 u0Var = (u0) this.f12752c;
                rVar.getClass();
                ((ArrayList) rVar.f13463c).remove(u0Var);
                k0 k0Var = (k0) ((x) rVar.f13464d).f10138a;
                if (k0Var != null) {
                    k0Var.a(u0Var);
                    break;
                }
                break;
            default:
                exc.printStackTrace();
                r rVar2 = ((c1) this.f12751b).f13831a;
                h5.l1 l1Var = (h5.l1) this.f12752c;
                rVar2.getClass();
                ((ArrayList) rVar2.e).remove(l1Var);
                k0 k0Var2 = (k0) ((x) rVar2.f13464d).f10138a;
                if (k0Var2 != null) {
                    k0Var2.a(l1Var);
                    break;
                }
                break;
        }
    }

    @Override // h1.h
    public h1.p y(Object obj) {
        Boolean bool = (Boolean) obj;
        w1.l lVar = (w1.l) this.f12752c;
        if (bool.booleanValue()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Sending cached crash reports...", null);
            }
            boolean zBooleanValue = bool.booleanValue();
            s sVar = lVar.f13352b;
            if (zBooleanValue) {
                sVar.h.c(null);
                return ((h1.p) this.f12751b).j(lVar.e.f13576a, new x4(this, 24));
            }
            sVar.getClass();
            androidx.window.layout.c.g("An invalid data collection token was used.");
            return null;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Deleting cached crash reports...", null);
        }
        c2.d dVar = lVar.g;
        Iterator it = c2.d.m(((File) dVar.f1643d).listFiles(w1.l.f13349r)).iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
        c2.d dVar2 = ((c2.b) lVar.f13359m.f1642c).f1636b;
        c2.b.a(c2.d.m(((File) dVar2.f).listFiles()));
        c2.b.a(c2.d.m(((File) dVar2.g).listFiles()));
        c2.b.a(c2.d.m(((File) dVar2.h).listFiles()));
        lVar.f13363q.c(null);
        return r0.f.x(null);
    }

    public /* synthetic */ c(Object obj, Object obj2, int i10, boolean z9) {
        this.f12750a = i10;
        this.f12751b = obj;
        this.f12752c = obj2;
    }

    public c(n5 n5Var, v4.a aVar) {
        this.f12750a = 3;
        n5Var.getClass();
        this.f12751b = n5Var;
        this.f12752c = aVar;
    }

    public c(UptodownApp uptodownApp) {
        this.f12750a = 5;
        this.f12751b = uptodownApp;
        this.f12752c = new v5.h(this);
    }

    public c(int i10) {
        this.f12750a = i10;
        switch (i10) {
            case 11:
                n5 n5Var = new n5(26);
                this.f12751b = n5Var;
                this.f12752c = new x4(n5Var, 27);
                break;
            default:
                this.f12751b = new AtomicInteger();
                this.f12752c = new AtomicInteger();
                break;
        }
    }

    public /* synthetic */ c(int i10, Object obj, Object obj2) {
        this.f12750a = i10;
        this.f12752c = obj;
        this.f12751b = obj2;
    }

    public c(c cVar) throws Resources.NotFoundException, IOException {
        this.f12750a = 0;
        Context context = (Context) cVar.f12751b;
        int iD = w1.g.d(context, "com.google.firebase.crashlytics.unity_version", TypedValues.Custom.S_STRING);
        if (iD != 0) {
            this.f12751b = "Unity";
            String string = context.getResources().getString(iD);
            this.f12752c = string;
            String strI = a3.a.i("Unity Editor version is: ", string);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", strI, null);
                return;
            }
            return;
        }
        if (context.getAssets() != null) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("flutter_assets/NOTICES.Z");
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                this.f12751b = "Flutter";
                this.f12752c = null;
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Development platform is: Flutter", null);
                    return;
                }
                return;
            } catch (IOException unused) {
            }
        }
        this.f12751b = null;
        this.f12752c = null;
    }
}
