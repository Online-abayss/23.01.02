package com.example.demo.Kitchen;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ServerController {

    private final KitchenService kitchenService;

    public ServerController(KitchenService kitchenService) {
        this.kitchenService = kitchenService;
    }

    @GetMapping(value = "/server" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> serveDishes() {
        return this.kitchenService.getDishes();
    }

    @GetMapping(value = "/server-dishes" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<Dish> deliverDishes() {
         return this.kitchenService.getDishes()
                 .map(dish -> dish.deliver(dish));
    }

    // 책에 있는 curl 실행시키는건 명령프로토콜 창 띄워서 거기서 입력하면 뜬다.
}
