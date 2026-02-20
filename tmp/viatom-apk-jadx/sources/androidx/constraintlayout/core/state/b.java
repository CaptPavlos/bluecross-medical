package androidx.constraintlayout.core.state;

import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.Person;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.location.GnssStatus;
import android.os.LocaleList;
import android.text.PrecomputedText;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f460a;

    public /* synthetic */ b(int i10) {
        this.f460a = i10;
    }

    public static /* bridge */ /* synthetic */ NotificationChannel a(Object obj) {
        return (NotificationChannel) obj;
    }

    public static /* bridge */ /* synthetic */ NotificationChannelGroup b(Object obj) {
        return (NotificationChannelGroup) obj;
    }

    public static /* bridge */ /* synthetic */ Person c(Object obj) {
        return (Person) obj;
    }

    public static /* bridge */ /* synthetic */ ShortcutInfo d(Object obj) {
        return (ShortcutInfo) obj;
    }

    public static /* bridge */ /* synthetic */ ShortcutManager e(Object obj) {
        return (ShortcutManager) obj;
    }

    public static /* bridge */ /* synthetic */ GnssStatus f(Object obj) {
        return (GnssStatus) obj;
    }

    public static /* bridge */ /* synthetic */ LocaleList g(Object obj) {
        return (LocaleList) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void h(int i10, Object obj, Object obj2, Object obj3, String str) {
        throw new IllegalArgumentException(str + obj + obj2 + obj3 + ((char) i10));
    }

    public static /* synthetic */ void i(Object obj, String str) {
        throw new IllegalArgumentException((str + obj).toString());
    }

    public static /* synthetic */ void j(Object obj, String str, Object obj2) {
        throw new IllegalArgumentException(str + obj + obj2);
    }

    public static /* bridge */ /* synthetic */ boolean k(Object obj) {
        return obj instanceof PrecomputedText;
    }

    public static /* bridge */ /* synthetic */ Class l() {
        return ShortcutManager.class;
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float f) {
        switch (this.f460a) {
            case 0:
                return Transition.lambda$getInterpolator$6(f);
            default:
                return Transition.lambda$getInterpolator$7(f);
        }
    }
}
