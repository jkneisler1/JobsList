package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    JobRepository repository;

    @Override
    public void run(String... strings) {
        Job job;
        job = new Job(LocalDateTime.now(), "Plumber needed", "A backed up sink needs uncloging", "P. U. Waters", "301-555-9876");
        repository.save(job);

        job = new Job(LocalDateTime.now(), "Wanted Landscaper", "Flower beds need to be cleaned up", "Dr. T. Y. Garten", "301-555-6789");
        repository.save(job);

        job = new Job(LocalDateTime.now(), "Contractor", "Need an estimate on a kitchen remodel", "Joshua Woods", "301-555-1234");
        repository.save(job);

        job = new Job(LocalDateTime.now(), "Contractor", "Need an estimate on a bathroom remodel", "Joshua Woods", "301-555-1234");
        repository.save(job);
    }


}
