import java.util.*;
import java.lang.*;
import java.io.*;
class displayMatrix
{   
	char arrayy[][];
	int R;
	int C;
	int count;
	displayMatrix()
	{
		R=20;
		C=40;
		count=0;
	   arrayy=new char[R][C];
	   	for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
            if(i==0 || i==R-1 || j==0 || j==C-1)
            {
			
             arrayy[i][j]='*';
			 
            }
            else
            {
             arrayy[i][j]=' ';
            }
			}
		}
	}
	int checkx(createPoint p[],int i)
	{
		for(int k=0;k<4;k++)
		{
			if(p[k].x==i)
			{
				return 1;
			}
		}
		return 0;
		
	}
	int checky(createPoint p[],int j)
	{
	    for(int k=0;k<4;k++)
		{
		    if(p[k].y==j)
			{
			return 1;
			}
		}
		return 0;
		
	}
	int tempChange(createPoint p[],createPoint prev[])
	{
		   int flag= checkEnd(p,prev);
		   if(flag==1)
		   {
			   gameOver();
			   System.exit(0); 
			   return 99;
		   }
			for(int i=0;i<R;i++)
			{
				for(int j=0;j<C;j++)
				{
					if(prev[0].x!=0)
					{
					if(prev[0].x==i && prev[0].y==j || prev[1].x==i && prev[1].y==j || prev[2].x==i && prev[2].y==j || prev[3].x==i && prev[3].y==j)
                    {
						arrayy[i][j]=' ';
					}
					}
					if(p[0].x==i && p[0].y==j || p[1].x==i && p[1].y==j || p[2].x==i && p[2].y==j || p[3].x==i && p[3].y==j)
                    {
						arrayy[i][j]='#';
					}
				}
			}
		
	    checkingFull();
     	show();
		
		return 1;
	}
	int checkEnd(createPoint p[],createPoint prev[])
	{
	  
	  if(prev[0].x==0 && prev[0].y==0 && prev[1].x==0 && prev[1].y==0 && prev[2].x==0 && prev[2].y==0&&prev[3].x==0 && prev[3].y==0 )
	  {
         for(int i=0;i<4;i++)
		 {
			 if(arrayy[p[i].x][p[i].y]=='#')
			 {
				 System.out.println("Priya vats");
				 return 1;
			 }
		 }
	  }
    return 0;	  
	}
	void gameOver()
	{
	   	for(int i=0;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
            if(i==0 || i==R-1 || j==0 || j==C-1)
            {
			
             arrayy[i][j]='*';
			 
            }
            else
            {
             arrayy[i][j]=' ';
            }
			}
		}
		arrayy[10][11]='G';
		arrayy[10][12]='A';
		arrayy[10][13]='M';
		arrayy[10][14]='E';
		arrayy[12][11]='O';
		arrayy[12][12]='V';
		arrayy[12][13]='E';
		arrayy[12][14]='R';
		arrayy[12][15]='!';
		show();
	}
	void checkingFull()
	{
		int c=0;
		for(int i=0;i<R;i++)
		{
			c=0;
			for(int j=0;j<C;j++)
			{
				if(arrayy[i][j]=='#')
				{
					c=c+1;
				}
			}
			if(c==C-2)
			{
				count++;
				for(int k=1;k<C-1;k++)
				{
					arrayy[i][k]=' ';
				}
				for(int k=i;k>=0;k--)
				{
					for(int l=0;l<C;l++)
					{
					if(arrayy[k][l]=='#')
					{
						arrayy[k][l]=' ';
						arrayy[k+1][l]='#';
					}
					}
				}
				
			}
			
		}
	}
	void show()
	{
		
       System.out.println();System.out.println();System.out.println();System.out.println();
	   System.out.println();System.out.println();System.out.println();System.out.println();
	   System.out.println();System.out.println();System.out.println();System.out.println();
	   System.out.println();System.out.println();System.out.println();System.out.println();
	   System.out.println();System.out.println();System.out.println();System.out.println();
	   System.out.println();System.out.println();System.out.println();System.out.println();
	   System.out.println();System.out.println();System.out.println();System.out.println();
		for(int i=0; i<R; i++)
		{
			for(int j=0; j<C; j++)
			{
				System.out.print(arrayy[i][j]);
			}
			System.out.println();
		}
		System.out.println("Score : "+count);
	
	}
	
}

class createPoint
{
public int x;
public int y;
    createPoint()
	{
    x=0;
	y=0;
	}
    void setPoint(int x, int y)
	{
		this.x=x;
		this.y=y;
	}
    int getX()
	{
		return x;
	}		
	int getY()
	{
		return y;
	}
	
}
enum Ranshape {
 
  ZShape(new int[][] { { 1, 13 }, { 1, 14 }, { 2, 14 }, { 2, 15 } }),
  LineShape(new int[][] { { 1, 13 }, { 1, 14 }, { 1, 15 }, { 1, 16 } }),
  TShape(new int[][] { { 1, 13 }, { 1, 14 }, { 1, 15 }, { 2, 14 } }),
  SquareShape(new int[][] { { 1, 13 }, { 1, 14 }, { 2, 13 }, { 2, 14 } }),
  LShape(new int[][] { { 1, 13 }, { 2, 13 }, { 3, 13 }, { 3, 14 } }),
  MirroredLShape(new int[][] { { 1, 13 }, { 2, 13 }, { 3, 13 }, { 3, 12 } });
 
  public int[][] coords;
 
 
  private Ranshape(int[][] coords) {
    this.coords = coords;    
  }
}
class shapeOfObjects
{
createPoint p[];
createPoint prev[];
public int position;
	shapeOfObjects()
	{
		p=new createPoint[4];
		for(int i=0;i<4;i++)
			p[i]=new createPoint();
		
		prev=new createPoint[4];
		for(int i=0;i<4;i++)
			prev[i]=new createPoint();
	}
	
	int set(displayMatrix d)
	{
		Ranshape allshapes[] = Ranshape.values(); 
	    Random rand = new Random();
		rotation r=new rotation();
		r.position=0;
		int  n = rand.nextInt(3) + 0;
		r.currentshape=allshapes[n].toString();
		create(allshapes[n],d);	
	    int c=play(d,r);
	    return c;
	}
	void create(Ranshape ab,displayMatrix d)
	{
		p[0].setPoint(ab.coords[0][0],ab.coords[0][1]);
		p[1].setPoint(ab.coords[1][0],ab.coords[1][1]);
		p[2].setPoint(ab.coords[2][0],ab.coords[2][1]);
		p[3].setPoint(ab.coords[3][0],ab.coords[3][1]);
		prev[0].setPoint(0,0);
		prev[1].setPoint(0,0);
		prev[2].setPoint(0,0);
		prev[3].setPoint(0,0);	

	    d.tempChange(p,prev);			

	}
	int play(displayMatrix d,rotation r)
	{
		Working w=new Working();
		int a=w.work(d,p,prev,r);
		return a;
	}
}
class Working
{ 
char ch;
 	int work(displayMatrix d,createPoint p[],createPoint prev[],rotation r)
 	{
	 Scanner ss=new Scanner(System.in);
	 Movement m=new Movement();
	 int a=1;
	 int kisme=1;
	  ch=ss.next().charAt(0);
	 while(a==1)
	 {
     if(ch=='a')
 	 {
 	 	a=m.left(p,prev,d);

	 }
 	 else if(ch=='d')
 	 {
 	 	a=m.right(p,prev,d);
 	 }
	 else if(ch=='s')
	 {
	 	a=m.down(p,prev,d); 
	 }
	 else if(ch=='r')
	 {
		a=m.rotate(p,prev,d,r); 
		 
	 }
	 else if(ch=='u')
	 {
		 
	 }
	 ch=ss.next().charAt(0);
     }
	 return a;
	}		
}
class Movement
{
int l;
    Movement()
	{
		l=0;
		
	}
	int left(createPoint p[],createPoint prev[],displayMatrix d)
	{	
		int a=0;
		int flag=0;
	    int rflag=0;
		if(l==0)
		{
		for(int i=0;i<4;i++)
		{
			a=p[i].y-1;
			if(a<1)
			{
			flag=1;
			}
			
		}
		}
		for(int i=0;i<4;i++)
	    {
			prev[i].x=p[i].x;
			prev[i].y=p[i].y;
			p[i].y=p[i].y-1;			
	    }

		if(flag==0)
		{
			int ii=0;
			int jj=0;
		
         for(int i=0;i<4;i++)
		 {
			 rflag=0;
			 ii=p[i].x;
			 jj=p[i].y;
			 for(int j=0;j<4;j++)
			 {
				 if(ii==prev[j].x && jj==prev[j].y)
				 {
					rflag=1; 
					
				 }
				 
			 }
			 if(rflag==0 && ii>0 && jj>0)
			 {
				 if(d.arrayy[ii][jj]=='#')
				 {
				 flag=1;
				 }
			 }

			 
		 }
		  
		}
          
        if(flag==1)
		{
		for(int i=0;i<4;i++)
	    {
			p[i].y=p[i].y+1;
	    	prev[i].x=p[i].x;
			prev[i].y=p[i].y;
					
	    }
		a=d.tempChange(p,prev);		

		}
		else if(flag==0)
		{
			a=d.tempChange(p,prev);		

		}
	    
		return 1;

	}
	int right(createPoint p[],createPoint prev[],displayMatrix d)
	{
        int a=0;
		int flag=0;
		int rflag=0;
		for(int i=0;i<4;i++)
		{
			a=p[i].y+1;
			if(a>38)
			{
			flag=1;
			}
			
		}
		
		for(int i=0;i<4;i++)
		{
			prev[i].x=p[i].x;
			prev[i].y=p[i].y;
			p[i].y=p[i].y+1;			
		}
		if(flag==0)
		{
			int ii=0;
			int jj=0;
		
         for(int i=0;i<4;i++)
		 {
			 rflag=0;
			 ii=p[i].x;
			 jj=p[i].y;
			 for(int j=0;j<4;j++)
			 {
				 if(ii==prev[j].x && jj==prev[j].y)
				 {
					rflag=1; 
					
				 }
				 
			 }
			 if(rflag==0 && ii>0 && jj>0)
			 {
				 if(d.arrayy[ii][jj]=='#')
				 {
				 flag=1;
				 }
			 }

			 
		 }
		  
		}
        
        if(flag==1)
		{
		for(int i=0;i<4;i++)
	    {
			p[i].y=p[i].y-1;
	    	prev[i].x=p[i].x;
			prev[i].y=p[i].y;
					
	    }
		a=d.tempChange(p,prev);	
		
		}
		else if(flag==0)
		{
		a=d.tempChange(p,prev);

		}
	
		return 1;
	}
	int down(createPoint p[],createPoint prev[],displayMatrix d)
	{
        int a=0;
		int flag=0;
		int rflag=0;
		for(int i=0;i<4;i++)
		{
			a=p[i].x+1;
			if(a>18)
			{
			flag=1;
			return 0;
			}
			
		}
		for(int i=0;i<4;i++)
		{
			prev[i].x=p[i].x;
			prev[i].y=p[i].y;
			p[i].x=p[i].x+1;			
		}
		if(flag==0)
		{
			int ii=0;
			int jj=0;
		
         for(int i=0;i<4;i++)
		 {
			 rflag=0;
			 ii=p[i].x;
			 jj=p[i].y;
			 for(int j=0;j<4;j++)
			 {
				 if(ii==prev[j].x && jj==prev[j].y)
				 {
					rflag=1; 
					
				 }
				 
			 }
			 if(rflag==0 && ii>0 && jj>0)
			 {
				 if(d.arrayy[ii][jj]=='#')
				 {
				 flag=1;
				 }
			 }

			 
		 }
		  
		}
        
        if(flag==1)
		{
		for(int i=0;i<4;i++)
	    {
			p[i].x=p[i].x-1;
	    	prev[i].x=p[i].x;
			prev[i].y=p[i].y;
					
	    }
		a=d.tempChange(p,prev);	

        return 0;		
		}
		if(flag==0)
		{
		a=d.tempChange(p,prev);

		}
        
	return a;	
	}
	int rotate(createPoint p[],createPoint prev[],displayMatrix d,rotation r)
	{
		int a=r.rotateShape(p,prev,d);
		return a;
	}

	
}
enum rot
{
  LineShape(new int[][] { {0,0,1,-1,2,-2,3,-3},{0,0,-1,-1,-2,-2,-3,-3},{0,0,-1,1,-2,2,-3,3},{0,0,1,1,2,2,3,3} }),
  ZShape(new int[][] { { 0,1,1,1,0,0,1,0 }, { 2,-1,0,0,0,0,0,-1 }, {-2,1,0,0,0,0,0,1}, {0,-1,-1,-1,0,0,-1,0 } }),
  TShape(new int[][] { { -1,1,0,0,1,-1,-1,-1 }, {1,1,0,0,-1,-1,-1,1}, {1,-1,0,0,-1,1,1,1}, { -1,-1,0,0,1,1,1,-1 } }),
  SquareShape(new int[][] { { 0,0,0,0,0,0,0,0}, { 0,0,0,0,0,0,0,0}, { 0,0,0,0,0,0,0,0}, { 0,0,0,0,0,0,0,0}}),
  LShape(new int[][] { { 1,1,0,0,-1,-1,0,-2 }, {1,-1,0,0,-1,1,-2,0 }, {0,-1,1,0,2,1,1,2 }, {-2,2,-1,1,0,0,1,1} }),
  MirroredLShape(new int[][] { {2,1,1,0,0,-1,-1,0 }, {0,-1,-1,0,-2,1,-1,2 }, {-1,-1,0,0,1,1,2,0 }, { -1,1,0,0,1,-1,0,-2 } });
  public int[][] rotcoords;
  private rot(int[][] rotcoords)
  {
   this.rotcoords = rotcoords; 
  }
}
class rotation
{
	int position;
	String currentshape;
	int temp[][]=new int[4][2];
	
	int rotateShape(createPoint p[],createPoint prev[],displayMatrix d)
	{
		int flag=0;
		int k=0;
		int a=0;
		rot c=rot.valueOf(currentshape);
		for(int i=0;i<4;i++)
		{
			
			temp[i][k++]=prev[i].x;
			temp[i][k++]=prev[i].y;
			k=0;
			prev[i].x=p[i].x;
			prev[i].y=p[i].y;
		
		}
		k=0;
		int l=0;

		for(int i=0;i<4;i++)
		{
			p[i].x=p[i].x+c.rotcoords[position][k++];
			p[i].y=p[i].y+c.rotcoords[position][k++];
			
     	}
		
	    for(int i=0;i<4;i++)
		{
           if(p[i].x>0 && p[i].x<d.R-2 && p[i].y>0 && p[i].y<d.C-2)
		   {
			   if(d.arrayy[p[i].x][p[i].y]!=' ')
			   {
			   if(checkR(prev,p[i].x,p[i].y)==1)
			   {
				   flag=1;
			  
			   }	
			   }			   
		   }
		   else if(p[i].x<1)
		   {
			flag=1;
		   }
		}
		
        if(flag==1)
		{
			k=0;
         for(int i=0;i<4;i++)
		 {
			 p[i].x=prev[i].x;
			 p[i].y=prev[i].y;
			 prev[i].x=temp[i][k++];
			 prev[i].y=temp[i][k++];
			 k=0;
		 }
		 a=d.tempChange(p,prev);
		}
        else if(flag==0)
		{
		position=position+1;
		if(position==4)
		{
			position=0;
		}
        a=d.tempChange(p,prev);
					if(a==99)
			{
				return 99;
			}
		}	
		return a;
	}		
		int checkR(createPoint prev[],int x,int y)
		{
			for(int i=0;i<4;i++)
			{
				if(prev[i].x==x && prev[i].y==y)
				{
					return 0;
				}
			}
			return 1;
		}
	    
	}
	

class game1
{   
	public static void main(String args[])
	{	
	displayMatrix d=new displayMatrix();
	int a=0;
	while(a==0)
	{
		System.out.println("value of a is "+a);
	    shapeOfObjects s=new shapeOfObjects();
	    a=s.set(d);
	
    }
	}
}     