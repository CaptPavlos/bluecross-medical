package com.mbridge.msdk.newreward.player.apt_api;

import android.app.Activity;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class AptApi {
    public static void bind(Activity activity) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Class.forName(activity.getClass().getCanonicalName() + "BindingGroup").getDeclaredConstructor(activity.getClass()).newInstance(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
