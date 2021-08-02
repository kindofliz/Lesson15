import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class Lesson15Notes {
    public static void main(String[] args) {

        
    //LOCALDATE EXAMPLE

        //Current Date
        LocalDate today = LocalDate.now();
        System.out.println("Current Date = " +today);

        //Creating LocalDate by providing inout arguments
        LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
        System.out.println("Specific date = " +firstDay_2014);

        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST = " + todayKolkata);

        //Getting date from the base date i.e 01/01/1970
        LocalDate dateFromBase = LocalDate.ofEpochDay(365);
        System.out.println("The 365th day from base date is = " + dateFromBase);

        LocalDate hudredDay2014 = LocalDate.ofYearDay(2014, 100);
        System.out.println("The 100th day of 2014 was = " + hudredDay2014);

        System.out.println();


    //LOCAL TIME EXAMPLE

        //Current Time
        LocalTime time = LocalTime.now();
        System.out.println("Current time is: " + time);

        //Creating LocalTime by providing input arguments
        LocalTime specificTime = LocalTime.of(12,20,25,40);
        System.out.println("Specific Time of Day = "+specificTime);

        //Current time in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Time in IST = "+timeKolkata);

        //Getting time specific time in seconds
        LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
        System.out.println("10000th second time= "+specificSecondTime);

        System.out.println();


    //LOCALDATETIME EXAMPLE

        //Current Date
        LocalDateTime todayy = LocalDateTime.now();
        System.out.println("Current DateTime = "+todayy);

        //Current Date using LocalDate and LocalTime
        todayy = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("Current DateTime = "+todayy);

        //Creating LocalDateTime by providing input arguments
        LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
        System.out.println("Specific Date = "+specificDate);

        //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
        LocalDateTime todayyKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
        System.out.println("Current Date in IST = "+todayyKolkata);

        //Getting date from the base date i.e 01/01/1970
        LocalDateTime dateFromBasee = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
        System.out.println("10000th second time from 01/01/1970 = "+dateFromBasee);

        System.out.println();



    //INSTANT (Instant class is used to work with machine readable time format. Instant stores date time in unix timestamp)

        //Current time stamp
        Instant timestamp = Instant.now();
        System.out.println("Current Timestamp = "+timestamp);

        //Instant from timestamp
        Instant specificTimee = Instant.ofEpochMilli(timestamp.toEpochMilli());
        System.out.println("Specific Time = "+specificTimee);

        //Duration example
        Duration thirtyDay = Duration.ofDays(30);
        System.out.println(thirtyDay);

        System.out.println();



    //Java 8 Date API Utilities (plus/minus days, weeks, months etc.)

        LocalDate todayyy = LocalDate.now();

        //Get the Year, check if it's leap year
        System.out.println("Year "+todayyy.getYear()+" is Leap Year? "+today.isLeapYear());

        //Compare two LocalDate for before and after
        System.out.println("Today is before 01/01/2015? "+todayyy.isBefore(LocalDate.of(2015,1,1)));

        //Create LocalDateTime from LocalDate
        System.out.println("Current Time = " + todayyy.atTime(LocalTime.now()));

        //plus and minus operations
        System.out.println("10 days after today will be "+today.plusDays(10));
        System.out.println("3 weeks after today will be "+today.plusWeeks(3));
        System.out.println("20 months after today will be "+today.plusMonths(20));

        System.out.println("10 days before today will be "+today.minusDays(10));
        System.out.println("3 weeks before today will be "+today.minusWeeks(3));
        System.out.println("20 months before today will be "+today.minusMonths(20));

        //Temporal adjusters for adjusting the dates
        System.out.println("First date of this month = "+today.with(TemporalAdjusters.firstDayOfMonth()));
        LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
        System.out.println("Last date of this year = "+lastDayOfYear);

        Period period = today.until(lastDayOfYear);
        System.out.println("Period Format = "+period);
        System.out.println("Months remaining in the year = "+period.getMonths());

        System.out.println();


    //Java 8 Date Parsing and Formatting

        //Format examples
        LocalDate date = LocalDate.now();

        //default format
        System.out.println("Default format of LocalDate = "+date);
        //specific format
        System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
        System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));


        LocalDateTime dateTime = LocalDateTime.now();

        //default format
        System.out.println("Default format of LocalDateTime = "+dateTime);
        //specific format
        System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
        System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

//        Instant timestamp = Instant.now();
//        //default format
//        System.out.println("Default format of Instant = "+timestamp);

//        //Parse examples
//        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
//                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
//        System.out.println("Default format after parsing = "+dt);

        System.out.println();


    //Java Date API Legacy Date Time Support (there are several utility methods through which we can convert Legacy classes to new classes and vice versa)

        //Date to Instant
        timestamp = new Date().toInstant();
        //Now we can convert Instant to LocalDateTime or other similar classes
        LocalDateTime dateeee = LocalDateTime.ofInstant(timestamp, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
        System.out.println("Date = "+dateeee);

        //Calendar to Instant
        Instant timeLegacy = Calendar.getInstance().toInstant();
        System.out.println(timeLegacy);

        //TimeZone to ZoneId
        ZoneId defaultZone = TimeZone.getDefault().toZoneId();
        System.out.println(defaultZone);

        //ZonedDateTime from specific Calendar
        ZonedDateTime gregorianCalendarDateTime = new GregorianCalendar().toZonedDateTime();
        System.out.println(gregorianCalendarDateTime);

        //Date API to Legacy classes
        Date dt = Date.from(Instant.now());
        System.out.println(dt);

        TimeZone tz = TimeZone.getTimeZone(defaultZone);
        System.out.println(tz);

        GregorianCalendar gc = GregorianCalendar.from(gregorianCalendarDateTime);
        System.out.println(gc);





        //PRACTICE TASK 3
        //ask the user to write the day, month and year of the birthday
        Scanner scanner = new Scanner(System.in);

        //?????


    }

}
