package myapp.searchEngine;

import myapp.Stockable.List;

import java.net.URI;

public class TreeNode {
    private String word;
    private TreeNode leftChild = null;
    private TreeNode rightChild = null;
    private List<String> filesList = new List<>();

    public TreeNode(String word, String fileList)
    {
        this.word = word;
        addFilesList(fileList);
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

    public List<String> getFilesList() {
        return filesList;
    }

    public void addFilesList(String filesList) {
        this.filesList.add(filesList);
    }
}
