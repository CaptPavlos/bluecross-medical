package b9;

import android.content.Intent;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import c1.g1;
import com.uptodown.core.activities.InstallerActivity;
import g5.z;
import h5.o0;
import java.io.File;
import java.io.IOException;
import l4.w;
import org.json.JSONException;
import org.json.JSONObject;
import r7.i0;
import r7.y;
import z8.f0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b implements z {

    /* renamed from: a, reason: collision with root package name */
    public final Object f858a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f859b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f860c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f861d;
    public final Object e;

    public b(p8.g gVar, g1 g1Var) {
        this.e = gVar;
        this.f858a = g1Var;
        f0 f0VarJ = g1Var.j(1);
        this.f860c = f0VarJ;
        this.f861d = new p8.c(this, f0VarJ, g1Var);
    }

    public JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("themeUuid", (String) this.f858a);
        jSONObject.put("language", (String) this.f860c);
        jSONObject.put("copApplicable", (Boolean) this.f861d);
        jSONObject.put("advancedApplicable", (Boolean) this.e);
        jSONObject.put("gbcApplicable", this.f859b);
        return jSONObject;
    }

    public void b() throws IOException {
        synchronized (((p8.g) this.e)) {
            try {
                if (this.f859b) {
                    return;
                }
                this.f859b = true;
                q8.c.c((f0) this.f860c);
                try {
                    ((g1) this.f858a).a();
                } catch (IOException unused) {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // g5.z
    public void m(o0 o0Var) {
        int i10 = o0Var.f8677c;
        final w wVar = (w) this.f860c;
        final File file = (File) this.f861d;
        Object obj = this.e;
        Object obj2 = this.f858a;
        if (i10 > 0) {
            final String str = (String) obj2;
            final boolean z9 = this.f859b;
            final h5.q qVar = (h5.q) obj;
            g7.a aVar = new g7.a() { // from class: l4.u
                @Override // g7.a
                public final Object invoke() {
                    File file2 = file;
                    file2.getClass();
                    String absolutePath = file2.getAbsolutePath();
                    absolutePath.getClass();
                    w wVar2 = wVar;
                    Intent intent = new Intent(wVar2, (Class<?>) InstallerActivity.class);
                    intent.putExtra("realPath", absolutePath);
                    intent.putExtra("requireUserAction", z9);
                    intent.putExtra("backgroundInstallation", false);
                    intent.addFlags(268435456);
                    String str2 = str;
                    if (str2 != null && str2.length() != 0) {
                        intent.putExtra("newFeatures", str2);
                    }
                    wVar2.startActivity(intent);
                    h5.q qVar2 = qVar;
                    if (qVar2 != null) {
                        wVar2.V(qVar2);
                    }
                    return s6.w.f12711a;
                }
            };
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(wVar);
            y7.e eVar = i0.f12407a;
            y.q(lifecycleScope, w7.n.f13548a, null, new c5.m(wVar, o0Var, aVar, null, 6), 2);
            return;
        }
        String str2 = (String) obj2;
        boolean z10 = this.f859b;
        file.getClass();
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        Intent intent = new Intent(wVar, (Class<?>) InstallerActivity.class);
        intent.putExtra("realPath", absolutePath);
        intent.putExtra("requireUserAction", z10);
        intent.putExtra("backgroundInstallation", false);
        intent.addFlags(268435456);
        if (str2 != null && str2.length() != 0) {
            intent.putExtra("newFeatures", str2);
        }
        wVar.startActivity(intent);
        h5.q qVar2 = (h5.q) obj;
        if (qVar2 != null) {
            wVar.V(qVar2);
        }
    }

    @Override // g5.z
    public void q() {
        w wVar = (w) this.f860c;
        File file = (File) this.f861d;
        String str = (String) this.f858a;
        boolean z9 = this.f859b;
        file.getClass();
        String absolutePath = file.getAbsolutePath();
        absolutePath.getClass();
        Intent intent = new Intent(wVar, (Class<?>) InstallerActivity.class);
        intent.putExtra("realPath", absolutePath);
        intent.putExtra("requireUserAction", z9);
        intent.putExtra("backgroundInstallation", false);
        intent.addFlags(268435456);
        if (str != null && str.length() != 0) {
            intent.putExtra("newFeatures", str);
        }
        wVar.startActivity(intent);
        h5.q qVar = (h5.q) this.e;
        if (qVar != null) {
            wVar.V(qVar);
        }
    }

    public b(String str, String str2, Boolean bool, Boolean bool2, boolean z9) {
        this.f858a = str;
        this.f860c = str2;
        this.f861d = bool;
        this.e = bool2;
        this.f859b = z9;
    }

    public b(w wVar, File file, String str, boolean z9, h5.q qVar) {
        this.f860c = wVar;
        this.f861d = file;
        this.f858a = str;
        this.f859b = z9;
        this.e = qVar;
    }
}
