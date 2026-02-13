package l4;

import android.view.View;
import com.uptodown.activities.OrganizationActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class m5 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10623a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OrganizationActivity f10624b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ h5.d0 f10625c;

    public /* synthetic */ m5(h5.d0 d0Var, OrganizationActivity organizationActivity) {
        this.f10623a = 0;
        this.f10625c = d0Var;
        this.f10624b = organizationActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10 = this.f10623a;
        h5.d0 d0Var = this.f10625c;
        OrganizationActivity organizationActivity = this.f10624b;
        switch (i10) {
            case 0:
                int i11 = OrganizationActivity.K;
                String str = d0Var.f8495b;
                if (str != null) {
                    v5.c.e(organizationActivity, str, d0Var.f8494a);
                    break;
                }
                break;
            case 1:
                int i12 = OrganizationActivity.K;
                if (!organizationActivity.isFinishing()) {
                    String str2 = d0Var.f8496c;
                    str2.getClass();
                    v5.c.e(organizationActivity, str2, null);
                    break;
                }
                break;
            case 2:
                int i13 = OrganizationActivity.K;
                if (!organizationActivity.isFinishing()) {
                    String str3 = d0Var.f8497d;
                    str3.getClass();
                    v5.c.e(organizationActivity, str3, null);
                    break;
                }
                break;
            default:
                int i14 = OrganizationActivity.K;
                if (!organizationActivity.isFinishing()) {
                    String str4 = d0Var.e;
                    str4.getClass();
                    v5.c.e(organizationActivity, str4, null);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ m5(OrganizationActivity organizationActivity, h5.d0 d0Var, int i10) {
        this.f10623a = i10;
        this.f10624b = organizationActivity;
        this.f10625c = d0Var;
    }
}
