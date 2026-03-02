package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    public /* synthetic */ SplitPairRule(Set set, boolean z9, boolean z10, boolean z11, int i10, int i11, float f, int i12, int i13, g gVar) {
        this(set, (i13 & 2) != 0 ? false : z9, (i13 & 4) != 0 ? true : z10, (i13 & 8) != 0 ? false : z11, (i13 & 16) != 0 ? 0 : i10, (i13 & 32) != 0 ? 0 : i11, (i13 & 64) != 0 ? 0.5f : f, (i13 & 128) != 0 ? 3 : i12);
    }

    @Override // androidx.window.embedding.SplitRule
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        return l.a(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    @Override // androidx.window.embedding.SplitRule
    public int hashCode() {
        return ((((((this.filters.hashCode() + (super.hashCode() * 31)) * 31) + (this.finishPrimaryWithSecondary ? 1231 : 1237)) * 31) + (this.finishSecondaryWithPrimary ? 1231 : 1237)) * 31) + (this.clearTop ? 1231 : 1237);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter splitPairFilter) {
        splitPairFilter.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(splitPairFilter);
        return new SplitPairRule(t6.l.u0(linkedHashSet), this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplitPairRule(Set<SplitPairFilter> set, boolean z9, boolean z10, boolean z11, int i10, int i11, float f, int i12) {
        super(i10, i11, f, i12);
        set.getClass();
        this.finishPrimaryWithSecondary = z9;
        this.finishSecondaryWithPrimary = z10;
        this.clearTop = z11;
        this.filters = t6.l.u0(set);
    }
}
