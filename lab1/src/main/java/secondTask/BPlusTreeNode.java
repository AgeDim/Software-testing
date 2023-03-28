package secondTask;

import java.util.ArrayList;
import java.util.List;

public class BPlusTreeNode {
    public List<Integer> result = new ArrayList<>();
    public int[] keys;
    int MinDeg;
    public BPlusTreeNode[] children;
    int num;
    boolean isLeaf;

    public BPlusTreeNode(int deg, boolean isLeaf) {
        this.MinDeg = deg;
        this.isLeaf = isLeaf;
        this.keys = new int[2 * this.MinDeg - 1];
        this.children = new BPlusTreeNode[2 * this.MinDeg];
        this.num = 0;
    }

    public int findKey(int key) {
        int idx = 0;
        while (idx < num && keys[idx] < key)
            ++idx;
        return idx;
    }

    public void remove(int key) {
        int idx = findKey(key);
        if (idx < num && keys[idx] == key) {
            if (isLeaf)
                removeFromLeaf(idx);
            else
                removeFromNonLeaf(idx);
        } else {
            if (isLeaf) {
                System.out.printf("The key %d does not exist in the tree\n", key);
                return;
            }
            System.out.println("children[idx].num:" + children[idx].num);
            System.out.println("MinDeg: " + MinDeg);
        }
    }

    public void removeFromLeaf(int idx) {
        if (num - (idx + 1) >= 0)
            System.arraycopy(keys, idx + 1, keys,
                    idx + 1 - 1, num - (idx + 1));
        num--;
    }

    public void removeFromNonLeaf(int idx) {
        int key = keys[idx];
        System.out.println("in rfnl");
        System.out.println("children[idx].num: " + children[idx].num);
        System.out.println("children[idx]: " + children[idx].traverse().toString());
        System.out.println("idx: " + idx);
        merge(idx);
        children[idx].remove(key);
    }

    public int getPred(int idx) {
        BPlusTreeNode cur = children[idx];
        return cur.keys[cur.num - 1];
    }

    public int getSucc(int idx) {
        BPlusTreeNode cur = children[idx + 1];
        return cur.keys[0];
    }

    public void merge(int idx) {
        BPlusTreeNode child = children[idx];
        BPlusTreeNode sibling = children[idx + 1];
        child.keys[MinDeg - 1] = keys[idx];
        for (int i = 0; i < sibling.num; ++i)
            child.keys[i + MinDeg] = sibling.keys[i];
        for (int i = idx + 1; i < num; ++i)
            keys[i - 1] = keys[i];
        for (int i = idx + 2; i <= num; ++i)
            children[i - 1] = children[i];
        child.num += sibling.num + 1;
        num--;
    }

    public void insertNotFull(int key) {
        int i = num - 1;
        if (isLeaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            num = num + 1;
        } else {
            if (children[i + 1].num == 2 * MinDeg - 1) {
                splitChild(i + 1, children[i + 1]);
                if (keys[i + 1] < key)
                    i++;
            }
            children[i + 1].insertNotFull(key);
        }
    }


    public void splitChild(int i, BPlusTreeNode y) {
        BPlusTreeNode z = new BPlusTreeNode(y.MinDeg, y.isLeaf);
        z.num = MinDeg - 1;
        for (int j = 0; j < MinDeg - 1; j++)
            z.keys[j] = y.keys[j + MinDeg];
        if (!y.isLeaf) {
            for (int j = 0; j < MinDeg; j++)
                z.children[j] = y.children[j + MinDeg];
        }
        y.num = MinDeg - 1;
        children[i + 1] = z;
        keys[i] = y.keys[MinDeg - 1];
        num = num + 1;
    }

    public List<Integer> traverse() {
        int i;
        result.clear();
        for (i = 0; i < num; i++) {
            result.add(keys[i]);
            System.out.printf(" %d", keys[i]);
        }
        return result;
    }

    public BPlusTreeNode search(int key) {
        result.clear();
        int i = 0;
        while (i < num && key > keys[i]) {
            result.add(keys[i]);
            i++;
        }
        if (i < num && keys[i] == key) {
            result.add(keys[i]);
            return this;
        }
        if (isLeaf)
            return null;
        return this;
    }
}
