package c6;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.jvm.internal.l;
import t6.m;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Observer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1778a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l9.a f1779b;

    public /* synthetic */ b(l9.a aVar, int i10) {
        this.f1778a = i10;
        this.f1779b = aVar;
    }

    /* JADX WARN: Type inference failed for: r1v17, types: [java.lang.Object, java.util.Map] */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object obj) {
        TextView textView;
        i6.e eVar;
        int i10 = this.f1778a;
        l9.a aVar = this.f1779b;
        switch (i10) {
            case 0:
                c cVar = (c) aVar;
                cVar.dismiss();
                FragmentActivity activity = cVar.getActivity();
                if (activity == null) {
                    return;
                }
                activity.finish();
                return;
            default:
                i6.d dVar = (i6.d) aVar;
                d9.f fVar = (d9.f) obj;
                i6.e eVar2 = dVar.G;
                if (eVar2 == null) {
                    l.i("viewModel");
                    throw null;
                }
                fVar.getClass();
                ArrayList arrayList = eVar2.f9058d;
                arrayList.clear();
                ArrayList arrayList2 = fVar.f7487a;
                int size = arrayList2.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    d9.h hVar = (d9.h) obj2;
                    String str = hVar.f7508a;
                    String str2 = hVar.f7509b;
                    String strValueOf = String.valueOf(hVar.f7510c);
                    String str3 = hVar.f7511d;
                    ArrayList arrayList3 = hVar.e;
                    int size2 = arrayList3.size();
                    ArrayList arrayList4 = arrayList2;
                    String strG = "";
                    int i12 = 0;
                    int i13 = 0;
                    while (i13 < size2) {
                        Object obj3 = arrayList3.get(i13);
                        int i14 = i13 + 1;
                        int i15 = i12 + 1;
                        if (i12 < 0) {
                            m.U();
                            throw null;
                        }
                        int iIntValue = ((Number) obj3).intValue();
                        k8.c cVar2 = eVar2.f9055a.f8097a;
                        if (cVar2 == null) {
                            eVar = eVar2;
                        } else {
                            eVar = eVar2;
                            k8.f fVar2 = (k8.f) cVar2.f10084d.get(String.valueOf(iIntValue));
                            if (fVar2 != null) {
                                String strG2 = l.g(String.format("• %s.", Arrays.copyOf(new Object[]{fVar2.f10089b}, 1)), strG);
                                strG = i12 != arrayList3.size() + (-1) ? l.g("\n", strG2) : strG2;
                            }
                        }
                        i12 = i15;
                        i13 = i14;
                        eVar2 = eVar;
                    }
                    arrayList.add(new l9.f(str, str2, strValueOf, str3, strG));
                    arrayList2 = arrayList4;
                }
                i6.e eVar3 = dVar.G;
                if (eVar3 == null) {
                    l.i("viewModel");
                    throw null;
                }
                if (eVar3.f9058d.isEmpty()) {
                    TextView textView2 = dVar.D;
                    if (textView2 != null) {
                        i6.b bVar = dVar.F;
                        if (bVar == null) {
                            l.i("args");
                            throw null;
                        }
                        textView2.setText(bVar.f9040p);
                    }
                    Context context = dVar.getContext();
                    if (context == null || (textView = dVar.D) == null) {
                        return;
                    }
                    textView.setTextColor(ContextCompat.getColor(context, R.color.colorRed));
                    return;
                }
                FragmentActivity activity2 = dVar.getActivity();
                if (activity2 != null && activity2.getSupportFragmentManager().findFragmentByTag(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D) == null) {
                    FragmentTransaction fragmentTransactionBeginTransaction = activity2.getSupportFragmentManager().beginTransaction();
                    i6.e eVar4 = dVar.G;
                    if (eVar4 == null) {
                        l.i("viewModel");
                        throw null;
                    }
                    g6.b bVar2 = new g6.b(eVar4.f9058d);
                    g6.d dVar2 = new g6.d();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("partner_disclosure_args", bVar2);
                    dVar2.setArguments(bundle);
                    fragmentTransactionBeginTransaction.add(dVar2, DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_D).commit();
                    return;
                }
                return;
        }
    }
}
