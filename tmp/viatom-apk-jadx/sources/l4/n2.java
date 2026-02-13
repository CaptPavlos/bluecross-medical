package l4;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.fragment.app.Fragment;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.activities.MainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class n2 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10647a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f10648b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n2(MainActivity mainActivity, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10647a = i10;
        this.f10648b = mainActivity;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10647a) {
            case 0:
                return new n2(this.f10648b, cVar, 0);
            default:
                return new n2(this.f10648b, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10647a) {
            case 0:
                n2 n2Var = (n2) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                n2Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                n2 n2Var2 = (n2) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                n2Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        int i10 = this.f10647a;
        s6.w wVar = s6.w.f12711a;
        MainActivity mainActivity = this.f10648b;
        switch (i10) {
            case 0:
                ArrayList arrayListA = androidx.constraintlayout.core.widgets.analyzer.a.A(obj);
                v5.g gVarL = v5.g.f13148u.l(mainActivity);
                gVarL.a();
                h5.q0 q0VarL = gVarL.L("categories");
                if (q0VarL == null || !q0VarL.a()) {
                    c1.w4 w4Var = new c1.w4(mainActivity, 4, false);
                    h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/v2/categories/parents"), ShareTarget.METHOD_GET, new HashMap());
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/v2/categories/parents");
                    if (!p0VarM.b() && p0VarM.f8696a != null) {
                        JSONObject jSONObject = p0VarM.f8699d;
                        jSONObject.getClass();
                        arrayListA = com.google.android.gms.internal.measurement.a4.n(jSONObject);
                        String str = p0VarM.f8696a;
                        str.getClass();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        gVarL.l("categories");
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "categories");
                        contentValues.put("json", str);
                        contentValues.put(CampaignEx.JSON_KEY_TIMESTAMP, String.valueOf(jCurrentTimeMillis));
                        SQLiteDatabase sQLiteDatabase = gVarL.f13150a;
                        sQLiteDatabase.getClass();
                        sQLiteDatabase.insert("responses", null, contentValues);
                    }
                } else {
                    arrayListA = com.google.android.gms.internal.measurement.a4.n(new JSONObject(q0VarL.f8718b));
                }
                gVarL.b();
                if (!arrayListA.isEmpty()) {
                    mainActivity.f6643n0.addAll(arrayListA);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                Fragment fragmentG0 = mainActivity.G0();
                if (fragmentG0 instanceof e5.j0) {
                    ((e5.j0) fragmentG0).E();
                    break;
                }
                break;
        }
        return wVar;
    }
}
