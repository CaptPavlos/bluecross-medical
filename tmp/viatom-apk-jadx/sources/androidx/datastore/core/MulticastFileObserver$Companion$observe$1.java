package androidx.datastore.core;

import androidx.datastore.core.MulticastFileObserver;
import g7.p;
import java.io.File;
import kotlin.jvm.internal.m;
import r7.k0;
import s6.w;
import t7.r;
import t7.s;
import w6.c;
import y6.e;
import y6.i;
import z1.t1;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@e(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", l = {84, 85}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class MulticastFileObserver$Companion$observe$1 extends i implements p {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MulticastFileObserver$Companion$observe$1(File file, c cVar) {
        super(2, cVar);
        this.$file = file;
    }

    @Override // y6.a
    public final c create(Object obj, c cVar) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.$file, cVar);
        multicastFileObserver$Companion$observe$1.L$0 = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    @Override // g7.p
    public final Object invoke(s sVar, c cVar) {
        return ((MulticastFileObserver$Companion$observe$1) create(sVar, cVar)).invokeSuspend(w.f12711a);
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        k0 k0VarObserve;
        s sVar;
        int i10 = this.label;
        w wVar = w.f12711a;
        x6.a aVar = x6.a.f13718a;
        if (i10 == 0) {
            s6.a.e(obj);
            s sVar2 = (s) this.L$0;
            MulticastFileObserver$Companion$observe$1$flowObserver$1 multicastFileObserver$Companion$observe$1$flowObserver$1 = new MulticastFileObserver$Companion$observe$1$flowObserver$1(this.$file, sVar2);
            MulticastFileObserver.Companion companion = MulticastFileObserver.Companion;
            File parentFile = this.$file.getParentFile();
            parentFile.getClass();
            k0VarObserve = companion.observe(parentFile, multicastFileObserver$Companion$observe$1$flowObserver$1);
            this.L$0 = sVar2;
            this.L$1 = k0VarObserve;
            this.label = 1;
            if (((r) sVar2).f12859d.l(wVar, this) != aVar) {
                sVar = sVar2;
            }
        }
        if (i10 != 1) {
            if (i10 == 2) {
                s6.a.e(obj);
                return wVar;
            }
            androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        k0VarObserve = (k0) this.L$1;
        sVar = (s) this.L$0;
        s6.a.e(obj);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(k0VarObserve);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        return t1.h(sVar, anonymousClass1, this) == aVar ? aVar : wVar;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements g7.a {
        final /* synthetic */ k0 $disposeListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k0 k0Var) {
            super(0);
            this.$disposeListener = k0Var;
        }

        @Override // g7.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m41invoke();
            return w.f12711a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m41invoke() {
            this.$disposeListener.dispose();
        }
    }
}
