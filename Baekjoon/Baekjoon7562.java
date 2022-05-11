import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = Integer.parseInt(br.readLine());
        
        int result[] = new int[caseNum];
        for(int i = 0; i < caseNum; i++){
            int boardWidth = Integer.parseInt(br.readLine());
            
            int[] currPos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] targetPos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            
            visitedInt = new int[boardWidth][boardWidth];
            q.clear();
    
            if(currPos[0] == targetPos[0] && currPos[1] == targetPos[1]){
                result[i] = 0;
                continue;
            }
            result[i] = bfs(new Pos(currPos[0],currPos[1]),new Pos(targetPos[0],targetPos[1]));
        }
        for(int i : result){
            System.out.println(i);
        }
        br.close();
    }

    static class Pos{
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }

    static int[][] visitedInt;
    static Queue<Pos> q = new LinkedList<>();
    static int[] dx = {1,1,-1,-1,2,2,-2,-2};
    static int[] dy = {2,-2,2,-2,1,-1,1,-1};
    public static int bfs(Pos currPos, Pos targetPos){
        q.add(new Pos(currPos.x,currPos.y));
        visitedInt[currPos.x][currPos.y] = 1;
        while(!q.isEmpty()){
            Pos pos = q.poll();
            for(int i = 0; i < 8; i++){
                Pos newPos = new Pos(pos.x+dx[i],pos.y+dy[i]);
                if(newPos.x == targetPos.x && newPos.y == targetPos.y){
                        visitedInt[newPos.x][newPos.y] = -1;
                        return visitedInt[pos.x][pos.y];
                }else if(checkPos(newPos) && visitedInt[newPos.x][newPos.y] == 0){
                    q.add(newPos);
                    visitedInt[newPos.x][newPos.y] = visitedInt[pos.x][pos.y] + 1;
                }
            }
        }
        return -1;
    }

    public static boolean checkPos(Pos pos){
        return (pos.x >= 0 && pos.y >= 0 && pos.x < visitedInt.length && pos.y < visitedInt.length);
    }

}