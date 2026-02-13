package androidx.lifecycle;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import g7.l;
import java.io.Serializable;
import kotlin.jvm.internal.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f584a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f585b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Serializable f586c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f587d;

    public /* synthetic */ i(Object obj, Serializable serializable, Object obj2, int i10) {
        this.f584a = i10;
        this.f585b = obj;
        this.f586c = serializable;
        this.f587d = obj2;
    }

    @Override // g7.l
    public final Object invoke(Object obj) {
        switch (this.f584a) {
            case 0:
                return Transformations.switchMap$lambda$3((l) this.f585b, (x) this.f586c, (MediatorLiveData) this.f587d, obj);
            default:
                return Integer.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.delete$lambda$5((String) this.f585b, (String) this.f586c, (Object[]) this.f587d, (SupportSQLiteDatabase) obj));
        }
    }
}
