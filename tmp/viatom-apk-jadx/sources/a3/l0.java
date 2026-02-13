package a3;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class l0 {
    public static ArrayList a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        context.getClass();
        int i10 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            runningAppProcesses = t6.t.f12808a;
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
        ArrayList arrayList3 = new ArrayList(t6.n.V(arrayList2, 10));
        int size2 = arrayList2.size();
        while (i11 < size2) {
            Object obj3 = arrayList2.get(i11);
            i11++;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = (ActivityManager.RunningAppProcessInfo) obj3;
            String str2 = runningAppProcessInfo.processName;
            str2.getClass();
            arrayList3.add(new k0(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, kotlin.jvm.internal.l.a(runningAppProcessInfo.processName, str)));
        }
        return arrayList3;
    }

    public static k0 b(Context context) {
        Object obj;
        String strA;
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
            if (((k0) obj).f119b == iMyPid) {
                break;
            }
        }
        k0 k0Var = (k0) obj;
        if (k0Var != null) {
            return k0Var;
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 > 33) {
            strA = Process.myProcessName();
            strA.getClass();
        } else if ((i11 < 28 || (strA = Application.getProcessName()) == null) && (strA = n0.c.a()) == null) {
            strA = "";
        }
        return new k0(strA, iMyPid, 0, false);
    }
}
