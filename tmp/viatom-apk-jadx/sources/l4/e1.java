package l4;

import com.uptodown.activities.LanguageSettingsActivity;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class e1 extends y6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f10346a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LanguageSettingsActivity f10347b;

    /* renamed from: c, reason: collision with root package name */
    public int f10348c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(LanguageSettingsActivity languageSettingsActivity, y6.c cVar) {
        super(cVar);
        this.f10347b = languageSettingsActivity;
    }

    @Override // y6.a
    public final Object invokeSuspend(Object obj) {
        this.f10346a = obj;
        this.f10348c |= Integer.MIN_VALUE;
        return LanguageSettingsActivity.n0(this.f10347b, this);
    }
}
