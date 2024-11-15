//package mk.finki.ukim.mk.lab.web;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Event;
//import mk.finki.ukim.mk.lab.service.EventService;
//import mk.finki.ukim.mk.lab.service.Impl.EventServiceImpl;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//@WebServlet(name="EventListServlet",urlPatterns = "/servlet/event")
//public class EventListServlet extends HttpServlet {
//    private final EventService eventService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public EventListServlet(EventService eventService, SpringTemplateEngine springTemplateEngine) {
//        this.eventService = eventService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Event> events;
//        String searchName = req.getParameter("searchName");
//        String searchRating = req.getParameter("searchRating");
//
//        //Search name i search rating ne se null
//        if (searchName != null && searchRating != null && !Objects.equals(searchRating,"")) {
//            events = eventService.searchByName(searchName).stream()
//                    .filter(e->e.getPopularityScore()>=Double.parseDouble(searchRating))
//                    .collect(Collectors.toList());
//        }
//        //Search name ne e null, search rating e null
//        else if (searchName != null) {
//            events = eventService.searchByName(searchName);
//        }
//        //Search rating ne e null, search rating e null
//        else if (searchRating != null && !Objects.equals(searchRating,"")) {
//            events = eventService.listAll().stream()
//                    .filter(e->e.getPopularityScore()>=Double.parseDouble(searchRating))
//                    .collect(Collectors.toList());
//        }
//        //Dvata parametri se null
//        else{
//            events=eventService.listAll();
//        }
//
//        IWebExchange webExchange= JakartaServletWebApplication
//                .buildApplication(req.getServletContext())
//                .buildExchange(req,resp);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("events",events);
//        springTemplateEngine.process("listEvents.html",context,resp.getWriter());
//    }
//
//}
