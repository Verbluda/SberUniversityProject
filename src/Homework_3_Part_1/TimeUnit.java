package Homework_3_Part_1;

public class TimeUnit {
    private int hours;
    private int mins;
    private int secs;

    public TimeUnit() {
        this.hours = 0;
        this.mins = 0;
        this.secs = 0;
    }

    public TimeUnit(int hours) {
        this();
        if (hours >= 24) {
            System.out.printf("На часах может быть от 0 до 23 часов, установить %d часов не получилось, было применено значение по умолчанию.\n", hours);
        }
        else if (hours < 0) {
            System.out.println("Количество часов не может быть отрицательным, было применено значение по умолчанию.");
        }
        else {
            this.hours = hours;
        }
    }
    public TimeUnit(int hours, int mins) {
        this(hours);
        if (mins >= 60) {
            System.out.printf("На часах может быть от 0 до 59 минут, установить %d минут не получилось, было применено значение по умолчанию.\n", mins);
        }
        else if (mins < 0) {
            System.out.println("Количество минут не может быть отрицательным, было применено значение по умолчанию.");
        }
        else {
            this.mins = mins;
        }
    }
    public TimeUnit(int hours, int mins, int secs) {
        this(hours, mins);
        if (secs >= 60) {
            System.out.printf("На часах может быть от 0 до 59 секунд, установить %d секунд не получилось, было применено значение по умолчанию.\n", secs);
        }
        else if (secs < 0) {
            System.out.println("Количество секунд не может быть отрицательным, было применено значение по умолчанию.");
        }
        else {
            this.secs = secs;
        }
    }
    public void get24FormatTime() {
        System.out.printf("%02d:%02d:%02d\n", hours, mins, secs);
    }
    public void ge12FormatTime() {
        System.out.printf("%02d:%02d:%02d ", hours % 12, mins, secs);
        if (hours < 12) {
            System.out.println("am");
        } else {
            System.out.println("pm");
        }
    }
    public void addTime(int hours, int mins, int secs) {
        if (secs >= 60 || mins >= 60 || hours >= 24) {
            System.out.printf("На часах может быть от 0 до 59 секунд или минут и от 0 до 23 часов, прибавить: %02d:%02d:%02d - к установленному времени не получилось, введите корректные данные.\n", hours, mins, secs);
        } else if (secs < 0 || mins < 0 || hours < 0) {
            System.out.println("Время не может быть отрицательным, прибавить значения к установленному времени не получилось, введите корректные данные.");
        } else {
            this.secs += secs;
            if (this.secs >= 60) {
                this.mins += this.secs / 60;
                this.secs %= 60;
            }
            this.mins += mins;
            if (this.mins >= 60) {
                this.hours += this.mins / 60;
                this.mins %= 60;
            }
            this.hours += hours;
            if (this.hours >= 24) {
                System.out.println("Наступили следующие сутки.");
                this.hours %= 24;
            }
        }
    }
}
