package com.google.gson.internal;

import java.util.Iterator;
import p8.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public k f2563a;

    /* renamed from: b, reason: collision with root package name */
    public k f2564b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f2565c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ l f2566d;
    public final /* synthetic */ int e;

    public i(l lVar, int i10) {
        this.e = i10;
        this.f2566d = lVar;
        this.f2563a = lVar.f.f2572d;
        this.f2565c = lVar.e;
    }

    public final Object a() {
        return b();
    }

    public final k b() {
        k kVar = this.f2563a;
        l lVar = this.f2566d;
        if (kVar == lVar.f) {
            a.b();
            return null;
        }
        if (lVar.e != this.f2565c) {
            a2.a.e();
            return null;
        }
        this.f2563a = kVar.f2572d;
        this.f2564b = kVar;
        return kVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f2563a != this.f2566d.f;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.e) {
            case 1:
                return b().f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        k kVar = this.f2564b;
        if (kVar == null) {
            u.e();
            return;
        }
        l lVar = this.f2566d;
        lVar.d(kVar, true);
        this.f2564b = null;
        this.f2565c = lVar.e;
    }
}
