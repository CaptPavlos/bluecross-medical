package j;

import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import g7.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Locale;
import kotlin.jvm.internal.m;
import s6.i;
import s6.w;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class e extends m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9874a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9875b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Object obj, int i10) {
        super(2);
        this.f9874a = i10;
        this.f9875b = obj;
    }

    @Override // g7.p
    public final Object invoke(Object obj, Object obj2) {
        String lowerCase;
        switch (this.f9874a) {
            case 0:
                int iIntValue = ((Number) obj).intValue();
                boolean zBooleanValue = ((Boolean) obj2).booleanValue();
                ArrayList arrayList = (ArrayList) this.f9875b;
                Integer numValueOf = Integer.valueOf(iIntValue);
                if (zBooleanValue) {
                    lowerCase = GBCConsentValue.GRANTED.getValue().toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                } else {
                    lowerCase = GBCConsentValue.DENIED.getValue().toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                }
                arrayList.add(new i(numValueOf, lowerCase));
                break;
            default:
                int iIntValue2 = ((Number) obj).intValue();
                Boolean bool = (Boolean) obj2;
                bool.getClass();
                ((LinkedHashMap) this.f9875b).put(String.valueOf(iIntValue2), bool);
                break;
        }
        return w.f12711a;
    }
}
