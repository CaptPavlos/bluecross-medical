package j4;

import android.net.Uri;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class l0 {

    /* renamed from: a, reason: collision with root package name */
    public static final StringBuilder f9987a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    public static final z8.l f9988b;

    /* renamed from: c, reason: collision with root package name */
    public static final z8.l f9989c;

    static {
        z8.l lVar = z8.l.f14487d;
        f9988b = r0.f.u("RIFF");
        f9989c = r0.f.u("WEBP");
    }

    public static String a(c0 c0Var, StringBuilder sb) {
        List list = (List) c0Var.f9928i;
        Uri uri = (Uri) c0Var.f9925b;
        if (uri != null) {
            String string = uri.toString();
            sb.ensureCapacity(string.length() + 50);
            sb.append(string);
        } else {
            sb.ensureCapacity(50);
            sb.append(c0Var.f9926c);
        }
        sb.append('\n');
        if (c0Var.b()) {
            sb.append("resize:");
            sb.append(c0Var.f9927d);
            sb.append('x');
            sb.append(c0Var.e);
            sb.append('\n');
        }
        if (c0Var.f) {
            sb.append("centerCrop:");
            sb.append(c0Var.g);
            sb.append('\n');
        }
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                sb.append(((i0) list.get(i10)).key());
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
