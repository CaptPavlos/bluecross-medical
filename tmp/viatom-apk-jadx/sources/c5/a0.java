package c5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import h5.o0;
import h5.p0;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a0 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1651a;

    /* renamed from: b, reason: collision with root package name */
    public int f1652b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w2.r f1653c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f1654d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(w2.r rVar, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1651a = i10;
        this.f1653c = rVar;
        this.f1654d = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1651a) {
            case 0:
                return new a0(this.f1653c, this.f1654d, cVar, 0);
            default:
                return new a0(this.f1653c, this.f1654d, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1651a) {
        }
        return ((a0) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        int i10 = this.f1651a;
        s6.w wVar = s6.w.f12711a;
        String str = this.f1654d;
        x6.a aVar = x6.a.f13718a;
        w2.r rVar = this.f1653c;
        int i11 = 0;
        w6.c cVar = null;
        int i12 = 1;
        switch (i10) {
            case 0:
                int i13 = this.f1652b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    p0 p0VarC = new w4((Context) rVar.f13463c, 4, false).C(str);
                    if (p0VarC.b() || (jSONObject = p0VarC.f8699d) == null) {
                        y7.e eVar = r7.i0.f12407a;
                        s7.c cVar2 = w7.n.f13548a;
                        y yVar = new y(rVar, null, 2);
                        this.f1652b = 3;
                        if (r7.y.z(yVar, cVar2, this) != aVar) {
                        }
                    } else {
                        o0 o0VarN = w2.r.n(rVar, jSONObject);
                        if (o0VarN != null) {
                            y7.e eVar2 = r7.i0.f12407a;
                            s7.c cVar3 = w7.n.f13548a;
                            z zVar = new z(rVar, o0VarN, cVar, i11);
                            this.f1652b = 1;
                            if (r7.y.z(zVar, cVar3, this) != aVar) {
                            }
                        } else {
                            y7.e eVar3 = r7.i0.f12407a;
                            s7.c cVar4 = w7.n.f13548a;
                            y yVar2 = new y(rVar, null, 1);
                            this.f1652b = 2;
                            if (r7.y.z(yVar2, cVar4, this) != aVar) {
                            }
                        }
                    }
                    break;
                } else if (i13 != 1 && i13 != 2 && i13 != 3) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                int i14 = this.f1652b;
                if (i14 == 0) {
                    s6.a.e(obj);
                    w4 w4Var = new w4((Context) rVar.f13463c, 4, false);
                    str.getClass();
                    p0 p0VarM = w4Var.m("https://www.uptodown.app:443/eapi/v2/virus-total-by-sha256/" + str + "/report", ShareTarget.METHOD_GET, null);
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/v2/virus-total-by-sha256/sha256/report");
                    if (p0VarM.b() || (jSONObject2 = p0VarM.f8699d) == null) {
                        y7.e eVar4 = r7.i0.f12407a;
                        s7.c cVar5 = w7.n.f13548a;
                        y yVar3 = new y(rVar, null, 4);
                        this.f1652b = 3;
                        if (r7.y.z(yVar3, cVar5, this) != aVar) {
                        }
                    } else {
                        o0 o0VarN2 = w2.r.n(rVar, jSONObject2);
                        if (o0VarN2 != null) {
                            y7.e eVar5 = r7.i0.f12407a;
                            s7.c cVar6 = w7.n.f13548a;
                            z zVar2 = new z(rVar, o0VarN2, cVar, i12);
                            this.f1652b = 1;
                            if (r7.y.z(zVar2, cVar6, this) != aVar) {
                            }
                        } else {
                            y7.e eVar6 = r7.i0.f12407a;
                            s7.c cVar7 = w7.n.f13548a;
                            y yVar4 = new y(rVar, null, 3);
                            this.f1652b = 2;
                            if (r7.y.z(yVar4, cVar7, this) != aVar) {
                            }
                        }
                    }
                    break;
                } else if (i14 != 1 && i14 != 2 && i14 != 3) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
        }
        return aVar;
    }
}
