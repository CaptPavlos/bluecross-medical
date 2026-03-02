package c5;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import c1.w4;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import h5.c1;
import h5.e1;
import h5.p0;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class u extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1759a;

    /* renamed from: b, reason: collision with root package name */
    public int f1760b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e0.n f1761c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ u(e0.n nVar, w6.c cVar, int i10) {
        super(2, cVar);
        this.f1759a = i10;
        this.f1761c = nVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f1759a) {
            case 0:
                return new u(this.f1761c, cVar, 0);
            default:
                return new u(this.f1761c, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f1759a) {
        }
        return ((u) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        JSONObject jSONObject;
        ArrayList arrayList;
        int i10;
        int i11 = this.f1759a;
        s6.w wVar = s6.w.f12711a;
        x6.a aVar = x6.a.f13718a;
        e0.n nVar = this.f1761c;
        switch (i11) {
            case 0:
                int i12 = this.f1760b;
                int i13 = 1;
                if (i12 != 0) {
                    if (i12 == 1) {
                        s6.a.e(obj);
                        break;
                    } else {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    this.f1760b = 1;
                    y7.e eVar = r7.i0.f12407a;
                    Object objZ = r7.y.z(new u(nVar, null, i13), y7.d.f14116a, this);
                    if (objZ != aVar) {
                        objZ = wVar;
                    }
                    if (objZ == aVar) {
                        break;
                    }
                }
                break;
            default:
                int i14 = this.f1760b;
                if (i14 != 0) {
                    if (i14 != 1 && i14 != 2) {
                        androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                        break;
                    } else {
                        s6.a.e(obj);
                        break;
                    }
                } else {
                    s6.a.e(obj);
                    Context context = nVar.f7616a;
                    w4 w4Var = new w4(context, 4, false);
                    long j10 = ((h5.h) nVar.f7618c).f8566a;
                    int i15 = nVar.f7617b;
                    String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
                    e1 e1VarH = c1.h(context);
                    if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
                        String str = e1VarH.f8512a;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
                        if (sharedPreferences.contains("device_rooted")) {
                            sharedPreferences.getBoolean("device_rooted", false);
                        }
                    } catch (Exception unused) {
                    }
                    HashMap map = new HashMap();
                    map.put("page[limit]", String.valueOf(20));
                    map.put("page[offset]", String.valueOf(i15));
                    p0 p0VarM = w4Var.m("https://www.uptodown.app:443/eapi/v3/app/" + j10 + "/device/" + string + "/compatible/versions", ShareTarget.METHOD_GET, map);
                    p0VarM.f8699d = w4Var.k(p0VarM, "/eapi/v3/app/appID/device/identifier/compatible/versions");
                    if (!p0VarM.b() && (jSONObject = p0VarM.f8699d) != null) {
                        int iOptInt = !jSONObject.isNull("success") ? jSONObject.optInt("success", 0) : 1;
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (iOptInt != 1 || jSONArrayOptJSONArray == null) {
                            arrayList = null;
                        } else {
                            arrayList = new ArrayList();
                            int length = jSONArrayOptJSONArray.length();
                            int i16 = 0;
                            while (i16 < length) {
                                h5.c0 c0Var = new h5.c0();
                                c0Var.f8486b = -1L;
                                c0Var.f8488d = -1L;
                                c0Var.f8489i = new ArrayList();
                                JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i16);
                                if (!jSONObjectOptJSONObject.isNull("fileID")) {
                                    c0Var.g = jSONObjectOptJSONObject.optString("fileID");
                                }
                                if (!jSONObjectOptJSONObject.isNull("version")) {
                                    c0Var.f8485a = jSONObjectOptJSONObject.optString("version");
                                }
                                if (jSONObjectOptJSONObject.isNull("versionCode")) {
                                    i10 = i16;
                                } else {
                                    i10 = i16;
                                    c0Var.f8488d = jSONObjectOptJSONObject.optLong("versionCode");
                                }
                                if (!jSONObjectOptJSONObject.isNull("sizeInBytes")) {
                                    c0Var.f8486b = jSONObjectOptJSONObject.optLong("sizeInBytes");
                                }
                                if (!jSONObjectOptJSONObject.isNull("minSDKVersion")) {
                                    c0Var.e = jSONObjectOptJSONObject.optString("minSDKVersion");
                                }
                                if (!jSONObjectOptJSONObject.isNull("lastUpdate")) {
                                    c0Var.f8487c = jSONObjectOptJSONObject.optString("lastUpdate");
                                }
                                if (!jSONObjectOptJSONObject.isNull("fileType")) {
                                    c0Var.f = jSONObjectOptJSONObject.optString("fileType");
                                }
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("requiredFeatures");
                                if (jSONArrayOptJSONArray2 != null) {
                                    c0Var.h = new ArrayList();
                                    int length2 = jSONArrayOptJSONArray2.length();
                                    for (int i17 = 0; i17 < length2; i17++) {
                                        ArrayList arrayList2 = c0Var.h;
                                        if (arrayList2 != null) {
                                            arrayList2.add(jSONArrayOptJSONArray2.optString(i17));
                                        }
                                    }
                                }
                                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("containedFiles");
                                if (jSONArrayOptJSONArray3 != null) {
                                    c0Var.f8489i = new ArrayList();
                                    int length3 = jSONArrayOptJSONArray3.length();
                                    int i18 = 0;
                                    while (i18 < length3) {
                                        JSONObject jSONObject2 = jSONArrayOptJSONArray3.getJSONObject(i18);
                                        jSONObject2.getClass();
                                        h5.r rVar = new h5.r();
                                        int i19 = length;
                                        if (!jSONObject2.isNull("fileID")) {
                                            rVar.f8722c = jSONObject2.optLong("fileID");
                                        }
                                        if (!jSONObject2.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                                            rVar.f8723d = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                                        }
                                        if (!jSONObject2.isNull("size")) {
                                            rVar.e = jSONObject2.optLong("size");
                                        }
                                        if (!jSONObject2.isNull("sha256")) {
                                            rVar.g = jSONObject2.optString("sha256");
                                        }
                                        c0Var.f8489i.add(rVar);
                                        i18++;
                                        length = i19;
                                    }
                                }
                                arrayList.add(c0Var);
                                i16 = i10 + 1;
                                length = length;
                            }
                        }
                        if (arrayList == null || arrayList.isEmpty()) {
                            y7.e eVar2 = r7.i0.f12407a;
                            s7.c cVar = w7.n.f13548a;
                            a6.n nVar2 = new a6.n(nVar, null, 4);
                            this.f1760b = 2;
                            if (r7.y.z(nVar2, cVar, this) != aVar) {
                            }
                        } else {
                            y7.e eVar3 = r7.i0.f12407a;
                            s7.c cVar2 = w7.n.f13548a;
                            a6.j jVar = new a6.j(nVar, arrayList, (w6.c) null, 3);
                            this.f1760b = 1;
                            if (r7.y.z(jVar, cVar2, this) != aVar) {
                            }
                        }
                        break;
                    }
                }
                break;
        }
        return aVar;
    }
}
