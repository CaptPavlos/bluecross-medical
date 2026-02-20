package a6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import r7.i0;
import r7.w;
import r7.y;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class t extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f293a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f294b;

    /* renamed from: c, reason: collision with root package name */
    public int f295c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(int i10, Context context, w6.c cVar) {
        super(2, cVar);
        this.f294b = context;
        this.f295c = i10;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f293a) {
            case 0:
                return new t(this.f294b, cVar);
            default:
                return new t(this.f295c, this.f294b, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws Throwable {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f293a) {
            case 0:
                return ((t) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
            default:
                t tVar = (t) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                tVar.invokeSuspend(wVar2);
                return wVar2;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i10 = this.f293a;
        s6.w wVar = s6.w.f12711a;
        Context context = this.f294b;
        switch (i10) {
            case 0:
                int i11 = this.f295c;
                if (i11 != 0) {
                    if (i11 == 1) {
                        s6.a.e(obj);
                        return wVar;
                    }
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                s6.a.e(obj);
                ArrayList arrayListI = v5.a.i(context);
                v5.a aVar = new v5.a();
                this.f295c = 1;
                y7.e eVar = i0.f12407a;
                Object objZ = y.z(new c5.g(context, arrayListI, aVar, (w6.c) null), y7.d.f14116a, this);
                x6.a aVar2 = x6.a.f13718a;
                if (objZ != aVar2) {
                    objZ = wVar;
                }
                return objZ == aVar2 ? aVar2 : wVar;
            default:
                s6.a.e(obj);
                v5.g gVarL = v5.g.f13148u.l(context);
                gVarL.a();
                String[] strArr = {String.valueOf(this.f295c)};
                SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.delete("notifications", "id=?", strArr);
                gVarL.b();
                return wVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(Context context, w6.c cVar) {
        super(2, cVar);
        this.f294b = context;
    }
}
