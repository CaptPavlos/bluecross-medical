package com.mbridge.msdk.newreward.function.g;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.retention.BridgeParameter;
import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    Handler f5005a;

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Object> f5006b;

    /* renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f5007c;

    /* renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.command.c f5008d;

    public b(Object obj, com.mbridge.msdk.newreward.a.e eVar, com.mbridge.msdk.newreward.function.command.c cVar) {
        HandlerThread handlerThread;
        this.f5006b = new WeakReference<>(obj);
        this.f5007c = eVar;
        this.f5008d = cVar;
        if (eVar == null) {
            handlerThread = new HandlerThread("HandlerReportMessage");
            handlerThread.start();
        } else if (eVar.a() == null) {
            handlerThread = new HandlerThread("HandlerReportMessage");
            eVar.a(handlerThread);
            handlerThread.start();
        } else {
            handlerThread = eVar.a();
        }
        this.f5005a = new Handler(handlerThread.getLooper());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static /* synthetic */ void a(com.mbridge.msdk.newreward.function.g.b r20, java.lang.Object r21, java.lang.reflect.Method r22, java.lang.Object[] r23) throws java.lang.NoSuchMethodException, java.lang.SecurityException {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.newreward.function.g.b.a(com.mbridge.msdk.newreward.function.g.b, java.lang.Object, java.lang.reflect.Method, java.lang.Object[]):void");
    }

    private Map a(Object obj, String str, Object[] objArr) throws NoSuchMethodException, SecurityException {
        HashMap map = new HashMap();
        try {
            int length = objArr.length;
            Class<?>[] clsArr = new Class[length];
            for (int i10 = 0; i10 < length; i10++) {
                Object obj2 = objArr[i10];
                if (obj2 instanceof Integer) {
                    clsArr[i10] = Integer.TYPE;
                } else {
                    clsArr[i10] = obj2.getClass();
                }
            }
            Method method = obj.getClass().getMethod(str, clsArr);
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (int i11 = 0; i11 < parameterAnnotations.length; i11++) {
                int i12 = 0;
                while (true) {
                    Annotation[] annotationArr = parameterAnnotations[i11];
                    if (i12 < annotationArr.length) {
                        Annotation annotation = annotationArr[i12];
                        if (annotation instanceof BridgeParameter) {
                            String strKey = ((BridgeParameter) annotation).key();
                            Object obj3 = objArr[i11];
                            StringBuilder sb = new StringBuilder();
                            sb.append("ioc上报参数为：第");
                            int i13 = i11 + 1;
                            sb.append(i13);
                            sb.append("参数，第");
                            int i14 = i12 + 1;
                            sb.append(i14);
                            sb.append("个注解,Annotation.parametersKey=");
                            sb.append(strKey);
                            sb.append(", methodName->");
                            sb.append(method.getName());
                            af.b("HandlerReportMessage", sb.toString());
                            af.b("HandlerReportMessage", "ioc上报参数为：第" + i13 + "参数，第" + i14 + "个注解,Parameter.value=" + obj3);
                            map.put(strKey, obj3);
                        }
                        i12++;
                    }
                }
            }
            return map;
        } catch (Exception e) {
            af.b("HandlerReportMessage", e.getMessage());
            return map;
        }
    }

    public final void a(final Object obj, final Method method, final Object[] objArr) {
        CampaignEx campaignEx;
        Handler handler = this.f5005a;
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.mbridge.msdk.newreward.function.g.b.1
            @Override // java.lang.Runnable
            public final void run() throws SecurityException {
                try {
                    b.a(b.this, obj, method, objArr);
                } catch (NoSuchMethodException e) {
                    af.b("HandlerReportMessage", e.getMessage());
                }
            }
        });
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.f5007c;
            if (eVar != null && eVar.D() != null && this.f5007c.D().a() != null && !this.f5007c.D().a().isEmpty()) {
                List<CampaignEx> listA = this.f5007c.D().a();
                if (listA.isEmpty() || (campaignEx = listA.get(0)) == null || !campaignEx.isActiveOm()) {
                    return;
                }
                com.mbridge.msdk.newreward.function.command.c cVar = this.f5008d;
                com.mbridge.msdk.newreward.a.e eVar2 = this.f5007c;
                WeakReference<Object> weakReference = this.f5006b;
                cVar.a(cVar.a("adapter_model", eVar2, "methodName", method, "methodRep", obj, "args", objArr, TypedValues.AttributesType.S_TARGET, weakReference == null ? null : weakReference.get()), "OMSDKReceiver");
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
