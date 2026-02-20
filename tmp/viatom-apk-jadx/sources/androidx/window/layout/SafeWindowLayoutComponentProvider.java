package androidx.window.layout;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.window.extensions.layout.WindowLayoutComponent;
import com.google.android.gms.internal.measurement.a4;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.function.Consumer;
import kotlin.jvm.internal.m;
import s6.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SafeWindowLayoutComponentProvider {
    public static final SafeWindowLayoutComponentProvider INSTANCE = new SafeWindowLayoutComponentProvider();
    private static final f windowLayoutComponent$delegate = s6.a.d(SafeWindowLayoutComponentProvider$windowLayoutComponent$2.INSTANCE);

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isFoldingFeatureValid$1, reason: invalid class name */
    public static final class AnonymousClass1 extends m implements g7.a {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x005a  */
        @Override // g7.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
            /*
                r6 = this;
                androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.INSTANCE
                java.lang.ClassLoader r1 = r6.$classLoader
                java.lang.Class r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$foldingFeatureClass(r0, r1)
                java.lang.String r2 = "getBounds"
                r3 = 0
                java.lang.reflect.Method r2 = r1.getMethod(r2, r3)
                java.lang.String r4 = "getType"
                java.lang.reflect.Method r4 = r1.getMethod(r4, r3)
                java.lang.String r5 = "getState"
                java.lang.reflect.Method r1 = r1.getMethod(r5, r3)
                r2.getClass()
                java.lang.Class<android.graphics.Rect> r3 = android.graphics.Rect.class
                kotlin.jvm.internal.f r3 = kotlin.jvm.internal.y.a(r3)
                boolean r3 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r2, r3)
                if (r3 == 0) goto L5a
                boolean r2 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r2)
                if (r2 == 0) goto L5a
                r4.getClass()
                java.lang.Class r2 = java.lang.Integer.TYPE
                kotlin.jvm.internal.f r3 = kotlin.jvm.internal.y.a(r2)
                boolean r3 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r4, r3)
                if (r3 == 0) goto L5a
                boolean r3 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r4)
                if (r3 == 0) goto L5a
                r1.getClass()
                kotlin.jvm.internal.f r2 = kotlin.jvm.internal.y.a(r2)
                boolean r2 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r1, r2)
                if (r2 == 0) goto L5a
                boolean r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r1)
                if (r0 == 0) goto L5a
                r0 = 1
                goto L5b
            L5a:
                r0 = 0
            L5b:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider.AnonymousClass1.invoke():java.lang.Boolean");
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowExtensionsValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01351 extends m implements g7.a {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01351(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0029  */
        @Override // g7.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke() throws java.lang.NoSuchMethodException, java.lang.SecurityException {
            /*
                r4 = this;
                androidx.window.layout.SafeWindowLayoutComponentProvider r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.INSTANCE
                java.lang.ClassLoader r1 = r4.$classLoader
                java.lang.Class r1 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$windowExtensionsClass(r0, r1)
                java.lang.String r2 = "getWindowLayoutComponent"
                r3 = 0
                java.lang.reflect.Method r1 = r1.getMethod(r2, r3)
                java.lang.ClassLoader r2 = r4.$classLoader
                java.lang.Class r2 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$windowLayoutComponentClass(r0, r2)
                r1.getClass()
                boolean r3 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$isPublic(r0, r1)
                if (r3 == 0) goto L29
                r2.getClass()
                boolean r0 = androidx.window.layout.SafeWindowLayoutComponentProvider.access$doesReturn(r0, r1, r2)
                if (r0 == 0) goto L29
                r0 = 1
                goto L2a
            L29:
                r0 = 0
            L2a:
                java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SafeWindowLayoutComponentProvider.C01351.invoke():java.lang.Boolean");
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutComponentValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01361 extends m implements g7.a {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01361(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        @Override // g7.a
        public final Boolean invoke() throws NoSuchMethodException, SecurityException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            Class clsWindowLayoutComponentClass = safeWindowLayoutComponentProvider.windowLayoutComponentClass(this.$classLoader);
            boolean z9 = false;
            Method method = clsWindowLayoutComponentClass.getMethod("addWindowLayoutInfoListener", Activity.class, Consumer.class);
            Method method2 = clsWindowLayoutComponentClass.getMethod("removeWindowLayoutInfoListener", Consumer.class);
            method.getClass();
            if (safeWindowLayoutComponentProvider.isPublic(method)) {
                method2.getClass();
                if (safeWindowLayoutComponentProvider.isPublic(method2)) {
                    z9 = true;
                }
            }
            return Boolean.valueOf(z9);
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    /* renamed from: androidx.window.layout.SafeWindowLayoutComponentProvider$isWindowLayoutProviderValid$1, reason: invalid class name and case insensitive filesystem */
    public static final class C01371 extends m implements g7.a {
        final /* synthetic */ ClassLoader $classLoader;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01371(ClassLoader classLoader) {
            super(0);
            this.$classLoader = classLoader;
        }

        @Override // g7.a
        public final Boolean invoke() throws NoSuchMethodException, SecurityException {
            SafeWindowLayoutComponentProvider safeWindowLayoutComponentProvider = SafeWindowLayoutComponentProvider.INSTANCE;
            Method declaredMethod = safeWindowLayoutComponentProvider.windowExtensionsProviderClass(this.$classLoader).getDeclaredMethod("getWindowExtensions", null);
            Class clsWindowExtensionsClass = safeWindowLayoutComponentProvider.windowExtensionsClass(this.$classLoader);
            declaredMethod.getClass();
            clsWindowExtensionsClass.getClass();
            return Boolean.valueOf(safeWindowLayoutComponentProvider.doesReturn(declaredMethod, (Class<?>) clsWindowExtensionsClass) && safeWindowLayoutComponentProvider.isPublic(declaredMethod));
        }
    }

    private SafeWindowLayoutComponentProvider() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean canUseWindowLayoutComponent(ClassLoader classLoader) {
        return Build.VERSION.SDK_INT >= 24 && isWindowLayoutProviderValid(classLoader) && isWindowExtensionsValid(classLoader) && isWindowLayoutComponentValid(classLoader) && isFoldingFeatureValid(classLoader);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, m7.c cVar) {
        return doesReturn(method, a4.q(cVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> foldingFeatureClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.FoldingFeature");
    }

    private final boolean isFoldingFeatureValid(ClassLoader classLoader) {
        return validate(new AnonymousClass1(classLoader));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPublic(Method method) {
        return Modifier.isPublic(method.getModifiers());
    }

    private final boolean isWindowExtensionsValid(ClassLoader classLoader) {
        return validate(new C01351(classLoader));
    }

    @RequiresApi(24)
    private final boolean isWindowLayoutComponentValid(ClassLoader classLoader) {
        return validate(new C01361(classLoader));
    }

    private final boolean isWindowLayoutProviderValid(ClassLoader classLoader) {
        return validate(new C01371(classLoader));
    }

    private final boolean validate(g7.a aVar) {
        try {
            return ((Boolean) aVar.invoke()).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensions");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowExtensionsProviderClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.WindowExtensionsProvider");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> windowLayoutComponentClass(ClassLoader classLoader) {
        return classLoader.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
    }

    public final WindowLayoutComponent getWindowLayoutComponent() {
        return (WindowLayoutComponent) windowLayoutComponent$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean doesReturn(Method method, Class<?> cls) {
        return method.getReturnType().equals(cls);
    }
}
