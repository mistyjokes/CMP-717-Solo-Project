package game;

public class Camera
{
	
	public static int x = 0;
	public static int y = 0;
	
	
	public static void goLT(int dx)
	{
		x -= dx;
	}

	public static void goRT(int dx)
	{
		x += dx;
	}
	
	public static void goUP(int dy)
	{
		y -= dy;
	}

	public static void goDN(int dy)
	{
		y += dy;
	}

	

}
