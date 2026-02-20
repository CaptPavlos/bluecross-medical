package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.inmobi.cmp.core.model.Vector;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: k, reason: collision with root package name */
    public static final a f2452k = a.f2448d;

    /* renamed from: l, reason: collision with root package name */
    public static final int f2453l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f2454m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f2455n = 2;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f2456a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f2457b;

    /* renamed from: c, reason: collision with root package name */
    public final d0.i f2458c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f2459d;
    public final List e;
    public final boolean f;
    public final a g;
    public final List h;

    /* renamed from: i, reason: collision with root package name */
    public final List f2460i;

    /* renamed from: j, reason: collision with root package name */
    public final List f2461j;

    public b() {
        Excluder excluder = Excluder.f2466c;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this.f2456a = new ThreadLocal();
        this.f2457b = new ConcurrentHashMap();
        d0.i iVar = new d0.i(9);
        this.f2458c = iVar;
        this.f = true;
        this.g = f2452k;
        this.h = list;
        this.f2460i = list;
        this.f2461j = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.bind.e.A);
        arrayList.add(ObjectTypeAdapter.d(f2454m));
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.bind.e.f2545p);
        arrayList.add(com.google.gson.internal.bind.e.g);
        arrayList.add(com.google.gson.internal.bind.e.f2537d);
        arrayList.add(com.google.gson.internal.bind.e.e);
        arrayList.add(com.google.gson.internal.bind.e.f);
        final i iVar2 = com.google.gson.internal.bind.e.f2540k;
        arrayList.add(com.google.gson.internal.bind.e.b(Long.TYPE, Long.class, iVar2));
        arrayList.add(com.google.gson.internal.bind.e.b(Double.TYPE, Double.class, new Gson$1()));
        arrayList.add(com.google.gson.internal.bind.e.b(Float.TYPE, Float.class, new Gson$2()));
        int i10 = f2455n;
        arrayList.add(i10 == 2 ? NumberTypeAdapter.f2497b : NumberTypeAdapter.d(i10));
        arrayList.add(com.google.gson.internal.bind.e.h);
        arrayList.add(com.google.gson.internal.bind.e.f2538i);
        arrayList.add(com.google.gson.internal.bind.e.a(AtomicLong.class, new i() { // from class: com.google.gson.Gson$4
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) {
                return new AtomicLong(((Number) iVar2.b(aVar)).longValue());
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) {
                iVar2.c(bVar, Long.valueOf(((AtomicLong) obj).get()));
            }
        }.a()));
        arrayList.add(com.google.gson.internal.bind.e.a(AtomicLongArray.class, new i() { // from class: com.google.gson.Gson$5
            @Override // com.google.gson.i
            public final Object b(i3.a aVar) throws IOException {
                ArrayList arrayList2 = new ArrayList();
                aVar.a();
                while (aVar.k()) {
                    arrayList2.add(Long.valueOf(((Number) iVar2.b(aVar)).longValue()));
                }
                aVar.f();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i11 = 0; i11 < size; i11++) {
                    atomicLongArray.set(i11, ((Long) arrayList2.get(i11)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.i
            public final void c(i3.b bVar, Object obj) throws IOException {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.b();
                int length = atomicLongArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    iVar2.c(bVar, Long.valueOf(atomicLongArray.get(i11)));
                }
                bVar.f();
            }
        }.a()));
        arrayList.add(com.google.gson.internal.bind.e.f2539j);
        arrayList.add(com.google.gson.internal.bind.e.f2541l);
        arrayList.add(com.google.gson.internal.bind.e.f2546q);
        arrayList.add(com.google.gson.internal.bind.e.f2547r);
        arrayList.add(com.google.gson.internal.bind.e.a(BigDecimal.class, com.google.gson.internal.bind.e.f2542m));
        arrayList.add(com.google.gson.internal.bind.e.a(BigInteger.class, com.google.gson.internal.bind.e.f2543n));
        arrayList.add(com.google.gson.internal.bind.e.a(com.google.gson.internal.h.class, com.google.gson.internal.bind.e.f2544o));
        arrayList.add(com.google.gson.internal.bind.e.f2548s);
        arrayList.add(com.google.gson.internal.bind.e.t);
        arrayList.add(com.google.gson.internal.bind.e.f2550v);
        arrayList.add(com.google.gson.internal.bind.e.f2551w);
        arrayList.add(com.google.gson.internal.bind.e.y);
        arrayList.add(com.google.gson.internal.bind.e.f2549u);
        arrayList.add(com.google.gson.internal.bind.e.f2535b);
        arrayList.add(DefaultDateTypeAdapter.f2482c);
        arrayList.add(com.google.gson.internal.bind.e.f2552x);
        if (com.google.gson.internal.sql.b.f2594a) {
            arrayList.add(com.google.gson.internal.sql.b.f2596c);
            arrayList.add(com.google.gson.internal.sql.b.f2595b);
            arrayList.add(com.google.gson.internal.sql.b.f2597d);
        }
        arrayList.add(ArrayTypeAdapter.f2476c);
        arrayList.add(com.google.gson.internal.bind.e.f2534a);
        arrayList.add(new CollectionTypeAdapterFactory(iVar));
        arrayList.add(new MapTypeAdapterFactory(iVar));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(iVar);
        this.f2459d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(com.google.gson.internal.bind.e.B);
        arrayList.add(new ReflectiveTypeAdapterFactory(iVar, f2453l, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.e = DesugarCollections.unmodifiableList(arrayList);
    }

    public static void a(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            throw new IllegalArgumentException(d8 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* JADX WARN: Finally extract failed */
    public final Object b(String str, Type type) {
        Object objB;
        TypeToken typeToken = new TypeToken(type);
        i3.a aVar = new i3.a(new StringReader(str));
        aVar.f8979o = 2;
        boolean z9 = true;
        aVar.f8979o = 1;
        try {
            try {
                try {
                    aVar.x();
                    z9 = false;
                    i iVarC = c(typeToken);
                    Class cls = typeToken.f2599a;
                    objB = iVarC.b(aVar);
                    Class clsL = com.google.gson.internal.f.l(cls);
                    if (objB != null && !clsL.isInstance(objB)) {
                        throw new ClassCastException("Type adapter '" + iVarC + "' returned wrong type; requested " + cls + " but got instance of " + objB.getClass() + "\nVerify that the adapter was registered for the correct type.");
                    }
                    aVar.f8979o = 2;
                } catch (Throwable th) {
                    aVar.f8979o = 2;
                    throw th;
                }
            } catch (IOException e) {
                throw new e(e);
            } catch (IllegalStateException e3) {
                throw new e(e3);
            }
        } catch (EOFException e7) {
            if (!z9) {
                throw new e(e7);
            }
            aVar.f8979o = 2;
            objB = null;
        } catch (AssertionError e10) {
            throw new AssertionError("AssertionError (GSON 2.13.2): " + e10.getMessage(), e10);
        }
        if (objB != null) {
            try {
                if (aVar.x() != 10) {
                    throw new e("JSON document was not fully consumed.");
                }
            } catch (i3.c e11) {
                throw new e(e11);
            } catch (IOException e12) {
                throw new e(e12);
            }
        }
        return objB;
    }

    public final i c(TypeToken typeToken) {
        boolean z9;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f2457b;
        i iVar = (i) concurrentHashMap.get(typeToken);
        if (iVar != null) {
            return iVar;
        }
        ThreadLocal threadLocal = this.f2456a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z9 = true;
        } else {
            i iVar2 = (i) map.get(typeToken);
            if (iVar2 != null) {
                return iVar2;
            }
            z9 = false;
        }
        try {
            Gson$FutureTypeAdapter gson$FutureTypeAdapter = new Gson$FutureTypeAdapter();
            map.put(typeToken, gson$FutureTypeAdapter);
            Iterator it = this.e.iterator();
            i iVarA = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                iVarA = ((j) it.next()).a(this, typeToken);
                if (iVarA != null) {
                    if (gson$FutureTypeAdapter.f2446a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    gson$FutureTypeAdapter.f2446a = iVarA;
                    map.put(typeToken, iVarA);
                }
            }
            if (z9) {
                threadLocal.remove();
            }
            if (iVarA == null) {
                androidx.window.layout.c.j(typeToken, "GSON (2.13.2) cannot handle ");
                return null;
            }
            if (z9) {
                concurrentHashMap.putAll(map);
            }
            return iVarA;
        } catch (Throwable th) {
            if (z9) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.i d(com.google.gson.j r8, com.google.gson.reflect.TypeToken r9) {
        /*
            r7 = this;
            java.lang.String r0 = "skipPast must not be null"
            j$.util.Objects.requireNonNull(r8, r0)
            java.lang.String r0 = "type must not be null"
            j$.util.Objects.requireNonNull(r9, r0)
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory r0 = r7.f2459d
            r0.getClass()
            j$.util.concurrent.ConcurrentHashMap r1 = r0.f2491b
            com.google.gson.j r2 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.f2489c
            r3 = 1
            if (r8 != r2) goto L17
            goto L58
        L17:
            java.lang.Class r2 = r9.f2599a
            java.lang.Object r4 = r1.get(r2)
            com.google.gson.j r4 = (com.google.gson.j) r4
            if (r4 == 0) goto L24
            if (r4 != r8) goto L59
            goto L58
        L24:
            java.lang.Class<f3.a> r4 = f3.a.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            f3.a r4 = (f3.a) r4
            if (r4 != 0) goto L2f
            goto L59
        L2f:
            java.lang.Class r4 = r4.value()
            java.lang.Class<com.google.gson.j> r5 = com.google.gson.j.class
            boolean r5 = r5.isAssignableFrom(r4)
            if (r5 != 0) goto L3c
            goto L59
        L3c:
            d0.i r5 = r0.f2490a
            com.google.gson.reflect.TypeToken r6 = new com.google.gson.reflect.TypeToken
            r6.<init>(r4)
            com.google.gson.internal.m r4 = r5.z(r6, r3)
            java.lang.Object r4 = r4.d()
            com.google.gson.j r4 = (com.google.gson.j) r4
            java.lang.Object r1 = r1.putIfAbsent(r2, r4)
            com.google.gson.j r1 = (com.google.gson.j) r1
            if (r1 == 0) goto L56
            r4 = r1
        L56:
            if (r4 != r8) goto L59
        L58:
            r8 = r0
        L59:
            java.util.List r0 = r7.e
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L60:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L79
            java.lang.Object r2 = r0.next()
            com.google.gson.j r2 = (com.google.gson.j) r2
            if (r1 != 0) goto L72
            if (r2 != r8) goto L60
            r1 = r3
            goto L60
        L72:
            com.google.gson.i r2 = r2.a(r7, r9)
            if (r2 == 0) goto L60
            return r2
        L79:
            if (r1 != 0) goto L80
            com.google.gson.i r8 = r7.c(r9)
            return r8
        L80:
            java.lang.String r8 = "GSON cannot serialize or deserialize "
            androidx.window.layout.c.j(r9, r8)
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b.d(com.google.gson.j, com.google.gson.reflect.TypeToken):com.google.gson.i");
    }

    public final void e(Vector vector, Class cls, i3.b bVar) {
        i iVarC = c(new TypeToken(cls));
        int i10 = bVar.h;
        if (i10 == 2) {
            bVar.h = 1;
        }
        boolean z9 = bVar.f8987i;
        boolean z10 = bVar.f8989k;
        bVar.f8987i = this.f;
        bVar.f8989k = false;
        try {
            try {
                iVarC.c(bVar, vector);
            } catch (IOException e) {
                throw new e(e);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e3.getMessage(), e3);
            }
        } finally {
            bVar.n(i10);
            bVar.f8987i = z9;
            bVar.f8989k = z10;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.e + ",instanceCreators:" + this.f2458c + "}";
    }
}
