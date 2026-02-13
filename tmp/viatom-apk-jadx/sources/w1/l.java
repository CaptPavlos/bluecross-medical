package w1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import c1.g1;
import c1.q2;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicMarkableReference;
import z1.a0;
import z1.b0;
import z1.h1;
import z1.i0;
import z1.j0;
import z1.k0;
import z1.k1;
import z1.l1;
import z1.m0;
import z1.m1;
import z1.m2;
import z1.n1;
import z1.n2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class l {

    /* renamed from: r, reason: collision with root package name */
    public static final c2.a f13349r = new c2.a(3);

    /* renamed from: s, reason: collision with root package name */
    public static final Charset f13350s = Charset.forName(C.UTF8_NAME);

    /* renamed from: a, reason: collision with root package name */
    public final Context f13351a;

    /* renamed from: b, reason: collision with root package name */
    public final s f13352b;

    /* renamed from: c, reason: collision with root package name */
    public final t1.c f13353c;

    /* renamed from: d, reason: collision with root package name */
    public final c2.d f13354d;
    public final x1.e e;
    public final w f;
    public final c2.d g;
    public final a h;

    /* renamed from: i, reason: collision with root package name */
    public final y1.f f13355i;

    /* renamed from: j, reason: collision with root package name */
    public final t1.b f13356j;

    /* renamed from: k, reason: collision with root package name */
    public final u1.a f13357k;

    /* renamed from: l, reason: collision with root package name */
    public final i f13358l;

    /* renamed from: m, reason: collision with root package name */
    public final c2.d f13359m;

    /* renamed from: n, reason: collision with root package name */
    public r f13360n;

    /* renamed from: o, reason: collision with root package name */
    public final h1.i f13361o = new h1.i();

    /* renamed from: p, reason: collision with root package name */
    public final h1.i f13362p = new h1.i();

    /* renamed from: q, reason: collision with root package name */
    public final h1.i f13363q = new h1.i();

    public l(Context context, w wVar, s sVar, c2.d dVar, t1.c cVar, a aVar, c2.d dVar2, y1.f fVar, c2.d dVar3, t1.b bVar, u1.a aVar2, i iVar, x1.e eVar) {
        new AtomicBoolean(false);
        this.f13351a = context;
        this.f = wVar;
        this.f13352b = sVar;
        this.g = dVar;
        this.f13353c = cVar;
        this.h = aVar;
        this.f13354d = dVar2;
        this.f13355i = fVar;
        this.f13356j = bVar;
        this.f13357k = aVar2;
        this.f13358l = iVar;
        this.f13359m = dVar3;
        this.e = eVar;
    }

    public static h1.p a(l lVar) {
        h1.p pVarM;
        lVar.getClass();
        ArrayList arrayList = new ArrayList();
        for (File file : c2.d.m(((File) lVar.g.f1643d).listFiles(f13349r))) {
            try {
                long j10 = Long.parseLong(file.getName().substring(3));
                try {
                    Class.forName("com.google.firebase.crash.FirebaseCrash");
                    Log.w("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, FirebaseCrash exists", null);
                    pVarM = r0.f.x(null);
                } catch (ClassNotFoundException unused) {
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        Log.d("FirebaseCrashlytics", "Logging app exception event to Firebase Analytics", null);
                    }
                    pVarM = r0.f.m(new ScheduledThreadPoolExecutor(1), new k(lVar, j10));
                }
                arrayList.add(pVarM);
            } catch (NumberFormatException unused2) {
                Log.w("FirebaseCrashlytics", "Could not parse app exception timestamp from file " + file.getName(), null);
            }
            file.delete();
        }
        return r0.f.M(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05f2  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25, types: [int] */
    /* JADX WARN: Type inference failed for: r11v58 */
    /* JADX WARN: Type inference failed for: r32v0, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r32, d5.n r33, boolean r34) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1907
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.l.b(boolean, d5.n, boolean):void");
    }

    public final void c(String str, Boolean bool) {
        String str2;
        Integer num;
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        String strI = a3.a.i("Opening a new session with ID ", str);
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", strI, null);
        }
        Locale locale = Locale.US;
        w wVar = this.f;
        a aVar = this.h;
        l1 l1Var = new l1(wVar.f13402c, aVar.f, aVar.g, wVar.c().f13324a, r1.i.b(aVar.f13320d != null ? 4 : 1), aVar.h);
        String str3 = Build.VERSION.RELEASE;
        String str4 = Build.VERSION.CODENAME;
        n1 n1Var = new n1(g.g());
        Context context = this.f13351a;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockCount = statFs.getBlockCount() * statFs.getBlockSize();
        f fVar = f.f13333a;
        String str5 = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str5)) {
            f fVar2 = (f) f.f13334b.get(str5.toLowerCase(locale));
            if (fVar2 != null) {
                fVar = fVar2;
            }
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Architecture#getValue()::Build.CPU_ABI returned null or empty", null);
        }
        int iOrdinal = fVar.ordinal();
        String str6 = Build.MODEL;
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        long jA = g.a(context);
        boolean zF = g.f();
        int iC = g.c();
        String str7 = Build.MANUFACTURER;
        String str8 = Build.PRODUCT;
        this.f13356j.d(str, jCurrentTimeMillis, new k1(l1Var, n1Var, new m1(iOrdinal, iAvailableProcessors, jA, blockCount, zF, iC)));
        if (!bool.booleanValue() || str == null) {
            str2 = str8;
        } else {
            c2.d dVar = this.f13354d;
            synchronized (((String) dVar.f1641b)) {
                dVar.f1641b = str;
                str2 = str8;
                ((x1.e) dVar.f1643d).f13577b.a(new androidx.work.impl.e(dVar, str, ((y1.e) ((AtomicMarkableReference) ((g1) dVar.e).f1230b).getReference()).a(), ((s8.c) dVar.g).a()));
            }
        }
        y1.f fVar3 = this.f13355i;
        ((y1.d) fVar3.f13758b).a();
        fVar3.f13758b = y1.f.f13756c;
        if (str != null) {
            fVar3.f13758b = new y1.m(((c2.d) fVar3.f13757a).h(str, "userlog"));
        }
        this.f13358l.b(str);
        c2.d dVar2 = this.f13359m;
        q qVar = (q) dVar2.f1641b;
        Charset charset = n2.f14312a;
        a0 a0Var = new a0();
        a0Var.f14142a = "20.0.3";
        a aVar2 = qVar.f13385c;
        String str9 = aVar2.f13317a;
        if (str9 == null) {
            androidx.window.layout.c.k("Null gmpAppId");
            return;
        }
        a0Var.f14143b = str9;
        w wVar2 = qVar.f13384b;
        String str10 = wVar2.c().f13324a;
        if (str10 == null) {
            androidx.window.layout.c.k("Null installationUuid");
            return;
        }
        a0Var.f14145d = str10;
        a0Var.e = wVar2.c().f13325b;
        a0Var.f = wVar2.c().f13326c;
        String str11 = aVar2.f;
        if (str11 == null) {
            androidx.window.layout.c.k("Null buildVersion");
            return;
        }
        a0Var.h = str11;
        String str12 = aVar2.g;
        if (str12 == null) {
            androidx.window.layout.c.k("Null displayVersion");
            return;
        }
        a0Var.f14146i = str12;
        a0Var.f14144c = 4;
        a0Var.f14150m = (byte) (a0Var.f14150m | 1);
        i0 i0Var = new i0();
        i0Var.f = false;
        byte b10 = (byte) (i0Var.f14246m | 2);
        i0Var.f14241d = jCurrentTimeMillis;
        i0Var.f14246m = (byte) (b10 | 1);
        if (str == null) {
            androidx.window.layout.c.k("Null identifier");
            return;
        }
        i0Var.f14239b = str;
        String str13 = q.g;
        if (str13 == null) {
            androidx.window.layout.c.k("Null generator");
            return;
        }
        i0Var.f14238a = str13;
        String str14 = wVar2.f13402c;
        if (str14 == null) {
            androidx.window.layout.c.k("Null identifier");
            return;
        }
        String str15 = wVar2.c().f13324a;
        t1.c cVar = aVar2.h;
        if (((t1.c) cVar.f12752c) == null) {
            cVar.f12752c = new t1.c(cVar);
        }
        t1.c cVar2 = (t1.c) cVar.f12752c;
        String str16 = (String) cVar2.f12751b;
        if (cVar2 == null) {
            cVar.f12752c = new t1.c(cVar);
        }
        i0Var.g = new k0(str14, str11, str12, str15, str16, (String) ((t1.c) cVar.f12752c).f12752c);
        h1 h1Var = new h1();
        h1Var.f14228a = 3;
        h1Var.e = (byte) (h1Var.e | 1);
        if (str3 == null) {
            androidx.window.layout.c.k("Null version");
            return;
        }
        h1Var.f14229b = str3;
        if (str4 == null) {
            androidx.window.layout.c.k("Null buildVersion");
            return;
        }
        h1Var.f14230c = str4;
        h1Var.f14231d = g.g();
        h1Var.e = (byte) (h1Var.e | 2);
        i0Var.f14242i = h1Var.a();
        StatFs statFs2 = new StatFs(Environment.getDataDirectory().getPath());
        int iIntValue = 7;
        if (!TextUtils.isEmpty(str5) && (num = (Integer) q.f.get(str5.toLowerCase(locale))) != null) {
            iIntValue = num.intValue();
        }
        int iAvailableProcessors2 = Runtime.getRuntime().availableProcessors();
        long jA2 = g.a(qVar.f13383a);
        long blockCount2 = statFs2.getBlockCount() * statFs2.getBlockSize();
        boolean zF2 = g.f();
        int iC2 = g.c();
        m0 m0Var = new m0();
        m0Var.f14292a = iIntValue;
        byte b11 = (byte) (m0Var.f14297j | 1);
        m0Var.f14297j = b11;
        if (str6 == null) {
            androidx.window.layout.c.k("Null model");
            return;
        }
        m0Var.f14293b = str6;
        m0Var.f14294c = iAvailableProcessors2;
        m0Var.f14295d = jA2;
        m0Var.e = blockCount2;
        m0Var.f = zF2;
        m0Var.g = iC2;
        m0Var.f14297j = (byte) (((byte) (((byte) (((byte) (((byte) (b11 | 2)) | 4)) | 8)) | 16)) | 32);
        if (str7 == null) {
            androidx.window.layout.c.k("Null manufacturer");
            return;
        }
        m0Var.h = str7;
        if (str2 == null) {
            androidx.window.layout.c.k("Null modelClass");
            return;
        }
        m0Var.f14296i = str2;
        i0Var.f14243j = m0Var.a();
        i0Var.f14245l = 3;
        i0Var.f14246m = (byte) (i0Var.f14246m | 4);
        a0Var.f14147j = i0Var.a();
        b0 b0VarA = a0Var.a();
        c2.d dVar3 = ((c2.b) dVar2.f1642c).f1636b;
        m2 m2Var = b0VarA.f14166k;
        if (m2Var == null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Could not get session for report", null);
                return;
            }
            return;
        }
        String str17 = ((j0) m2Var).f14261b;
        try {
            c2.b.g.getClass();
            c2.b.f(dVar3.h(str17, "report"), a2.b.f21a.w(b0VarA));
            File fileH = dVar3.h(str17, "start-time");
            long j10 = ((j0) m2Var).f14263d;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(fileH), c2.b.e);
            try {
                outputStreamWriter.write("");
                fileH.setLastModified(j10 * 1000);
                outputStreamWriter.close();
            } finally {
            }
        } catch (IOException e) {
            String strI2 = a3.a.i("Could not persist report for session ", str17);
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", strI2, e);
            }
        }
    }

    public final boolean d(d5.n nVar) throws Throwable {
        x1.e.a();
        r rVar = this.f13360n;
        if (rVar != null && rVar.e.get()) {
            Log.w("FirebaseCrashlytics", "Skipping session finalization because a crash has already occurred.", null);
            return false;
        }
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "Finalizing previously open sessions.", null);
        }
        try {
            b(true, nVar, true);
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "Closed all previously open sessions.", null);
            }
            return true;
        } catch (Exception e) {
            Log.e("FirebaseCrashlytics", "Unable to finalize previously open sessions.", e);
            return false;
        }
    }

    public final String e() {
        NavigableSet navigableSetC = ((c2.b) this.f13359m.f1642c).c();
        if (navigableSetC.isEmpty()) {
            return null;
        }
        return (String) navigableSetC.first();
    }

    public final String f() throws Resources.NotFoundException, IOException {
        InputStream resourceAsStream;
        Context context = this.f13351a;
        int iD = g.d(context, "com.google.firebase.crashlytics.version_control_info", TypedValues.Custom.S_STRING);
        String string = iD == 0 ? null : context.getResources().getString(iD);
        if (string != null) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Read version control info from string resource", null);
            }
            return Base64.encodeToString(string.getBytes(f13350s), 0);
        }
        ClassLoader classLoader = l.class.getClassLoader();
        if (classLoader == null) {
            Log.w("FirebaseCrashlytics", "Couldn't get Class Loader", null);
            resourceAsStream = null;
        } else {
            resourceAsStream = classLoader.getResourceAsStream("META-INF/version-control-info.textproto");
        }
        if (resourceAsStream == null) {
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            Log.i("FirebaseCrashlytics", "No version control information found", null);
            return null;
        }
        try {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Read version control info from file", null);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int i10 = resourceAsStream.read(bArr);
                    if (i10 == -1) {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        String strEncodeToString = Base64.encodeToString(byteArray, 0);
                        resourceAsStream.close();
                        return strEncodeToString;
                    }
                    byteArrayOutputStream.write(bArr, 0, i10);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                resourceAsStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void g() throws Resources.NotFoundException {
        try {
            String strF = f();
            if (strF != null) {
                try {
                    ((g1) this.f13354d.f).l("com.crashlytics.version-control-info", strF);
                } catch (IllegalArgumentException e) {
                    Context context = this.f13351a;
                    if (context != null) {
                        if ((context.getApplicationInfo().flags & 2) != 0) {
                            throw e;
                        }
                    }
                    Log.e("FirebaseCrashlytics", "Attempting to set custom attribute with null key, ignoring.", null);
                }
                Log.i("FirebaseCrashlytics", "Saved version control info", null);
            }
        } catch (IOException e3) {
            Log.w("FirebaseCrashlytics", "Unable to save version control info", e3);
        }
    }

    public final void h(h1.p pVar) {
        h1.p pVar2;
        h1.p pVarA;
        h1.i iVar = this.f13361o;
        c2.d dVar = ((c2.b) this.f13359m.f1642c).f1636b;
        if (c2.d.m(((File) dVar.f).listFiles()).isEmpty() && c2.d.m(((File) dVar.g).listFiles()).isEmpty() && c2.d.m(((File) dVar.h).listFiles()).isEmpty()) {
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", "No crash reports are available to be sent.", null);
            }
            iVar.c(Boolean.FALSE);
            return;
        }
        t1.d dVar2 = t1.d.f12753a;
        dVar2.c("Crash reports are available to be sent.");
        s sVar = this.f13352b;
        if (sVar.a()) {
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", "Automatic data collection is enabled. Allowing upload.", null);
            }
            iVar.c(Boolean.FALSE);
            pVarA = r0.f.x(Boolean.TRUE);
        } else {
            dVar2.b("Automatic data collection is disabled.");
            dVar2.c("Notifying that unsent reports are available.");
            iVar.c(Boolean.TRUE);
            synchronized (sVar.f13393c) {
                pVar2 = sVar.f13394d.f8418a;
            }
            t3.h hVar = new t3.h(12);
            pVar2.getClass();
            q2 q2Var = h1.j.f8419a;
            h1.p pVar3 = new h1.p();
            pVar2.f8436b.o(new h1.m(q2Var, hVar, pVar3));
            pVar2.p();
            dVar2.b("Waiting for send/deleteUnsentReports to be called.");
            pVarA = x1.a.a(pVar3, this.f13362p.f8418a);
        }
        pVarA.j(this.e.f13576a, new t1.c(7, this, pVar));
    }
}
