package androidx.lifecycle.viewmodel;

import androidx.lifecycle.viewmodel.CreationExtras;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class CreationExtrasKt {
    public static final boolean contains(CreationExtras creationExtras, CreationExtras.Key<?> key) {
        creationExtras.getClass();
        key.getClass();
        return creationExtras.getExtras$lifecycle_viewmodel_release().containsKey(key);
    }

    public static final MutableCreationExtras plus(CreationExtras creationExtras, CreationExtras creationExtras2) {
        creationExtras.getClass();
        creationExtras2.getClass();
        Map<CreationExtras.Key<?>, Object> extras$lifecycle_viewmodel_release = creationExtras.getExtras$lifecycle_viewmodel_release();
        Map<CreationExtras.Key<?>, Object> extras$lifecycle_viewmodel_release2 = creationExtras2.getExtras$lifecycle_viewmodel_release();
        extras$lifecycle_viewmodel_release.getClass();
        extras$lifecycle_viewmodel_release2.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(extras$lifecycle_viewmodel_release);
        linkedHashMap.putAll(extras$lifecycle_viewmodel_release2);
        return new MutableCreationExtras(linkedHashMap);
    }

    public static final void plusAssign(MutableCreationExtras mutableCreationExtras, CreationExtras creationExtras) {
        mutableCreationExtras.getClass();
        creationExtras.getClass();
        mutableCreationExtras.getExtras$lifecycle_viewmodel_release().putAll(creationExtras.getExtras$lifecycle_viewmodel_release());
    }
}
