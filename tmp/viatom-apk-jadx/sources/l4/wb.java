package l4;

import android.text.Editable;
import android.text.TextWatcher;
import com.uptodown.activities.UsernameEditActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class wb implements TextWatcher {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10973a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UsernameEditActivity f10974b;

    public /* synthetic */ wb(UsernameEditActivity usernameEditActivity, int i10) {
        this.f10973a = i10;
        this.f10974b = usernameEditActivity;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        int i10 = this.f10973a;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f10973a;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f10973a;
        UsernameEditActivity usernameEditActivity = this.f10974b;
        switch (i13) {
            case 0:
                int i14 = UsernameEditActivity.K;
                usernameEditActivity.n0().f7130w.setText(charSequence);
                usernameEditActivity.n0().f7131x.setText(charSequence);
                usernameEditActivity.n0().y.setText(charSequence);
                usernameEditActivity.n0().f7132z.setText(charSequence);
                break;
            default:
                if (charSequence != null) {
                    String string = charSequence.toString();
                    int i15 = UsernameEditActivity.K;
                    usernameEditActivity.o0(string);
                    break;
                }
                break;
        }
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(CharSequence charSequence, int i10, int i11, int i12) {
    }

    private final void d(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
