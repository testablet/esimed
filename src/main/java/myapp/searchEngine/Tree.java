package myapp.searchEngine;

public class Tree {

    Tree head;
    TreeNode node = null;
    public void insert(String word, String fileName)
    {
        insertTree(word, fileName,node);
    }

    private TreeNode insertTree(String word, String fileName, TreeNode node)
    {
        if(node == null)
        {
            node = new TreeNode(word);
            return node;
        }
        else if(word.compareTo(node.getWord())<0)
        {
            node.leftChild = insertTree(word, fileName, node.leftChild);
        }
        else if(word.compareTo(node.getWord())>0)
        {
            node.rightChild = insertTree(word, fileName, node.rightChild);
        }
        else
        {
            node.add
        }
        return node;
    }

}
