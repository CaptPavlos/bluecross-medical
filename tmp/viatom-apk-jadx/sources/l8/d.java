package l8;

import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class d extends b {
    @Override // l8.b
    public final Object[] b(int i10) {
        int leadingMargin = 10;
        if (i10 > 1) {
            leadingMargin = 10 - this.f11093a.getLeadingMargin(true);
            if (i10 > 2) {
                leadingMargin -= (i10 - 2) * 20;
            }
        }
        return new Object[]{new LeadingMarginSpan.Standard((i10 - 1) * 20), new BulletSpan(leadingMargin)};
    }
}
