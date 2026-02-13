package com.mbridge.msdk.tracker.network;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.work.WorkRequest;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.tracker.network.ae;
import com.mbridge.msdk.tracker.network.b;
import com.mbridge.msdk.tracker.network.w;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class u<T> implements Comparable<u<T>> {

    /* renamed from: a, reason: collision with root package name */
    private c f5464a;

    /* renamed from: b, reason: collision with root package name */
    private String f5465b;

    /* renamed from: c, reason: collision with root package name */
    private volatile q f5466c;

    /* renamed from: d, reason: collision with root package name */
    private long f5467d;
    private Map<String, String> e;
    private final ae.a f;
    private int g;
    private final String h;

    /* renamed from: i, reason: collision with root package name */
    private final int f5468i;

    /* renamed from: j, reason: collision with root package name */
    private final String f5469j;

    /* renamed from: k, reason: collision with root package name */
    private final int f5470k;

    /* renamed from: l, reason: collision with root package name */
    private final Object f5471l;

    /* renamed from: m, reason: collision with root package name */
    private w.a f5472m;

    /* renamed from: n, reason: collision with root package name */
    private Integer f5473n;

    /* renamed from: o, reason: collision with root package name */
    private v f5474o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f5475p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f5476q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f5477r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f5478s;
    private boolean t;

    /* renamed from: u, reason: collision with root package name */
    private z f5479u;

    /* renamed from: v, reason: collision with root package name */
    private b.a f5480v;

    /* renamed from: w, reason: collision with root package name */
    private a f5481w;

    /* renamed from: x, reason: collision with root package name */
    private long f5482x;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface a {
        void a(u<?> uVar);

        void a(u<?> uVar, w<?> wVar);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public enum b {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public u(int i10, String str, int i11, String str2) {
        Uri uri;
        String host;
        this.f = null;
        this.f5471l = new Object();
        int iHashCode = 0;
        this.f5475p = false;
        this.f5476q = false;
        this.f5477r = false;
        this.f5478s = false;
        this.t = false;
        this.f5480v = null;
        this.f5482x = 0L;
        this.g = i10;
        this.h = str;
        this.f5468i = i11;
        this.f5469j = str2;
        this.f5479u = new e();
        if (!TextUtils.isEmpty(str) && (uri = Uri.parse(str)) != null && (host = uri.getHost()) != null) {
            iHashCode = host.hashCode();
        }
        this.f5470k = iHashCode;
        this.f5467d = SystemClock.elapsedRealtime();
    }

    private byte[] a(Map<String, String> map, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            int i10 = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                i10++;
                if (entry.getKey() != null) {
                    sb.append(URLEncoder.encode(entry.getKey(), str));
                    sb.append('=');
                    sb.append(URLEncoder.encode(entry.getValue() == null ? "" : entry.getValue(), str));
                    if (i10 <= map.size() - 1) {
                        sb.append('&');
                    }
                }
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e) {
            androidx.privacysandbox.ads.adservices.adid.a.l(a3.a.i("Encoding not supported: ", str), e);
            return null;
        }
    }

    public abstract w<T> a(r rVar);

    public abstract void a(T t);

    public final void b(ad adVar) {
        w.a aVar;
        synchronized (this.f5471l) {
            aVar = this.f5472m;
        }
        if (aVar != null) {
            aVar.a(adVar);
        }
    }

    public final void c(String str, String str2) {
        if (this.e == null) {
            this.e = new HashMap();
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            this.e.put(str, str2);
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Object obj) {
        u uVar = (u) obj;
        b bVarE = e();
        b bVarE2 = uVar.e();
        return bVarE == bVarE2 ? this.f5473n.intValue() - uVar.f5473n.intValue() : bVarE2.ordinal() - bVarE.ordinal();
    }

    public final String d(String str) {
        if (this.e != null && !TextUtils.isEmpty(str)) {
            try {
                return this.e.get(str);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public b e() {
        return b.NORMAL;
    }

    public final String f() {
        return this.f5469j;
    }

    public final long g() {
        return SystemClock.elapsedRealtime() - this.f5467d;
    }

    public final int h() {
        return this.f5468i;
    }

    public final int i() {
        return this.g;
    }

    public final int j() {
        return this.f5470k;
    }

    public final String k() {
        return this.h;
    }

    public final String l() {
        if (!TextUtils.isEmpty(this.f5465b)) {
            return this.f5465b;
        }
        if (this.f5464a == null) {
            this.f5464a = new com.mbridge.msdk.tracker.network.toolbox.e();
        }
        String strA = this.f5464a.a(this);
        this.f5465b = strA;
        return strA;
    }

    public final b.a m() {
        return this.f5480v;
    }

    public final boolean n() {
        boolean z9;
        synchronized (this.f5471l) {
            z9 = this.f5476q;
        }
        return z9;
    }

    public final String o() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    public final byte[] p() {
        Map<String, String> mapA = a();
        if (mapA == null || mapA.size() <= 0) {
            this.f5482x = 0L;
            return null;
        }
        byte[] bArrA = a(mapA, C.UTF8_NAME);
        this.f5482x = bArrA.length;
        return bArrA;
    }

    public final long q() {
        return this.f5482x;
    }

    public final boolean r() {
        return this.f5475p;
    }

    public final boolean s() {
        return this.f5478s;
    }

    public final boolean t() {
        return this.t;
    }

    public String toString() {
        String str = "0x" + Integer.toHexString(this.f5470k);
        StringBuilder sb = new StringBuilder();
        sb.append(n() ? "[X] " : "[ ] ");
        sb.append(this.h);
        sb.append(" ");
        sb.append(str);
        sb.append(" ");
        sb.append(e());
        sb.append(" ");
        sb.append(this.f5473n);
        return sb.toString();
    }

    public final int u() {
        z zVarB = b();
        if (zVarB == null) {
            return 30000;
        }
        return zVarB.a();
    }

    public final long v() {
        z zVarB = b();
        if (zVarB == null) {
            return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }
        long jB = zVarB.b();
        return jB < 0 ? WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS : jB;
    }

    public final void w() {
        synchronized (this.f5471l) {
            this.f5477r = true;
        }
    }

    public final boolean x() {
        boolean z9;
        synchronized (this.f5471l) {
            z9 = this.f5477r;
        }
        return z9;
    }

    public final void y() {
        a aVar;
        synchronized (this.f5471l) {
            aVar = this.f5481w;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public final q z() {
        return this.f5466c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u<?> b(boolean z9) {
        this.f5475p = z9;
        return this;
    }

    public z b() {
        return this.f5479u;
    }

    public final void b(int i10) {
        v vVar = this.f5474o;
        if (vVar != null) {
            vVar.a(this, i10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u<?> d(boolean z9) {
        this.t = z9;
        return this;
    }

    public boolean d() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u<?> c(int i10) {
        this.f5473n = Integer.valueOf(i10);
        return this;
    }

    public Map<String, String> c() {
        return Collections.EMPTY_MAP;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u<?> c(boolean z9) {
        this.f5478s = z9;
        return this;
    }

    public final void c(String str) {
        v vVar = this.f5474o;
        if (vVar != null) {
            vVar.b(this);
        }
    }

    public u(int i10, String str, int i11) {
        this(i10, str, i11, "un_known");
    }

    public u(int i10, String str) {
        this(i10, str, 0);
    }

    public Map<String, String> a() {
        return null;
    }

    public final void a(w.a aVar) {
        this.f5472m = aVar;
    }

    public final void a(int i10) {
        this.g = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final u<?> a(v vVar) {
        this.f5474o = vVar;
        return this;
    }

    public final void a(w<?> wVar) {
        a aVar;
        synchronized (this.f5471l) {
            aVar = this.f5481w;
        }
        if (aVar != null) {
            aVar.a(this, wVar);
        }
    }

    public final void a(q qVar) {
        this.f5466c = qVar;
    }
}
