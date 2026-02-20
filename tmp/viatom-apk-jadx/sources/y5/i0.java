package y5;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import c1.w4;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.YouTubeActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class i0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13886a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13887b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f13888c;

    public /* synthetic */ i0(int i10, Object obj, Object obj2) {
        this.f13886a = i10;
        this.f13887b = obj;
        this.f13888c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Resources.NotFoundException {
        int i10 = this.f13886a;
        Object obj = this.f13888c;
        Object obj2 = this.f13887b;
        switch (i10) {
            case 0:
                ((j0) obj2).f13895b.z((h5.h) obj);
                break;
            case 1:
                z0 z0Var = (z0) obj2;
                h5.t0 t0Var = (h5.t0) obj;
                view.getClass();
                g5.n nVar = z0Var.f14081b;
                Object tag = view.getTag();
                tag.getClass();
                nVar.B(((Integer) tag).intValue());
                Context context = z0Var.f14080a;
                if (h5.c1.h(context) != null) {
                    new w4(context, 5, false).F(z0Var.f14085j);
                    if (!v5.n.f13172d.contains(Long.valueOf(t0Var.f8739a))) {
                        z0Var.f14084i.setText(String.valueOf(t0Var.f8744j + 1));
                        break;
                    }
                }
                break;
            case 2:
                h5.l1 l1Var = (h5.l1) obj;
                e5.j0 j0Var = (e5.j0) ((c1) obj2).f13831a.f13462b;
                float f = UptodownApp.E;
                if (k4.c.s() && j0Var.getActivity() != null && !j0Var.requireActivity().isFinishing()) {
                    Intent intent = new Intent(j0Var.getActivity(), (Class<?>) YouTubeActivity.class);
                    intent.putExtra("id_youtube", l1Var.f8650a);
                    j0Var.startActivity(intent);
                    break;
                }
                break;
            case 3:
                h5.u0 u0Var = (h5.u0) obj;
                w2.r rVar = ((c1) obj2).f13831a;
                ArrayList<? extends Parcelable> arrayList = (ArrayList) rVar.f13463c;
                e5.j0 j0Var2 = (e5.j0) rVar.f13462b;
                float f10 = UptodownApp.E;
                if (k4.c.s() && j0Var2.getActivity() != null && !j0Var2.requireActivity().isFinishing()) {
                    Intent intent2 = new Intent(j0Var2.requireActivity(), (Class<?>) Gallery.class);
                    Bundle bundle = new Bundle();
                    bundle.putParcelableArrayList("images", arrayList);
                    bundle.putInt("index", arrayList.indexOf(u0Var));
                    intent2.putExtra("bundle", bundle);
                    FragmentActivity fragmentActivityRequireActivity = j0Var2.requireActivity();
                    fragmentActivityRequireActivity.getClass();
                    j0Var2.startActivity(intent2, k4.c.a(fragmentActivityRequireActivity));
                    break;
                }
                break;
            case 4:
                ((j1) obj2).f13904d.b((h5.h) obj);
                break;
            case 5:
                h5.h hVar = (h5.h) obj;
                g5.a aVar = ((k1) obj2).f13926c;
                if (aVar != null) {
                    aVar.b(hVar);
                    break;
                }
                break;
            case 6:
                ((n1) obj2).f13948a.A((h5.x0) obj);
                break;
            case 7:
                n4.u0 u0Var2 = (n4.u0) obj2;
                r1 r1Var = (r1) obj;
                float f11 = UptodownApp.E;
                if (k4.c.s()) {
                    boolean z9 = u0Var2.f11493a.f8540v;
                    g5.p pVar = r1Var.f13985a;
                    if (!z9) {
                        if (pVar != null) {
                            pVar.b(r1Var.getBindingAdapterPosition());
                            break;
                        }
                    } else if (pVar != null) {
                        pVar.f(r1Var.getBindingAdapterPosition());
                        break;
                    }
                }
                break;
            case 8:
                s1 s1Var = (s1) obj2;
                Context context2 = (Context) obj;
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - s1Var.f14012i > s1Var.h) {
                    s1Var.f14012i = jCurrentTimeMillis;
                    context2.getClass();
                    ImageView imageView = s1Var.g;
                    imageView.getClass();
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context2, R.anim.rotate);
                    animationLoadAnimation.setRepeatCount(-1);
                    imageView.startAnimation(animationLoadAnimation);
                    ((SecurityActivity) s1Var.f14008a.f10987b).u0();
                    break;
                }
                break;
            case 9:
                ((d2) obj2).f13841a.A((h5.x0) obj);
                break;
            default:
                l4.w wVar = (l4.w) obj2;
                String str = (String) obj;
                AlertDialog alertDialog = wVar.f10935w;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                v5.c.e(wVar, str, null);
                break;
        }
    }

    public /* synthetic */ i0(f fVar, h5.h hVar, int i10, int i11) {
        this.f13886a = i11;
        this.f13887b = fVar;
        this.f13888c = hVar;
    }
}
