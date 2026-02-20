package com.google.android.material.button;

import e5.u0;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2306a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2307b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f2306a = i10;
        this.f2307b = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2306a) {
        }
        return ((Number) ((u0) this.f2307b).invoke(obj, obj2)).intValue();
    }
}
