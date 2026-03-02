package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.thrid.okhttp.CacheControl;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.internal.Internal;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpDate;
import com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class CacheStrategy {
    public final Response cacheResponse;
    public final Request networkRequest;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class Factory {
        private int ageSeconds;
        final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        final long nowMillis;
        private long receivedResponseMillis;
        final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long j10, Request request, Response response) {
            this.ageSeconds = -1;
            this.nowMillis = j10;
            this.request = request;
            this.cacheResponse = response;
            if (response != null) {
                this.sentRequestMillis = response.sentRequestAtMillis();
                this.receivedResponseMillis = response.receivedResponseAtMillis();
                Headers headers = response.headers();
                int size = headers.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String strName = headers.name(i10);
                    String strValue = headers.value(i10);
                    if ("Date".equalsIgnoreCase(strName)) {
                        this.servedDate = HttpDate.parse(strValue);
                        this.servedDateString = strValue;
                    } else if ("Expires".equalsIgnoreCase(strName)) {
                        this.expires = HttpDate.parse(strValue);
                    } else if ("Last-Modified".equalsIgnoreCase(strName)) {
                        this.lastModified = HttpDate.parse(strValue);
                        this.lastModifiedString = strValue;
                    } else if (Command.HTTP_HEADER_ETAG.equalsIgnoreCase(strName)) {
                        this.etag = strValue;
                    } else if ("Age".equalsIgnoreCase(strName)) {
                        this.ageSeconds = HttpHeaders.parseSeconds(strValue, -1);
                    }
                }
            }
        }

        private long cacheResponseAge() {
            Date date = this.servedDate;
            long jMax = date != null ? Math.max(0L, this.receivedResponseMillis - date.getTime()) : 0L;
            int i10 = this.ageSeconds;
            if (i10 != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(i10));
            }
            long j10 = this.receivedResponseMillis;
            return jMax + (j10 - this.sentRequestMillis) + (this.nowMillis - j10);
        }

        private long computeFreshnessLifetime() {
            if (this.cacheResponse.cacheControl().maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.maxAgeSeconds());
            }
            if (this.expires != null) {
                Date date = this.servedDate;
                long time = this.expires.getTime() - (date != null ? date.getTime() : this.receivedResponseMillis);
                if (time > 0) {
                    return time;
                }
                return 0L;
            }
            if (this.lastModified != null && this.cacheResponse.request().url().query() == null) {
                Date date2 = this.servedDate;
                long time2 = (date2 != null ? date2.getTime() : this.sentRequestMillis) - this.lastModified.getTime();
                if (time2 > 0) {
                    return time2 / 10;
                }
            }
            return 0L;
        }

        private CacheStrategy getCandidate() {
            String str;
            Response response = this.cacheResponse;
            Request request = this.request;
            if (response == null) {
                return new CacheStrategy(request, null);
            }
            if (request.isHttps() && this.cacheResponse.handshake() == null) {
                return new CacheStrategy(this.request, null);
            }
            boolean zIsCacheable = CacheStrategy.isCacheable(this.cacheResponse, this.request);
            Request request2 = this.request;
            if (!zIsCacheable) {
                return new CacheStrategy(request2, null);
            }
            CacheControl cacheControl = request2.cacheControl();
            if (cacheControl.noCache() || hasConditions(this.request)) {
                return new CacheStrategy(this.request, null);
            }
            CacheControl cacheControl2 = this.cacheResponse.cacheControl();
            long jCacheResponseAge = cacheResponseAge();
            long jComputeFreshnessLifetime = computeFreshnessLifetime();
            int iMaxAgeSeconds = cacheControl.maxAgeSeconds();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            if (iMaxAgeSeconds != -1) {
                jComputeFreshnessLifetime = Math.min(jComputeFreshnessLifetime, timeUnit.toMillis(cacheControl.maxAgeSeconds()));
            }
            long millis = 0;
            long millis2 = cacheControl.minFreshSeconds() != -1 ? timeUnit.toMillis(cacheControl.minFreshSeconds()) : 0L;
            if (!cacheControl2.mustRevalidate() && cacheControl.maxStaleSeconds() != -1) {
                millis = timeUnit.toMillis(cacheControl.maxStaleSeconds());
            }
            if (!cacheControl2.noCache()) {
                long j10 = millis2 + jCacheResponseAge;
                if (j10 < millis + jComputeFreshnessLifetime) {
                    Response.Builder builderNewBuilder = this.cacheResponse.newBuilder();
                    if (j10 >= jComputeFreshnessLifetime) {
                        builderNewBuilder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jCacheResponseAge > 86400000 && isFreshnessLifetimeHeuristic()) {
                        builderNewBuilder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builderNewBuilder.build());
                }
            }
            String str2 = this.etag;
            if (str2 != null) {
                str = "If-None-Match";
            } else {
                str = "If-Modified-Since";
                if (this.lastModified != null) {
                    str2 = this.lastModifiedString;
                } else {
                    if (this.servedDate == null) {
                        return new CacheStrategy(this.request, null);
                    }
                    str2 = this.servedDateString;
                }
            }
            Headers.Builder builderNewBuilder2 = this.request.headers().newBuilder();
            Internal.instance.addLenient(builderNewBuilder2, str, str2);
            return new CacheStrategy(this.request.newBuilder().headers(builderNewBuilder2.build()).build(), this.cacheResponse);
        }

        private static boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }

        private boolean isFreshnessLifetimeHeuristic() {
            return this.cacheResponse.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        public CacheStrategy get() {
            CacheStrategy candidate = getCandidate();
            return (candidate.networkRequest == null || !this.request.cacheControl().onlyIfCached()) ? candidate : new CacheStrategy(null, null);
        }
    }

    public CacheStrategy(Request request, Response response) {
        this.networkRequest = request;
        this.cacheResponse = response;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        if (r3.cacheControl().isPrivate() == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isCacheable(com.mbridge.msdk.thrid.okhttp.Response r3, com.mbridge.msdk.thrid.okhttp.Request r4) {
        /*
            int r0 = r3.code()
            r1 = 200(0xc8, float:2.8E-43)
            r2 = 0
            if (r0 == r1) goto L5a
            r1 = 410(0x19a, float:5.75E-43)
            if (r0 == r1) goto L5a
            r1 = 414(0x19e, float:5.8E-43)
            if (r0 == r1) goto L5a
            r1 = 501(0x1f5, float:7.02E-43)
            if (r0 == r1) goto L5a
            r1 = 203(0xcb, float:2.84E-43)
            if (r0 == r1) goto L5a
            r1 = 204(0xcc, float:2.86E-43)
            if (r0 == r1) goto L5a
            r1 = 307(0x133, float:4.3E-43)
            if (r0 == r1) goto L31
            r1 = 308(0x134, float:4.32E-43)
            if (r0 == r1) goto L5a
            r1 = 404(0x194, float:5.66E-43)
            if (r0 == r1) goto L5a
            r1 = 405(0x195, float:5.68E-43)
            if (r0 == r1) goto L5a
            switch(r0) {
                case 300: goto L5a;
                case 301: goto L5a;
                case 302: goto L31;
                default: goto L30;
            }
        L30:
            goto L59
        L31:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.header(r0)
            if (r0 != 0) goto L5a
            com.mbridge.msdk.thrid.okhttp.CacheControl r0 = r3.cacheControl()
            int r0 = r0.maxAgeSeconds()
            r1 = -1
            if (r0 != r1) goto L5a
            com.mbridge.msdk.thrid.okhttp.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPublic()
            if (r0 != 0) goto L5a
            com.mbridge.msdk.thrid.okhttp.CacheControl r0 = r3.cacheControl()
            boolean r0 = r0.isPrivate()
            if (r0 == 0) goto L59
            goto L5a
        L59:
            return r2
        L5a:
            com.mbridge.msdk.thrid.okhttp.CacheControl r3 = r3.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L70
            com.mbridge.msdk.thrid.okhttp.CacheControl r3 = r4.cacheControl()
            boolean r3 = r3.noStore()
            if (r3 != 0) goto L70
            r3 = 1
            return r3
        L70:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache.CacheStrategy.isCacheable(com.mbridge.msdk.thrid.okhttp.Response, com.mbridge.msdk.thrid.okhttp.Request):boolean");
    }
}
