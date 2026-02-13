package com.mbridge.msdk.foundation.c;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.Serializable;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private int f3338a;

    /* renamed from: b, reason: collision with root package name */
    private int f3339b;

    /* renamed from: c, reason: collision with root package name */
    private String f3340c;

    /* renamed from: d, reason: collision with root package name */
    private Throwable f3341d;
    private CampaignEx e;
    private MBridgeIds f;
    private String g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f3342i;

    /* renamed from: j, reason: collision with root package name */
    private int f3343j = -1;

    /* renamed from: k, reason: collision with root package name */
    private String f3344k;

    /* renamed from: l, reason: collision with root package name */
    private HashMap<Object, Object> f3345l;

    /* renamed from: m, reason: collision with root package name */
    private int f3346m;

    /* renamed from: n, reason: collision with root package name */
    private String f3347n;

    /* renamed from: o, reason: collision with root package name */
    private String f3348o;

    /* renamed from: p, reason: collision with root package name */
    private String f3349p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f3350q;

    public b(int i10, int i11, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f3340c = a.a(i11);
        } else {
            a("his_reason", str);
            this.f3340c = str;
        }
        this.f3346m = i10;
        this.f3339b = a.b(i11);
    }

    public final Object a(Object obj) {
        HashMap<Object, Object> map = this.f3345l;
        if (map != null && map.containsKey(obj)) {
            return this.f3345l.get(obj);
        }
        return null;
    }

    public final String b() {
        int i10;
        String strA = !TextUtils.isEmpty(this.f3340c) ? this.f3340c : "";
        if (TextUtils.isEmpty(strA) && (i10 = this.f3338a) != -1) {
            strA = a.a(i10);
        }
        Throwable th = this.f3341d;
        if (th == null) {
            return strA;
        }
        String message = th.getMessage();
        return !TextUtils.isEmpty(message) ? a3.a.j(strA, " # ", message) : strA;
    }

    public final CampaignEx c() {
        return this.e;
    }

    public final MBridgeIds d() {
        if (this.f == null) {
            this.f = new MBridgeIds();
        }
        return this.f;
    }

    public final int e() {
        return this.f3339b;
    }

    public final String f() {
        return this.h;
    }

    public final int g() {
        return this.f3343j;
    }

    public final String h() {
        return this.f3344k;
    }

    public final int i() {
        return this.f3346m;
    }

    public final String j() {
        return this.f3347n;
    }

    public final String k() {
        return this.f3348o;
    }

    public final String l() {
        return this.f3349p;
    }

    public final boolean m() {
        return this.f3350q;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MBFailureReason{errorCode=");
        sb.append(this.f3338a);
        sb.append(", errorSubType=");
        sb.append(this.f3339b);
        sb.append(", message='");
        sb.append(this.f3340c);
        sb.append("', cause=");
        sb.append(this.f3341d);
        sb.append(", campaign=");
        sb.append(this.e);
        sb.append(", ids=");
        sb.append(this.f);
        sb.append(", requestId='");
        sb.append(this.g);
        sb.append("', localRequestId='");
        sb.append(this.h);
        sb.append("', isHeaderBidding=");
        sb.append(this.f3342i);
        sb.append(", typeD=");
        sb.append(this.f3343j);
        sb.append(", reasonD='");
        sb.append(this.f3344k);
        sb.append("', extraMap=");
        sb.append(this.f3345l);
        sb.append(", serverErrorCode=");
        sb.append(this.f3346m);
        sb.append(", errorUrl='");
        sb.append(this.f3347n);
        sb.append("', serverErrorResponse='");
        return a3.a.o(sb, this.f3348o, "'}");
    }

    public final void c(String str) {
        this.f3344k = str;
    }

    public final void e(String str) {
        this.f3348o = str;
    }

    public final void f(String str) {
        this.f3349p = str;
    }

    public final void d(String str) {
        this.f3347n = str;
    }

    public final void a(String str) {
        this.f3340c = str;
    }

    public final void a(Throwable th) {
        this.f3341d = th;
    }

    public final void a(CampaignEx campaignEx) {
        this.e = campaignEx;
    }

    public final void a(MBridgeIds mBridgeIds) {
        this.f = mBridgeIds;
    }

    public final void a(boolean z9) {
        this.f3342i = z9;
    }

    public final void a(Object obj, Object obj2) {
        if (this.f3345l == null) {
            this.f3345l = new HashMap<>();
        }
        this.f3345l.put(obj, obj2);
    }

    public final int a() {
        return this.f3338a;
    }

    public final void a(int i10) {
        this.f3343j = i10;
    }

    public b(int i10, String str) {
        this.f3338a = i10;
        if (!TextUtils.isEmpty(str)) {
            a("his_reason", str);
        }
        this.f3340c = str;
        this.f3339b = a.b(i10);
    }

    public b(int i10) {
        this.f3338a = i10;
        this.f3339b = a.b(i10);
    }

    public final void b(String str) {
        this.h = str;
    }

    public final void b(boolean z9) {
        this.f3350q = z9;
    }
}
