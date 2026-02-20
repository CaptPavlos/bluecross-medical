package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class p implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2125a;

    /* renamed from: b, reason: collision with root package name */
    public int f2126b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2127c;

    public /* synthetic */ p(Object obj, int i10) {
        this.f2125a = i10;
        this.f2127c = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f2125a) {
            case 0:
                if (this.f2126b < ((q) this.f2127c).f2137a.length()) {
                }
                break;
            case 1:
                if (this.f2126b < ((q) this.f2127c).f2137a.length()) {
                }
                break;
            default:
                if (this.f2126b < ((d) this.f2127c).o()) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        switch (this.f2125a) {
            case 0:
                String str = ((q) this.f2127c).f2137a;
                int i10 = this.f2126b;
                if (i10 < str.length()) {
                    this.f2126b = i10 + 1;
                    return new q(String.valueOf(i10));
                }
                com.google.gson.internal.a.b();
                return null;
            case 1:
                q qVar = (q) this.f2127c;
                String str2 = qVar.f2137a;
                int i11 = this.f2126b;
                if (i11 < str2.length()) {
                    this.f2126b = i11 + 1;
                    return new q(String.valueOf(qVar.f2137a.charAt(i11)));
                }
                com.google.gson.internal.a.b();
                return null;
            default:
                d dVar = (d) this.f2127c;
                int i12 = this.f2126b;
                int iO = dVar.o();
                int i13 = this.f2126b;
                if (i12 < iO) {
                    this.f2126b = i13 + 1;
                    return dVar.p(i13);
                }
                StringBuilder sb = new StringBuilder(String.valueOf(i13).length() + 21);
                sb.append("Out of bounds index: ");
                sb.append(i13);
                throw new NoSuchElementException(sb.toString());
        }
    }
}
