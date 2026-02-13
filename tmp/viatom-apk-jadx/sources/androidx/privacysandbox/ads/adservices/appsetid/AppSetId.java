package androidx.privacysandbox.ads.adservices.appsetid;

import com.google.gson.internal.a;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class AppSetId {
    public static final Companion Companion = new Companion(null);
    public static final int SCOPE_APP = 1;
    public static final int SCOPE_DEVELOPER = 2;
    private final String id;
    private final int scope;

    public AppSetId(String str, int i10) {
        str.getClass();
        this.id = str;
        this.scope = i10;
        if (i10 == 1 || i10 == 2) {
            return;
        }
        a.n("Scope undefined.");
        throw null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppSetId)) {
            return false;
        }
        AppSetId appSetId = (AppSetId) obj;
        return l.a(this.id, appSetId.id) && this.scope == appSetId.scope;
    }

    public final String getId() {
        return this.id;
    }

    public final int getScope() {
        return this.scope;
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.scope;
    }

    public String toString() {
        return androidx.constraintlayout.core.widgets.analyzer.a.y(new StringBuilder("AppSetId: id="), this.id, ", scope=", this.scope == 1 ? "SCOPE_APP" : "SCOPE_DEVELOPER");
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
