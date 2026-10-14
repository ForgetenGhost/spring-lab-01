package kz.iitu.springlab.service;

import kz.iitu.springlab.annotation.Audited;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class CatalogService {

    public String findById(long id) {
        sleep(50); // simulating a database call
        return "Item no. " + id;
    }

    public List<String> findAll(int limit) {
        sleep(300); // a deliberately «slow» method
        return IntStream.rangeClosed(1, limit)
                .mapToObj(i -> "Item no. " + i)
                .toList();
    }

    @Audited
    public String remove(long id) {
        if (id <= 0) {
            throw new IllegalArgumentException("Invalid identifier: " + id);
        }
        return "Removed item no. " + id;
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}