package androidx.work.impl.constraints;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class NetworkState {
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean z9, boolean z10, boolean z11, boolean z12) {
        this.isConnected = z9;
        this.isValidated = z10;
        this.isMetered = z11;
        this.isNotRoaming = z12;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, boolean z9, boolean z10, boolean z11, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z9 = networkState.isConnected;
        }
        if ((i10 & 2) != 0) {
            z10 = networkState.isValidated;
        }
        if ((i10 & 4) != 0) {
            z11 = networkState.isMetered;
        }
        if ((i10 & 8) != 0) {
            z12 = networkState.isNotRoaming;
        }
        return networkState.copy(z9, z10, z11, z12);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    public final NetworkState copy(boolean z9, boolean z10, boolean z11, boolean z12) {
        return new NetworkState(z9, z10, z11, z12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.isConnected == networkState.isConnected && this.isValidated == networkState.isValidated && this.isMetered == networkState.isMetered && this.isNotRoaming == networkState.isNotRoaming;
    }

    public int hashCode() {
        return ((((((this.isConnected ? 1231 : 1237) * 31) + (this.isValidated ? 1231 : 1237)) * 31) + (this.isMetered ? 1231 : 1237)) * 31) + (this.isNotRoaming ? 1231 : 1237);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NetworkState(isConnected=");
        sb.append(this.isConnected);
        sb.append(", isValidated=");
        sb.append(this.isValidated);
        sb.append(", isMetered=");
        sb.append(this.isMetered);
        sb.append(", isNotRoaming=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.isNotRoaming, ')');
    }
}
