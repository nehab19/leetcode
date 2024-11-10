package guru.springframework.spring5webapp.leetcode.binarytrees;

import java.util.*;

public class DistanceKBinaryTree {
    Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        addParent(root);
        BFS(target, k, result);
        return result;
    }

    private void BFS(TreeNode target, int k, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(target.val);

        while (!queue.isEmpty()) {
            int size = queue.size();
            // means it has reached the level
            if (k == 0) {
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode currentNode = queue.poll();

                //check left child
                if (currentNode.left != null && !visitedNodes.contains(currentNode.left.val)) {
                    queue.offer(currentNode.left);
                    visitedNodes.add(currentNode.left.val);
                }

                //check right child
                if (currentNode.right != null && !visitedNodes.contains(currentNode.right.val)) {
                    queue.offer(currentNode.right);
                    visitedNodes.add(currentNode.right.val);
                }

                //check for parent
                if (parentMap.containsKey(currentNode) && !visitedNodes.contains(parentMap.get(currentNode).val)) {
                    queue.offer(parentMap.get(currentNode));
                    visitedNodes.add(parentMap.get(currentNode).val);
                }
            }
            k--;
        }

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            result.add(temp.val);
        }
    }

    //make map with parent nodes
    private void addParent(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parentMap.put(root.left, root);
            addParent(root.left);
        }

        if (root.right != null) {
            parentMap.put(root.right, root);
            addParent(root.right);
        }
    }
}
