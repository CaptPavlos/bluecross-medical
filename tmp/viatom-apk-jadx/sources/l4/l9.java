package l4;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class l9 implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10602a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10603b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10604c;

    public /* synthetic */ l9(Object obj, Context context, int i10) {
        this.f10602a = i10;
        this.f10603b = obj;
        this.f10604c = context;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) throws Resources.NotFoundException {
        int i10 = this.f10602a;
        Context context = this.f10604c;
        Object obj = this.f10603b;
        switch (i10) {
            case 0:
                Updates updates = (Updates) context;
                if (!((kotlin.jvm.internal.u) obj).f10135a) {
                    int i11 = Updates.f6656p0;
                    updates.E0();
                    updates.P0();
                    break;
                }
                break;
            case 1:
                Updates updates2 = (Updates) context;
                if (!((kotlin.jvm.internal.u) obj).f10135a) {
                    int i12 = Updates.f6656p0;
                    updates2.E0();
                    updates2.P0();
                    break;
                }
                break;
            default:
                e5.j0 j0Var = (e5.j0) obj;
                int iIntValue = ((Number) j0Var.G().S.getValue()).intValue();
                h5.e1 e1VarH = h5.c1.h(context);
                if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
                    String str = e1VarH.f8512a;
                    str.getClass();
                    if (str.length() > 0) {
                        com.mbridge.msdk.dycreator.baseview.a.o(iIntValue, j0Var.G().S, null);
                        d5.b bVar = j0Var.f7785b;
                        if (iIntValue == 1) {
                            bVar.getClass();
                            ((ImageView) bVar.f6898x.f).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar2 = j0Var.f7785b;
                            bVar2.getClass();
                            ((ImageView) bVar2.f6898x.g).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar3 = j0Var.f7785b;
                            bVar3.getClass();
                            ((ImageView) bVar3.f6898x.h).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar4 = j0Var.f7785b;
                            bVar4.getClass();
                            ((ImageView) bVar4.f6898x.f7085i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar5 = j0Var.f7785b;
                            bVar5.getClass();
                            ((ImageView) bVar5.f6898x.f7086j).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            break;
                        } else if (iIntValue == 2) {
                            bVar.getClass();
                            ((ImageView) bVar.f6898x.f).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar6 = j0Var.f7785b;
                            bVar6.getClass();
                            ((ImageView) bVar6.f6898x.g).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar7 = j0Var.f7785b;
                            bVar7.getClass();
                            ((ImageView) bVar7.f6898x.h).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar8 = j0Var.f7785b;
                            bVar8.getClass();
                            ((ImageView) bVar8.f6898x.f7085i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar9 = j0Var.f7785b;
                            bVar9.getClass();
                            ((ImageView) bVar9.f6898x.f7086j).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            break;
                        } else if (iIntValue == 3) {
                            bVar.getClass();
                            ((ImageView) bVar.f6898x.f).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar10 = j0Var.f7785b;
                            bVar10.getClass();
                            ((ImageView) bVar10.f6898x.g).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar11 = j0Var.f7785b;
                            bVar11.getClass();
                            ((ImageView) bVar11.f6898x.h).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar12 = j0Var.f7785b;
                            bVar12.getClass();
                            ((ImageView) bVar12.f6898x.f7085i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar13 = j0Var.f7785b;
                            bVar13.getClass();
                            ((ImageView) bVar13.f6898x.f7086j).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            break;
                        } else if (iIntValue == 4) {
                            bVar.getClass();
                            ((ImageView) bVar.f6898x.f).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar14 = j0Var.f7785b;
                            bVar14.getClass();
                            ((ImageView) bVar14.f6898x.g).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar15 = j0Var.f7785b;
                            bVar15.getClass();
                            ((ImageView) bVar15.f6898x.h).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar16 = j0Var.f7785b;
                            bVar16.getClass();
                            ((ImageView) bVar16.f6898x.f7085i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar17 = j0Var.f7785b;
                            bVar17.getClass();
                            ((ImageView) bVar17.f6898x.f7086j).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            break;
                        } else if (iIntValue == 5) {
                            bVar.getClass();
                            ((ImageView) bVar.f6898x.f).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar18 = j0Var.f7785b;
                            bVar18.getClass();
                            ((ImageView) bVar18.f6898x.g).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar19 = j0Var.f7785b;
                            bVar19.getClass();
                            ((ImageView) bVar19.f6898x.h).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar20 = j0Var.f7785b;
                            bVar20.getClass();
                            ((ImageView) bVar20.f6898x.f7085i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            d5.b bVar21 = j0Var.f7785b;
                            bVar21.getClass();
                            ((ImageView) bVar21.f6898x.f7086j).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_on));
                            break;
                        } else {
                            bVar.getClass();
                            ((ImageView) bVar.f6898x.f).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar22 = j0Var.f7785b;
                            bVar22.getClass();
                            ((ImageView) bVar22.f6898x.g).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar23 = j0Var.f7785b;
                            bVar23.getClass();
                            ((ImageView) bVar23.f6898x.h).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar24 = j0Var.f7785b;
                            bVar24.getClass();
                            ((ImageView) bVar24.f6898x.f7085i).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            d5.b bVar25 = j0Var.f7785b;
                            bVar25.getClass();
                            ((ImageView) bVar25.f6898x.f7086j).setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_star_off));
                            break;
                        }
                    }
                }
                break;
        }
    }
}
