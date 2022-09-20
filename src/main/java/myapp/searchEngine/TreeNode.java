package myapp.searchEngine;

import myapp.Stockable.List;

import java.net.URI;

public class TreeNode {
    private String word;
    private TreeNode leftChild = null;
    private TreeNode rightChild = null;
    private String filesList;
    private List<String> list = new List<>();

    public TreeNode(String word, List<String> list)
    {
        this.word = word;
        this.list = list;
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

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
