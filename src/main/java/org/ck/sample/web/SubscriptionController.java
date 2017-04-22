package org.ck.sample.web;

import org.ck.sample.util.SimpleTruncateUtil;
import org.ck.sample.util.TruncateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SubscriptionController {

    @Autowired
    TruncateUtil simple;

    @RequestMapping(value = "/subscribe")
    public String subscribe(HttpServletRequest request){

        String orderDetails = getOrderDetails(request);
        int size = getTruncateSize(request);
        String truncatedOrderDetails = simple.truncate(orderDetails,size);
        log(truncatedOrderDetails);
        return truncatedOrderDetails;
    }

    private int getTruncateSize(HttpServletRequest request) {
        String[] size = request.getParameterValues("size");
        if (size == null || size.length == 0)
            return 25;
        return Integer.valueOf(size[0]).shortValue();
    }

    private String getOrderDetails(HttpServletRequest request) {
        // appends all the details to form a
        String[] order = request.getParameterValues("order");
        return order[0];
    }

    private void log(String log) {
        // write to a log file
    }
}
