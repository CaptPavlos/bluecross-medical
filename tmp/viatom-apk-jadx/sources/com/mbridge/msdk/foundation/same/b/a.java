package com.mbridge.msdk.foundation.same.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private List<a> f3636a;

    /* renamed from: b, reason: collision with root package name */
    private String f3637b;

    /* renamed from: c, reason: collision with root package name */
    private a f3638c;

    /* renamed from: d, reason: collision with root package name */
    private c f3639d;

    public final void a(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final String b() {
        return this.f3637b;
    }

    public final a c() {
        return this.f3638c;
    }

    public final c d() {
        return this.f3639d;
    }

    private void a(a aVar) {
        if (this.f3636a == null) {
            this.f3636a = new ArrayList();
        }
        aVar.f3638c = this;
        this.f3636a.add(aVar);
    }

    public final void a(c cVar, String str) {
        a aVar = new a();
        aVar.f3639d = cVar;
        aVar.f3637b = str;
        a(aVar);
    }

    public final List<a> a() {
        return this.f3636a;
    }

    public final void a(String str) {
        this.f3637b = str;
    }

    public final void a(c cVar) {
        this.f3639d = cVar;
    }
}
