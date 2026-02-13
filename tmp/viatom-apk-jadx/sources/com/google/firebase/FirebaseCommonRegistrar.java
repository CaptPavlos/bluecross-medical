package com.google.firebase;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.firebase.components.ComponentRegistrar;
import f9.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import o2.d;
import o2.e;
import o2.f;
import o2.g;
import p8.u;
import q1.a;
import q1.i;
import q1.q;
import y2.b;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class FirebaseCommonRegistrar implements ComponentRegistrar {
    public static /* synthetic */ String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        return (applicationInfo == null || Build.VERSION.SDK_INT < 24) ? "" : String.valueOf(applicationInfo.minSdkVersion);
    }

    public static String b(String str) {
        return str.replace(' ', '_').replace('/', '_');
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public final List getComponents() {
        String str;
        ArrayList arrayList = new ArrayList();
        p pVarA = a.a(b.class);
        pVarA.c(new i(2, 0, y2.a.class));
        pVarA.f = new u(25);
        arrayList.add(pVarA.d());
        q qVar = new q(p1.a.class, Executor.class);
        p pVar = new p(d.class, new Class[]{f.class, g.class});
        pVar.c(i.a(Context.class));
        pVar.c(i.a(l1.g.class));
        pVar.c(new i(2, 0, e.class));
        pVar.c(new i(1, 1, b.class));
        pVar.c(new i(qVar, 1, 0));
        pVar.f = new o2.b(qVar, 0);
        arrayList.add(pVar.d());
        arrayList.add(a.a.o("fire-android", String.valueOf(Build.VERSION.SDK_INT)));
        arrayList.add(a.a.o("fire-core", "22.0.1"));
        arrayList.add(a.a.o("device-name", b(Build.PRODUCT)));
        arrayList.add(a.a.o("device-model", b(Build.DEVICE)));
        arrayList.add(a.a.o("device-brand", b(Build.BRAND)));
        arrayList.add(a.a.z("android-target-sdk", new com.google.gson.internal.a(14)));
        arrayList.add(a.a.z("android-min-sdk", new com.google.gson.internal.a(15)));
        arrayList.add(a.a.z("android-platform", new com.google.gson.internal.a(16)));
        arrayList.add(a.a.z("android-installer", new com.google.gson.internal.a(17)));
        try {
            s6.e.f12688b.getClass();
            str = "2.2.10";
        } catch (NoClassDefFoundError unused) {
            str = null;
        }
        if (str != null) {
            arrayList.add(a.a.o("kotlin", str));
        }
        return arrayList;
    }
}
