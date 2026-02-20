package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: com.mbridge.msdk.thrid.okhttp.Authenticator.1
        @Override // com.mbridge.msdk.thrid.okhttp.Authenticator
        public Request authenticate(Route route, Response response) {
            return null;
        }
    };

    Request authenticate(Route route, Response response) throws IOException;
}
