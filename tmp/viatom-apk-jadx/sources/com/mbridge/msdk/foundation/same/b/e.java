package com.mbridge.msdk.foundation.same.b;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static volatile e f3651a;

    /* renamed from: b, reason: collision with root package name */
    private final b f3652b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<a> f3653c = new ArrayList<>();

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public File f3654a;

        /* renamed from: b, reason: collision with root package name */
        public c f3655b;

        public a(c cVar, File file) {
            this.f3655b = cVar;
            this.f3654a = file;
        }
    }

    private e(b bVar) {
        this.f3652b = bVar;
    }

    private boolean a(com.mbridge.msdk.foundation.same.b.a aVar) {
        String strB;
        com.mbridge.msdk.foundation.same.b.a aVarC = aVar.c();
        if (aVarC == null) {
            strB = aVar.b();
        } else {
            File fileB = b(aVarC.d());
            if (fileB == null) {
                return false;
            }
            strB = fileB.getAbsolutePath() + File.separator + aVar.b();
        }
        File file = new File(strB);
        if (!(!file.exists() ? file.mkdirs() : true)) {
            return false;
        }
        this.f3653c.add(new a(aVar.d(), file));
        List<com.mbridge.msdk.foundation.same.b.a> listA = aVar.a();
        if (listA != null) {
            Iterator<com.mbridge.msdk.foundation.same.b.a> it = listA.iterator();
            while (it.hasNext()) {
                if (!a(it.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    public static File b(c cVar) {
        try {
            if (a() == null || a().f3653c == null || a().f3653c.isEmpty()) {
                return null;
            }
            ArrayList<a> arrayList = a().f3653c;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                a aVar = arrayList.get(i10);
                i10++;
                a aVar2 = aVar;
                if (aVar2.f3655b.equals(cVar)) {
                    return aVar2.f3654a;
                }
            }
            return null;
        } catch (Throwable th) {
            af.b("MBridgeDirManager", th.getMessage(), th);
            return null;
        }
    }

    public final boolean b() {
        return a(this.f3652b.b());
    }

    public static synchronized e a() {
        try {
            if (f3651a == null && com.mbridge.msdk.foundation.controller.c.m().c() != null) {
                ai.a(com.mbridge.msdk.foundation.controller.c.m().c());
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3651a;
    }

    public static synchronized void a(b bVar) {
        if (f3651a == null) {
            f3651a = new e(bVar);
        }
    }

    public static String a(c cVar) {
        File fileB = b(cVar);
        if (fileB != null) {
            return fileB.getAbsolutePath();
        }
        return null;
    }
}
