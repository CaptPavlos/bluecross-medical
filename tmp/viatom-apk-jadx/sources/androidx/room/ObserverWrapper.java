package androidx.room;

import androidx.room.InvalidationTracker;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import o7.u;
import t6.v;
import u6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ObserverWrapper {
    private final InvalidationTracker.Observer observer;
    private final Set<String> singleTableSet;
    private final int[] tableIds;
    private final String[] tableNames;

    public ObserverWrapper(InvalidationTracker.Observer observer, int[] iArr, String[] strArr) {
        Set<String> setSingleton;
        observer.getClass();
        iArr.getClass();
        strArr.getClass();
        this.observer = observer;
        this.tableIds = iArr;
        this.tableNames = strArr;
        if (iArr.length != strArr.length) {
            androidx.window.layout.c.g("Check failed.");
            throw null;
        }
        if (strArr.length == 0) {
            setSingleton = v.f12810a;
        } else {
            setSingleton = Collections.singleton(strArr[0]);
            setSingleton.getClass();
        }
        this.singleTableSet = setSingleton;
    }

    public final InvalidationTracker.Observer getObserver$room_runtime_release() {
        return this.observer;
    }

    public final int[] getTableIds$room_runtime_release() {
        return this.tableIds;
    }

    public final void notifyByTableIds$room_runtime_release(Set<Integer> set) {
        set.getClass();
        int[] iArr = this.tableIds;
        int length = iArr.length;
        Set<String> setO = v.f12810a;
        if (length != 0) {
            int i10 = 0;
            if (length != 1) {
                i iVar = new i();
                int[] iArr2 = this.tableIds;
                int length2 = iArr2.length;
                int i11 = 0;
                while (i10 < length2) {
                    int i12 = i11 + 1;
                    if (set.contains(Integer.valueOf(iArr2[i10]))) {
                        iVar.add(this.tableNames[i11]);
                    }
                    i10++;
                    i11 = i12;
                }
                setO = l1.b.o(iVar);
            } else if (set.contains(Integer.valueOf(iArr[0]))) {
                setO = this.singleTableSet;
            }
        }
        if (setO.isEmpty()) {
            return;
        }
        this.observer.onInvalidated(setO);
    }

    public final void notifyByTableNames$room_runtime_release(Set<String> set) {
        set.getClass();
        int length = this.tableNames.length;
        Set<String> setO = v.f12810a;
        if (length != 0) {
            if (length != 1) {
                i iVar = new i();
                for (String str : set) {
                    String[] strArr = this.tableNames;
                    int length2 = strArr.length;
                    int i10 = 0;
                    while (true) {
                        if (i10 < length2) {
                            String str2 = strArr[i10];
                            if (u.Z(str2, str, true)) {
                                iVar.add(str2);
                                break;
                            }
                            i10++;
                        }
                    }
                }
                setO = l1.b.o(iVar);
            } else if (!set.isEmpty()) {
                Iterator<T> it = set.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (u.Z((String) it.next(), this.tableNames[0], true)) {
                            setO = this.singleTableSet;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        if (setO.isEmpty()) {
            return;
        }
        this.observer.onInvalidated(setO);
    }
}
