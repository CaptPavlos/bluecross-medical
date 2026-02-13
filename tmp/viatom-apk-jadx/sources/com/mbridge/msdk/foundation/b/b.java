package com.mbridge.msdk.foundation.b;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.z;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private CopyOnWriteArrayList<CampaignEx> f3322a;

    /* renamed from: b, reason: collision with root package name */
    private double f3323b;

    /* renamed from: c, reason: collision with root package name */
    private String f3324c;

    /* renamed from: d, reason: collision with root package name */
    private String f3325d;
    private int e;
    private long f;
    private int g;
    private long h;

    /* renamed from: i, reason: collision with root package name */
    private String f3326i;

    /* renamed from: j, reason: collision with root package name */
    private long f3327j;

    public final void a(String str) throws NumberFormatException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = z.a(str);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        try {
            double d8 = Double.parseDouble(strA);
            if (d8 <= 0.0d) {
                return;
            }
            this.f3323b = d8;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final CopyOnWriteArrayList<CampaignEx> b() {
        return this.f3322a;
    }

    public final double c() {
        return this.f3323b;
    }

    public final String d() {
        return this.f3324c;
    }

    public final String e() {
        return this.f3325d;
    }

    public final int f() {
        return this.e;
    }

    public final int g() {
        return this.g;
    }

    public final long h() {
        return this.h;
    }

    public final void b(String str) {
        this.f3324c = str;
    }

    public final void c(String str) {
        this.f3325d = str;
    }

    public final void d(String str) {
        this.f3326i = str;
    }

    public final void b(int i10) {
        this.g = i10;
    }

    public final void c(long j10) {
        this.f = j10;
    }

    public final void b(long j10) {
        this.h = j10;
    }

    public final void a(long j10) {
        this.f3327j = j10;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f3322a = copyOnWriteArrayList;
    }

    public final long a() {
        return this.f3327j;
    }

    public final void a(int i10) {
        this.e = i10;
    }
}
