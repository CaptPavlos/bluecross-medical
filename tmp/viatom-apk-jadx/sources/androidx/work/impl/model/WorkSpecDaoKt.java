package androidx.work.impl.model;

import com.google.android.gms.internal.measurement.a4;
import java.util.UUID;
import r7.s;
import s6.w;
import u7.i;
import u7.i0;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class WorkSpecDaoKt {
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, required_network_request, requires_charging, requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    public static final u7.h dedup(final u7.h hVar, s sVar) {
        hVar.getClass();
        sVar.getClass();
        return i0.k(i0.g(new u7.h() { // from class: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1

            /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                @y6.e(c = "androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2", f = "WorkSpecDao.kt", l = {50}, m = "emit")
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends y6.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(w6.c cVar) {
                        super(cVar);
                    }

                    @Override // y6.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // u7.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, w6.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        int r1 = r0.label
                        r2 = 1
                        if (r1 == 0) goto L2c
                        if (r1 != r2) goto L25
                        s6.a.e(r6)
                        goto L63
                    L25:
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        androidx.window.layout.c.g(r5)
                        r5 = 0
                        return r5
                    L2c:
                        s6.a.e(r6)
                        u7.i r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        java.lang.Iterable r5 = (java.lang.Iterable) r5
                        java.util.ArrayList r1 = new java.util.ArrayList
                        r3 = 10
                        int r3 = t6.n.V(r5, r3)
                        r1.<init>(r3)
                        java.util.Iterator r5 = r5.iterator()
                    L44:
                        boolean r3 = r5.hasNext()
                        if (r3 == 0) goto L58
                        java.lang.Object r3 = r5.next()
                        androidx.work.impl.model.WorkSpec$WorkInfoPojo r3 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r3
                        androidx.work.WorkInfo r3 = r3.toWorkInfo()
                        r1.add(r3)
                        goto L44
                    L58:
                        r0.label = r2
                        java.lang.Object r5 = r6.emit(r1, r0)
                        x6.a r6 = x6.a.f13718a
                        if (r5 != r6) goto L63
                        return r6
                    L63:
                        s6.w r5 = s6.w.f12711a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w6.c):java.lang.Object");
                }
            }

            @Override // u7.h
            public Object collect(i iVar, w6.c cVar) {
                Object objCollect = hVar.collect(new AnonymousClass2(iVar), cVar);
                return objCollect == x6.a.f13718a ? objCollect : w.f12711a;
            }
        }), sVar);
    }

    public static final u7.h getWorkStatusPojoFlowDataForIds(WorkSpecDao workSpecDao, UUID uuid) {
        workSpecDao.getClass();
        uuid.getClass();
        final u7.h workStatusPojoFlowDataForIds = workSpecDao.getWorkStatusPojoFlowDataForIds(a4.u(String.valueOf(uuid)));
        return i0.g(new u7.h() { // from class: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1

            /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2, reason: invalid class name */
            public static final class AnonymousClass2<T> implements i {
                final /* synthetic */ i $this_unsafeFlow;

                @y6.e(c = "androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2", f = "WorkSpecDao.kt", l = {50}, m = "emit")
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends y6.c {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(w6.c cVar) {
                        super(cVar);
                    }

                    @Override // y6.a
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(i iVar) {
                    this.$this_unsafeFlow = iVar;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // u7.i
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r5, w6.c r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.result
                        int r1 = r0.label
                        r2 = 1
                        if (r1 == 0) goto L2c
                        if (r1 != r2) goto L25
                        s6.a.e(r6)
                        goto L57
                    L25:
                        java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                        androidx.window.layout.c.g(r5)
                        r5 = 0
                        return r5
                    L2c:
                        s6.a.e(r6)
                        u7.i r6 = r4.$this_unsafeFlow
                        java.util.List r5 = (java.util.List) r5
                        r5.getClass()
                        boolean r1 = r5.isEmpty()
                        r3 = 0
                        if (r1 == 0) goto L3f
                        r5 = r3
                        goto L44
                    L3f:
                        r1 = 0
                        java.lang.Object r5 = r5.get(r1)
                    L44:
                        androidx.work.impl.model.WorkSpec$WorkInfoPojo r5 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r5
                        if (r5 == 0) goto L4c
                        androidx.work.WorkInfo r3 = r5.toWorkInfo()
                    L4c:
                        r0.label = r2
                        java.lang.Object r5 = r6.emit(r3, r0)
                        x6.a r6 = x6.a.f13718a
                        if (r5 != r6) goto L57
                        return r6
                    L57:
                        s6.w r5 = s6.w.f12711a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, w6.c):java.lang.Object");
                }
            }

            @Override // u7.h
            public Object collect(i iVar, w6.c cVar) {
                Object objCollect = workStatusPojoFlowDataForIds.collect(new AnonymousClass2(iVar), cVar);
                return objCollect == x6.a.f13718a ? objCollect : w.f12711a;
            }
        });
    }

    public static final u7.h getWorkStatusPojoFlowForName(WorkSpecDao workSpecDao, s sVar, String str) {
        workSpecDao.getClass();
        sVar.getClass();
        str.getClass();
        return dedup(workSpecDao.getWorkStatusPojoFlowForName(str), sVar);
    }

    public static final u7.h getWorkStatusPojoFlowForTag(WorkSpecDao workSpecDao, s sVar, String str) {
        workSpecDao.getClass();
        sVar.getClass();
        str.getClass();
        return dedup(workSpecDao.getWorkStatusPojoFlowForTag(str), sVar);
    }
}
