package com.mbridge.msdk.mbsignalcommon.windvane;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public enum e {
    JS("js", "application/x-javascript"),
    CSS("css", "text/css"),
    JPG("jpg", "image/jpeg"),
    JPEG("jpep", "image/jpeg"),
    PNG("png", "image/png"),
    WEBP("webp", "image/webp"),
    GIF("gif", "image/gif"),
    HTM("htm", "text/html"),
    HTML("html", "text/html");


    /* renamed from: j, reason: collision with root package name */
    private String f4415j;

    /* renamed from: k, reason: collision with root package name */
    private String f4416k;

    e(String str, String str2) {
        this.f4415j = str;
        this.f4416k = str2;
    }

    public final String a() {
        return this.f4415j;
    }

    public final String b() {
        return this.f4416k;
    }
}
