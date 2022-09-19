package myapp.searchEngine;

public class TreeNode {
    String word="";
    TreeNode leftChild=null;
    TreeNode rightChild=null;
    private String filesList;

    public TreeNode(String word, TreeNode leftChild, TreeNode rightChild)
    {
        this.word = word;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getWord()
    {
        return word;
    }

    public TreeNode getLeftChild()
    {
        return leftChild;

    }
    public TreeNode getRightChild()
    {
        return rightChild;
    }

    public void setLeftChild(TreeNode leftChild)
    {
        this.leftChild = leftChild;
    }

    public void setRightChild(TreeNode rightChild)
    {
        this.rightChild = rightChild;
    }

    public String getFilesList() {
        return filesList;
    }

    public void setFilesList(String filesList) {
        this.filesList = filesList;
    }
}
