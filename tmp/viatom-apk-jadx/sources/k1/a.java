package k1;

import a3.x;
import a4.f;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import c1.c3;
import c1.i1;
import c1.k3;
import c1.v4;
import c1.x3;
import com.google.android.gms.internal.measurement.c0;
import com.google.android.gms.internal.measurement.n0;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.OldVersionsActivity;
import e0.i;
import e0.k;
import e0.l;
import e0.m;
import e5.b2;
import f1.e;
import h0.p;
import h0.v;
import h1.c;
import h1.d;
import h1.g;
import h1.h;
import h1.j;
import h1.o;
import h5.q;
import i0.l0;
import i0.s;
import i0.y;
import j$.util.Objects;
import j4.i0;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import o7.u;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10039a;

    /* renamed from: b, reason: collision with root package name */
    public Object f10040b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f10041c;

    public a(x3 x3Var, k3 k3Var) {
        this.f10039a = 10;
        this.f10040b = k3Var;
        Objects.requireNonNull(x3Var);
        this.f10041c = x3Var;
    }

    private final void a() {
        k kVar = (k) this.f10040b;
        IBinder iBinder = (IBinder) this.f10041c;
        synchronized (kVar) {
            if (iBinder == null) {
                kVar.a("Null service connection");
                return;
            }
            try {
                kVar.f7610c = new f(iBinder);
                kVar.f7608a = 2;
                ((ScheduledExecutorService) kVar.f.f7618c).execute(new i(kVar, 0));
            } catch (RemoteException e) {
                kVar.a(e.getMessage());
            }
        }
    }

    private final void b() {
        k kVar = (k) this.f10040b;
        int i10 = ((l) this.f10041c).f7612a;
        synchronized (kVar) {
            l lVar = (l) kVar.e.get(i10);
            if (lVar != null) {
                Log.w("MessengerIpcClient", "Timing out request: " + i10);
                kVar.e.remove(i10);
                lVar.b(new m("Timed out waiting for response", null));
                kVar.c();
            }
        }
    }

    private final void c() {
        i0.i l0Var;
        v vVar = (v) this.f10041c;
        e eVar = (e) this.f10040b;
        f0.b bVar = eVar.f8044b;
        if (bVar.f7991b == 0) {
            s sVar = eVar.f8045c;
            y.g(sVar);
            f0.b bVar2 = sVar.f8948c;
            if (bVar2.f7991b != 0) {
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(String.valueOf(bVar2)), new Exception());
                vVar.f8411p.h(bVar2);
                vVar.f8410o.o();
                return;
            }
            p pVar = vVar.f8411p;
            IBinder iBinder = sVar.f8947b;
            if (iBinder == null) {
                l0Var = null;
            } else {
                int i10 = i0.a.f8858b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                l0Var = iInterfaceQueryLocalInterface instanceof i0.i ? (i0.i) iInterfaceQueryLocalInterface : new l0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 3);
            }
            Set set = vVar.f8408m;
            pVar.getClass();
            if (l0Var == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                pVar.h(new f0.b(4));
            } else {
                pVar.f8396d = l0Var;
                pVar.e = set;
                if (pVar.f8393a) {
                    ((g0.b) pVar.f8394b).d(l0Var, set);
                }
            }
        } else {
            vVar.f8411p.h(bVar);
        }
        vVar.f8410o.o();
    }

    private final void d() {
        h1.l lVar = (h1.l) this.f10041c;
        h1.p pVar = lVar.f8428d;
        try {
            h1.p pVar2 = (h1.p) lVar.f8427c.a((h1.p) this.f10040b);
            if (pVar2 == null) {
                lVar.u(new NullPointerException("Continuation returned null"));
                return;
            }
            o oVar = j.f8420b;
            pVar2.c(oVar, lVar);
            pVar2.b(oVar, lVar);
            pVar2.f8436b.o(new h1.m((Executor) oVar, (c) lVar));
            pVar2.p();
        } catch (g e) {
            if (e.getCause() instanceof Exception) {
                pVar.k((Exception) e.getCause());
            } else {
                pVar.k(e);
            }
        } catch (Exception e3) {
            pVar.k(e3);
        }
    }

    private final void e() {
        synchronized (((h1.m) this.f10041c).f8431c) {
            ((d) ((h1.m) this.f10041c).f8432d).o((h1.p) this.f10040b);
        }
    }

    private final void f() {
        synchronized (((h1.m) this.f10041c).f8431c) {
            h1.e eVar = (h1.e) ((h1.m) this.f10041c).f8432d;
            Exception excF = ((h1.p) this.f10040b).f();
            y.g(excF);
            eVar.u(excF);
        }
    }

    private final void g() {
        synchronized (((h1.m) this.f10041c).f8431c) {
            ((h1.f) ((h1.m) this.f10041c).f8432d).h(((h1.p) this.f10040b).g());
        }
    }

    private final void h() {
        h1.m mVar = (h1.m) this.f10041c;
        h1.p pVar = (h1.p) mVar.f8432d;
        try {
            h1.p pVarY = ((h) mVar.f8431c).y(((h1.p) this.f10040b).g());
            o oVar = j.f8420b;
            pVarY.c(oVar, mVar);
            pVarY.b(oVar, mVar);
            pVarY.f8436b.o(new h1.m((Executor) oVar, (c) mVar));
            pVarY.p();
        } catch (g e) {
            if (e.getCause() instanceof Exception) {
                mVar.u((Exception) e.getCause());
            } else {
                pVar.k(e);
            }
        } catch (CancellationException unused) {
            mVar.n();
        } catch (Exception e3) {
            pVar.k(e3);
        }
    }

    private final void i() {
        h1.p pVar = (h1.p) this.f10040b;
        try {
            pVar.l(((Callable) this.f10041c).call());
        } catch (Exception e) {
            pVar.k(e);
        } catch (Throwable th) {
            pVar.k(new RuntimeException(th));
        }
    }

    private final void j() {
        throw new RuntimeException("Transformation " + ((i0) this.f10040b).key() + " crashed with exception.", (RuntimeException) this.f10041c);
    }

    private final void k() {
        b2 b2Var = ((MoreInfo) this.f10041c).J;
        if (b2Var != null) {
            b2Var.getClass();
            q qVar = (q) this.f10040b;
            b2Var.e(qVar != null ? qVar.f8701b : null);
        }
    }

    private final void l() {
        q qVar = (q) this.f10040b;
        OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) this.f10041c;
        int i10 = OldVersionsActivity.L;
        if (oldVersionsActivity.q0().f10552d.getValue() != null) {
            Object value = oldVersionsActivity.q0().f10552d.getValue();
            value.getClass();
            if (((h5.h) value).f8595w != null) {
                Object value2 = oldVersionsActivity.q0().f10552d.getValue();
                value2.getClass();
                if (u.Z(((h5.h) value2).f8595w, qVar.f8701b, true)) {
                    oldVersionsActivity.r0(qVar);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
    
        if (r1 == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004e, code lost:
    
        ((java.lang.Runnable) r10.f10040b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005d, code lost:
    
        r1.j.f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.f10040b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x007a, code lost:
    
        r10.f10040b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007c, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.f10041c     // Catch: java.lang.Throwable -> L58
            r1.j r2 = (r1.j) r2     // Catch: java.lang.Throwable -> L58
            java.util.ArrayDeque r2 = r2.f12337b     // Catch: java.lang.Throwable -> L58
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L58
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.f10041c     // Catch: java.lang.Throwable -> L20
            r1.j r0 = (r1.j) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.f12338c     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
        L18:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L46
        L20:
            r0 = move-exception
            goto L7d
        L22:
            long r6 = r0.f12339d     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.f12339d = r6     // Catch: java.lang.Throwable -> L20
            r0.f12338c = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.f10041c     // Catch: java.lang.Throwable -> L20
            r1.j r4 = (r1.j) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.f12337b     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.f10040b = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L47
            java.lang.Object r0 = r10.f10041c     // Catch: java.lang.Throwable -> L20
            r1.j r0 = (r1.j) r0     // Catch: java.lang.Throwable -> L20
            r0.f12338c = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L46
            goto L18
        L46:
            return
        L47:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L58
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.f10040b     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
            r3.run()     // Catch: java.lang.Throwable -> L5a java.lang.RuntimeException -> L5c
        L55:
            r10.f10040b = r2     // Catch: java.lang.Throwable -> L58
            goto L2
        L58:
            r0 = move-exception
            goto L7f
        L5a:
            r0 = move-exception
            goto L7a
        L5c:
            r3 = move-exception
            java.util.logging.Logger r4 = r1.j.f     // Catch: java.lang.Throwable -> L5a
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5a
            r6.<init>()     // Catch: java.lang.Throwable -> L5a
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.Object r7 = r10.f10040b     // Catch: java.lang.Throwable -> L5a
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L5a
            r6.append(r7)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L5a
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L5a
            goto L55
        L7a:
            r10.f10040b = r2     // Catch: java.lang.Throwable -> L58
            throw r0     // Catch: java.lang.Throwable -> L58
        L7d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L58
        L7f:
            if (r1 == 0) goto L88
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L88:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.a.m():void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:175|(1:177)(9:180|485|181|182|(1:185)(5:187|(1:189)|487|190|(23:192|(1:194)(1:196)|483|197|475|198|199|203|(2:205|(2:207|(2:209|(2:211|(2:213|(2:215|(1:217)(1:218))(1:219))(1:220))(1:221))(1:222))(1:223))(1:224)|225|479|226|(1:228)(1:229)|230|(1:232)|236|(1:238)(7:240|(0)(1:243)|(3:477|245|(1:247)(1:248))|(2:254|(1:256)(4:257|(3:260|(1:509)(1:510)|258)|508|263))(1:263)|(1:265)(1:266)|267|(30:269|(1:271)(1:272)|273|(1:275)|276|(1:278)(1:279)|280|(2:282|(2:287|(1:289))(1:(3:286|287|(0))(1:290)))(0)|291|(21:294|296|(1:298)|299|(1:315)(1:316)|317|(1:319)|320|(2:325|(2:331|(2:338|(2:339|(1:505)(2:341|(2:506|343)(1:507)))))(1:330))(1:324)|344|(3:348|(1:350)|351)|352|(1:354)|355|(1:359)|360|(3:362|(7:364|(1:366)(1:367)|368|(1:370)|371|(4:375|(1:377)|378|(1:380))|381)(1:383)|382)(10:384|(2:386|(2:399|400)(3:389|(5:391|(1:393)(1:394)|395|(1:397)|398)(0)|400))(1:401)|402|(1:404)|405|491|406|407|411|(5:413|(1:415)(1:416)|(1:420)|(1:422)|423))|424|(3:426|(1:428)(1:429)|(5:431|(1:433)|434|(1:436)|437))|438|533)(1:295)|300|(1:(1:311)(19:310|299|(0)(0)|317|(0)|320|(3:322|325|(3:328|331|(4:334|336|338|(3:339|(0)(0)|507)))(0))(0)|344|(4:346|348|(0)|351)(0)|352|(0)|355|(2:357|359)|360|(0)(0)|424|(0)|438|533))(1:313)|312|(0)(0)|317|(0)|320|(0)(0)|344|(0)(0)|352|(0)|355|(0)|360|(0)(0)|424|(0)|438|533)(2:439|534))|239|(0)|(0)(0)|(0)(0)|267|(0)(0)))|186|487|190|(0))|178|179|203|(0)(0)|225|479|226|(0)(0)|230|(0)|236|(0)(0)|239|(0)|(0)(0)|(0)(0)|267|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:180|485|181|182|(1:185)(5:187|(1:189)|487|190|(23:192|(1:194)(1:196)|483|197|475|198|199|203|(2:205|(2:207|(2:209|(2:211|(2:213|(2:215|(1:217)(1:218))(1:219))(1:220))(1:221))(1:222))(1:223))(1:224)|225|479|226|(1:228)(1:229)|230|(1:232)|236|(1:238)(7:240|(0)(1:243)|(3:477|245|(1:247)(1:248))|(2:254|(1:256)(4:257|(3:260|(1:509)(1:510)|258)|508|263))(1:263)|(1:265)(1:266)|267|(30:269|(1:271)(1:272)|273|(1:275)|276|(1:278)(1:279)|280|(2:282|(2:287|(1:289))(1:(3:286|287|(0))(1:290)))(0)|291|(21:294|296|(1:298)|299|(1:315)(1:316)|317|(1:319)|320|(2:325|(2:331|(2:338|(2:339|(1:505)(2:341|(2:506|343)(1:507)))))(1:330))(1:324)|344|(3:348|(1:350)|351)|352|(1:354)|355|(1:359)|360|(3:362|(7:364|(1:366)(1:367)|368|(1:370)|371|(4:375|(1:377)|378|(1:380))|381)(1:383)|382)(10:384|(2:386|(2:399|400)(3:389|(5:391|(1:393)(1:394)|395|(1:397)|398)(0)|400))(1:401)|402|(1:404)|405|491|406|407|411|(5:413|(1:415)(1:416)|(1:420)|(1:422)|423))|424|(3:426|(1:428)(1:429)|(5:431|(1:433)|434|(1:436)|437))|438|533)(1:295)|300|(1:(1:311)(19:310|299|(0)(0)|317|(0)|320|(3:322|325|(3:328|331|(4:334|336|338|(3:339|(0)(0)|507)))(0))(0)|344|(4:346|348|(0)|351)(0)|352|(0)|355|(2:357|359)|360|(0)(0)|424|(0)|438|533))(1:313)|312|(0)(0)|317|(0)|320|(0)(0)|344|(0)(0)|352|(0)|355|(0)|360|(0)(0)|424|(0)|438|533)(2:439|534))|239|(0)|(0)(0)|(0)(0)|267|(0)(0)))|186|487|190|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x052d, code lost:
    
        r9 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x05f0, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x05f1, code lost:
    
        c1.u1.m(r10);
        r10.f.d(c1.w0.o(r2), "Fetching Google App Id failed with exception. appId", r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0508 A[Catch: NameNotFoundException -> 0x052d, TryCatch #8 {NameNotFoundException -> 0x052d, blocks: (B:190:0x04fd, B:192:0x0508, B:194:0x0514), top: B:487:0x04fd }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0559  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x05db  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x05dc  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x05e1 A[Catch: IllegalStateException -> 0x05f0, TRY_LEAVE, TryCatch #2 {IllegalStateException -> 0x05f0, blocks: (B:226:0x05cf, B:230:0x05dd, B:232:0x05e1), top: B:479:0x05cf }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x061f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0656  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0685  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0689  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0690  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x077a  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x07ad  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0850  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0858  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x087f  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x088f  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x08ae  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x08d2  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0904  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x091b  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:350:0x093f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x096c  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0986  */
    /* JADX WARN: Removed duplicated region for block: B:362:0x099f  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0a0d  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0ab5  */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0b7b  */
    /* JADX WARN: Removed duplicated region for block: B:439:0x0be6  */
    /* JADX WARN: Removed duplicated region for block: B:477:0x0630 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:493:0x0342 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0913 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v69, types: [c1.b3] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException, java.lang.NumberFormatException, java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 3346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.a.run():void");
    }

    public String toString() {
        switch (this.f10039a) {
            case 0:
                x xVar = new x(a.class.getSimpleName());
                f fVar = (f) this.f10041c;
                i0.k kVar = new i0.k(3, false);
                ((i0.k) xVar.f183d).f8923b = kVar;
                xVar.f183d = kVar;
                kVar.f8924c = fVar;
                return xVar.toString();
            case 29:
                Runnable runnable = (Runnable) this.f10040b;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i10 = ((r1.j) this.f10041c).f12338c;
                sb.append(i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ a(Object obj, Object obj2, int i10, boolean z9) {
        this.f10039a = i10;
        this.f10040b = obj2;
        this.f10041c = obj;
    }

    public a(i1 i1Var, c0 c0Var, i1 i1Var2) {
        this.f10039a = 2;
        this.f10040b = c0Var;
        this.f10041c = i1Var;
    }

    public a(c3 c3Var, n0 n0Var) {
        this.f10039a = 5;
        this.f10040b = n0Var;
        Objects.requireNonNull(c3Var);
        this.f10041c = c3Var;
    }

    public /* synthetic */ a(int i10, Object obj, Object obj2) {
        this.f10039a = i10;
        this.f10040b = obj;
        this.f10041c = obj2;
    }

    public a(d0.i iVar, v4 v4Var, Runnable runnable) {
        this.f10039a = 13;
        this.f10040b = v4Var;
        this.f10041c = runnable;
    }

    public a(r1.j jVar) {
        this.f10039a = 29;
        this.f10041c = jVar;
    }
}
