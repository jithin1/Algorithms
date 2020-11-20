
codechef.com/NOV20A/problems/SCALSUM

// This program uses square root decompositon technique.

/*
 Divide into squreRoot(n) blocks
 For each block, find all the levels that come inside this block (level is nothing but the depth of the nodes
 Now from the above step, take that level which has the minimum number of nodes
 For the above level calculate the dot product for all the pairs
 The above approach will work as for each query. at max we have to travel only 2*squareRoot(n) nodes to find the answer.
 Rest are precomputed
 
 */


/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	private static int[] parent;
	private static long[] a;
	private static final long mod = (1L << 32);
	private static int blockSize;
	private static int maxDepth;
	private static long[] dotProduct;
	private static int[] depth;
	private static List<List<Integer>> nodesByDepth;
	private static List<List<Long>> nodesByDepthPrecomputed;
	private static List<Map<Integer,Integer>> nodeToIndex;
	private static int[][] g;
	private static boolean[] precompute;

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int m = n - 1;

		parent = new int[n];
		dotProduct = new long[n];
		depth = new int[n];
		st = new StringTokenizer(br.readLine());
		a = new long[n];

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(st.nextToken());

		int[] from = new int[m], to = new int[m];
		for (int i = 0; i < m; i++) { // input edges
			st = new StringTokenizer(br.readLine());
			from[i] = Integer.parseInt(st.nextToken()) - 1;
			to[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		construct(n, from, to);
		DFS(0, -1, 0);
		blockSize = (int) Math.sqrt(n);;
		precompute = new boolean[n];
		nodesByDepth = new ArrayList();
		nodesByDepthPrecomputed = new ArrayList();
		nodeToIndex = new ArrayList();

		for (int i = 0; i <= maxDepth; i++) {
			nodesByDepth.add(new ArrayList());
		}

		for (int i = 0; i < n; i++) {
			nodesByDepth.get(depth[i]).add(i);
			nodesByDepthPrecomputed.add(new ArrayList());
			nodeToIndex.add(new HashMap());
		}

		getDistances();
		
        for(int i=0;i<q;i++) {
        	 st = new StringTokenizer(br.readLine());
        	 int u = Integer.parseInt(st.nextToken())-1;
        	 int v = Integer.parseInt(st.nextToken())-1;
        	 out.println(findDotProduct(u, v));
        }
        
        out.close();
	}

	private static void getDistances() {
		for (int i = 0; i <= maxDepth; i = i + blockSize) {
			int minDepth = Integer.MAX_VALUE;
			int level = -1;

			for (int j = i; j <= Math.min(i + blockSize, maxDepth); j++) {
				if (minDepth > nodesByDepth.get(j).size()) {
					minDepth = nodesByDepth.get(j).size();
					level = j;
				}
			}
             
			for (int j = 0; j < nodesByDepth.get(level).size(); j++) {
				int u = nodesByDepth.get(level).get(j);
                 int itr = 0;
				for (int k = j; k < nodesByDepth.get(level).size(); k++,itr++) {
					int v = nodesByDepth.get(level).get(k);
					long ans = findDotProduct(u, v);
					nodesByDepthPrecomputed.get(u).add(ans);
					nodeToIndex.get(u).put(v,itr);
				}
				precompute[u] = true;
			}

			
		}
	}

	private static long findDotProduct(int u, int v) {
		long ans = 0;

		while (u != v && !precompute[u]) {
			ans = (ans + ((a[u] * a[v])%mod))%mod;
			u = parent[u];
			v = parent[v];
		}

		if (u == v)
			ans = (ans + dotProduct[u]) % mod;
		else {
			int a = Math.min(u, v);
			int b = Math.max(u, v);
			int index= nodeToIndex.get(a).get(b);
			ans = (ans + nodesByDepthPrecomputed.get(a).get(index)) % mod;
		}

		return ans;
	}

	private static void DFS(int u, int p, int d) {
		parent[u] = p;
		dotProduct[u] = (a[u] * a[u]) % mod;
		if (p != -1)
			dotProduct[u] = (dotProduct[u] + dotProduct[p]) % mod;

		depth[u] = d;
		maxDepth = Math.max(maxDepth, d);

		for (int v : g[u]) {
			if (v == p)
				continue;
			DFS(v, u, d + 1);
		}
	}

	private static int[][] construct(int n, int[] from, int[] to) { // Graph construction
		g = new int[n][];
		int[] p = new int[n];
		for (int f : from)
			p[f]++;
		for (int t : to)
			p[t]++;
		for (int i = 0; i < n; i++)
			g[i] = new int[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
			g[to[i]][--p[to[i]]] = from[i];
		}
		return g;
	}
}
