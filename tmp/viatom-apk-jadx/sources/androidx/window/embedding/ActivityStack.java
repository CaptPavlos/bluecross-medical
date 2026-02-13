package androidx.window.embedding;

import android.app.Activity;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityStack {
    private final List<Activity> activities;
    private final boolean isEmpty;

    /* JADX WARN: Multi-variable type inference failed */
    public ActivityStack(List<? extends Activity> list, boolean z9) {
        list.getClass();
        this.activities = list;
        this.isEmpty = z9;
    }

    public final boolean contains(Activity activity) {
        activity.getClass();
        return this.activities.contains(activity);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityStack)) {
            return false;
        }
        ActivityStack activityStack = (ActivityStack) obj;
        return (l.a(this.activities, activityStack.activities) || this.isEmpty == activityStack.isEmpty) ? false : true;
    }

    public final List<Activity> getActivities$window_release() {
        return this.activities;
    }

    public int hashCode() {
        return this.activities.hashCode() + ((this.isEmpty ? 1 : 0) * 31);
    }

    public final boolean isEmpty() {
        return this.isEmpty;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ActivityStack{");
        sb.append(l.g(getActivities$window_release(), "activities="));
        sb.append("isEmpty=" + this.isEmpty + '}');
        return sb.toString();
    }

    public /* synthetic */ ActivityStack(List list, boolean z9, int i10, g gVar) {
        this(list, (i10 & 2) != 0 ? false : z9);
    }
}
