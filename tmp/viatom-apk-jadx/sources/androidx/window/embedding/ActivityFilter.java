package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.l;
import o7.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public ActivityFilter(ComponentName componentName, String str) {
        componentName.getClass();
        this.componentName = componentName;
        this.intentAction = str;
        String packageName = componentName.getPackageName();
        packageName.getClass();
        String className = componentName.getClassName();
        className.getClass();
        if (packageName.length() <= 0) {
            com.google.gson.internal.a.n("Package name must not be empty");
            throw null;
        }
        if (className.length() <= 0) {
            com.google.gson.internal.a.n("Activity class name must not be empty.");
            throw null;
        }
        if (m.d0(packageName, "*", false) && m.k0(packageName, "*", 0, false, 6) != packageName.length() - 1) {
            com.google.gson.internal.a.n("Wildcard in package name is only allowed at the end.");
            throw null;
        }
        if (!m.d0(className, "*", false) || m.k0(className, "*", 0, false, 6) == className.length() - 1) {
            return;
        }
        com.google.gson.internal.a.n("Wildcard in class name is only allowed at the end.");
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        return l.a(this.componentName, activityFilter.componentName) && l.a(this.intentAction, activityFilter.intentAction);
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int iHashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final boolean matchesActivity(Activity activity) {
        activity.getClass();
        if (!MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        if (str == null) {
            return true;
        }
        Intent intent = activity.getIntent();
        return l.a(str, intent == null ? null : intent.getAction());
    }

    public final boolean matchesIntent(Intent intent) {
        intent.getClass();
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        return str == null || l.a(str, intent.getAction());
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + ((Object) this.intentAction) + ')';
    }
}
