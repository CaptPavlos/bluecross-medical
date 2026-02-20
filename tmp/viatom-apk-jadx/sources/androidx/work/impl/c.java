package androidx.work.impl;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.work.WorkerParameters;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.uptodown.R;
import com.uptodown.activities.UserDeviceDetailsActivity;
import h5.h1;
import java.util.ArrayList;
import l4.f5;
import o7.u;
import p4.k0;
import p4.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f683a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f684b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f685c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f686d;

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i10) {
        this.f683a = i10;
        this.f684b = obj;
        this.f685c = obj2;
        this.f686d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        int i10 = this.f683a;
        Object obj = this.f686d;
        Object obj2 = this.f685c;
        Object obj3 = this.f684b;
        switch (i10) {
            case 0:
                ((Processor) obj3).lambda$startWork$1((k1.b) obj2, (WorkerWrapper) obj);
                return;
            case 1:
                WorkLauncherImpl.startWork$lambda$0((WorkLauncherImpl) obj3, (StartStopToken) obj2, (WorkerParameters.RuntimeExtras) obj);
                return;
            case 2:
                ((i4.f) obj3).loadUrl("javascript:" + ((String) obj2) + '(' + t6.l.h0((ArrayList) obj, ",", null, null, null, 62) + ')');
                return;
            case 3:
                h1 h1Var = (h1) obj3;
                EditText editText = (EditText) ((a4.f) obj2).f219c;
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj;
                int i11 = UserDeviceDetailsActivity.N;
                String str = h1Var.f8607c;
                if (str != null && str.length() != 0) {
                    editText.requestFocus();
                    editText.setText(h1Var.f8607c);
                    editText.selectAll();
                }
                userDeviceDetailsActivity.showKeyboard(editText);
                return;
            case 4:
                m0 m0Var = (m0) obj3;
                String str2 = (String) obj2;
                String str3 = (String) obj;
                m0Var.G();
                str2.getClass();
                if (!u.X(str2, ".apk", true) && !u.X(str2, ".xapk", true) && !u.X(str2, ".apks", true) && !u.X(str2, ".apkm", true)) {
                    m0Var.j(m0Var.getString(R.string.msg_file_received) + str2 + ' ' + str3);
                    return;
                }
                m0Var.G();
                View viewInflate = View.inflate(m0Var, R.layout.dialog_receiving_finished, null);
                View viewFindViewById = viewInflate.findViewById(R.id.tv_receiving_finished);
                viewFindViewById.getClass();
                TextView textView = (TextView) viewFindViewById;
                textView.setTypeface(o4.b.f11719r);
                textView.setText(str2);
                View viewFindViewById2 = viewInflate.findViewById(R.id.tv_install);
                viewFindViewById2.getClass();
                TextView textView2 = (TextView) viewFindViewById2;
                textView2.setTypeface(o4.b.f11719r);
                textView2.setOnClickListener(new f5(20, m0Var, str2));
                View viewFindViewById3 = viewInflate.findViewById(R.id.tv_cancel);
                viewFindViewById3.getClass();
                TextView textView3 = (TextView) viewFindViewById3;
                textView3.setTypeface(o4.b.f11719r);
                textView3.setText(m0Var.getString(android.R.string.ok));
                textView3.setOnClickListener(new k0(m0Var, 0));
                m0Var.I(viewInflate);
                return;
            default:
                h1.i iVar = (h1.i) obj;
                try {
                    ((FirebaseMessagingService) obj3).b((Intent) obj2);
                    return;
                } finally {
                    iVar.a(null);
                }
        }
    }
}
