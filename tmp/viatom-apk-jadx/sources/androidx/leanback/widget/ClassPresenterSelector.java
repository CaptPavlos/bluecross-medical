package androidx.leanback.widget;

import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class ClassPresenterSelector extends PresenterSelector {
    private final ArrayList<Presenter> mPresenters = new ArrayList<>();
    private final HashMap<Class<?>, Object> mClassMap = new HashMap<>();

    public ClassPresenterSelector addClassPresenter(Class<?> cls, Presenter presenter) {
        this.mClassMap.put(cls, presenter);
        if (!this.mPresenters.contains(presenter)) {
            this.mPresenters.add(presenter);
        }
        return this;
    }

    public ClassPresenterSelector addClassPresenterSelector(Class<?> cls, PresenterSelector presenterSelector) {
        this.mClassMap.put(cls, presenterSelector);
        Presenter[] presenters = presenterSelector.getPresenters();
        for (int i10 = 0; i10 < presenters.length; i10++) {
            if (!this.mPresenters.contains(presenters[i10])) {
                this.mPresenters.add(presenters[i10]);
            }
        }
        return this;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter getPresenter(Object obj) {
        Object obj2;
        Presenter presenter;
        if (obj == null) {
            return null;
        }
        Class<?> superclass = obj.getClass();
        do {
            obj2 = this.mClassMap.get(superclass);
            if ((obj2 instanceof PresenterSelector) && (presenter = ((PresenterSelector) obj2).getPresenter(obj)) != null) {
                return presenter;
            }
            superclass = superclass.getSuperclass();
            if (obj2 != null) {
                break;
            }
        } while (superclass != null);
        return (Presenter) obj2;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        ArrayList<Presenter> arrayList = this.mPresenters;
        return (Presenter[]) arrayList.toArray(new Presenter[arrayList.size()]);
    }
}
