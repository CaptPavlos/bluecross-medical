package j$.util;

import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes2.dex */
public final class s0 extends r1 {
    public final /* synthetic */ SortedSet f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(SortedSet sortedSet, java.util.Collection collection) {
        super(21, collection);
        this.f = sortedSet;
    }

    @Override // j$.util.r1, j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f.comparator();
    }
}
