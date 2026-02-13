package androidx.graphics.shapes;

import androidx.collection.MutableFloatList;
import kotlin.jvm.internal.g;
import s6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class DoubleMapper {
    public static final Companion Companion = new Companion(null);
    public static final DoubleMapper Identity;
    private final MutableFloatList sourceValues;
    private final MutableFloatList targetValues;

    static {
        Float fValueOf = Float.valueOf(0.0f);
        i iVar = new i(fValueOf, fValueOf);
        Float fValueOf2 = Float.valueOf(0.5f);
        Identity = new DoubleMapper(iVar, new i(fValueOf2, fValueOf2));
    }

    public DoubleMapper(i... iVarArr) {
        iVarArr.getClass();
        this.sourceValues = new MutableFloatList(iVarArr.length);
        this.targetValues = new MutableFloatList(iVarArr.length);
        int length = iVarArr.length;
        int i10 = 0;
        while (true) {
            MutableFloatList mutableFloatList = this.sourceValues;
            if (i10 >= length) {
                FloatMappingKt.validateProgress(mutableFloatList);
                FloatMappingKt.validateProgress(this.targetValues);
                return;
            } else {
                mutableFloatList.add(((Number) iVarArr[i10].f12693a).floatValue());
                this.targetValues.add(((Number) iVarArr[i10].f12694b).floatValue());
                i10++;
            }
        }
    }

    public final float map(float f) {
        return FloatMappingKt.linearMap(this.sourceValues, this.targetValues, f);
    }

    public final float mapBack(float f) {
        return FloatMappingKt.linearMap(this.targetValues, this.sourceValues, f);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }
}
