package m6;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class b extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11214a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f11215b;

    public /* synthetic */ b(e eVar, int i10) {
        this.f11214a = i10;
        this.f11215b = eVar;
    }

    @Override // android.text.style.ClickableSpan
    public final void onClick(View view) {
        switch (this.f11214a) {
            case 0:
                view.getClass();
                FragmentActivity activity = this.f11215b.getActivity();
                if (activity == null) {
                    return;
                }
                activity.getSupportFragmentManager().beginTransaction().add(new e6.c(), "e0.a").add(new k6.c(), "h0.c").commit();
                return;
            default:
                e eVar = this.f11215b;
                view.getClass();
                try {
                    f fVar = eVar.f11225i;
                    if (fVar == null) {
                        l.i("viewModel");
                        throw null;
                    }
                    if (fVar.h.g.length() > 0) {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        f fVar2 = eVar.f11225i;
                        if (fVar2 == null) {
                            l.i("viewModel");
                            throw null;
                        }
                        intent.setData(Uri.parse(fVar2.h.g));
                        eVar.startActivity(intent);
                        return;
                    }
                    return;
                } catch (ActivityNotFoundException unused) {
                    ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
                    if (callback == null) {
                        return;
                    }
                    callback.onCmpError(ChoiceError.INVALID_URL);
                    return;
                }
        }
    }
}
