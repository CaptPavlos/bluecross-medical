package l4;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;
import com.uptodown.workers.GenerateQueueWorker;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class w3 extends y6.i implements g7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10945a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10946b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f10947c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f10948d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ a4 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ w3(a4 a4Var, String str, String str2, ArrayList arrayList, boolean z9, w6.c cVar, int i10) {
        super(2, cVar);
        this.f10945a = i10;
        this.f = a4Var;
        this.f10946b = str;
        this.f10947c = str2;
        this.f10948d = arrayList;
        this.e = z9;
    }

    @Override // y6.a
    public final w6.c create(Object obj, w6.c cVar) {
        switch (this.f10945a) {
            case 0:
                return new w3(this.f, this.f10946b, this.f10947c, this.f10948d, this.e, cVar, 0);
            default:
                return new w3((Updates) this.f, this.f10946b, this.f10947c, this.f10948d, this.e, cVar, 1);
        }
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        r7.w wVar = (r7.w) obj;
        w6.c cVar = (w6.c) obj2;
        switch (this.f10945a) {
            case 0:
                w3 w3Var = (w3) create(wVar, cVar);
                s6.w wVar2 = s6.w.f12711a;
                w3Var.invokeSuspend(wVar2);
                return wVar2;
            default:
                w3 w3Var2 = (w3) create(wVar, cVar);
                s6.w wVar3 = s6.w.f12711a;
                w3Var2.invokeSuspend(wVar3);
                return wVar3;
        }
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f10945a) {
            case 0:
                s6.a.e(obj);
                final a4 a4Var = this.f;
                if (!a4Var.isFinishing()) {
                    a4Var.Q();
                    AlertDialog.Builder builder = new AlertDialog.Builder(a4Var);
                    d5.j jVarH = d5.j.h(a4Var.getLayoutInflater());
                    TextView textView = (TextView) jVarH.f7135c;
                    TextView textView2 = (TextView) jVarH.f;
                    TextView textView3 = (TextView) jVarH.f7136d;
                    TextView textView4 = (TextView) jVarH.e;
                    TextView textView5 = (TextView) jVarH.g;
                    t3.h hVar = v5.g.f13148u;
                    Context applicationContext = a4Var.getApplicationContext();
                    applicationContext.getClass();
                    v5.g gVarL = hVar.l(applicationContext);
                    gVarL.a();
                    final String str = this.f10946b;
                    h5.f fVarR = gVarL.r(str);
                    gVarL.b();
                    textView5.setTypeface(o4.b.f11719r);
                    textView5.setText(fVarR != null ? fVarR.f8525b : null);
                    textView4.setTypeface(o4.b.f11720s);
                    textView4.setText(this.f10947c);
                    textView3.setTypeface(o4.b.f11720s);
                    Iterator it = this.f10948d.iterator();
                    it.getClass();
                    String str2 = "";
                    while (it.hasNext()) {
                        Object next = it.next();
                        next.getClass();
                        str2 = str2 + "- " + ((String) next) + '\n';
                    }
                    textView3.setText(str2);
                    textView2.setTypeface(o4.b.f11719r);
                    final int i10 = 0;
                    final boolean z9 = this.e;
                    textView2.setOnClickListener(new View.OnClickListener() { // from class: l4.v3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i11 = i10;
                            String str3 = str;
                            boolean z10 = z9;
                            a4 a4Var2 = a4Var;
                            switch (i11) {
                                case 0:
                                    a4Var2.Q();
                                    float f = UptodownApp.E;
                                    if (!k4.c.o(a4Var2, "GenerateQueueWorker") && !k4.c.o(a4Var2, "downloadApkWorker")) {
                                        a4Var2.L = true;
                                        if (!k4.c.o(a4Var2, "GenerateQueueWorker")) {
                                            WorkManager.Companion.getInstance(a4Var2).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", z10).putString("packagename", str3).build()).build());
                                            break;
                                        }
                                    } else {
                                        String string = a4Var2.getString(R.string.error_download_in_progress_wait);
                                        string.getClass();
                                        a4Var2.N(string);
                                        break;
                                    }
                                    break;
                                default:
                                    Updates updates = (Updates) a4Var2;
                                    updates.Q();
                                    float f10 = UptodownApp.E;
                                    if (!k4.c.o(updates, "GenerateQueueWorker") && !k4.c.o(updates, "downloadApkWorker")) {
                                        updates.L = true;
                                        if (!k4.c.o(updates, "GenerateQueueWorker")) {
                                            WorkManager.Companion.getInstance(updates).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", z10).putString("packagename", str3).build()).build());
                                            break;
                                        }
                                    } else {
                                        String string2 = updates.getString(R.string.error_download_in_progress_wait);
                                        string2.getClass();
                                        updates.N(string2);
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    textView.setTypeface(o4.b.f11719r);
                    textView.setOnClickListener(new r3(a4Var, 7));
                    builder.setCancelable(false);
                    builder.setView((LinearLayout) jVarH.f7134b);
                    a4Var.f10935w = builder.create();
                    if (!a4Var.isFinishing() && a4Var.f10935w != null) {
                        a4Var.j0();
                    }
                }
                break;
            default:
                s6.a.e(obj);
                final Updates updates = (Updates) this.f;
                if (!updates.isFinishing()) {
                    updates.Q();
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(updates);
                    d5.j jVarH2 = d5.j.h(updates.getLayoutInflater());
                    TextView textView6 = (TextView) jVarH2.f7135c;
                    TextView textView7 = (TextView) jVarH2.f;
                    TextView textView8 = (TextView) jVarH2.f7136d;
                    TextView textView9 = (TextView) jVarH2.e;
                    TextView textView10 = (TextView) jVarH2.g;
                    t3.h hVar2 = v5.g.f13148u;
                    Context applicationContext2 = updates.getApplicationContext();
                    applicationContext2.getClass();
                    v5.g gVarL2 = hVar2.l(applicationContext2);
                    gVarL2.a();
                    final String str3 = this.f10946b;
                    h5.f fVarR2 = gVarL2.r(str3);
                    gVarL2.b();
                    textView10.setTypeface(o4.b.f11719r);
                    textView10.setText(fVarR2 != null ? fVarR2.f8525b : null);
                    textView9.setTypeface(o4.b.f11720s);
                    textView9.setText(this.f10947c);
                    textView8.setTypeface(o4.b.f11720s);
                    Iterator it2 = this.f10948d.iterator();
                    it2.getClass();
                    String str4 = "";
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        str4 = str4 + "- " + ((String) next2) + '\n';
                    }
                    textView8.setText(str4);
                    textView7.setTypeface(o4.b.f11719r);
                    final int i11 = 1;
                    final boolean z10 = this.e;
                    textView7.setOnClickListener(new View.OnClickListener() { // from class: l4.v3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i112 = i11;
                            String str32 = str3;
                            boolean z102 = z10;
                            a4 a4Var2 = updates;
                            switch (i112) {
                                case 0:
                                    a4Var2.Q();
                                    float f = UptodownApp.E;
                                    if (!k4.c.o(a4Var2, "GenerateQueueWorker") && !k4.c.o(a4Var2, "downloadApkWorker")) {
                                        a4Var2.L = true;
                                        if (!k4.c.o(a4Var2, "GenerateQueueWorker")) {
                                            WorkManager.Companion.getInstance(a4Var2).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", z102).putString("packagename", str32).build()).build());
                                            break;
                                        }
                                    } else {
                                        String string = a4Var2.getString(R.string.error_download_in_progress_wait);
                                        string.getClass();
                                        a4Var2.N(string);
                                        break;
                                    }
                                    break;
                                default:
                                    Updates updates2 = (Updates) a4Var2;
                                    updates2.Q();
                                    float f10 = UptodownApp.E;
                                    if (!k4.c.o(updates2, "GenerateQueueWorker") && !k4.c.o(updates2, "downloadApkWorker")) {
                                        updates2.L = true;
                                        if (!k4.c.o(updates2, "GenerateQueueWorker")) {
                                            WorkManager.Companion.getInstance(updates2).enqueue(((OneTimeWorkRequest.Builder) com.mbridge.msdk.dycreator.baseview.a.h(GenerateQueueWorker.class, "GenerateQueueWorker")).setInputData(new Data.Builder().putBoolean("downloadAnyway", z102).putString("packagename", str32).build()).build());
                                            break;
                                        }
                                    } else {
                                        String string2 = updates2.getString(R.string.error_download_in_progress_wait);
                                        string2.getClass();
                                        updates2.N(string2);
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                    textView6.setTypeface(o4.b.f11719r);
                    textView6.setOnClickListener(new f5(7, updates, str3));
                    builder2.setCancelable(false);
                    builder2.setView((LinearLayout) jVarH2.f7134b);
                    updates.f10935w = builder2.create();
                    if (!updates.isFinishing() && updates.f10935w != null) {
                        updates.j0();
                    }
                }
                break;
        }
        return s6.w.f12711a;
    }
}
