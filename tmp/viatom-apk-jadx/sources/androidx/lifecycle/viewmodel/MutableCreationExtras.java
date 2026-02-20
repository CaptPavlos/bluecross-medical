package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MutableCreationExtras extends CreationExtras {
    public MutableCreationExtras(Map<CreationExtras.Key<?>, ? extends Object> map) {
        map.getClass();
        getExtras$lifecycle_viewmodel_release().putAll(map);
    }

    @Override // androidx.lifecycle.viewmodel.CreationExtras
    public <T> T get(CreationExtras.Key<T> key) {
        key.getClass();
        return (T) getExtras$lifecycle_viewmodel_release().get(key);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void set(CreationExtras.Key<T> key, T t) {
        key.getClass();
        getExtras$lifecycle_viewmodel_release().put(key, t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutableCreationExtras() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MutableCreationExtras(CreationExtras creationExtras) {
        this((Map<CreationExtras.Key<?>, ? extends Object>) creationExtras.getExtras$lifecycle_viewmodel_release());
        creationExtras.getClass();
    }

    public /* synthetic */ MutableCreationExtras(CreationExtras creationExtras, int i10, g gVar) {
        this((i10 & 1) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }
}
