package androidx.work.impl.model;

import androidx.room.AmbiguousColumnResolver;
import androidx.sqlite.SQLiteConnection;
import g7.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f730a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Serializable f731b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f732c;

    public /* synthetic */ c(int i10, String str) {
        this.f730a = 2;
        this.f732c = i10;
        this.f731b = str;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f730a) {
            case 0:
                return SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$3("DELETE FROM SystemIdInfo where work_spec_id=? AND generation=?", (String) this.f731b, this.f732c, (SQLiteConnection) obj);
            case 1:
                return SystemIdInfoDao_Impl.getSystemIdInfo$lambda$1("SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?", (String) this.f731b, this.f732c, (SQLiteConnection) obj);
            case 2:
                return WorkSpecDao_Impl.setStopReason$lambda$51("UPDATE workspec SET stop_reason=? WHERE id=?", this.f732c, (String) this.f731b, (SQLiteConnection) obj);
            case 3:
                return WorkSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride$lambda$46("UPDATE workspec SET next_schedule_time_override=9223372036854775807 WHERE (id=? AND next_schedule_time_override_generation=?)", (String) this.f731b, this.f732c, (SQLiteConnection) obj);
            default:
                return AmbiguousColumnResolver.resolve$lambda$16$lambda$15((ArrayList) this.f731b, this.f732c, (List) obj);
        }
    }

    public /* synthetic */ c(Serializable serializable, int i10, int i11) {
        this.f730a = i11;
        this.f731b = serializable;
        this.f732c = i10;
    }
}
