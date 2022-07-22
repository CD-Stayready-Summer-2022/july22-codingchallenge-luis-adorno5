package com.codedifferently;

import java.util.*;

public class Solution {
    /**
     * You will be given an integer called number and an array called possibleFamilyMembers
     * your jobs is to find the number's family members. A family member is any value that's with in
     * 1 of any other number in the family.
     *
     * So for example if the number = 4, and the possibleFamilyMembers is [1,4,3,5]
     * The actualFamilyMembers would be [3,4,5]
     * 3 is 1 away from 4
     * 4 is equal to 4
     * 4 is 1 away from 5
     * while
     * 1 is not included because the closest releation to 1 is 3 and that's 2 away.
     * @param number
     * @param possibleFamilyMembers
     * @return
     */
    public Integer[] numberFamily(Integer number, Integer[] possibleFamilyMembers){
        Arrays.sort(possibleFamilyMembers);
        List<Integer> family = List.of(possibleFamilyMembers);
        Set<Integer> result = new TreeSet<>();
        boolean flag = true;
        for(int i = family.indexOf(number); i<family.size()-1; i++){
            int current = family.get(i);
            int next = family.get(i+1);
            if(current == number || Math.abs(current-next) < 2)
                result.add(current);
            if(Math.abs(current-next) > 1) {
                flag = false;
                break;
            }
        }
        if(flag)
            result.add(family.get(family.size()-1));
        flag = true;
        for(int i = family.indexOf(number); i>0; i--){
            int current = family.get(i);
            int next = family.get(i-1);
            if(Math.abs(current-next) < 2) {
                result.add(current);
                result.add(next);
            }
            if(Math.abs(current-next) > 1) {
                flag = false;
                break;
            }
        }
        if(flag)
            result.add(family.get(0));
        return result.toArray(new Integer[0]);
    }
}
