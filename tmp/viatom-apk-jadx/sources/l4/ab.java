package l4;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.activities.UserDeviceDetailsActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class ab implements u7.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10230a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserDeviceDetailsActivity f10231b;

    public /* synthetic */ ab(UserDeviceDetailsActivity userDeviceDetailsActivity, int i10) {
        this.f10230a = i10;
        this.f10231b = userDeviceDetailsActivity;
    }

    @Override // u7.i
    public final Object emit(Object obj, w6.c cVar) throws Resources.NotFoundException {
        int i10 = this.f10230a;
        s6.w wVar = s6.w.f12711a;
        v5.k kVar = v5.k.f13167a;
        v5.j jVar = v5.j.f13166a;
        final UserDeviceDetailsActivity userDeviceDetailsActivity = this.f10231b;
        switch (i10) {
            case 0:
                v5.m mVar = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar, jVar)) {
                    if (!(mVar instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        final h5.h1 h1Var = ((eb) ((v5.l) mVar).f13168a).f10371a;
                        int i11 = UserDeviceDetailsActivity.N;
                        userDeviceDetailsActivity.n0().f7028o.setText(h1Var.f8607c);
                        userDeviceDetailsActivity.n0().f7026m.setText(h1Var.f8608d);
                        userDeviceDetailsActivity.n0().f7032s.setText(h1Var.e);
                        if (h1Var.f8609i > 0) {
                            userDeviceDetailsActivity.n0().f7021d.setImageDrawable(ContextCompat.getDrawable(userDeviceDetailsActivity, R.drawable.vector_unchecked));
                        } else {
                            userDeviceDetailsActivity.n0().f7021d.setImageDrawable(ContextCompat.getDrawable(userDeviceDetailsActivity, R.drawable.vector_checked));
                        }
                        userDeviceDetailsActivity.n0().f7022i.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: l4.xa
                            @Override // android.widget.RadioGroup.OnCheckedChangeListener
                            public final void onCheckedChanged(RadioGroup radioGroup, int i12) {
                                h5.h1 h1Var2 = h1Var;
                                ArrayList arrayList = h1Var2.f8611k;
                                ArrayList arrayList2 = h1Var2.f8610j;
                                int i13 = UserDeviceDetailsActivity.N;
                                UserDeviceDetailsActivity userDeviceDetailsActivity2 = userDeviceDetailsActivity;
                                if (i12 == userDeviceDetailsActivity2.n0().g.getId()) {
                                    if (((Boolean) userDeviceDetailsActivity2.o0().h.getValue()).booleanValue()) {
                                        if (arrayList2.size() > 1) {
                                            t6.q.W(arrayList2, new a9.i(15));
                                        }
                                    } else if (arrayList2.size() > 1) {
                                        t6.q.W(arrayList2, new a9.i(13));
                                    }
                                    n4.b1 b1Var = userDeviceDetailsActivity2.J;
                                    if (b1Var != null) {
                                        arrayList2.getClass();
                                        b1Var.f11307a = arrayList2;
                                        b1Var.notifyDataSetChanged();
                                    }
                                    RadioButton radioButton = userDeviceDetailsActivity2.n0().g;
                                    radioButton.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, R.drawable.ripple_checkbox_selected_button));
                                    radioButton.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(userDeviceDetailsActivity2, R.drawable.vector_check_blue), (Drawable) null, (Drawable) null, (Drawable) null);
                                    RadioButton radioButton2 = userDeviceDetailsActivity2.n0().h;
                                    radioButton2.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, R.drawable.core_ripple_bg_card));
                                    radioButton2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                } else if (i12 == userDeviceDetailsActivity2.n0().h.getId()) {
                                    if (((Boolean) userDeviceDetailsActivity2.o0().h.getValue()).booleanValue()) {
                                        if (arrayList.size() > 1) {
                                            t6.q.W(arrayList, new a9.i(16));
                                        }
                                    } else if (arrayList.size() > 1) {
                                        t6.q.W(arrayList, new a9.i(14));
                                    }
                                    n4.b1 b1Var2 = userDeviceDetailsActivity2.J;
                                    if (b1Var2 != null) {
                                        arrayList.getClass();
                                        b1Var2.f11307a = arrayList;
                                        b1Var2.notifyDataSetChanged();
                                    }
                                    RadioButton radioButton3 = userDeviceDetailsActivity2.n0().h;
                                    radioButton3.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, R.drawable.ripple_checkbox_selected_button));
                                    radioButton3.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(userDeviceDetailsActivity2, R.drawable.vector_check_blue), (Drawable) null, (Drawable) null, (Drawable) null);
                                    RadioButton radioButton4 = userDeviceDetailsActivity2.n0().g;
                                    radioButton4.setBackground(ContextCompat.getDrawable(userDeviceDetailsActivity2, R.drawable.core_ripple_bg_card));
                                    radioButton4.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
                                }
                                userDeviceDetailsActivity2.n0().f7023j.smoothScrollToPosition(0);
                            }
                        });
                        userDeviceDetailsActivity.J = new n4.b1(h1Var.f8610j, userDeviceDetailsActivity.K);
                        userDeviceDetailsActivity.n0().f7023j.setAdapter(userDeviceDetailsActivity.J);
                        userDeviceDetailsActivity.n0().f.setVisibility(8);
                        userDeviceDetailsActivity.n0().e.setVisibility(0);
                        break;
                    }
                } else {
                    userDeviceDetailsActivity.n0().f.setVisibility(0);
                    break;
                }
                break;
            case 1:
                v5.m mVar2 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar2, jVar)) {
                    if (!(mVar2 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar2, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        fb fbVar = (fb) ((v5.l) mVar2).f13168a;
                        String str = fbVar.f10408b;
                        if (str != null && str.length() != 0) {
                            userDeviceDetailsActivity.C(fbVar.f10408b);
                        }
                        if (fbVar.f10407a == 1) {
                            userDeviceDetailsActivity.n0().f7028o.setText(fbVar.f10410d);
                            userDeviceDetailsActivity.setResult(3);
                            break;
                        }
                    }
                }
                break;
            default:
                v5.m mVar3 = (v5.m) obj;
                if (!kotlin.jvm.internal.l.a(mVar3, jVar)) {
                    if (!(mVar3 instanceof v5.l)) {
                        if (!kotlin.jvm.internal.l.a(mVar3, kVar)) {
                            androidx.window.layout.c.b();
                            break;
                        }
                    } else {
                        gb gbVar = (gb) ((v5.l) mVar3).f13168a;
                        String str2 = gbVar.f10440b;
                        if (str2 != null && str2.length() != 0) {
                            userDeviceDetailsActivity.C(gbVar.f10440b);
                        }
                        if (gbVar.f10439a == 1) {
                            b bVar = userDeviceDetailsActivity.L;
                            String string = Settings.Secure.getString(userDeviceDetailsActivity.getContentResolver(), "android_id");
                            h5.e1 e1VarH = h5.c1.h(userDeviceDetailsActivity);
                            if ((e1VarH != null ? e1VarH.f8512a : null) != null) {
                                String str3 = e1VarH.f8512a;
                            }
                            try {
                                SharedPreferences sharedPreferences = userDeviceDetailsActivity.getSharedPreferences("CoreSettings", 0);
                                if (sharedPreferences.contains("device_rooted")) {
                                    sharedPreferences.getBoolean("device_rooted", false);
                                }
                            } catch (Exception unused) {
                            }
                            if (!kotlin.jvm.internal.l.a(gbVar.f10441c, string)) {
                                userDeviceDetailsActivity.setResult(4);
                                bVar.handleOnBackPressed();
                                break;
                            } else {
                                userDeviceDetailsActivity.setResult(5);
                                bVar.handleOnBackPressed();
                                break;
                            }
                        }
                    }
                }
                break;
        }
        return null;
    }
}
