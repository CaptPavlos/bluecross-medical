package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import g7.l;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f736a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f737b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f738c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f739d;

    public /* synthetic */ e(String str, List list, WorkSpecDao_Impl workSpecDao_Impl, int i10) {
        this.f736a = i10;
        this.f737b = str;
        this.f738c = list;
        this.f739d = workSpecDao_Impl;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f736a) {
            case 0:
                return WorkSpecDao_Impl.getWorkStatusPojoFlowDataForIds$lambda$11(this.f737b, this.f738c, this.f739d, (SQLiteConnection) obj);
            case 1:
                return WorkSpecDao_Impl.getWorkStatusPojoLiveDataForIds$lambda$10(this.f737b, this.f738c, this.f739d, (SQLiteConnection) obj);
            default:
                return WorkSpecDao_Impl.getWorkStatusPojoForIds$lambda$9(this.f737b, this.f738c, this.f739d, (SQLiteConnection) obj);
        }
    }
}
