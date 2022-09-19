package myapp.searchEngine;

import java.net.URI;

public class TreeNode {
    private String word="";
    public TreeNode leftChild = null;
    public TreeNode rightChild = null;
    private String filesList;

    public TreeNode(String word)
    {
        this.word = word;
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
