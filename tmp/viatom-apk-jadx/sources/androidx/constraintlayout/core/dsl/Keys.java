package androidx.constraintlayout.core.dsl;

import java.util.Arrays;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Keys {
    public void append(StringBuilder sb, String str, float f) {
        if (Float.isNaN(f)) {
            return;
        }
        sb.append(str);
        sb.append(":");
        sb.append(f);
        sb.append(",\n");
    }

    public String unpack(String[] strArr) {
        StringBuilder sb = new StringBuilder("[");
        int i10 = 0;
        while (i10 < strArr.length) {
            sb.append(i10 == 0 ? "'" : ",'");
            sb.append(strArr[i10]);
            sb.append("'");
            i10++;
        }
        sb.append("]");
        return sb.toString();
    }

    public void append(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(str);
            sb.append(":'");
            sb.append(str2);
            sb.append("',\n");
        }
    }

    public void append(StringBuilder sb, String str, int i10) {
        if (i10 != Integer.MIN_VALUE) {
            sb.append(str);
            sb.append(":'");
            sb.append(i10);
            sb.append("',\n");
        }
    }

    public void append(StringBuilder sb, String str, String[] strArr) {
        if (strArr != null) {
            sb.append(str);
            sb.append(":");
            sb.append(unpack(strArr));
            sb.append(",\n");
        }
    }

    public void append(StringBuilder sb, String str, float[] fArr) {
        if (fArr != null) {
            sb.append(str);
            sb.append("percentWidth:");
            sb.append(Arrays.toString(fArr));
            sb.append(",\n");
        }
    }
}
