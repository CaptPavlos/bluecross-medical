package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.constraintlayout.core.widgets.analyzer.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
@ExperimentalFeatures.RegisterSourceOptIn
/* loaded from: classes.dex */
public final class SourceRegistrationRequest {
    private final InputEvent inputEvent;
    private final List<Uri> registrationUris;

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Builder {
        private InputEvent inputEvent;
        private final List<Uri> registrationUris;

        /* JADX WARN: Multi-variable type inference failed */
        public Builder(List<? extends Uri> list) {
            list.getClass();
            this.registrationUris = list;
        }

        public final SourceRegistrationRequest build() {
            return new SourceRegistrationRequest(this.registrationUris, this.inputEvent);
        }

        public final Builder setInputEvent(InputEvent inputEvent) {
            inputEvent.getClass();
            this.inputEvent = inputEvent;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SourceRegistrationRequest(List<? extends Uri> list, InputEvent inputEvent) {
        list.getClass();
        this.registrationUris = list;
        this.inputEvent = inputEvent;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) obj;
        return l.a(this.registrationUris, sourceRegistrationRequest.registrationUris) && l.a(this.inputEvent, sourceRegistrationRequest.inputEvent);
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final List<Uri> getRegistrationUris() {
        return this.registrationUris;
    }

    public int hashCode() {
        int iHashCode = this.registrationUris.hashCode();
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent == null) {
            return iHashCode;
        }
        return inputEvent.hashCode() + (iHashCode * 31);
    }

    public String toString() {
        return a.x("AppSourcesRegistrationRequest { ", "RegistrationUris=[" + this.registrationUris + "], InputEvent=" + this.inputEvent, " }");
    }

    public /* synthetic */ SourceRegistrationRequest(List list, InputEvent inputEvent, int i10, g gVar) {
        this(list, (i10 & 2) != 0 ? null : inputEvent);
    }
}
