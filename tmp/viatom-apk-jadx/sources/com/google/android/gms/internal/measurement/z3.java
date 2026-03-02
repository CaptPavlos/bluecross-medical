package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class z3 {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f2277a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f2278b;

    /* renamed from: c, reason: collision with root package name */
    public static final Pattern f2279c;

    static {
        Uri.parse("content://com.google.android.gsf.gservices/prefix");
        f2278b = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        f2279c = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    }
}
