package com.mbridge.msdk.click.entity;

import androidx.annotation.NonNull;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f2804a;

    /* renamed from: b, reason: collision with root package name */
    public String f2805b;

    /* renamed from: c, reason: collision with root package name */
    public String f2806c;

    /* renamed from: d, reason: collision with root package name */
    public String f2807d;
    public int e;
    public int f;
    public String g;
    public String h;

    public final String a() {
        return "statusCode=" + this.f + ", location=" + this.f2804a + ", contentType=" + this.f2805b + ", contentLength=" + this.e + ", contentEncoding=" + this.f2806c + ", referer=" + this.f2807d;
    }

    @NonNull
    public final String toString() {
        StringBuilder sb = new StringBuilder("ClickResponseHeader{location='");
        sb.append(this.f2804a);
        sb.append("', contentType='");
        sb.append(this.f2805b);
        sb.append("', contentEncoding='");
        sb.append(this.f2806c);
        sb.append("', referer='");
        sb.append(this.f2807d);
        sb.append("', contentLength=");
        sb.append(this.e);
        sb.append(", statusCode=");
        sb.append(this.f);
        sb.append(", url='");
        sb.append(this.g);
        sb.append("', exception='");
        return a3.a.o(sb, this.h, "'}");
    }
}
