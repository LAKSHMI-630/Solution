import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

public class SortedArrayToBST {

    // Convert sorted array to balanced BST
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);

        return node;
    }

    // Level order traversal of BST to print
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

        // Remove trailing "null"s for clean output
        int i = res.size() - 1;
        while (i >= 0 && res.get(i).equals("null")) {
            res.remove(i--);
        }
        return res;
    }

    // Main method to read input and output result
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in sorted array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        SortedArrayToBST solution = new SortedArrayToBST();
        TreeNode root = solution.sortedArrayToBST(nums);

        List<String> output = levelOrder(root);
        System.out.println("Constructed BST (level-order): " + output);
    }
}