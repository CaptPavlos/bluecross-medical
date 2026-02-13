package androidx.work;

import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class InputMergerKt {
    private static final String TAG;

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("InputMerger");
        strTagWithPrefix.getClass();
        TAG = strTagWithPrefix;
    }

    public static final InputMerger fromClassName(String str) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        str.getClass();
        try {
            Object objNewInstance = Class.forName(str).getDeclaredConstructor(null).newInstance(null);
            objNewInstance.getClass();
            return (InputMerger) objNewInstance;
        } catch (Exception e) {
            Logger.get().error(TAG, "Trouble instantiating ".concat(str), e);
            return null;
        }
    }
}
