package com.mbridge.msdk.tracker.network.toolbox;

import androidx.browser.trusted.sharing.ShareTarget;
import com.mbridge.msdk.tracker.network.u;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends com.mbridge.msdk.tracker.network.toolbox.a {

    /* renamed from: a, reason: collision with root package name */
    private final b f5457a;

    /* renamed from: b, reason: collision with root package name */
    private final SSLSocketFactory f5458b;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static class a extends FilterInputStream {

        /* renamed from: a, reason: collision with root package name */
        private final HttpURLConnection f5459a;

        public a(HttpURLConnection httpURLConnection) {
            super(h.b(httpURLConnection));
            this.f5459a = httpURLConnection;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public final void close() throws IOException {
            super.close();
            this.f5459a.disconnect();
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface b extends m {
    }

    private h(b bVar, SSLSocketFactory sSLSocketFactory) {
        this.f5457a = bVar;
        this.f5458b = sSLSocketFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputStream b(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public final g a(u<?> uVar, Map<String, String> map) throws Throwable {
        SSLSocketFactory sSLSocketFactory;
        String strA = uVar.i() == 0 ? d.a(uVar.k(), uVar) : uVar.k();
        HashMap map2 = new HashMap();
        map2.putAll(map);
        map2.putAll(uVar.c());
        b bVar = this.f5457a;
        if (bVar != null) {
            String strA2 = bVar.a(strA);
            if (strA2 == null) {
                com.google.gson.internal.a.m(a3.a.i("URL blocked by rewriter: ", strA));
                return null;
            }
            strA = strA2;
        }
        URL url = new URL(strA);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int iU = uVar.u();
        httpURLConnection.setConnectTimeout(iU);
        httpURLConnection.setReadTimeout(iU);
        boolean z9 = false;
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        if ("https".equals(url.getProtocol()) && (sSLSocketFactory = this.f5458b) != null) {
            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
        }
        try {
            for (String str : map2.keySet()) {
                httpURLConnection.setRequestProperty(str, (String) map2.get(str));
            }
            switch (uVar.i()) {
                case 0:
                    httpURLConnection.setRequestMethod(ShareTarget.METHOD_GET);
                    break;
                case 1:
                    httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                    a(httpURLConnection, uVar);
                    break;
                case 2:
                    httpURLConnection.setRequestMethod("PUT");
                    a(httpURLConnection, uVar);
                    break;
                case 3:
                    httpURLConnection.setRequestMethod("DELETE");
                    break;
                case 4:
                    httpURLConnection.setRequestMethod("HEAD");
                    break;
                case 5:
                    httpURLConnection.setRequestMethod("OPTIONS");
                    break;
                case 6:
                    httpURLConnection.setRequestMethod("TRACE");
                    break;
                case 7:
                    httpURLConnection.setRequestMethod("PATCH");
                    a(httpURLConnection, uVar);
                    break;
                default:
                    throw new IllegalStateException("Unknown method type.");
            }
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == -1) {
                throw new IOException("Could not retrieve response code from HttpUrlConnection.");
            }
            if (uVar.i() == 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304)) {
                g gVar = new g(responseCode, a(httpURLConnection.getHeaderFields()));
                httpURLConnection.disconnect();
                return gVar;
            }
            try {
                return new g(responseCode, a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new a(httpURLConnection));
            } catch (Throwable th) {
                th = th;
                z9 = true;
                if (!z9) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private h(b bVar) {
        this(bVar, null);
    }

    public h() {
        this(null);
    }

    private static List<com.mbridge.msdk.tracker.network.h> a(Map<String, List<String>> map) {
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (entry.getKey() != null) {
                Iterator<String> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    arrayList.add(new com.mbridge.msdk.tracker.network.h(entry.getKey(), it.next()));
                }
            }
        }
        return arrayList;
    }

    private void a(HttpURLConnection httpURLConnection, u<?> uVar) throws IOException {
        byte[] bArrP = uVar.p();
        if (bArrP != null) {
            a(httpURLConnection, uVar, bArrP);
        }
    }

    private void a(HttpURLConnection httpURLConnection, u<?> uVar, byte[] bArr) throws IOException {
        httpURLConnection.setDoOutput(true);
        if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
            httpURLConnection.setRequestProperty("Content-Type", uVar.o());
        }
        int length = bArr.length;
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.close();
    }
}
