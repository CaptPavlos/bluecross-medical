package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m extends h {

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2080c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2081d;
    public final w2.r e;

    public m(String str, ArrayList arrayList, List list, w2.r rVar) {
        super(str);
        this.f2080c = new ArrayList();
        this.e = rVar;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                this.f2080c.add(((n) obj).f());
            }
        }
        this.f2081d = new ArrayList(list);
    }

    @Override // com.google.android.gms.internal.measurement.h
    public final n a(w2.r rVar, List list) {
        r rVar2;
        w2.r rVarN = this.e.N();
        t tVar = (t) rVarN.f13463c;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f2080c;
            int size = arrayList.size();
            rVar2 = n.f2091a0;
            if (i11 >= size) {
                break;
            }
            if (i11 < list.size()) {
                rVarN.Q((String) arrayList.get(i11), ((t) rVar.f13463c).c(rVar, (n) list.get(i11)));
            } else {
                rVarN.Q((String) arrayList.get(i11), rVar2);
            }
            i11++;
        }
        ArrayList arrayList2 = this.f2081d;
        int size2 = arrayList2.size();
        while (i10 < size2) {
            Object obj = arrayList2.get(i10);
            i10++;
            n nVar = (n) obj;
            n nVarC = tVar.c(rVarN, nVar);
            if (nVarC instanceof o) {
                nVarC = tVar.c(rVarN, nVar);
            }
            if (nVarC instanceof f) {
                return ((f) nVarC).f1946a;
            }
        }
        return rVar2;
    }

    @Override // com.google.android.gms.internal.measurement.h, com.google.android.gms.internal.measurement.n
    public final n l() {
        return new m(this);
    }

    public m(m mVar) {
        super(mVar.f1973a);
        ArrayList arrayList = new ArrayList(mVar.f2080c.size());
        this.f2080c = arrayList;
        arrayList.addAll(mVar.f2080c);
        ArrayList arrayList2 = new ArrayList(mVar.f2081d.size());
        this.f2081d = arrayList2;
        arrayList2.addAll(mVar.f2081d);
        this.e = mVar.e;
    }
}
