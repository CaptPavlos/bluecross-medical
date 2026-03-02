package com.inmobi.cmp.core.model;

import f6.o;
import g7.p;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;
import o7.t;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class Vector {
    private int bitLength;
    private Map<Integer, Boolean> map;

    public /* synthetic */ Vector(Map map, int i10, g gVar) {
        this((i10 & 1) != 0 ? new LinkedHashMap() : map);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Vector copy$default(Vector vector, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            map = vector.map;
        }
        return vector.copy(map);
    }

    public final void clear() {
        this.map.clear();
    }

    public final Map<Integer, Boolean> component1() {
        return this.map;
    }

    public final boolean contains(int i10) {
        return this.map.containsKey(Integer.valueOf(i10));
    }

    public final Vector copy(Map<Integer, Boolean> map) {
        map.getClass();
        return new Vector(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Vector) && l.a(this.map, ((Vector) obj).map);
    }

    public final void forEach(p pVar) {
        pVar.getClass();
        for (Map.Entry<Integer, Boolean> entry : this.map.entrySet()) {
            pVar.invoke(entry.getKey(), entry.getValue());
        }
    }

    public final void forEachMap(g7.l lVar) {
        lVar.getClass();
        Iterator<Map.Entry<Integer, Boolean>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    public final Boolean get(int i10) {
        return this.map.get(Integer.valueOf(i10));
    }

    public final Set<Integer> getAcceptedItems() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = getMap().keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (l.a(get(iIntValue), Boolean.TRUE)) {
                linkedHashSet.add(Integer.valueOf(iIntValue));
            }
        }
        return linkedHashSet;
    }

    public final int getBitLength() {
        return this.bitLength;
    }

    public final Set<Integer> getKeys() {
        return this.map.keySet();
    }

    public final Map<Integer, Boolean> getMap() {
        return this.map;
    }

    public final int getMaxId() {
        Integer num = (Integer) t6.l.k0(this.map.keySet());
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final void set(Set<String> set) {
        set.getClass();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            Integer numU = t.U((String) it.next());
            if (numU != null) {
                getMap().put(Integer.valueOf(numU.intValue()), Boolean.TRUE);
                setBitLength(0);
            }
        }
    }

    public final void setAllOwnedItems() {
        Iterator<Map.Entry<Integer, Boolean>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            set(it.next().getKey().intValue());
        }
    }

    public final void setBitLength(int i10) {
        this.bitLength = i10;
    }

    public final void setItems(Set<Integer> set) {
        set.getClass();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            getMap().put(Integer.valueOf(((Number) it.next()).intValue()), Boolean.TRUE);
            setBitLength(0);
        }
    }

    public final void setMap(Map<Integer, Boolean> map) {
        map.getClass();
        this.map = map;
    }

    public final void setOwnedItems(Vector vector) {
        if (vector == null) {
            return;
        }
        vector.forEach(new o(1, this));
    }

    public final int size() {
        return this.map.size();
    }

    public String toString() {
        return "Vector(map=" + this.map + ')';
    }

    public final void unset(Set<Integer> set) {
        set.getClass();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            getMap().put(Integer.valueOf(((Number) it.next()).intValue()), Boolean.FALSE);
            setBitLength(0);
        }
    }

    public final void unsetAllOwnedItems() {
        Iterator<Map.Entry<Integer, Boolean>> it = this.map.entrySet().iterator();
        while (it.hasNext()) {
            unset(it.next().getKey().intValue());
        }
    }

    public Vector(Map<Integer, Boolean> map) {
        map.getClass();
        this.map = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Vector() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final void unset(Vector vector) {
        forEach(new f6.p(vector, this));
    }

    public final void unset(int i10) {
        this.map.put(Integer.valueOf(i10), Boolean.FALSE);
        this.bitLength = 0;
    }

    public final void set(Vector vector) {
        if (vector == null) {
            return;
        }
        vector.forEach(new o(0, this));
    }

    public final void set(int i10) {
        this.map.put(Integer.valueOf(i10), Boolean.TRUE);
    }
}
