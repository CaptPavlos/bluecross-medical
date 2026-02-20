package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.internal.CanonicalName_jvmKt;
import androidx.lifecycle.viewmodel.internal.ViewModelProviders;
import g7.l;
import java.util.LinkedHashMap;
import java.util.Map;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ViewModelFactoryDsl
/* loaded from: classes.dex */
public final class InitializerViewModelFactoryBuilder {
    private final Map<c, ViewModelInitializer<?>> initializers = new LinkedHashMap();

    public final <T extends ViewModel> void addInitializer(c cVar, l lVar) {
        cVar.getClass();
        lVar.getClass();
        if (!this.initializers.containsKey(cVar)) {
            this.initializers.put(cVar, new ViewModelInitializer<>(cVar, lVar));
            return;
        }
        throw new IllegalArgumentException(("A `initializer` with the same `clazz` has already been added: " + CanonicalName_jvmKt.getCanonicalName(cVar) + '.').toString());
    }

    public final ViewModelProvider.Factory build() {
        return ViewModelProviders.INSTANCE.createInitializerFactory$lifecycle_viewmodel_release(this.initializers.values());
    }
}
