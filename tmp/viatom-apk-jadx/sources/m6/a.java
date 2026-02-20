package m6;

import a3.o;
import android.graphics.Bitmap;
import c6.g;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import g7.l;
import kotlin.jvm.internal.m;
import r7.y;
import s6.w;
import w6.i;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a extends m implements l {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11212a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11213b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(l lVar) {
        super(1);
        this.f11212a = 2;
        this.f11213b = (m) lVar;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [g7.l, kotlin.jvm.internal.m] */
    @Override // g7.l
    public final Object invoke(Object obj) throws Throwable {
        switch (this.f11212a) {
            case 0:
                y.u(i.f13523a, new o((Bitmap) obj, (e) this.f11213b, (w6.c) null, 27));
                break;
            case 1:
                ((g) this.f11213b).invoke((USRegulationData) obj);
                break;
            case 2:
                ((m) this.f11213b).invoke((USRegulationData) obj);
                break;
            default:
                ((a) this.f11213b).invoke((USRegulationData) obj);
                break;
        }
        return w.f12711a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(Object obj, int i10) {
        super(1);
        this.f11212a = i10;
        this.f11213b = obj;
    }
}
