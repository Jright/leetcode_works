package No301_350;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

public class No341_FlattenNestedListIterator implements Iterator<Integer> {

    ArrayDeque<NestedInteger> stack;

    public No341_FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        loadStack(nestedList);
    }

    @Override
    public Integer next() {
        if(!hasNext()){
            return null;
        }
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()){
            loadStack(stack.pop().getList());
        }
        return !stack.isEmpty();
    }

    private void loadStack(List<NestedInteger> list){
        for(int i = 0; i < list.size(); i++){
            stack.push(list.get(i));
        }
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
