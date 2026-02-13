package androidx.graphics.shapes;

import androidx.collection.FloatList;
import androidx.constraintlayout.core.state.b;
import com.google.android.gms.internal.measurement.l5;
import java.util.Collection;
import java.util.Iterator;
import t6.m;
import t6.x;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FloatMappingKt {
    public static final float linearMap(FloatList floatList, FloatList floatList2, float f) {
        floatList.getClass();
        floatList2.getClass();
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException(("Invalid progress: " + f).toString());
        }
        Iterator it = l5.N(0, floatList._size).iterator();
        while (it.hasNext()) {
            int iNextInt = ((x) it).nextInt();
            int i10 = iNextInt + 1;
            if (progressInRange(f, floatList.get(iNextInt), floatList.get(i10 % floatList.getSize()))) {
                int size = i10 % floatList.getSize();
                float fPositiveModulo = Utils.positiveModulo(floatList.get(size) - floatList.get(iNextInt), 1.0f);
                return Utils.positiveModulo((Utils.positiveModulo(floatList2.get(size) - floatList2.get(iNextInt), 1.0f) * (fPositiveModulo < 0.001f ? 0.5f : Utils.positiveModulo(f - floatList.get(iNextInt), 1.0f) / fPositiveModulo)) + floatList2.get(iNextInt), 1.0f);
            }
        }
        com.google.gson.internal.a.o("Collection contains no element matching the predicate.");
        return 0.0f;
    }

    public static final boolean progressInRange(float f, float f10, float f11) {
        return f11 >= f10 ? f10 <= f && f <= f11 : f >= f10 || f <= f11;
    }

    public static final void validateProgress(FloatList floatList) {
        int i10;
        floatList.getClass();
        Boolean boolValueOf = Boolean.TRUE;
        float[] fArr = floatList.content;
        int i11 = floatList._size;
        int i12 = 0;
        while (true) {
            boolean z9 = true;
            if (i12 >= i11) {
                break;
            }
            float f = fArr[i12];
            if (!boolValueOf.booleanValue() || 0.0f > f || f > 1.0f) {
                z9 = false;
            }
            boolValueOf = Boolean.valueOf(z9);
            i12++;
        }
        if (!boolValueOf.booleanValue()) {
            b.i(FloatList.joinToString$default(floatList, null, null, null, 0, null, 31, null), "FloatMapping - Progress outside of range: ");
            return;
        }
        Iterable iterableN = l5.N(1, floatList.getSize());
        if ((iterableN instanceof Collection) && ((Collection) iterableN).isEmpty()) {
            i10 = 0;
        } else {
            Iterator it = iterableN.iterator();
            i10 = 0;
            while (it.hasNext()) {
                int iNextInt = ((x) it).nextInt();
                if (floatList.get(iNextInt) < floatList.get(iNextInt - 1) && (i10 = i10 + 1) < 0) {
                    m.T();
                    throw null;
                }
            }
        }
        if (i10 <= 1) {
            return;
        }
        b.i(FloatList.joinToString$default(floatList, null, null, null, 0, null, 31, null), "FloatMapping - Progress wraps more than once: ");
    }
}
