package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okio.BufferedSource;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String str, long j10, BufferedSource bufferedSource) {
        this.contentTypeString = str;
        this.contentLength = j10;
        this.source = bufferedSource;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.ResponseBody
    public long contentLength() {
        return this.contentLength;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.ResponseBody
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.ResponseBody
    public BufferedSource source() {
        return this.source;
    }
}
