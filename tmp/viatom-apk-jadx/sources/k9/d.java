package k9;

import androidx.lifecycle.ViewModel;
import b9.h;
import com.inmobi.cmp.ChoiceCmpCallback;
import d0.i;
import d9.p;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends ViewModel {

    /* renamed from: a, reason: collision with root package name */
    public final i f10120a;

    /* renamed from: b, reason: collision with root package name */
    public final ChoiceCmpCallback f10121b;

    /* renamed from: c, reason: collision with root package name */
    public final d9.b f10122c;

    /* renamed from: d, reason: collision with root package name */
    public final o8.i f10123d;
    public final h e;
    public final n6.c f;

    public d(i iVar, ChoiceCmpCallback choiceCmpCallback, d9.b bVar, o8.i iVar2, h hVar, n6.c cVar) {
        this.f10120a = iVar;
        this.f10121b = choiceCmpCallback;
        this.f10122c = bVar;
        this.f10123d = iVar2;
        this.e = hVar;
        this.f = cVar;
    }

    public final String a() {
        p pVar;
        String str;
        o8.i iVar = this.f10123d;
        return (iVar == null || (pVar = iVar.f) == null || (str = pVar.h) == null) ? "" : str;
    }

    public final String b() {
        d9.b bVar = this.f10122c;
        return !bVar.f7466b.isEmpty() ? (String) l.c0(bVar.f7466b) : "";
    }

    public final String c() {
        p pVar;
        String str;
        o8.i iVar = this.f10123d;
        return (iVar == null || (pVar = iVar.f) == null || (str = pVar.g) == null) ? "" : str;
    }

    public final String d() {
        p pVar;
        String str;
        o8.i iVar = this.f10123d;
        return (iVar == null || (pVar = iVar.f) == null || (str = pVar.f) == null) ? "" : str;
    }
}
