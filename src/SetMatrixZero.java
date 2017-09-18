public class SetMatrixZero{
    public static int[][] setZero(int[][] origMatrix){
        if(origMatrix == null){
            return origMatrix;
        }
        int rowNum = origMatrix.length;
        int columNum = 0;
        if(rowNum==0){
            return origMatrix;
        }else{
            columNum = origMatrix[0].length;
        }
        int[] zeroRows=new int[rowNum];
        int[] zeroColumns=new int[columNum];

        for ( int i=0;i<origMatrix.length;i++) {
            for (int j = 0; j < origMatrix[i].length; j++) {
                if (origMatrix[i][j] == 0) {
                    zeroRows[i]=1;
                    zeroColumns[j]=1;
                }
            }
        }
        for (int p=0;p<zeroRows.length;p++){
            if(zeroRows[p]==1) {
                for(int j=0;j<columNum;j++)
                    origMatrix[p][j] = 0;
            }
        }
        for (int p=0;p<zeroColumns.length;p++){
            if(zeroColumns[p]==1) {
                for(int i=0;i<rowNum;i++)
                    origMatrix[i][p] = 0;
            }
        }
        return origMatrix;
    }

    public static void main(String[] args){
        int[][] matrix = new int[][]{
                {0}
        };
        setZero(matrix);
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

}