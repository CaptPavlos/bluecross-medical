package n4;

import android.content.SharedPreferences;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.l5;
import com.uptodown.activities.UserAvatarActivity;
import l4.x4;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11331a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11332b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.ViewHolder f11333c;

    public /* synthetic */ e0(RecyclerView.ViewHolder viewHolder, int i10, int i11) {
        this.f11331a = i11;
        this.f11333c = viewHolder;
        this.f11332b = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SharedPreferences sharedPreferences;
        int i10;
        int i11 = this.f11331a;
        int i12 = this.f11332b;
        RecyclerView.ViewHolder viewHolder = this.f11333c;
        switch (i11) {
            case 0:
                ((f0) viewHolder).f11340c.a(i12);
                break;
            case 1:
                x4 x4Var = ((x0) viewHolder).f11511b;
                x4Var.getClass();
                UserAvatarActivity userAvatarActivity = (UserAvatarActivity) x4Var.f10987b;
                int i13 = UserAvatarActivity.O;
                if (userAvatarActivity.o0().e.getValue() != null) {
                    SharedPreferences sharedPreferences2 = userAvatarActivity.getSharedPreferences("SharedPreferencesUser", 0);
                    try {
                        sharedPreferences = userAvatarActivity.getSharedPreferences("SettingsPreferences", 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String string = sharedPreferences.contains("UTOKEN") ? sharedPreferences.getString("UTOKEN", null) : null;
                    if (string != null || sharedPreferences2.getString("is_turbo", null) != null) {
                        Object value = userAvatarActivity.o0().e.getValue();
                        value.getClass();
                        if (((h5.e1) value).d()) {
                            z0 z0Var = userAvatarActivity.J;
                            if (z0Var == null || z0Var.f != -1) {
                                z0Var.getClass();
                                z0Var.f = -1;
                                z0 z0Var2 = userAvatarActivity.J;
                                z0Var2.getClass();
                                z0Var2.notifyDataSetChanged();
                            }
                            z0 z0Var3 = userAvatarActivity.K;
                            if (z0Var3 != null) {
                                z0Var3.notifyItemChanged(z0Var3.f);
                            }
                            z0 z0Var4 = userAvatarActivity.K;
                            if (z0Var4 != null) {
                                z0Var4.f = i12;
                            }
                            if (z0Var4 != null) {
                                z0Var4.notifyItemChanged(i12);
                                break;
                            }
                        }
                    }
                }
                v5.c.e(userAvatarActivity, l5.A(userAvatarActivity), null);
                break;
            case 2:
                x4 x4Var2 = ((y0) viewHolder).f11518b;
                x4Var2.getClass();
                UserAvatarActivity userAvatarActivity2 = (UserAvatarActivity) x4Var2.f10987b;
                z0 z0Var5 = userAvatarActivity2.K;
                if (z0Var5 != null && (i10 = z0Var5.f) != -1) {
                    z0Var5.notifyItemChanged(i10);
                    z0 z0Var6 = userAvatarActivity2.K;
                    z0Var6.getClass();
                    z0Var6.f = -1;
                    z0 z0Var7 = userAvatarActivity2.K;
                    z0Var7.getClass();
                    z0Var7.notifyItemChanged(i12);
                }
                z0 z0Var8 = userAvatarActivity2.J;
                z0Var8.getClass();
                z0Var8.f = i12;
                z0 z0Var9 = userAvatarActivity2.J;
                z0Var9.getClass();
                z0Var9.notifyDataSetChanged();
                break;
            default:
                ((y5.w0) viewHolder).f14053b.e(i12);
                break;
        }
    }

    public /* synthetic */ e0(RecyclerView.ViewHolder viewHolder, h5.j jVar, int i10, int i11) {
        this.f11331a = i11;
        this.f11333c = viewHolder;
        this.f11332b = i10;
    }
}
