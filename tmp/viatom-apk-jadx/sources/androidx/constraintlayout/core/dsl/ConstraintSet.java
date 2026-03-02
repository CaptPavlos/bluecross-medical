package androidx.constraintlayout.core.dsl;

import a3.a;
import java.util.ArrayList;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class ConstraintSet {
    ArrayList<Constraint> mConstraints = new ArrayList<>();
    ArrayList<Helper> mHelpers = new ArrayList<>();
    private final String mName;

    public ConstraintSet(String str) {
        this.mName = str;
    }

    public void add(Constraint constraint) {
        this.mConstraints.add(constraint);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(a.o(new StringBuilder(), this.mName, ":{\n"));
        int i10 = 0;
        if (!this.mConstraints.isEmpty()) {
            ArrayList<Constraint> arrayList = this.mConstraints;
            int size = arrayList.size();
            int i11 = 0;
            while (i11 < size) {
                Constraint constraint = arrayList.get(i11);
                i11++;
                sb.append(constraint.toString());
            }
        }
        if (!this.mHelpers.isEmpty()) {
            ArrayList<Helper> arrayList2 = this.mHelpers;
            int size2 = arrayList2.size();
            while (i10 < size2) {
                Helper helper = arrayList2.get(i10);
                i10++;
                sb.append(helper.toString());
            }
        }
        sb.append("},\n");
        return sb.toString();
    }

    public void add(Helper helper) {
        this.mHelpers.add(helper);
    }
}
