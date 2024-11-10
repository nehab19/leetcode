package guru.springframework.spring5webapp.leetcode.binarytrees;

class TreeNodeClass {
    int value;
    TreeNodeClass left;
    TreeNodeClass right;

    TreeNodeClass(int value) {
        this.value = value;
    }

    TreeNodeClass(int value, TreeNodeClass left, TreeNodeClass right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

}

public class SumOfLeaves {
    public int sumOfLeave(TreeNodeClass current, TreeNodeClass parent) {
        if (current == null) {
            return 0;
        }
        int sum = 0;
        if (current.left == null && current.right == null) {
            if (parent != null && parent.left == current) {
               return current.value;
            }
        }
        int left = sumOfLeave(current.left, current);
        int right = sumOfLeave(current.right, current);
        return left + right;

    }
    public static int sumOfLeaveApproach(TreeNodeClass current,boolean isLeft) {
        if (current == null) {
            return 0;
        }
        if (current.left == null && current.right == null&& isLeft) {
            return current.value;
        }
        return sumOfLeaveApproach(current.left,true) + sumOfLeaveApproach(current.right,false);

    }

    public static int sumOfLeftLeaves(TreeNodeClass root) {
        if (root == null) {
            return 0;
        }
        TreeNodeClass parent = null;
        return sumOfLeaveApproach(root, false);
    }

    public static void main(String[] args) {
            TreeNodeClass root = new TreeNodeClass(5);
            root.left = new TreeNodeClass(3);
            root.right = new TreeNodeClass(6);
            root.left.left = new TreeNodeClass(5);
            root.left.right = new TreeNodeClass(2);
            root.right.left = new TreeNodeClass(5);
            root.right.right = new TreeNodeClass(7);
        sumOfLeftLeaves(root);

        }
}
