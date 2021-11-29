package org.launchcode.techjobs.mvc.controllers;

import org.launchcode.techjobs.mvc.models.Job;
import org.launchcode.techjobs.mvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

import static org.launchcode.techjobs.mvc.controllers.ListController.columnChoices;


/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.
    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
        ArrayList<Job> jobs;
        if (searchTerm.equals("all")) {
            jobs = JobData.findAll();
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
        }
        model.addAttribute("columns", columnChoices);
        model.addAttribute("jobs", jobs);
       return "search";
    }
    //@PostMapping(value="")
    //PostMapping because the form in the search.html says "post" value="" because RequestMapping("search")
   // public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm){
      //  ArrayList<Job> jobs;

//        if  the searchTerm is equal to All Jobs then jobs = JobData.findAll()...
//           then add  model.addAttribute("title", "All Jobs");
//         else
//            jobs = JobData.by the searchType at least and searchTerm if available?
//            model.addAttribute("title", "Jobs with " + columnChoices.whatever
//            the searchType + ": " + searchTerm value if present?);
       }

