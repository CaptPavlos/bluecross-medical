package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.slidingpanelayout.widget.FoldingFeatureObserver;
import androidx.window.layout.DisplayFeature;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.WindowInfoTracker;
import androidx.window.layout.WindowLayoutInfo;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import g7.p;
import java.util.Iterator;
import java.util.concurrent.Executor;
import r7.a1;
import r7.w;
import r7.y;
import s6.a;
import u7.h;
import u7.i0;
import w6.c;
import y6.e;
import y6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class FoldingFeatureObserver {
    private final Executor executor;
    private a1 job;
    private OnFoldingFeatureChangeListener onFoldingFeatureChangeListener;
    private final WindowInfoTracker windowInfoTracker;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public interface OnFoldingFeatureChangeListener {
        void onFoldingFeatureChange(FoldingFeature foldingFeature);
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    @e(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1", f = "FoldingFeatureObserver.kt", l = {97}, m = "invokeSuspend")
    /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1, reason: invalid class name */
    public static final class AnonymousClass1 extends i implements p {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, c cVar) {
            super(2, cVar);
            this.$activity = activity;
        }

        @Override // y6.a
        public final c create(Object obj, c cVar) {
            return FoldingFeatureObserver.this.new AnonymousClass1(this.$activity, cVar);
        }

        @Override // g7.p
        public final Object invoke(w wVar, c cVar) {
            return ((AnonymousClass1) create(wVar, cVar)).invokeSuspend(s6.w.f12711a);
        }

        @Override // y6.a
        public final Object invokeSuspend(Object obj) {
            int i10 = this.label;
            if (i10 == 0) {
                a.e(obj);
                final h hVarWindowLayoutInfo = FoldingFeatureObserver.this.windowInfoTracker.windowLayoutInfo(this.$activity);
                final FoldingFeatureObserver foldingFeatureObserver = FoldingFeatureObserver.this;
                h hVarG = i0.g(new h() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1

                    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
                    /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2, reason: invalid class name */
                    public static final class AnonymousClass2 implements u7.i {
                        final /* synthetic */ u7.i $this_unsafeFlow$inlined;
                        final /* synthetic */ FoldingFeatureObserver this$0;

                        @e(c = "androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2", f = "FoldingFeatureObserver.kt", l = {TsExtractor.TS_STREAM_TYPE_DTS}, m = "emit")
                        /* renamed from: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                        public static final class AnonymousClass1 extends y6.c {
                            Object L$0;
                            int label;
                            /* synthetic */ Object result;

                            public AnonymousClass1(c cVar) {
                                super(cVar);
                            }

                            @Override // y6.a
                            public final Object invokeSuspend(Object obj) {
                                this.result = obj;
                                this.label |= Integer.MIN_VALUE;
                                return AnonymousClass2.this.emit(null, this);
                            }
                        }

                        public AnonymousClass2(u7.i iVar, FoldingFeatureObserver foldingFeatureObserver) {
                            this.$this_unsafeFlow$inlined = iVar;
                            this.this$0 = foldingFeatureObserver;
                        }

                        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                        @Override // u7.i
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct add '--show-bad-code' argument
                        */
                        public java.lang.Object emit(java.lang.Object r5, w6.c r6) {
                            /*
                                r4 = this;
                                boolean r0 = r6 instanceof androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                                if (r0 == 0) goto L13
                                r0 = r6
                                androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = (androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r1 & r2
                                if (r3 == 0) goto L13
                                int r1 = r1 - r2
                                r0.label = r1
                                goto L18
                            L13:
                                androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1 r0 = new androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1$2$1
                                r0.<init>(r6)
                            L18:
                                java.lang.Object r6 = r0.result
                                int r1 = r0.label
                                r2 = 1
                                if (r1 == 0) goto L2c
                                if (r1 != r2) goto L25
                                s6.a.e(r6)
                                goto L47
                            L25:
                                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                                androidx.window.layout.c.g(r5)
                                r5 = 0
                                return r5
                            L2c:
                                s6.a.e(r6)
                                u7.i r6 = r4.$this_unsafeFlow$inlined
                                androidx.window.layout.WindowLayoutInfo r5 = (androidx.window.layout.WindowLayoutInfo) r5
                                androidx.slidingpanelayout.widget.FoldingFeatureObserver r1 = r4.this$0
                                androidx.window.layout.FoldingFeature r5 = androidx.slidingpanelayout.widget.FoldingFeatureObserver.access$getFoldingFeature(r1, r5)
                                if (r5 != 0) goto L3c
                                goto L47
                            L3c:
                                r0.label = r2
                                java.lang.Object r5 = r6.emit(r5, r0)
                                x6.a r6 = x6.a.f13718a
                                if (r5 != r6) goto L47
                                return r6
                            L47:
                                s6.w r5 = s6.w.f12711a
                                return r5
                            */
                            throw new UnsupportedOperationException("Method not decompiled: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, w6.c):java.lang.Object");
                        }
                    }

                    @Override // u7.h
                    public Object collect(u7.i iVar, c cVar) {
                        Object objCollect = hVarWindowLayoutInfo.collect(new AnonymousClass2(iVar, foldingFeatureObserver), cVar);
                        return objCollect == x6.a.f13718a ? objCollect : s6.w.f12711a;
                    }
                });
                final FoldingFeatureObserver foldingFeatureObserver2 = FoldingFeatureObserver.this;
                u7.i iVar = new u7.i() { // from class: androidx.slidingpanelayout.widget.FoldingFeatureObserver$registerLayoutStateChangeCallback$1$invokeSuspend$$inlined$collect$1
                    @Override // u7.i
                    public Object emit(FoldingFeature foldingFeature, c cVar) {
                        s6.w wVar;
                        FoldingFeature foldingFeature2 = foldingFeature;
                        FoldingFeatureObserver.OnFoldingFeatureChangeListener onFoldingFeatureChangeListener = foldingFeatureObserver2.onFoldingFeatureChangeListener;
                        s6.w wVar2 = s6.w.f12711a;
                        if (onFoldingFeatureChangeListener == null) {
                            wVar = null;
                        } else {
                            onFoldingFeatureChangeListener.onFoldingFeatureChange(foldingFeature2);
                            wVar = wVar2;
                        }
                        return wVar == x6.a.f13718a ? wVar : wVar2;
                    }
                };
                this.label = 1;
                Object objCollect = hVarG.collect(iVar, this);
                x6.a aVar = x6.a.f13718a;
                if (objCollect == aVar) {
                    return aVar;
                }
            } else {
                if (i10 != 1) {
                    androidx.window.layout.c.g("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                a.e(obj);
            }
            return s6.w.f12711a;
        }
    }

    public FoldingFeatureObserver(WindowInfoTracker windowInfoTracker, Executor executor) {
        windowInfoTracker.getClass();
        executor.getClass();
        this.windowInfoTracker = windowInfoTracker;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FoldingFeature getFoldingFeature(WindowLayoutInfo windowLayoutInfo) {
        Object next;
        Iterator<T> it = windowLayoutInfo.getDisplayFeatures().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((DisplayFeature) next) instanceof FoldingFeature) {
                break;
            }
        }
        if (next instanceof FoldingFeature) {
            return (FoldingFeature) next;
        }
        return null;
    }

    public final void registerLayoutStateChangeCallback(Activity activity) {
        activity.getClass();
        a1 a1Var = this.job;
        if (a1Var != null) {
            a1Var.a(null);
        }
        this.job = y.q(y.a(y.k(this.executor)), null, null, new AnonymousClass1(activity, null), 3);
    }

    public final void setOnFoldingFeatureChangeListener(OnFoldingFeatureChangeListener onFoldingFeatureChangeListener) {
        onFoldingFeatureChangeListener.getClass();
        this.onFoldingFeatureChangeListener = onFoldingFeatureChangeListener;
    }

    public final void unregisterLayoutStateChangeCallback() {
        a1 a1Var = this.job;
        if (a1Var == null) {
            return;
        }
        a1Var.a(null);
    }
}
