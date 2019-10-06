package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        String formattedDate = postedDate.substring(postedDate.indexOf(',') + 1, postedDate.length());
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

    @RequestMapping(value="/jobManage/{id}", method=RequestMethod.POST, params="action")
    public String jobManage(@PathVariable("id") long id, Model model, @RequestParam(value="action", required=true) String action) {
        System.out.println(action);
        System.out.println(id);
        String returnStr = "";
        if (action.equals("edit")) {
            model.addAttribute("job", jobRepository.findById(id).get());
            returnStr = "jobform";
        }
        else if (action.equals("delete")) {
            jobRepository.deleteById(id);
            returnStr = "redirect:/";
        }
        else if (action.equals("details")) {
            model.addAttribute("job", jobRepository.findById(id).get());
            returnStr = "list";
        }
        return returnStr;
    }
}
