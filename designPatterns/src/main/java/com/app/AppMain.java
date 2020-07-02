package com.app;

import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class AppMain 
{
	private static Logger log = Logger.getLogger(AppMain.class.getName());
    public static void main(final String[] args )
    {
    	int octal = 011;
    	int hexa = 0x001100;
    	int x, y, z;
    	x = 42;
    	y = x++;
    	z = ++x;
        log.info( "Hello World!" );
        System.out.println(y);
        System.out.println(z);
    }
}
