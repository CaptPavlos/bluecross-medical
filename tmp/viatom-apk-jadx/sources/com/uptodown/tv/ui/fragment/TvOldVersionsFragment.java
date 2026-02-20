package com.uptodown.tv.ui.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.a;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import h5.f;
import h5.h;
import h5.q;
import java.util.ArrayList;
import java.util.Arrays;
import k4.c;
import l4.kb;
import q5.p;
import r7.i0;
import r7.y;
import s5.d0;
import s5.w;
import y7.d;
import y7.e;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class TvOldVersionsFragment extends VerticalGridSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public h f6715a;

    /* renamed from: b, reason: collision with root package name */
    public f f6716b;

    /* renamed from: c, reason: collision with root package name */
    public AlertDialog f6717c;

    /* renamed from: d, reason: collision with root package name */
    public w f6718d;

    public static final void a(TvOldVersionsFragment tvOldVersionsFragment, q qVar) {
        Context contextRequireContext = tvOldVersionsFragment.requireContext();
        contextRequireContext.getClass();
        int iQ = qVar.q(contextRequireContext);
        if (iQ < 0) {
            Toast.makeText(tvOldVersionsFragment.getContext(), tvOldVersionsFragment.getString(R.string.error_cant_enqueue_download) + " (108)", 1).show();
            return;
        }
        Context contextRequireContext2 = tvOldVersionsFragment.requireContext();
        contextRequireContext2.getClass();
        float f = UptodownApp.E;
        if (!c.o(contextRequireContext2, "downloadApkWorker")) {
            WorkManager.Companion.getInstance(contextRequireContext2).enqueue(((OneTimeWorkRequest.Builder) a.h(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", iQ).build()).build());
            return;
        }
        Context context = tvOldVersionsFragment.getContext();
        String string = tvOldVersionsFragment.getString(R.string.msg_added_to_downlads_queue);
        string.getClass();
        h hVar = tvOldVersionsFragment.f6715a;
        hVar.getClass();
        Toast.makeText(context, String.format(string, Arrays.copyOf(new Object[]{hVar.f8567b}, 1)), 1).show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
    
        if (r7.y.z(r1, r8, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(com.uptodown.tv.ui.fragment.TvOldVersionsFragment r7, y6.c r8) {
        /*
            boolean r0 = r8 instanceof s5.e0
            if (r0 == 0) goto L13
            r0 = r8
            s5.e0 r0 = (s5.e0) r0
            int r1 = r0.f12625c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f12625c = r1
            goto L18
        L13:
            s5.e0 r0 = new s5.e0
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f12623a
            int r1 = r0.f12625c
            r2 = 0
            r3 = 2
            r4 = 1
            x6.a r5 = x6.a.f13718a
            if (r1 == 0) goto L35
            if (r1 == r4) goto L31
            if (r1 != r3) goto L2b
            s6.a.e(r8)
            goto L5d
        L2b:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            androidx.window.layout.c.g(r7)
            return r2
        L31:
            s6.a.e(r8)
            goto L4b
        L35:
            s6.a.e(r8)
            y7.e r8 = r7.i0.f12407a
            y7.d r8 = y7.d.f14116a
            s5.f0 r1 = new s5.f0
            r6 = 0
            r1.<init>(r7, r2, r6)
            r0.f12625c = r4
            java.lang.Object r8 = r7.y.z(r1, r8, r0)
            if (r8 != r5) goto L4b
            goto L5c
        L4b:
            y7.e r8 = r7.i0.f12407a
            s7.c r8 = w7.n.f13548a
            s5.f0 r1 = new s5.f0
            r1.<init>(r7, r2, r4)
            r0.f12625c = r3
            java.lang.Object r7 = r7.y.z(r1, r8, r0)
            if (r7 != r5) goto L5d
        L5c:
            return r5
        L5d:
            s6.w r7 = s6.w.f12711a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvOldVersionsFragment.b(com.uptodown.tv.ui.fragment.TvOldVersionsFragment, y6.c):java.lang.Object");
    }

    public static final void c(TvOldVersionsFragment tvOldVersionsFragment, ArrayList arrayList) {
        w wVar = tvOldVersionsFragment.f6718d;
        wVar.getClass();
        wVar.clear();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            w wVar2 = tvOldVersionsFragment.f6718d;
            wVar2.getClass();
            wVar2.add(arrayList.get(i10));
        }
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (extras = activity.getIntent().getExtras()) != null) {
            if (extras.containsKey(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                this.f6716b = (f) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP, f.class) : extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP));
            }
            if (extras.containsKey("appInfo")) {
                this.f6715a = (h) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", h.class) : extras.getParcelable("appInfo"));
                Context contextRequireContext = requireContext();
                contextRequireContext.getClass();
                h hVar = this.f6715a;
                hVar.getClass();
                this.f6716b = v5.a.h(contextRequireContext, hVar.f8595w);
            }
        }
        f fVar = this.f6716b;
        if (fVar != null) {
            p pVar = new p();
            pVar.f12276a = fVar.f8526c;
            pVar.f12277b = fVar;
            this.f6718d = new w(pVar);
        } else {
            h hVar2 = this.f6715a;
            if (hVar2 != null) {
                String str = hVar2.f8595w;
                p pVar2 = new p();
                pVar2.f12276a = str;
                this.f6718d = new w(pVar2);
            }
        }
        setAdapter(this.f6718d);
        setTitle(getString(R.string.rollback_title));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new androidx.constraintlayout.helper.widget.a(this, 11), 500L);
        setOnItemViewClickedListener(new d0(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        e eVar = i0.f12407a;
        y.q(y.a(d.f14116a), null, null, new kb(this, (w6.c) null, 10), 3);
    }
}
