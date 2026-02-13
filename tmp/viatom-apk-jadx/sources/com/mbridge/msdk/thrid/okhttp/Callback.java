package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
