package j$.util.stream;

import j$.util.Spliterator;
import java.util.Deque;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final class j3 extends k3 {
    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        h2 h2VarA;
        if (!c()) {
            return false;
        }
        boolean zTryAdvance = this.f9642d.tryAdvance(consumer);
        if (!zTryAdvance) {
            if (this.f9641c == null && (h2VarA = k3.a(this.e)) != null) {
                Spliterator spliterator = h2VarA.spliterator();
                this.f9642d = spliterator;
                return spliterator.tryAdvance(consumer);
            }
            this.f9639a = null;
        }
        return zTryAdvance;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        if (this.f9639a == null) {
            return;
        }
        if (this.f9642d == null) {
            Spliterator spliterator = this.f9641c;
            if (spliterator == null) {
                Deque dequeB = b();
                while (true) {
                    h2 h2VarA = k3.a(dequeB);
                    if (h2VarA != null) {
                        h2VarA.forEach(consumer);
                    } else {
                        this.f9639a = null;
                        return;
                    }
                }
            } else {
                spliterator.forEachRemaining(consumer);
            }
        } else {
            while (tryAdvance(consumer)) {
            }
        }
    }
}
