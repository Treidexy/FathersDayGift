package me.Treidex.FDay;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JRootPane;

import me.Treidex.Game.*;
import me.Treidex.Game.GameObject.*;
import me.Treidex.Game.GameObject.Components.*;
import me.Treidex.Game.GameObject.Components.Colliders.*;
import me.Treidex.Game.GameObject.Components.UI.*;
import me.Treidex.Game.GameObject.Components.UI.Events.*;
import me.Treidex.Game.Math.*;
import me.Treidex.Game.SuperClasses.*;

public class Main {
	private static final int width = (650+116);
	private static final int height = (650+116);
	
	private static GameManager gameManager;
	private static Boolean[] board;
	private static boolean xTurn;
	private static GameObject[] texts;
	
	public static void main(String[] args) {
		Scene game = new Scene() {
			public void init() {
				board = new Boolean[9];
				xTurn = false;
				
				texts = new GameObject[] {new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0)),new GameObject(new Transform(Vector2.zero,Vector2.zero,0))};
				
				noTranslateObjects = new GameObject[] {};
				staticObjects = new GameObject[] {
					// TopLeft
					new GameObject(
						new Transform(
							new Vector2(125, 125),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[0] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[0] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// Top
					new GameObject(
						new Transform(
							new Vector2(375, 125),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[1] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[1] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// TopRight
					new GameObject(
						new Transform(
							new Vector2(625, 125),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[2] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[2] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// Left
					new GameObject(
						new Transform(
							new Vector2(125, 375),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[3] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[3] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// Middle
					new GameObject(
						new Transform(
							new Vector2(375, 375),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[4] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[4] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// Right
					new GameObject(
						new Transform(
							new Vector2(625, 375),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[5] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[5] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// BottomLeft
					new GameObject(
						new Transform(
							new Vector2(125, 625),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[6] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[6] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// Bottom
					new GameObject(
						new Transform(
							new Vector2(375, 625),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[7] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[7] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					),
					// BottomRight
					new GameObject(
						new Transform(
							new Vector2(625, 625),
							new Vector2(250, 250),
							0
						),
						new Button(
							new Color(200, 200, 200),
							new Color(169, 169, 169),
							new Color(100, 100, 100),
							new ButtonEvent() {
								public void mouseOver(Button[] b) {}
								public void mousePressed(Button[] b) {}
								
								public void mouseReleased(Button[] b) {
									if (board[8] == null) {
										b[0].normalCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].overCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										b[0].pressedCol = (xTurn? new Color(255, 0, 0): new Color(0, 0, 255));
										
										board[8] = xTurn;
										
										xTurn = !xTurn;
										newRound();
									}
								}
							}
						)
					)
				};
				gameObjects = texts;
				
				super.init();
			}
			
			public void draw(Graphics g) {
				g.setColor(new Color(255, 255, 255));
				g.fillRect(0, 0, width, height);
				
				super.draw(g);
			}
			
			private void newRound() {
				Boolean win = checkBoard();
				if (win != null) {
					System.out.println((win? "Red": "Blue") + " Won the Match!");
					JFrame jf = new JFrame((win? "Red": "Blue") + " Won the Match!");
					jf.setUndecorated(true);
					jf.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
					jf.setResizable(false);
					jf.setSize(155, 30);
					jf.setLocationRelativeTo(null);
					jf.setAlwaysOnTop(true);
					jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf.setVisible(true);
					gameManager.changeScene(this);
					return; 
				}
				
				int completeSquares = 0;
				for (int i = 0; i < board.length; i++)
					if (board[i] != null)
						completeSquares++;
				if (completeSquares >= board.length) {
					System.out.println("Tie!");
					JFrame jf = new JFrame("Tie!");
					jf.setUndecorated(true);
					jf.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
					jf.setResizable(false);
					jf.setSize(55, 30);
					jf.setLocationRelativeTo(null);
					jf.setAlwaysOnTop(true);
					jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					jf.setVisible(true);
					gameManager.changeScene(this);
				}
			}
			
			private Boolean checkBoard() {
				// [0] 1  2
				//  3 [4] 5
				//  6  7 [8]
				
				if (board[0] != null) {
					if (board[1] == (board[0]))
						if (board[2] == (board[0]))
							return board[0];
					
					if (board[4] == (board[0]))
						if (board[8] == (board[0]))
							return board[0];
					
					if (board[3] == (board[0]))
						if (board[6] == (board[0]))
							return board[0];
				}
				
				if (board[4] != null) {
					if (board[1] == (board[4]))
						if (board[7] == (board[4]))
							return board[4];
					
					if (board[3] == (board[4]))
						if (board[5] == (board[4]))
							return board[4];
					
					if (board[2] == (board[4]))
						if (board[6] == (board[4]))
							return board[4];
				}
				
				if (board[8] != null) {
					if (board[2] == (board[8]))
						if (board[5] == (board[8]))
							return board[8];
					
					if (board[6] == (board[8]))
						if (board[7] == (board[8]))
							return board[8];
				}
				
				return null;
			}
		};
		
		gameManager = new GameManager(game);
		
		Program program = new Program(gameManager, "Fathers Day Gift! - Treidex", 1337, 60, width, height);
		program.start();
	}
}
