package androidx.datastore.core;

import g7.l;
import java.io.File;
import kotlin.jvm.internal.m;
import p4.i0;
import r7.y;
import s6.w;
import t7.k;
import t7.r;
import t7.s;
import w6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class MulticastFileObserver$Companion$observe$1$flowObserver$1 extends m implements l {
    final /* synthetic */ s $$this$channelFlow;
    final /* synthetic */ File $file;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1$flowObserver$1(File file, s sVar) {
        super(1);
        this.$file = file;
        this.$$this$channelFlow = sVar;
    }

    public final void invoke(String str) {
        if (kotlin.jvm.internal.l.a(str, this.$file.getName())) {
            s sVar = this.$$this$channelFlow;
            Object objQ = ((r) sVar).f12859d.q(w.f12711a);
            if (!(objQ instanceof k)) {
                return;
            }
            Object obj = ((t7.l) y.u(i.f13523a, new i0(sVar, null, 11))).f12853a;
        }
    }

    @Override // g7.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return w.f12711a;
    }
}
