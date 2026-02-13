package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import g7.l;
import r7.i0;
import r7.s;
import s6.w;
import w7.n;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    public static final class AnonymousClass2 implements g7.a {
        final /* synthetic */ g7.a $block;

        public AnonymousClass2(g7.a aVar) {
            this.$block = aVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [R, java.lang.Object] */
        @Override // g7.a
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z9, final s sVar, final g7.a aVar, w6.c cVar) {
        final r7.g gVar = new r7.g(1, r0.f.F(cVar));
        gVar.s();
        final ?? r72 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Object jVar;
                lifecycleOwner.getClass();
                event.getClass();
                if (event != Lifecycle.Event.Companion.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        gVar.resumeWith(new s6.j(new LifecycleDestroyedException()));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                r7.f fVar = gVar;
                try {
                    jVar = aVar.invoke();
                } catch (Throwable th) {
                    jVar = new s6.j(th);
                }
                fVar.resumeWith(jVar);
            }
        };
        if (z9) {
            sVar.dispatch(w6.i.f13523a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r72);
                }
            });
        } else {
            lifecycle.addObserver(r72);
        }
        gVar.u(new l() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            public final void invoke(Throwable th) {
                s sVar2 = sVar;
                w6.i iVar = w6.i.f13523a;
                if (!sVar2.isDispatchNeeded(iVar)) {
                    lifecycle.removeObserver(r72);
                    return;
                }
                s sVar3 = sVar;
                final Lifecycle lifecycle2 = lifecycle;
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r72;
                sVar3.dispatch(iVar, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        lifecycle2.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                    }
                });
            }

            @Override // g7.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return w.f12711a;
            }
        });
        return gVar.q();
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, g7.a aVar, w6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, g7.a aVar, w6.c cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, g7.a aVar, w6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, g7.a aVar, w6.c cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, g7.a aVar, w6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, g7.a aVar, w6.c cVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, g7.a aVar, w6.c cVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) < 0) {
            androidx.constraintlayout.core.state.b.i(state, "target state must be CREATED or greater, found ");
            return null;
        }
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, g7.a aVar, w6.c cVar) {
        lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            y7.e eVar = i0.f12407a;
            s7.c cVar2 = n.f13548a.f12716c;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, g7.a aVar, w6.c cVar) {
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, g7.a aVar, w6.c cVar) {
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, g7.a aVar, w6.c cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, g7.a aVar, w6.c cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, g7.a aVar, w6.c cVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, g7.a aVar, w6.c cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            y7.e eVar = i0.f12407a;
            s7.c cVar2 = n.f13548a.f12716c;
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, g7.a aVar, w6.c cVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, g7.a aVar, w6.c cVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, g7.a aVar, w6.c cVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        y7.e eVar = i0.f12407a;
        s7.c cVar2 = n.f13548a.f12716c;
        boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, g7.a aVar, w6.c cVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            y7.e eVar = i0.f12407a;
            s7.c cVar2 = n.f13548a.f12716c;
            boolean zIsDispatchNeeded = cVar2.isDispatchNeeded(cVar.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, cVar2, new AnonymousClass2(aVar), cVar);
        }
        androidx.constraintlayout.core.state.b.i(state, "target state must be CREATED or greater, found ");
        return null;
    }
}
