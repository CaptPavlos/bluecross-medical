package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.google.android.material.internal.ViewUtils;
import q5.l;
import q5.q;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class c implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2345a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2346b;

    public /* synthetic */ c(Object obj, int i10) {
        this.f2345a = i10;
        this.f2346b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z9) {
        switch (this.f2345a) {
            case 0:
                for (EditText editText : (EditText[]) this.f2346b) {
                    if (editText.hasFocus()) {
                        break;
                    }
                }
                ViewUtils.hideKeyboard(view, false);
                break;
            case 1:
                l lVar = (l) this.f2346b;
                view.getClass();
                view.setBackgroundColor(z9 ? lVar.f12268a : lVar.f12269b);
                break;
            default:
                q qVar = (q) this.f2346b;
                view.getClass();
                view.setBackgroundColor(z9 ? qVar.f12278a : qVar.f12279b);
                break;
        }
    }
}
