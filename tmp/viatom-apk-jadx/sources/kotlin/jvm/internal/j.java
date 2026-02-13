package kotlin.jvm.internal;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class j extends d implements i, m7.e {
    private final int arity;
    private final int flags;

    public j(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(obj, cls, str, str2, (i11 & 1) == 1);
        this.arity = i10;
        this.flags = 0;
    }

    @Override // kotlin.jvm.internal.d
    public m7.b computeReflected() {
        y.f10139a.getClass();
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            return getName().equals(jVar.getName()) && getSignature().equals(jVar.getSignature()) && this.flags == jVar.flags && this.arity == jVar.arity && l.a(getBoundReceiver(), jVar.getBoundReceiver()) && l.a(getOwner(), jVar.getOwner());
        }
        if (obj instanceof m7.e) {
            return obj.equals(compute());
        }
        return false;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    @Override // kotlin.jvm.internal.d
    public m7.e getReflected() {
        m7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return (m7.e) bVarCompute;
        }
        throw new f7.a("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public int hashCode() {
        return getSignature().hashCode() + ((getName().hashCode() + (getOwner() == null ? 0 : getOwner().hashCode() * 31)) * 31);
    }

    @Override // m7.e
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // m7.e
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override // m7.e
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // m7.e
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // kotlin.jvm.internal.d, m7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        m7.b bVarCompute = compute();
        if (bVarCompute != this) {
            return bVarCompute.toString();
        }
        if ("<init>".equals(getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + getName() + " (Kotlin reflection is not available)";
    }
}
