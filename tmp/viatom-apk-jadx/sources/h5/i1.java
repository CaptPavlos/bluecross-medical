package h5;

import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class i1 {

    /* renamed from: a, reason: collision with root package name */
    public long f8616a;

    /* renamed from: b, reason: collision with root package name */
    public String f8617b;

    /* renamed from: c, reason: collision with root package name */
    public String f8618c;

    /* renamed from: d, reason: collision with root package name */
    public String f8619d;
    public String e;
    public long f;
    public String g;
    public ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public String f8620i;

    public final String a() {
        if (this.f8618c == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8618c);
        float f = UptodownApp.E;
        return a3.a.o(sb, UptodownApp.F, ":webp");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserListItem(programId=");
        sb.append(this.f8616a);
        sb.append(", name=");
        sb.append(this.f8617b);
        sb.append(", icon=");
        sb.append(this.f8618c);
        sb.append(", packagename=");
        return a3.a.m(sb, this.f8619d, ')');
    }
}
