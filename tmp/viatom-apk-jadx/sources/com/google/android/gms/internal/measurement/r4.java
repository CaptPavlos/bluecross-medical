package com.google.android.gms.internal.measurement;

import androidx.collection.ArrayMap;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class r4 {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayMap f2143a = new ArrayMap();

    public static synchronized void a() {
        ArrayMap arrayMap = f2143a;
        Iterator it = arrayMap.values().iterator();
        if (it.hasNext()) {
            ((r4) it.next()).getClass();
            throw null;
        }
        arrayMap.clear();
    }
}
