package com.alwo.service.impl;

import com.alwo.dto.OrderDataDto;
import com.alwo.model.OrderedProduct;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemplateService {

    private final TemplateEngine templateEngine;


    public TemplateService(TemplateEngine templateEngine){
        this.templateEngine = templateEngine;
    }


    public String orderEmail(List<OrderedProduct> orderedProducts) {
        Context context = new Context();
        context.setVariable("header", "Your order");
        context.setVariable("products", orderedProducts);
        String body = templateEngine.process("orderTemplate", context);
        return body;
    }

    public String newsletterEmail() {
        Context context = new Context();
        context.setVariable("header", "New great books on Alwo BOOKSTORE!!! :-)");
        context.setVariable("title", "Bestsellers!");
        context.setVariable("description", "The Best Books!!!");
        String body = templateEngine.process("template", context);
        return body;
    }
}

