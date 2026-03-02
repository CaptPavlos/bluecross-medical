package com.mbridge.msdk.newreward.function.g;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements InvocationHandler {

    /* renamed from: a, reason: collision with root package name */
    b f5019a;

    /* renamed from: b, reason: collision with root package name */
    private Object f5020b;

    public e(Object obj, com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.command.c cVar) {
        this.f5020b = obj;
        try {
            this.f5019a = new b(obj, eVar, cVar);
        } catch (Exception unused) {
            if (eVar.a() != null) {
                eVar.a().quitSafely();
            }
        }
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object objInvoke;
        try {
            objInvoke = method.invoke(this.f5020b, objArr);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            objInvoke = null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        b bVar = this.f5019a;
        if (bVar == null) {
            return objInvoke;
        }
        bVar.a(objInvoke, method, objArr);
        af.b("ReportHandler", "方法名：" + method.getName() + " 耗时为：" + String.valueOf(System.currentTimeMillis() - jCurrentTimeMillis));
        return objInvoke;
    }
}
