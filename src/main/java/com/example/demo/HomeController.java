package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    @Autowired
    JobRepository jobRepository;

    @RequestMapping("/")
    public String jobList(Model model) {
        model.addAttribute("jobs", jobRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String addJob(Model model) {
        model.addAttribute("job", new Job());
        return "jobform";
    }

    @PostMapping("/procsearch")
    public String searchResult(Model model, @RequestParam(name="search") String search) {
        model.addAttribute("jobs", jobRepository.findJobByTitle(search));
        return "searchlist";
    }

    @PostMapping("/procjob")
    public String processForm(@ModelAttribute Job job, @RequestParam(name="postedDate") String postedDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // System.out.println(postedDate);
        String formattedDate = postedDate.substring(1, postedDate.length());
        LocalDateTime dateTime = LocalDateTime.parse(formattedDate, formatter);
        job.setPostedDate(dateTime);
        jobRepository.save(job);

        return "redirect:/";
    }

    @PostMapping("/proc_user_search")
    public String processUserSearch(Model model, @RequestParam(name="search") String search) {
        model.addAttribute("jobs", jobRepository.findJobByAuthor(search));
        return "returnuserlist";
    }

    @PostMapping("/jobdelete")
    public String jobDelete(Model model, @ModelAttribute Job job, String search) {
        Long remove = job.getId();
        System.out.println(remove);
        model.addAttribute("jobs", jobRepository.removeById(remove));
        return "returnuserlist";
    }
}
