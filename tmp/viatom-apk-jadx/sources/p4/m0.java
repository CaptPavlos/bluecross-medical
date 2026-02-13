package p4;

import android.app.AlertDialog;
import android.app.Application;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.net.Socket;
import java.util.ArrayList;
import l4.a4;
import l4.n5;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class m0 extends f {

    /* renamed from: p, reason: collision with root package name */
    public TextView f11994p;

    /* renamed from: q, reason: collision with root package name */
    public ProgressBar f11995q;

    /* renamed from: r, reason: collision with root package name */
    public AlertDialog f11996r;

    /* renamed from: s, reason: collision with root package name */
    public TextView f11997s;
    public TextView t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f11998u;

    public final void E() {
        View viewInflate = View.inflate(this, R.layout.dialog_sending_file, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_percentage_dialog_sending);
        this.f11994p = textView;
        if (textView != null) {
            textView.setTypeface(o4.b.f11719r);
        }
        ProgressBar progressBar = (ProgressBar) viewInflate.findViewById(R.id.progressbar_dialog_sending);
        this.f11995q = progressBar;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_cancel_dialog_sending);
        this.f11998u = textView2;
        textView2.getClass();
        textView2.setTypeface(o4.b.f11719r);
        TextView textView3 = this.f11998u;
        if (textView3 != null) {
            textView3.setOnClickListener(new k0(this, 2));
        }
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tv_sending_app);
        this.f11997s = textView4;
        if (textView4 != null) {
            textView4.setTypeface(o4.b.f11720s);
        }
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.tv_device_to_sending);
        this.t = textView5;
        if (textView5 != null) {
            textView5.setTypeface(o4.b.f11719r);
        }
        I(viewInflate);
    }

    public final void F() {
        ArrayList arrayList;
        v4.f fVar = o4.b.t;
        Integer numValueOf = (fVar == null || (arrayList = fVar.g) == null) ? null : Integer.valueOf(arrayList.size());
        numValueOf.getClass();
        if (numValueOf.intValue() <= 0) {
            j(getString(R.string.nsd_no_devices_available));
            return;
        }
        a4 a4Var = (a4) this;
        n5 n5Var = new n5(a4Var, 17);
        View viewInflate = View.inflate(this, R.layout.devices_available_nsd, null);
        v4.f fVar2 = o4.b.t;
        fVar2.getClass();
        ArrayList arrayList2 = fVar2.g;
        r4.a aVar = new r4.a();
        aVar.f12372a = arrayList2;
        aVar.f12373b = n5Var;
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.rv_devices);
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), 1, false));
        }
        recyclerView.setAdapter(aVar);
        View viewFindViewById = viewInflate.findViewById(R.id.tv_cancel);
        viewFindViewById.getClass();
        TextView textView = (TextView) viewFindViewById;
        textView.setTypeface(o4.b.f11719r);
        textView.setOnClickListener(new k0(a4Var, 3));
        I(viewInflate);
    }

    public final void G() {
        AlertDialog alertDialog = this.f11996r;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.f11996r = null;
    }

    public final void I(View view) {
        AlertDialog alertDialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view);
        builder.setCancelable(false);
        AlertDialog alertDialogCreate = builder.create();
        this.f11996r = alertDialogCreate;
        Window window = alertDialogCreate != null ? alertDialogCreate.getWindow() : null;
        window.getClass();
        window.setBackgroundDrawable(new ColorDrawable(0));
        if (isFinishing() || (alertDialog = this.f11996r) == null) {
            return;
        }
        alertDialog.show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Socket socket;
        v4.f fVar;
        super.onResume();
        v4.a aVar = o4.b.f11721u;
        if (aVar != null && ((socket = aVar.f13128d) == null || socket.isClosed())) {
            Application application = getApplication();
            application.getClass();
            if (!((o4.b) application).f11728c.get() && (fVar = o4.b.t) != null) {
                fVar.b();
            }
        }
        AlertDialog alertDialog = this.f11996r;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        if (o4.b.f11722v) {
            o4.b.f11722v = false;
            runOnUiThread(new j0(this, 1));
            r0.f.n(null);
            return;
        }
        String str = o4.b.f11723w;
        if (str != null) {
            runOnUiThread(new androidx.work.impl.c(this, str, o4.b.f11724x, 4));
            o4.b.f11723w = null;
            o4.b.f11724x = null;
            return;
        }
        String str2 = o4.b.y;
        if (str2 != null) {
            runOnUiThread(new l0(this, str2, 1));
            o4.b.y = null;
            return;
        }
        String str3 = o4.b.f11725z;
        if (str3 != null) {
            runOnUiThread(new l0(this, str3, 0));
            o4.b.f11725z = null;
        }
    }

    public void H() {
    }
}
