package c0;

import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ d f977b = new d(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f978a;

    public /* synthetic */ d(int i10) {
        this.f978a = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f978a) {
        }
        return ((Scope) obj).f1856b.compareTo(((Scope) obj2).f1856b);
    }
}
