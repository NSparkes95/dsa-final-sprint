package com.theater.dsa_fs.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.theater.dsa_fs.model.TreeSnapshot;
import com.theater.dsa_fs.repository.TreeSnapshotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeSnapshotService {
    @Autowired
    private TreeSnapshotRepository treeSnapshotRepository;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public TreeSnapshot createTreeSnapshot(List<Integer> numbers) {
        // Build Tree
        TreeNode root = null;
        for (int num : numbers) {
            root = insertIntoTree(root, num);
        }

        // Serialize Tree
        String treeJson = "";
        try {
            treeJson = objectMapper.writeValueAsString(root);
        } catch (Exception e) {
            throw new RuntimeException("Could not serialize tree", e);
        }

        // Save Snapshot
        TreeSnapshot snapshot = new TreeSnapshot();
        snapshot.setInputNumbers(numbers.toString().replaceAll("[\\[\\]]", ""));
        snapshot.setTreeJson(treeJson);
        return treeSnapshotRepository.save(snapshot);
    }

    // Retrieve all snapshots
    public List<TreeSnapshot> getAllSnapshots() {
        return treeSnapshotRepository.findAll();
    }

    public static class TreeNode {
        public int value;
        public TreeNode left, right;
        public TreeNode(int value) {this.value = value;}
    }
    private TreeNode insertIntoTree (TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.value) {
            root.left = insertIntoTree(root.left, value);
        } else if (value > root.value) {
            root.right = insertIntoTree(root.right, value);
        }
        return root;
    }
}