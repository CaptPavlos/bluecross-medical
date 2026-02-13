package androidx.fragment.app.strictmode;

import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SetTargetFragmentUsageViolation extends TargetFragmentUsageViolation {
    private final int requestCode;
    private final Fragment targetFragment;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetTargetFragmentUsageViolation(Fragment fragment, Fragment fragment2, int i10) {
        super(fragment, "Attempting to set target fragment " + fragment2 + " with request code " + i10 + " for fragment " + fragment);
        fragment.getClass();
        fragment2.getClass();
        this.targetFragment = fragment2;
        this.requestCode = i10;
    }

    public final int getRequestCode() {
        return this.requestCode;
    }

    public final Fragment getTargetFragment() {
        return this.targetFragment;
    }
}
