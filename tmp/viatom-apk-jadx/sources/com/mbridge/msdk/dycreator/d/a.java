package com.mbridge.msdk.dycreator.d;

import com.mbridge.msdk.dycreator.g.c;
import com.mbridge.msdk.dycreator.g.d;
import com.mbridge.msdk.dycreator.g.f;
import com.mbridge.msdk.dycreator.g.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f3242a;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.d.a$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f3243a;

        static {
            int[] iArr = new int[EnumC0024a.values().length];
            f3243a = iArr;
            try {
                iArr[EnumC0024a.VIEW_OBSERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3243a[EnumC0024a.CLICK_OBSERVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3243a[EnumC0024a.EFFECT_OBSERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3243a[EnumC0024a.REPORT_OBSERVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: com.mbridge.msdk.dycreator.d.a$a, reason: collision with other inner class name */
    public enum EnumC0024a {
        VIEW_OBSERVER,
        CLICK_OBSERVER,
        EFFECT_OBSERVER,
        REPORT_OBSERVER
    }

    private a() {
    }

    public final <T extends com.mbridge.msdk.dycreator.g.a> T a(EnumC0024a enumC0024a) {
        int i10 = AnonymousClass1.f3243a[enumC0024a.ordinal()];
        if (i10 == 1) {
            return new d();
        }
        if (i10 == 2) {
            return new c();
        }
        if (i10 == 3) {
            return new f();
        }
        if (i10 != 4) {
            return null;
        }
        return new h();
    }

    public static a a() {
        if (f3242a == null) {
            synchronized (a.class) {
                try {
                    if (f3242a == null) {
                        f3242a = new a();
                    }
                } finally {
                }
            }
        }
        return f3242a;
    }
}
