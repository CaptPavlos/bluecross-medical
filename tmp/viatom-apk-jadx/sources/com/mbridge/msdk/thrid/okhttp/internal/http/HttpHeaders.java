package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.mbridge.msdk.thrid.okhttp.Challenge;
import com.mbridge.msdk.thrid.okhttp.Cookie;
import com.mbridge.msdk.thrid.okhttp.CookieJar;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.HttpUrl;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import p8.u;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get("Content-Length"));
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0079, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void parseChallengeHeader(java.util.List<com.mbridge.msdk.thrid.okhttp.Challenge> r8, com.mbridge.msdk.thrid.okio.Buffer r9) {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Lf
            skipWhitespaceAndCommas(r9)
            java.lang.String r1 = readToken(r9)
            if (r1 != 0) goto Lf
            goto Lc0
        Lf:
            boolean r2 = skipWhitespaceAndCommas(r9)
            java.lang.String r3 = readToken(r9)
            if (r3 != 0) goto L2c
            boolean r9 = r9.exhausted()
            if (r9 != 0) goto L21
            goto Lc0
        L21:
            com.mbridge.msdk.thrid.okhttp.Challenge r9 = new com.mbridge.msdk.thrid.okhttp.Challenge
            java.util.Map r0 = java.util.Collections.EMPTY_MAP
            r9.<init>(r1, r0)
            r8.add(r9)
            return
        L2c:
            r4 = 61
            int r5 = skipAll(r9, r4)
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r2 != 0) goto L5c
            if (r6 != 0) goto L40
            boolean r2 = r9.exhausted()
            if (r2 == 0) goto L5c
        L40:
            com.mbridge.msdk.thrid.okhttp.Challenge r2 = new com.mbridge.msdk.thrid.okhttp.Challenge
            java.lang.StringBuilder r3 = a3.a.v(r3)
            java.lang.String r4 = repeat(r4, r5)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L5c:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = skipAll(r9, r4)
            int r5 = r5 + r6
        L66:
            if (r3 != 0) goto L77
            java.lang.String r3 = readToken(r9)
            boolean r5 = skipWhitespaceAndCommas(r9)
            if (r5 == 0) goto L73
            goto L79
        L73:
            int r5 = skipAll(r9, r4)
        L77:
            if (r5 != 0) goto L84
        L79:
            com.mbridge.msdk.thrid.okhttp.Challenge r4 = new com.mbridge.msdk.thrid.okhttp.Challenge
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        L84:
            r6 = 1
            if (r5 <= r6) goto L88
            goto Lc0
        L88:
            boolean r6 = skipWhitespaceAndCommas(r9)
            if (r6 == 0) goto L8f
            goto Lc0
        L8f:
            boolean r6 = r9.exhausted()
            if (r6 != 0) goto La4
            r6 = 0
            byte r6 = r9.getByte(r6)
            r7 = 34
            if (r6 != r7) goto La4
            java.lang.String r6 = readQuotedString(r9)
            goto La8
        La4:
            java.lang.String r6 = readToken(r9)
        La8:
            if (r6 != 0) goto Lab
            goto Lc0
        Lab:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lb4
            goto Lc0
        Lb4:
            boolean r3 = skipWhitespaceAndCommas(r9)
            if (r3 != 0) goto Lc1
            boolean r3 = r9.exhausted()
            if (r3 != 0) goto Lc1
        Lc0:
            return
        Lc1:
            r3 = r0
            goto L66
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.http.HttpHeaders.parseChallengeHeader(java.util.List, com.mbridge.msdk.thrid.okio.Buffer):void");
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < headers.size(); i10++) {
            if (str.equalsIgnoreCase(headers.name(i10))) {
                parseChallengeHeader(arrayList, new Buffer().writeUtf8(headers.value(i10)));
            }
        }
        return arrayList;
    }

    public static int parseSeconds(String str, int i10) throws NumberFormatException {
        try {
            long j10 = Long.parseLong(str);
            if (j10 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j10 < 0) {
                return 0;
            }
            return (int) j10;
        } catch (NumberFormatException unused) {
            return i10;
        }
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.readByte() != 34) {
            f.a();
            return null;
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == 34) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (jIndexOfElement == -1) {
                jIndexOfElement = buffer.size();
            }
            if (jIndexOfElement != 0) {
                return buffer.readUtf8(jIndexOfElement);
            }
            return null;
        } catch (EOFException unused) {
            u.m();
            return null;
        }
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static String repeat(char c10, int i10) {
        char[] cArr = new char[i10];
        Arrays.fill(cArr, c10);
        return new String(cArr);
    }

    private static int skipAll(Buffer buffer, byte b10) {
        int i10 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b10) {
            i10++;
            buffer.readByte();
        }
        return i10;
    }

    public static int skipUntil(String str, int i10, String str2) {
        while (i10 < str.length() && str2.indexOf(str.charAt(i10)) == -1) {
            i10++;
        }
        return i10;
    }

    public static int skipWhitespace(String str, int i10) {
        char cCharAt;
        while (i10 < str.length() && ((cCharAt = str.charAt(i10)) == ' ' || cCharAt == '\t')) {
            i10++;
        }
        return i10;
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean z9 = false;
        while (!buffer.exhausted()) {
            byte b10 = buffer.getByte(0L);
            if (b10 != 44) {
                if (b10 != 32 && b10 != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z9 = true;
            }
        }
        return z9;
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> treeSet = Collections.EMPTY_SET;
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            if ("Vary".equalsIgnoreCase(headers.name(i10))) {
                String strValue = headers.value(i10);
                if (treeSet.isEmpty()) {
                    treeSet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strValue.split(",")) {
                    treeSet.add(str.trim());
                }
            }
        }
        return treeSet;
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> setVaryFields = varyFields(headers2);
        if (setVaryFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strName = headers.name(i10);
            if (setVaryFields.contains(strName)) {
                builder.add(strName, headers.value(i10));
            }
        }
        return builder.build();
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }
}
