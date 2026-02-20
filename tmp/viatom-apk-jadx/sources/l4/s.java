package l4;

import com.uptodown.R;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class s implements t4.b, t4.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f10804a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f10805b;

    public /* synthetic */ s(w wVar, File file) {
        this.f10804a = wVar;
        this.f10805b = file;
    }

    @Override // t4.d
    public void a(File file, ArrayList arrayList) throws XmlPullParserException, IOException {
        w wVar = this.f10804a;
        wVar.h0(file);
        s sVar = new s(wVar, file);
        d5.j jVar = new d5.j(wVar);
        jVar.l(arrayList);
        new com.google.android.gms.internal.measurement.j4(wVar, sVar).k(jVar.m(), false);
        v5.g gVarL = v5.g.f13148u.l(wVar);
        gVarL.a();
        String name = file.getName();
        name.getClass();
        h5.q qVarW = gVarL.w(name);
        gVarL.b();
        if (qVarW != null) {
            wVar.V(qVarW);
        }
    }

    @Override // t4.d
    public void c(int i10) {
        this.f10804a.g0(this.f10805b);
    }

    @Override // t4.d
    public void g() {
        w wVar = this.f10804a;
        String string = wVar.getString(R.string.msg_install_from_unknown_source, wVar.getString(R.string.app_name));
        string.getClass();
        wVar.N(string);
    }

    @Override // t4.b
    public void i() {
        this.f10804a.f0(this.f10805b);
    }

    @Override // t4.b
    public void k(String str) {
        w wVar = this.f10804a;
        if (str != null) {
            wVar.N(str);
            return;
        }
        String string = wVar.getString(R.string.error_generico);
        string.getClass();
        wVar.N(string);
    }

    @Override // t4.d
    public void l() {
        w wVar = this.f10804a;
        String string = wVar.getString(R.string.core_kill_this_app, wVar.getString(R.string.app_name));
        string.getClass();
        wVar.N(string);
    }

    @Override // t4.d
    public void n() {
        this.f10804a.g0(this.f10805b);
    }

    @Override // t4.d
    public void o() {
        w wVar = this.f10804a;
        String string = wVar.getString(R.string.error_unzipping);
        string.getClass();
        wVar.N(string);
    }

    @Override // t4.d
    public void r() {
        this.f10804a.k();
    }

    @Override // t4.d
    public void e(File file) {
    }

    @Override // t4.d
    public void f(File file) {
    }
}
