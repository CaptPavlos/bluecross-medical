package com.inmobi.cmp.model;

import a.a;
import com.inmobi.cmp.core.cmpapi.status.DisplayStatus;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class DisplayInfo {

    /* renamed from: a, reason: collision with root package name */
    public DisplayStatus f2612a;

    /* renamed from: b, reason: collision with root package name */
    public String f2613b;

    /* renamed from: c, reason: collision with root package name */
    public Regulations f2614c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2615d;

    public DisplayInfo(DisplayStatus displayStatus, String str, Regulations regulations, boolean z9) {
        displayStatus.getClass();
        str.getClass();
        regulations.getClass();
        this.f2612a = displayStatus;
        this.f2613b = str;
        this.f2614c = regulations;
        this.f2615d = z9;
    }

    public static /* synthetic */ DisplayInfo copy$default(DisplayInfo displayInfo, DisplayStatus displayStatus, String str, Regulations regulations, boolean z9, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            displayStatus = displayInfo.f2612a;
        }
        if ((i10 & 2) != 0) {
            str = displayInfo.f2613b;
        }
        if ((i10 & 4) != 0) {
            regulations = displayInfo.f2614c;
        }
        if ((i10 & 8) != 0) {
            z9 = displayInfo.f2615d;
        }
        return displayInfo.copy(displayStatus, str, regulations, z9);
    }

    public final DisplayStatus component1() {
        return this.f2612a;
    }

    public final String component2() {
        return this.f2613b;
    }

    public final Regulations component3() {
        return this.f2614c;
    }

    public final boolean component4() {
        return this.f2615d;
    }

    public final DisplayInfo copy(DisplayStatus displayStatus, String str, Regulations regulations, boolean z9) {
        displayStatus.getClass();
        str.getClass();
        regulations.getClass();
        return new DisplayInfo(displayStatus, str, regulations, z9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisplayInfo)) {
            return false;
        }
        DisplayInfo displayInfo = (DisplayInfo) obj;
        return this.f2612a == displayInfo.f2612a && l.a(this.f2613b, displayInfo.f2613b) && this.f2614c == displayInfo.f2614c && this.f2615d == displayInfo.f2615d;
    }

    public final String getDisplayMessage() {
        return this.f2613b;
    }

    public final DisplayStatus getDisplayStatus() {
        return this.f2612a;
    }

    public final boolean getGbcShown() {
        return this.f2615d;
    }

    public final Regulations getRegulationShown() {
        return this.f2614c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iHashCode = (this.f2614c.hashCode() + a.b(this.f2613b, this.f2612a.hashCode() * 31)) * 31;
        boolean z9 = this.f2615d;
        int i10 = z9;
        if (z9 != 0) {
            i10 = 1;
        }
        return iHashCode + i10;
    }

    public final void setDisplayMessage(String str) {
        str.getClass();
        this.f2613b = str;
    }

    public final void setDisplayStatus(DisplayStatus displayStatus) {
        displayStatus.getClass();
        this.f2612a = displayStatus;
    }

    public final void setGbcShown(boolean z9) {
        this.f2615d = z9;
    }

    public final void setRegulationShown(Regulations regulations) {
        regulations.getClass();
        this.f2614c = regulations;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DisplayInfo(displayStatus=");
        sb.append(this.f2612a);
        sb.append(", displayMessage=");
        sb.append(this.f2613b);
        sb.append(", regulationShown=");
        sb.append(this.f2614c);
        sb.append(", gbcShown=");
        return androidx.constraintlayout.core.widgets.analyzer.a.z(sb, this.f2615d, ')');
    }

    public /* synthetic */ DisplayInfo(DisplayStatus displayStatus, String str, Regulations regulations, boolean z9, int i10, g gVar) {
        this(displayStatus, str, regulations, (i10 & 8) != 0 ? false : z9);
    }
}
