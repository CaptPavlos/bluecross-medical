package androidx.constraintlayout.helper.widget;

import a3.z0;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.room.RoomTrackingLiveData;
import androidx.work.ListenableFutureKt;
import c1.g1;
import c2.d;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.uptodown.R;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.tv.ui.fragment.TvMyAppsFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.l;
import l4.d7;
import l4.ic;
import r7.a1;
import w2.b0;
import w2.r;
import x.c;
import y1.e;
import y1.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f463b;

    public /* synthetic */ a(Object obj, int i10) {
        this.f462a = i10;
        this.f463b = obj;
    }

    private final void a() {
        g1 g1Var = (g1) this.f463b;
        Map mapA = null;
        ((AtomicReference) g1Var.f1231c).set(null);
        synchronized (g1Var) {
            try {
                if (((AtomicMarkableReference) g1Var.f1230b).isMarked()) {
                    mapA = ((e) ((AtomicMarkableReference) g1Var.f1230b).getReference()).a();
                    AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) g1Var.f1230b;
                    atomicMarkableReference.set((e) atomicMarkableReference.getReference(), false);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (mapA != null) {
            d dVar = (d) g1Var.f1232d;
            ((h) dVar.f1642c).h((String) dVar.f1641b, mapA, g1Var.f1229a);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = 2;
        int i11 = 1;
        switch (this.f462a) {
            case 0:
                ((Carousel) this.f463b).lambda$updateItems$0();
                return;
            case 1:
                RoomTrackingLiveData.access$invalidated((RoomTrackingLiveData) this.f463b);
                return;
            case 2:
                ListenableFutureKt.launchFuture$lambda$1$lambda$0((a1) this.f463b);
                return;
            case 3:
                ((MaterialButton) this.f463b).lambda$setOpticalCenterEnabled$1();
                return;
            case 4:
                ((CarouselLayoutManager) this.f463b).refreshKeylineState();
                return;
            case 5:
                ((MaterialBackOrchestrator) this.f463b).startListeningForBackCallbacksWithPriorityOverlay();
                return;
            case 6:
                AppInstalledDetailsActivity appInstalledDetailsActivity = (AppInstalledDetailsActivity) this.f463b;
                int i12 = AppInstalledDetailsActivity.Y;
                appInstalledDetailsActivity.F0().f7011w.smoothScrollTo(0, appInstalledDetailsActivity.F0().f7000o.getTop());
                return;
            case 7:
                RecommendedActivity recommendedActivity = (RecommendedActivity) this.f463b;
                int i13 = RecommendedActivity.Z;
                String string = recommendedActivity.getString(R.string.recommended_login_msg);
                string.getClass();
                recommendedActivity.L(string, new d7(recommendedActivity, i11), new d7(recommendedActivity, i10));
                return;
            case 8:
                WishlistActivity wishlistActivity = (WishlistActivity) this.f463b;
                int i14 = WishlistActivity.Z;
                String string2 = wishlistActivity.getString(R.string.wishlist_login_msg);
                string2.getClass();
                wishlistActivity.L(string2, new ic(wishlistActivity, i11), new ic(wishlistActivity, i10));
                return;
            case 9:
                FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) this.f463b;
                HorizontalScrollView horizontalScrollView = fileExplorerActivity.A;
                if (horizontalScrollView == null) {
                    l.i("svBreadcrumb");
                    throw null;
                }
                LinearLayout linearLayout = fileExplorerActivity.f6675z;
                if (linearLayout == null) {
                    l.i("llBreadcrumb");
                    throw null;
                }
                int right = linearLayout.getRight();
                LinearLayout linearLayout2 = fileExplorerActivity.f6675z;
                if (linearLayout2 != null) {
                    horizontalScrollView.scrollTo(right, linearLayout2.getTop());
                    return;
                } else {
                    l.i("llBreadcrumb");
                    throw null;
                }
            case 10:
                ((TvMyAppsFragment) this.f463b).startEntranceTransition();
                return;
            case 11:
                ((TvOldVersionsFragment) this.f463b).startEntranceTransition();
                return;
            case 12:
                r rVar = (r) this.f463b;
                ((w.h) ((c) rVar.e)).h(new v.e(rVar, 3));
                return;
            case 13:
                z0 z0Var = (z0) this.f463b;
                synchronized (((ArrayDeque) z0Var.f198d)) {
                    SharedPreferences.Editor editorEdit = ((SharedPreferences) z0Var.f).edit();
                    String str = (String) z0Var.f196b;
                    StringBuilder sb = new StringBuilder();
                    Iterator it = ((ArrayDeque) z0Var.f198d).iterator();
                    while (it.hasNext()) {
                        sb.append((String) it.next());
                        sb.append((String) z0Var.f197c);
                    }
                    editorEdit.putString(str, sb.toString()).commit();
                }
                return;
            case 14:
                b0 b0Var = (b0) this.f463b;
                Log.w("FirebaseMessaging", "Service took too long to process intent: " + b0Var.f13424a.getAction() + " finishing.");
                b0Var.f13425b.c(null);
                return;
            case 15:
                a();
                return;
            default:
                ((AppCompatTextView) this.f463b).setSelected(true);
                return;
        }
    }
}
