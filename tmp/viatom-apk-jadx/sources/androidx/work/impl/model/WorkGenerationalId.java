package androidx.work.impl.model;

import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkGenerationalId {
    private final int generation;
    private final String workSpecId;

    public WorkGenerationalId(String str, int i10) {
        str.getClass();
        this.workSpecId = str;
        this.generation = i10;
    }

    public static /* synthetic */ WorkGenerationalId copy$default(WorkGenerationalId workGenerationalId, String str, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = workGenerationalId.workSpecId;
        }
        if ((i11 & 2) != 0) {
            i10 = workGenerationalId.generation;
        }
        return workGenerationalId.copy(str, i10);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final WorkGenerationalId copy(String str, int i10) {
        str.getClass();
        return new WorkGenerationalId(str, i10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkGenerationalId)) {
            return false;
        }
        WorkGenerationalId workGenerationalId = (WorkGenerationalId) obj;
        return l.a(this.workSpecId, workGenerationalId.workSpecId) && this.generation == workGenerationalId.generation;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public final String getWorkSpecId() {
        return this.workSpecId;
    }

    public int hashCode() {
        return (this.workSpecId.hashCode() * 31) + this.generation;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("WorkGenerationalId(workSpecId=");
        sb.append(this.workSpecId);
        sb.append(", generation=");
        return a3.a.k(sb, this.generation, ')');
    }
}
