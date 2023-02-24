package HW5;

public class Main {
    public static void main(String[] args) {

        BinaryNode root = new BinaryNode(0);
        BinaryNode node1 = new BinaryNode(1);
        BinaryNode node2 = new BinaryNode(2);
        BinaryNode node3 = new BinaryNode(3);
        BinaryNode node4 = new BinaryNode(4);
        BinaryNode node5 = new BinaryNode(5);
        BinaryNode node6 = new BinaryNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node3.left = node6;

//        BinaryNode.bypassNode(root);

        TreeNode tNode0 = new TreeNode("0");
        TreeNode tNode1 = new TreeNode("1");
        TreeNode tNode2 = new TreeNode("2");
        TreeNode tNode3 = new TreeNode("3");
        TreeNode tNode4 = new TreeNode("4");


        tNode0.addChild(tNode1);
        tNode0.addChild(tNode2);
        tNode1.addChild(tNode3);
        tNode1.addChild(tNode4);

        tNode0.treeSearch(tNode0);

    }

}
