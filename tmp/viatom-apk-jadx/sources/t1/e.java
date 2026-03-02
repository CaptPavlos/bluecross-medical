package t1;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.l;
import t6.n;
import t6.t;
import z1.c2;
import z1.y0;
import z1.z0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f12754a = new e();

    public static ArrayList a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        context.getClass();
        int i10 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            runningAppProcesses = t.f12808a;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : runningAppProcesses) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        int i12 = 0;
        while (i12 < size) {
            Object obj2 = arrayList.get(i12);
            i12++;
            if (((ActivityManager.RunningAppProcessInfo) obj2).uid == i10) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(n.V(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i11 < size2) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj3;
            y0 y0Var = new y0();
            String str2 = runningAppProcessInfo.processName;
            if (str2 == null) {
                androidx.window.layout.c.k("Null processName");
                return null;
            }
            y0Var.f14391a = str2;
            y0Var.f14392b = runningAppProcessInfo.pid;
            byte b10 = (byte) (y0Var.e | 1);
            y0Var.f14393c = runningAppProcessInfo.importance;
            y0Var.e = (byte) (b10 | 2);
            y0Var.f14394d = l.a(str2, str);
            y0Var.e = (byte) (y0Var.e | 4);
            arrayList3.add(y0Var.a());
        }
        return arrayList3;
    }

    public final c2 b(Context context) {
        Object obj;
        String processName;
        context.getClass();
        int iMyPid = Process.myPid();
        ArrayList arrayListA = a(context);
        int size = arrayListA.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                obj = null;
                break;
            }
            obj = arrayListA.get(i10);
            i10++;
            if (((z0) ((c2) obj)).f14398b == iMyPid) {
                break;
            }
        }
        c2 c2Var = (c2) obj;
        if (c2Var != null) {
            return c2Var;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 33) {
            processName = Process.myProcessName();
            processName.getClass();
        } else if (i11 < 28 || (processName = Application.getProcessName()) == null) {
            processName = "";
        }
        y0 y0Var = new y0();
        y0Var.f14391a = processName;
        y0Var.f14392b = iMyPid;
        byte b10 = (byte) (y0Var.e | 1);
        y0Var.f14393c = 0;
        y0Var.f14394d = false;
        y0Var.e = (byte) (((byte) (b10 | 2)) | 4);
        return y0Var.a();
    }
}
