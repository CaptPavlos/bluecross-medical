package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.internal.CanonicalName_jvmKt;
import i7.b;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.y;
import m7.k;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
final class SavedStateRegistryOwnerDelegate<T> implements b {
    private final SavedStateConfiguration configuration;
    private final g7.a init;
    private final String key;
    private final SavedStateRegistry registry;
    private final c8.b serializer;
    private T value;

    public SavedStateRegistryOwnerDelegate(SavedStateRegistry savedStateRegistry, c8.b bVar, String str, SavedStateConfiguration savedStateConfiguration, g7.a aVar) {
        savedStateRegistry.getClass();
        bVar.getClass();
        savedStateConfiguration.getClass();
        aVar.getClass();
        this.registry = savedStateRegistry;
        this.serializer = bVar;
        this.key = str;
        this.configuration = savedStateConfiguration;
        this.init = aVar;
    }

    private final String createDefaultKey(Object obj, k kVar) {
        String str;
        if (obj != null) {
            str = CanonicalName_jvmKt.getCanonicalName(y.a(obj.getClass())) + '.';
        } else {
            str = "";
        }
        StringBuilder sbV = a3.a.v(str);
        sbV.append(kVar.getName());
        return sbV.toString();
    }

    private final T loadValue(String str) {
        Bundle bundleConsumeRestoredStateForKey = this.registry.consumeRestoredStateForKey(str);
        if (bundleConsumeRestoredStateForKey != null) {
            return (T) SavedStateDecoderKt.decodeFromSavedState(this.serializer, bundleConsumeRestoredStateForKey, this.configuration);
        }
        return null;
    }

    private final void registerSave(String str) {
        this.registry.registerSavedStateProvider(str, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.savedstate.serialization.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle saveState() {
                return SavedStateRegistryOwnerDelegate.registerSave$lambda$1(this.f639a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle registerSave$lambda$1(SavedStateRegistryOwnerDelegate savedStateRegistryOwnerDelegate) {
        c8.b bVar = savedStateRegistryOwnerDelegate.serializer;
        T t = savedStateRegistryOwnerDelegate.value;
        if (t != null) {
            return SavedStateEncoderKt.encodeToSavedState(bVar, t, savedStateRegistryOwnerDelegate.configuration);
        }
        l.i("value");
        throw null;
    }

    @Override // i7.a
    public T getValue(Object obj, k kVar) {
        kVar.getClass();
        if (this.value == null) {
            String strCreateDefaultKey = this.key;
            if (strCreateDefaultKey == null) {
                strCreateDefaultKey = createDefaultKey(obj, kVar);
            }
            registerSave(strCreateDefaultKey);
            T tLoadValue = loadValue(strCreateDefaultKey);
            if (tLoadValue == null) {
                tLoadValue = (T) this.init.invoke();
            }
            this.value = tLoadValue;
        }
        T t = this.value;
        if (t != null) {
            return t;
        }
        l.i("value");
        throw null;
    }

    public void setValue(Object obj, k kVar, T t) {
        kVar.getClass();
        t.getClass();
        if (this.value == null) {
            String strCreateDefaultKey = this.key;
            if (strCreateDefaultKey == null) {
                strCreateDefaultKey = createDefaultKey(obj, kVar);
            }
            registerSave(strCreateDefaultKey);
        }
        this.value = t;
    }
}
