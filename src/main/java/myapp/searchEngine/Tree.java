package myapp.searchEngine;
import myapp.Stockable.List;

import java.util.function.Consumer;

public class Tree {
    // Membre privé
    private TreeNode head = null;

    // Constructeurs
    public void insert(String word, String fileName)
    {
        insertTree(word, fileName, head);
    }

    // Get / Set
    public TreeNode getHead() {
        return head;
    }
    public void setHead(TreeNode head) {
        this.head = head;
    }

    // Méthodes
    private TreeNode insertTree(String word, String fileName, TreeNode node)
    {
        if(node == null)
        {
            List<String> list = new List<>();
            list.add(fileName);
            node = new TreeNode(word, list);
            return node;
        }
        if(word.compareTo(node.getWord()) < 0)
        {
            node.setLeftChild(insertTree(word, fileName, node.getLeftChild()));
        }
        else if(word.compareTo(node.getWord()) > 0)
        {
            node.setRightChild(insertTree(word, fileName, node.getRightChild()));
        }
        else
        {
            node.getList().add(fileName);
        }
        return node;
    }

    private void walk(Consumer<TreeNode> process)
    {
        walkTree(process, head);
    }
    private void  walkTree(Consumer<TreeNode> consumerTreeNode, TreeNode treeNode)
    {
        if(treeNode.getLeftChild() != null){
            walkTree(consumerTreeNode, treeNode.getLeftChild());
        }
        consumerTreeNode.accept(treeNode);
        if(treeNode.getRightChild() != null){
            walkTree(consumerTreeNode, treeNode.getRightChild());
        }
    }
}
