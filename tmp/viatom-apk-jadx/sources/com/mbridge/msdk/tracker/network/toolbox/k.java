package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.MediaType;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.RequestBody;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class k extends a {

    /* renamed from: a, reason: collision with root package name */
    private final OkHttpClient f5462a;

    public k() {
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        ThreadFactory threadFactory = Util.threadFactory("OkHttp Dispatcher", false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Dispatcher dispatcher = new Dispatcher(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, threadFactory));
        dispatcher.setMaxRequestsPerHost(50);
        dispatcher.setMaxRequests(256);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.readTimeout(30L, timeUnit);
        builder.connectTimeout(30L, timeUnit);
        builder.writeTimeout(30L, timeUnit);
        builder.retryOnConnectionFailure(true);
        builder.connectionPool(new ConnectionPool(32, 5L, TimeUnit.MINUTES));
        builder.dispatcher(dispatcher);
        this.f5462a = builder.build();
    }

    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public final g a(u<?> uVar, Map<String, String> map) throws IOException {
        q qVarZ = uVar.z();
        if (this.f5462a == null) {
            com.google.gson.internal.a.m("okhttp client is null");
            return null;
        }
        int iU = uVar.u() <= 0 ? 30000 : uVar.u();
        long jV = uVar.v();
        String strA = uVar.i() == 0 ? d.a(uVar.k(), uVar) : uVar.k();
        if (qVarZ != null) {
            qVarZ.a(strA);
            long j10 = iU;
            qVarZ.b(j10);
            qVarZ.c(j10);
            qVarZ.d(j10);
            qVarZ.j(uVar.g());
        }
        if (qVarZ != null) {
            try {
                qVarZ.i(uVar.q());
            } catch (Exception unused) {
            }
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(Protocol.HTTP_1_1);
        arrayList.add(Protocol.HTTP_2);
        OkHttpClient.Builder builderProtocols = this.f5462a.newBuilder().protocols(arrayList);
        long j11 = iU;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient.Builder builderCallTimeout = builderProtocols.readTimeout(j11, timeUnit).connectTimeout(j11, timeUnit).writeTimeout(j11, timeUnit).callTimeout(Math.max(jV, 0L), timeUnit);
        if (qVarZ != null && builderCallTimeout != null) {
            try {
                builderCallTimeout.eventListener(new OKHTTPEventListener(qVarZ));
            } catch (Exception unused2) {
            }
        }
        Request.Builder builder = new Request.Builder();
        for (Map.Entry<String, String> entry : uVar.c().entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }
        builder.addHeader("Connection", CampaignEx.JSON_NATIVE_VIDEO_CLOSE);
        switch (uVar.i()) {
            case 0:
                builder.get();
                break;
            case 1:
                RequestBody requestBodyA = a(uVar);
                if (requestBodyA == null) {
                    com.google.gson.internal.a.m("can't create request body for post");
                    return null;
                }
                builder.post(requestBodyA);
                break;
            case 2:
                RequestBody requestBodyA2 = a(uVar);
                if (requestBodyA2 == null) {
                    com.google.gson.internal.a.m("can't create request body for put");
                    return null;
                }
                builder.put(requestBodyA2);
                break;
            case 3:
                builder.delete();
                break;
            case 4:
                builder.head();
                break;
            case 5:
                builder.method("OPTIONS", null);
                break;
            case 6:
                builder.method("TRACE", null);
                break;
            case 7:
                RequestBody requestBodyA3 = a(uVar);
                if (requestBodyA3 == null) {
                    com.google.gson.internal.a.m("can't create request body for patch");
                    return null;
                }
                builder.patch(requestBodyA3);
                break;
            default:
                androidx.window.layout.c.g("Unknown method type.");
                return null;
        }
        Response responseExecute = builderCallTimeout.build().newCall(builder.url(strA).build()).execute();
        Headers headers = responseExecute.headers();
        ArrayList arrayList2 = new ArrayList();
        int size = headers.size();
        for (int i10 = 0; i10 < size; i10++) {
            String strName = headers.name(i10);
            String strValue = headers.value(i10);
            if (strName != null) {
                arrayList2.add(new com.mbridge.msdk.tracker.network.h(strName, strValue));
            }
        }
        ResponseBody responseBodyBody = responseExecute.body();
        if (responseBodyBody == null) {
            return new g(responseExecute.code(), arrayList2);
        }
        return new g(responseExecute.code(), arrayList2, responseBodyBody.contentLength() > 2147483647L ? -1 : (int) responseBodyBody.contentLength(), responseBodyBody.byteStream());
    }

    private static RequestBody a(u uVar) {
        byte[] bArrP;
        if (uVar == null || (bArrP = uVar.p()) == null) {
            return null;
        }
        return RequestBody.create((MediaType) null, bArrP);
    }
}
