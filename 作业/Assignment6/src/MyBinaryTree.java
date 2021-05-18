public class MyBinaryTree<T> {

    private TreeNode root;
    private int size;

    public MyBinaryTree(T root){
        this.root.setData(root);
    }

    public void addTreeNodes(String directions, T[] values){
        char[] a = directions.toCharArray();
        String b = null;
        T[] value = null;
        for( int i = 1; i < a.length; i++){
            b += a[i];
            value[i-1] = values[i];
        }
        if( a[0] == '0'){
            root.leftChild = new TreeNode(values[0]);
            addTreeNodes(b, value);
        }
        if( a[0] == '1'){
            root.rightChild = new TreeNode(values[0]);
            addTreeNodes(b, value);
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
