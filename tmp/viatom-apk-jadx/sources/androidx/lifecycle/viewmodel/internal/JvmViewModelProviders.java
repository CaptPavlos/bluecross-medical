package androidx.lifecycle.viewmodel.internal;

import androidx.lifecycle.ViewModel;
import androidx.privacysandbox.ads.adservices.adid.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class JvmViewModelProviders {
    public static final JvmViewModelProviders INSTANCE = new JvmViewModelProviders();

    private JvmViewModelProviders() {
    }

    public final <T extends ViewModel> T createViewModel(Class<T> cls) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        cls.getClass();
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                a.i(cls, "Cannot create an instance of ");
                return null;
            }
            try {
                T tNewInstance = declaredConstructor.newInstance(null);
                tNewInstance.getClass();
                return tNewInstance;
            } catch (IllegalAccessException e) {
                androidx.core.view.accessibility.a.n("Cannot create an instance of ", cls, e);
                return null;
            } catch (InstantiationException e3) {
                androidx.core.view.accessibility.a.n("Cannot create an instance of ", cls, e3);
                return null;
            }
        } catch (NoSuchMethodException e7) {
            androidx.core.view.accessibility.a.n("Cannot create an instance of ", cls, e7);
            return null;
        }
    }
}
