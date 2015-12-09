/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import smarthomes.controllers.BookingController;
import smarthomes.domain.Booking;

/**
 *
 * @author Kelli
 */
public class BookingControllerTests {
    BookingController bcon ;
    public BookingControllerTests() {
        bcon = new BookingController();
        
    }
    
//    @Test
//    public void testDateConversion(){
//        Date d = bcon.getDateFromString("12/12/2015");
//        assertEquals("2015-12-12",d);
//    }
//    
//    @Test
//    public void testTimeConversion(){
//        Time d = bcon.getTimeFromString("11:30pm");
//        assertEquals("11:30:00",d);
//    }
    
    @Test
    public void getBooking(){
        List<Booking> bookings = bcon.getAllBookings();
        Assert.assertEquals(7,bookings.size());
    }
}
