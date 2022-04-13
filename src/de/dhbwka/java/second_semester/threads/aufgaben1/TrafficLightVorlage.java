package de.dhbwka.java.second_semester.threads.aufgaben1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

@SuppressWarnings("all")
public class TrafficLightVorlage extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 405633757260635657L;
	private final static long DELAY = 500;


	   public TrafficLightVorlage() {
	   }

	   @Override
	   public void paintComponent( Graphics g ) {
	      super.paintComponent( g );

	      // traffic light box
	      g.setColor( Color.BLACK );
	      g.fillRect( 10, 10, 80, 195 );

	      // 3 x empty light
	      g.setColor( Color.WHITE );
	      g.fillOval( 23, 23, 54, 54 );
	      g.fillOval( 23, 83, 54, 54 );
	      g.fillOval( 23, 143, 54, 54 );

	      /* ====================================================
	       * ====================================================
	       * SET THE CORRECT VALUES FOR THE FOLLOWING 3 VARIABLES
	       * ====================================================
	       * ==================================================== */
	      boolean redOn = true;
	      boolean yellowOn = true;
	      boolean greenOn = true;
	      
	      // draw colored lights, if active
	      if ( redOn ) {
	         g.setColor( Color.RED );
	         g.fillOval( 25, 25, 50, 50 );
	      }
	      
	      if ( yellowOn ) {
	         g.setColor( Color.YELLOW );
	         g.fillOval( 25, 85, 50, 50 );
	      }
	      if ( greenOn ) {
	         g.setColor( Color.GREEN );
	         g.fillOval( 25, 145, 50, 50 );
	      }
	   }

	   public static void main( String[] args ) {
	      // Create frame and add TrafficLight component
	      JFrame f = new JFrame( "Traffic Light" );
	      f.add( new TrafficLightVorlage() );
	      f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	      f.setSize( 100, 260 );
	      f.setVisible( true );
	   }
}
