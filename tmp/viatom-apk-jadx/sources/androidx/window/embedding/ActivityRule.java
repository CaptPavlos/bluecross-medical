package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.g;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    public ActivityRule(Set<ActivityFilter> set, boolean z9) {
        set.getClass();
        this.alwaysExpand = z9;
        this.filters = l.u0(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        return kotlin.jvm.internal.l.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + (this.alwaysExpand ? 1231 : 1237);
    }

    public final ActivityRule plus$window_release(ActivityFilter activityFilter) {
        activityFilter.getClass();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new ActivityRule(l.u0(linkedHashSet), this.alwaysExpand);
    }

    public /* synthetic */ ActivityRule(Set set, boolean z9, int i10, g gVar) {
        this(set, (i10 & 2) != 0 ? false : z9);
    }
}
