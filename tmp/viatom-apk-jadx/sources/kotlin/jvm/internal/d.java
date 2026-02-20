package kotlin.jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class d implements m7.b, Serializable {
    public static final Object NO_RECEIVER = c.f10130a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient m7.b reflected;
    private final String signature;

    public d(Object obj, Class cls, String str, String str2, boolean z9) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z9;
    }

    @Override // m7.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // m7.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public m7.b compute() {
        m7.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        m7.b bVarComputeReflected = computeReflected();
        this.reflected = bVarComputeReflected;
        return bVarComputeReflected;
    }

    public abstract m7.b computeReflected();

    @Override // m7.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // m7.b
    public String getName() {
        return this.name;
    }

    public m7.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return y.a(cls);
        }
        y.f10139a.getClass();
        return new p(cls);
    }

    @Override // m7.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public abstract m7.b getReflected();

    @Override // m7.b
    public m7.l getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // m7.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // m7.b
    public m7.m getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // m7.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // m7.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // m7.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // m7.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
