package myapp.searchEngine;

public class TreeNode {
    public String word;
    private TreeNode leftChild;
    private TreeNode rightChild;
    public String filesList;


    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public String getWord() {
        return word;
    }

    public String getFilesList() {
        return filesList;
    }

    public void setFilesList(String filesList) {
        this.filesList = filesList;
    }
}
