package com.mbridge.msdk.mbsignalcommon.windvane;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.mbsignalcommon.c.a;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements Handler.Callback, c {

    /* renamed from: a, reason: collision with root package name */
    protected Pattern f4425a;

    /* renamed from: b, reason: collision with root package name */
    protected String f4426b;

    /* renamed from: d, reason: collision with root package name */
    protected Context f4428d;
    protected WindVaneWebView e;

    /* renamed from: c, reason: collision with root package name */
    protected final int f4427c = 1;
    protected Handler f = new Handler(Looper.getMainLooper(), this);

    public i(Context context) {
        this.f4428d = context;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final boolean a(String str) {
        if (!j.a(str)) {
            return false;
        }
        this.f4425a = j.b(str);
        this.f4426b = str;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.String r8) {
        /*
            r7 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L8
            goto Lc2
        L8:
            r0 = 2
            r1 = 0
            r2 = 1
            if (r8 != 0) goto Le
            goto L69
        Le:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r3 = r7.e
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = com.mbridge.msdk.mbsignalcommon.mraid.c.a(r3, r8)
            if (r3 == 0) goto L1b
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r7.e
            r3.f4406b = r8
            goto L6a
        L1b:
            java.util.regex.Pattern r3 = r7.f4425a
            java.util.regex.Matcher r8 = r3.matcher(r8)
            boolean r3 = r8.matches()
            if (r3 == 0) goto L69
            com.mbridge.msdk.mbsignalcommon.windvane.a r3 = new com.mbridge.msdk.mbsignalcommon.windvane.a
            r3.<init>()
            int r4 = r8.groupCount()
            r5 = 5
            if (r4 < r5) goto L39
            java.lang.String r5 = r8.group(r5)
            r3.f = r5
        L39:
            r5 = 3
            if (r4 < r5) goto L69
            java.lang.String r4 = r8.group(r2)
            r3.f4408d = r4
            java.lang.String r4 = r8.group(r0)
            r3.g = r4
            java.lang.String r8 = r8.group(r5)
            r3.e = r8
            java.util.HashMap<java.lang.String, java.lang.String> r4 = com.mbridge.msdk.mbsignalcommon.base.e.f4326k
            if (r4 == 0) goto L64
            boolean r8 = r4.containsKey(r8)
            if (r8 == 0) goto L64
            java.util.HashMap<java.lang.String, java.lang.String> r8 = com.mbridge.msdk.mbsignalcommon.base.e.f4326k
            java.lang.String r4 = r3.e
            java.lang.Object r8 = r8.get(r4)
            java.lang.String r8 = (java.lang.String) r8
            r3.e = r8
        L64:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r7.e
            r3.f4406b = r8
            goto L6a
        L69:
            r3 = r1
        L6a:
            if (r3 != 0) goto L6d
            goto Lc2
        L6d:
            com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView r8 = r3.f4406b
            if (r8 != 0) goto L72
            goto L78
        L72:
            java.lang.String r1 = r3.f4408d
            java.lang.Object r1 = r8.getJsObject(r1)
        L78:
            if (r1 != 0) goto L7b
            goto Lc2
        L7b:
            android.content.Context r8 = r7.f4428d     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.Class r4 = r1.getClass()     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            com.mbridge.msdk.mbsignalcommon.c.a$c r8 = com.mbridge.msdk.mbsignalcommon.c.a.a(r8, r4)     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.String r4 = r3.e     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.Class<java.lang.Object> r5 = java.lang.Object.class
            r6 = 0
            r0[r6] = r5     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r0[r2] = r5     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            com.mbridge.msdk.mbsignalcommon.c.a$d r8 = r8.a(r4, r0)     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            r8.a()     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            boolean r0 = r1 instanceof com.mbridge.msdk.mbsignalcommon.windvane.h     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            if (r0 == 0) goto Lc2
            r3.f4405a = r8     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            r3.f4407c = r1     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            android.os.Message r8 = android.os.Message.obtain()     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            r8.what = r2     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            r8.obj = r3     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            android.os.Handler r0 = r7.f     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            r0.sendMessage(r8)     // Catch: java.lang.Exception -> Lb7 com.mbridge.msdk.mbsignalcommon.c.a.b.C0038a -> Lb9
            return
        Lb7:
            r8 = move-exception
            goto Lbb
        Lb9:
            r8 = move-exception
            goto Lbf
        Lbb:
            r8.printStackTrace()
            goto Lc2
        Lbf:
            r8.printStackTrace()
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.mbsignalcommon.windvane.i.b(java.lang.String):void");
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        a aVar = (a) message.obj;
        if (aVar == null) {
            return false;
        }
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (message.what != 1) {
            return false;
        }
        Object obj = aVar.f4407c;
        a.d dVar = aVar.f4405a;
        if (dVar != null && obj != null) {
            dVar.a(obj, aVar, TextUtils.isEmpty(aVar.f) ? "{}" : aVar.f);
        }
        return true;
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.c
    public final void a(WindVaneWebView windVaneWebView) {
        this.e = windVaneWebView;
    }
}
