package Wrappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalendlyCalendar {

	WebDriver driver;

	private static SimpleDateFormat sdf = new SimpleDateFormat("hh:mma");
	
//    private By availableDates = By.xpath("//tbody[@data-testid='calendar-table']//td");
//    private By availableTime = By.xpath("//div[@role='listitem']/button");
    //private static By nextBtn = By.xpath("//button[text()='Next']");
    
    public static void selectDateAfterTwoDaysSkippingWeekends(List<WebElement> elements) {
        LocalDate targetDate = LocalDate.now().plusDays(2);

        // Skip Saturday and Sunday
        while (targetDate.getDayOfWeek() == DayOfWeek.SATURDAY ||
               targetDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            targetDate = targetDate.plusDays(1);
        }

        // Format the date string as required by your UI
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d"); // Adjust if needed
        String dateText = targetDate.format(formatter);

        System.out.println("Selecting date: " + dateText);

        // Use helper method to select date
        selectDateOnly(elements, dateText);
    }

    public static void selectDateOnly(List<WebElement> dateCells, String targetDateText) {
        for (WebElement cell : dateCells) {
            //WebElement button = cell.getAttribute(targetDateText);
            String ariaLabel = cell.getAttribute("aria-label");

            // Debug prints
            //System.out.println("Checking date cell aria-label: " + ariaLabel);

            if (ariaLabel != null && ariaLabel.contains(targetDateText)) {
                if (cell.isEnabled()) {
                    cell.click();
                    return;
                } else {
                    System.out.println("Button for date " + targetDateText + " is disabled.");
                }
            }
        }
        throw new RuntimeException("Date '" + targetDateText + "' not found or not selectable in calendar.");
    }
    
//    public static void selectDate(List<WebElement> element, String dateText) {
//        boolean dateFound = false;
//        //List<WebElement> dates = driver.findElements(availableDates);
//        for (WebElement date : element) {
//            if (date.getText().contains(dateText)) {
//                date.click();
//                dateFound = true;
//                break;
//            }
//        }
//
//        if (!dateFound) {
//            throw new RuntimeException("Date '" + dateText + "' not found in calendar.");
//        }
//    }

//    public static void selectTime( WebDriver driver, List<WebElement> element, String timeText) {
//        boolean timeFound = false;
//        //List<WebElement> times = driver.findElements(availableTime);
//        //WebElement calendlyNextBtn = driver.findElement(nextBtn);
//        for (WebElement time : element) {
//            if (time.getText().contains(timeText)) {
//                time.click();
//                //calendlyNextBtn.click();
//                timeFound = true;
//                break;
//            }
//        }
//
//        if (!timeFound) {
//            throw new RuntimeException("Time '" + timeText + "' not found in calendar.");
//        }
//    }
    
    public static void selectTime(WebDriver driver, List<WebElement> elements) {
    //List<WebElement> timeSlots = customer_landing_locators.get_calendlyCalendarTimes();
    if (!elements.isEmpty()) {
        elements.get(0).click();  // Or use your wrapper method
    }
    }
    
    
//    public static void selectTime(WebDriver driver, List<WebElement> element, String timeText) {
//        boolean timeFound = false;
//        WebElement nextAvailableTime = null;
//
//        Date requestedTime;
//        try {
//            requestedTime = sdf.parse(timeText);
//        } catch (ParseException e) {
//            throw new RuntimeException("Invalid time format for input: " + timeText);
//        }
//
//        for (WebElement time : element) {
//            String timeStr = time.getText().trim();
//            Date currentTime;
//            try {
//                currentTime = sdf.parse(timeStr);
//            } catch (ParseException e) {
//                // If time format doesn't match, skip this element
//                continue;
//            }
//
//            if (timeStr.equalsIgnoreCase(timeText)) {
//                // Exact time found - click and exit
//                time.click();
//                timeFound = true;
//                break;
//            }
//
//            // If time is after requested time, record as candidate for next available time
//            if (currentTime.after(requestedTime)) {
//                if (nextAvailableTime == null) {
//                    nextAvailableTime = time;
//                } else {
//                    // Keep the earliest next available time
//                    try {
//                        Date existingTime = sdf.parse(nextAvailableTime.getText().trim());
//                        if (currentTime.before(existingTime)) {
//                            nextAvailableTime = time;
//                        }
//                    } catch (ParseException ex) {
//                        // ignore parsing errors here
//                    }
//                }
//            }
//        }
//
//        if (!timeFound) {
//            if (nextAvailableTime != null) {
//                nextAvailableTime.click();
//                timeFound = true;
//            } else {
//                throw new RuntimeException("Time '" + timeText + "' not found, and no next available time slot.");
//            }
//        }
//    }
    
}

