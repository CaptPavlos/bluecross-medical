package com.mbridge.msdk.thrid.okhttp;

import androidx.window.layout.c;
import com.google.android.material.card.MaterialCardViewHelper;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Response implements Closeable {
    final ResponseBody body;
    private volatile CacheControl cacheControl;
    final Response cacheResponse;
    final int code;
    final Handshake handshake;
    final Headers headers;
    final String message;
    final Response networkResponse;
    final Response priorResponse;
    final Protocol protocol;
    final long receivedResponseAtMillis;
    final Request request;
    final long sentRequestAtMillis;

    public Response(Builder builder) {
        this.request = builder.request;
        this.protocol = builder.protocol;
        this.code = builder.code;
        this.message = builder.message;
        this.handshake = builder.handshake;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.networkResponse = builder.networkResponse;
        this.cacheResponse = builder.cacheResponse;
        this.priorResponse = builder.priorResponse;
        this.sentRequestAtMillis = builder.sentRequestAtMillis;
        this.receivedResponseAtMillis = builder.receivedResponseAtMillis;
    }

    public ResponseBody body() {
        return this.body;
    }

    public CacheControl cacheControl() {
        CacheControl cacheControl = this.cacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControl2 = CacheControl.parse(this.headers);
        this.cacheControl = cacheControl2;
        return cacheControl2;
    }

    public Response cacheResponse() {
        return this.cacheResponse;
    }

    public List<Challenge> challenges() {
        String str;
        int i10 = this.code;
        if (i10 == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i10 != 407) {
                return Collections.EMPTY_LIST;
            }
            str = "Proxy-Authenticate";
        }
        return HttpHeaders.parseChallenges(headers(), str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody != null) {
            responseBody.close();
        } else {
            c.g("response is not eligible for a body and must not be closed");
        }
    }

    public int code() {
        return this.code;
    }

    public Handshake handshake() {
        return this.handshake;
    }

    public String header(String str, String str2) {
        String str3 = this.headers.get(str);
        return str3 != null ? str3 : str2;
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public boolean isRedirect() {
        int i10 = this.code;
        if (i10 == 307 || i10 == 308) {
            return true;
        }
        switch (i10) {
            case MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION /* 300 */:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public boolean isSuccessful() {
        int i10 = this.code;
        return i10 >= 200 && i10 < 300;
    }

    public String message() {
        return this.message;
    }

    public Response networkResponse() {
        return this.networkResponse;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public ResponseBody peekBody(long j10) throws IOException {
        BufferedSource bufferedSourceSource = this.body.source();
        bufferedSourceSource.request(j10);
        Buffer bufferM236clone = bufferedSourceSource.buffer().m236clone();
        if (bufferM236clone.size() > j10) {
            Buffer buffer = new Buffer();
            buffer.write(bufferM236clone, j10);
            bufferM236clone.clear();
            bufferM236clone = buffer;
        }
        return ResponseBody.create(this.body.contentType(), bufferM236clone.size(), bufferM236clone);
    }

    public Response priorResponse() {
        return this.priorResponse;
    }

    public Protocol protocol() {
        return this.protocol;
    }

    public long receivedResponseAtMillis() {
        return this.receivedResponseAtMillis;
    }

    public Request request() {
        return this.request;
    }

    public long sentRequestAtMillis() {
        return this.sentRequestAtMillis;
    }

    public String toString() {
        return "Response{protocol=" + this.protocol + ", code=" + this.code + ", message=" + this.message + ", url=" + this.request.url() + '}';
    }

    public Headers headers() {
        return this.headers;
    }

    public String header(String str) {
        return header(str, null);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder {
        ResponseBody body;
        Response cacheResponse;
        int code;
        Handshake handshake;
        Headers.Builder headers;
        String message;
        Response networkResponse;
        Response priorResponse;
        Protocol protocol;
        long receivedResponseAtMillis;
        Request request;
        long sentRequestAtMillis;

        public Builder(Response response) {
            this.code = -1;
            this.request = response.request;
            this.protocol = response.protocol;
            this.code = response.code;
            this.message = response.message;
            this.handshake = response.handshake;
            this.headers = response.headers.newBuilder();
            this.body = response.body;
            this.networkResponse = response.networkResponse;
            this.cacheResponse = response.cacheResponse;
            this.priorResponse = response.priorResponse;
            this.sentRequestAtMillis = response.sentRequestAtMillis;
            this.receivedResponseAtMillis = response.receivedResponseAtMillis;
        }

        private void checkPriorResponse(Response response) {
            if (response.body == null) {
                return;
            }
            a.n("priorResponse.body != null");
        }

        private void checkSupportResponse(String str, Response response) {
            if (response.body != null) {
                a.n(a3.a.C(str, ".body != null"));
                return;
            }
            if (response.networkResponse != null) {
                a.n(a3.a.C(str, ".networkResponse != null"));
            } else if (response.cacheResponse != null) {
                a.n(a3.a.C(str, ".cacheResponse != null"));
            } else {
                if (response.priorResponse == null) {
                    return;
                }
                a.n(a3.a.C(str, ".priorResponse != null"));
            }
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Builder body(ResponseBody responseBody) {
            this.body = responseBody;
            return this;
        }

        public Response build() {
            if (this.request == null) {
                c.g("request == null");
                return null;
            }
            if (this.protocol == null) {
                c.g("protocol == null");
                return null;
            }
            if (this.code < 0) {
                u.f(this.code, "code < 0: ");
                return null;
            }
            if (this.message != null) {
                return new Response(this);
            }
            c.g("message == null");
            return null;
        }

        public Builder cacheResponse(Response response) {
            if (response != null) {
                checkSupportResponse("cacheResponse", response);
            }
            this.cacheResponse = response;
            return this;
        }

        public Builder code(int i10) {
            this.code = i10;
            return this;
        }

        public Builder handshake(Handshake handshake) {
            this.handshake = handshake;
            return this;
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder message(String str) {
            this.message = str;
            return this;
        }

        public Builder networkResponse(Response response) {
            if (response != null) {
                checkSupportResponse("networkResponse", response);
            }
            this.networkResponse = response;
            return this;
        }

        public Builder priorResponse(Response response) {
            if (response != null) {
                checkPriorResponse(response);
            }
            this.priorResponse = response;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder receivedResponseAtMillis(long j10) {
            this.receivedResponseAtMillis = j10;
            return this;
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public Builder request(Request request) {
            this.request = request;
            return this;
        }

        public Builder sentRequestAtMillis(long j10) {
            this.sentRequestAtMillis = j10;
            return this;
        }

        public Builder() {
            this.code = -1;
            this.headers = new Headers.Builder();
        }
    }
}
