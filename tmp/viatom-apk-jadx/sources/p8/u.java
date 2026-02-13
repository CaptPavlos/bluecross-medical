package p8;

import a3.z0;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.measurement.u6;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.SSLPeerUnverifiedException;
import l4.p2;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class u implements q2.a, q1.d, h1.e, w.f, h1.a, n2.a, m.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12159a;

    public /* synthetic */ u(int i10) {
        this.f12159a = i10;
    }

    public static /* synthetic */ void e() {
        throw new IllegalStateException();
    }

    public static /* synthetic */ void f(int i10, String str) {
        throw new IllegalStateException(str + i10);
    }

    public static /* synthetic */ void g(long j10, Object obj) throws EOFException {
        throw new EOFException("\\n not found: limit=" + j10 + ((Object) " content=") + obj + (char) 8230);
    }

    public static /* synthetic */ void h(Object obj) {
        throw new AssertionError(obj);
    }

    public static /* synthetic */ void i(Object obj, String str) {
        throw new IllegalStateException((str + obj).toString());
    }

    public static /* synthetic */ void j(Object obj, String str, Object obj2) {
        throw new u6(str + obj + obj2);
    }

    public static /* synthetic */ void k(String str) {
        throw new IndexOutOfBoundsException(str);
    }

    public static /* synthetic */ void l(String str, Throwable th) {
        throw new o3.a(str, th);
    }

    public static /* synthetic */ void m() {
        throw new AssertionError();
    }

    public static /* synthetic */ void n(int i10, String str) throws IOException {
        throw new IOException(str + i10);
    }

    public static /* synthetic */ void o(Object obj, String str) throws SSLPeerUnverifiedException {
        throw new SSLPeerUnverifiedException(str + obj);
    }

    public static /* synthetic */ void p() {
        throw new UnsupportedOperationException();
    }

    public static /* synthetic */ void q() throws EOFException {
        throw new EOFException();
    }

    @Override // h1.a
    public Object a(h1.p pVar) throws IOException {
        boolean z9;
        int i10;
        Object obj;
        switch (this.f12159a) {
            case 18:
                if (pVar.i()) {
                    w1.b bVar = (w1.b) pVar.g();
                    t1.d dVar = t1.d.f12753a;
                    dVar.b("Crashlytics report successfully enqueued to DataTransport: " + bVar.f13322b);
                    File file = bVar.f13323c;
                    z9 = true;
                    if (file.delete()) {
                        dVar.b("Deleted report file: " + file.getPath());
                    } else {
                        dVar.d("Crashlytics could not delete report file: " + file.getPath(), null);
                    }
                } else {
                    Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", pVar.f());
                    z9 = false;
                }
                return Boolean.valueOf(z9);
            case 19:
            default:
                synchronized (pVar.f8435a) {
                    i0.y.i(pVar.f8437c, "Task is not yet complete");
                    if (pVar.f8438d) {
                        throw new CancellationException("Task is already canceled.");
                    }
                    boolean zIsInstance = IOException.class.isInstance(pVar.f);
                    Exception exc = pVar.f;
                    if (zIsInstance) {
                        throw ((Throwable) IOException.class.cast(exc));
                    }
                    if (exc != null) {
                        throw new h1.g(exc);
                    }
                    obj = pVar.e;
                }
                Bundle bundle = (Bundle) obj;
                if (bundle != null) {
                    String string = bundle.getString("registration_id");
                    if (string != null) {
                        return string;
                    }
                    String string2 = bundle.getString("unregistered");
                    if (string2 != null) {
                        return string2;
                    }
                    String string3 = bundle.getString(CampaignEx.JSON_NATIVE_VIDEO_ERROR);
                    if ("RST".equals(string3)) {
                        com.google.gson.internal.a.m("INSTANCE_ID_RESET");
                    } else if (string3 != null) {
                        com.google.gson.internal.a.m(string3);
                    } else {
                        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                        com.google.gson.internal.a.m("SERVICE_NOT_AVAILABLE");
                    }
                } else {
                    com.google.gson.internal.a.m("SERVICE_NOT_AVAILABLE");
                }
                return null;
            case 20:
                i10 = 403;
                break;
            case 21:
                i10 = -1;
                break;
        }
        return Integer.valueOf(i10);
    }

    @Override // w.f
    public Object apply(Object obj) {
        switch (this.f12159a) {
            case 17:
                Cursor cursor = (Cursor) obj;
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    if (string == null) {
                        androidx.window.layout.c.k("Null backendName");
                        return null;
                    }
                    m.d dVarB = z.a.b(cursor.getInt(2));
                    String string2 = cursor.getString(3);
                    arrayList.add(new p.i(string, string2 == null ? null : Base64.decode(string2, 0), dVarB));
                }
                return arrayList;
            default:
                x2.e eVar = (x2.e) obj;
                p2 p2Var = w2.n.f13455a;
                p2Var.getClass();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    p2Var.a(eVar, byteArrayOutputStream);
                } catch (IOException unused) {
                }
                return byteArrayOutputStream.toByteArray();
        }
    }

    @Override // q2.a
    public void b(q2.b bVar) {
        switch (this.f12159a) {
            case 2:
                return;
            default:
                bVar.get().getClass();
                throw new ClassCastException();
        }
    }

    @Override // q1.d
    public Object c(z0 z0Var) {
        switch (this.f12159a) {
            case 5:
                return (ScheduledExecutorService) ExecutorsRegistrar.f2420a.get();
            case 6:
                return (ScheduledExecutorService) ExecutorsRegistrar.f2422c.get();
            case 7:
                return (ScheduledExecutorService) ExecutorsRegistrar.f2421b.get();
            case 8:
                q1.m mVar = ExecutorsRegistrar.f2420a;
                return r1.k.f12340a;
            case 9:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(z0Var);
            default:
                Set setO = z0Var.o(y2.a.class);
                y2.c cVar = y2.c.f13779c;
                if (cVar == null) {
                    synchronized (y2.c.class) {
                        try {
                            cVar = y2.c.f13779c;
                            if (cVar == null) {
                                cVar = new y2.c(0);
                                y2.c.f13779c = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return new y2.b(setO, cVar);
        }
    }

    @Override // h1.e
    public void u(Exception exc) {
        Log.e("FirebaseCrashlytics", "Error fetching settings.", exc);
    }

    public /* synthetic */ u(Object obj, int i10) {
        this.f12159a = i10;
    }

    private final void d(q2.b bVar) {
    }
}
