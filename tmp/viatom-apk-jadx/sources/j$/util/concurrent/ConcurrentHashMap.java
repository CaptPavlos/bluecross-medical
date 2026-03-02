package j$.util.concurrent;

import j$.util.Map;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* loaded from: classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, Map {
    public static final int g = Runtime.getRuntime().availableProcessors();
    public static final j$.sun.misc.a h;

    /* renamed from: i, reason: collision with root package name */
    public static final long f9355i;

    /* renamed from: j, reason: collision with root package name */
    public static final long f9356j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f9357k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f9358l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f9359m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f9360n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f9361o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a, reason: collision with root package name */
    public volatile transient l[] f9362a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient l[] f9363b;
    private volatile transient long baseCount;

    /* renamed from: c, reason: collision with root package name */
    public volatile transient c[] f9364c;
    private volatile transient int cellsBusy;

    /* renamed from: d, reason: collision with root package name */
    public transient i f9365d;
    public transient s e;
    public transient e f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    public static final int i(int i10) {
        return (i10 ^ (i10 >>> 16)) & Integer.MAX_VALUE;
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        j$.sun.misc.a aVar = j$.sun.misc.a.f9125b;
        h = aVar;
        f9355i = aVar.h(ConcurrentHashMap.class, "sizeCtl");
        f9356j = aVar.h(ConcurrentHashMap.class, "transferIndex");
        f9357k = aVar.h(ConcurrentHashMap.class, "baseCount");
        f9358l = aVar.h(ConcurrentHashMap.class, "cellsBusy");
        f9359m = aVar.h(c.class, "value");
        f9360n = aVar.a(l[].class);
        int iB = aVar.b(l[].class);
        if (((iB - 1) & iB) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        f9361o = 31 - Integer.numberOfLeadingZeros(iB);
    }

    public static final int l(int i10) {
        int iNumberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i10 - 1);
        if (iNumberOfLeadingZeros < 0) {
            return 1;
        }
        if (iNumberOfLeadingZeros >= 1073741824) {
            return 1073741824;
        }
        return iNumberOfLeadingZeros + 1;
    }

    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() != Comparable.class || (actualTypeArguments = parameterizedType.getActualTypeArguments()) == null || actualTypeArguments.length != 1 || actualTypeArguments[0] != cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    public static final l k(l[] lVarArr, int i10) {
        return (l) h.f(lVarArr, (i10 << f9361o) + f9360n);
    }

    public static final boolean b(l[] lVarArr, int i10, l lVar) {
        return j$.com.android.tools.r8.a.z(h.f9126a, lVarArr, (i10 << f9361o) + f9360n, lVar);
    }

    public static final void h(l[] lVarArr, int i10, l lVar) {
        h.j(lVarArr, (i10 << f9361o) + f9360n, lVar);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i10) {
        this(i10, 0.75f, 1);
    }

    public ConcurrentHashMap(int i10, float f, int i11) {
        if (f <= 0.0f || i10 < 0 || i11 <= 0) {
            throw new IllegalArgumentException();
        }
        long j10 = (long) (((i10 < i11 ? i11 : i10) / f) + 1.0d);
        this.sizeCtl = j10 >= 1073741824 ? 1073741824 : l((int) j10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j10 = j();
        if (j10 < 0) {
            return 0;
        }
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        return j() <= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        int length;
        l lVarK;
        Object obj2;
        int i10 = i(obj.hashCode());
        l[] lVarArr = this.f9362a;
        if (lVarArr == null || (length = lVarArr.length) <= 0 || (lVarK = k(lVarArr, (length - 1) & i10)) == null) {
            return null;
        }
        int i11 = lVarK.f9381a;
        if (i11 == i10) {
            Object obj3 = lVarK.f9382b;
            if (obj3 == obj || (obj3 != null && obj.equals(obj3))) {
                return (V) lVarK.f9383c;
            }
        } else if (i11 < 0) {
            l lVarA = lVarK.a(i10, obj);
            if (lVarA != null) {
                return (V) lVarA.f9383c;
            }
            return null;
        }
        while (true) {
            lVarK = lVarK.f9384d;
            if (lVarK == null) {
                return null;
            }
            if (lVarK.f9381a == i10 && ((obj2 = lVarK.f9382b) == obj || (obj2 != null && obj.equals(obj2)))) {
                break;
            }
        }
        return (V) lVarK.f9383c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f9362a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                Object obj2 = lVarA.f9383c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k10, V v6) {
        return (V) f(k10, v6, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x006a, code lost:
    
        r7 = r6.f9383c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006c, code lost:
    
        if (r11 != false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x006e, code lost:
    
        r6.f9383c = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00a5, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.f(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        o(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) g(obj, null, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0045, code lost:
    
        r9 = r5.f9383c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0047, code lost:
    
        if (r15 == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0049, code lost:
    
        if (r15 == r9) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
    
        if (r9 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0051, code lost:
    
        if (r15.equals(r9) == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0053, code lost:
    
        if (r14 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0055, code lost:
    
        r5.f9383c = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0058, code lost:
    
        r5 = r5.f9384d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x005a, code lost:
    
        if (r8 == null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005c, code lost:
    
        r8.f9384d = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x005f, code lost:
    
        h(r1, r3, r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object g(java.lang.Object r13, java.lang.Object r14, java.lang.Object r15) {
        /*
            r12 = this;
            int r0 = r13.hashCode()
            int r0 = i(r0)
            j$.util.concurrent.l[] r1 = r12.f9362a
        La:
            r2 = 0
            if (r1 == 0) goto Lbe
            int r3 = r1.length
            if (r3 == 0) goto Lbe
            int r3 = r3 + (-1)
            r3 = r3 & r0
            j$.util.concurrent.l r4 = k(r1, r3)
            if (r4 != 0) goto L1b
            goto Lbe
        L1b:
            int r5 = r4.f9381a
            r6 = -1
            if (r5 != r6) goto L25
            j$.util.concurrent.l[] r1 = r12.d(r1, r4)
            goto La
        L25:
            monitor-enter(r4)
            j$.util.concurrent.l r7 = k(r1, r3)     // Catch: java.lang.Throwable -> L42
            if (r7 != r4) goto Lad
            r7 = 1
            if (r5 < 0) goto L6c
            r8 = r2
            r5 = r4
        L31:
            int r9 = r5.f9381a     // Catch: java.lang.Throwable -> L42
            if (r9 != r0) goto L63
            java.lang.Object r9 = r5.f9382b     // Catch: java.lang.Throwable -> L42
            if (r9 == r13) goto L45
            if (r9 == 0) goto L63
            boolean r9 = r13.equals(r9)     // Catch: java.lang.Throwable -> L42
            if (r9 == 0) goto L63
            goto L45
        L42:
            r13 = move-exception
            goto Lbc
        L45:
            java.lang.Object r9 = r5.f9383c     // Catch: java.lang.Throwable -> L42
            if (r15 == 0) goto L53
            if (r15 == r9) goto L53
            if (r9 == 0) goto Lae
            boolean r10 = r15.equals(r9)     // Catch: java.lang.Throwable -> L42
            if (r10 == 0) goto Lae
        L53:
            if (r14 == 0) goto L58
            r5.f9383c = r14     // Catch: java.lang.Throwable -> L42
            goto Laf
        L58:
            j$.util.concurrent.l r5 = r5.f9384d
            if (r8 == 0) goto L5f
            r8.f9384d = r5     // Catch: java.lang.Throwable -> L42
            goto Laf
        L5f:
            h(r1, r3, r5)     // Catch: java.lang.Throwable -> L42
            goto Laf
        L63:
            j$.util.concurrent.l r8 = r5.f9384d     // Catch: java.lang.Throwable -> L42
            if (r8 != 0) goto L68
            goto Lae
        L68:
            r11 = r8
            r8 = r5
            r5 = r11
            goto L31
        L6c:
            boolean r5 = r4 instanceof j$.util.concurrent.q     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto La0
            r5 = r4
            j$.util.concurrent.q r5 = (j$.util.concurrent.q) r5     // Catch: java.lang.Throwable -> L42
            j$.util.concurrent.r r8 = r5.e     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto Lae
            j$.util.concurrent.r r8 = r8.b(r0, r13, r2)     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto Lae
            java.lang.Object r9 = r8.f9383c     // Catch: java.lang.Throwable -> L42
            if (r15 == 0) goto L8b
            if (r15 == r9) goto L8b
            if (r9 == 0) goto Lae
            boolean r10 = r15.equals(r9)     // Catch: java.lang.Throwable -> L42
            if (r10 == 0) goto Lae
        L8b:
            if (r14 == 0) goto L90
            r8.f9383c = r14     // Catch: java.lang.Throwable -> L42
            goto Laf
        L90:
            boolean r8 = r5.f(r8)     // Catch: java.lang.Throwable -> L42
            if (r8 == 0) goto Laf
            j$.util.concurrent.r r5 = r5.f     // Catch: java.lang.Throwable -> L42
            j$.util.concurrent.l r5 = p(r5)     // Catch: java.lang.Throwable -> L42
            h(r1, r3, r5)     // Catch: java.lang.Throwable -> L42
            goto Laf
        La0:
            boolean r3 = r4 instanceof j$.util.concurrent.m     // Catch: java.lang.Throwable -> L42
            if (r3 != 0) goto La5
            goto Lad
        La5:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L42
            java.lang.String r14 = "Recursive update"
            r13.<init>(r14)     // Catch: java.lang.Throwable -> L42
            throw r13     // Catch: java.lang.Throwable -> L42
        Lad:
            r7 = 0
        Lae:
            r9 = r2
        Laf:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            if (r7 == 0) goto La
            if (r9 == 0) goto Lbe
            if (r14 != 0) goto Lbb
            r13 = -1
            r12.a(r13, r6)
        Lbb:
            return r9
        Lbc:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            throw r13
        Lbe:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.g(java.lang.Object, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        l lVarK;
        l lVar;
        l[] lVarArrD = this.f9362a;
        long j10 = 0;
        loop0: while (true) {
            int i10 = 0;
            while (lVarArrD != null && i10 < lVarArrD.length) {
                lVarK = k(lVarArrD, i10);
                if (lVarK == null) {
                    i10++;
                } else {
                    int i11 = lVarK.f9381a;
                    if (i11 == -1) {
                        break;
                    }
                    synchronized (lVarK) {
                        try {
                            if (k(lVarArrD, i10) == lVarK) {
                                if (i11 >= 0) {
                                    lVar = lVarK;
                                } else {
                                    lVar = lVarK instanceof q ? ((q) lVarK).f : null;
                                }
                                while (lVar != null) {
                                    j10--;
                                    lVar = lVar.f9384d;
                                }
                                h(lVarArrD, i10, null);
                                i10++;
                            }
                        } finally {
                        }
                    }
                }
            }
            lVarArrD = d(lVarArrD, lVarK);
        }
        if (j10 != 0) {
            a(j10, -1);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i iVar = this.f9365d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.f9365d = iVar2;
        return iVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        s sVar = this.e;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.e = sVar2;
        return sVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        l[] lVarArr = this.f9362a;
        int iHashCode = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                iHashCode += lVarA.f9383c.hashCode() ^ lVarA.f9382b.hashCode();
            }
        }
        return iHashCode;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        l[] lVarArr = this.f9362a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l lVarA = pVar.a();
        if (lVarA != null) {
            while (true) {
                Object obj = lVarA.f9382b;
                Object obj2 = lVarA.f9383c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        V value;
        V v6;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        l[] lVarArr = this.f9362a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA != null) {
                Object obj2 = lVarA.f9383c;
                Object obj3 = map.get(lVarA.f9382b);
                if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                    break;
                }
            } else {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v6 = get(key)) == null || (value != v6 && !value.equals(v6))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        int i10 = 0;
        int i11 = 1;
        while (i11 < 16) {
            i10++;
            i11 <<= 1;
        }
        int i12 = 32 - i10;
        int i13 = i11 - 1;
        n[] nVarArr = new n[16];
        for (int i14 = 0; i14 < 16; i14++) {
            nVarArr[i14] = new n();
        }
        ObjectOutputStream.PutField putFieldPutFields = objectOutputStream.putFields();
        putFieldPutFields.put("segments", nVarArr);
        putFieldPutFields.put("segmentShift", i12);
        putFieldPutFields.put("segmentMask", i13);
        objectOutputStream.writeFields();
        l[] lVarArr = this.f9362a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l lVarA = pVar.a();
                if (lVarA == null) {
                    break;
                }
                objectOutputStream.writeObject(lVarA.f9382b);
                objectOutputStream.writeObject(lVarA.f9383c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        long j10;
        long j11;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j12 = 0;
        long j13 = 0;
        l lVar = null;
        while (true) {
            Object object = objectInputStream.readObject();
            Object object2 = objectInputStream.readObject();
            j10 = 1;
            if (object == null || object2 == null) {
                break;
            }
            j13++;
            lVar = new l(i(object.hashCode()), object, object2, lVar);
        }
        if (j13 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j14 = (long) ((j13 / 0.75f) + 1.0d);
        int iL = j14 >= 1073741824 ? 1073741824 : l((int) j14);
        l[] lVarArr = new l[iL];
        int i10 = iL - 1;
        while (lVar != null) {
            l lVar2 = lVar.f9384d;
            int i11 = lVar.f9381a;
            int i12 = i11 & i10;
            l lVarK = k(lVarArr, i12);
            boolean z9 = true;
            if (lVarK == null) {
                j11 = j10;
            } else {
                Object obj2 = lVar.f9382b;
                if (lVarK.f9381a < 0) {
                    if (((q) lVarK).e(i11, obj2, lVar.f9383c) == null) {
                        j12 += j10;
                    }
                    j11 = j10;
                } else {
                    j11 = j10;
                    int i13 = 0;
                    for (l lVar3 = lVarK; lVar3 != null; lVar3 = lVar3.f9384d) {
                        if (lVar3.f9381a == i11 && ((obj = lVar3.f9382b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z9 = false;
                            break;
                        }
                        i13++;
                    }
                    if (z9 && i13 >= 8) {
                        j12 += j11;
                        lVar.f9384d = lVarK;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.f9381a, lVar4.f9382b, lVar4.f9383c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f9384d = rVar3;
                            }
                            lVar4 = lVar4.f9384d;
                            rVar2 = rVar3;
                        }
                        h(lVarArr, i12, new q(rVar));
                    }
                }
                z9 = false;
            }
            if (z9) {
                j12 += j11;
                lVar.f9384d = lVarK;
                h(lVarArr, i12, lVar);
            }
            lVar = lVar2;
            j10 = j11;
        }
        this.f9362a = lVarArr;
        this.sizeCtl = iL - (iL >>> 2);
        this.baseCount = j12;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k10, V v6) {
        return (V) f(k10, v6, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return g(obj, obj3, obj2) != null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            throw null;
        }
        return g(obj, obj2, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        V v6 = get(obj);
        return v6 == null ? obj2 : v6;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f9362a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            } else {
                biConsumer.accept(lVarA.f9382b, lVarA.f9383c);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f9362a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l lVarA = pVar.a();
            if (lVarA == null) {
                return;
            }
            Object obj = lVarA.f9383c;
            Object obj2 = lVarA.f9382b;
            do {
                Object objApply = biFunction.apply(obj2, obj);
                objApply.getClass();
                if (g(obj2, objApply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x008c, code lost:
    
        r5 = r5.f9383c;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object computeIfAbsent(java.lang.Object r12, java.util.function.Function r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00aa, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object computeIfPresent(java.lang.Object r14, java.util.function.BiFunction r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto Lbd
            if (r15 == 0) goto Lbd
            int r1 = r14.hashCode()
            int r1 = i(r1)
            j$.util.concurrent.l[] r2 = r13.f9362a
            r3 = 0
            r5 = r0
            r4 = r3
        L12:
            if (r2 == 0) goto Lb7
            int r6 = r2.length
            if (r6 != 0) goto L19
            goto Lb7
        L19:
            int r6 = r6 + (-1)
            r6 = r6 & r1
            j$.util.concurrent.l r7 = k(r2, r6)
            if (r7 != 0) goto L24
            goto Lae
        L24:
            int r8 = r7.f9381a
            r9 = -1
            if (r8 != r9) goto L2e
            j$.util.concurrent.l[] r2 = r13.d(r2, r7)
            goto L12
        L2e:
            monitor-enter(r7)
            j$.util.concurrent.l r10 = k(r2, r6)     // Catch: java.lang.Throwable -> L4b
            if (r10 != r7) goto Lab
            if (r8 < 0) goto L70
            r4 = 1
            r10 = r0
            r8 = r7
        L3a:
            int r11 = r8.f9381a     // Catch: java.lang.Throwable -> L4b
            if (r11 != r1) goto L65
            java.lang.Object r11 = r8.f9382b     // Catch: java.lang.Throwable -> L4b
            if (r11 == r14) goto L4e
            if (r11 == 0) goto L65
            boolean r11 = r14.equals(r11)     // Catch: java.lang.Throwable -> L4b
            if (r11 == 0) goto L65
            goto L4e
        L4b:
            r14 = move-exception
            goto Lb5
        L4e:
            java.lang.Object r5 = r8.f9383c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L59
            r8.f9383c = r5     // Catch: java.lang.Throwable -> L4b
            goto Lab
        L59:
            j$.util.concurrent.l r3 = r8.f9384d     // Catch: java.lang.Throwable -> L4b
            if (r10 == 0) goto L60
            r10.f9384d = r3     // Catch: java.lang.Throwable -> L4b
            goto L63
        L60:
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L63:
            r3 = r9
            goto Lab
        L65:
            j$.util.concurrent.l r10 = r8.f9384d     // Catch: java.lang.Throwable -> L4b
            if (r10 != 0) goto L6a
            goto Lab
        L6a:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L3a
        L70:
            boolean r8 = r7 instanceof j$.util.concurrent.q     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9e
            r4 = r7
            j$.util.concurrent.q r4 = (j$.util.concurrent.q) r4     // Catch: java.lang.Throwable -> L4b
            j$.util.concurrent.r r8 = r4.e     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            j$.util.concurrent.r r8 = r8.b(r1, r14, r0)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            java.lang.Object r5 = r8.f9383c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L8c
            r8.f9383c = r5     // Catch: java.lang.Throwable -> L4b
            goto L9c
        L8c:
            boolean r3 = r4.f(r8)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L9b
            j$.util.concurrent.r r3 = r4.f     // Catch: java.lang.Throwable -> L4b
            j$.util.concurrent.l r3 = p(r3)     // Catch: java.lang.Throwable -> L4b
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L9b:
            r3 = r9
        L9c:
            r4 = 2
            goto Lab
        L9e:
            boolean r6 = r7 instanceof j$.util.concurrent.m     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto La3
            goto Lab
        La3:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L4b
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch: java.lang.Throwable -> L4b
            throw r14     // Catch: java.lang.Throwable -> L4b
        Lab:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L12
        Lae:
            if (r3 == 0) goto Lb4
            long r14 = (long) r3
            r13.a(r14, r4)
        Lb4:
            return r5
        Lb5:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            throw r14
        Lb7:
            j$.util.concurrent.l[] r2 = r13.e()
            goto L12
        Lbd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        l lVar;
        Object objApply;
        Object obj2;
        if (obj == null || biFunction == null) {
            throw null;
        }
        int i10 = i(obj.hashCode());
        l[] lVarArrE = this.f9362a;
        int i11 = 0;
        Object objApply2 = null;
        int i12 = 0;
        while (true) {
            if (lVarArrE != null) {
                int length = lVarArrE.length;
                if (length != 0) {
                    int i13 = (length - 1) & i10;
                    l lVarK = k(lVarArrE, i13);
                    if (lVarK == null) {
                        m mVar = new m();
                        synchronized (mVar) {
                            try {
                                if (b(lVarArrE, i13, mVar)) {
                                    try {
                                        objApply2 = biFunction.apply(obj, null);
                                        if (objApply2 != null) {
                                            lVar = new l(i10, obj, objApply2);
                                            i12 = 1;
                                        } else {
                                            lVar = null;
                                        }
                                        h(lVarArrE, i13, lVar);
                                        i11 = 1;
                                    } catch (Throwable th) {
                                        h(lVarArrE, i13, null);
                                        throw th;
                                    }
                                }
                            } finally {
                            }
                        }
                        if (i11 != 0) {
                        }
                    } else {
                        int i14 = lVarK.f9381a;
                        if (i14 == -1) {
                            lVarArrE = d(lVarArrE, lVarK);
                        } else {
                            synchronized (lVarK) {
                                try {
                                    if (k(lVarArrE, i13) == lVarK) {
                                        if (i14 >= 0) {
                                            l lVar2 = null;
                                            l lVar3 = lVarK;
                                            i11 = 1;
                                            while (true) {
                                                if (lVar3.f9381a == i10 && ((obj2 = lVar3.f9382b) == obj || (obj2 != null && obj.equals(obj2)))) {
                                                    break;
                                                }
                                                l lVar4 = lVar3.f9384d;
                                                if (lVar4 == null) {
                                                    objApply = biFunction.apply(obj, null);
                                                    if (objApply != null) {
                                                        if (lVar3.f9384d != null) {
                                                            throw new IllegalStateException("Recursive update");
                                                        }
                                                        lVar3.f9384d = new l(i10, obj, objApply);
                                                        i12 = 1;
                                                    }
                                                } else {
                                                    i11++;
                                                    lVar2 = lVar3;
                                                    lVar3 = lVar4;
                                                }
                                            }
                                            Object objApply3 = biFunction.apply(obj, lVar3.f9383c);
                                            if (objApply3 != null) {
                                                lVar3.f9383c = objApply3;
                                                objApply2 = objApply3;
                                            } else {
                                                l lVar5 = lVar3.f9384d;
                                                if (lVar2 != null) {
                                                    lVar2.f9384d = lVar5;
                                                } else {
                                                    h(lVarArrE, i13, lVar5);
                                                }
                                                objApply2 = objApply3;
                                                i12 = -1;
                                            }
                                        } else if (lVarK instanceof q) {
                                            q qVar = (q) lVarK;
                                            r rVar = qVar.e;
                                            r rVarB = rVar != null ? rVar.b(i10, obj, null) : null;
                                            objApply = biFunction.apply(obj, rVarB == null ? null : rVarB.f9383c);
                                            if (objApply != null) {
                                                if (rVarB != null) {
                                                    rVarB.f9383c = objApply;
                                                } else {
                                                    qVar.e(i10, obj, objApply);
                                                    i12 = 1;
                                                }
                                            } else if (rVarB != null) {
                                                if (qVar.f(rVarB)) {
                                                    h(lVarArrE, i13, p(qVar.f));
                                                }
                                                i12 = -1;
                                            }
                                            i11 = 1;
                                            objApply2 = objApply;
                                        } else if (lVarK instanceof m) {
                                            throw new IllegalStateException("Recursive update");
                                        }
                                    }
                                } finally {
                                }
                            }
                            if (i11 != 0) {
                                if (i11 >= 8) {
                                    n(lVarArrE, i13);
                                }
                            }
                        }
                    }
                }
            }
            lVarArrE = e();
        }
        if (i12 != 0) {
            a(i12, i11);
        }
        return objApply2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x00dd, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object merge(java.lang.Object r18, java.lang.Object r19, java.util.function.BiFunction r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public boolean contains(Object obj) {
        return containsValue(obj);
    }

    public final l[] e() {
        while (true) {
            l[] lVarArr = this.f9362a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i10 = this.sizeCtl;
            if (i10 < 0) {
                Thread.yield();
            } else if (h.c(this, f9355i, i10, -1)) {
                try {
                    l[] lVarArr2 = this.f9362a;
                    if (lVarArr2 == null || lVarArr2.length == 0) {
                        int i11 = i10 > 0 ? i10 : 16;
                        l[] lVarArr3 = new l[i11];
                        this.f9362a = lVarArr3;
                        i10 = i11 - (i11 >>> 2);
                        lVarArr2 = lVarArr3;
                    }
                    this.sizeCtl = i10;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i10;
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:97:0x0140, code lost:
    
        if (r1.f9364c != r6) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0142, code lost:
    
        r1.f9364c = (j$.util.concurrent.c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r25, int r27) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    public final l[] d(l[] lVarArr, l lVar) {
        int i10;
        if (lVar instanceof g) {
            l[] lVarArr2 = ((g) lVar).e;
            int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
            while (lVarArr2 == this.f9363b && this.f9362a == lVarArr && (i10 = this.sizeCtl) < 0 && (i10 >>> 16) == iNumberOfLeadingZeros && i10 != iNumberOfLeadingZeros + 1 && i10 != 65535 + iNumberOfLeadingZeros && this.transferIndex > 0) {
                if (h.c(this, f9355i, i10, i10 + 1)) {
                    m(lVarArr, lVarArr2);
                    break;
                }
            }
            return lVarArr2;
        }
        return this.f9362a;
    }

    public final void o(int i10) {
        int length;
        int iL = i10 >= 536870912 ? 1073741824 : l(i10 + (i10 >>> 1) + 1);
        while (true) {
            int i11 = this.sizeCtl;
            if (i11 < 0) {
                break;
            }
            l[] lVarArr = this.f9362a;
            if (lVarArr == null || (length = lVarArr.length) == 0) {
                int i12 = i11 > iL ? i11 : iL;
                if (h.c(this, f9355i, i11, -1)) {
                    try {
                        if (this.f9362a == lVarArr) {
                            this.f9362a = new l[i12];
                            i11 = i12 - (i12 >>> 2);
                        }
                    } finally {
                        this.sizeCtl = i11;
                    }
                } else {
                    continue;
                }
            } else if (iL <= i11 || length >= 1073741824) {
                break;
            } else if (lVarArr == this.f9362a) {
                if (h.c(this, f9355i, i11, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                    m(lVarArr, null);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r10v9, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r5v5, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v10, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v15, types: [j$.util.concurrent.l] */
    public final void m(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z9;
        char c10;
        int i14;
        int i15;
        l qVar;
        l qVar2;
        r lVar;
        int i16;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int length = lVarArr.length;
        int i17 = g;
        boolean z10 = true;
        int i18 = i17 > 1 ? (length >>> 3) / i17 : length;
        char c11 = 16;
        int i19 = i18 < 16 ? 16 : i18;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr4 = new l[length << 1];
                concurrentHashMap.f9363b = lVarArr4;
                concurrentHashMap.transferIndex = length;
                lVarArr3 = lVarArr4;
            } catch (Throwable unused) {
                concurrentHashMap.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar = new g(lVarArr3);
        boolean zB = true;
        int i20 = 0;
        int i21 = 0;
        boolean z11 = false;
        while (true) {
            if (zB) {
                int i22 = i20 - 1;
                if (i22 >= i21 || z11) {
                    i21 = i21;
                    i20 = i22;
                    zB = false;
                } else {
                    int i23 = concurrentHashMap.transferIndex;
                    if (i23 <= 0) {
                        i20 = -1;
                    } else {
                        j$.sun.misc.a aVar = h;
                        int i24 = i21;
                        long j10 = f9356j;
                        if (i23 > i19) {
                            i11 = i24;
                            i12 = i23 - i19;
                            i10 = i22;
                        } else {
                            i10 = i22;
                            i11 = i24;
                            i12 = 0;
                        }
                        boolean zC = aVar.c(concurrentHashMap, j10, i23, i12);
                        i21 = i12;
                        if (zC) {
                            i20 = i23 - 1;
                        } else {
                            i21 = i11;
                            i20 = i10;
                        }
                    }
                    zB = false;
                }
            } else {
                int i25 = i21;
                r lVar2 = null;
                if (i20 < 0 || i20 >= length || (i15 = i20 + length) >= length2) {
                    i13 = length;
                    z9 = z10;
                    c10 = c11;
                    i14 = i19;
                    if (z11) {
                        concurrentHashMap.f9363b = null;
                        concurrentHashMap.f9362a = lVarArr3;
                        concurrentHashMap.sizeCtl = (i13 << 1) - (i13 >>> 1);
                        return;
                    }
                    int i26 = i20;
                    j$.sun.misc.a aVar2 = h;
                    long j11 = f9355i;
                    int i27 = concurrentHashMap.sizeCtl;
                    if (!aVar2.c(concurrentHashMap, j11, i27, i27 - 1)) {
                        i20 = i26;
                    } else {
                        if (i27 - 2 != ((Integer.numberOfLeadingZeros(i13) | 32768) << 16)) {
                            return;
                        }
                        zB = z9;
                        z11 = zB;
                        i20 = i13;
                    }
                } else {
                    ?? K = k(lVarArr, i20);
                    if (K == 0) {
                        zB = b(lVarArr, i20, gVar);
                        i13 = length;
                        z9 = z10;
                        c10 = c11;
                        i14 = i19;
                    } else {
                        z9 = z10;
                        int i28 = K.f9381a;
                        if (i28 == -1) {
                            i13 = length;
                            c10 = c11;
                            i14 = i19;
                            zB = z9;
                        } else {
                            synchronized (K) {
                                try {
                                    if (k(lVarArr, i20) == K) {
                                        if (i28 >= 0) {
                                            int i29 = i28 & length;
                                            r rVar = K;
                                            for (r rVar2 = K.f9384d; rVar2 != null; rVar2 = rVar2.f9384d) {
                                                char c12 = c11;
                                                int i30 = rVar2.f9381a & length;
                                                if (i30 != i29) {
                                                    rVar = rVar2;
                                                    i29 = i30;
                                                }
                                                c11 = c12;
                                            }
                                            c10 = c11;
                                            if (i29 == 0) {
                                                lVar = null;
                                                lVar2 = rVar;
                                            } else {
                                                lVar = rVar;
                                            }
                                            l lVar3 = K;
                                            while (lVar3 != rVar) {
                                                int i31 = lVar3.f9381a;
                                                Object obj = lVar3.f9382b;
                                                int i32 = length;
                                                Object obj2 = lVar3.f9383c;
                                                if ((i31 & i32) == 0) {
                                                    i16 = i19;
                                                    lVar2 = new l(i31, obj, obj2, lVar2);
                                                } else {
                                                    i16 = i19;
                                                    lVar = new l(i31, obj, obj2, lVar);
                                                }
                                                lVar3 = lVar3.f9384d;
                                                length = i32;
                                                i19 = i16;
                                            }
                                            i13 = length;
                                            i14 = i19;
                                            h(lVarArr3, i20, lVar2);
                                            h(lVarArr3, i15, lVar);
                                            h(lVarArr, i20, gVar);
                                        } else {
                                            i13 = length;
                                            c10 = c11;
                                            i14 = i19;
                                            if (K instanceof q) {
                                                q qVar3 = (q) K;
                                                r rVar3 = null;
                                                r rVar4 = null;
                                                l lVar4 = qVar3.f;
                                                int i33 = 0;
                                                int i34 = 0;
                                                r rVar5 = null;
                                                while (lVar4 != null) {
                                                    q qVar4 = qVar3;
                                                    int i35 = lVar4.f9381a;
                                                    r rVar6 = new r(i35, lVar4.f9382b, lVar4.f9383c, null, null);
                                                    if ((i35 & i13) == 0) {
                                                        rVar6.h = rVar4;
                                                        if (rVar4 == null) {
                                                            lVar2 = rVar6;
                                                        } else {
                                                            rVar4.f9384d = rVar6;
                                                        }
                                                        i33++;
                                                        rVar4 = rVar6;
                                                    } else {
                                                        rVar6.h = rVar3;
                                                        if (rVar3 == null) {
                                                            rVar5 = rVar6;
                                                        } else {
                                                            rVar3.f9384d = rVar6;
                                                        }
                                                        i34++;
                                                        rVar3 = rVar6;
                                                    }
                                                    lVar4 = lVar4.f9384d;
                                                    qVar3 = qVar4;
                                                }
                                                q qVar5 = qVar3;
                                                if (i33 <= 6) {
                                                    qVar = p(lVar2);
                                                } else {
                                                    qVar = i34 != 0 ? new q(lVar2) : qVar5;
                                                }
                                                if (i34 <= 6) {
                                                    qVar2 = p(rVar5);
                                                } else {
                                                    qVar2 = i33 != 0 ? new q(rVar5) : qVar5;
                                                }
                                                h(lVarArr3, i20, qVar);
                                                h(lVarArr3, i15, qVar2);
                                                h(lVarArr, i20, gVar);
                                            }
                                        }
                                        zB = z9;
                                    } else {
                                        i13 = length;
                                        c10 = c11;
                                        i14 = i19;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                concurrentHashMap = this;
                i21 = i25;
                z10 = z9;
                c11 = c10;
                length = i13;
                i19 = i14;
            }
        }
    }

    public final long j() {
        c[] cVarArr = this.f9364c;
        long j10 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j10 += cVar.value;
                }
            }
        }
        return j10;
    }

    public final void n(l[] lVarArr, int i10) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l lVarK = k(lVarArr, i10);
        if (lVarK == null || lVarK.f9381a < 0) {
            return;
        }
        synchronized (lVarK) {
            try {
                if (k(lVarArr, i10) == lVarK) {
                    r rVar = null;
                    r rVar2 = null;
                    l lVar = lVarK;
                    while (lVar != null) {
                        r rVar3 = new r(lVar.f9381a, lVar.f9382b, lVar.f9383c, null, null);
                        rVar3.h = rVar2;
                        if (rVar2 == null) {
                            rVar = rVar3;
                        } else {
                            rVar2.f9384d = rVar3;
                        }
                        lVar = lVar.f9384d;
                        rVar2 = rVar3;
                    }
                    h(lVarArr, i10, new q(rVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [j$.util.concurrent.l] */
    public static l p(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (r rVar2 = rVar; rVar2 != null; rVar2 = rVar2.f9384d) {
            l lVar3 = new l(rVar2.f9381a, rVar2.f9382b, rVar2.f9383c);
            if (lVar2 == null) {
                lVar = lVar3;
            } else {
                lVar2.f9384d = lVar3;
            }
            lVar2 = lVar3;
        }
        return lVar;
    }
}
