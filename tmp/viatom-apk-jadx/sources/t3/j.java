package t3;

import android.app.ActivityManager;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import org.json.JSONObject;
import z1.t1;

/* loaded from: classes3.dex */
public final class j extends b {

    /* renamed from: a, reason: collision with root package name */
    public final b9.h f12791a;

    /* renamed from: b, reason: collision with root package name */
    public final t1.c f12792b;

    /* renamed from: c, reason: collision with root package name */
    public final w3.g f12793c;

    /* renamed from: d, reason: collision with root package name */
    public c4.a f12794d;
    public y3.a e;
    public boolean f;
    public boolean g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f12795i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12796j;

    public j(t1.c cVar, b9.h hVar) {
        y3.a bVar;
        String string = UUID.randomUUID().toString();
        this.f12793c = new w3.g();
        this.f = false;
        this.g = false;
        this.f12792b = cVar;
        this.f12791a = hVar;
        this.h = string;
        this.f12794d = new c4.a(null);
        c cVar2 = (c) hVar.f;
        if (cVar2 == c.HTML || cVar2 == c.JAVASCRIPT) {
            WebView webView = (WebView) hVar.f883b;
            bVar = new y3.b(string);
            if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            bVar.f13783b = new c4.a(webView);
        } else {
            bVar = new y3.d(string, DesugarCollections.unmodifiableMap((HashMap) hVar.f884c), (String) hVar.g);
        }
        this.e = bVar;
        this.e.g();
        w3.c.f13498c.f13499a.add(this);
        y3.a aVar = this.e;
        WebView webViewF = aVar.f();
        String str = aVar.f13782a;
        JSONObject jSONObject = new JSONObject();
        z3.b.b(jSONObject, "impressionOwner", g.NATIVE);
        z3.b.b(jSONObject, "mediaEventsOwner", (g) cVar.f12751b);
        z3.b.b(jSONObject, "creativeType", (d) cVar.f12752c);
        z3.b.b(jSONObject, "impressionType", f.BEGIN_TO_RENDER);
        z3.b.b(jSONObject, "isolateVerificationScripts", Boolean.FALSE);
        w3.i.f13511a.a(webViewF, "init", jSONObject, str);
    }

    @Override // t3.b
    public final void a(View view, e eVar) {
        if (this.g) {
            return;
        }
        w3.g gVar = this.f12793c;
        gVar.getClass();
        if (view == null) {
            com.google.gson.internal.a.n("FriendlyObstruction is null");
        } else if (gVar.a(view) == null) {
            gVar.f13508a.add(new w3.f(view, eVar));
        }
    }

    @Override // t3.b
    public final void c() {
        if (this.g) {
            return;
        }
        this.f12794d.clear();
        e();
        this.g = true;
        y3.a aVar = this.e;
        int i10 = 0;
        w3.i.f13511a.a(aVar.f(), "finishSession", aVar.f13782a);
        w3.c cVar = w3.c.f13498c;
        ArrayList arrayList = cVar.f13500b;
        ArrayList arrayList2 = cVar.f13500b;
        boolean z9 = arrayList.size() > 0;
        cVar.f13499a.remove(this);
        arrayList2.remove(this);
        if (z9 && arrayList2.size() <= 0) {
            w3.j jVarB = w3.j.b();
            jVarB.getClass();
            a4.c cVar2 = a4.c.f;
            cVar2.getClass();
            Handler handler = a4.c.h;
            if (handler != null) {
                handler.removeCallbacks(a4.c.f204j);
                a4.c.h = null;
            }
            cVar2.f205a.clear();
            a4.c.g.post(new a4.a(cVar2, i10));
            w3.b bVar = w3.b.f13497d;
            bVar.f13501a = false;
            bVar.f13503c = null;
            v3.a aVar2 = jVarB.f13514c;
            aVar2.f13121a.getContentResolver().unregisterContentObserver(aVar2);
        }
        this.e.e();
        this.e = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // t3.b
    public final void d(View view) {
        if (this.g) {
            return;
        }
        t1.b(view, "AdView is null");
        if (((View) this.f12794d.get()) == view) {
            return;
        }
        this.f12794d = new c4.a(view);
        y3.a aVar = this.e;
        aVar.getClass();
        aVar.f = System.nanoTime();
        aVar.e = 1;
        Collection<j> collectionUnmodifiableCollection = DesugarCollections.unmodifiableCollection(w3.c.f13498c.f13499a);
        if (collectionUnmodifiableCollection == null || collectionUnmodifiableCollection.isEmpty()) {
            return;
        }
        for (j jVar : collectionUnmodifiableCollection) {
            if (jVar != this && ((View) jVar.f12794d.get()) == view) {
                jVar.f12794d.clear();
            }
        }
    }

    @Override // t3.b
    public final void e() {
        if (this.g) {
            return;
        }
        this.f12793c.f13508a.clear();
    }

    @Override // t3.b
    public final void f() {
        if (this.f) {
            return;
        }
        this.f = true;
        w3.c cVar = w3.c.f13498c;
        boolean z9 = cVar.f13500b.size() > 0;
        cVar.f13500b.add(this);
        if (!z9) {
            w3.j jVarB = w3.j.b();
            jVarB.getClass();
            w3.b bVar = w3.b.f13497d;
            bVar.f13503c = jVarB;
            bVar.f13501a = true;
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            boolean z10 = runningAppProcessInfo.importance == 100 || bVar.b();
            bVar.f13502b = z10;
            bVar.a(z10);
            a4.c.f.getClass();
            a4.c.b();
            v3.a aVar = jVarB.f13514c;
            aVar.e = aVar.a();
            aVar.b();
            aVar.f13121a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, aVar);
        }
        float f = w3.j.b().f13512a;
        y3.a aVar2 = this.e;
        w3.i.f13511a.a(aVar2.f(), "setDeviceVolume", Float.valueOf(f), aVar2.f13782a);
        y3.a aVar3 = this.e;
        Date date = w3.a.f.f13494b;
        aVar3.b(date != null ? (Date) date.clone() : null);
        this.e.c(this, this.f12791a);
    }
}
