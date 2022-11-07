import java.util.Stack;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < ingredient.length; i++){
            stack.push(ingredient[i]);

            if(stack.peek() == 1 && stack.size() > 3){
                String target = stack.get(stack.size()-4).toString()+stack.get(stack.size()-3).toString()+stack.get(stack.size()-2).toString()+stack.get(stack.size()-1).toString();
                if(target.equals("1231")){
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}