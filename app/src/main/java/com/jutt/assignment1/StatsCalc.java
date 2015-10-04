package com.jutt.assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hammadjutt on 2015-10-03.
 */
public class StatsCalc {

    private StatsData data;
    private ArrayList<Integer> reactions;
    private ArrayList<BuzzerResult> buzzers;

//    private Map<String, ArrayList<Integer>> statData;

    public StatsCalc(StatsData data) {
        this.data = data;
        this.reactions = this.data.getReactions();
        this.buzzers = this.data.getBuzzers();
    }

    private List<Integer> getLast(Integer n) {
        if(n == 0)
            return reactions;
        int last = reactions.size();
        if(n > last)
            n = last;
        return reactions.subList(last - n, last);
    }

    public Integer min(Integer n) {
        List<Integer> subList = getLast(n);
        return Collections.min(subList);
    }

    public Integer max(Integer n) {
        List<Integer> subList = getLast(n);
        return Collections.max(subList);
    }


    public Integer avg(Integer n) {
        int sum = 0;
        List<Integer> subList = getLast(n);
        if(!subList.isEmpty()) {
            for(Integer time:subList) {
                sum += time;
            }
            return sum/subList.size();
        }
        return 0;
    }

    public Integer median(Integer n) {
        Integer median;
        List<Integer> sorted = getLast(n);
        Collections.sort(sorted);

        int middle = ((sorted.size()) / 2);
        if(sorted.size() % 2 == 0){
            median = (sorted.get(middle) + sorted.get(middle - 1)) / 2;
        } else{
            median = sorted.get(middle);
        }
        return median;
    }

    public Integer countBuzzes(Player p, Integer numPlayers) {
        Integer i = 0;
        for(BuzzerResult br: buzzers) {
            if(br.numPlayers == numPlayers && br.winner.getNumber() == p.getNumber()) {
                i++;
            }
        }
        return i;
    }

    class ParsedStats {
        int[][] reactions = new int[4][3];
    }




}
