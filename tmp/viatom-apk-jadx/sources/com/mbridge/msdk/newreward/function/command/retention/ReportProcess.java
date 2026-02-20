package com.mbridge.msdk.newreward.function.command.retention;

import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.command.retention.ReportAnnotation;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class ReportProcess {
    static e adapterModel;

    public static void init(e eVar) {
        adapterModel = eVar;
    }

    public static void reportProcessAtThisTime(Object obj) throws SecurityException {
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (!method.isAnnotationPresent(ReportAnnotation.MethodInfo.class)) {
                return;
            }
        }
    }
}
