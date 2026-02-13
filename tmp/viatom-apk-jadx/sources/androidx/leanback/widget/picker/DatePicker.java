package androidx.leanback.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.a;
import androidx.leanback.R;
import androidx.leanback.widget.picker.PickerUtility;
import com.google.android.material.timepicker.TimeModel;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import z8.f;

/* compiled from: r8-map-id-41d83e727936d3330b608d725ba7b7c2e83c0817dc12ceb2aead6fdefac83833 */
/* loaded from: classes.dex */
public class DatePicker extends Picker {
    private static final int[] DATE_FIELDS = {5, 2, 1};
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String LOG_TAG = "DatePicker";
    private int mColDayIndex;
    private int mColMonthIndex;
    private int mColYearIndex;
    private PickerUtility.DateConstant mConstant;
    private Calendar mCurrentDate;
    private final DateFormat mDateFormat;
    private String mDatePickerFormat;
    private PickerColumn mDayColumn;
    private Calendar mMaxDate;
    private Calendar mMinDate;
    private PickerColumn mMonthColumn;
    private Calendar mTempDate;
    private PickerColumn mYearColumn;

    @SuppressLint({"CustomViewStyleable"})
    public DatePicker(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.mDateFormat = new SimpleDateFormat(DATE_FORMAT, Locale.getDefault());
        updateCurrentLocale();
        int[] iArr = R.styleable.lbDatePicker;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, 0, 0);
        try {
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_android_minDate);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_android_maxDate);
            String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.lbDatePicker_datePickerFormat);
            typedArrayObtainStyledAttributes.recycle();
            this.mTempDate.clear();
            boolean zIsEmpty = TextUtils.isEmpty(string);
            Calendar calendar = this.mTempDate;
            if (zIsEmpty) {
                calendar.set(1900, 0, 1);
            } else if (!parseDate(string, calendar)) {
                this.mTempDate.set(1900, 0, 1);
            }
            this.mMinDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
            this.mTempDate.clear();
            boolean zIsEmpty2 = TextUtils.isEmpty(string2);
            Calendar calendar2 = this.mTempDate;
            if (zIsEmpty2) {
                calendar2.set(2100, 0, 1);
            } else if (!parseDate(string2, calendar2)) {
                this.mTempDate.set(2100, 0, 1);
            }
            this.mMaxDate.setTimeInMillis(this.mTempDate.getTimeInMillis());
            setDatePickerFormat(TextUtils.isEmpty(string3) ? new String(android.text.format.DateFormat.getDateFormatOrder(context)) : string3);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private static boolean isAnyOf(char c10, char[] cArr) {
        for (char c11 : cArr) {
            if (c10 == c11) {
                return true;
            }
        }
        return false;
    }

    private boolean isNewDate(int i10, int i11, int i12) {
        return (this.mCurrentDate.get(1) == i10 && this.mCurrentDate.get(2) == i12 && this.mCurrentDate.get(5) == i11) ? false : true;
    }

    private boolean parseDate(String str, Calendar calendar) {
        try {
            calendar.setTime(this.mDateFormat.parse(str));
            return true;
        } catch (ParseException unused) {
            Log.w(LOG_TAG, "Date: " + str + " not in format: MM/dd/yyyy");
            return false;
        }
    }

    private void updateCurrentLocale() {
        PickerUtility.DateConstant dateConstantInstance = PickerUtility.getDateConstantInstance(Locale.getDefault(), getContext().getResources());
        this.mConstant = dateConstantInstance;
        this.mTempDate = PickerUtility.getCalendarForLocale(this.mTempDate, dateConstantInstance.locale);
        this.mMinDate = PickerUtility.getCalendarForLocale(this.mMinDate, this.mConstant.locale);
        this.mMaxDate = PickerUtility.getCalendarForLocale(this.mMaxDate, this.mConstant.locale);
        this.mCurrentDate = PickerUtility.getCalendarForLocale(this.mCurrentDate, this.mConstant.locale);
        PickerColumn pickerColumn = this.mMonthColumn;
        if (pickerColumn != null) {
            pickerColumn.setStaticLabels(this.mConstant.months);
            setColumnAt(this.mColMonthIndex, this.mMonthColumn);
        }
    }

    private static boolean updateMax(PickerColumn pickerColumn, int i10) {
        if (i10 == pickerColumn.getMaxValue()) {
            return false;
        }
        pickerColumn.setMaxValue(i10);
        return true;
    }

    private static boolean updateMin(PickerColumn pickerColumn, int i10) {
        if (i10 == pickerColumn.getMinValue()) {
            return false;
        }
        pickerColumn.setMinValue(i10);
        return true;
    }

    private void updateSpinners(final boolean z9) {
        post(new Runnable() { // from class: androidx.leanback.widget.picker.DatePicker.1
            @Override // java.lang.Runnable
            public void run() {
                DatePicker.this.updateSpinnersImpl(z9);
            }
        });
    }

    @VisibleForTesting
    public List<CharSequence> extractSeparators() {
        String bestYearMonthDayPattern = getBestYearMonthDayPattern(this.mDatePickerFormat);
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] cArr = {'Y', 'y', 'M', 'm', 'D', 'd'};
        boolean z9 = false;
        char c10 = 0;
        for (int i10 = 0; i10 < bestYearMonthDayPattern.length(); i10++) {
            char cCharAt = bestYearMonthDayPattern.charAt(i10);
            if (cCharAt != ' ') {
                if (cCharAt != '\'') {
                    if (z9 || !isAnyOf(cCharAt, cArr)) {
                        sb.append(cCharAt);
                    } else if (cCharAt != c10) {
                        arrayList.add(sb.toString());
                        sb.setLength(0);
                    }
                    c10 = cCharAt;
                } else if (z9) {
                    z9 = false;
                } else {
                    sb.setLength(0);
                    z9 = true;
                }
            }
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    @VisibleForTesting
    public String getBestYearMonthDayPattern(String str) {
        String bestDateTimePattern = android.text.format.DateFormat.getBestDateTimePattern(this.mConstant.locale, str);
        return TextUtils.isEmpty(bestDateTimePattern) ? DATE_FORMAT : bestDateTimePattern;
    }

    public long getDate() {
        return this.mCurrentDate.getTimeInMillis();
    }

    public String getDatePickerFormat() {
        return this.mDatePickerFormat;
    }

    public long getMaxDate() {
        return this.mMaxDate.getTimeInMillis();
    }

    public long getMinDate() {
        return this.mMinDate.getTimeInMillis();
    }

    @Override // androidx.leanback.widget.picker.Picker
    public final void onColumnValueChanged(int i10, int i11) {
        this.mTempDate.setTimeInMillis(this.mCurrentDate.getTimeInMillis());
        int currentValue = getColumnAt(i10).getCurrentValue();
        if (i10 == this.mColDayIndex) {
            this.mTempDate.add(5, i11 - currentValue);
        } else if (i10 == this.mColMonthIndex) {
            this.mTempDate.add(2, i11 - currentValue);
        } else {
            if (i10 != this.mColYearIndex) {
                f.a();
                return;
            }
            this.mTempDate.add(1, i11 - currentValue);
        }
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5));
    }

    public void setDate(int i10, int i11, int i12, boolean z9) {
        if (isNewDate(i10, i11, i12)) {
            this.mCurrentDate.set(i10, i11, i12);
            boolean zBefore = this.mCurrentDate.before(this.mMinDate);
            Calendar calendar = this.mCurrentDate;
            if (zBefore) {
                calendar.setTimeInMillis(this.mMinDate.getTimeInMillis());
            } else if (calendar.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(z9);
        }
    }

    public void setDatePickerFormat(String str) {
        if (TextUtils.isEmpty(str)) {
            str = new String(android.text.format.DateFormat.getDateFormatOrder(getContext()));
        }
        if (TextUtils.equals(this.mDatePickerFormat, str)) {
            return;
        }
        this.mDatePickerFormat = str;
        List<CharSequence> listExtractSeparators = extractSeparators();
        if (listExtractSeparators.size() != str.length() + 1) {
            a.k("Separators size: ", listExtractSeparators.size(), " must equal the size of datePickerFormat: ", str.length(), " + 1");
            return;
        }
        setSeparators(listExtractSeparators);
        this.mDayColumn = null;
        this.mMonthColumn = null;
        this.mYearColumn = null;
        this.mColMonthIndex = -1;
        this.mColDayIndex = -1;
        this.mColYearIndex = -1;
        String upperCase = str.toUpperCase(this.mConstant.locale);
        ArrayList arrayList = new ArrayList(3);
        for (int i10 = 0; i10 < upperCase.length(); i10++) {
            char cCharAt = upperCase.charAt(i10);
            if (cCharAt == 'D') {
                if (this.mDayColumn != null) {
                    com.google.gson.internal.a.n("datePicker format error");
                    return;
                }
                PickerColumn pickerColumn = new PickerColumn();
                this.mDayColumn = pickerColumn;
                arrayList.add(pickerColumn);
                this.mDayColumn.setLabelFormat(TimeModel.ZERO_LEADING_NUMBER_FORMAT);
                this.mColDayIndex = i10;
            } else if (cCharAt != 'M') {
                if (cCharAt != 'Y') {
                    com.google.gson.internal.a.n("datePicker format error");
                    return;
                }
                if (this.mYearColumn != null) {
                    com.google.gson.internal.a.n("datePicker format error");
                    return;
                }
                PickerColumn pickerColumn2 = new PickerColumn();
                this.mYearColumn = pickerColumn2;
                arrayList.add(pickerColumn2);
                this.mColYearIndex = i10;
                this.mYearColumn.setLabelFormat(TimeModel.NUMBER_FORMAT);
            } else {
                if (this.mMonthColumn != null) {
                    com.google.gson.internal.a.n("datePicker format error");
                    return;
                }
                PickerColumn pickerColumn3 = new PickerColumn();
                this.mMonthColumn = pickerColumn3;
                arrayList.add(pickerColumn3);
                this.mMonthColumn.setStaticLabels(this.mConstant.months);
                this.mColMonthIndex = i10;
            }
        }
        setColumns(arrayList);
        updateSpinners(false);
    }

    public void setMaxDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        if (this.mTempDate.get(1) != this.mMaxDate.get(1) || this.mTempDate.get(6) == this.mMaxDate.get(6)) {
            this.mMaxDate.setTimeInMillis(j10);
            if (this.mCurrentDate.after(this.mMaxDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMaxDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public void setMinDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        if (this.mTempDate.get(1) != this.mMinDate.get(1) || this.mTempDate.get(6) == this.mMinDate.get(6)) {
            this.mMinDate.setTimeInMillis(j10);
            if (this.mCurrentDate.before(this.mMinDate)) {
                this.mCurrentDate.setTimeInMillis(this.mMinDate.getTimeInMillis());
            }
            updateSpinners(false);
        }
    }

    public void updateSpinnersImpl(boolean z9) {
        int[] iArr = {this.mColDayIndex, this.mColMonthIndex, this.mColYearIndex};
        boolean z10 = true;
        boolean z11 = true;
        for (int length = DATE_FIELDS.length - 1; length >= 0; length--) {
            int i10 = iArr[length];
            if (i10 >= 0) {
                int i11 = DATE_FIELDS[length];
                PickerColumn columnAt = getColumnAt(i10);
                boolean zUpdateMin = (z10 ? updateMin(columnAt, this.mMinDate.get(i11)) : updateMin(columnAt, this.mCurrentDate.getActualMinimum(i11))) | (z11 ? updateMax(columnAt, this.mMaxDate.get(i11)) : updateMax(columnAt, this.mCurrentDate.getActualMaximum(i11)));
                z10 &= this.mCurrentDate.get(i11) == this.mMinDate.get(i11);
                z11 &= this.mCurrentDate.get(i11) == this.mMaxDate.get(i11);
                if (zUpdateMin) {
                    setColumnAt(iArr[length], columnAt);
                }
                setColumnValue(iArr[length], this.mCurrentDate.get(i11), z9);
            }
        }
    }

    public void setDate(long j10) {
        this.mTempDate.setTimeInMillis(j10);
        setDate(this.mTempDate.get(1), this.mTempDate.get(2), this.mTempDate.get(5), false);
    }

    private void setDate(int i10, int i11, int i12) {
        setDate(i10, i11, i12, false);
    }

    public DatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.datePickerStyle);
    }
}
