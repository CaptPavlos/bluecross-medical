package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SetUserVisibleHintViolation extends Violation {
    private final boolean isVisibleToUser;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetUserVisibleHintViolation(Fragment fragment, boolean z9) {
        super(fragment, "Attempting to set user visible hint to " + z9 + " for fragment " + fragment);
        fragment.getClass();
        this.isVisibleToUser = z9;
    }

    public final boolean isVisibleToUser() {
        return this.isVisibleToUser;
    }
}
