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
        //job = new Job(LocalDateTime.of(2019, 10, 4, 11, 45), "Plumber needed", "A backed up sink needs uncloging", "P. U. Waters", "301-555-9876");
        //CharSequence j1 = new CharSequence("2019-10-4T11:45:10");
        //job = new Job(LocalDateTime.parse("2019-10-4T11:45:10"), "Plumber needed", "A backed up sink needs uncloging", "P. U. Waters", "301-555-9876");
        job = new Job(LocalDateTime.now(), "Plumber needed", "A backed up sink needs uncloging", "P. U. Waters", "301-555-9876");
        repository.save(job);

        //job = new Job(LocalDateTime.of(2019, 10, 5,12, 15), "Wanted Landscaper", "Flower beds need to be cleaned up", "Dr. T. Y. Garten", "301-555-6789");
        //job = new Job(LocalDateTime.parse("2019-10-5T12:15:10"), "Wanted Landscaper", "Flower beds need to be cleaned up", "Dr. T. Y. Garten", "301-555-6789");
        job = new Job(LocalDateTime.now(), "Wanted Landscaper", "Flower beds need to be cleaned up", "Dr. T. Y. Garten", "301-555-6789");
        repository.save(job);

        //job = new Job(LocalDateTime.of(2019, 10, 5,15, 10), "Contractor", "Need an estimate on a kitchen remodel", "Joshua Woods", "301-555-1234");
        //job = new Job(LocalDateTime.parse("2019-10-5T15:10:10"), "Contractor", "Need an estimate on a kitchen remodel", "Joshua Woods", "301-555-1234");
        job = new Job(LocalDateTime.now(), "Contractor", "Need an estimate on a kitchen remodel", "Joshua Woods", "301-555-1234");
        repository.save(job);

        //job = new Job(LocalDateTime.of(2019, 10, 25,15, 10), "Contractor", "Need an estimate on a bathroom remodel", "Joshua Woods", "301-555-1234");
        //job = new Job(LocalDateTime.parse("2019-10-25T15:10:10"), "Contractor", "Need an estimate on a bathroom remodel", "Joshua Woods", "301-555-1234");
        job = new Job(LocalDateTime.now(), "Contractor", "Need an estimate on a bathroom remodel", "Joshua Woods", "301-555-1234");
        repository.save(job);
    }


}
