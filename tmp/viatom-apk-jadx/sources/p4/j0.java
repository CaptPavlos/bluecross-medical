package p4;

import android.net.nsd.NsdServiceInfo;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.uptodown.R;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class j0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11978a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f11979b;

    public /* synthetic */ j0(m0 m0Var, int i10) {
        this.f11978a = i10;
        this.f11979b = m0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        NsdServiceInfo nsdServiceInfo;
        switch (this.f11978a) {
            case 0:
                m0 m0Var = this.f11979b;
                m0Var.E();
                TextView textView2 = m0Var.f11997s;
                if (textView2 != null) {
                    textView2.setText(m0Var.getString(R.string.sending_app_to));
                }
                v4.f fVar = o4.b.t;
                String serviceName = (fVar == null || (nsdServiceInfo = fVar.f) == null) ? null : nsdServiceInfo.getServiceName();
                if (serviceName != null && (textView = m0Var.t) != null) {
                    textView.setText(serviceName.substring(0, o7.m.k0(serviceName, "_d:_", 0, false, 6)));
                }
                ProgressBar progressBar = m0Var.f11995q;
                if (progressBar != null) {
                    progressBar.setIndeterminate(false);
                    break;
                }
                break;
            default:
                m0 m0Var2 = this.f11979b;
                m0Var2.G();
                m0Var2.G();
                View viewInflate = View.inflate(m0Var2, R.layout.dialog_receiving_finished, null);
                View viewFindViewById = viewInflate.findViewById(R.id.tv_receiving_finished);
                viewFindViewById.getClass();
                TextView textView3 = (TextView) viewFindViewById;
                textView3.setTypeface(o4.b.f11719r);
                textView3.setText(m0Var2.getString(R.string.nsd_app_sent_successfully));
                View viewFindViewById2 = viewInflate.findViewById(R.id.tv_install);
                viewFindViewById2.getClass();
                ((TextView) viewFindViewById2).setVisibility(8);
                View viewFindViewById3 = viewInflate.findViewById(R.id.tv_cancel);
                viewFindViewById3.getClass();
                TextView textView4 = (TextView) viewFindViewById3;
                textView4.setTypeface(o4.b.f11719r);
                textView4.setText(m0Var2.getString(android.R.string.ok));
                textView4.setOnClickListener(new k0(m0Var2, 4));
                m0Var2.I(viewInflate);
                break;
        }
    }
}
