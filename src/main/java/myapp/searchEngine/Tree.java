package myapp.searchEngine;
import myapp.Stockable.List;

import java.util.function.Consumer;

public class Tree {
    // Membre privé
    private TreeNode head = null;

    // Constructeurs
    public void insert(String word, String fileName)
    {
        head = insertTree(word, fileName, head);
    }

    // Get / Set
    public TreeNode getHead() {
        return head;
    }

    // Méthodes
    private TreeNode insertTree(String word, String fileName, TreeNode node)
    {
        if(node == null)
        {
            return new TreeNode(word, fileName);
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
            node.addFilesList(fileName);
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
