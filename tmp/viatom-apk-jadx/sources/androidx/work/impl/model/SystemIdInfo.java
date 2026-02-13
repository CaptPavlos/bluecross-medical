package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})}, primaryKeys = {"work_spec_id", "generation"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SystemIdInfo {

    @ColumnInfo(defaultValue = "0")
    private final int generation;

    @ColumnInfo(name = "system_id")
    public final int systemId;

    @ColumnInfo(name = "work_spec_id")
    public final String workSpecId;

    public SystemIdInfo(String str, int i10, int i11) {
        str.getClass();
        this.workSpecId = str;
        this.generation = i10;
        this.systemId = i11;
    }

    public static /* synthetic */ SystemIdInfo copy$default(SystemIdInfo systemIdInfo, String str, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = systemIdInfo.workSpecId;
        }
        if ((i12 & 2) != 0) {
            i10 = systemIdInfo.generation;
        }
        if ((i12 & 4) != 0) {
            i11 = systemIdInfo.systemId;
        }
        return systemIdInfo.copy(str, i10, i11);
    }

    public final String component1() {
        return this.workSpecId;
    }

    public final int component2() {
        return this.generation;
    }

    public final int component3() {
        return this.systemId;
    }

    public final SystemIdInfo copy(String str, int i10, int i11) {
        str.getClass();
        return new SystemIdInfo(str, i10, i11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SystemIdInfo)) {
            return false;
        }
        SystemIdInfo systemIdInfo = (SystemIdInfo) obj;
        return l.a(this.workSpecId, systemIdInfo.workSpecId) && this.generation == systemIdInfo.generation && this.systemId == systemIdInfo.systemId;
    }

    public final int getGeneration() {
        return this.generation;
    }

    public int hashCode() {
        return (((this.workSpecId.hashCode() * 31) + this.generation) * 31) + this.systemId;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SystemIdInfo(workSpecId=");
        sb.append(this.workSpecId);
        sb.append(", generation=");
        sb.append(this.generation);
        sb.append(", systemId=");
        return a3.a.k(sb, this.systemId, ')');
    }
}
