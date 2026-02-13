package androidx.leanback.widget;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SinglePresenterSelector extends PresenterSelector {
    private final Presenter mPresenter;

    public SinglePresenterSelector(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter getPresenter(Object obj) {
        return this.mPresenter;
    }

    @Override // androidx.leanback.widget.PresenterSelector
    public Presenter[] getPresenters() {
        return new Presenter[]{this.mPresenter};
    }
}
