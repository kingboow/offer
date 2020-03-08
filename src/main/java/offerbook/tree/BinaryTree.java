package offerbook.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 二叉树
 * 前序：根左右
 * 中序：左根右
 * 后续：左右根
 * <p>
 * 面试题：26 34 55 7 33
 * <p>
 * 宽度优先遍历：从左到右先访问树的第一次节点，再访问第二层节点--面试题32
 * 特例：
 * 二叉搜索树：左 < 根 < 右 -- 面试题36、68
 * 堆：--面试题40
 * 最大堆：根节点最大
 * 最小堆：根节点最小
 * 红黑树
 * 节点分为红、黑两种颜色
 * 从根节点到叶子结点的最长路径不超过最短的两倍
 */
public class BinaryTree {
    /**
     * 面试题 7 重建二叉树
     */
    private Map<Integer, Integer> inOrderMap = new HashMap();

    private void buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null) {
            return;
        }
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }
        TreeNode node = binaryTreeNode(preOrder, 0, 0, inOrder.length - 1);
        node.getData();
    }

    public TreeNode binaryTreeNode(int[] preOrder, int rootIndex, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        int rootValue = preOrder[rootIndex];
        TreeNode root = new TreeNode();
        root.setData(rootValue);

        int i = inOrderMap.get(rootValue);
        root.setLeft(binaryTreeNode(preOrder, rootIndex + 1, inLeft, i - 1));
        root.setRight(binaryTreeNode(preOrder, rootIndex + 1 + i - inLeft, i + 1, inRight));
        return root;
    }

    /**
     * 树的深度
     *
     * @param treeNode
     * @return
     */
    public int treeDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = treeDepth(treeNode.getLeft());
        int right = treeDepth(treeNode.getRight());
        return (left > right) ? (left + 1) : (right + 1);
    }

    /**
     * 判断该树是不是平衡二叉树。
     * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int depth = 0;
        return isBalanced(root, depth);
    }

    private boolean isBalanced(TreeNode root, int depth) {
        if (root == null) {
            return true;
        }
        int left = 0;
        int right = 0;

        if (isBalanced(root.getLeft(), left) && isBalanced(root.getRight(), right)) {
            int diff = left - right;
            if (Math.abs(diff) <= 1) {
                depth = 1 + (left > right ? left : right);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree(pre, in);
    }
}
