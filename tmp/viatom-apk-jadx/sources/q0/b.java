package q0;

import android.os.IBinder;
import android.os.IInterface;
import i0.y;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends u0.b implements a {

    /* renamed from: b, reason: collision with root package name */
    public final Object f12218b;

    public b(Object obj) {
        super("com.google.android.gms.dynamic.IObjectWrapper", 2);
        this.f12218b = obj;
    }

    public static a I(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new c(iBinder, "com.google.android.gms.dynamic.IObjectWrapper", 3);
    }

    public static Object J(a aVar) throws SecurityException {
        if (aVar instanceof b) {
            return ((b) aVar).f12218b;
        }
        IBinder iBinderAsBinder = aVar.asBinder();
        Field[] declaredFields = iBinderAsBinder.getClass().getDeclaredFields();
        Field field = null;
        int i10 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i10++;
                field = field2;
            }
        }
        if (i10 != 1) {
            com.google.gson.internal.a.n(a3.a.f(declaredFields.length, "Unexpected number of IObjectWrapper declared fields: "));
            return null;
        }
        y.g(field);
        if (field.isAccessible()) {
            com.google.gson.internal.a.n("IObjectWrapper declared field not private!");
            return null;
        }
        field.setAccessible(true);
        try {
            return field.get(iBinderAsBinder);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Could not access the field in remoteBinder.", e);
        } catch (NullPointerException e3) {
            throw new IllegalArgumentException("Binder object is null.", e3);
        }
    }
}
