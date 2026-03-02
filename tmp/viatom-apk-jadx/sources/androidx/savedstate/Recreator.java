package androidx.savedstate;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.savedstate.SavedStateRegistry;
import androidx.window.layout.c;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.g;
import p8.u;
import s6.i;
import t6.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class Recreator implements LifecycleEventObserver {
    public static final String CLASSES_KEY = "classes_to_restore";
    public static final String COMPONENT_KEY = "androidx.savedstate.Restarter";
    public static final Companion Companion = new Companion(null);
    private final SavedStateRegistryOwner owner;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class SavedStateProvider implements SavedStateRegistry.SavedStateProvider {
        private final Set<String> classes;

        public SavedStateProvider(SavedStateRegistry savedStateRegistry) {
            savedStateRegistry.getClass();
            this.classes = new LinkedHashSet();
            savedStateRegistry.registerSavedStateProvider(Recreator.COMPONENT_KEY, this);
        }

        public final void add(String str) {
            str.getClass();
            this.classes.add(str);
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            i[] iVarArr = new i[0];
            Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
            SavedStateWriter.m218putStringListimpl(SavedStateWriter.m183constructorimpl(bundleBundleOf), Recreator.CLASSES_KEY, l.r0(this.classes));
            return bundleBundleOf;
        }
    }

    public Recreator(SavedStateRegistryOwner savedStateRegistryOwner) {
        savedStateRegistryOwner.getClass();
        this.owner = savedStateRegistryOwner;
    }

    private final void reflectiveNew(String str) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.AutoRecreated.class);
            clsAsSubclass.getClass();
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    objNewInstance.getClass();
                    ((SavedStateRegistry.AutoRecreated) objNewInstance).onRecreated(this.owner);
                } catch (Exception e) {
                    a.l(a3.a.i("Failed to instantiate ", str), e);
                }
            } catch (NoSuchMethodException e3) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e3);
            }
        } catch (ClassNotFoundException e7) {
            a.l(androidx.constraintlayout.core.widgets.analyzer.a.x("Class ", str, " wasn't found"), e7);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        lifecycleOwner.getClass();
        event.getClass();
        if (event != Lifecycle.Event.ON_CREATE) {
            u.h("Next event must be ON_CREATE");
            return;
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
        Bundle bundleConsumeRestoredStateForKey = this.owner.getSavedStateRegistry().consumeRestoredStateForKey(COMPONENT_KEY);
        if (bundleConsumeRestoredStateForKey == null) {
            return;
        }
        List<String> listM172getStringListOrNullimpl = SavedStateReader.m172getStringListOrNullimpl(SavedStateReader.m97constructorimpl(bundleConsumeRestoredStateForKey), CLASSES_KEY);
        if (listM172getStringListOrNullimpl == null) {
            c.g("SavedState with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
            return;
        }
        Iterator<String> it = listM172getStringListOrNullimpl.iterator();
        while (it.hasNext()) {
            reflectiveNew(it.next());
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        private Companion() {
        }
    }
}
