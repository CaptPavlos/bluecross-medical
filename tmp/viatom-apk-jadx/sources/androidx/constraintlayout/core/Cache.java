package androidx.constraintlayout.core;

import androidx.constraintlayout.core.Pools;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class Cache {
    Pools.Pool<ArrayRow> mOptimizedArrayRowPool = new Pools.SimplePool(256);
    Pools.Pool<ArrayRow> mArrayRowPool = new Pools.SimplePool(256);
    Pools.Pool<SolverVariable> mSolverVariablePool = new Pools.SimplePool(256);
    SolverVariable[] mIndexedVariables = new SolverVariable[32];
}
