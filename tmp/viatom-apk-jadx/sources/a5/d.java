package a5;

import com.google.android.gms.internal.measurement.a4;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: s, reason: collision with root package name */
    public static d f227s;

    /* renamed from: a, reason: collision with root package name */
    public final int f228a;

    /* renamed from: b, reason: collision with root package name */
    public final int f229b;

    /* renamed from: c, reason: collision with root package name */
    public final int f230c;
    public final Process e;
    public final BufferedReader f;
    public final BufferedReader g;
    public final OutputStreamWriter h;

    /* renamed from: d, reason: collision with root package name */
    public String f231d = "";

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f232i = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public boolean f233j = false;

    /* renamed from: k, reason: collision with root package name */
    public boolean f234k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f235l = false;

    /* renamed from: m, reason: collision with root package name */
    public final int f236m = DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS;

    /* renamed from: n, reason: collision with root package name */
    public int f237n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f238o = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f239p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f240q = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f241r = false;

    public d(int i10) throws InterruptedException, z4.a, TimeoutException, IOException {
        String str;
        this.f228a = 25000;
        this.f229b = 0;
        this.f230c = 1;
        b bVar = new b(this, 0);
        b bVar2 = new b(this, 1);
        a4.x("Starting shell: su");
        switch (1) {
            case 1:
                str = "normal";
                break;
            case 2:
                str = "u:r:shell:s0";
                break;
            case 3:
                str = "u:r:system_server:s0";
                break;
            case 4:
                str = "u:r:system_app:s0";
                break;
            case 5:
                str = "u:r:platform_app:s0";
                break;
            case 6:
                str = "u:r:untrusted_app:s0";
                break;
            case 7:
                str = "u:r:recovery:s0";
                break;
            default:
                throw null;
        }
        a4.x("Context: ".concat(str));
        a4.x("Timeout: " + i10);
        this.f229b = 2;
        i10 = i10 <= 0 ? 25000 : i10;
        this.f228a = i10;
        this.f230c = 1;
        Process processExec = Runtime.getRuntime().exec(DownloadCommon.DOWNLOAD_REPORT_SUCCESS);
        this.e = processExec;
        this.f = new BufferedReader(new InputStreamReader(processExec.getInputStream(), C.UTF8_NAME));
        this.g = new BufferedReader(new InputStreamReader(processExec.getErrorStream(), C.UTF8_NAME));
        this.h = new OutputStreamWriter(processExec.getOutputStream(), C.UTF8_NAME);
        c cVar = new c();
        cVar.f225a = -911;
        cVar.f226b = this;
        cVar.start();
        try {
            cVar.join(i10);
            int i11 = cVar.f225a;
            if (i11 == -911) {
                try {
                    processExec.destroy();
                } catch (Exception unused) {
                }
                c(this.f);
                c(this.g);
                b(this.h);
                throw new TimeoutException(this.f231d);
            }
            if (i11 == -42) {
                try {
                    processExec.destroy();
                } catch (Exception unused2) {
                }
                c(this.f);
                c(this.g);
                b(this.h);
                throw new z4.a("Root Access Denied");
            }
            Thread thread = new Thread(bVar, "Shell Input");
            thread.setPriority(5);
            thread.start();
            Thread thread2 = new Thread(bVar2, "Shell Output");
            thread2.setPriority(5);
            thread2.start();
        } catch (InterruptedException unused3) {
            cVar.interrupt();
            Thread.currentThread().interrupt();
            throw new TimeoutException();
        }
    }

    public static void a(d dVar) {
        ArrayList arrayList = dVar.f232i;
        dVar.f241r = true;
        int i10 = dVar.f236m;
        int iAbs = Math.abs(i10 - (i10 / 4));
        a4.x("Cleaning up: " + iAbs);
        for (int i11 = 0; i11 < iAbs; i11++) {
            arrayList.remove(0);
        }
        dVar.f237n = arrayList.size() - 1;
        dVar.f238o = arrayList.size() - 1;
        dVar.f241r = false;
    }

    public static void b(OutputStreamWriter outputStreamWriter) {
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void c(Reader reader) {
        if (reader != null) {
            try {
                reader.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void d() {
        a4.x("Request to close root shell!");
        d dVar = f227s;
        if (dVar == null) {
            return;
        }
        a4.x("Request to close shell!");
        int i10 = 0;
        while (dVar.f234k) {
            a4.x("Waiting on shell to finish executing before closing...");
            i10++;
            if (i10 > 10000) {
                break;
            }
        }
        synchronized (dVar.f232i) {
            dVar.f233j = true;
            new a0.c(dVar, 1).start();
        }
        a4.x("Shell Closed!");
        if (dVar == f227s) {
            f227s = null;
        }
    }

    public static d e(int i10) {
        int i11;
        d dVar = f227s;
        if (dVar == null) {
            a4.x("Starting Root Shell!");
            int i12 = 0;
            while (f227s == null) {
                try {
                    a4.x("Trying to open Root Shell, attempt #" + i12);
                    f227s = new d(i10);
                } catch (IOException e) {
                    i11 = i12 + 1;
                    if (i12 >= 3) {
                        a4.x("IOException, could not start shell");
                        throw e;
                    }
                    i12 = i11;
                } catch (TimeoutException e3) {
                    i11 = i12 + 1;
                    if (i12 >= 3) {
                        a4.x("TimeoutException, could not start shell");
                        throw e3;
                    }
                    i12 = i11;
                } catch (z4.a e7) {
                    i11 = i12 + 1;
                    if (i12 >= 3) {
                        a4.x("RootDeniedException, could not start shell");
                        throw e7;
                    }
                    i12 = i11;
                }
            }
        } else if (dVar.f230c != 1) {
            try {
                a4.x("Context is different than open shell, switching context... " + a3.a.D(f227s.f230c) + " VS " + a3.a.D(1));
                f227s.f();
            } catch (IOException | TimeoutException | z4.a unused) {
            }
        } else {
            a4.x("Using Existing Root Shell!");
        }
        return f227s;
    }

    public final void f() {
        if (this.f229b != 2) {
            a4.x("Can only switch context on a root shell!");
            return;
        }
        try {
            a4.x("Request to close root shell!");
            d dVar = f227s;
            if (dVar != null) {
                a4.x("Request to close shell!");
                int i10 = 0;
                while (dVar.f234k) {
                    a4.x("Waiting on shell to finish executing before closing...");
                    i10++;
                    if (i10 > 10000) {
                        break;
                    }
                }
                synchronized (dVar.f232i) {
                    dVar.f233j = true;
                    new a0.c(dVar, 1).start();
                }
                a4.x("Shell Closed!");
                if (dVar == f227s) {
                    f227s = null;
                }
            }
        } catch (Exception unused) {
            a4.x("Problem closing shell while trying to switch context...");
        }
        e(this.f228a);
    }
}
