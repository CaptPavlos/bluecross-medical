package com.mbridge.msdk.thrid.okhttp;

import androidx.browser.trusted.sharing.ShareTarget;
import androidx.window.layout.c;
import com.google.gson.internal.a;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpMethod;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Request {
    final RequestBody body;
    private volatile CacheControl cacheControl;
    final Headers headers;
    final String method;
    final Map<Class<?>, Object> tags;
    final HttpUrl url;

    public Request(Builder builder) {
        this.url = builder.url;
        this.method = builder.method;
        this.headers = builder.headers.build();
        this.body = builder.body;
        this.tags = Util.immutableMap(builder.tags);
    }

    public RequestBody body() {
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

    public String header(String str) {
        return this.headers.get(str);
    }

    public List<String> headers(String str) {
        return this.headers.values(str);
    }

    public boolean isHttps() {
        return this.url.isHttps();
    }

    public String method() {
        return this.method;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public <T> T tag(Class<? extends T> cls) {
        return cls.cast(this.tags.get(cls));
    }

    public String toString() {
        return "Request{method=" + this.method + ", url=" + this.url + ", tags=" + this.tags + '}';
    }

    public HttpUrl url() {
        return this.url;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Builder {
        RequestBody body;
        Headers.Builder headers;
        String method;
        Map<Class<?>, Object> tags;
        HttpUrl url;

        public Builder(Request request) {
            Map<Class<?>, Object> map = Collections.EMPTY_MAP;
            this.tags = map;
            this.url = request.url;
            this.method = request.method;
            this.body = request.body;
            this.tags = request.tags.isEmpty() ? map : new LinkedHashMap<>(request.tags);
            this.headers = request.headers.newBuilder();
        }

        public Builder addHeader(String str, String str2) {
            this.headers.add(str, str2);
            return this;
        }

        public Request build() {
            if (this.url != null) {
                return new Request(this);
            }
            c.g("url == null");
            return null;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            String string = cacheControl.toString();
            return string.isEmpty() ? removeHeader("Cache-Control") : header("Cache-Control", string);
        }

        public Builder delete(RequestBody requestBody) {
            return method("DELETE", requestBody);
        }

        public Builder get() {
            return method(ShareTarget.METHOD_GET, null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder header(String str, String str2) {
            this.headers.set(str, str2);
            return this;
        }

        public Builder headers(Headers headers) {
            this.headers = headers.newBuilder();
            return this;
        }

        public Builder method(String str, RequestBody requestBody) {
            if (str == null) {
                c.k("method == null");
                return null;
            }
            if (str.length() == 0) {
                a.n("method.length() == 0");
                return null;
            }
            if (requestBody != null && !HttpMethod.permitsRequestBody(str)) {
                a.n(androidx.constraintlayout.core.widgets.analyzer.a.x("method ", str, " must not have a request body."));
                return null;
            }
            if (requestBody == null && HttpMethod.requiresRequestBody(str)) {
                a.n(androidx.constraintlayout.core.widgets.analyzer.a.x("method ", str, " must have a request body."));
                return null;
            }
            this.method = str;
            this.body = requestBody;
            return this;
        }

        public Builder patch(RequestBody requestBody) {
            return method("PATCH", requestBody);
        }

        public Builder post(RequestBody requestBody) {
            return method(ShareTarget.METHOD_POST, requestBody);
        }

        public Builder put(RequestBody requestBody) {
            return method("PUT", requestBody);
        }

        public Builder removeHeader(String str) {
            this.headers.removeAll(str);
            return this;
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            if (cls == null) {
                c.k("type == null");
                return null;
            }
            Map<Class<?>, Object> map = this.tags;
            if (t == null) {
                map.remove(cls);
                return this;
            }
            if (map.isEmpty()) {
                this.tags = new LinkedHashMap();
            }
            this.tags.put(cls, cls.cast(t));
            return this;
        }

        public Builder url(String str) {
            if (str != null) {
                return url(HttpUrl.get(str.regionMatches(true, 0, "ws:", 0, 3) ? "http:".concat(str.substring(3)) : str.regionMatches(true, 0, "wss:", 0, 4) ? "https:".concat(str.substring(4)) : str));
            }
            c.k("url == null");
            return null;
        }

        public Builder delete() {
            return delete(Util.EMPTY_REQUEST);
        }

        public Builder tag(Object obj) {
            return tag(Object.class, obj);
        }

        public Builder() {
            this.tags = Collections.EMPTY_MAP;
            this.method = ShareTarget.METHOD_GET;
            this.headers = new Headers.Builder();
        }

        public Builder url(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.url = httpUrl;
                return this;
            }
            c.k("url == null");
            return null;
        }

        public Builder url(URL url) {
            if (url != null) {
                return url(HttpUrl.get(url.toString()));
            }
            c.k("url == null");
            return null;
        }
    }

    public Headers headers() {
        return this.headers;
    }

    public Object tag() {
        return tag(Object.class);
    }
}
