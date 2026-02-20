package com.mbridge.msdk.newreward.function.command.retention;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class AutoNewProcess {
    public static void bind(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        for (Field field : obj.getClass().getDeclaredFields()) {
            if (((AutoNew) field.getAnnotation(AutoNew.class)) != null) {
                field.setAccessible(true);
                try {
                    field.set(obj, field.getType().getConstructor(null).newInstance(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e3) {
                    e3.printStackTrace();
                } catch (NoSuchMethodException e7) {
                    e7.printStackTrace();
                } catch (InvocationTargetException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }
}
