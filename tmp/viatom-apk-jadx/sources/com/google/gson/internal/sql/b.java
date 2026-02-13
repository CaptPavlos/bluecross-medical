package com.google.gson.internal.sql;

import com.google.gson.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean f2594a;

    /* renamed from: b, reason: collision with root package name */
    public static final j f2595b;

    /* renamed from: c, reason: collision with root package name */
    public static final j f2596c;

    /* renamed from: d, reason: collision with root package name */
    public static final j f2597d;

    static {
        boolean z9;
        try {
            Class.forName("java.sql.Date");
            z9 = true;
        } catch (ClassNotFoundException unused) {
            z9 = false;
        }
        f2594a = z9;
        if (z9) {
            f2595b = SqlDateTypeAdapter.f2588b;
            f2596c = SqlTimeTypeAdapter.f2590b;
            f2597d = SqlTimestampTypeAdapter.f2592b;
        } else {
            f2595b = null;
            f2596c = null;
            f2597d = null;
        }
    }
}
