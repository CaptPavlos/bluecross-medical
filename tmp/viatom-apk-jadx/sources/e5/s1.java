package e5;

import android.content.Context;
import androidx.browser.trusted.sharing.ShareTarget;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s1 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7855a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7856b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t1 f7857c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(t1 t1Var, ArrayList arrayList, w6.c cVar) {
        super(2, cVar);
        this.f7857c = t1Var;
        this.f7856b = arrayList;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f7855a) {
            case 0:
                return new s1(this.f7857c, this.f7856b, cVar);
            default:
                return new s1(this.f7856b, this.f7857c, cVar);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f7855a) {
            case 0:
                s1 s1Var = (s1) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                s1Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                s1 s1Var2 = (s1) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                s1Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        JSONObject jSONObject;
        switch (this.f7855a) {
            case 0:
                s6.a.e(obj);
                t1 t1Var = this.f7857c;
                Context contextRequireContext = t1Var.requireContext();
                contextRequireContext.getClass();
                w4 w4Var = new w4(contextRequireContext, 4, false);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = t1Var.f;
                if (arrayList2 != null) {
                    Iterator it = arrayList2.iterator();
                    it.getClass();
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        h5.k kVar = ((h5.x0) next).f8788a;
                        if (kVar.f8635d) {
                            arrayList.add(new Integer(kVar.f8632a));
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    t1Var.f7871j = false;
                } else {
                    HashMap map = new HashMap();
                    map.put("page[limit]", String.valueOf(20));
                    map.put("page[offset]", String.valueOf(0));
                    map.put("categoryIDs", arrayList.toString());
                    h5.p0 p0VarM = w4Var.m("https://www.uptodown.app:443".concat("/eapi/floating-category/additional/apps"), ShareTarget.METHOD_POST, map);
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/floating-category/additional/apps");
                    if (p0VarM.b() || (jSONObject = p0VarM.f8699d) == null) {
                        t1Var.f7871j = false;
                    } else {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (jSONObject.optInt("success") == 1 && jSONArrayOptJSONArray != null) {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i10 = 0; i10 < length; i10++) {
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i10);
                                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("floatingCategory");
                                if (jSONObjectOptJSONObject2 != null) {
                                    h5.k kVar2 = new h5.k(0, (String) null, 7);
                                    kVar2.b(jSONObjectOptJSONObject2);
                                    ArrayList arrayList3 = new ArrayList();
                                    JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("apps");
                                    if (jSONArrayOptJSONArray2 != null) {
                                        int length2 = jSONArrayOptJSONArray2.length();
                                        for (int i11 = 0; i11 < length2; i11++) {
                                            h5.h hVar = new h5.h();
                                            JSONObject jSONObjectOptJSONObject3 = jSONArrayOptJSONArray2.optJSONObject(i11);
                                            jSONObjectOptJSONObject3.getClass();
                                            hVar.a(null, jSONObjectOptJSONObject3);
                                            arrayList3.add(hVar);
                                        }
                                    }
                                    h5.x0 x0Var = new h5.x0(kVar2, arrayList3, 4);
                                    x0Var.f8790c = 5;
                                    ArrayList arrayList4 = t1Var.f;
                                    if (arrayList4 != null) {
                                        arrayList4.add(x0Var);
                                    }
                                    this.f7856b.add(x0Var);
                                }
                            }
                        }
                    }
                }
                t1Var.f7870i = false;
                break;
            default:
                s6.a.e(obj);
                ArrayList arrayList5 = this.f7856b;
                int size = arrayList5.size();
                t1 t1Var2 = this.f7857c;
                if (size < 4) {
                    t1Var2.f7871j = false;
                }
                Iterator it2 = arrayList5.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    next2.getClass();
                    h5.x0 x0Var2 = (h5.x0) next2;
                    n4.h hVar2 = t1Var2.f7867b;
                    if (hVar2 != null) {
                        hVar2.b(x0Var2);
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s1(ArrayList arrayList, t1 t1Var, w6.c cVar) {
        super(2, cVar);
        this.f7856b = arrayList;
        this.f7857c = t1Var;
    }
}
