package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import g7.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f740a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f741b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WorkSpec f742c;

    public /* synthetic */ f(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec, int i10) {
        this.f740a = i10;
        this.f741b = workSpecDao_Impl;
        this.f742c = workSpec;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f740a) {
            case 0:
                return WorkSpecDao_Impl.updateWorkSpec$lambda$1(this.f741b, this.f742c, (SQLiteConnection) obj);
            default:
                return WorkSpecDao_Impl.insertWorkSpec$lambda$0(this.f741b, this.f742c, (SQLiteConnection) obj);
        }
    }
}
