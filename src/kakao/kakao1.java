/**
 * kakao.kakao1.java
 */
package kakao;

class kakao1 {
	
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        //board는 판, skill은 공격(type:1),회복(type:2)
        int skillDegree = 0;
        
        int count = 0;
        
        //스킬의 갯수 만큼 날릴건데
        for(int x=0; x<skill.length; x++ ){
            
            //공격,회복을
            skillDegree = skill[x][5];
            
            //보드판을 돌아다니면서
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[i].length; j++){

                    //스킬의 범위 안에 있다면
                    if(i>=skill[count][1] && i<=skill[count][3]){
                        if(j>=skill[count][2] && j<=skill[count][4]){

                            //공격,회복을 나눈후
                            if(skill[count][0] == 1){
                                board[i][j] -= skillDegree;
                            }else{
                                board[i][j] += skillDegree;
                            }
                                
                        }
                    }
                }
                
            }
            count++; 
            
        }

        for(int x=0; x<board.length; x++){
            for(int y=0; y<board[x].length; y++){
                //System.out.println(board[x][y]);
                if(board[x][y] > 0){
                    answer += 1;
                }    
            }
        }
        
    return answer;
        
    }
}
