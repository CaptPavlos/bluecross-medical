package l4;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.R;
import com.uptodown.activities.MoreInfo;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class y2 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11016a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MoreInfo f11017b;

    public /* synthetic */ y2(MoreInfo moreInfo, int i10) {
        this.f11016a = i10;
        this.f11017b = moreInfo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f11016a;
        final int i11 = 0;
        w6.c cVar = null;
        final MoreInfo moreInfo = this.f11017b;
        switch (i10) {
            case 0:
                int i12 = MoreInfo.P;
                String string = moreInfo.getString(R.string.dmca_title);
                string.getClass();
                String string2 = moreInfo.getString(R.string.url_dmca);
                string2.getClass();
                v5.c.e(moreInfo, string2, string);
                break;
            case 1:
                int i13 = MoreInfo.P;
                moreInfo.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 2:
                h5.h hVar = moreInfo.K;
                hVar.getClass();
                h5.k kVar = hVar.f8597x;
                kVar.getClass();
                moreInfo.r0(kVar);
                break;
            case 3:
                int i14 = MoreInfo.P;
                if (!moreInfo.isFinishing()) {
                    h5.h hVar2 = moreInfo.K;
                    hVar2.getClass();
                    String str = hVar2.M;
                    str.getClass();
                    v5.c.e(moreInfo, str, null);
                    break;
                }
                break;
            case 4:
                int i15 = MoreInfo.P;
                Object systemService = moreInfo.getSystemService("clipboard");
                systemService.getClass();
                h5.h hVar3 = moreInfo.K;
                hVar3.getClass();
                ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, hVar3.G));
                break;
            case 5:
                int i16 = MoreInfo.P;
                if (moreInfo.q0().f7413i.getVisibility() != 0) {
                    moreInfo.q0().f7413i.setVisibility(0);
                    moreInfo.q0().e.setImageResource(R.drawable.vector_more_info_collapse);
                    moreInfo.q0().C.post(new Runnable() { // from class: l4.z2
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i17 = i11;
                            MoreInfo moreInfo2 = moreInfo;
                            switch (i17) {
                                case 0:
                                    int i18 = MoreInfo.P;
                                    moreInfo2.q0().C.smoothScrollTo(0, moreInfo2.q0().f7438w.getTop());
                                    break;
                                default:
                                    int i19 = MoreInfo.P;
                                    moreInfo2.q0().C.smoothScrollTo(0, moreInfo2.q0().f7429r.getTop());
                                    break;
                            }
                        }
                    });
                    break;
                } else {
                    moreInfo.q0().f7413i.setVisibility(8);
                    moreInfo.q0().e.setImageResource(R.drawable.vector_more_info_expand);
                    break;
                }
            case 6:
                int i17 = MoreInfo.P;
                Object systemService2 = moreInfo.getSystemService("clipboard");
                systemService2.getClass();
                h5.h hVar4 = moreInfo.K;
                hVar4.getClass();
                ((ClipboardManager) systemService2).setPrimaryClip(ClipData.newPlainText(null, hVar4.D));
                break;
            case 7:
                int i18 = MoreInfo.P;
                r7.y.q(LifecycleOwnerKt.getLifecycleScope(moreInfo), null, null, new c3(moreInfo, cVar, 4), 3);
                break;
            default:
                int i19 = MoreInfo.P;
                if (moreInfo.q0().g.getVisibility() != 0) {
                    moreInfo.q0().g.setVisibility(0);
                    moreInfo.q0().f7412d.setImageResource(R.drawable.vector_more_info_collapse);
                    final int i20 = 1;
                    moreInfo.q0().C.post(new Runnable() { // from class: l4.z2
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i172 = i20;
                            MoreInfo moreInfo2 = moreInfo;
                            switch (i172) {
                                case 0:
                                    int i182 = MoreInfo.P;
                                    moreInfo2.q0().C.smoothScrollTo(0, moreInfo2.q0().f7438w.getTop());
                                    break;
                                default:
                                    int i192 = MoreInfo.P;
                                    moreInfo2.q0().C.smoothScrollTo(0, moreInfo2.q0().f7429r.getTop());
                                    break;
                            }
                        }
                    });
                    break;
                } else {
                    moreInfo.q0().g.setVisibility(8);
                    moreInfo.q0().f7412d.setImageResource(R.drawable.vector_more_info_expand);
                    break;
                }
        }
    }
}
