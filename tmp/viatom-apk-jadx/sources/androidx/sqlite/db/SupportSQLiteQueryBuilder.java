package androidx.sqlite.db;

import com.google.gson.internal.a;
import java.util.regex.Pattern;
import kotlin.jvm.internal.g;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = new Companion(null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        sb.append(str);
        sb.append(str2);
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            if (i10 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    public static final SupportSQLiteQueryBuilder builder(String str) {
        return Companion.builder(str);
    }

    public final SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.columns = strArr;
        return this;
    }

    public final SupportSQLiteQuery create() {
        String str;
        String str2 = this.groupBy;
        if ((str2 == null || str2.length() == 0) && (str = this.having) != null && str.length() != 0) {
            a.n("HAVING clauses are only permitted when using a groupBy clause");
            return null;
        }
        StringBuilder sb = new StringBuilder(androidx.constraintlayout.widget.R.styleable.ConstraintSet_stateLabels);
        sb.append("SELECT ");
        if (this.distinct) {
            sb.append("DISTINCT ");
        }
        String[] strArr = this.columns;
        if (strArr == null || strArr.length == 0) {
            sb.append("* ");
        } else {
            strArr.getClass();
            appendColumns(sb, strArr);
        }
        sb.append("FROM ");
        sb.append(this.table);
        appendClause(sb, " WHERE ", this.selection);
        appendClause(sb, " GROUP BY ", this.groupBy);
        appendClause(sb, " HAVING ", this.having);
        appendClause(sb, " ORDER BY ", this.orderBy);
        appendClause(sb, " LIMIT ", this.limit);
        return new SimpleSQLiteQuery(sb.toString(), this.bindArgs);
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String str) {
        this.groupBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String str) {
        this.having = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String str) {
        str.getClass();
        boolean zMatches = limitPattern.matcher(str).matches();
        if (str.length() == 0 || zMatches) {
            this.limit = str;
            return this;
        }
        f.b("invalid LIMIT clauses:".concat(str));
        return null;
    }

    public final SupportSQLiteQueryBuilder orderBy(String str) {
        this.orderBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }

    /* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final SupportSQLiteQueryBuilder builder(String str) {
            str.getClass();
            return new SupportSQLiteQueryBuilder(str, null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, g gVar) {
        this(str);
    }
}
