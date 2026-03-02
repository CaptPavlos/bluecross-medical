package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import com.google.gson.internal.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor;
    private static final Method sNativeCreateFromTypeface;
    private static final Method sNativeCreateWeightAlias;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;

    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;

    static {
        Field declaredField;
        Constructor<Typeface> declaredConstructor;
        Method declaredMethod;
        Method declaredMethod2;
        try {
            declaredField = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
            Class cls = Long.TYPE;
            Class cls2 = Integer.TYPE;
            try {
                declaredMethod = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, cls, cls2);
                declaredMethod.setAccessible(true);
                declaredMethod2 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, cls, cls2);
                declaredMethod2.setAccessible(true);
                declaredConstructor = Typeface.class.getDeclaredConstructor(cls);
                declaredConstructor.setAccessible(true);
            } catch (NoSuchMethodException e) {
                e = e;
                Log.e(TAG, e.getClass().getName(), e);
                declaredField = null;
                declaredConstructor = null;
                declaredMethod = null;
                declaredMethod2 = null;
                sNativeInstance = declaredField;
                sNativeCreateFromTypeface = declaredMethod;
                sNativeCreateWeightAlias = declaredMethod2;
                sConstructor = declaredConstructor;
                sWeightTypefaceCache = new LongSparseArray<>(3);
                sWeightCacheLock = new Object();
            }
        } catch (NoSuchFieldException | NoSuchMethodException e3) {
            e = e3;
        }
        sNativeInstance = declaredField;
        sNativeCreateFromTypeface = declaredMethod;
        sNativeCreateWeightAlias = declaredMethod2;
        sConstructor = declaredConstructor;
        sWeightTypefaceCache = new LongSparseArray<>(3);
        sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    private static Typeface create(long j10) {
        try {
            return sConstructor.newInstance(Long.valueOf(j10));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public static Typeface createWeightStyle(@NonNull Typeface typeface, int i10, boolean z9) {
        if (!isPrivateApiAvailable()) {
            return null;
        }
        int i11 = (i10 << 1) | (z9 ? 1 : 0);
        synchronized (sWeightCacheLock) {
            try {
                long nativeInstance = getNativeInstance(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = sWeightTypefaceCache;
                SparseArray<Typeface> sparseArray = longSparseArray.get(nativeInstance);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>(4);
                    longSparseArray.put(nativeInstance, sparseArray);
                } else {
                    Typeface typeface2 = sparseArray.get(i11);
                    if (typeface2 != null) {
                        return typeface2;
                    }
                }
                Typeface typefaceCreate = z9 == typeface.isItalic() ? create(nativeCreateWeightAlias(nativeInstance, i10)) : create(nativeCreateFromTypefaceWithExactStyle(nativeInstance, i10, z9));
                sparseArray.put(i11, typefaceCreate);
                return typefaceCreate;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long getNativeInstance(@NonNull Typeface typeface) {
        try {
            return sNativeInstance.getLong(typeface);
        } catch (IllegalAccessException e) {
            a.j(e);
            return 0L;
        }
    }

    private static boolean isPrivateApiAvailable() {
        return sNativeInstance != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateFromTypefaceWithExactStyle(long j10, int i10, boolean z9) {
        try {
            Long l10 = (Long) sNativeCreateFromTypeface.invoke(null, Long.valueOf(j10), Integer.valueOf(z9 ? 2 : 0));
            l10.longValue();
            return ((Long) sNativeCreateWeightAlias.invoke(null, l10, Integer.valueOf(i10))).longValue();
        } catch (IllegalAccessException e) {
            a.j(e);
            return 0L;
        } catch (InvocationTargetException e3) {
            a.j(e3);
            return 0L;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateWeightAlias(long j10, int i10) {
        try {
            return ((Long) sNativeCreateWeightAlias.invoke(null, Long.valueOf(j10), Integer.valueOf(i10))).longValue();
        } catch (IllegalAccessException e) {
            a.j(e);
            return 0L;
        } catch (InvocationTargetException e3) {
            a.j(e3);
            return 0L;
        }
    }
}
