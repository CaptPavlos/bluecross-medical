package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.gms.internal.measurement.a4;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewModelProviderImpl_androidKt {
    public static final <VM extends ViewModel> VM createViewModel(ViewModelProvider.Factory factory, c cVar, CreationExtras creationExtras) {
        factory.getClass();
        cVar.getClass();
        creationExtras.getClass();
        try {
            try {
                return (VM) factory.create(cVar, creationExtras);
            } catch (AbstractMethodError unused) {
                return (VM) factory.create(a4.q(cVar));
            }
        } catch (AbstractMethodError unused2) {
            return (VM) factory.create(a4.q(cVar), creationExtras);
        }
    }
}
