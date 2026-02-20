package androidx.work.impl.model;

import androidx.collection.ArrayMap;
import androidx.sqlite.SQLiteConnection;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f723a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f724b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SQLiteConnection f725c;

    public /* synthetic */ a(RawWorkInfoDao_Impl rawWorkInfoDao_Impl, SQLiteConnection sQLiteConnection, int i10) {
        this.f723a = i10;
        this.f724b = rawWorkInfoDao_Impl;
        this.f725c = sQLiteConnection;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f723a) {
            case 0:
                return RawWorkInfoDao_Impl.__fetchRelationshipWorkProgressAsandroidxWorkData$lambda$4(this.f724b, this.f725c, (ArrayMap) obj);
            default:
                return RawWorkInfoDao_Impl.__fetchRelationshipWorkTagAsjavaLangString$lambda$3(this.f724b, this.f725c, (ArrayMap) obj);
        }
    }
}
