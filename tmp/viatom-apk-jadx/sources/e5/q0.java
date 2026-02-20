package e5;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c1.w4;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class q0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c1 f7834a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f7835b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f7836c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f7837d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ Context f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(c1 c1Var, long j10, String str, String str2, boolean z9, Context context, w6.c cVar) {
        super(2, cVar);
        this.f7834a = c1Var;
        this.f7835b = j10;
        this.f7836c = str;
        this.f7837d = str2;
        this.e = z9;
        this.f = context;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        return new q0(this.f7834a, this.f7835b, this.f7836c, this.f7837d, this.e, this.f, cVar);
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        q0 q0Var = (q0) create((r7.w) obj, (w6.c) obj2);
        s6.w wVar = s6.w.f12711a;
        q0Var.invokeSuspend(wVar);
        return wVar;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        s6.a.e(obj);
        u7.m0 m0Var = this.f7834a.f7703m;
        m0Var.getClass();
        m0Var.g(null, v5.j.f13166a);
        Context context = this.f;
        w4 w4Var = new w4(context, 4, false);
        long j10 = this.f7835b;
        h5.p0 p0VarA = w4Var.a(j10);
        if (!p0VarA.b() && (jSONObject = p0VarA.f8699d) != null && jSONObject.optInt("success") == 1) {
            new t1.c(context, 4).e(com.mbridge.msdk.dycreator.baseview.a.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "added"), "preregister");
            v5.g gVarL = v5.g.f13148u.l(context);
            gVarL.a();
            if (gVarL.I(j10) == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("appId", Long.valueOf(j10));
                contentValues.put("automaticDownload", Integer.valueOf(this.e ? 1 : 0));
                SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.insert("preregistrations", null, contentValues);
            }
            gVarL.b();
            v5.l lVar = new v5.l(new n0(true));
            m0Var.getClass();
            m0Var.g(null, lVar);
        }
        return s6.w.f12711a;
    }
}
