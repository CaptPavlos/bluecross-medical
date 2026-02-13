package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import com.google.android.gms.internal.measurement.a4;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.a0;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public final class SavedStateViewModelFactory_androidKt {
    private static final List<Class<?>> ANDROID_VIEWMODEL_SIGNATURE = m.Q(Application.class, SavedStateHandle.class);
    private static final List<Class<?>> VIEWMODEL_SIGNATURE = a4.u(SavedStateHandle.class);

    public static final <T> Constructor<T> findMatchingConstructor(Class<T> cls, List<? extends Class<?>> list) {
        cls.getClass();
        list.getClass();
        kotlin.jvm.internal.b bVarD = a0.d(cls.getConstructors());
        while (bVarD.hasNext()) {
            Constructor<T> constructor = (Constructor) bVarD.next();
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            parameterTypes.getClass();
            List listY0 = t6.j.y0(parameterTypes);
            if (list.equals(listY0)) {
                return constructor;
            }
            if (list.size() == listY0.size() && listY0.containsAll(list)) {
                throw new UnsupportedOperationException("Class " + cls.getSimpleName() + " must have parameters in the proper order: " + list);
            }
        }
        return null;
    }

    public static final <T extends ViewModel> T newInstance(Class<T> cls, Constructor<T> constructor, Object... objArr) {
        cls.getClass();
        constructor.getClass();
        objArr.getClass();
        try {
            return constructor.newInstance(Arrays.copyOf(objArr, objArr.length));
        } catch (IllegalAccessException e) {
            androidx.core.view.accessibility.a.n("Failed to access ", cls, e);
            return null;
        } catch (InstantiationException e3) {
            throw new RuntimeException("A " + cls + " cannot be instantiated.", e3);
        } catch (InvocationTargetException e7) {
            androidx.privacysandbox.ads.adservices.adid.a.l("An exception happened in constructor of " + cls, e7.getCause());
            return null;
        }
    }
}
