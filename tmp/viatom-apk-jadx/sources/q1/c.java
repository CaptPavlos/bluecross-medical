package q1;

import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements q2.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12223a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12224b;

    public /* synthetic */ c(Object obj, int i10) {
        this.f12223a = i10;
        this.f12224b = obj;
    }

    @Override // q2.b
    public final Object get() throws ClassNotFoundException {
        switch (this.f12223a) {
            case 0:
                String str = (String) this.f12224b;
                try {
                    Class<?> cls = Class.forName(str);
                    if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                        return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
                    }
                    throw new l("Class " + str + " is not an instance of com.google.firebase.components.ComponentRegistrar");
                } catch (ClassNotFoundException unused) {
                    Log.w("ComponentDiscovery", "Class " + str + " is not an found.");
                    return null;
                } catch (IllegalAccessException e) {
                    throw new l(androidx.constraintlayout.core.widgets.analyzer.a.x("Could not instantiate ", str, "."), e);
                } catch (InstantiationException e3) {
                    throw new l(androidx.constraintlayout.core.widgets.analyzer.a.x("Could not instantiate ", str, "."), e3);
                } catch (NoSuchMethodException e7) {
                    throw new l(a3.a.i("Could not instantiate ", str), e7);
                } catch (InvocationTargetException e10) {
                    throw new l(a3.a.i("Could not instantiate ", str), e10);
                }
            case 1:
                return (ComponentRegistrar) this.f12224b;
            default:
                return new s2.c((l1.g) this.f12224b);
        }
    }
}
