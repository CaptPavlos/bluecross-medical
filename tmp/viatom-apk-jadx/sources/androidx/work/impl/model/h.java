package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f746a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f747b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f748c;

    public /* synthetic */ h(WorkSpecDao_Impl workSpecDao_Impl, SQLiteConnection sQLiteConnection, int i10) {
        this.f746a = i10;
        this.f747b = workSpecDao_Impl;
        this.f748c = sQLiteConnection;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f746a) {
            case 0:
                return WorkSpecDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData$lambda$53(this.f747b, this.f748c, (ArrayMap) obj);
            default:
                return WorkSpecDao_Impl.__fetchRelationshipWorkTagAsjavaLangString$lambda$52(this.f747b, this.f748c, (ArrayMap) obj);
        }
    }
}
