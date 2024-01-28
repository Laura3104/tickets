package com.tickets.tickets.web.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Custom handler exception resolver.
 */
@Component
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {

    /**
     * Resolve exception model and view.
     *
     * @param request  the request
     * @param response the response
     * @param handler  the handler
     * @param ex       the ex
     * @return the model and view
     */
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Map<String, Object> model = new HashMap<>();
        model.put("message", ex.getMessage());
        return new ModelAndView("error", model);
    }

    @Override
    public ModelAndView resolveException(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Object handler, Exception ex) {
        return null;
    }
}
