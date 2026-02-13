package com.mbridge.msdk.foundation.b;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static int f3328a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f3329b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f3330c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static int f3331d = 2;
    public static int e = 4;
    private CopyOnWriteArrayList<CampaignEx> f;
    private String g;
    private int h = 21;

    /* renamed from: i, reason: collision with root package name */
    private int f3332i = f3329b;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<String> f3333j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private List<String> f3334k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private List<String> f3335l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private List<String> f3336m = new ArrayList();

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f3333j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            List<String> list = this.f3334k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.f3335l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final String d() {
        List<String> list = this.f3334k;
        return list == null ? "" : list.toString();
    }

    public final String e() {
        List<String> list = this.f3335l;
        return list == null ? "" : list.toString();
    }

    public final String f() {
        List<String> list = this.f3336m;
        return list == null ? "" : list.toString();
    }

    public final int g() {
        return this.f3332i;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        this.f = copyOnWriteArrayList;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        ArrayList<String> arrayList = this.f3333j;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final CopyOnWriteArrayList<CampaignEx> a() {
        return this.f;
    }

    public final void a(int i10) {
        this.f3332i = i10;
    }
}
