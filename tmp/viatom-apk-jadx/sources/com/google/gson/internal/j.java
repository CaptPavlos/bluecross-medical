package com.google.gson.internal;

import com.google.android.gms.internal.measurement.r6;
import com.google.android.gms.internal.measurement.t6;
import j$.util.Objects;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class j extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2567a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractMap f2568b;

    public /* synthetic */ j(AbstractMap abstractMap, int i10) {
        this.f2567a = i10;
        this.f2568b = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        switch (this.f2567a) {
            case 2:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((r6) this.f2568b).put((Comparable) entry.getKey(), entry.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f2567a) {
            case 0:
                ((l) this.f2568b).clear();
                break;
            case 1:
                ((l) this.f2568b).clear();
                break;
            default:
                ((r6) this.f2568b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        k kVarA;
        switch (this.f2567a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                l lVar = (l) this.f2568b;
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                k kVar = null;
                if (key != null) {
                    try {
                        kVarA = lVar.a(key, false);
                    } catch (ClassCastException unused) {
                    }
                } else {
                    kVarA = null;
                }
                if (kVarA != null && Objects.equals(kVarA.h, entry.getValue())) {
                    kVar = kVarA;
                }
                return kVar != null;
            case 1:
                return ((l) this.f2568b).containsKey(obj);
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                Object obj2 = ((r6) this.f2568b).get(entry2.getKey());
                Object value = entry2.getValue();
                if (obj2 != value) {
                    return obj2 != null && obj2.equals(value);
                }
                return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f2567a) {
            case 0:
                return new i((l) this.f2568b, 0);
            case 1:
                return new i((l) this.f2568b, 1);
            default:
                return new t6((r6) this.f2568b);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        k kVarA;
        switch (this.f2567a) {
            case 0:
                l lVar = (l) this.f2568b;
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    k kVar = null;
                    if (key != null) {
                        try {
                            kVarA = lVar.a(key, false);
                        } catch (ClassCastException unused) {
                        }
                    } else {
                        kVarA = null;
                    }
                    if (kVarA != null && Objects.equals(kVarA.h, entry.getValue())) {
                        kVar = kVarA;
                    }
                    if (kVar != null) {
                        lVar.d(kVar, true);
                        break;
                    }
                }
                break;
            case 1:
                l lVar2 = (l) this.f2568b;
                k kVarA2 = null;
                if (obj != null) {
                    try {
                        kVarA2 = lVar2.a(obj, false);
                    } catch (ClassCastException unused2) {
                    }
                }
                if (kVarA2 != null) {
                    lVar2.d(kVarA2, true);
                }
                if (kVarA2 != null) {
                    break;
                }
                break;
            default:
                Map.Entry entry2 = (Map.Entry) obj;
                if (contains(entry2)) {
                    ((r6) this.f2568b).remove(entry2.getKey());
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f2567a) {
            case 0:
                return ((l) this.f2568b).f2578d;
            case 1:
                return ((l) this.f2568b).f2578d;
            default:
                return ((r6) this.f2568b).size();
        }
    }
}
