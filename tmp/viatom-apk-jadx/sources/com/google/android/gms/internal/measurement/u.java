package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f2190a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f2191b;

    public u(h hVar, w2.r rVar) {
        this.f2190a = hVar;
        this.f2191b = rVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        n nVar = (n) obj;
        n nVar2 = (n) obj2;
        if (nVar instanceof r) {
            return !(nVar2 instanceof r) ? 1 : 0;
        }
        if (nVar2 instanceof r) {
            return -1;
        }
        h hVar = this.f2190a;
        return hVar == null ? nVar.f().compareTo(nVar2.f()) : (int) a.a.b0(hVar.a(this.f2191b, Arrays.asList(nVar, nVar2)).g().doubleValue());
    }
}
