package androidx.graphics.shapes;

import g7.l;
import kotlin.jvm.internal.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FeatureMappingKt$featureMapper$2$1$1 extends m implements l {
    final /* synthetic */ int $N;
    final /* synthetic */ DoubleMapper $dm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeatureMappingKt$featureMapper$2$1$1(DoubleMapper doubleMapper, int i10) {
        super(1);
        this.$dm = doubleMapper;
        this.$N = i10;
    }

    public final CharSequence invoke(int i10) {
        return Format_jvmKt.toStringWithLessPrecision(this.$dm.map(i10 / this.$N));
    }

    @Override // g7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }
}
