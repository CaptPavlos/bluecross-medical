package com.mbridge.msdk.tracker;

import java.io.Serializable;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    static String f5346a = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_count INTEGER)";

    /* renamed from: b, reason: collision with root package name */
    static String f5347b = "DROP TABLE IF EXISTS %s";

    /* renamed from: c, reason: collision with root package name */
    private final e f5348c;

    /* renamed from: d, reason: collision with root package name */
    private int f5349d;
    private int e;
    private final String f;
    private long g;
    private boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    private boolean f5350i = false;

    public i(e eVar) {
        this.f5348c = eVar;
        this.f = eVar.e();
    }

    public final void a(boolean z9) {
        this.h = z9;
    }

    public final void b(boolean z9) {
        this.f5350i = z9;
    }

    public final e c() {
        return this.f5348c;
    }

    public final int d() {
        return this.f5349d;
    }

    public final int e() {
        return this.e;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final boolean a() {
        return this.h;
    }

    public final boolean b() {
        return this.f5350i;
    }

    public final void a(int i10) {
        this.f5349d = i10;
    }

    public final void b(int i10) {
        this.e = i10;
    }

    public final void a(long j10) {
        this.g = j10;
    }
}
