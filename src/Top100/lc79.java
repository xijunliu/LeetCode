package Top100;

public class lc79 {
    public boolean exist(char[][] board, String word) {
        if(word == null) return true;
        if(board==null || board.length==0 || board[0] == null) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, word, 0,visited)) {

                    return true;
                }
            }
        }
        return false;
    }

    public  boolean search(char[][] board, int l, int r, String word, int index,boolean[][] visited){
        if(l>=board.length || r>=board[0].length || l<0 || r<0 || index >=word.length()
                || visited[l][r] || board[l][r] != word.charAt(index)) return false;
        if(index==word.length()-1) return true;
        visited[l][r] = true;
        if( search(board, l, r+1, word, index+1,visited)||search(board, l+1, r, word, index+1,visited)||
                search(board, l, r-1, word, index+1,visited)||search(board, l-1, r, word, index+1,visited)){
            return true;
        }
        visited[l][r] = false;

        return false;
    }
}
