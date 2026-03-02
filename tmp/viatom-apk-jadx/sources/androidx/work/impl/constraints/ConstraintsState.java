package androidx.work.impl.constraints;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class ConstraintsState {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ConstraintsMet extends ConstraintsState {
        public static final ConstraintsMet INSTANCE = new ConstraintsMet();

        private ConstraintsMet() {
            super(null);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class ConstraintsNotMet extends ConstraintsState {
        private final int reason;

        public ConstraintsNotMet(int i10) {
            super(null);
            this.reason = i10;
        }

        public static /* synthetic */ ConstraintsNotMet copy$default(ConstraintsNotMet constraintsNotMet, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = constraintsNotMet.reason;
            }
            return constraintsNotMet.copy(i10);
        }

        public final int component1() {
            return this.reason;
        }

        public final ConstraintsNotMet copy(int i10) {
            return new ConstraintsNotMet(i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConstraintsNotMet) && this.reason == ((ConstraintsNotMet) obj).reason;
        }

        public final int getReason() {
            return this.reason;
        }

        public int hashCode() {
            return this.reason;
        }

        public String toString() {
            return a3.a.k(new StringBuilder("ConstraintsNotMet(reason="), this.reason, ')');
        }
    }

    public /* synthetic */ ConstraintsState(g gVar) {
        this();
    }

    private ConstraintsState() {
    }
}
