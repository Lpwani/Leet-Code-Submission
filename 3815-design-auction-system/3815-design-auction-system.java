class AuctionSystem {

    // key :- itemId, value :- {userId : bidAmount}
    HashMap <Integer, HashMap<Integer,Integer>> hm = new HashMap<Integer, HashMap<Integer,Integer>>();
    // key :- itemId, value :- max_bid
    HashMap <Integer, Integer> item_maxbid = new HashMap<Integer,Integer>();
    // key :- itemId, value :- max_bidder
    HashMap <Integer, Integer> item_maxbidder = new HashMap<Integer,Integer>();

    public AuctionSystem() {
    }
    
    public void addBid(int userId, int itemId, int bidAmount) {

        if (!hm.containsKey(itemId)) {
            HashMap<Integer,Integer> user_bid = new HashMap<>();
            user_bid.put(userId,bidAmount);
            hm.put(itemId,user_bid);

            item_maxbid.put(itemId, bidAmount);
            item_maxbidder.put(itemId, userId);
            return;
        }

        HashMap<Integer,Integer> item_map = hm.get(itemId);

        boolean existed = item_map.containsKey(userId);
        int oldBid = existed ? item_map.get(userId) : -1;

        item_map.put(userId, bidAmount);

        int currMax = item_maxbid.get(itemId);
        int currWinner = item_maxbidder.get(itemId);

        // New or increased bid beats max
        if (bidAmount > currMax ||
            (bidAmount == currMax && userId > currWinner)) {

            item_maxbid.put(itemId, bidAmount);
            item_maxbidder.put(itemId, userId);
            return;
        }

        // Existing max bidder lowered bid → recompute
        if (existed && userId == currWinner && bidAmount < currMax) {

            int highest = -1;
            int max = -1;

            for (int u : item_map.keySet()) {
                int b = item_map.get(u);

                if (b > max || (b == max && u > highest)) {
                    max = b;
                    highest = u;
                }
            }

            item_maxbid.put(itemId, max);
            item_maxbidder.put(itemId, highest);
        }
    }
    
    public void updateBid(int userId, int itemId, int newAmount) {
        hm.get(itemId).put(userId, newAmount);

        int currMax = item_maxbid.get(itemId);
        int currWinner = item_maxbidder.get(itemId);

        // Case 1: new bid is higher
        if (newAmount > currMax ||
        (newAmount == currMax && userId > currWinner)) {

            item_maxbid.put(itemId, newAmount);
            item_maxbidder.put(itemId, userId);
            return;
        }

        // 🔴 Case 2: highest bidder lowered their bid → recompute
        if (userId == currWinner && newAmount < currMax) {

            int highest = -1;
            int max = -1;

            for (int u : hm.get(itemId).keySet()) {
                int b = hm.get(itemId).get(u);

                if (b > max || (b == max && u > highest)) {
                    max = b;
                    highest = u;
                }
            }

            item_maxbid.put(itemId, max);
            item_maxbidder.put(itemId, highest);
        }
    }
    
    public void removeBid(int userId, int itemId) {

        hm.get(itemId).remove(userId);

        HashMap<Integer,Integer> item_map = hm.get(itemId);

        if (item_map.isEmpty()) {
            hm.remove(itemId);
            item_maxbid.remove(itemId);
            item_maxbidder.remove(itemId);
            return;
        }

        if(userId == item_maxbidder.get(itemId)){
            int highest_bidder = -1;
            int max_bid = -1;

            if(hm.containsKey(itemId)){

                for(int curr_user_id : item_map.keySet()){
                    if(item_map.get(curr_user_id) > max_bid){
                        highest_bidder = curr_user_id;
                        max_bid = item_map.get(curr_user_id);
                    }
                    else if(item_map.get(curr_user_id) == max_bid && curr_user_id > highest_bidder){
                        highest_bidder = curr_user_id;
                    }
                }
            }
            item_maxbidder.put(itemId, highest_bidder);
            item_maxbid.put(itemId, max_bid);

            // for (int curr : item_map.keySet()) {
            //     int bid = item_map.get(curr);

            //     if (bid > max_bid ||
            //     (bid == max_bid && curr > highest_bidder)) {

            //         max_bid = bid;
            //         highest_bidder = curr;
            //     }
            // }

            // item_maxbidder.put(itemId, highest_bidder);
            // item_maxbid.put(itemId, max_bid);
        
        }

    }
    
    public int getHighestBidder(int itemId) {
        // int highest_bidder = -1;
        // int max_bid = -1;

        // if(!hm.containsKey(itemId)) return -1;

        // HashMap<Integer,Integer> item_map = hm.get(itemId);

        // for(int curr_user_id : item_map.keySet()){
        //     if(item_map.get(curr_user_id) > max_bid){
        //         highest_bidder = curr_user_id;
        //         max_bid = item_map.get(curr_user_id);
        //     }
        //     else if(item_map.get(curr_user_id) == max_bid && curr_user_id > highest_bidder){
        //         highest_bidder = curr_user_id;
        //     }
        // }

        if(item_maxbidder.get(itemId) == null) return -1;
        return item_maxbidder.get(itemId);
    }
}

/**
 * Your AuctionSystem object will be instantiated and called as such:
 * AuctionSystem obj = new AuctionSystem();
 * obj.addBid(userId,itemId,bidAmount);
 * obj.updateBid(userId,itemId,newAmount);
 * obj.removeBid(userId,itemId);
 * int param_4 = obj.getHighestBidder(itemId);
 */