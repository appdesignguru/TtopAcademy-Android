package com.ttopacademy.localdatasources.roomdb;

import androidx.room.TypeConverter;
import java.util.Date;

/** DateTime converter class for Room database. */
public class DateTimeConverters {

    /** Converts timestamp from Long to Date. */
    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    /** Converts timestamp from Date to Long. */
    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
