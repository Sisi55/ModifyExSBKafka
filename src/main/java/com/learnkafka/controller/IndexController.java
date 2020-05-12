package com.learnkafka.controller;

import com.learnkafka.config.auth.LoginUser;
import com.learnkafka.config.auth.dto.SessionUser;
import com.learnkafka.elasticdomain.UserAction;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    //    private final HttpSession httpSession;
    private final ElasticsearchRestTemplate template;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        /*
userName
clickCount
shopCount
*/

//        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        UserAction shopListAction = template
                .queryForObject(GetQuery.getById("{\"userName\":\"sisi\",\"actionType\":\"shoplist\"}"),
                        UserAction.class);
        model.addAttribute("shopCount", shopListAction.getCount());

        UserAction clickAction = template
                .queryForObject(GetQuery.getById("{\"userName\":\"sisi\",\"actionType\":\"click\"}"),
                        UserAction.class);
        model.addAttribute("clickCount", clickAction.getCount());


        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/test")
    public String test_ConcreteProducts(Model model, @LoginUser SessionUser user) {


        return "test";
    }
}
