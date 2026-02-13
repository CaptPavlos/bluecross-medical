package com.google.gson;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    public static final a f2448d = new a("", "", false);

    /* renamed from: a, reason: collision with root package name */
    public final String f2449a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2450b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f2451c;

    static {
        new a("\n", "  ", true);
    }

    public a(String str, String str2, boolean z9) {
        if (!str.matches("[\r\n]*")) {
            com.google.gson.internal.a.n("Only combinations of \\n and \\r are allowed in newline.");
            throw null;
        }
        if (!str2.matches("[ \t]*")) {
            com.google.gson.internal.a.n("Only combinations of spaces and tabs are allowed in indent.");
            throw null;
        }
        this.f2449a = str;
        this.f2450b = str2;
        this.f2451c = z9;
    }
}
