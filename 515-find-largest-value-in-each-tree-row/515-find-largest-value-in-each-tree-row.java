/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> ans = new ArrayList<>();

		if(root == null) return ans;

		//declare queue for level order traversal
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		// loop till queue is not empty
		while(!q.isEmpty()) {
			int size = q.size();

			// store max element for each tree row
			int max = Integer.MIN_VALUE;


			for(int i = 0;i<size;i++) {
				TreeNode node = q.peek();

				// if there is left child, add it to the queue
				if(node.left != null) {
					q.add(node.left);
				}
				
				// if there is right child, add it to the queue
				if(node.right != null) {
					q.add(node.right);
				}
				
				// check if the curr node value is greater than max, if so update max, keep doing this for all elements
				// in the row
				max = Math.max(max, node.val);
				q.poll();
			}
			// lastly add that max value in the ans list
			ans.add(max);
		}

		return ans;
	}
}