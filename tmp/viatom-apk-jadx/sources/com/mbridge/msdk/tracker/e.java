package com.mbridge.msdk.tracker;

import java.io.Serializable;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    private String f5333a;

    /* renamed from: d, reason: collision with root package name */
    private JSONObject f5336d;

    /* renamed from: i, reason: collision with root package name */
    private h f5337i;

    /* renamed from: b, reason: collision with root package name */
    private int f5334b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f5335c = 0;
    private long g = 0;
    private long h = 604800000;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5338j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f5339k = false;
    private long f = System.currentTimeMillis();
    private String e = UUID.randomUUID().toString();

    public e(String str) {
        this.f5333a = str;
    }

    public final String a() {
        return this.f5333a;
    }

    public final int b() {
        return this.f5334b;
    }

    public final int c() {
        return this.f5335c;
    }

    public final JSONObject d() {
        JSONObject jSONObject = this.f5336d;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f5336d = jSONObject2;
        return jSONObject2;
    }

    public final String e() {
        return this.e;
    }

    public final long f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final h i() {
        return this.f5337i;
    }

    public final boolean j() {
        return this.f5338j;
    }

    public final boolean k() {
        return this.f5339k;
    }

    public final void a(int i10) {
        this.f5334b = i10;
    }

    public final void b(int i10) {
        this.f5335c = i10;
    }

    public final void c(long j10) {
        this.h = j10;
    }

    public final void a(JSONObject jSONObject) {
        this.f5336d = jSONObject;
    }

    public final void b(long j10) {
        this.g = j10;
    }

    public final void a(String str) {
        this.e = str;
    }

    public final void a(long j10) {
        this.f = j10;
    }

    public final void a(h hVar) {
        this.f5337i = hVar;
    }

    public final void a(boolean z9) {
        this.f5339k = z9;
    }
}
