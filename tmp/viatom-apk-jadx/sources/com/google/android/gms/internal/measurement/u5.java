package com.google.android.gms.internal.measurement;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class u5 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f2192a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2193b;

    static {
        Charset.forName(C.ASCII_NAME);
        f2192a = Charset.forName(C.UTF8_NAME);
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2193b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
