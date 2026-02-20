package com.mbridge.msdk.dycreator.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import java.io.File;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static volatile f f3250a;

    /* renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.dycreator.a.b f3251b;

    private f(Context context) {
        this.f3251b = null;
        com.mbridge.msdk.dycreator.a.b bVarA = com.mbridge.msdk.dycreator.a.b.a();
        this.f3251b = bVarA;
        bVarA.a(context, "");
    }

    public final View a(ViewGroup viewGroup, String str) {
        if (viewGroup != null && !TextUtils.isEmpty(str)) {
            if (viewGroup.getId() == str.hashCode()) {
                return viewGroup;
            }
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (childAt.getId() == str.hashCode()) {
                    return childAt;
                }
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, str);
                }
            }
        }
        return null;
    }

    public final View a(String str) {
        if (new File(str).exists()) {
            return this.f3251b.f(str);
        }
        return null;
    }

    public static f a(Context context) {
        if (f3250a == null) {
            synchronized (f.class) {
                try {
                    if (f3250a == null) {
                        f3250a = new f(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f3250a;
    }
}
