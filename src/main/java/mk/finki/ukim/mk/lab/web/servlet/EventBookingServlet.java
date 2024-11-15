//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.service.EventBookingService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet (name="event-booking-servlet", urlPatterns = "/servlet/event/booking")
//public class EventBookingServlet extends HttpServlet {
//
//    private final SpringTemplateEngine templateEngine;
//
//    public EventBookingServlet(SpringTemplateEngine templateEngine) {
//        this.templateEngine = templateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange= JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context=new WebContext(webExchange);
//
//        templateEngine.process("bookingConfirmation.html",context,resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context=new WebContext(webExchange);
//        context.setVariable("nameForBooking",req.getRemoteHost());
//        context.setVariable("ipForBooking",req.getRemoteAddr());
//        context.setVariable("eventName",req.getParameter("radio1"));
//        context.setVariable("numTickets",req.getParameter("numTickets"));
//        templateEngine.process("bookingConfirmation.html",context,resp.getWriter());
//    }
//}
