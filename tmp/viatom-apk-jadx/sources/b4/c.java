package b4;

import a4.f;
import android.text.TextUtils;
import j$.util.DesugarCollections;
import java.util.HashSet;
import org.json.JSONObject;
import t3.j;
import w3.i;

/* loaded from: classes3.dex */
public final class c extends a {

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f840c;

    /* renamed from: d, reason: collision with root package name */
    public final JSONObject f841d;
    public final long e;
    public final /* synthetic */ int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(f fVar, HashSet hashSet, JSONObject jSONObject, long j10, int i10) {
        super(fVar);
        this.f = i10;
        this.f840c = new HashSet(hashSet);
        this.f841d = jSONObject;
        this.e = j10;
    }

    @Override // b4.a
    /* renamed from: a */
    public final void onPostExecute(String str) {
        w3.c cVar;
        int i10 = this.f;
        i iVar = i.f13511a;
        long j10 = this.e;
        HashSet hashSet = this.f840c;
        switch (i10) {
            case 0:
                w3.c cVar2 = w3.c.f13498c;
                if (cVar2 != null) {
                    for (j jVar : DesugarCollections.unmodifiableCollection(cVar2.f13499a)) {
                        if (hashSet.contains(jVar.h)) {
                            y3.a aVar = jVar.e;
                            if (j10 >= aVar.f && aVar.e != 3) {
                                aVar.e = 3;
                                iVar.a(aVar.f(), "setNativeViewHierarchy", str, aVar.f13782a);
                            }
                        }
                    }
                }
                super.onPostExecute(str);
                break;
            default:
                if (!TextUtils.isEmpty(str) && (cVar = w3.c.f13498c) != null) {
                    for (j jVar2 : DesugarCollections.unmodifiableCollection(cVar.f13499a)) {
                        if (hashSet.contains(jVar2.h)) {
                            y3.a aVar2 = jVar2.e;
                            if (j10 >= aVar2.f) {
                                aVar2.e = 2;
                                iVar.a(aVar2.f(), "setNativeViewHierarchy", str, aVar2.f13782a);
                            }
                        }
                    }
                }
                super.onPostExecute(str);
                break;
        }
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        switch (this.f) {
            case 0:
                return this.f841d.toString();
            default:
                f fVar = this.f839b;
                JSONObject jSONObject = (JSONObject) fVar.f218b;
                JSONObject jSONObject2 = this.f841d;
                if (z3.b.e(jSONObject2, jSONObject)) {
                    return null;
                }
                fVar.f218b = jSONObject2;
                return jSONObject2.toString();
        }
    }

    @Override // b4.a, android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Object obj) {
        switch (this.f) {
            case 0:
                onPostExecute((String) obj);
                break;
            default:
                onPostExecute((String) obj);
                break;
        }
    }
}
