package androidx.lifecycle;

import android.app.Application;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {
    private final Application application;

    public AndroidViewModel(Application application) {
        application.getClass();
        this.application = application;
    }

    public <T extends Application> T getApplication() {
        T t = (T) this.application;
        t.getClass();
        return t;
    }
}
