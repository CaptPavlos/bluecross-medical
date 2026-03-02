package s4;

import java.io.File;
import r7.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class h extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12571a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f12572b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ File f12573c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(File file, n nVar, w6.c cVar) {
        super(2, cVar);
        this.f12571a = 0;
        this.f12573c = file;
        this.f12572b = nVar;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f12571a) {
            case 0:
                return new h(this.f12573c, this.f12572b, cVar);
            case 1:
                return new h(this.f12572b, this.f12573c, cVar, 1);
            case 2:
                return new h(this.f12572b, this.f12573c, cVar, 2);
            case 3:
                return new h(this.f12572b, this.f12573c, cVar, 3);
            default:
                return new h(this.f12572b, this.f12573c, cVar, 4);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        w wVar = (w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f12571a) {
            case 0:
                h hVar = (h) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                hVar.invokeSuspend(wVar2);
                break;
        }
        return ((h) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        t4.a aVar;
        switch (this.f12571a) {
            case 0:
                s6.a.e(obj);
                File file = this.f12573c;
                if (file != null && (aVar = this.f12572b.f12596c) != null) {
                    aVar.J(file);
                }
                break;
            case 1:
                s6.a.e(obj);
                t4.a aVar2 = this.f12572b.f12596c;
                if (aVar2 != null) {
                    aVar2.D(this.f12573c);
                    break;
                }
                break;
            case 2:
                s6.a.e(obj);
                t4.a aVar3 = this.f12572b.f12596c;
                if (aVar3 != null) {
                    aVar3.t(this.f12573c);
                    break;
                }
                break;
            case 3:
                s6.a.e(obj);
                t4.a aVar4 = this.f12572b.f12596c;
                if (aVar4 != null) {
                    aVar4.D(this.f12573c);
                    break;
                }
                break;
            default:
                s6.a.e(obj);
                t4.a aVar5 = this.f12572b.f12596c;
                if (aVar5 != null) {
                    aVar5.t(this.f12573c);
                    break;
                }
                break;
        }
        return s6.w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(n nVar, File file, w6.c cVar, int i10) {
        super(2, cVar);
        this.f12571a = i10;
        this.f12572b = nVar;
        this.f12573c = file;
    }
}
