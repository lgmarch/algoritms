package homework;

import lessonwork.Cat;
import lessonwork.Tree;

public class GenerateTree {
    private Tree[] tree;

    public void run(int numTree, int levels) {
        System.out.print("Создание деревьев: ");
        generateTrees(numTree, levels);
    }

    private void generateTrees(int num, int levels) {
        tree = new Tree[num];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = getTree(levels);
        }
    }

    private Tree getTree(int levels) {
        Tree tree = new Tree();
        while (tree.getHeight(tree.getRoot()) < levels) {
            tree.insert(new Cat(getRandomInt(-100, 100), "1"));
        }
        System.out.println(tree);
        System.out.println(tree.isBalance(tree.getRoot()) ? "Yes" : "No");
        return tree;
    }

    //Ну Котики с солидным возрастом...
    private int getRandomInt(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) - max;
    }

    public static void main(String[] args) {
        GenerateTree genTree = new GenerateTree();
        genTree.run(20, 6);
    }
}
