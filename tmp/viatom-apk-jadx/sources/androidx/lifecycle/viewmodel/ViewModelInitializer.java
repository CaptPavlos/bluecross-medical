package androidx.lifecycle.viewmodel;

import androidx.lifecycle.ViewModel;
import g7.l;
import kotlin.jvm.internal.y;
import m7.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ViewModelInitializer<T extends ViewModel> {
    private final c clazz;
    private final l initializer;

    public ViewModelInitializer(c cVar, l lVar) {
        cVar.getClass();
        lVar.getClass();
        this.clazz = cVar;
        this.initializer = lVar;
    }

    public final c getClazz$lifecycle_viewmodel_release() {
        return this.clazz;
    }

    public final l getInitializer$lifecycle_viewmodel_release() {
        return this.initializer;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelInitializer(Class<T> cls, l lVar) {
        this(y.a(cls), lVar);
        cls.getClass();
        lVar.getClass();
    }
}
