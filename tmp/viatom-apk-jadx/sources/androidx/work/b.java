package androidx.work;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f662a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f663b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f664c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g7.a f665d;

    public /* synthetic */ b(AtomicBoolean atomicBoolean, CallbackToFutureAdapter.Completer completer, g7.a aVar, int i10) {
        this.f662a = i10;
        this.f663b = atomicBoolean;
        this.f664c = completer;
        this.f665d = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f662a) {
            case 0:
                ListenableFutureKt.executeAsync$lambda$4$lambda$3(this.f663b, this.f664c, this.f665d);
                break;
            default:
                WorkerKt.future$lambda$2$lambda$1(this.f663b, this.f664c, this.f665d);
                break;
        }
    }
}
