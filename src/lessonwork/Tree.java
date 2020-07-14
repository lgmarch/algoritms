package lessonwork;

public class Tree {
    // travers
    // delete

    private class TreeNode implements Comparable {
        private Cat c;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(Cat c) {
            this.c = c;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "c=" + c.toString() +
                    '}';
        }

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof Cat))
                throw new ClassCastException("Not a cat");
            return c.getAge() - ((Cat) o).getAge();
        }
    }

    TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void insert(Cat c) {
        TreeNode node = new TreeNode(c);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent = null; //Предыдущий узел
            while (true) {
                parent = current;
                if (c.getAge() < current.c.getAge()) {
                    current = current.left;
                    if (current == null) {
                        parent.left = node;
                        return;
                    }
                } else if (c.getAge() > current.c.getAge()){
                    current = current.right;
                    if (current == null) {
                        parent.right = node;
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    public Cat find(int age) {
        TreeNode current = root;
        while (current.c.getAge() != age) {
            current = (age < current.c.getAge()) ? current.left : current.right;
            if (current == null) return null;
        }
        return current.c;
    }

    private void preOrderTraverse(TreeNode current) {
        if (current != null) {
            System.out.print(current.c.getAge() + " ");
            preOrderTraverse(current.left);
            preOrderTraverse(current.right);
        }
    }

    public void displayTree() {
        preOrderTraverse(root);
    }

    public boolean delete(int age) {
        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeftChild = true;

        //Находим удаляемый узел
        while (current.c.getAge() != age) {
            parent = current;
            if (age < current.c.getAge()) {
                current = current.left;
                isLeftChild = true;
            } else {
                current = current.right;
                isLeftChild = false;
            }
            if (current == null) {
                return false;
            }
        }

        // leaf
        if (current.left == null && current.right == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.left = null;
            else
                parent.right = null;
        }
        // one ancestor
        else if (current.right == null) {
            if (isLeftChild)
                parent.left = current.left;
            else
                parent.right = current.left;
        } else if (current.left == null) {
            if (isLeftChild)
                parent.left = current.right;
            else
                parent.right = current.right;
        }
        // two ancestors
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parent = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            parent = s;
            s = curr;
            curr = curr.left; //Ищем самый левый лист в правом поддереве
        }

        if (s != node.right) {
            parent.left = s.right;
            s.right = node.right;
        }
        return s;
    }

    //Максимальное количество уровней в дереве: высота + 1. Используется рекурсия.
    public int getHeight(TreeNode treeNode) {
        if (treeNode == null) return 0;
        if (treeNode.left == null && treeNode.right == null) return 1;

        int left = 0;
        if (treeNode.left != null) {
            left = getHeight(treeNode.left);
        }
        int right = 0;
        if (treeNode.right != null) {
            right = getHeight(treeNode.right);
        }
        return (Math.max(left, right) + 1);
    }

    //Сравниваем две соседние ветки
    public boolean isBalance(TreeNode node) {
        if (node == null) return true;
        return Math.abs(Math.max(getHeight(node.left), 0) - Math.max(getHeight(node.right), 0)) < 2;
    }

}
















