package d6;

import com.inmobi.cmp.model.ChoiceError;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final ChoiceError f7454a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ChoiceError choiceError) {
        super(choiceError.getMessage());
        choiceError.getClass();
        this.f7454a = choiceError;
    }
}
