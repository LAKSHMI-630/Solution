import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class BalanceBSTWithInput {

    // Build BST from level order input (array with "null")
    public static TreeNode buildTreeFromLevelOrder(List<String> nodes) {
        if (nodes == null || nodes.isEmpty() || nodes.get(0).equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes.get(0)));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < nodes.size()) {
            TreeNode current = queue.poll();

            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.left);
            }
            i++;

            if (i < nodes.size() && !nodes.get(i).equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes.get(i)));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Inorder traversal to get sorted nodes
    private void inorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;
        inorder(root.left, nodes);
        nodes.add(root.val);
        inorder(root.right, nodes);
    }

    // Build balanced BST from sorted list
    private TreeNode buildBST(List<Integer> nodes, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = buildBST(nodes, left, mid - 1);
        root.right = buildBST(nodes, mid + 1, right);
        return root;
    }

    // Balance BST main method
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        return buildBST(nodes, 0, nodes.size() - 1);
    }

    // Level order traversal output (with "null")
    public static List<String> levelOrder(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                res.add("null");
            } else {
                res.add(String.valueOf(node.val));
                q.offer(node.left);
                q.offer(node.right);
            }
        }

        // Trim trailing nulls for cleaner output
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) {
            res.remove(i--);
        }

        return res;
    }

    // Main method with runtime input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BalanceBSTWithInput solution = new BalanceBSTWithInput();

        System.out.println("Enter BST nodes in level-order, separated by spaces (use 'null' for empty):");
        String line = sc.nextLine().trim();

        if (line.isEmpty()) {
            System.out.println("Input is empty.");
            return;
        }

        List<String> nodes = Arrays.asList(line.split("\\s+"));
        TreeNode root = buildTreeFromLevelOrder(nodes);

        TreeNode balancedRoot = solution.balanceBST(root);
        List<String> output = levelOrder(balancedRoot);

        System.out.println("Balanced BST (level-order): " + output);
    }
}