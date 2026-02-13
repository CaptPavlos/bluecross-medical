package l8;

import android.text.Editable;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class c extends b {

    /* renamed from: b, reason: collision with root package name */
    public int f11094b;

    @Override // l8.b
    public final void a(Editable editable) {
        if (editable.length() > 0 && editable.charAt(editable.length() - 1) != '\n') {
            editable.append("\n");
        }
        editable.setSpan(this, editable.length(), editable.length(), 17);
        int i10 = this.f11094b;
        this.f11094b = i10 + 1;
        editable.append((CharSequence) String.valueOf(i10)).append(". ");
    }

    @Override // l8.b
    public final Object[] b(int i10) {
        int i11 = (i10 - 1) * 20;
        if (i10 > 2) {
            i11 -= (i10 - 2) * 20;
        }
        return new Object[]{new LeadingMarginSpan.Standard(i11)};
    }
}
