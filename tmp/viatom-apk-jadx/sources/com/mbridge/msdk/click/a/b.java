package com.mbridge.msdk.click.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.HashSet;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f2780a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static int f2781b = 1;

    /* renamed from: c, reason: collision with root package name */
    private String f2782c;

    /* renamed from: d, reason: collision with root package name */
    private int f2783d;
    private HashSet<String> e = new HashSet<>();
    private long f = System.currentTimeMillis();
    private CampaignEx g;
    private String h;

    /* renamed from: i, reason: collision with root package name */
    private int f2784i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f2785j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f2786k;

    /* renamed from: l, reason: collision with root package name */
    private int f2787l;

    public b(String str, String str2) {
        this.f2782c = str;
        b(str2);
    }

    public final boolean a() {
        return this.f2785j;
    }

    public final void b(String str) {
        this.f2783d++;
        this.e.add(str);
    }

    public final int c() {
        return this.f2787l;
    }

    public final int d() {
        return this.f2784i;
    }

    public final String e() {
        return this.h;
    }

    public final CampaignEx f() {
        return this.g;
    }

    public final String g() {
        return this.f2782c;
    }

    public final int h() {
        return this.f2783d;
    }

    public final HashSet<String> i() {
        return this.e;
    }

    public final long j() {
        return this.f;
    }

    public final void a(boolean z9) {
        this.f2785j = z9;
    }

    public final void a(int i10) {
        this.f2787l = i10;
    }

    public final void a(String str) {
        this.h = str;
    }

    public final void a(CampaignEx campaignEx) {
        this.g = campaignEx;
    }

    public final void b(boolean z9) {
        this.f2786k = z9;
    }

    public final void b(int i10) {
        this.f2784i = i10;
    }

    public final boolean b() {
        return this.f2786k;
    }
}
