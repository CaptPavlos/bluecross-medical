package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Build;
import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;
import com.google.android.material.R;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes3.dex */
class DateStrings {
    private DateStrings() {
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l10, @Nullable Long l11, @Nullable SimpleDateFormat simpleDateFormat) {
        if (l10 == null && l11 == null) {
            return Pair.create(null, null);
        }
        if (l10 == null) {
            return Pair.create(null, getDateString(l11.longValue(), simpleDateFormat));
        }
        if (l11 == null) {
            return Pair.create(getDateString(l10.longValue(), simpleDateFormat), null);
        }
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(l10.longValue());
        Calendar utcCalendar2 = UtcDates.getUtcCalendar();
        utcCalendar2.setTimeInMillis(l11.longValue());
        if (simpleDateFormat != null) {
            return Pair.create(simpleDateFormat.format(new Date(l10.longValue())), simpleDateFormat.format(new Date(l11.longValue())));
        }
        return utcCalendar.get(1) == utcCalendar2.get(1) ? utcCalendar.get(1) == todayCalendar.get(1) ? Pair.create(getMonthDay(l10.longValue(), Locale.getDefault()), getMonthDay(l11.longValue(), Locale.getDefault())) : Pair.create(getMonthDay(l10.longValue(), Locale.getDefault()), getYearMonthDay(l11.longValue(), Locale.getDefault())) : Pair.create(getYearMonthDay(l10.longValue(), Locale.getDefault()), getYearMonthDay(l11.longValue(), Locale.getDefault()));
    }

    public static String getDateString(long j10, @Nullable SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat != null ? simpleDateFormat.format(new Date(j10)) : isDateWithinCurrentYear(j10) ? getMonthDay(j10) : getYearMonthDay(j10);
    }

    public static String getDayContentDescription(Context context, long j10, boolean z9, boolean z10, boolean z11) {
        String optionalYearMonthDayOfWeekDay = getOptionalYearMonthDayOfWeekDay(j10);
        if (z9) {
            optionalYearMonthDayOfWeekDay = String.format(context.getString(R.string.mtrl_picker_today_description), optionalYearMonthDayOfWeekDay);
        }
        return z10 ? String.format(context.getString(R.string.mtrl_picker_start_date_description), optionalYearMonthDayOfWeekDay) : z11 ? String.format(context.getString(R.string.mtrl_picker_end_date_description), optionalYearMonthDayOfWeekDay) : optionalYearMonthDayOfWeekDay;
    }

    public static String getMonthDay(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getAbbrMonthDayFormat(locale).format(new Date(j10)) : UtcDates.getMediumNoYear(locale).format(new Date(j10));
    }

    public static String getMonthDayOfWeekDay(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getMonthWeekdayDayFormat(locale).format(new Date(j10)) : UtcDates.getFullFormat(locale).format(new Date(j10));
    }

    public static String getOptionalYearMonthDayOfWeekDay(long j10) {
        return isDateWithinCurrentYear(j10) ? getMonthDayOfWeekDay(j10) : getYearMonthDayOfWeekDay(j10);
    }

    public static String getYearContentDescription(Context context, int i10) {
        return UtcDates.getTodayCalendar().get(1) == i10 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i10)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i10));
    }

    public static String getYearMonth(long j10) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getYearMonthFormat(Locale.getDefault()).format(new Date(j10)) : DateUtils.formatDateTime(null, j10, 8228);
    }

    public static String getYearMonthDay(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getYearAbbrMonthDayFormat(locale).format(new Date(j10)) : UtcDates.getMediumFormat(locale).format(new Date(j10));
    }

    public static String getYearMonthDayOfWeekDay(long j10, Locale locale) {
        return Build.VERSION.SDK_INT >= 24 ? UtcDates.getYearMonthWeekdayDayFormat(locale).format(new Date(j10)) : UtcDates.getFullFormat(locale).format(new Date(j10));
    }

    private static boolean isDateWithinCurrentYear(long j10) {
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        Calendar utcCalendar = UtcDates.getUtcCalendar();
        utcCalendar.setTimeInMillis(j10);
        return todayCalendar.get(1) == utcCalendar.get(1);
    }

    public static String getDateString(long j10) {
        return getDateString(j10, null);
    }

    public static String getMonthDay(long j10) {
        return getMonthDay(j10, Locale.getDefault());
    }

    public static String getMonthDayOfWeekDay(long j10) {
        return getMonthDayOfWeekDay(j10, Locale.getDefault());
    }

    public static String getYearMonthDay(long j10) {
        return getYearMonthDay(j10, Locale.getDefault());
    }

    public static String getYearMonthDayOfWeekDay(long j10) {
        return getYearMonthDayOfWeekDay(j10, Locale.getDefault());
    }

    public static Pair<String, String> getDateRangeString(@Nullable Long l10, @Nullable Long l11) {
        return getDateRangeString(l10, l11, null);
    }
}
