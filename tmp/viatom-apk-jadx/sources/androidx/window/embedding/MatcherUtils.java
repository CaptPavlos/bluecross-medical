package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.l;
import o7.m;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalWindowApi
/* loaded from: classes.dex */
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!m.d0(str2, "*", false)) {
            return false;
        }
        if (l.a(str2, "*")) {
            return true;
        }
        if (m.k0(str2, "*", 0, false, 6) == m.m0("*", str2, 6) && u.X(str2, "*", false)) {
            return u.c0(str, str2.substring(0, str2.length() - 1), false);
        }
        com.google.gson.internal.a.n("Name pattern with a wildcard must only contain a single wildcard in the end");
        return false;
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName componentName) {
        ComponentName component;
        activity.getClass();
        componentName.getClass();
        if (areComponentsMatching$window_release(activity.getComponentName(), componentName)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, componentName);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0079 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean areComponentsMatching$window_release(android.content.ComponentName r6, android.content.ComponentName r7) {
        /*
            r5 = this;
            r7.getClass()
            java.lang.String r0 = "*"
            r1 = 1
            r2 = 0
            if (r6 != 0) goto L1e
            java.lang.String r6 = r7.getPackageName()
            boolean r6 = kotlin.jvm.internal.l.a(r6, r0)
            if (r6 == 0) goto L7c
            java.lang.String r6 = r7.getClassName()
            boolean r6 = kotlin.jvm.internal.l.a(r6, r0)
            if (r6 == 0) goto L7c
            goto L7b
        L1e:
            java.lang.String r3 = r6.toString()
            r3.getClass()
            boolean r0 = o7.m.d0(r3, r0, r2)
            if (r0 != 0) goto L7d
            java.lang.String r0 = r6.getPackageName()
            java.lang.String r3 = r7.getPackageName()
            boolean r0 = kotlin.jvm.internal.l.a(r0, r3)
            if (r0 != 0) goto L50
            java.lang.String r0 = r6.getPackageName()
            r0.getClass()
            java.lang.String r3 = r7.getPackageName()
            r3.getClass()
            boolean r0 = r5.wildcardMatch(r0, r3)
            if (r0 == 0) goto L4e
            goto L50
        L4e:
            r0 = r2
            goto L51
        L50:
            r0 = r1
        L51:
            java.lang.String r3 = r6.getClassName()
            java.lang.String r4 = r7.getClassName()
            boolean r3 = kotlin.jvm.internal.l.a(r3, r4)
            if (r3 != 0) goto L76
            java.lang.String r6 = r6.getClassName()
            r6.getClass()
            java.lang.String r7 = r7.getClassName()
            r7.getClass()
            boolean r6 = r5.wildcardMatch(r6, r7)
            if (r6 == 0) goto L74
            goto L76
        L74:
            r6 = r2
            goto L77
        L76:
            r6 = r1
        L77:
            if (r0 == 0) goto L7c
            if (r6 == 0) goto L7c
        L7b:
            return r1
        L7c:
            return r2
        L7d:
            java.lang.String r6 = "Wildcard can only be part of the rule."
            com.google.gson.internal.a.n(r6)
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.areComponentsMatching$window_release(android.content.ComponentName, android.content.ComponentName):boolean");
    }
}
