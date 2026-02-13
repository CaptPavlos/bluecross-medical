package com.mbridge.msdk.newreward.function.a;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f4646a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static int f4647b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f4648c = 3;

    /* renamed from: d, reason: collision with root package name */
    public static int f4649d = 2;
    public static int e = 4;
    private com.mbridge.msdk.newreward.function.c.a.b f;
    private String g;
    private int h = 21;

    /* renamed from: i, reason: collision with root package name */
    private int f4650i = f4647b;

    /* renamed from: j, reason: collision with root package name */
    private ArrayList<String> f4651j = new ArrayList<>();

    /* renamed from: k, reason: collision with root package name */
    private List<String> f4652k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private List<String> f4653l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private List<String> f4654m = new ArrayList();

    public final void a(String str) {
        try {
            ArrayList<String> arrayList = this.f4651j;
            if (arrayList != null) {
                arrayList.add(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void b(String str) {
        try {
            List<String> list = this.f4652k;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final void c(String str) {
        try {
            List<String> list = this.f4653l;
            if (list != null) {
                list.add(str);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public final String d() {
        List<String> list = this.f4652k;
        return list == null ? "" : list.toString();
    }

    public final String e() {
        List<String> list = this.f4653l;
        return list == null ? "" : list.toString();
    }

    public final String f() {
        List<String> list = this.f4654m;
        return list == null ? "" : list.toString();
    }

    public final int g() {
        return this.h;
    }

    public final int h() {
        return this.f4650i;
    }

    public final void d(String str) {
        this.g = str;
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.b bVar) {
        this.f = bVar;
    }

    public final String b() {
        return this.g;
    }

    public final String c() {
        ArrayList<String> arrayList = this.f4651j;
        if (arrayList == null) {
            return "";
        }
        return arrayList.toString();
    }

    public final com.mbridge.msdk.newreward.function.c.a.b a() {
        return this.f;
    }

    public final void a(int i10) {
        this.f4650i = i10;
    }
}
