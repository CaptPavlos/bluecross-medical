package y6;

import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import s6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class a implements w6.c, d, Serializable {
    private final w6.c completion;

    public a(w6.c cVar) {
        this.completion = cVar;
    }

    public w6.c create(w6.c cVar) {
        cVar.getClass();
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public d getCallerFrame() {
        w6.c cVar = this.completion;
        if (cVar instanceof d) {
            return (d) cVar;
        }
        return null;
    }

    public final w6.c getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        e eVar = (e) getClass().getAnnotation(e.class);
        String str = null;
        if (eVar == null) {
            return null;
        }
        int iV = eVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i10 = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        x8.c cVar = f.f14099b;
        x8.c cVar2 = f.f14098a;
        if (cVar == null) {
            try {
                x8.c cVar3 = new x8.c(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod(RewardPlus.NAME, null));
                f.f14099b = cVar3;
                cVar = cVar3;
            } catch (Exception unused2) {
                f.f14099b = cVar2;
                cVar = cVar2;
            }
        }
        if (cVar != cVar2 && (method = cVar.f13730a) != null && (objInvoke = method.invoke(getClass(), null)) != null && (method2 = cVar.f13731b) != null && (objInvoke2 = method2.invoke(objInvoke, null)) != null) {
            Method method3 = cVar.f13732c;
            Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
            if (objInvoke3 instanceof String) {
                str = (String) objInvoke3;
            }
        }
        if (str == null) {
            strC = eVar.c();
        } else {
            strC = str + '/' + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i10);
    }

    public abstract Object invokeSuspend(Object obj);

    @Override // w6.c
    public final void resumeWith(Object obj) {
        w6.c cVar = this;
        while (true) {
            a aVar = (a) cVar;
            w6.c cVar2 = aVar.completion;
            cVar2.getClass();
            try {
                obj = aVar.invokeSuspend(obj);
                if (obj == x6.a.f13718a) {
                    return;
                }
            } catch (Throwable th) {
                obj = new j(th);
            }
            aVar.releaseIntercepted();
            if (!(cVar2 instanceof a)) {
                cVar2.resumeWith(obj);
                return;
            }
            cVar = cVar2;
        }
    }

    public String toString() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public w6.c create(Object obj, w6.c cVar) {
        cVar.getClass();
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public void releaseIntercepted() {
    }
}
