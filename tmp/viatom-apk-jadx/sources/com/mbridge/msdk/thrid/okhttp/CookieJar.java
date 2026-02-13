package com.mbridge.msdk.thrid.okhttp;

import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public interface CookieJar {
    public static final CookieJar NO_COOKIES = new CookieJar() { // from class: com.mbridge.msdk.thrid.okhttp.CookieJar.1
        @Override // com.mbridge.msdk.thrid.okhttp.CookieJar
        public List<Cookie> loadForRequest(HttpUrl httpUrl) {
            return Collections.EMPTY_LIST;
        }

        @Override // com.mbridge.msdk.thrid.okhttp.CookieJar
        public void saveFromResponse(HttpUrl httpUrl, List<Cookie> list) {
        }
    };

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);
}
