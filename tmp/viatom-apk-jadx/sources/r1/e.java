package r1;

import java.util.concurrent.ExecutorService;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12329a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f12330b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Runnable f12331c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n5 f12332d;

    public /* synthetic */ e(f fVar, Runnable runnable, n5 n5Var, int i10) {
        this.f12329a = i10;
        this.f12330b = fVar;
        this.f12331c = runnable;
        this.f12332d = n5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12329a) {
            case 0:
                ExecutorService executorService = this.f12330b.f12333a;
                final int i10 = 0;
                final Runnable runnable = this.f12331c;
                final n5 n5Var = this.f12332d;
                executorService.execute(new Runnable() { // from class: r1.c
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i10) {
                            case 0:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e) {
                                    ((h) n5Var.f10654b).setException(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable.run();
                                    return;
                                } catch (Exception e3) {
                                    ((h) n5Var.f10654b).setException(e3);
                                    return;
                                }
                            default:
                                Runnable runnable2 = runnable;
                                h hVar = (h) n5Var.f10654b;
                                try {
                                    runnable2.run();
                                    hVar.set(null);
                                    return;
                                } catch (Exception e7) {
                                    hVar.setException(e7);
                                    return;
                                }
                        }
                    }
                });
                break;
            case 1:
                ExecutorService executorService2 = this.f12330b.f12333a;
                final int i11 = 2;
                final Runnable runnable2 = this.f12331c;
                final n5 n5Var2 = this.f12332d;
                executorService2.execute(new Runnable() { // from class: r1.c
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i11) {
                            case 0:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e) {
                                    ((h) n5Var2.f10654b).setException(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable2.run();
                                    return;
                                } catch (Exception e3) {
                                    ((h) n5Var2.f10654b).setException(e3);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable2;
                                h hVar = (h) n5Var2.f10654b;
                                try {
                                    runnable22.run();
                                    hVar.set(null);
                                    return;
                                } catch (Exception e7) {
                                    hVar.setException(e7);
                                    return;
                                }
                        }
                    }
                });
                break;
            default:
                ExecutorService executorService3 = this.f12330b.f12333a;
                final int i12 = 1;
                final Runnable runnable3 = this.f12331c;
                final n5 n5Var3 = this.f12332d;
                executorService3.execute(new Runnable() { // from class: r1.c
                    @Override // java.lang.Runnable
                    public final void run() throws Exception {
                        switch (i12) {
                            case 0:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e) {
                                    ((h) n5Var3.f10654b).setException(e);
                                    throw e;
                                }
                            case 1:
                                try {
                                    runnable3.run();
                                    return;
                                } catch (Exception e3) {
                                    ((h) n5Var3.f10654b).setException(e3);
                                    return;
                                }
                            default:
                                Runnable runnable22 = runnable3;
                                h hVar = (h) n5Var3.f10654b;
                                try {
                                    runnable22.run();
                                    hVar.set(null);
                                    return;
                                } catch (Exception e7) {
                                    hVar.setException(e7);
                                    return;
                                }
                        }
                    }
                });
                break;
        }
    }
}
