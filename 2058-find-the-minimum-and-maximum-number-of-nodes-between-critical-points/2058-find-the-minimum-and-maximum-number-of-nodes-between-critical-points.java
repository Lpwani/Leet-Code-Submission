/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // Space Complexity : O(N)
        // Time Complexity : O(N)
        
       int maxDist = Integer.MIN_VALUE;
       int minDist =  Integer.MAX_VALUE;

       ListNode curr = head;

       int len = 0;

        while(curr != null){
            curr = curr.next;
            len++;
        }

        ArrayList<Integer> crtIdx = new ArrayList<>();

        curr = head;
        int arr[] = new int[len];

        for(int i = 0; i < len; i++){
            arr[i] = curr.val;
            curr = curr.next;
        }

        int currSign = 0;

        for(int i = 1; i < len; i++){
            if(currSign == 0){
                if(arr[i-1] > arr[i]) currSign = -1;
                if(arr[i-1] < arr[i]) currSign = 1;
            }
            else if(currSign != 0){
                if(currSign == 1){
                    if(arr[i] < arr[i - 1]){
                        crtIdx.add(i-1);
                        currSign = -1;
                    }
                    if(arr[i] == arr[i-1]){
                        currSign = 0;
                    }
                }
                if(currSign == -1){
                    if(arr[i] > arr[i-1]){
                        crtIdx.add(i-1);
                        currSign = 1;
                    }
                    if(arr[i] == arr[i-1]){
                        currSign = 0;
                    }
                }
            }
        }

        if(crtIdx.size() < 2){
            minDist = -1;
            maxDist = -1;
        }
        else{
            maxDist = crtIdx.get(crtIdx.size()-1) - crtIdx.get(0);
            for(int i = 1; i < crtIdx.size(); i++){
                minDist = Math.min(minDist, crtIdx.get(i) - crtIdx.get(i-1));
            }
        }
        

        // for(int i = 0; i < crtIdx.size(); i++){
        //     // System.out.print(arr[i]+" ");
        //     System.out.print(crtIdx.get(i)+" ");
        // }

        return new int[]{minDist, maxDist};
    }
}