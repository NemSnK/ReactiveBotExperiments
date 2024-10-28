package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.request.SendMessage;
import org.example.model.Chats;
import org.example.repo.TutorialRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Main {
    private static final String TOKEN = "7315450619:AAFPJiJRy-J9ZPjNd1ELp3nGVyUnoZFrU7o";
    private final TutorialRepository repository;

    public Main(TutorialRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() {
        TelegramBot bot = new TelegramBot(TOKEN);
        bot.setUpdatesListener(updates -> {
            Flux.fromIterable(updates)
                    .log()
//                    .buffer()
//                    .flatMap()
//                    .subscribeOn(Schedulers.parallel())
                    .subscribe(update -> {
                        long chatId = update.message().chat().id();
                        var text = update.message().text();
                        Mono.just(new Chats(text, "Instruction for Mongo", true))
                                .log()
                                .flatMap(repository::save)
                                .subscribe();
//                        SendResponse response =
                        bot.execute(new SendMessage(chatId, "Добавлена запись: " + text));
                    });


            repository.findAll().doOnNext(
                    tutorial -> {
                        System.out.println(tutorial.getId() + ") tutorial is: " + tutorial.getTitle());
                    }
            ).subscribe();
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}