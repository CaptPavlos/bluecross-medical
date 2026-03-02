package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.adid.a;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public final class KClassUtil {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <T, C> T findAndInstantiateDatabaseImpl(Class<C> cls, String str) throws ClassNotFoundException {
        String name;
        String str2;
        cls.getClass();
        str.getClass();
        Package r02 = cls.getPackage();
        if (r02 == null || (name = r02.getName()) == null) {
            name = "";
        }
        String canonicalName = cls.getCanonicalName();
        canonicalName.getClass();
        if (name.length() != 0) {
            canonicalName = canonicalName.substring(name.length() + 1);
        }
        StringBuilder sb = new StringBuilder();
        String strReplace = canonicalName.replace('.', '_');
        strReplace.getClass();
        sb.append(strReplace);
        sb.append(str);
        String string = sb.toString();
        try {
            if (name.length() == 0) {
                str2 = string;
            } else {
                str2 = name + '.' + string;
            }
            Class<?> cls2 = Class.forName(str2, true, cls.getClassLoader());
            cls2.getClass();
            return (T) cls2.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cannot find implementation for " + cls.getCanonicalName() + ". " + string + " does not exist. Is Room annotation processor correctly configured?", e);
        } catch (IllegalAccessException e3) {
            a.k("Cannot access the constructor ", cls.getCanonicalName(), e3);
            return null;
        } catch (InstantiationException e7) {
            a.k("Failed to create an instance of ", cls.getCanonicalName(), e7);
            return null;
        }
    }

    public static /* synthetic */ Object findAndInstantiateDatabaseImpl$default(Class cls, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = "_Impl";
        }
        return findAndInstantiateDatabaseImpl(cls, str);
    }
}
