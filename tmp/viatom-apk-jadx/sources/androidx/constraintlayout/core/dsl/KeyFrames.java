package androidx.constraintlayout.core.dsl;

import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class KeyFrames {
    ArrayList<Keys> mKeys = new ArrayList<>();

    public void add(Keys keys) {
        this.mKeys.add(keys);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.mKeys.isEmpty()) {
            sb.append("keyFrames:{\n");
            ArrayList<Keys> arrayList = this.mKeys;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Keys keys = arrayList.get(i10);
                i10++;
                sb.append(keys.toString());
            }
            sb.append("},\n");
        }
        return sb.toString();
    }
}
