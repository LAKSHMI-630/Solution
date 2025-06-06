import java.util.*;

// Node for linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

// Node for tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

// Main class with main method
public class SortedListToBST {

    // Convert sorted linked list to BST
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return buildBST(values, 0, values.size() - 1);
    }

    private TreeNode buildBST(List<Integer> values, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(values.get(mid));
        node.left = buildBST(values, left, mid - 1);
        node.right = buildBST(values, mid + 1, right);
        return node;
    }

    // Level-order output (LeetCode format)
    public static List<String> levelOrder(TreeNode root) {
        List<String> output = new ArrayList<>();
        if (root == null) return output;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                output.add("null");
            } else {
                output.add(String.valueOf(curr.val));
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }

        // Trim trailing nulls
        int i = output.size() - 1;
        while (i >= 0 && output.get(i).equals("null")) {
            output.remove(i--);
        }

        return output;
    }

    // Create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Main method (runtime input)
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements in sorted linked list: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter sorted linked list elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ListNode head = createList(nums);
        SortedListToBST solution = new SortedListToBST();
        TreeNode root = solution.sortedListToBST(head);

        List<String> output = levelOrder(root);
        System.out.println("Output: " + output);
    }
}