package c5;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.uptodown.R;
import l4.t3;
import org.json.JSONException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class m0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1727a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w2.r f1728b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f1729c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m0(w2.r rVar, kotlin.jvm.internal.x xVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1727a = i10;
        this.f1728b = rVar;
        this.f1729c = xVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1727a) {
            case 0:
                return new m0(this.f1728b, this.f1729c, cVar, 0);
            default:
                return new m0(this.f1728b, this.f1729c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) throws JSONException {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1727a) {
            case 0:
                m0 m0Var = (m0) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                m0Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                m0 m0Var2 = (m0) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                m0Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws JSONException {
        String str;
        t3 t3Var;
        String str2;
        int i10 = this.f1727a;
        s6.w wVar = s6.w.f12711a;
        w2.r rVar = this.f1728b;
        String str3 = null;
        kotlin.jvm.internal.x xVar = this.f1729c;
        switch (i10) {
            case 0:
                s6.a.e(obj);
                h5.h hVar = (h5.h) rVar.f13463c;
                Context context = (Context) rVar.f13462b;
                h5.f fVar = (h5.f) rVar.f13464d;
                if (fVar == null) {
                    if (hVar == null) {
                        xVar.f10138a = null;
                        break;
                    } else {
                        String str4 = hVar.e;
                        if (str4 != null) {
                            xVar.f10138a = str4;
                            break;
                        } else {
                            String str5 = hVar.f8595w;
                            str5.getClass();
                            String str6 = hVar.D;
                            str6.getClass();
                            xVar.f10138a = w2.r.m(rVar, context, str5, str6);
                            break;
                        }
                    }
                } else {
                    String str7 = fVar.f;
                    if (str7 != null) {
                        xVar.f10138a = str7;
                        break;
                    } else {
                        String str8 = fVar.f8526c;
                        str8.getClass();
                        String str9 = fVar.f8531l;
                        str9.getClass();
                        String strM = w2.r.m(rVar, context, str8, str9);
                        fVar.f = strM;
                        v5.g gVarL = v5.g.f13148u.l(context);
                        gVarL.a();
                        gVarL.a0(fVar);
                        gVarL.b();
                        xVar.f10138a = strM;
                        break;
                    }
                }
            default:
                s6.a.e(obj);
                h5.h hVar2 = (h5.h) rVar.f13463c;
                Context context2 = (Context) rVar.f13462b;
                h5.f fVar2 = (h5.f) rVar.f13464d;
                if (fVar2 == null || (str = fVar2.f8525b) == null) {
                    str = hVar2 != null ? hVar2.f8567b : null;
                }
                if (fVar2 != null && (str2 = fVar2.f8526c) != null) {
                    str3 = str2;
                } else if (hVar2 != null) {
                    str3 = hVar2.f8595w;
                }
                if (xVar.f10138a != null && str != null && str3 != null) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.addFlags(524288);
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.SUBJECT", context2.getString(R.string.share_app_details_msg, str));
                    intent.putExtra("android.intent.extra.TEXT", (String) xVar.f10138a);
                    context2.startActivity(Intent.createChooser(intent, context2.getString(R.string.option_button_share)));
                    Bundle bundle = new Bundle();
                    bundle.putString("packagename", str3);
                    new t1.c(context2, 4).e(bundle, "share_app");
                    break;
                } else if (str != null && (t3Var = (t3) rVar.e) != null) {
                    t3Var.f10842a.C(str);
                    break;
                }
                break;
        }
        return wVar;
    }
}
