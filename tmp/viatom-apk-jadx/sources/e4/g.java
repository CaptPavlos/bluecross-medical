package e4;

import a3.s;
import java.util.Iterator;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7661a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f7662b;

    public /* synthetic */ g(h hVar, float f, int i10) {
        this.f7661a = i10;
        this.f7662b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7661a) {
            case 0:
                i4.f fVar = this.f7662b.f7663a;
                s sVar = fVar.f9001d;
                if (sVar != null) {
                    sVar.invoke(fVar.f9000c);
                    return;
                } else {
                    l.i("youTubePlayerInitListener");
                    throw null;
                }
            case 1:
                i4.f fVar2 = this.f7662b.f7663a;
                for (f4.a aVar : fVar2.getListeners()) {
                    e fVar3 = fVar2.getInstance();
                    aVar.getClass();
                    fVar3.getClass();
                }
                return;
            case 2:
                i4.f fVar4 = this.f7662b.f7663a;
                Iterator<T> it = fVar4.getListeners().iterator();
                while (it.hasNext()) {
                    ((f4.a) it.next()).e(fVar4.getInstance());
                }
                return;
            case 3:
                i4.f fVar5 = this.f7662b.f7663a;
                for (f4.a aVar2 : fVar5.getListeners()) {
                    e fVar6 = fVar5.getInstance();
                    aVar2.getClass();
                    fVar6.getClass();
                }
                return;
            case 4:
                i4.f fVar7 = this.f7662b.f7663a;
                for (f4.a aVar3 : fVar7.getListeners()) {
                    e fVar8 = fVar7.getInstance();
                    aVar3.getClass();
                    fVar8.getClass();
                }
                return;
            case 5:
                i4.f fVar9 = this.f7662b.f7663a;
                Iterator<T> it2 = fVar9.getListeners().iterator();
                while (it2.hasNext()) {
                    ((f4.a) it2.next()).c(fVar9.getInstance());
                }
                return;
            default:
                i4.f fVar10 = this.f7662b.f7663a;
                for (f4.a aVar4 : fVar10.getListeners()) {
                    e fVar11 = fVar10.getInstance();
                    aVar4.getClass();
                    fVar11.getClass();
                }
                return;
        }
    }

    public /* synthetic */ g(h hVar, int i10) {
        this.f7661a = i10;
        this.f7662b = hVar;
    }

    public /* synthetic */ g(h hVar, Enum r22, int i10) {
        this.f7661a = i10;
        this.f7662b = hVar;
    }
}
