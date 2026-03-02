package androidx.constraintlayout.core.widgets;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Rectangle {
    public int height;
    public int width;

    /* renamed from: x, reason: collision with root package name */
    public int f461x;
    public int y;

    public boolean contains(int i10, int i11) {
        int i12;
        int i13 = this.f461x;
        return i10 >= i13 && i10 < i13 + this.width && i11 >= (i12 = this.y) && i11 < i12 + this.height;
    }

    public int getCenterX() {
        return (this.f461x + this.width) / 2;
    }

    public int getCenterY() {
        return (this.y + this.height) / 2;
    }

    public void grow(int i10, int i11) {
        this.f461x -= i10;
        this.y -= i11;
        this.width = (i10 * 2) + this.width;
        this.height = (i11 * 2) + this.height;
    }

    public boolean intersects(Rectangle rectangle) {
        int i10;
        int i11;
        int i12 = this.f461x;
        int i13 = rectangle.f461x;
        return i12 >= i13 && i12 < i13 + rectangle.width && (i10 = this.y) >= (i11 = rectangle.y) && i10 < i11 + rectangle.height;
    }

    public void setBounds(int i10, int i11, int i12, int i13) {
        this.f461x = i10;
        this.y = i11;
        this.width = i12;
        this.height = i13;
    }
}
