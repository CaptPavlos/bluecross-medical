package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import com.google.android.gms.internal.measurement.a4;
import java.util.List;
import kotlin.jvm.internal.g;
import u6.c;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class Feature {
    private final List<Cubic> cubics;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Edge extends Feature {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Edge(List<? extends Cubic> list) {
            super(list);
            list.getClass();
        }

        public String toString() {
            return "Edge";
        }

        @Override // androidx.graphics.shapes.Feature
        public Edge transformed$graphics_shapes_release(PointTransformer pointTransformer) {
            pointTransformer.getClass();
            c cVarL = a4.l();
            int size = getCubics().size();
            for (int i10 = 0; i10 < size; i10++) {
                cVarL.add(getCubics().get(i10).transformed(pointTransformer));
            }
            return new Edge(a4.h(cVarL));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Feature(List<? extends Cubic> list) {
        list.getClass();
        this.cubics = list;
    }

    public final List<Cubic> getCubics() {
        return this.cubics;
    }

    public abstract Feature transformed$graphics_shapes_release(PointTransformer pointTransformer);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Corner extends Feature {
        private final boolean convex;
        private final long roundedCenter;
        private final long vertex;

        public /* synthetic */ Corner(List list, long j10, long j11, boolean z9, int i10, g gVar) {
            this(list, j10, j11, (i10 & 8) != 0 ? true : z9, null);
        }

        public final boolean getConvex() {
            return this.convex;
        }

        /* renamed from: getRoundedCenter-1ufDz9w, reason: not valid java name */
        public final long m48getRoundedCenter1ufDz9w() {
            return this.roundedCenter;
        }

        /* renamed from: getVertex-1ufDz9w, reason: not valid java name */
        public final long m49getVertex1ufDz9w() {
            return this.vertex;
        }

        public String toString() {
            return "Corner: vertex=" + ((Object) FloatFloatPair.m16toStringimpl(this.vertex)) + ", center=" + ((Object) FloatFloatPair.m16toStringimpl(this.roundedCenter)) + ", convex=" + this.convex;
        }

        @Override // androidx.graphics.shapes.Feature
        public Feature transformed$graphics_shapes_release(PointTransformer pointTransformer) {
            pointTransformer.getClass();
            c cVarL = a4.l();
            int size = getCubics().size();
            for (int i10 = 0; i10 < size; i10++) {
                cVarL.add(getCubics().get(i10).transformed(pointTransformer));
            }
            return new Corner(a4.h(cVarL), PointKt.m66transformedso9K2fw(this.vertex, pointTransformer), PointKt.m66transformedso9K2fw(this.roundedCenter, pointTransformer), this.convex, null);
        }

        public /* synthetic */ Corner(List list, long j10, long j11, boolean z9, g gVar) {
            this(list, j10, j11, z9);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Corner(List<? extends Cubic> list, long j10, long j11, boolean z9) {
            super(list);
            list.getClass();
            this.vertex = j10;
            this.roundedCenter = j11;
            this.convex = z9;
        }
    }
}
