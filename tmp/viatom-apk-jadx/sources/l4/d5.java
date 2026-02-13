package l4;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.lifecycle.ViewModelKt;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d5 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10325a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10326b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e5 f10327c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d5(Context context, e5 e5Var, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10325a = i10;
        this.f10326b = context;
        this.f10327c = e5Var;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10325a) {
            case 0:
                return new d5(this.f10326b, this.f10327c, cVar, 0);
            default:
                return new d5(this.f10326b, this.f10327c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10325a) {
            case 0:
                d5 d5Var = (d5) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                d5Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                d5 d5Var2 = (d5) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                d5Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        Cursor cursorQuery;
        int i10 = this.f10325a;
        s6.w wVar = s6.w.f12711a;
        e5 e5Var = this.f10327c;
        w6.c cVar = null;
        Context context = this.f10326b;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                v5.g gVarL = v5.g.f13148u.l(context);
                gVarL.a();
                SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.delete("notifications", null, null);
                gVarL.b();
                r7.w viewModelScope = ViewModelKt.getViewModelScope(e5Var);
                y7.e eVar = r7.i0.f12407a;
                r7.y.q(viewModelScope, y7.d.f14116a, null, new d5(context, e5Var, cVar, 1), 2);
                break;
            default:
                s6.a.e(obj);
                v5.g gVarL2 = v5.g.f13148u.l(context);
                gVarL2.a();
                ArrayList arrayList = new ArrayList();
                try {
                    SQLiteDatabase sQLiteDatabase2 = gVarL2.f13150a;
                    sQLiteDatabase2.getClass();
                    cursorQuery = sQLiteDatabase2.query("notifications", gVarL2.f13155j, null, null, null, null, "id DESC");
                } catch (Exception e) {
                    e = e;
                    cursorQuery = null;
                }
                try {
                    if (cursorQuery.moveToFirst()) {
                        h5.b0 b0Var = new h5.b0();
                        b0Var.a(cursorQuery);
                        arrayList.add(b0Var);
                    }
                    while (cursorQuery.moveToNext()) {
                        h5.b0 b0Var2 = new h5.b0();
                        b0Var2.a(cursorQuery);
                        arrayList.add(b0Var2);
                    }
                    cursorQuery.close();
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (cursorQuery != null && !cursorQuery.isClosed()) {
                        cursorQuery.close();
                    }
                    gVarL2.b();
                    u7.m0 m0Var = e5Var.f10359a;
                    v5.l lVar = new v5.l(new c5(arrayList));
                    m0Var.getClass();
                    m0Var.g(null, lVar);
                    return wVar;
                }
                gVarL2.b();
                u7.m0 m0Var2 = e5Var.f10359a;
                v5.l lVar2 = new v5.l(new c5(arrayList));
                m0Var2.getClass();
                m0Var2.g(null, lVar2);
                break;
        }
        return wVar;
    }
}
