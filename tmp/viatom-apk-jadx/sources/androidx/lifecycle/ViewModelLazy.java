package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements s6.f {
    private VM cached;
    private final g7.a extrasProducer;
    private final g7.a factoryProducer;
    private final g7.a storeProducer;
    private final m7.c viewModelClass;

    public ViewModelLazy(m7.c cVar, g7.a aVar, g7.a aVar2, g7.a aVar3) {
        cVar.getClass();
        aVar.getClass();
        aVar2.getClass();
        aVar3.getClass();
        this.viewModelClass = cVar;
        this.storeProducer = aVar;
        this.factoryProducer = aVar2;
        this.extrasProducer = aVar3;
    }

    @Override // s6.f
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) ViewModelProvider.Companion.create((ViewModelStore) this.storeProducer.invoke(), (ViewModelProvider.Factory) this.factoryProducer.invoke(), (CreationExtras) this.extrasProducer.invoke()).get(this.viewModelClass);
        this.cached = vm2;
        return vm2;
    }

    @Override // s6.f
    public boolean isInitialized() {
        return this.cached != null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelLazy(m7.c cVar, g7.a aVar, g7.a aVar2) {
        this(cVar, aVar, aVar2, null, 8, null);
        cVar.getClass();
        aVar.getClass();
        aVar2.getClass();
    }

    public /* synthetic */ ViewModelLazy(m7.c cVar, g7.a aVar, g7.a aVar2, g7.a aVar3, int i10, kotlin.jvm.internal.g gVar) {
        this(cVar, aVar, aVar2, (i10 & 8) != 0 ? new k(0) : aVar3);
    }
}
