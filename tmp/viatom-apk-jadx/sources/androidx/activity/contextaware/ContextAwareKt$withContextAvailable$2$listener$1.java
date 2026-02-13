package androidx.activity.contextaware;

import android.content.Context;
import g7.l;
import r7.f;
import s6.j;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ContextAwareKt$withContextAvailable$2$listener$1 implements OnContextAvailableListener {
    final /* synthetic */ f $co;
    final /* synthetic */ l $onContextAvailable;

    public ContextAwareKt$withContextAvailable$2$listener$1(f fVar, l lVar) {
        this.$co = fVar;
        this.$onContextAvailable = lVar;
    }

    @Override // androidx.activity.contextaware.OnContextAvailableListener
    public void onContextAvailable(Context context) {
        Object jVar;
        context.getClass();
        f fVar = this.$co;
        try {
            jVar = this.$onContextAvailable.invoke(context);
        } catch (Throwable th) {
            jVar = new j(th);
        }
        fVar.resumeWith(jVar);
    }
}
