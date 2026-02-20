package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class MethodCallsLogger {
    private final Map<String, Integer> calledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i10) {
        str.getClass();
        Integer num = this.calledMethods.get(str);
        int iIntValue = num != null ? num.intValue() : 0;
        boolean z9 = (iIntValue & i10) != 0;
        this.calledMethods.put(str, Integer.valueOf(i10 | iIntValue));
        return !z9;
    }
}
