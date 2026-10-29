class Solution {
    int n, LOG, timer;
    List<Integer>[] adj;
    int[][] up;
    int[] depth, tin, tout, prefix;
    int[] bit;
    char[] chars;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        chars = s.toCharArray();

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        prefix = new int[n];
        bit = new int[n + 2];

        buildTree();

        List<Boolean> answer = new ArrayList<>();

        for (String query : queries) {
            String[] p = query.split("\\s+");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                if (chars[u] != c) {
                    int delta = (1 << (chars[u] - 'a')) ^ (1 << (c - 'a'));
                    rangeUpdate(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int ancestor = lca(u, v);

                int maskU = prefix[u] ^ pointQuery(tin[u]);
                int maskV = prefix[v] ^ pointQuery(tin[v]);

                int mask = maskU ^ maskV ^ (1 << (chars[ancestor] - 'a'));

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    void buildTree() {
        int capacity = 2 * n + 5;

        int[] stackNode = new int[capacity];
        int[] stackParent = new int[capacity];
        int[] stackState = new int[capacity];

        int top = 0;
        stackNode[top] = 0;
        stackParent[top] = -1;
        stackState[top++] = 0;

        timer = 0;

        while (top > 0) {
            --top;

            int u = stackNode[top];
            int p = stackParent[top];
            int state = stackState[top];

            if (state == 1) {
                tout[u] = timer - 1;
                continue;
            }

            tin[u] = timer++;
            depth[u] = (p == -1) ? 0 : depth[p] + 1;

            up[0][u] = (p == -1) ? u : p;

            for (int j = 1; j < LOG; j++) {
                up[j][u] = up[j - 1][up[j - 1][u]];
            }

            int parentMask = (p == -1) ? 0 : prefix[p];
            prefix[u] = parentMask ^ (1 << (chars[u] - 'a'));

            stackNode[top] = u;
            stackParent[top] = p;
            stackState[top++] = 1;

            for (int i = adj[u].size() - 1; i >= 0; i--) {
                int v = adj[u].get(i);

                if (v != p) {
                    stackNode[top] = v;
                    stackParent[top] = u;
                    stackState[top++] = 0;
                }
            }
        }
    }

    int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                u = up[j][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {
            if (up[j][u] != up[j][v]) {
                u = up[j][u];
                v = up[j][v];
            }
        }

        return up[0][u];
    }

    void add(int index, int value) {
        for (int i = index; i < bit.length; i += i & -i) {
            bit[i] ^= value;
        }
    }

    int pointQuery(int index) {
        int result = 0;

        for (int i = index + 1; i > 0; i -= i & -i) {
            result ^= bit[i];
        }

        return result;
    }

    void rangeUpdate(int left, int right, int value) {
        add(left + 1, value);
        add(right + 2, value);
    }
}
