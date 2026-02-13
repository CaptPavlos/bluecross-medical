package x4;

import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class r extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13658a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b9.h f13659b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y f13660c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f13661d;
    public final /* synthetic */ String e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(b9.h hVar, y yVar, ArrayList arrayList, String str, w6.c cVar, int i10) {
        super(2, cVar);
        this.f13658a = i10;
        this.f13659b = hVar;
        this.f13660c = yVar;
        this.f13661d = arrayList;
        this.e = str;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f13658a) {
            case 0:
                return new r(this.f13659b, this.f13660c, this.f13661d, this.e, cVar, 0);
            default:
                return new r(this.f13659b, this.f13660c, this.f13661d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f13658a) {
            case 0:
                r rVar = (r) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                rVar.invokeSuspend(wVar2);
                return wVar2;
            default:
                r rVar2 = (r) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                rVar2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f13658a) {
            case 0:
                s6.a.e(obj);
                int size = (this.f13660c.f13699b * 100) / this.f13661d.size();
                b9.h hVar = this.f13659b;
                ((ProgressBar) hVar.f882a).setProgress(size);
                ((TextView) hVar.f883b).setText(this.e);
                break;
            default:
                s6.a.e(obj);
                int size2 = (this.f13660c.f13699b * 100) / this.f13661d.size();
                b9.h hVar2 = this.f13659b;
                ((ProgressBar) hVar2.f882a).setProgress(size2);
                ((TextView) hVar2.f883b).setText(this.e);
                break;
        }
        return s6.w.f12711a;
    }
}
