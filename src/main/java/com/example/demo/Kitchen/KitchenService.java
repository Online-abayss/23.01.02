package com.example.demo.Kitchen;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

@Service
public class KitchenService {

    // 요리 스트림 생성

//    Flux<Dish> getDishes() {
//        return Flux.<Dish> generate(sink -> sink.next(randomDish()))
//                .delayElements(Duration.ofMillis(250));
//    }

    // 요리 무작위 선택

    private Dish randomDish() {
        return menu.get(picker.nextInt(menu.size()));
    }

    private List<Dish> menu = Arrays.asList(
            new Dish("Sssame chicken"),
            new Dish("Lo mein noodles, plain"),
            new Dish("Sweet & sour beef"));

    private Random picker = new Random();
}
