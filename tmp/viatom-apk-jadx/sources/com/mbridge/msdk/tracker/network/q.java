package com.mbridge.msdk.tracker.network;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.Connection;
import com.mbridge.msdk.thrid.okhttp.Handshake;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.Route;
import com.mbridge.msdk.thrid.okhttp.TlsVersion;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q {
    private volatile long A;
    private volatile long B;
    private volatile long C;
    private volatile long D;
    private volatile long E;
    private volatile long F;
    private volatile long G;
    private volatile List<InetAddress> H;
    private volatile InetSocketAddress I;
    private volatile Proxy J;
    private volatile Handshake K;
    private volatile Protocol L;
    private volatile IOException M;
    private volatile Exception O;
    private long Q;
    private long R;
    private long S;
    private long T;

    /* renamed from: d, reason: collision with root package name */
    private volatile String f5426d;
    private volatile long f;

    /* renamed from: j, reason: collision with root package name */
    private volatile String f5428j;

    /* renamed from: k, reason: collision with root package name */
    private volatile String f5429k;

    /* renamed from: s, reason: collision with root package name */
    private volatile long f5437s;
    private volatile long t;

    /* renamed from: u, reason: collision with root package name */
    private volatile IOException f5438u;

    /* renamed from: v, reason: collision with root package name */
    private volatile long f5439v;

    /* renamed from: w, reason: collision with root package name */
    private volatile long f5440w;

    /* renamed from: x, reason: collision with root package name */
    private volatile long f5441x;
    private volatile long y;

    /* renamed from: z, reason: collision with root package name */
    private volatile long f5442z;

    /* renamed from: a, reason: collision with root package name */
    protected volatile String f5423a = "";

    /* renamed from: b, reason: collision with root package name */
    private volatile String f5424b = "";

    /* renamed from: c, reason: collision with root package name */
    private volatile String f5425c = "";
    private volatile String e = "";
    private volatile int g = -1;
    private volatile String h = "";

    /* renamed from: i, reason: collision with root package name */
    private volatile int f5427i = -1;

    /* renamed from: l, reason: collision with root package name */
    private volatile String f5430l = "okhttp";

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f5431m = false;

    /* renamed from: n, reason: collision with root package name */
    private final AtomicInteger f5432n = new AtomicInteger(0);

    /* renamed from: o, reason: collision with root package name */
    private volatile String f5433o = "";

    /* renamed from: p, reason: collision with root package name */
    private volatile long f5434p = 0;

    /* renamed from: q, reason: collision with root package name */
    private volatile long f5435q = 0;

    /* renamed from: r, reason: collision with root package name */
    private volatile long f5436r = 0;
    private volatile boolean N = false;
    private volatile boolean P = false;

    public q(String str, String str2) {
        this.f5426d = "";
        this.f5428j = "un_known";
        this.f5429k = "";
        this.f5428j = str;
        this.f5429k = str2;
        this.f5426d = UUID.randomUUID().toString();
    }

    private String g() {
        return TextUtils.isEmpty(this.f5425c) ? "" : this.f5425c;
    }

    private String h() {
        return TextUtils.isEmpty(this.f5424b) ? "" : this.f5424b;
    }

    private String i() {
        return TextUtils.isEmpty(this.f5426d) ? "" : this.f5426d;
    }

    private String k() {
        try {
            return TextUtils.isEmpty(this.f5423a) ? "" : URLEncoder.encode(this.f5423a, C.UTF8_NAME);
        } catch (UnsupportedEncodingException unused) {
            return "";
        }
    }

    private String l() {
        return TextUtils.isEmpty(this.f5428j) ? "un_known" : this.f5428j;
    }

    private String m() {
        return TextUtils.isEmpty(this.f5429k) ? "" : this.f5429k;
    }

    private int n() {
        return this.f5432n.getAndAdd(0);
    }

    private String o() {
        if (this.H == null || this.H.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < this.H.size(); i10++) {
            try {
                InetAddress inetAddress = this.H.get(i10);
                if (inetAddress != null) {
                    sb.append(inetAddress.getHostAddress());
                    if (i10 != this.H.size() - 1) {
                        sb.append(",");
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getDnsResult ", e);
                }
            }
        }
        return sb.toString();
    }

    private String p() {
        if (this.I != null) {
            try {
                InetAddress address = this.I.getAddress();
                if (address == null) {
                    return "";
                }
                String hostAddress = address.getHostAddress();
                return TextUtils.isEmpty(hostAddress) ? "" : hostAddress;
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getAddress ", e);
                }
            }
        }
        return "";
    }

    private String q() {
        if (this.K != null) {
            try {
                TlsVersion tlsVersion = this.K.tlsVersion();
                return tlsVersion == null ? "" : tlsVersion.javaName();
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "getTlsVersion ", e);
                }
            }
        }
        return "";
    }

    private String r() {
        try {
            if (this.M != null) {
                String name = this.M.getClass().getName();
                String message = this.M.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    return a("connection: %s ", name, message);
                }
            }
            if (this.f5438u != null) {
                String name2 = this.f5438u.getClass().getName();
                String message2 = this.f5438u.getMessage();
                if (!TextUtils.isEmpty(message2)) {
                    return a("call: %s ", name2, message2);
                }
            }
            if (this.O == null) {
                return "un_known";
            }
            String name3 = this.O.getClass().getName();
            String message3 = this.O.getMessage();
            return !TextUtils.isEmpty(message3) ? a("error: %s ", name3, message3) : "un_known";
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return "un_known";
            }
            af.b("NetworkMonitor", "getError ", e);
            return "un_known";
        }
    }

    public final void a(IOException iOException) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.t = jElapsedRealtime;
        this.f5438u = iOException;
        if (iOException != null) {
            if (this.f5439v == 0) {
                this.f5439v = jElapsedRealtime;
            }
            if (this.f5440w == 0) {
                this.f5440w = jElapsedRealtime;
            }
            if (this.f5441x == 0) {
                this.f5441x = jElapsedRealtime;
            }
            if (this.y == 0) {
                this.y = jElapsedRealtime;
            }
            if (this.f5442z == 0) {
                this.f5442z = jElapsedRealtime;
            }
            if (this.A == 0) {
                this.A = jElapsedRealtime;
            }
            if (this.B == 0) {
                this.B = jElapsedRealtime;
            }
            if (this.C == 0) {
                this.C = jElapsedRealtime;
            }
            if (this.D == 0) {
                this.D = jElapsedRealtime;
            }
            if (this.E == 0) {
                this.E = jElapsedRealtime;
            }
            if (this.F == 0) {
                this.F = jElapsedRealtime;
            }
            if (this.G == 0) {
                this.G = jElapsedRealtime;
            }
        }
    }

    public final void b(int i10) {
        Proxy.Type type;
        this.g = i10;
        if (this.P) {
            this.P = false;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "m_request_end");
                jSONObject.put("uuid", i());
                jSONObject.put("request_uuid", j());
                jSONObject.put("url", k());
                jSONObject.put("timeout", this.Q);
                jSONObject.put("timeout_connection", this.R);
                jSONObject.put("timeout_read", this.S);
                jSONObject.put("timeout_write", this.T);
                jSONObject.put("scene", l());
                jSONObject.put("lrid", h());
                jSONObject.put("method", m());
                jSONObject.put("adtp", g());
                jSONObject.put("http_stack", this.f5430l);
                jSONObject.put("retry_count", n() - 1);
                jSONObject.put("request_wait_duration", this.f);
                jSONObject.put(TypedValues.TransitionType.S_DURATION, (this.t - this.f5437s) + this.f);
                jSONObject.put("request_duration", this.t - this.f5437s);
                jSONObject.put("response_code", this.f5427i);
                String strO = o();
                jSONObject.put("dns_result", strO);
                jSONObject.put("dns_status", TextUtils.isEmpty(strO) ? 2 : 1);
                jSONObject.put("is_connection_acquired", this.f5431m ? 1 : 0);
                jSONObject.put("address", p());
                jSONObject.put("port", this.I != null ? this.I.getPort() : -1);
                jSONObject.put("proxy", (this.J == null || (type = this.J.type()) == null) ? "" : type.toString());
                jSONObject.put("protocol", this.L != null ? this.L.toString() : "");
                jSONObject.put("tls_version", q());
                jSONObject.put("content_type", com.mbridge.msdk.foundation.same.d.a(this.f5433o));
                int i11 = this.g;
                jSONObject.put("result", i11);
                if (i11 != 1) {
                    jSONObject.put("error_type", this.h);
                    jSONObject.put("reason", r());
                }
                jSONObject.put("dns_duration", this.f5440w - this.f5439v);
                jSONObject.put("connect_duration", this.y - this.f5441x);
                jSONObject.put("request_header_duration", this.A - this.f5442z);
                jSONObject.put("request_body_duration", this.C - this.B);
                jSONObject.put("request_body_size", this.f5434p);
                jSONObject.put("response_header_duration", this.E - this.D);
                jSONObject.put("response_body_duration", this.G - this.F);
                jSONObject.put("response_body_size", this.f5435q);
                jSONObject.put("transmission_duration", this.D - this.f5442z);
                jSONObject.put("current_response_body_size", this.f5436r);
                com.mbridge.msdk.tracker.e eVarA = a(jSONObject, "m_request_end");
                if (MBridgeConstans.DEBUG) {
                    af.a("NetworkMonitor_" + l(), "request  end  monitor = " + jSONObject.toString());
                }
                com.mbridge.msdk.foundation.same.report.d.d.a().c().a(eVarA);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "reportRequestEnd ", th);
                }
            }
        }
    }

    public final void c() {
        this.B = SystemClock.elapsedRealtime();
    }

    public final void d() {
        this.D = SystemClock.elapsedRealtime();
    }

    public final void e(long j10) {
        this.C = SystemClock.elapsedRealtime();
    }

    public final void f(long j10) {
        this.f5436r = j10;
    }

    public final void j(long j10) {
        this.e = UUID.randomUUID().toString();
        this.f = j10;
        this.f5432n.addAndGet(1);
        this.M = null;
        this.f5438u = null;
        this.O = null;
        this.f5437s = 0L;
        this.t = 0L;
        this.f5439v = 0L;
        this.f5440w = 0L;
        this.f5441x = 0L;
        this.y = 0L;
        this.f5442z = 0L;
        this.A = 0L;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = 0L;
        this.G = 0L;
        this.f5435q = 0L;
        this.f5436r = 0L;
        this.f5431m = false;
        this.g = -1;
        this.f5427i = -1;
        this.h = "";
        this.f5433o = "";
        this.f5434p = 0L;
        this.P = false;
        this.P = true;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("key", "m_request_start");
            jSONObject.put("uuid", i());
            jSONObject.put("request_uuid", j());
            jSONObject.put("lrid", h());
            jSONObject.put("url", k());
            jSONObject.put("timeout", this.Q);
            jSONObject.put("timeout_connection", this.R);
            jSONObject.put("timeout_read", this.S);
            jSONObject.put("timeout_write", this.T);
            jSONObject.put("scene", l());
            jSONObject.put("method", m());
            jSONObject.put("adtp", g());
            jSONObject.put("http_stack", this.f5430l);
            jSONObject.put("retry_count", n() - 1);
            jSONObject.put("request_wait_duration", this.f);
            com.mbridge.msdk.tracker.e eVarA = a(jSONObject, "m_request_start");
            if (MBridgeConstans.DEBUG) {
                af.a("NetworkMonitor_" + l(), "request start monitor = " + jSONObject.toString());
            }
            com.mbridge.msdk.foundation.same.report.d.d.a().c().a(eVarA);
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                af.b("NetworkMonitor", "reportRequestStart ", th);
            }
        }
    }

    public final long f() {
        return this.f5436r;
    }

    public final void c(String str) {
        this.f5424b = str;
    }

    public final void d(String str) {
        this.h = str;
    }

    public final void e() {
        this.F = SystemClock.elapsedRealtime();
    }

    public final void c(long j10) {
        this.S = j10;
    }

    public final void d(long j10) {
        this.T = j10;
    }

    public final void g(long j10) {
        this.G = SystemClock.elapsedRealtime();
    }

    public final void h(long j10) {
        this.f5435q = j10;
    }

    public final void i(long j10) {
        this.f5434p = j10;
    }

    public final void a(long j10) {
        this.Q = j10;
    }

    public final void a(int i10) {
        this.f5427i = i10;
    }

    public final void a(Call call) {
        this.f5437s = SystemClock.elapsedRealtime();
    }

    public final void a() {
        this.f5439v = SystemClock.elapsedRealtime();
    }

    public final void a(List<InetAddress> list) {
        this.f5440w = SystemClock.elapsedRealtime();
        this.H = list;
    }

    public final void a(InetSocketAddress inetSocketAddress, Proxy proxy) {
        this.f5441x = SystemClock.elapsedRealtime();
        this.I = inetSocketAddress;
        this.J = proxy;
        this.N = true;
    }

    public final void a(Handshake handshake) {
        this.K = handshake;
    }

    public final void a(Protocol protocol, IOException iOException) {
        this.y = SystemClock.elapsedRealtime();
        this.L = protocol;
        this.M = iOException;
    }

    public final void a(Connection connection) {
        this.f5431m = !this.N;
        if (!this.f5431m || connection == null) {
            return;
        }
        try {
            this.L = connection.protocol();
            Route route = connection.route();
            if (route != null) {
                this.I = route.socketAddress();
                this.J = route.proxy();
            }
            this.K = connection.handshake();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                af.b("NetworkMonitor", "connectionAcquired ", e);
            }
        }
    }

    public final void a(Request request) {
        this.A = SystemClock.elapsedRealtime();
    }

    public final void a(Response response) {
        this.E = SystemClock.elapsedRealtime();
        if (response != null) {
            try {
                Headers headers = response.headers();
                if (headers != null) {
                    String str = headers.get("Content-Type");
                    if (TextUtils.isEmpty(str)) {
                        str = "";
                    }
                    this.f5433o = str;
                }
            } catch (Exception e) {
                this.f5433o = EnvironmentCompat.MEDIA_UNKNOWN;
                if (MBridgeConstans.DEBUG) {
                    af.b("NetworkMonitor", "responseHeadersEnd ", e);
                }
            }
        }
    }

    public final void a(String str) {
        this.f5423a = str;
    }

    private static String a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str2)) {
            str2 = "IOException";
        }
        sb.append(String.format(str, str2));
        sb.append(TextUtils.isEmpty(str3) ? "" : str3.replaceAll("[\\n\\r]", " "));
        return sb.toString();
    }

    public final void a(Exception exc) {
        this.O = exc;
    }

    private static com.mbridge.msdk.tracker.e a(JSONObject jSONObject, String str) {
        com.mbridge.msdk.tracker.e eVar = new com.mbridge.msdk.tracker.e(str);
        eVar.b(0);
        eVar.a(0);
        eVar.a(com.mbridge.msdk.foundation.same.report.c.c());
        eVar.a(jSONObject);
        return eVar;
    }

    private String j() {
        return TextUtils.isEmpty(this.e) ? "" : this.e;
    }

    public final void b(String str) {
        this.f5425c = str;
    }

    public final void b() {
        this.f5442z = SystemClock.elapsedRealtime();
    }

    public final void b(long j10) {
        this.R = j10;
    }
}
