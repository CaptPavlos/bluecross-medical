package l4;

import android.view.View;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10670a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f10671b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g7.a f10672c;

    public /* synthetic */ o(w wVar, g7.a aVar) {
        this.f10670a = 1;
        this.f10671b = wVar;
        this.f10672c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f10670a) {
            case 0:
                this.f10672c.invoke();
                this.f10671b.Q();
                break;
            case 1:
                this.f10671b.Q();
                this.f10672c.invoke();
                break;
            case 2:
                this.f10672c.invoke();
                this.f10671b.Q();
                break;
            case 3:
                this.f10672c.invoke();
                this.f10671b.Q();
                break;
            case 4:
                this.f10672c.invoke();
                this.f10671b.Q();
                break;
            default:
                this.f10672c.invoke();
                this.f10671b.Q();
                break;
        }
    }

    public /* synthetic */ o(g7.a aVar, w wVar, int i10) {
        this.f10670a = i10;
        this.f10672c = aVar;
        this.f10671b = wVar;
    }
}
