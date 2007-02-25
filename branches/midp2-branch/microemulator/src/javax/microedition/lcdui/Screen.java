/*
 *  MicroEmulator
 *  Copyright (C) 2001 Bartek Teodorczyk <barteo@it.pl>
 *
 *  This library is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public
 *  License as published by the Free Software Foundation; either
 *  version 2.1 of the License, or (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *  Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
 
package javax.microedition.lcdui;


public abstract class Screen extends Displayable
{

	Screen(String title)
	{
		super(title);
	}


	abstract int traverse(int gameKeyCode, int top, int bottom);


  void keyPressed(int keyCode)
	{
    int gameKeyCode = Display.getGameAction(keyCode);

    if (gameKeyCode == 1 || gameKeyCode == 6) {
			viewPortY += traverse(gameKeyCode, viewPortY, viewPortY + viewPortHeight);
			repaint();
    }
	}


	void keyRepeated(int keyCode)
	{
    keyPressed(keyCode);
	}

}