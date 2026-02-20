package e5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.PublicProfileActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c0 implements g5.z, g5.i, t4.b, BannerAdListener, g5.q, g5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7693a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j0 f7694b;

    public /* synthetic */ c0(j0 j0Var, int i10) {
        this.f7693a = i10;
        this.f7694b = j0Var;
    }

    @Override // g5.a
    public void b(h5.h hVar) {
        switch (this.f7693a) {
            case 6:
                hVar.getClass();
                break;
            case 7:
                hVar.getClass();
                break;
            default:
                hVar.getClass();
                break;
        }
    }

    @Override // g5.a
    public void c(h5.h hVar) {
        int i10 = this.f7693a;
        hVar.getClass();
        switch (i10) {
            case 6:
                j0.n(this.f7694b, hVar);
                break;
            case 7:
                j0.n(this.f7694b, hVar);
                break;
            default:
                j0.n(this.f7694b, hVar);
                break;
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void closeFullScreen(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
    }

    @Override // g5.i
    public void f(int i10) {
        if (i10 == 404) {
            u7.m0 m0Var = this.f7694b.G().K;
            Boolean bool = Boolean.TRUE;
            m0Var.getClass();
            m0Var.g(null, bool);
        }
    }

    @Override // t4.b
    public void i() {
        j0 j0Var = this.f7694b;
        String string = j0Var.getString(R.string.installing);
        string.getClass();
        j0.j(j0Var, string);
    }

    @Override // t4.b
    public void k(String str) {
        j0 j0Var = this.f7694b;
        if (str != null) {
            j0Var.x(str);
            return;
        }
        String string = j0Var.getString(R.string.error_generico);
        string.getClass();
        j0Var.x(string);
    }

    @Override // g5.i
    public void l(h5.h hVar) {
        j0 j0Var = this.f7694b;
        j0Var.f7784a = hVar;
        j0Var.W();
        j0Var.r();
    }

    @Override // g5.z
    public void m(h5.o0 o0Var) {
        switch (this.f7693a) {
            case 0:
                j0 j0Var = this.f7694b;
                if (j0Var.getActivity() != null && (j0Var.getActivity() instanceof l4.w) && !j0Var.requireActivity().isFinishing()) {
                    j0Var.D().Q = o0Var;
                    if (o0Var.f8677c <= 0) {
                        j0Var.A();
                        break;
                    } else {
                        FragmentActivity activity = j0Var.getActivity();
                        activity.getClass();
                        ((l4.w) activity).P(j0Var.D(), new u(j0Var, 2), new u(j0Var, 3));
                        break;
                    }
                }
                break;
            default:
                j0 j0Var2 = this.f7694b;
                j0Var2.D().Q = o0Var;
                if (j0Var2.getActivity() != null && !j0Var2.requireActivity().isFinishing() && o0Var.f8677c > 0) {
                    d5.b bVar = j0Var2.f7785b;
                    bVar.getClass();
                    ((ImageView) bVar.G.f7059n).setImageResource(R.drawable.vector_shield_vt_positive);
                    d5.b bVar2 = j0Var2.f7785b;
                    bVar2.getClass();
                    ((ImageView) bVar2.G.f7059n).setBackgroundResource(R.drawable.ripple_virus_report_positive);
                    break;
                }
                break;
        }
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onClick(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "clicked");
        new t1.c(this.f7694b.getContext(), 4).e(bundle, "mintegral_banner");
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onCloseBanner(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "closed");
        new t1.c(this.f7694b.getContext(), 4).e(bundle, "mintegral_banner");
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLeaveApp(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
        mBridgeIds.getClass();
        str.getClass();
        j0 j0Var = this.f7694b;
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.y.setVisibility(8);
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        bVar2.f6900y0.setVisibility(8);
        d5.b bVar3 = j0Var.f7785b;
        bVar3.getClass();
        bVar3.y.release();
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed");
        new t1.c(j0Var.getContext(), 4).e(bundle, "mintegral_banner");
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLoadSuccessed(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
        j0 j0Var = this.f7694b;
        d5.b bVar = j0Var.f7785b;
        bVar.getClass();
        bVar.f6900y0.setTypeface(o4.b.f11720s);
        d5.b bVar2 = j0Var.f7785b;
        bVar2.getClass();
        bVar2.f6900y0.setVisibility(0);
        d5.b bVar3 = j0Var.f7785b;
        bVar3.getClass();
        bVar3.f6900y0.setOnClickListener(new r(j0Var, 23));
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "loaded");
        new t1.c(j0Var.getContext(), 4).e(bundle, "mintegral_banner");
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void onLogImpression(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
    }

    @Override // g5.z
    public void q() {
        switch (this.f7693a) {
            case 0:
                this.f7694b.A();
                break;
            default:
                j0 j0Var = this.f7694b;
                if (j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                    d5.b bVar = j0Var.f7785b;
                    bVar.getClass();
                    ((ImageView) bVar.G.f7059n).setImageResource(R.drawable.vector_shield_vt_not_available);
                    d5.b bVar2 = j0Var.f7785b;
                    bVar2.getClass();
                    ((ImageView) bVar2.G.f7059n).setBackgroundResource(R.drawable.ripple_virus_report_not_available);
                    break;
                }
                break;
        }
    }

    @Override // g5.q
    public void r(h5.e1 e1Var) {
        j0 j0Var = this.f7694b;
        Intent intent = new Intent(j0Var.requireContext(), (Class<?>) PublicProfileActivity.class);
        intent.putExtra("user", e1Var);
        float f = UptodownApp.E;
        FragmentActivity fragmentActivityRequireActivity = j0Var.requireActivity();
        fragmentActivityRequireActivity.getClass();
        j0Var.startActivity(intent, k4.c.a(fragmentActivityRequireActivity));
    }

    @Override // com.mbridge.msdk.out.BannerAdListener
    public void showFullScreen(MBridgeIds mBridgeIds) {
        mBridgeIds.getClass();
    }

    @Override // g5.q
    public void F() {
    }
}
