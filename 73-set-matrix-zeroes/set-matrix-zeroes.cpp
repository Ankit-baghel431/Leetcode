class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        
        int row = matrix.size();
        int col = matrix[0].size();

        vector<int> temp1(row, 1);
        vector<int> temp2(col, 1);

        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j]==0){
                    temp1[i]=0;
                    temp2[j]=0;
                }
            }
        }
        for(int i =0; i<row; i++){
            for(int j=0; j<col; j++){
                if(temp1[i]==0 or temp2[j]==0) matrix[i][j] =0;
            }
        }

    }
};