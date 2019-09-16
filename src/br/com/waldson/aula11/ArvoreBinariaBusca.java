package br.com.waldson.aula11;

public class ArvoreBinariaBusca {
    private Node raiz = null;

    public boolean isEmpty() {
        return raiz == null;
    }

    public void insert(Node node) {
        if (raiz == null) {
            raiz = node;
            return;
        }
        raiz.insert(node);
    }

    public void insert(int value) {
        Node n = new Node(value);
        insert(n);
    }

    public void remove(Node node) {
        Node pos = raiz.search(node.getValue());
        Node nod = raiz.getRight();
        while (nod.getLeft() != null) nod = nod.getLeft();

        if (nod.getRight() != null) {
            Node tmp = new Node(nod.getRight().getValue());
            tmp.setLeft(nod.getRight().getLeft());
            tmp.setRight(nod.getRight().getRight());
            pos.setValue(nod.getValue());
            pos.setRight(tmp);
        } else {
            pos.setValue(nod.getValue());
            pos.setRight(null);
        }
    }

    public Node search(int key) {
        if (raiz == null) {
            return null;
        }
        return raiz.search(key);
    }

}
