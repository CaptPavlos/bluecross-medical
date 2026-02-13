package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.system.NoProGuard;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.Handshake;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.tracker.network.q;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public class OKHTTPEventListener extends EventListener implements NoProGuard {
    private static String TAG = "OKHTTPEventListener";
    private final q monitor;

    public OKHTTPEventListener(q qVar) {
        this.monitor = qVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void callEnd(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.a((IOException) null);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void callFailed(Call call, IOException iOException) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.a(iOException);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void callStart(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.a(call);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("connection_end");
        this.monitor.a(protocol, (IOException) null);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.a(protocol, iOException);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("connection_start");
        this.monitor.a(inetSocketAddress, proxy);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.a(connection);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("dns_end");
        this.monitor.a(list);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void dnsStart(Call call, String str) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("dns_start");
        this.monitor.a();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void requestBodyEnd(Call call, long j10) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("request_body_end");
        this.monitor.e(j10);
        this.monitor.d("transmission_start");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void requestBodyStart(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("request_body_start");
        this.monitor.c();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("request_header_end");
        this.monitor.a(request);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void requestHeadersStart(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("request_header_start");
        this.monitor.b();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void responseBodyEnd(Call call, long j10) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("response_body_end");
        this.monitor.h(j10);
        this.monitor.g(j10);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void responseBodyStart(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("response_body_start");
        this.monitor.e();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("response_header_end");
        this.monitor.a(response);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void responseHeadersStart(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("response_header_start");
        this.monitor.d();
        this.monitor.d("transmission_end");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("secure_connect_end");
        this.monitor.a(handshake);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void secureConnectStart(Call call) {
        q qVar = this.monitor;
        if (qVar == null) {
            return;
        }
        qVar.d("secure_connect_start");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.EventListener
    public void connectionReleased(Call call, Connection connection) {
    }
}
