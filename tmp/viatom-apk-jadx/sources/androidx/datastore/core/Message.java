package androidx.datastore.core;

import g7.p;
import kotlin.jvm.internal.g;
import r7.l;
import w6.h;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public abstract class Message<T> {

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Read<T> extends Message<T> {
        private final State<T> lastState;

        public Read(State<T> state) {
            super(null);
            this.lastState = state;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Update<T> extends Message<T> {
        private final l ack;
        private final h callerContext;
        private final State<T> lastState;
        private final p transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Update(p pVar, l lVar, State<T> state, h hVar) {
            super(null);
            pVar.getClass();
            lVar.getClass();
            hVar.getClass();
            this.transform = pVar;
            this.ack = lVar;
            this.lastState = state;
            this.callerContext = hVar;
        }

        public final l getAck() {
            return this.ack;
        }

        public final h getCallerContext() {
            return this.callerContext;
        }

        @Override // androidx.datastore.core.Message
        public State<T> getLastState() {
            return this.lastState;
        }

        public final p getTransform() {
            return this.transform;
        }
    }

    public /* synthetic */ Message(g gVar) {
        this();
    }

    public abstract State<T> getLastState();

    private Message() {
    }
}
