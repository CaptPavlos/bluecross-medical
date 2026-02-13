package q5;

import android.content.Context;
import androidx.leanback.widget.ImageCardView;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e extends ImageCardView {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f12260a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, Context context) {
        super(context);
        this.f12260a = fVar;
    }

    @Override // androidx.leanback.widget.BaseCardView, android.view.View
    public void setSelected(boolean z9) {
        this.f12260a.a(this, z9);
        super.setSelected(z9);
    }
}
