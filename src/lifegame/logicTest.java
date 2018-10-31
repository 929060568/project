package lifegame;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class logicTest {
    private logic logic=new logic();
	@org.junit.Test
	void testLogic() {
		 for (int row = 0; row <logic. world.length; row++) {  
		        for (int col = 0; col <logic. world[0].length; col++) {  
		         assertEquals( logic.nextStatus[row][col] ,logic.world[row][col]);  
		         assertEquals( logic.tempStatus[row][col] ,logic.world[row][col]);  
		        }  
		    }  
	}

	@org.junit.Test
	void testPaintComponentGraphics() {
		
	}

	@Test
	void testChangeCellstatus() {
		logic.changeCellstatus();
		 for (int row = 0; row < 20; row++) {  
	         for (int col = 0; col < 20; col++) {  
	               switch(logic.neiborCellnum(row,col)) {
	               case 0:  
	               case 1:  
	               case 4:  
	               case 5:  
	               case 6:  
	               case 7:  
	               case 8:  
	                 assertEquals(logic.nextStatus[row][col] , 0);  
	                   break;  
	               case 2:  
	                  assertEquals( logic.nextStatus[row][col],logic.tempStatus[row][col]);  
	                   break;  
	               case 3:  
	                   assertEquals(logic.nextStatus[row][col] , 1);  
	                   break;  
	               }
	         }  
	     }  
	}

	@Test
	void testNeiborCellnum() {
		int [][]testworld={{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,                 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,	              {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		,	              {0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0}
		,                 {0,0,0,0,0,0,0,1,3,3,3,1,0,0,0,0,0,0,0,0}
		,                 {0,0,0,0,0,0,1,3,5,6,5,3,1,0,0,0,0,0,0,0}
		,                 {0,0,0,0,0,1,3,5,7,8,7,5,3,1,0,0,0,0,0,0}
		,                 {0,0,0,0,0,1,2,4,5,5,5,4,2,1,0,0,0,0,0,0}
		,                 {0,0,0,0,0,1,2,3,3,3,3,3,2,1,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
			,             {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
		
		for(int i=0;i<20;i++)
			for(int j=0;j<20;j++) {
				assertEquals(testworld[i][j],logic.neiborCellnum(i, j));
			}
	}

	@Test
	void testStartAnimation() {
		
	}

	@Test
	void testCopyWorldMap() {
		 for (int row = 0; row < logic.nextStatus.length; row++) {  
	         for (int col = 0; col < logic.nextStatus[row].length; col++) {  
	          assertEquals(   logic.tempStatus[row][col] , logic.nextStatus[row][col]);  
	         }  
	     }  
	}

}
