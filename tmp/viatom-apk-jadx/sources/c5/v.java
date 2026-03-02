package c5;

import android.content.Context;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import h5.p0;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class v extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1762a;

    /* renamed from: b, reason: collision with root package name */
    public int f1763b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c1.l f1764c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ v(c1.l lVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1762a = i10;
        this.f1764c = lVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1762a) {
            case 0:
                return new v(this.f1764c, cVar, 0);
            default:
                return new v(this.f1764c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1762a) {
        }
        return ((v) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        String str;
        int i10 = this.f1762a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        c1.l lVar = this.f1764c;
        int i11 = 1;
        w6.c cVar = null;
        switch (i10) {
            case 0:
                int i12 = this.f1763b;
                if (i12 == 0) {
                    s6.a.e(obj);
                    this.f1763b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new v(lVar, cVar, i11), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                } else if (i12 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    s6.a.e(obj);
                    break;
                }
                break;
            default:
                Context context = (Context) lVar.f1312b;
                int i13 = this.f1763b;
                if (i13 == 0) {
                    s6.a.e(obj);
                    int i14 = 4;
                    p0 p0VarQ = new w4(context, 4, false).q(lVar.f1311a);
                    if (!p0VarQ.b() && (str = p0VarQ.f8696a) != null && str.length() != 0) {
                        String str2 = p0VarQ.f8696a;
                        str2.getClass();
                        JSONObject jSONObject = new JSONObject(str2);
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObject.optInt("success") == 1 && jSONObjectOptJSONObject != null) {
                            h5.h hVar = new h5.h();
                            hVar.a(context, jSONObjectOptJSONObject);
                            y7.e eVar2 = r7.i0.f12407a;
                            s7.c cVar2 = w7.n.f13548a;
                            a6.j jVar = new a6.j(lVar, hVar, cVar, i14);
                            this.f1763b = 1;
                            if (r7.y.z(jVar, cVar2, this) != aVar) {
                            }
                        }
                    } else if (p0VarQ.b()) {
                        y7.e eVar3 = r7.i0.f12407a;
                        s7.c cVar3 = w7.n.f13548a;
                        a6.j jVar2 = new a6.j(lVar, p0VarQ, cVar, 5);
                        this.f1763b = 2;
                        if (r7.y.z(jVar2, cVar3, this) != aVar) {
                        }
                    }
                    break;
                } else if (i13 != 1 && i13 != 2) {
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
