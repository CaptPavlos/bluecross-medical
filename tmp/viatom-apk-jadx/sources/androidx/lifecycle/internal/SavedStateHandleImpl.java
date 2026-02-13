package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.core.os.BundleKt;
import androidx.fragment.app.a;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import s6.i;
import t6.a0;
import t6.b0;
import t6.u;
import u7.c0;
import u7.d0;
import u7.i0;
import u7.k0;
import u7.m0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SavedStateHandleImpl {
    private final Map<String, c0> flows;
    private final Map<String, c0> mutableFlows;
    private final Map<String, SavedStateRegistry.SavedStateProvider> providers;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;

    public SavedStateHandleImpl(Map<String, ? extends Object> map) {
        map.getClass();
        this.regular = new LinkedHashMap(map);
        this.providers = new LinkedHashMap();
        this.flows = new LinkedHashMap();
        this.mutableFlows = new LinkedHashMap();
        this.savedStateProvider = new a(this, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle savedStateProvider$lambda$0(SavedStateHandleImpl savedStateHandleImpl) {
        i[] iVarArr;
        for (Map.Entry entry : a0.l0(savedStateHandleImpl.mutableFlows).entrySet()) {
            savedStateHandleImpl.set((String) entry.getKey(), ((m0) ((c0) entry.getValue())).getValue());
        }
        for (Map.Entry entry2 : a0.l0(savedStateHandleImpl.providers).entrySet()) {
            savedStateHandleImpl.set((String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).saveState());
        }
        Map<String, Object> map = savedStateHandleImpl.regular;
        if (map.isEmpty()) {
            iVarArr = new i[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry<String, Object> entry3 : map.entrySet()) {
                arrayList.add(new i(entry3.getKey(), entry3.getValue()));
            }
            iVarArr = (i[]) arrayList.toArray(new i[0]);
        }
        Bundle bundleBundleOf = BundleKt.bundleOf((i[]) Arrays.copyOf(iVarArr, iVarArr.length));
        SavedStateWriter.m183constructorimpl(bundleBundleOf);
        return bundleBundleOf;
    }

    @MainThread
    public final void clearSavedStateProvider(String str) {
        str.getClass();
        this.providers.remove(str);
    }

    @MainThread
    public final boolean contains(String str) {
        str.getClass();
        return this.regular.containsKey(str);
    }

    @MainThread
    public final <T> T get(String str) {
        T t;
        str.getClass();
        try {
            c0 c0Var = this.mutableFlows.get(str);
            if (c0Var != null && (t = (T) ((m0) c0Var).getValue()) != null) {
                return t;
            }
            return (T) this.regular.get(str);
        } catch (ClassCastException unused) {
            remove(str);
            return null;
        }
    }

    public final Map<String, c0> getMutableFlows() {
        return this.mutableFlows;
    }

    @MainThread
    public final <T> c0 getMutableStateFlow(String str, T t) {
        str.getClass();
        Map<String, c0> map = this.mutableFlows;
        c0 c0VarA = map.get(str);
        if (c0VarA == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t);
            }
            c0VarA = i0.a(this.regular.get(str));
            map.put(str, c0VarA);
        }
        return c0VarA;
    }

    public final Map<String, Object> getRegular() {
        return this.regular;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> k0 getStateFlow(String str, T t) {
        str.getClass();
        Map<String, c0> map = this.flows;
        c0 c0VarA = map.get(str);
        if (c0VarA == null) {
            if (!this.regular.containsKey(str)) {
                this.regular.put(str, t);
            }
            c0VarA = i0.a(this.regular.get(str));
            map.put(str, c0VarA);
        }
        return new d0(c0VarA);
    }

    @MainThread
    public final Set<String> keys() {
        return b0.T(this.regular.keySet(), this.providers.keySet());
    }

    @MainThread
    public final <T> T remove(String str) {
        str.getClass();
        T t = (T) this.regular.remove(str);
        this.flows.remove(str);
        this.mutableFlows.remove(str);
        return t;
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    @MainThread
    public final <T> void set(String str, T t) {
        str.getClass();
        this.regular.put(str, t);
        c0 c0Var = this.flows.get(str);
        if (c0Var != null) {
            ((m0) c0Var).f(t);
        }
        c0 c0Var2 = this.mutableFlows.get(str);
        if (c0Var2 != null) {
            ((m0) c0Var2).f(t);
        }
    }

    @MainThread
    public final void setSavedStateProvider(String str, SavedStateRegistry.SavedStateProvider savedStateProvider) {
        str.getClass();
        savedStateProvider.getClass();
        this.providers.put(str, savedStateProvider);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SavedStateHandleImpl() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ SavedStateHandleImpl(Map map, int i10, g gVar) {
        this((i10 & 1) != 0 ? u.f12809a : map);
    }
}
