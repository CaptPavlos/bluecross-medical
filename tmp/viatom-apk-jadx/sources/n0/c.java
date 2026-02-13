package n0;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import com.google.android.gms.internal.measurement.a4;
import com.google.android.gms.internal.measurement.u6;
import i0.y;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static String f11271a;

    /* renamed from: b, reason: collision with root package name */
    public static int f11272b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f11273c;

    public static String a() throws Throwable {
        BufferedReader bufferedReader;
        if (f11271a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f11271a = Application.getProcessName();
            } else {
                int iMyPid = f11272b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f11272b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        String str = "/proc/" + iMyPid + "/cmdline";
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            bufferedReader = new BufferedReader(new FileReader(str));
                            try {
                                String line = bufferedReader.readLine();
                                y.g(line);
                                strTrim = line.trim();
                            } catch (IOException unused) {
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                f11271a = strTrim;
                                return f11271a;
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader2 = bufferedReader;
                                if (bufferedReader2 != null) {
                                    try {
                                        bufferedReader2.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                throw th;
                            }
                        } finally {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                        }
                    } catch (IOException unused3) {
                        bufferedReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        bufferedReader.close();
                    } catch (IOException unused4) {
                    }
                }
                f11271a = strTrim;
            }
        }
        return f11271a;
    }

    public static boolean b() {
        Boolean boolValueOf = f11273c;
        if (boolValueOf == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objN = a4.N(Process.class, "isIsolated", new t1.c[0]);
                    Object[] objArr = new Object[0];
                    if (objN == null) {
                        throw new u6(a.a.R(objArr));
                    }
                    boolValueOf = (Boolean) objN;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = Boolean.FALSE;
                }
            }
            f11273c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
