package androidx.work.impl.model;

import androidx.room.RoomRawQuery;
import androidx.sqlite.SQLiteConnection;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f726a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f727b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RoomRawQuery f728c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RawWorkInfoDao_Impl f729d;

    public /* synthetic */ b(String str, RoomRawQuery roomRawQuery, RawWorkInfoDao_Impl rawWorkInfoDao_Impl, int i10) {
        this.f726a = i10;
        this.f727b = str;
        this.f728c = roomRawQuery;
        this.f729d = rawWorkInfoDao_Impl;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f726a) {
            case 0:
                return RawWorkInfoDao_Impl.getWorkInfoPojos$lambda$0(this.f727b, this.f728c, this.f729d, (SQLiteConnection) obj);
            case 1:
                return RawWorkInfoDao_Impl.getWorkInfoPojosFlow$lambda$2(this.f727b, this.f728c, this.f729d, (SQLiteConnection) obj);
            default:
                return RawWorkInfoDao_Impl.getWorkInfoPojosLiveData$lambda$1(this.f727b, this.f728c, this.f729d, (SQLiteConnection) obj);
        }
    }
}
