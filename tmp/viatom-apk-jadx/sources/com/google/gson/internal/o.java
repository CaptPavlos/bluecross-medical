package com.google.gson.internal;

import j$.util.Objects;
import java.io.Writer;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class o extends Writer {

    /* renamed from: a, reason: collision with root package name */
    public final StringBuilder f2581a;

    /* renamed from: b, reason: collision with root package name */
    public final n f2582b = new n();

    public o(StringBuilder sb) {
        this.f2581a = sb;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f2581a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i10, int i11) {
        n nVar = this.f2582b;
        nVar.f2579a = cArr;
        nVar.f2580b = null;
        this.f2581a.append((CharSequence) nVar, i10, i11 + i10);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f2581a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i10, int i11) {
        this.f2581a.append(charSequence, i10, i11);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i10, int i11) {
        this.f2581a.append(charSequence, i10, i11);
        return this;
    }

    @Override // java.io.Writer
    public final void write(String str, int i10, int i11) {
        Objects.requireNonNull(str);
        this.f2581a.append((CharSequence) str, i10, i11 + i10);
    }

    @Override // java.io.Writer
    public final void write(int i10) {
        this.f2581a.append((char) i10);
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
