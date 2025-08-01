package com.theater.dsa_fs.controller;

import com.theater.dsa_fs.model.TreeSnapshot;
import com.theater.dsa_fs.service.TreeSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class TreeSnapshotController {
    @Autowired
    private TreeSnapshotService treeSnapshotService;

    // Shot HTML form for number input
    @GetMapping("/enter-numbers")
    public String showNumberForm() {
        return " enter-numbers";
    }

    // Process input numbers and display the tree snapshot
    @PostMapping("/process-numbers")
    public String processNumbers(@RequestParam("numbers") String numbers, Model model) {
        // Split the input string by commas and convert to a list of integers
        List<Integer> numberList = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // Create a TreeSnapshot object
        TreeSnapshot treeSnapshot = treeSnapshotService.createTreeSnapshot(numberList);

        // Save the snapshot using the service
        treeSnapshotService.saveSnapshot(treeSnapshot);

        // Add the snapshot to the model for display
        model.addAttribute("snapshot", treeSnapshot);

        return "tree-snapshot";
    }

    // Display the saved snapshots
    @GetMapping("/previous-snapshots")
    public string showPreviousSnapshots(Model model) {
        // Retrieve all saved snapshots
        List<TreeSnapshot> snapshots = treeSnapshotService.getAllSnapshots();

        // Add the snapshots to the model
        model.addAttribute("snapshots", snapshots);

        return "previous-snapshots";
    }
}