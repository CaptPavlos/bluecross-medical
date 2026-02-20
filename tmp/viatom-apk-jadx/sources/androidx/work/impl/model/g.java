package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f743a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f744b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f745c;

    public /* synthetic */ g(int i10, long j10, String str) {
        this.f743a = i10;
        this.f744b = j10;
        this.f745c = str;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f743a) {
            case 0:
                return WorkSpecDao_Impl.setNextScheduleTimeOverride$lambda$45("UPDATE workspec SET next_schedule_time_override=? WHERE id=?", this.f744b, this.f745c, (SQLiteConnection) obj);
            case 1:
                return Integer.valueOf(WorkSpecDao_Impl.markWorkSpecScheduled$lambda$47("UPDATE workspec SET schedule_requested_at=? WHERE id=?", this.f744b, this.f745c, (SQLiteConnection) obj));
            default:
                return WorkSpecDao_Impl.setLastEnqueueTime$lambda$42("UPDATE workspec SET last_enqueue_time=? WHERE id=?", this.f744b, this.f745c, (SQLiteConnection) obj);
        }
    }
}
