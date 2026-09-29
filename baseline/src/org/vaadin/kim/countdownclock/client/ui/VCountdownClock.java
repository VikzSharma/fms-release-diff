/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gwt.dom.client.Document
 *  com.google.gwt.dom.client.Element
 *  com.google.gwt.user.client.Timer
 *  com.google.gwt.user.client.ui.Widget
 */
package org.vaadin.kim.countdownclock.client.ui;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Widget;
import java.util.ArrayList;
import java.util.List;

public class VCountdownClock
extends Widget {
    public static final String TAGNAME = "countdownclock";
    public static final String CLASSNAME = "v-countdownclock";
    private long time = 0L;
    protected Counter counter = new Counter();
    protected List<TimeString> formatStrings = new ArrayList<TimeString>();
    protected String formatPrefix = "";
    protected List<TimeType> formatsPresent = new ArrayList<TimeType>();
    protected List<CountdownEndedListener> listeners = new ArrayList<CountdownEndedListener>();
    protected int oneDay = 86400000;
    protected int anHour = 3600000;
    protected int aMinute = 60000;
    protected int aSecond = 1000;
    protected int timerInterval = 1000;
    private boolean neglectHigher = false;

    public VCountdownClock() {
        this.setElement((Element)Document.get().createDivElement());
        this.setStyleName(CLASSNAME);
    }

    protected void setNeglectHigherUnits(boolean bl) {
        this.neglectHigher = bl;
    }

    protected void setTimeFormat(String string) {
        this.formatsPresent.clear();
        this.formatStrings.clear();
        this.formatPrefix = "";
        while (string.length() > 0) {
            int n = string.indexOf("%");
            if (n >= 0) {
                TimeString timeString;
                String string2 = n > 0 ? string.substring(0, n) : "";
                string = string.substring(n);
                String string3 = string.substring(0, 2);
                int n2 = 2;
                if (string3.equals("%d")) {
                    timeString = new TimeString(TimeType.DAYS);
                    this.formatStrings.add(timeString);
                    this.formatsPresent.add(TimeType.DAYS);
                } else if (string3.equals("%h")) {
                    timeString = new TimeString(TimeType.HOURS);
                    this.formatStrings.add(timeString);
                    this.formatsPresent.add(TimeType.HOURS);
                } else if (string3.equals("%m")) {
                    timeString = new TimeString(TimeType.MINUTES);
                    this.formatStrings.add(timeString);
                    this.formatsPresent.add(TimeType.MINUTES);
                } else if (string3.equals("%s")) {
                    timeString = new TimeString(TimeType.SECONDS);
                    this.formatStrings.add(timeString);
                    this.formatsPresent.add(TimeType.SECONDS);
                } else if (string.substring(0, 3).equals("%ts")) {
                    timeString = new TimeString(TimeType.TENTH_OF_A_SECONDS);
                    this.formatStrings.add(timeString);
                    this.formatsPresent.add(TimeType.TENTH_OF_A_SECONDS);
                    n2 = 3;
                } else {
                    string2 = string2 + string3;
                }
                if (this.formatStrings.size() <= 1) {
                    this.formatPrefix = string2;
                } else {
                    this.formatStrings.get(this.formatStrings.size() - 2).setPostfix(string2);
                }
                string = string.substring(n2);
                continue;
            }
            if (this.formatStrings.size() < 1) {
                this.formatPrefix = string;
            } else {
                this.formatStrings.get(this.formatStrings.size() - 1).setPostfix(string);
            }
            string = "";
        }
        if (this.formatsPresent.contains((Object)TimeType.TENTH_OF_A_SECONDS)) {
            this.timerInterval = 100;
        } else if (this.formatsPresent.contains((Object)TimeType.SECONDS)) {
            this.timerInterval = this.aSecond;
        } else if (this.formatsPresent.contains((Object)TimeType.MINUTES)) {
            this.timerInterval = this.aMinute;
        } else if (this.formatsPresent.contains((Object)TimeType.HOURS)) {
            this.timerInterval = this.anHour;
        } else if (this.formatsPresent.contains((Object)TimeType.DAYS)) {
            this.timerInterval = this.oneDay;
        }
    }

    public void startClock() {
        this.counter.scheduleRepeating(this.timerInterval);
        this.counter.run();
    }

    protected void updateLabel() {
        String string = "";
        if (this.formatPrefix != null) {
            string = string + this.formatPrefix;
        }
        for (TimeString timeString : this.formatStrings) {
            string = string + timeString.getValue(this.getTime());
        }
        this.getElement().setInnerHTML(string);
    }

    protected void onDetach() {
        super.onDetach();
        this.counter.cancel();
    }

    public void fireEndEvent() {
        for (CountdownEndedListener countdownEndedListener : this.listeners) {
            countdownEndedListener.countdownEnded();
        }
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long l) {
        this.time = l;
    }

    public void addListener(CountdownEndedListener countdownEndedListener) {
        this.listeners.add(countdownEndedListener);
    }

    public static interface CountdownEndedListener {
        public void countdownEnded();
    }

    protected static enum TimeType {
        DAYS,
        HOURS,
        MINUTES,
        SECONDS,
        TENTH_OF_A_SECONDS;

    }

    protected class TimeString {
        protected String postfix = "";
        protected TimeType type = null;

        public TimeString(TimeType timeType) {
            this.type = timeType;
        }

        public void setPostfix(String string) {
            this.postfix = string;
        }

        public String getPostfix() {
            return this.postfix;
        }

        public String getValue(long l) {
            if (this.type.equals((Object)TimeType.DAYS)) {
                return this.getDays(l) + this.postfix;
            }
            if (this.type.equals((Object)TimeType.HOURS)) {
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.DAYS)) {
                    l -= this.getDays(l) * (long)VCountdownClock.this.oneDay;
                }
                return this.getHours(l) + this.postfix;
            }
            if (this.type.equals((Object)TimeType.MINUTES)) {
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.DAYS)) {
                    l -= this.getDays(l) * (long)VCountdownClock.this.oneDay;
                }
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.HOURS)) {
                    l -= this.getHours(l) * (long)VCountdownClock.this.anHour;
                }
                return this.getMinutes(l) + this.postfix;
            }
            if (this.type.equals((Object)TimeType.SECONDS)) {
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.DAYS)) {
                    l -= this.getDays(l) * (long)VCountdownClock.this.oneDay;
                }
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.HOURS)) {
                    l -= this.getHours(l) * (long)VCountdownClock.this.anHour;
                }
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.MINUTES)) {
                    l -= this.getMinutes(l) * (long)VCountdownClock.this.aMinute;
                }
                return this.getSeconds(l) + this.postfix;
            }
            if (this.type.equals((Object)TimeType.TENTH_OF_A_SECONDS)) {
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.DAYS)) {
                    l -= this.getDays(l) * (long)VCountdownClock.this.oneDay;
                }
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.HOURS)) {
                    l -= this.getHours(l) * (long)VCountdownClock.this.anHour;
                }
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.MINUTES)) {
                    l -= this.getMinutes(l) * (long)VCountdownClock.this.aMinute;
                }
                if (VCountdownClock.this.neglectHigher || VCountdownClock.this.formatsPresent.contains((Object)TimeType.SECONDS)) {
                    l -= this.getSeconds(l) * (long)VCountdownClock.this.aSecond;
                }
                return Math.round(l / 100L) + this.postfix;
            }
            return "";
        }

        public String toString() {
            return this.type.name();
        }

        protected long getDays(long l) {
            return (long)Math.floor(l / (long)VCountdownClock.this.oneDay);
        }

        protected long getHours(long l) {
            return (long)Math.floor(l / (long)VCountdownClock.this.anHour);
        }

        protected long getMinutes(long l) {
            return (long)Math.floor(l / (long)VCountdownClock.this.aMinute);
        }

        protected long getSeconds(long l) {
            return (long)Math.floor(l / (long)VCountdownClock.this.aSecond);
        }
    }

    protected class Counter
    extends Timer {
        protected Counter() {
        }

        public void run() {
            VCountdownClock.this.setTime(VCountdownClock.this.getTime() - (long)VCountdownClock.this.timerInterval);
            if (VCountdownClock.this.getTime() <= 0L) {
                this.cancel();
                VCountdownClock.this.fireEndEvent();
                VCountdownClock.this.setTime(0L);
            }
            VCountdownClock.this.updateLabel();
        }
    }
}

