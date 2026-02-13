package kotlin.jvm.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class t extends d implements m7.k {
    private final boolean syntheticJavaProperty;

    public t(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, (i10 & 1) == 1);
        this.syntheticJavaProperty = false;
    }

    @Override // kotlin.jvm.internal.d
    public m7.b compute() {
        return this.syntheticJavaProperty ? this : super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return getOwner().equals(tVar.getOwner()) && getName().equals(tVar.getName()) && getSignature().equals(tVar.getSignature()) && l.a(getBoundReceiver(), tVar.getBoundReceiver());
        }
        if (obj instanceof m7.k) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.d
    public m7.k getReflected() {
        if (this.syntheticJavaProperty) {
            a2.a.m("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
            return null;
        }
        m7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (m7.k) bVarCompute;
        }
        throw new f7.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner().hashCode() * 31)) * 31);
    }

    @Override // m7.k
    public boolean isConst() {
        return getReflected().isConst();
    }

    @Override // m7.k
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        m7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
