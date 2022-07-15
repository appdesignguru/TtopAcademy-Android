package com.ttopacademy.utitlities.fakes;

import com.ttopacademy.utitlities.interfaces.DateTimeUtility;
import java.util.Date;
import javax.inject.Inject;

/** FakeDateTimeUtility implementation class. */
public class FakeDateTimeUtility implements DateTimeUtility {

    /** Constructs a new instance. */
    @Inject
    public FakeDateTimeUtility() {

    }

    @Override
    public long numberOfDaysBetween(Date firstDate, Date secondDate) {
        return 0;
    }
}
