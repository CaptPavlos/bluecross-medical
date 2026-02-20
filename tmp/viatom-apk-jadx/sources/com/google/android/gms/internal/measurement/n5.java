package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public abstract class n5 implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final o5 f2101a;

    /* renamed from: b, reason: collision with root package name */
    public o5 f2102b;

    public n5(o5 o5Var) {
        this.f2101a = o5Var;
        if (o5Var.e()) {
            com.google.gson.internal.a.n("Default instance must be immutable.");
            throw null;
        }
        this.f2102b = (o5) o5Var.o(4);
    }

    public static void a(int i10, List list) {
        int size = list.size() - i10;
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 26);
        sb.append("Element at index ");
        sb.append(size);
        sb.append(" is null.");
        String string = sb.toString();
        int size2 = list.size();
        while (true) {
            size2--;
            if (size2 < i10) {
                throw new NullPointerException(string);
            }
            list.remove(size2);
        }
    }

    public final void b() {
        if (this.f2102b.e()) {
            return;
        }
        o5 o5Var = (o5) this.f2101a.o(4);
        m6.f2086c.a(o5Var.getClass()).b(o5Var, this.f2102b);
        this.f2102b = o5Var;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final n5 clone() {
        n5 n5Var = (n5) this.f2101a.o(5);
        boolean zE = this.f2102b.e();
        o5 o5Var = this.f2102b;
        if (zE) {
            o5Var.g();
            o5Var = this.f2102b;
        }
        n5Var.f2102b = o5Var;
        return n5Var;
    }

    public final o5 d() {
        boolean zE = this.f2102b.e();
        o5 o5Var = this.f2102b;
        if (zE) {
            o5Var.g();
            o5Var = this.f2102b;
        }
        o5Var.getClass();
        boolean zE2 = true;
        byte bByteValue = ((Byte) o5Var.o(1)).byteValue();
        if (bByteValue != 1) {
            if (bByteValue == 0) {
                zE2 = false;
            } else {
                zE2 = m6.f2086c.a(o5Var.getClass()).e(o5Var);
                o5Var.o(2);
            }
        }
        if (zE2) {
            return o5Var;
        }
        throw new u6("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final void e(o5 o5Var) {
        o5 o5Var2 = this.f2101a;
        if (o5Var2.equals(o5Var)) {
            return;
        }
        if (!this.f2102b.e()) {
            o5 o5Var3 = (o5) o5Var2.o(4);
            m6.f2086c.a(o5Var3.getClass()).b(o5Var3, this.f2102b);
            this.f2102b = o5Var3;
        }
        o5 o5Var4 = this.f2102b;
        m6.f2086c.a(o5Var4.getClass()).b(o5Var4, o5Var);
    }

    public final void f(byte[] bArr, int i10, g5 g5Var) throws w5 {
        if (!this.f2102b.e()) {
            o5 o5Var = (o5) this.f2101a.o(4);
            m6.f2086c.a(o5Var.getClass()).b(o5Var, this.f2102b);
            this.f2102b = o5Var;
        }
        try {
            p6 p6VarA = m6.f2086c.a(this.f2102b.getClass());
            o5 o5Var2 = this.f2102b;
            x4 x4Var = new x4();
            g5Var.getClass();
            p6VarA.h(o5Var2, bArr, 0, i10, x4Var);
        } catch (w5 e) {
            throw e;
        } catch (IOException e3) {
            androidx.privacysandbox.ads.adservices.adid.a.l("Reading from byte array should not throw IOException.", e3);
        } catch (IndexOutOfBoundsException unused) {
            androidx.window.layout.c.m("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
